//package com.api.action;
//
//
//import com.api.MEnumError;
//import com.api.view.home.UserInfo;
//import com.base.action.CoreController;
//import com.base.api.ApiBaseController;
//import com.base.api.ApiException;
//import com.base.api.MobileInfo;
//import com.base.api.annotation.ApiMethod;
//import com.base.dialect.PaginationSupport;
//import com.base.util.JSONUtils;
//import com.item.dao.model.ShopCart;
//import com.item.dao.model.ShopCartExample;
//import com.item.dao.model.User;
//import com.item.service.ShopCartService;
//import com.paidang.dao.model.Goods;
//import com.paidang.service.GoodsService;
//import com.redis.JedisTemplate;
//import com.redis.RedisKeyUtils;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/userShopCart", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
//@Api(tags = "用户购物车(用户端)")
//public class ApiUserShopCartController extends ApiBaseController {
//
//
//    private static final Logger logger = Logger.getLogger(ApiUserShopCartController.class);
//
//    @Autowired
//    private JedisTemplate jedisTemplate;
//
//    @Autowired
//    private ShopCartService shopCartService;
//
//    @Autowired
//    private GoodsService goodsService;
//
///*    @RequestMapping("/list")
//    @ResponseBody
//    public String list(Integer page, Integer rows){
//        PaginationSupport.byPage(page, rows);
//        ShopCartExample example = new ShopCartExample();
//
//        List<ShopCart> list = shopCartService.selectByExample(example);
//        return page(list);
//    }
//
//    @RequestMapping("/save")
//    @ResponseBody
//    public String save(ShopCart shopCart){
//        if (shopCart.getId() == null){
//            shopCartService.insert(shopCart);
//        }else{
//            shopCartService.updateByPrimaryKeySelective(shopCart);
//        }
//        return ok();
//    }
//
//    @RequestMapping("/findById")
//    @ResponseBody
//    public String find(Integer id){
//        ShopCart shopCart = shopCartService.selectByPrimaryKey(id);
//        return ok(shopCart);
//    }
//
//    @RequestMapping("/del")
//    @ResponseBody
//    public String del(String id){
//        String[] ids = id.split(",");
//        for (String str : ids){
//            shopCartService.deleteByPrimaryKey(Integer.parseInt(str));
//        }
//        return ok();
//    }*/
//
//
//    @ApiOperation(value = "修改购物车商品数量", notes = "登陆")
//    @RequestMapping(value = "/updateCart", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Object updateCart(MobileInfo mobileInfo,@ApiParam(value = "商品id", required = true)Integer goodsId,@ApiParam(value = "商品数量", required = true)Integer num) {
//        if (num<=0){
//            throw new ApiException(-1,"数量不能小于0");
//        }
//        ShopCartExample entity=new ShopCartExample();
//        ShopCartExample.Criteria criteria=entity.createCriteria();
//        criteria.andUserIdEqualTo(mobileInfo.getUserid());
//        criteria.andGoodsIdEqualTo(goodsId);
//        List<ShopCart> list=shopCartService.selectByExample(entity);
//        Goods goods=goodsService.selectByPrimaryId(goodsId);
//        if (goods==null){
//            throw new ApiException(-1,"该商品不存在！");
//        }
//        if(goods.getIsOnline()==0){
//            throw new ApiException(-1,"该商品已经下架！");
//        }
//        if (list!=null && list.size()>0){
//
//            //购物车有商品修改
//            ShopCart shopCart=list.get(0);
//
////            Integer currentNum=shopCart.getNum();
////            if (num>0 &&(currentNum+num)>goods.getTotal()){
////                throw new ApiException(-1,"该商品库存不足！");
////            }else if (num<0 && Math.abs(num)>currentNum){
////                throw new ApiException(-1,"购物车中没有足够商品！");
////            }
//
//            if (num>goods.getTotal()){
//                throw new ApiException(-1,"该商品库存不足！");
//            }
//            shopCart.setNum(num);
//            if (shopCart.getNum()==0){
//               return shopCartService.deleteByPrimaryKey(shopCart.getId());
//            }else {
//                return shopCartService.updateByPrimaryKeySelective(shopCart);
//            }
//        }else {
//            if (num>goods.getTotal()){
//                throw new ApiException(-1,"库存不足");
//            }
//            if (num==0){
//                throw new ApiException(-1,"不能添加0数量商品");
//            }
//            //购物车没有商品新增
//            ShopCart shopCart=new ShopCart();
//            shopCart.setGoodsId(goodsId);
//            shopCart.setNum(num);
//            shopCart.setCreateTime(new Date());
//            shopCart.setUserId(mobileInfo.getUserid());
//            shopCart.setOrgId(goods.getOrgId());
//            return shopCartService.insert(shopCart);
//        }
//    }
//
//
//    @ApiOperation(value = "删除购物车商品", notes = "登陆")
//    @RequestMapping(value = "/delGoods", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Object delGoods(MobileInfo mobileInfo,@ApiParam(value = "商品id", required = true)Integer goodsId) {
//        ShopCartExample entity=new ShopCartExample();
//        ShopCartExample.Criteria criteria=entity.createCriteria();
//        criteria.andUserIdEqualTo(mobileInfo.getUserid());
//        criteria.andGoodsIdEqualTo(goodsId);
//        return shopCartService.deleteByExample(entity);
//    }
//
//
//    @ApiOperation(value = "购物车商品列表", notes = "登陆")
//    @RequestMapping(value = "/list", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Object list( @ApiParam(value = "用户id", required = true)Integer userId) {
//        return shopCartService.findList(userId);
//    }
//
//
//
//    @ApiOperation(value = "清空购物车商品", notes = "登陆")
//    @RequestMapping(value = "/delAll", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Object delAll(MobileInfo mobileInfo) {
//        ShopCartExample entity=new ShopCartExample();
//        ShopCartExample.Criteria criteria=entity.createCriteria();
//        criteria.andUserIdEqualTo(mobileInfo.getUserid());
//        return shopCartService.deleteByExample(entity);
//    }
//
//
//
//}
