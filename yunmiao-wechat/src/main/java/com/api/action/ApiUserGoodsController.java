//package com.api.action;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.api.MErrorEnum;
//import com.api.MPawnMsg;
//import com.api.MPostExpressAddress;
//import com.api.util.PageLimit;
//import com.api.view.indexInfo.ApiIndexHotMenu;
//import com.api.view.indexInfo.ApiIndexMenu;
//import com.api.view.indexInfo.IndexInfo;
//import com.api.view.myGoods.AppLogisticsDetail;
//import com.api.view.myGoods.AppMyGoods;
//import com.api.view.store.AppStoreBanner;
//import com.api.view.user.AppBXAddress;
//import com.base.api.ApiBaseController;
//import com.base.api.ApiException;
//import com.base.api.MobileInfo;
//import com.base.api.annotation.ApiMethod;
//import com.base.dao.model.Ret;
//import com.base.dialect.PaginationSupport;
//import com.base.util.BeanUtils;
//import com.base.util.DateUtil;
//import com.base.util.StringUtil;
//import com.item.dao.model.*;
//import com.item.daoEx.model.AdEx;
//import com.item.service.AdService;
//import com.item.service.CodeService;
//import com.item.service.FocusService;
//import com.item.service.UserService;
//import com.paidang.dao.model.*;
//import com.paidang.daoEx.model.ExpressEx;
//import com.paidang.daoEx.model.GoodsEx;
//import com.paidang.daoEx.model.PawnOrgEx;
//import com.paidang.daoEx.model.UserGoodsEx;
//import com.paidang.service.*;
//import com.sun.prism.impl.Disposer;
//import com.util.PaidangConst;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.math.BigDecimal;
//import java.text.DecimalFormat;
//import java.util.*;
//
//@RestController
//@RequestMapping(value = "/api/userGoods", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
//@Api(tags = "用户藏品(用户端)")
//public class ApiUserGoodsController extends ApiBaseController {
//
//    @Autowired
//    private UserGoodsService userGoodsService;
//    @Autowired
//    private PawnCateService pawnCateService;
//    @Autowired
//    private UserAddressService userAddressService;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private DiamondService diamondService;
//    @Autowired
//    private CodeService codeService;
//    @Autowired
//    private UserBankCardService userBankCardService;
//    @Autowired
//    private PlatformGoodsBuyService platformGoodsBuyService;
//    @Autowired
//    private ExpressService expressService;
//    @Autowired
//    private FocusService focusService;
//    @Autowired
//    private GoodsService goodsService;
//    @Autowired
//    private GoodsAuctionService goodsAuctionService;
//    @Autowired
//    private UserBalanceLogService userBalanceLogService;
//    @Autowired
//    private AdService adService;
//
//    @Autowired
//    private PawnOrgService pawnOrgService;
//
//    @Autowired
//    private VideoOnlineService videoOnlineService;
//
//    public enum MGoodsCateList {
//        SCPZB("1","奢侈品珠宝"),
//        sb("2","手表"),
//        zs("3","钻石"),
//        gjs("4","贵金属"),
//        fcys("5","翡翠玉石"),
//        hty("6","和田玉"),
//        qt("7","其他"),
//        csbs("8","彩色宝石");
//        private String code;
//        private String name;
//        private MGoodsCateList(String code,String name) {
//            this.code = code;
//            this.name = name;
//        }
//    }
//
//    /**
//     * 首页轮播图加拍档头条
//     */
//    @ApiOperation(value = "首页轮播图(用户端)", notes = "")
//    @RequestMapping("/indexBanner")
//    @ApiMethod()
//    public List<IndexInfo> indexBanner(MobileInfo mobileInfo){
//        List<IndexInfo> ret = new ArrayList<IndexInfo>();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("location",1);
//        List<AdEx> list = adService.selectRzList(map);
//        for(AdEx ex : list){
//            IndexInfo record = new IndexInfo();
//            record.setId(ex.getId());
//            record.setIndex_images(ex.getImg());
//            record.setType(ex.getType());
//            if(0 == ex.getType()){
//                record.setContent(ex.getContent());
//            }else if(1 == ex.getType()){
//                record.setContent(ex.getContent());
//            }else if(2 == ex.getType()){
//                record.setContent(getPage(ex.getId(),10));
//            }else if(3 == ex.getType()){
//                record.setContent(ex.getContent());
//            }else if(4 == ex.getType()){
//                record.setContent(ex.getContent());
//            }else if(5 == ex.getType()){
//                record.setContent(ex.getContent());
//            }
//            if(4 == ex.getType()){
//                //如果是绝当商品的商品
//                if(null == ex.getGoodsId()){
//                    //如果是后台上传的,则不区分30000
//                    record.setCstate(2);
//                }else{
//                    if(new BigDecimal(ex.getCost()).compareTo(new BigDecimal(30000) )== -1){
//                        //走流程小于三万则是普通商品
//                        record.setCstate(2);
//                    }else{
//                        record.setCstate(1);
//                    }
//                }
//            }
//            record.setState(1);
//            ret.add(record);
//        }
//
//        Map<String, Object> map2 = new HashMap<String, Object>();
//        map2.put("location",4);
//        List<AdEx> list2 = adService.selectRzList(map2);
//        for(Ad ex : list2){
//            IndexInfo c = new IndexInfo();
//            c.setId(ex.getId());
//            c.setPawnMsg(ex.getDiscription());
//            c.setState(2);
//            ret.add(c);
//        }
//        return ret;
//    }
//
//    /**
//     * 去鉴宝--在线鉴定
//     */
//    @ApiOperation(value = "去鉴宝--在线鉴定(用户端)", notes = "登陆")
//    @RequestMapping("/gotoAuthGood")
//    @ApiMethod(isLogin = true)
//    public Ret gotoAuthGood(MobileInfo mobileInfo,
//                            @ApiParam(value="图片",required = true) String images,
//                            @ApiParam(value="宝贝视频",required = false) String video,
//                            @ApiParam(value="内容[{'name':'品牌','content':'卡地亚','contentType':'1'},{'name':'主题材质','content':'宇宙大金刚','contentType':'1'}]---contentType:1普通2时间3图片4视频'",required = true) String content,
//                            //[{"name":"品牌","content":"卡地亚","contentType":"1"},{"name":"主题材质","content":"宇宙大金刚","contentType":"1"},{"name":"镶石材质","content":"超级大钻石","contentType":"1"},{"name":"使用情况","content":"使用情况良好","contentType":"1"},{"name":"附件","content":"保卡,证书","contentType":"1"},{"name":"购买价格","content":"9899","contentType":"1"},{"name":"购买时间","content":"2013-05-09","contentType":"1"}]
//                            @ApiParam(value="购买价格",required = false) String price,
//                            @ApiParam(value="类型code",required = true) Integer code,
//                            @ApiParam(value="购买时间",required = false) String buyTime,
//                            @ApiParam(value="鉴定要求",required = false) String authenticateRequire,
//                            @ApiParam(value="附件照",required = false) String goodsImgs,
//                            @ApiParam(value="描述",required = false) String info){
//        //JSONObject jsonObject = JSON.parseObject(content);
//        //JSONArray array = jsonObject.getJSONArray("json");
//        //String name = "";
//
//        Ret ret = new Ret();
//        PawnCateExample example = new PawnCateExample();
//
//        example.createCriteria().andCodeEqualTo(code+"");
//        List<PawnCate> list = pawnCateService.selectByExample(example);
//        PawnCate pawnCate = list.get(0);
//
//        UserGoods userGoods = new UserGoods();
//        //如果是钻石或者贵金属，不形成订单--并且除去类别为其他
//        if(!MGoodsCateList.zs.code.equals(pawnCate.getCode()) && !MGoodsCateList.gjs.code.equals(pawnCate.getCode()) && !MGoodsCateList.qt.code.equals(pawnCate.getCode())
//                && !MGoodsCateList.fcys.equals(pawnCate.getCode())){
//                //JSONObject jsonObj = (JSONObject)object;
//                //userGoods.setBuyPrice(new BigDecimal(jsonObj.get("buyPrice")+""));
//                //userGoods.setImages(jsonObj.get("image")+"");
//                if(StringUtil.isNotBlank(price)){
//                    userGoods.setBuyPrice(new BigDecimal(price));
//                }
//                userGoods.setImages(images);
//                userGoods.setContent(content);
//                userGoods.setUserId(mobileInfo.getUserid());
//                userGoods.setBelongId(mobileInfo.getUserid());
//                userGoods.setBelongType(1);
//                userGoods.setLocation(0);
//                if(StringUtil.isNotBlank(buyTime)){
//                    userGoods.setBuyTime(DateUtil.strToDate(buyTime));
//                }
//
//                userGoods.setGoodsImgs(goodsImgs);
//               // userGoods.setPostState(-1);
//                userGoods.setGoSell(0);
//                userGoods.setPostState(1);
//                userGoods.setGotoPawn(0);
//                userGoods.setCateCode(pawnCate.getCode());
//                userGoods.setBackState(0);
//                userGoods.setAuthResult(0);
//                userGoods.setCateId(pawnCate.getId());
//                userGoods.setIsVerify(0);
//                userGoods.setVideo(video);
//                userGoods.setInfo(info);
//                int result = userGoodsService.insert(userGoods);
//                if(result == 0){
//                    throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
//                }else{
//                    //新增成功
//                    ret.setCode(1);
//                }
//
//        }else if (MGoodsCateList.zs.code.equals(pawnCate.getCode())){
//            //在线鉴定出价格--钻石
//            JSONArray jsonArray = JSON.parseArray(content);
//            String color = null;
//            String weigth = null;
//            String light = null;
//            for(Object object : jsonArray){
//                JSONObject jsonObj = (JSONObject)object;
//                if(jsonObj.get("name").equals("克拉重量")){
//                    weigth = jsonObj.get("content")+"";
//                }
//                if(jsonObj.get("name").equals("颜色")){
//                    color = jsonObj.get("content")+"";
//                }
//                if(jsonObj.get("name").equals("净度")){
//                    light = jsonObj.get("content")+"";
//                }
//            }
//
//            //最终重量
//            Double weigthEnd = (Double.parseDouble(weigth))*100;
//            if(weigthEnd <= 30){
//                ret.setCode(-1);
//                ret.setMsg(" 0.3克拉以下的不予鉴定");
//                return ret;
//            }
//            if(light.equals("SI1") || light.equals("SI2") || light.equals("SI3") || light.equals("I1") || light.equals("I2") || light.equals("I3")){
//                ret.setData("参考价格，以邮件审核价格为准");
//            }
//            DiamondExample example1 = new DiamondExample();
//            example1.createCriteria().andWeightBeginLessThanOrEqualTo(weigthEnd.floatValue()).andWeigthEndGreaterThanOrEqualTo(weigthEnd.floatValue()).andColorEqualTo(color).andLightEqualTo(light);
//            List<Diamond> list1 = diamondService.selectByExample(example1);
//            if(null == list1 || list1.size() ==0){
//                ret.setCode(-1);
//                ret.setMsg("找不到该商品的价格，请到店或者邮寄");
//                return ret;
//            }
//            Diamond diamond = list1.get(0);
//            if(null == diamond){
//                throw new ApiException(MErrorEnum.APPID_FAIL_ERROR);
//            }
//
//            Double price1 = Integer.parseInt(diamond.getValue())*weigthEnd*7* PaidangConst.num;
//
//            ret.setCode(1);
//
//            DecimalFormat testPrice = new DecimalFormat("#.00");
//            ret.setMsg(testPrice.format(price1));
//
//
//        }else if(MGoodsCateList.gjs.code.equals(pawnCate.getCode())){
//            //在线鉴定出价格--黄金
//            JSONArray jsonArray = JSON.parseArray(content);
//            //种类
//            String type = null;
//            //克重
//            String weigth = null;
//            //纯度
//            String cd = null;
//            for(Object object : jsonArray){
//                JSONObject jsonObj = (JSONObject)object;
//                if(jsonObj.get("name").equals("金属种类")){
//                    if(jsonObj.get("content").equals("黄金")){
//                        type = "gold";
//                    }else if(jsonObj.get("content").equals("铂金")){
//                        type = "bj";
//                    }
//                }
//                if(jsonObj.get("name").equals("克重")){
//                    weigth = jsonObj.get("content")+"";
//                }
//                if(jsonObj.get("name").equals("纯度")){
//                    cd = jsonObj.get("content")+"";
//                }
//            }
//            CodeExample codeExample = new CodeExample();
//            codeExample.createCriteria().andCodeEqualTo(type);
//            List<Code> list1 = codeService.selectByExample(codeExample);
//            Code code2 = list1.get(0);
//
//            Double price1 = Double.parseDouble(code2.getValue())*Double.parseDouble(weigth)*Double.parseDouble(cd);
//            DecimalFormat testPrice = new DecimalFormat("#.00");
//            ret.setMsg(testPrice.format(price1));
//
//
//        }else if(MGoodsCateList.qt.code.equals(pawnCate.getCode())){
//            //其他
//            userGoods.setImages(images);
//            userGoods.setUserId(mobileInfo.getUserid());
//            userGoods.setBelongId(mobileInfo.getUserid());
//            userGoods.setBelongType(1);
//            userGoods.setLocation(0);
//            //userGoods.setPostState(-1);
//            userGoods.setPostState(1);
//            userGoods.setGotoPawn(0);
//            userGoods.setContent(content);
//            userGoods.setBackState(0);
//            userGoods.setAuthResult(0);
//            userGoods.setGoSell(0);
//            userGoods.setCateCode(pawnCate.getCode());
//            userGoods.setCateId(pawnCate.getId());
//            userGoods.setAuthenticateRequire(authenticateRequire);
//            userGoods.setVideo(video);
//            userGoods.setIsVerify(0);
//            int result = userGoodsService.insert(userGoods);
//            if(result == 0){
//                throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
//            }else{
//                //新增成功
//                ret.setCode(1);
//            }
//        }
//
//
//
//        return ret;
//    }
//
//    /**
//     * 我的鉴定列表
//     */
//    @ApiOperation(value="我的鉴定列表", notes = "登录")
//    @RequestMapping("/myGoods")
//    @ApiMethod(isPage = true, isLogin = true)
//    public List<AppMyGoods> list(MobileInfo mobileInfo,
//                                 PageLimit pageLimit){
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
////        UserGoodsExample example = new UserGoodsExample();
////        example.createCriteria().andBelongIdEqualTo(mobileInfo.getUserid()).andGotoPawnEqualTo(0).andBackStateEqualTo(0);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("belong_id",mobileInfo.getUserid());
//        List<UserGoodsEx> list = userGoodsService.selectMyGoods(map);
//        return getUserGoodsList(list);
//    }
//
//    /**
//     * 封装返回我的鉴定列表
//     *
//     * @param list
//     * @return
//     */
//    private List<AppMyGoods> getUserGoodsList(List<UserGoodsEx> list) {
//        List<AppMyGoods> appMyGoodsList = new ArrayList<AppMyGoods>();
//
//        for(UserGoodsEx ex : list){
//            appMyGoodsList.add(getAppMyGoodsList(ex));
//        }
//        return appMyGoodsList;
//    }
//    /**
//     * 封装返回AppMyGoods
//     *
//     * @param ex
//     * @return
//     */
//    private AppMyGoods getAppMyGoodsList(UserGoodsEx ex) {
//        AppMyGoods mini = new AppMyGoods();
//        mini.setId(ex.getId());
//        if(null == ex.getName() || "".equals(ex.getName())){
//            if(MGoodsCateList.zs.code.equals(ex.getCateCode())){
//                mini.setTitle(MGoodsCateList.zs.name);
//            }else if(MGoodsCateList.qt.code.equals(ex.getCateCode())){
//                mini.setTitle(MGoodsCateList.qt.name);
//            }else if(MGoodsCateList.gjs.code.equals(ex.getCateCode())){
//                mini.setTitle(MGoodsCateList.gjs.name);
//            }else if(MGoodsCateList.fcys.code.equals(ex.getCateCode())){
//                mini.setTitle(MGoodsCateList.fcys.name);
//            }else if(MGoodsCateList.sb.code.equals(ex.getCateCode())){
//                mini.setTitle(MGoodsCateList.sb.name);
//            }else if(MGoodsCateList.SCPZB.code.equals(ex.getCateCode())){
//                mini.setTitle(MGoodsCateList.SCPZB.name);
//            }else if(MGoodsCateList.hty.code.equals(ex.getCateCode())){
//                mini.setTitle(MGoodsCateList.hty.name);
//            }else if(MGoodsCateList.csbs.code.equals(ex.getCateCode())){
//                mini.setTitle(MGoodsCateList.csbs.name);
//            }
//        }else{
//            mini.setTitle(ex.getName());
//        }
//        String[] strs = ex.getImages().split(",");
//        mini.setImage(ex.getImages());
//
////        if(0 == ex.getPostState()){
////            //如果宝贝在用户手中，说明是在线鉴定
////            mini.setResult(ex.getAuthResult());
////            mini.setPriceTest(ex.getAuthPriceTest()+"");
////            mini.setPrice(ex.getAuthPrice()+"");
////        }else{
////            if(1 == ex.getIsVerify()){
////                mini.setResult(ex.getAuthResult());
////                mini.setPriceTest(ex.getAuthPriceTest()+"");
////                mini.setPrice(ex.getAuthPrice()+"");
////            }
////        }
//
//        if(1 == ex.getPostState()){
//            //用户没寄出--代表是在线鉴定
//            mini.setResult(ex.getAuthResult());
//            mini.setPriceTest(ex.getAuthPriceTest()+"");
//            mini.setPrice(ex.getAuthPrice()+"");
//        }else if(3 == ex.getPostState() || 4 == ex.getPostState()){
//            //平台收到宝贝--判断是否有二次鉴定
//            if(1 == ex.getIsVerify()){
//                //已经二次鉴定
//                mini.setResult(ex.getAuthResult());
//                mini.setPriceTest(ex.getAuthPriceTest()+"");
//                mini.setPrice(ex.getAuthPrice()+"");
//            }else{
//                //没有二次鉴定 -- 结果是鉴定中，--价格空
//                mini.setResult(1);
//                mini.setPriceTest("");
//                mini.setPrice("");
//
//            }
//        }
//
//
//        mini.setPostState(ex.getPostState());
//        if(null != ex.getGoSell()){
//            if(2 == ex.getGoSell()){
//                //平台已经确认打款并且上传打款凭证
//                mini.setPlatformIsVerify(1);
//                mini.setPlatformPayTicket(ex.getPlatformTicket());
//            }else if(1 == ex.getGoSell()){
//                mini.setPlatformIsVerify(0);
//            }else if(0 == ex.getGoSell()){
//                mini.setPlatformIsVerify(-1);
//            }
//        }else{
//            mini.setPlatformIsVerify(-1);
//        }
//
//
//        return mini;
//    }
//
//    /**
//     * 用户把宝贝卖给卖给平台
//     * @param mobileInfo
//     * @param id
//     * @return
//     */
//    @ApiOperation(value="用户把宝贝卖给卖给平台", notes = "登录")
//    @RequestMapping("/saleToPlatform")
//    @ApiMethod(isLogin = true)
//    public Ret saleToPlatform(MobileInfo mobileInfo,
//                               @ApiParam(value="id",required = true)Integer id,
//                               @ApiParam(value="银行卡id",required = true)Integer bankCardId) {
//        User user = userService.selectByPrimaryKey(mobileInfo.getUserid());
//        UserBankCard userBankCard = userBankCardService.selectByPrimaryKey(bankCardId);
//        //UserGoods userGoods = userGoodsService.selectByPrimaryKey(id);
//        UserGoodsExample example = new UserGoodsExample();
//        example.createCriteria().andIdEqualTo(id).andGoSellNotEqualTo(2);
//        List<UserGoods> list = userGoodsService.selectByExample(example);
//        UserGoods userGoods = list.get(0);
//        if(null != userGoods.getGoSell()){
//            if(1 == userGoods.getGoSell()){
//                throw new ApiException(MErrorEnum.APPLY_IS_WORKING);
//            }
//        }
//        //申请卖给平台
//        userGoods.setGoSell(1);
//        userGoodsService.updateByPrimaryKeySelective(userGoods);
//        if(4 == userGoods.getAuthResult() && 1 == userGoods.getLocation()){
//            //宝贝是真品并且宝贝现在在平台
//            //平台商品收购表插入数据
//            PlatformGoodsBuy platformGoodsBuy = new PlatformGoodsBuy();
//            platformGoodsBuy.setSource(1);
//            platformGoodsBuy.setGoodsId(userGoods.getId());
//            platformGoodsBuy.setPrice(userGoods.getAuthPrice());
//            platformGoodsBuy.setBankCardName(userBankCard.getBankCardName());
//            platformGoodsBuy.setBankCardNo(userBankCard.getBankCardNo());
//            platformGoodsBuy.setUserName(user.getName());
//            platformGoodsBuy.setUserPhone(user.getAccount());
//            platformGoodsBuy.setState(1);
//            int result = platformGoodsBuyService.insert(platformGoodsBuy);
//            if(result == 0){
//                throw new ApiException(MErrorEnum.SERVER_BUSY_ERROR);
//            }
////            //插入用户余额日志表
////            userBalanceLogService.updateUserBalanceLog(
////                    mobileInfo.getUserid(),
////                    id,
////                    userGoods.getAuthPrice(),
////                    1,
////                    5,
////                    10,
////                    "",
////                    "",
////                    userBankCard.getBankCardName(),
////                    userBankCard.getBankCardNo(),
////                    0,
////                    "宝祥",
////                    MPawnMsg.phone
////            );
//        }
//        return ok();
//    }
//
//    /**
//     * 物流信息
//     * @param mobileInfo
//     * @param pageLimit
//     * @param type
//     * @return
//     */
//    @ApiOperation(value="物流信息列表", notes = "登录")
//    @RequestMapping("/postList")
//    @ApiMethod(isPage = true, isLogin = true)
//    public List<AppLogisticsDetail> waitToPost(MobileInfo mobileInfo,
//                                       PageLimit pageLimit,
//                                       @ApiParam(value="状态(1寄往平台  2平台取回)",required = true)Integer type){
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("source_id",mobileInfo.getUserid());
//        map.put("type",type);
//        List<ExpressEx> list = expressService.selectByGoods(map);
//        List<AppLogisticsDetail> list2 = new ArrayList<AppLogisticsDetail>();
//        for(ExpressEx ex : list){
//            AppLogisticsDetail record = new AppLogisticsDetail();
//            record.setId(ex.getId());
//            record.setImages(ex.getGoodsImages());
//            record.setName(ex.getGoodsName());
//            record.setPostState(ex.getExpressState());
//            record.setBackState(ex.getExpressState());
//            record.setPostExpressCode(ex.getExpressCode() == null ? "" : ex.getExpressCode());
//            list2.add(record);
//        }
//
//        return list2;
//    }
//
//    /**
//     * 去邮寄--宝祥典当地址
//     */
//    @ApiOperation(value="去邮寄--宝祥典当地址", notes = "不需要登录")
//    @RequestMapping("/bxAddress")
//    @ApiMethod(isPage = false, isLogin = false)
//    public AppBXAddress bxAddress(){
//        AppBXAddress c = new AppBXAddress();
//        c.setName(MPawnMsg.name);
//        c.setPhone(MPawnMsg.phone);
//        c.setAddress(MPawnMsg.address);
//        return c;
//    }
//
//    /**
//     * 去邮寄--填写物流信息
//     */
//    @ApiOperation(value="去邮寄--填写物流信息", notes = "登录")
//    @RequestMapping("/gotoPost")
//    @ApiMethod(isPage = false, isLogin = true)
//    public Ret gotoPost(MobileInfo mobileInfo,
//                        @ApiParam(value="id(不是必填--若在线申请过必填，)",required = true)Integer id,
//                        @ApiParam(value="鉴定code(不是必填--若直接邮寄必填，)",required = true)String pawnCateCode,
//                        @ApiParam(value="图片(不是必填--若直接邮寄必填，)",required = true)String images,
//                        @ApiParam(value="物流单号",required = true)String pid,
//                        @ApiParam(value="邮寄打包视频",required = true)String video,
//                        @ApiParam(value="顺风保价",required = true)BigDecimal sfProtectPrice){
////       UserAddressExample userAddressExample = new UserAddressExample();
////       userAddressExample.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andIsDefaultEqualTo(1);
////       List<UserAddress> list = userAddressService.selectByExample(userAddressExample);
////       UserAddress ex = list.get(0);
//
//        Express express = new Express();
//        UserGoodsExample example = new UserGoodsExample();
//        if(null != id){
//            example.createCriteria().andIdEqualTo(id);
//        }
//
//
//        UserGoods userGoods = userGoodsService.selectByPrimaryKey(id);
//        UserGoods record = new UserGoods();
//
//
//
//
//        if(null !=  userGoods){
//            //经过在线申请
//
//            userGoods.setPostExpressCode(pid);
//            userGoods.setPostState(2);
//            userGoods.setPostExpress(MPostExpressAddress.xfAddress);
//            userGoods.setPostExpressCode(pid);
//            userGoods.setBackState(0);
//            userGoods.setGoVideo(video);
//            userGoods.setGoSell(0);
//            userGoods.setIsVerify(0);
//            userGoods.setSfProtectPrice(sfProtectPrice);
//            int result = userGoodsService.updateByPrimaryKeySelective(userGoods);
//            if(result == 0){
//                throw new ApiException(1000, "请求失败");
//            }
//            express.setFid(userGoods.getId());
//        }else{
//            //直接邮寄
//            record.setUserId(mobileInfo.getUserid());
//            record.setBelongId(mobileInfo.getUserid());
//            record.setBelongType(1);
//            record.setPostExpressCode(pid);
//            record.setGotoPawn(0);
//            record.setPostState(2);
//            record.setPostExpress(MPostExpressAddress.xfAddress);
//            record.setBackState(0);
//            record.setGoVideo(video);
//            record.setImages(images);
//            record.setGoSell(0);
//            record.setCateCode(pawnCateCode);
//            record.setSfProtectPrice(sfProtectPrice);
//            record.setIsVerify(0);
//            PawnCateExample pawnCateExample = new PawnCateExample();
//            pawnCateExample.createCriteria().andCodeEqualTo(pawnCateCode);
//            List<PawnCate> list1 = pawnCateService.selectByExample(pawnCateExample);
//            PawnCate pawnCate = list1.get(0);
//
//            record.setCateId(pawnCate.getId());
//            int result = userGoodsService.insert(record);
//            if(result == 0){
//                throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
//            }
//            express.setFid(record.getId());
//
//
//        }
//        //插入物流记录
//
//        express.setSource(1);
//        express.setSourceId(mobileInfo.getUserid());
//
//        express.setType(1);
//        express.setExpressName(MPostExpressAddress.xfAddress);
//        express.setExpressCode(pid);
//        express.setExpressState(0);
//        express.setExpressData("");
////            express.setPostName(ex.getUserName());
////            express.setPostPhone(ex.getPhone());
//        express.setReceiveName(MPawnMsg.name);
//        express.setReceivePhone(MPawnMsg.phone);
//        express.setReceviceAddress(MPawnMsg.address);
//        int expressResult = expressService.insert(express);
//        if(expressResult == 0){
//            throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
//        }
//
//            return ok();
//    }
//
//    @ApiOperation(value="我的鉴定--取回", notes = "登录")
//    @RequestMapping("/getBackGoods")
//    @ApiMethod(isPage = false, isLogin = true)
//    public Ret getBackGoods(MobileInfo mobileInfo,
//                            @ApiParam(value="id",required = true)Integer id,
//                            @ApiParam(value="地址id",required = true)Integer addressId){
////        Map<String, Object> map = new HashMap<String, Object>();
////        map.put("user_id",mobileInfo.getUserid());
////        map.put("id",id);
////
////        UserAddressEx userAddressEx = userAddressService.selectAppList(map);
//        User user = userService.selectByPrimaryKey(mobileInfo.getUserid());
//        //UserGoods userGoods = new UserGoods();
//        //userGoods.setId(id);
//        UserGoods userGoods = userGoodsService.selectByPrimaryKey(id);
//        userGoods.setBackUserName(user.getName());
//        userGoods.setBackState(1);
//        UserAddress userAddress = userAddressService.selectByPrimaryKey(addressId);
//        userGoods.setBackUserPhone(userAddress.getPhone());
//        userGoods.setBackUserExpress(userAddress.getArea()+userAddress.getAddress());
//        int result = userGoodsService.updateByPrimaryKeySelective(userGoods);
//        if(result == 0){
//            throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
//        }
//
////        //插入express表
////        Express express = new Express();
////        express.setSourceId(userGoods.getBelongId());
////        express.setFid(id);
////        express.setType(2);
////        express.setExpressState(0);
////        express.setReceiveName(user.getName());
////        express.setReceivePhone(userAddress.getPhone());
////        express.setReceviceAddress(userAddress.getArea()+userAddress.getAddress());
////        expressService.insert(express);
//        return ok();
//    }
//
//
//    /**
//     * 待签收列表
//     */
//    @ApiOperation(value="物流信息--待签收列表", notes = "登录")
//    @RequestMapping("/waitGetList")
//    @ApiMethod(isPage = true, isLogin = true)
//    public List<AppLogisticsDetail> waitGetList(MobileInfo mobileInfo,
//                                                PageLimit pageLimit){
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
//        UserGoodsExample userGoodsExample = new UserGoodsExample();
//        userGoodsExample.or().andBelongIdEqualTo(mobileInfo.getUserid()).andPostStateEqualTo(2);
//        userGoodsExample.or().andBelongIdEqualTo(mobileInfo.getUserid()).andPostStateEqualTo(3);
//        List<UserGoods> list = userGoodsService.selectByExample(userGoodsExample);
//        List<AppLogisticsDetail> array = new ArrayList<AppLogisticsDetail>();
//        for(UserGoods ex : list){
//            AppLogisticsDetail record = new AppLogisticsDetail();
//            record.setId(ex.getId());
//            record.setImages(ex.getImages());
//            record.setName(ex.getName());
//            record.setPostExpressCode(ex.getPostExpressCode());
//            record.setPostState(ex.getPostState());
//            array.add(record);
//        }
//
//        return array;
//    }
//
//    @ApiOperation(value="物流信息--签收宝贝", notes = "登录")
//    @RequestMapping("/getGoods")
//    @ApiMethod(isPage = false, isLogin = true)
//    public Ret getGoods(MobileInfo mobileInfo,
//                        @ApiParam(value="id",required = true)Integer id){
//        UserGoods userGoods = userGoodsService.selectByPrimaryKey(id);
//        userGoods.setBackState(3);
//        userGoodsService.updateByPrimaryKeySelective(userGoods);
//        return ok();
//    }
//
//
//
//    @ApiOperation(value="首页搜索 ", notes = "不登录")
//    @RequestMapping("/searchIndexMenu")
//    @ApiMethod(isPage = false, isLogin = false)
//    public List<ApiIndexMenu> searchIndexMenu(MobileInfo mobileInfo,
//                                              @ApiParam(value="name",required = true)String name){
//        List<ApiIndexMenu> ret = new ArrayList<ApiIndexMenu>();
////        GoodsExample example = new GoodsExample();
////        example.createCriteria().andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andNameLike("%"+name+"%");
////        example.setOrderByClause("create_time desc");
////        List<Goods> goodsList = goodsService.selectByExample(example);
//        GoodsEx goodsEx=new GoodsEx();
//        goodsEx.setName(name);
//        List<GoodsEx> goodsList=goodsService.findList(goodsEx);
//        Map<String, Object> map = new HashMap<String, Object>();
//        for(GoodsEx ex : goodsList){
//            ApiIndexMenu c = new ApiIndexMenu();
//            /*if(ex.getPrice().compareTo(new BigDecimal(30000)) == -1){
//                //如果他的价格不满三万则是最新绝当商品
//                c.setId(ex.getId());
//                c.setImg(ex.getImg());
//                c.setTitle(ex.getName());
//                c.setPrice(ex.getPrice()+"");
//                c.setState(2);
//            }else{
//                long second = DateUtil.secondsAfter(DateUtil.addMinute(ex.getCreateTime(),(PaidangConst.JD_GOODS_TIME)/60),new Date());
//                if(second > 0){
//                    c.setId(ex.getId());
//                    c.setEndTime(DateUtil.dateToStr(DateUtil.addHour(ex.getCreateTime(),24)));
//                    c.setEndTime2(second+"");
//                    c.setImg(ex.getImg());
//                    c.setTitle(ex.getName());
//                    c.setPrice(ex.getPrice()+"");
//                    //查找该物品的当前出价--最高价
//
//                    map.put("goods_id",ex.getId());
//                    BigDecimal maxPrice = goodsAuctionService.selectMaxPrice(map);
//                    c.setMaxPrice(maxPrice == null? "0" : maxPrice.toString());
//
//                    //查找该物品我的出价
//                    GoodsAuctionExample example1 = new GoodsAuctionExample();
//                    example1.createCriteria().andGoodsIdEqualTo(ex.getId()).andUserIdEqualTo(mobileInfo.getUserid());
//                    example1.setOrderByClause("price desc");
//                    List<GoodsAuction> list = goodsAuctionService.selectByExample(example1);
//                    if(list.size() != 0 && list != null){
//                        c.setMyPrice(list.get(0).getPrice()+"");
//                    }
//                    c.setState(3);
//                }else{
//                    //超过时间不显示，并且修改他为竞拍失效
//                    ex.setState(0);
//                    goodsService.updateByPrimaryKeySelective(ex);
//                    continue;
//                }
//                //               }
//
//            }*/
//            c.setId(ex.getId());
//            c.setImg(ex.getImg());
//            c.setTitle(ex.getName());
//            c.setPrice(ex.getPrice()+"");
//            c.setState(2);
//            c.setOrgId(ex.getOrgId());
//            c.setOrgName(ex.getOrgName());
//            c.setSource(ex.getSource());
//            ret.add(c);
//        }
//        return ret;
//    }
//
//    @ApiOperation(value="首页热门搜索 ", notes = "不登录")
//    @RequestMapping("/searchIndexHotMenu")
//    @ApiMethod(isPage = false, isLogin = false)
//    public List<ApiIndexHotMenu> searchIndexHotMenu(MobileInfo mobileInfo){
//        List<ApiIndexHotMenu> ret = new ArrayList<ApiIndexHotMenu>();
//        AdExample example = new AdExample();
//        example.createCriteria().andLocationEqualTo(5);
//        example.setOrderByClause("sort_order asc, create_time desc");
//        List<Ad> list = adService.selectByExampleWithBLOBs(example);
//        for(Ad ex : list){
//            ApiIndexHotMenu c = new ApiIndexHotMenu();
//            c.setId(ex.getId());
//            c.setName(ex.getContent());
//            ret.add(c);
//        }
//        return ret;
//    }
//
//
//    @ApiOperation(value="店铺搜索 ", notes = "不登录")
//    @RequestMapping("/searchIndexOrg")
//    @ApiMethod(isPage = false, isLogin = false)
//    public Object searchIndexOrg(@ApiParam(value="name",required = true)String name){
//        PawnOrgExample pawnOrgExample=new PawnOrgExample();
//        pawnOrgExample.createCriteria().andNameLike("%"+name+"%").andStateEqualTo(1);
//       // pawnOrgExample.setOrderByClause("create_time desc");
//        List<PawnOrg> list=pawnOrgService.selectByExample(pawnOrgExample);
//
//        if (list!=null && list.size()>0){
//            List<PawnOrgEx> exList=new ArrayList<>(list.size());
//            for(PawnOrg org:list){
//                PawnOrgEx ex=new PawnOrgEx();
//                try {
//                    BeanUtils.copyProperties(org,ex);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                List<GoodsEx> goodsExList=goodsService.getMostThreeGoods(ex.getId());
//                String img="";
//                for (int i=0;i<goodsExList.size();i++){
//                    if (StringUtil.isNotBlank(goodsExList.get(i).getImg())){
//                        if (i!=goodsExList.size()-1){
//                            img+=goodsExList.get(i).getImg()+",";
//                        }else {
//                            img+=goodsExList.get(i).getImg();
//                        }
//                    }
//                }
//                ex.setGoodsImgs(img);
//                exList.add(ex);
//            }
//            return exList;
//        }
//        return list;
//    }
//
//    @ApiOperation(value="视频搜索 ", notes = "不登录")
//    @RequestMapping("/searchIndexVideo")
//    @ApiMethod(isPage = false, isLogin = false)
//    public Object searchIndexVideo(@ApiParam(value="name",required = true)String name){
//        VideoOnlineExample example=new VideoOnlineExample();
//        example.createCriteria().andTitleLike("%"+name+"%");
//        example.setOrderByClause("create_time desc");
//        return videoOnlineService.selectByExample(example);
//    }
//}
