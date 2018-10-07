package com.api.service;

import com.alibaba.fastjson.JSONObject;
import com.api.MEnumError;
import com.api.view.pay.PayResult;
import com.base.api.ApiException;
import com.base.api.MobileInfo;
import com.base.pay.PayMethod;
import com.base.pay.ali.AlipayConfig;
import com.base.util.StringUtil;
import com.item.dao.model.PayLog;
import com.item.dao.model.ShopCart;
import com.item.dao.model.ShopCartExample;
import com.item.service.PayLogService;
import com.item.service.ShopCartService;
import com.paidang.dao.model.*;
import com.paidang.service.GoodsService;
import com.paidang.service.OrderService;
import com.paidang.service.UserAddressService;
import com.paidang.service.UserCouponService;
import com.util.MPaidangPayType;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @Auther: xuwenwei
 * @Date: 2018/7/31 08:39
 * @Description:
 */
@Service
public class ApiUserPayService {

    @Autowired
    private PayLogService payLogService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private UserCouponService userCouponService;

    @Autowired
    private ShopCartService shopCartService;

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public List<PayResult> createShopCartOrder(MobileInfo mobileInfo, String data, Integer addressId){
        List<Map> mapList =JSONObject.parseArray(data, Map.class);
        long code = System.currentTimeMillis();

        UserAddress userAddress = userAddressService.selectByPrimaryKey(addressId);
        if(null == userAddress){
            throw new ApiException(MEnumError.ADDRESS_NOT_EXIST);
        }
        List<PayResult> results=new ArrayList<>();
        Date date=new Date();
        int i=0;
        for (Map map:mapList){
            PayResult payResult = new PayResult();
            Integer goodsId=Integer.valueOf((String)map.get("goodsId"));
            String str =(String)map.get("couponId");
            Integer couponId=null;
            if(StringUtil.isNotBlank(str)){
                couponId=Integer.valueOf(str);
            }

            GoodsExample goodsExample = new GoodsExample();
            goodsExample.createCriteria().andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andTotalGreaterThanOrEqualTo(1).andIdEqualTo(goodsId);//.andStateEqualTo(1);
            List<Goods> list = goodsService.selectByExample(goodsExample);
            if(null == list || list.size() ==0) {
                throw new ApiException(MEnumError.GOODS_NOT_EXIST);

            }
            Goods goods = list.get(0);
            UserCoupon userCoupon = null;
            //用户使用优惠券
            if(null != couponId){
                UserCouponExample userCouponExample = new UserCouponExample();
                userCouponExample.createCriteria().andEndTimeGreaterThanOrEqualTo(new Date()).andIdEqualTo(couponId).andStateEqualTo(1);
                List<UserCoupon> userCouponList = userCouponService.selectByExample(userCouponExample);
                if(null == userCouponList || list.size() ==0){
                    throw new ApiException(MEnumError.COUPON_TYPE_EXIST);
                }
                userCoupon = userCouponList.get(0);
            }
            Order order = new Order();

            //订单号生成规则：时间戳加商品编号
            order.setCode((code+i) + goodsId.toString());
            order.setUserId(mobileInfo.getUserid());
            order.setGoodsId(goods.getId());
            order.setGoodsName(goods.getName());
            order.setGoodsImg(goods.getImg());
            order.setGoodsSource(goods.getSource());
            order.setOrgId(goods.getOrgId());
            order.setGoodsPrice(goods.getPrice());
            order.setGoodsCost(goods.getCost());
            order.setCommentState(0);
            order.setCreateTime(date);
            BigDecimal finalPrice = null;
            i++;
            if(null == userCoupon){
                //没有优惠券
                finalPrice = goods.getPrice();
            }else{
                finalPrice = goods.getPrice().subtract(userCoupon.getFull());
            }
            order.setPrice(finalPrice);
            order.setState(1);
            order.setIsBalance(0);
            order.setShipUser(userAddress.getUserName());
            order.setShipPhone(userAddress.getPhone());
            order.setShipAddress(userAddress.getArea()+userAddress.getAddress());
            order.setRefState(0);
            if(null != userCoupon){
                order.setCouponValue(userCoupon.getFull());
            }
            order.setCouponId(couponId);
            order.setIsDel(0);
            int result = orderService.insert(order);
            if(0 == result){
                throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
            }

            //商品数量-1
            goods.setTotal(goods.getTotal() - 1);
            goods.setSoldOut(goods.getSoldOut() + 1);
            int reuslt2 = goodsService.updateByPrimaryKeySelective(goods);

            if(0 == reuslt2){
                throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
            }

            //优惠券不可用
            if(null != userCoupon){
                userCoupon.setState(0);
                int result3 = userCouponService.updateByPrimaryKeySelective(userCoupon);
                if(0 == result3){
                    throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
                }
            }

            payResult.setId(order.getId().toString());
            results.add(payResult);
            ShopCartExample example=new ShopCartExample();
            example.createCriteria().andGoodsIdEqualTo(goodsId).andUserIdEqualTo(mobileInfo.getUserid());
            List<ShopCart> shopCarts=shopCartService.selectByExample(example);
            if (shopCarts==null || shopCarts.size()==0){
                throw new ApiException(-1,"购物车商品不存在");
            }
            ShopCart cart=shopCarts.get(0);
            if(cart.getNum()==1){
                shopCartService.deleteByPrimaryKey(shopCarts.get(0).getId());
            }else if (cart.getNum()>1){
                cart.setNum(cart.getNum()-1);
                shopCartService.updateByPrimaryKeySelective(cart);
            }

        }
        return results;
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public PayResult buyShopCartPay(MobileInfo mobileInfo, Integer platform, String orderIds){
        String logIds="";
        List<PayLog> logList=new ArrayList<>();
        BigDecimal price=new BigDecimal(0);
        String[] orderArray=orderIds.split(",");
        for (String id:orderArray){
            Integer orderId=Integer.valueOf(id);
            Order order = orderService.selectByPrimaryKey(orderId);
            if (order == null){
                throw new ApiException(MEnumError.WM_ORDER_NOTEXISTS);
            }
            order.setPayType(platform);
            orderService.updateByPrimaryKeySelective(order);
            PayLog log = new PayLog();
            log.setOrderId(order.getId());
            log.setUserId(mobileInfo.getUserid());
            log.setState(0);
            log.setMoney(order.getPrice());
            log.setParam(MPaidangPayType.NORMAL_BUY.name());
            payLogService.insertSelective(log);
            price=price.add(order.getPrice());
            logList.add(log);
            logIds+=log.getId()+"-";

        }
        boolean flag=logIds.charAt(logIds.length()-1)=='-';
        if (flag){
            logIds=logIds.substring(0,logIds.length()-1);
        }
        PayResult result = new PayResult();
        result.setPlatform(platform);
        switch (platform) {
            case 1:
                //支付宝
                result.setId(logIds+"_"+ MPaidangPayType.NORMAL_BUY.name());
                result.setMoney(price.toString());
                result.setBackUrl(PayMethod.urlToUrl(AlipayConfig.notify_url));
                break;
            case 2:
                //微信
                String wxId = PayMethod.wxPrepayId(price, logIds, "订单支付",MPaidangPayType.NORMAL_BUY);
                if (StringUtil.isBlank(wxId)){
                    throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
                }
                result.setId(wxId);
                break;
            default:
                throw new ApiException(MEnumError.PAY_TYPE_ERRPR);
        }


        return result;

    }
}
