//package com.api.action;
//
//import com.api.MEnumError;
//import com.api.MErrorEnum;
//import com.api.util.PageLimit;
//import com.api.view.indexInfo.ApiIndexMenu;
//import com.api.view.store.AppJdGoods;
//import com.api.view.store.AppOrgName;
//import com.api.view.store.AppStoreBanner;
//import com.api.view.store.AppStoreGoodsDetail;
//import com.api.view.user.AppUserCoupon;
//import com.api.view.video.AppVideoOnline;
//import com.base.api.ApiBaseController;
//import com.base.api.ApiException;
//import com.base.api.MobileInfo;
//import com.base.api.annotation.ApiMethod;
//import com.base.dao.model.Ret;
//import com.base.date.DateUtil;
//import com.base.dialect.PaginationSupport;
//import com.base.util.StringUtil;
//import com.item.dao.model.Ad;
//import com.item.dao.model.AdExample;
//import com.item.dao.model.Focus;
//import com.item.dao.model.FocusExample;
//import com.item.daoEx.model.AdEx;
//import com.item.service.AdService;
//import com.item.service.FocusService;
//import com.paidang.dao.model.*;
//import com.paidang.daoEx.model.GoodsAuctionEx;
//import com.paidang.daoEx.model.GoodsEx;
//import com.paidang.daoEx.model.VideoOnlineEx;
//import com.paidang.service.*;
//import com.util.PaidangConst;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import jdk.nashorn.internal.runtime.linker.JavaAdapterServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.math.BigDecimal;
//import java.util.*;
//
//@RestController
//@RequestMapping(value = "/api/storeGoods", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
//@Api(tags = "商城(用户端)")
//public class ApiStoreController extends ApiBaseController {
//
//    @Autowired
//    private GoodsService goodsService;
//    @Autowired
//    private UserCouponService userCouponService;
//    @Autowired
//    private FocusService focusService;
//    @Autowired
//    private PawnOrgService pawnOrgService;
//    @Autowired
//    private GoodsAuctionService goodsAuctionService;
//    @Autowired
//    private AdService adService;
//    @Autowired
//    private VideoOnlineService videoOnlineService;
//
//
//    public enum MStoreGoodsCateList {
//        zb("1","钟表","0"),
//        fc("2","翡翠","0"),
//        hty("3","和田玉","0"),
//        gdysp("4","古董艺术品","0"),
//        sh("5","书画","0"),
//        cszb("6","彩色珠宝","0"),
//        zs("7","钻石","0"),
//        other("8","更多","0"),
//
//        mqyt("9","明清砚台","4"),
//        ww("10","文玩","4"),
//        zx("11","杂项","4"),
//        hlbs("12","红蓝宝石","6"),
//        zml("13","祖母绿","6"),
//        zz("14","珍珠","6"),
//        bx("15","碧玺","6");
//
//        private String code;
//        private String name;
//        private String fid;
//        private MStoreGoodsCateList(String code,String name,String fid) {
//            this.code = code;
//            this.name = name;
//            this.fid = fid;
//        }
//    }
//
//    /**
//     * 认证商城首页轮播
//     * @return
//     */
//    @ApiOperation(value = "认证商城首页轮播", notes = "不需要登录")
//    @RequestMapping("/storeBanner")
//    @ApiMethod(isLogin = false)
//    public List<AppStoreBanner> storeBanner(){
//        List<AppStoreBanner> ret = new ArrayList<>();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("location",2);
//        List<AdEx> list = adService.selectRzList(map);
//        for(AdEx ex : list){
//            AppStoreBanner record = new AppStoreBanner();
//                record.setId(ex.getId());
//                record.setUrl(ex.getImg());
//                record.setType(ex.getType());
//                if(0 == ex.getType()){
//                    record.setContent("");
//                }else if(1 == ex.getType()){
//                    record.setContent(getPage(ex.getId(),10));
//                }else if(2 == ex.getType()){
//                    record.setContent(getPage(ex.getId(),10));
//                }else if(3 == ex.getType()){
//                    record.setContent(ex.getContent());
//                }else if(4 == ex.getType()){
//                    record.setContent(ex.getContent());
//                }else if(5 == ex.getType()){
//                    record.setContent(ex.getContent());
//                }
//            if(4 == ex.getType()){
//                //如果是绝当商品的商品
//                if(null == ex.getGoodsId()){
//                    //如果是后台上传的,则不区分30000
//                    record.setState(2);
//                }else{
//                    if(new BigDecimal(ex.getCost()).compareTo(new BigDecimal(30000) )== -1){
//                        //走流程小于三万则是普通商品
//                        record.setState(2);
//                    }else{
//                        record.setState(1);
//                    }
//                }
//            }
//            ret.add(record);
//        }
//        return ret;
//    }
//
//
//    /**
//     * 认证商场列表
//     */
//    @ApiOperation(value = "认证商场列表", notes = "分页")
//    @RequestMapping("/storeGoodsList")
//    @ApiMethod(isLogin = false)
//    public List<AppStoreGoodsDetail> storeGoodsList(MobileInfo mobileInfo,
//                                                    @ApiParam(value="code(1钟表，2翡翠，3和田玉，4古董艺术品，5书画，6彩色珠宝，7钻石，8其他，9明清砚台，10文玩，" +
//                                                            "11杂项,12红蓝宝石，13祖母绿，14珍珠，15碧玺)",required = true) Integer type,
//                                                    PageLimit pageLimit){
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
//        List<AppStoreGoodsDetail> list2 = new ArrayList<AppStoreGoodsDetail>();
//        GoodsExample goodsExample = new GoodsExample();
//
//
//        if(null != type){
//            goodsExample.createCriteria().andCateCodeEqualTo(type).andStateEqualTo(1).andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andTypeEqualTo(1).andSourceEqualTo(3).andTotalGreaterThanOrEqualTo(1);
//        }else{
//            goodsExample.createCriteria().andStateEqualTo(1).andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andSourceEqualTo(3).andTypeEqualTo(1).andTotalGreaterThanOrEqualTo(1);
//        }
//
//        List<Goods> list = goodsService.selectByExample(goodsExample);
//        for(Goods ex : list){
//            AppStoreGoodsDetail record = new AppStoreGoodsDetail();
//            record.setId(ex.getId());
//            record.setTitle(ex.getName());
//            record.setImg(ex.getImg());
//            record.setImages(ex.getImgs());
//            record.setWidth(ex.getWidth());
//            record.setHeight(ex.getHeight());
//            record.setAuthPrice(ex.getPrice()+"");
//            record.setPrice(ex.getPrice()+"");
//            list2.add(record);
//        }
//        return list2;
//    }
//
//    //TODO source 2机构 3平台自身 4供应商
//    /** 新品推荐 典当机构和平台
//     * 认证商场热门列表
//     */
//    @ApiOperation(value = "绝当商场类型列表", notes = "分页")
//    @RequestMapping("/storeJDGoodsLists")
//    @ApiMethod(isLogin = false)
//    public List<AppStoreGoodsDetail> storeJDGoodsLists(MobileInfo mobileInfo,
//                                                    @ApiParam(value="code(1奢侈品珠宝，2手表，3钻石，4贵金属，5翡翠玉石，6和田玉，7其他)",required = true) Integer type,
//                                                       PageLimit pageLimit){
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
//        List<AppStoreGoodsDetail> list2 = new ArrayList<AppStoreGoodsDetail>();
//        GoodsExample goodsExample = new GoodsExample();
//        goodsExample.or().andStateEqualTo(1).andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andSourceEqualTo(3).andTypeEqualTo(1).andSoldOutEqualTo(0);
//        goodsExample.or().andStateEqualTo(1).andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andSourceEqualTo(2).andTypeEqualTo(1).andSoldOutEqualTo(0);
//        goodsExample.setOrderByClause("is_suggest desc,create_time desc");
//        List<Goods> list = goodsService.selectByExample(goodsExample);
//        for(Goods ex : list){
//            AppStoreGoodsDetail record = new AppStoreGoodsDetail();
//            record.setId(ex.getId());
//            record.setTitle(ex.getName());
//            record.setImg(ex.getImg());
//            record.setImages(ex.getImgs());
//            record.setWidth(ex.getWidth());
//            record.setHeight(ex.getHeight());
//            record.setAuthPrice(ex.getPrice()+"");
//            record.setPrice(ex.getPrice()+"");
//            record.setSource(ex.getSource());
//            list2.add(record);
//        }
//        return list2;
//    }
//
//    //TODO source 2机构 3平台自身 4供应商
//    /** 新品推荐 典当机构和平台
//     * 认证商场热门列表
//     */
//    @ApiOperation(value = "认证商场热门列表", notes = "分页")
//    @RequestMapping("/storeHotGoodsList")
//    @ApiMethod()
//    public List<AppStoreGoodsDetail> storeHotGoodsList(MobileInfo mobileInfo,
//                                                       PageLimit pageLimit){
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
//        List<AppStoreGoodsDetail> list2 = new ArrayList<AppStoreGoodsDetail>();
//        GoodsExample goodsExample = new GoodsExample();
//        //goodsExample.createCriteria().andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andSourceEqualTo(3).andTotalGreaterThanOrEqualTo(1);
//
//        goodsExample.or().andStateEqualTo(1).andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andSourceEqualTo(3).andTotalGreaterThan(0);
//        goodsExample.or().andStateEqualTo(1).andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andSourceEqualTo(4).andTotalGreaterThan(0);
//        goodsExample.setOrderByClause("is_suggest desc,create_time desc");
//        List<Goods> list = goodsService.selectByExample(goodsExample);
//        for(Goods ex : list) {
//            AppStoreGoodsDetail record = new AppStoreGoodsDetail();
//            record.setId(ex.getId());
//            record.setImg(ex.getImg());
//            record.setImages(ex.getImgs());
//            record.setWidth(ex.getWidth());
//            record.setHeight(ex.getHeight());
//            record.setTitle(ex.getName());
//            record.setPrice(ex.getPrice() + "");
//            record.setAuthPrice(ex.getPrice()+"");
//            record.setSource(ex.getSource());
//            list2.add(record);
//        }
//        return list2;
//    }
//
//    /**
//     * 认证商场物品详情
//     */
//    @ApiOperation(value = "认证商场物品详情", notes = "不需要登录")
//    @RequestMapping("/storeGoodsDetail")
//    @ApiMethod(isLogin = false)
//    public AppStoreGoodsDetail storeGoodsDetail(@ApiParam(value="id",required = true) Integer id){
//        AppStoreGoodsDetail appStoreGoodsDetail = new AppStoreGoodsDetail();
//        GoodsEx goodsEx=new GoodsEx();
//        goodsEx.setId(id);
//        List<GoodsEx>  exList= goodsService.findList(goodsEx);
//        if (exList==null || exList.size()==0){
//            throw new ApiException(-1,"该商品不存在");
//        }
//        GoodsEx ex=exList.get(0);
//        appStoreGoodsDetail.setId(ex.getId());
//        appStoreGoodsDetail.setImages(ex.getImgs());
//        appStoreGoodsDetail.setTitle(ex.getName());
//        appStoreGoodsDetail.setPrice(ex.getPrice()+"");
//        appStoreGoodsDetail.setAuthPrice(ex.getCost()+"");
//        appStoreGoodsDetail.setDeclare(ex.getInfo());
//        appStoreGoodsDetail.setGoodsDescription(getPage(id,1));
//        appStoreGoodsDetail.setOrgId(ex.getOrgId());
//        appStoreGoodsDetail.setOrgName(ex.getOrgName());
//        appStoreGoodsDetail.setOrgIntroduction(ex.getOrgIntroduction());
//        appStoreGoodsDetail.setOrgLogo(ex.getOrgLogo());
//        appStoreGoodsDetail.setSource(ex.getSource());
//        return appStoreGoodsDetail;
//    }
//
//    /**
//     *认证商场购买商品优惠券列表
//     * @param id
//     * @return
//     */
//    @ApiOperation(value = "认证商场购买商品选择优惠券", notes = "不需要登录")
//    @RequestMapping("/userStroeCouponList")
//    @ApiMethod(isLogin = true)
//    public List<AppUserCoupon> userStroeCouponList(MobileInfo mobileInfo,
//                                                @ApiParam(value="商品id",required = true) Integer id){
//        Goods goods = goodsService.selectByPrimaryKey(id);
//        //商品售价
//        BigDecimal price = goods.getPrice();
//        UserCouponExample userCouponExample = new UserCouponExample();
//        userCouponExample.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andFullLessThanOrEqualTo(price).andEndTimeGreaterThanOrEqualTo(new Date()).andStateEqualTo(1);
//        List<UserCoupon> list = userCouponService.selectByExample(userCouponExample);
//        List<AppUserCoupon> list2 = new ArrayList<AppUserCoupon>();
//        for(UserCoupon ex : list){
//            AppUserCoupon record = new AppUserCoupon();
//            record.setId(ex.getId());
//            //record.setFull(ex.getFull()+"");
//            record.setCouponId(ex.getId());
//            record.setValue(ex.getFull()+"");
//            list2.add(record);
//        }
//        return list2;
//    }
//
//    /**
//     * 绝当商城轮播图
//     */
//    @ApiOperation(value = "绝当商城轮播图", notes = "分页")
//    @RequestMapping("/jdGoodsBanner")
//    @ApiMethod(isPage = false)
//    public List<AppStoreBanner> jdGoodsList(MobileInfo mobileInfo){
//        List<AppStoreBanner> ret = new ArrayList<>();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("location",3);
//        List<AdEx> list = adService.selectRzList(map);
//        for(AdEx ex : list){
//            AppStoreBanner record = new AppStoreBanner();
//            record.setId(ex.getId());
//            record.setUrl(ex.getImg());
//            record.setType(ex.getType());
//            if(0 == ex.getType()){
//                record.setContent("");
//            }else if(1 == ex.getType()){
//                record.setContent(getPage(ex.getId(),10));
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
//                    record.setState(2);
//                }else{
//                    if(new BigDecimal(ex.getCost()).compareTo(new BigDecimal(30000) )== -1){
//                        //走流程小于三万则是普通商品
//                        record.setState(2);
//                    }else{
//                        record.setState(1);
//                    }
//                }
//            }
//            ret.add(record);
//        }
//        return ret;
//    }
//
//    /**
//     * 绝当商场商家名称
//     */
//    @ApiOperation(value = "绝当商城商家名称", notes = "分页")
//    @RequestMapping("/orgName")
//    @ApiMethod(isPage = true)
//    public List<AppOrgName> orgName(MobileInfo mobileInfo,
//                                    PageLimit pageLimit){
//        List<AppOrgName> ret = new ArrayList<AppOrgName>();
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),
//                false);
//        PawnOrgExample pawnOrgExample = new PawnOrgExample();
//        pawnOrgExample.createCriteria().andTypeEqualTo(1);
//        pawnOrgExample.setOrderByClause("create_time desc");
//        List<PawnOrg> list = pawnOrgService.selectByExample(pawnOrgExample);
//        for(PawnOrg ex : list){
//            AppOrgName appOrgName = new AppOrgName();
//            appOrgName.setOrgId(ex.getId());
//            appOrgName.setOrgName(ex.getName());
//            ret.add(appOrgName);
//        }
//        return ret;
//    }
//
//
//    /** 目前是淘宝贝是source 为2
//     * 绝当商城列表
//     */
//    @ApiOperation(value = "绝当商城列表", notes = "不需要登陆")
//    @RequestMapping("/storeJDGoodsList")
//    @ApiMethod()
//    public List<AppStoreGoodsDetail> storeJDGoodsList(MobileInfo mobileInfo,
//                                                      PageLimit pageLimit,
//                                                      @ApiParam(value="时间排序 0升序 1降序",required = true) String timeUp,
//                                                      @ApiParam(value="价格 0升序 1降序",required = true) String priceUp,
//                                                      @ApiParam(value="商铺id",required = true) String orgId){
//        List<AppStoreGoodsDetail> ret = new ArrayList<AppStoreGoodsDetail>();
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),
//                false);
//        GoodsExample example = new GoodsExample();
//        GoodsExample.Criteria goodsExample = example.createCriteria().andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andTotalGreaterThanOrEqualTo(1).andTypeEqualTo(2).andSourceEqualTo(2);
//        //goodsExample.andSourceEqualTo(3);
//        if(StringUtil.isNotBlank(orgId)){
//            goodsExample.andOrgIdEqualTo(Integer.parseInt(orgId));
//        }
//
//        if("0".equals(priceUp) && "0".equals(timeUp)){
//            //默认时间降序，价格降序
//            example.setOrderByClause("create_time desc,price desc");
//        }else if("0".equals(priceUp) && "1".equals(timeUp)){
//            example.setOrderByClause("create_time asc,price desc");
//        }else if("1".equals(priceUp) && "0".equals(timeUp)){
//            example.setOrderByClause("price asc,create_time desc");
//        }else if("1".equals(priceUp) && "1".equals(timeUp)){
//            example.setOrderByClause("create_time asc,price asc");
//        }else{
//            example.setOrderByClause("sort_order desc,create_time desc,price desc");
//        }
//
//
//
//
//        List<Goods> goodsList = goodsService.selectByExample(example);
//        for(Goods ex : goodsList){
//            AppStoreGoodsDetail c = new AppStoreGoodsDetail();
//                c.setSource(ex.getSource());
//
//                if(ex.getPrice().compareTo(new BigDecimal("30000")) == -1 || null == ex.getGoodsId()){
//                    //普通绝当商品
//                    c.setType(0);
//                    c.setId(ex.getId());
//                    c.setTitle(ex.getName());
//                    c.setImg(ex.getImg());
//                    c.setImages(ex.getImgs());
//                    c.setWidth(ex.getWidth());
//                    c.setHeight(ex.getHeight());
//                    c.setPrice(ex.getPrice()+"");
//                    c.setAuthPrice(ex.getPrice()+"");
//                }else{
//                    //竞拍的商品
//                    long second = DateUtil.secondsAfter(DateUtil.addMinute(ex.getCreateTime(),(PaidangConst.JD_GOODS_TIME)/60),new Date());
//                    if(second > 0){
//                        //正在竞拍的商品
//                        c.setType(1);
//                        c.setId(ex.getId());
//                        c.setTitle(ex.getName());
//                        c.setImg(ex.getImg());
//                        c.setImages(ex.getImgs());
//                        c.setWidth(ex.getWidth());
//                        c.setHeight(ex.getHeight());
//                        c.setPrice(ex.getMaxAuction() == null? ex.getPrice()+"" : ex.getMaxAuction()+"");
//                        c.setAuthPrice(ex.getPrice()+"");
//                        //查找该物品的竞拍次数
//                        GoodsAuctionExample goodsAuctionExample = new GoodsAuctionExample();
//                        goodsAuctionExample.createCriteria().andGoodsIdEqualTo(ex.getId());
//                        int count = goodsAuctionService.countByExample(goodsAuctionExample);
//                        c.setCount(count);
//                    }else{
//                        //超过时间不显示，并且修改他为竞拍失效
//                        ex.setState(0);
//                        goodsService.updateByPrimaryKeySelective(ex);
//                        continue;
//                    }
//            }
//
//            ret.add(c);
//        }
//        return ret;
//    }
//
//    /**
//     * 绝当商城竞拍--出价
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "绝当商城竞拍出价", notes = "登陆")
//    @RequestMapping("/storeJDGoodsJp")
//    @ApiMethod(isLogin = true)
//    public Ret storeJDGoodsJp(MobileInfo mobileInfo,
//                              @ApiParam(value="id",required = true) Integer id,
//                              @ApiParam(value="出价",required = true) String price)throws Exception{
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("goods_id",id);
//
//        Goods goods = goodsService.selectByPrimaryKey(id);
//        //判断是否超时
//        int second = DateUtil.secondsAfter(DateUtil.addMinute(goods.getCreateTime(),(PaidangConst.JD_GOODS_TIME)/60),new Date());
//        if(second < 0){
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//
//        BigDecimal maxPrice = goodsAuctionService.selectMaxPrice(map);
//        if(null != maxPrice){
//            //没人出价，第一次出价
//            if(new BigDecimal(price).compareTo(maxPrice) != 1){
//                //如果出价小于等于最大价格，抛异常
//                throw new ApiException(MEnumError.MAX_PRICE_ERROR);
//            }
//        }
//
//
//        //插入竞拍表 goods_auction
//        GoodsAuction c = new GoodsAuction();
//        c.setGoodsId(id);
//        c.setUserId(mobileInfo.getUserid());
//        c.setPrice(new BigDecimal(price));
//        int result = goodsAuctionService.insert(c);
//        if(result == 0){
//            throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
//        }
//         //更新商品表的最新消息
//        goods.setMaxAutionId(c.getId());
//        goods.setMaxAuction(new BigDecimal(price));
//        goods.setUserId(mobileInfo.getUserid());
//        int result2 = goodsService.updateByPrimaryKey(goods);
//        if(result2 == 0){
//            throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
//        }
//        return ok();
//    }
//
//    /**
//     * 绝当商城详情
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "绝当商城详情", notes = "登陆")
//    @RequestMapping("/storeJDGoodsDetail")
//    @ApiMethod(isLogin = false)
//    public AppJdGoods storeJDGoodsDetail(MobileInfo mobileInfo,
//                                         @ApiParam(value="id",required = true) Integer id)throws Exception{
//        AppJdGoods c = new AppJdGoods();
//        Goods goods = goodsService.selectByPrimaryKey(id);
//        if (goods==null){
//            throw new ApiException(-1,"商品不存在");
//        }
//        PawnOrg pawnOrg=pawnOrgService.selectByPrimaryKey(goods.getOrgId());
////        GoodsAuctionExample goodsAuctionExample = new GoodsAuctionExample();
////        goodsAuctionExample.createCriteria().andGoodsIdEqualTo(id);
////        goodsAuctionExample.setOrderByClause("price asc,create_time desc");
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("goods_id",id);
//        //选出最高价
//        BigDecimal maxPirce = null;
//        List<GoodsAuctionEx> list = goodsAuctionService.selectByAuctionUser(map);
//        c.setSource(goods.getSource());
//        c.setId(goods.getId());
//        c.setImages(goods.getImgs());
//        c.setGoodsName(goods.getName());
//        c.setAuthPrice(goods.getCost()+"");
//        c.setPrice(goods.getPrice()+"");
//        if(0 != list.size()){
//            if(list.size()>1){
//                for(int i = 1;i<list.size();i++){
//                    maxPirce = list.get(0).getPrice();
//                    if(list.get(i-1).getPrice().compareTo(list.get(i).getPrice()) == -1){
//                        maxPirce = list.get(i).getPrice();
//                    }
//                }
//            }else{
//                maxPirce = list.get(0).getPrice();
//            }
//        }
//
//        c.setPrice(maxPirce==null? goods.getPrice()+"":maxPirce+"");
//        long second = DateUtil.secondsAfter(DateUtil.addMinute(goods.getCreateTime(),(PaidangConst.JD_GOODS_TIME)/60),new Date());
//        c.setTime(second+"");
//        c.setGoodsAuctionList(list);
//        c.setContent(getPage(id,1));
//        c.setOrgId(pawnOrg.getId());
//        c.setOrgName(pawnOrg.getName());
//        c.setOrgIntroduction(pawnOrg.getIntroduction());
//        c.setOrgLogo(pawnOrg.getOrgLogo());
//        return c;
//    }
//
//    /**
//     * 首页下的视频列表
//     */
//    @ApiOperation(value = "首页下的视频列表", notes = "不需要登陆")
//    @RequestMapping("/getVideoForIndex")
//    @ApiMethod()
//    public List<AppVideoOnline> getVideoForIndex(){
//        VideoOnlineExample example = new VideoOnlineExample();
//        example.createCriteria().andStateEqualTo(1);
//        example.setOrderByClause("create_time desc");
//        List<VideoOnline> list = videoOnlineService.selectByExample(example);
//
//        List<AppVideoOnline> ret = new ArrayList<AppVideoOnline>();
//        for(VideoOnline ex : list){
//            AppVideoOnline record = new AppVideoOnline();
//            record.setId(ex.getId());
//            record.setTitle(ex.getTitle());
//            record.setImg(ex.getImg());
//            record.setVideo(ex.getVideo()+ PaidangConst.VIDEO_NORMAL);
//            ret.add(record);
//        }
//        return ret;
//    }
//
//    @ApiOperation(value="首页下的列表 ", notes = "不登录")
//    @RequestMapping("/getIndexMenu")
//    @ApiMethod(isPage = false, isLogin = false)
//    public List<ApiIndexMenu> getIndexMenu(MobileInfo mobileInfo){
//        List<ApiIndexMenu> ret = new ArrayList<ApiIndexMenu>();
//        GoodsExample example = new GoodsExample();
//        example.createCriteria().andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2).andTotalGreaterThanOrEqualTo(1);
//        example.setOrderByClause("is_suggest desc,create_time desc");
//        List<Goods> goodsList = goodsService.selectByExample(example);
//        int cnt = 1;
//        int cnt2 = 1;
//        for(Goods ex : goodsList){
//            ApiIndexMenu c = new ApiIndexMenu();
//            if(3 == ex.getSource()){
//                if(cnt <= 6){
//                    //如果是认证商场商品
//                    c.setId(ex.getId());
//                    c.setPrice(ex.getPrice()+"");
//                    c.setImg(ex.getImg());
//                    c.setTitle(ex.getName());
//                    c.setState(1);
//                    if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zb.code)){
//                        c.setGoodsType(MStoreGoodsCateList.zb.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.fc.code)){
//                        c.setGoodsType(MStoreGoodsCateList.fc.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.hty.code)){
//                        c.setGoodsType(MStoreGoodsCateList.hty.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.gdysp.code)){
//                        c.setGoodsType(MStoreGoodsCateList.gdysp.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.sh.code)){
//                        c.setGoodsType(MStoreGoodsCateList.sh.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.cszb.code)){
//                        c.setGoodsType(MStoreGoodsCateList.cszb.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zs.code)){
//                        c.setGoodsType(MStoreGoodsCateList.zs.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.other.code)){
//                        c.setGoodsType(MStoreGoodsCateList.other.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.mqyt.code)){
//                        c.setGoodsType(MStoreGoodsCateList.mqyt.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.ww.code)){
//                        c.setGoodsType(MStoreGoodsCateList.ww.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zx.code)){
//                        c.setGoodsType(MStoreGoodsCateList.zx.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.hlbs.code)){
//                        c.setGoodsType(MStoreGoodsCateList.hlbs.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zml.code)){
//                        c.setGoodsType(MStoreGoodsCateList.zml.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zz.code)){
//                        c.setGoodsType(MStoreGoodsCateList.zz.name);
//                    }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.bx.code)){
//                        c.setGoodsType(MStoreGoodsCateList.bx.name);
//                    }
//                    cnt++;
//                }else{
//                    continue;
//                }
//
//            }else if(2 == ex.getSource()){
//                //如果是绝当商场商品
//                if(ex.getPrice().compareTo(new BigDecimal(30000)) == -1){
//
//                    if(cnt2 <= 4){
//                        //如果他的价格不满三万则是最新绝当商品
//                        c.setId(ex.getId());
//                        c.setImg(ex.getImg());
//                        c.setPrice(ex.getPrice()+"");
//                        c.setTitle(ex.getName());
//                        c.setState(2);
//                        if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zb.code)){
//                            c.setGoodsType(MStoreGoodsCateList.zb.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.fc.code)){
//                            c.setGoodsType(MStoreGoodsCateList.fc.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.hty.code)){
//                            c.setGoodsType(MStoreGoodsCateList.hty.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.gdysp.code)){
//                            c.setGoodsType(MStoreGoodsCateList.gdysp.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.sh.code)){
//                            c.setGoodsType(MStoreGoodsCateList.sh.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.cszb.code)){
//                            c.setGoodsType(MStoreGoodsCateList.cszb.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zs.code)){
//                            c.setGoodsType(MStoreGoodsCateList.zs.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.other.code)){
//                            c.setGoodsType(MStoreGoodsCateList.other.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.mqyt.code)){
//                            c.setGoodsType(MStoreGoodsCateList.mqyt.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.ww.code)){
//                            c.setGoodsType(MStoreGoodsCateList.ww.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zx.code)){
//                            c.setGoodsType(MStoreGoodsCateList.zx.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.hlbs.code)){
//                            c.setGoodsType(MStoreGoodsCateList.hlbs.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zml.code)){
//                            c.setGoodsType(MStoreGoodsCateList.zml.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zz.code)){
//                            c.setGoodsType(MStoreGoodsCateList.zz.name);
//                        }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.bx.code)){
//                            c.setGoodsType(MStoreGoodsCateList.bx.name);
//                        }
//                        cnt2++;
//                    }else{
//                        continue;
//                    }
//                }else{
//                    if(cnt2 <= 4){
//                        //价格超过三万则是最新绝当竞拍
//                        long second = com.base.util.DateUtil.secondsAfter(com.base.util.DateUtil.addMinute(ex.getCreateTime(),(PaidangConst.JD_GOODS_TIME)/60),new Date());
//                        if(second > 0){
//                            c.setId(ex.getId());
//                            c.setEndTime(com.base.util.DateUtil.dateToStr(com.base.util.DateUtil.addHour(ex.getCreateTime(),24)));
//                            c.setEndTime2(second+"");
//                            c.setImg(ex.getImg());
//                            c.setTitle(ex.getName());
//                            c.setPrice(ex.getPrice()+"");
//                            //查找该物品的竞拍次数
//                            GoodsAuctionExample goodsAuctionExample = new GoodsAuctionExample();
//                            goodsAuctionExample.createCriteria().andGoodsIdEqualTo(ex.getId());
//                            int count = goodsAuctionService.countByExample(goodsAuctionExample);
//                            c.setAucCount(count);
//                            c.setState(3);
//                            if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zb.code)){
//                                c.setGoodsType(MStoreGoodsCateList.zb.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.fc.code)){
//                                c.setGoodsType(MStoreGoodsCateList.fc.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.hty.code)){
//                                c.setGoodsType(MStoreGoodsCateList.hty.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.gdysp.code)){
//                                c.setGoodsType(MStoreGoodsCateList.gdysp.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.sh.code)){
//                                c.setGoodsType(MStoreGoodsCateList.sh.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.cszb.code)){
//                                c.setGoodsType(MStoreGoodsCateList.cszb.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zs.code)){
//                                c.setGoodsType(MStoreGoodsCateList.zs.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.other.code)){
//                                c.setGoodsType(MStoreGoodsCateList.other.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.mqyt.code)){
//                                c.setGoodsType(MStoreGoodsCateList.mqyt.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.ww.code)){
//                                c.setGoodsType(MStoreGoodsCateList.ww.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zx.code)){
//                                c.setGoodsType(MStoreGoodsCateList.zx.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.hlbs.code)){
//                                c.setGoodsType(MStoreGoodsCateList.hlbs.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zml.code)){
//                                c.setGoodsType(MStoreGoodsCateList.zml.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.zz.code)){
//                                c.setGoodsType(MStoreGoodsCateList.zz.name);
//                            }else if(ex.getCateCode().toString().equals(MStoreGoodsCateList.bx.code)){
//                                c.setGoodsType(MStoreGoodsCateList.bx.name);
//                            }
//                            cnt2++;
//                        }else{
//                            //超过时间不显示，并且修改他为竞拍失效
//                            ex.setState(0);
//                            goodsService.updateByPrimaryKeySelective(ex);
//                            continue;
//                        }
//                    }else{
//                        continue;
//                    }
//
//                }
//            }
//            ret.add(c);
//        }
//        return ret;
//
//    }
//
//}
