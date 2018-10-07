//package com.api.action;
//
//import com.api.util.PageLimit;
//import com.base.api.ApiBaseController;
//import com.base.api.annotation.ApiMethod;
//import com.base.dialect.PaginationSupport;
//import com.item.dao.model.UserComment;
//import com.paidang.dao.model.Goods;
//import com.paidang.dao.model.GoodsExample;
//import com.paidang.dao.model.PawnOrg;
//import com.paidang.service.GoodsService;
//import com.paidang.service.PawnOrgService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @param
// * @Auther: xuwenwei
// * @Date: 2018/8/3 15:48
// * @Description:
// */
//@RestController
//@RequestMapping(value = "/api/pawnOrg", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
//@Api(tags = "店铺详情")
//public class ApiPawnOrgController extends ApiBaseController {
//
//    @Autowired
//    private PawnOrgService pawnOrgService;
//
//    @Autowired
//    private GoodsService goodsService;
//
//    @ApiOperation(value = "店铺详情", notes = "不用登陆")
//    @RequestMapping(value = "/get", method = RequestMethod.POST)
//    @ApiMethod(isLogin = false)
//    public Object get(@ApiParam(value = "机构id", required = true) Integer orgId) {
//        PawnOrg pawnOrg = pawnOrgService.selectByPrimaryKey(orgId);
//        pawnOrg.setPassword(null);
//        return pawnOrg;
//    }
//
//
//    /**
//     * 店铺销量前三的商品
//     */
//
//    @ApiOperation(value = "店铺销量前3商品", notes = "不用登陆")
//    @RequestMapping(value = "/getMostThreeGoods", method = RequestMethod.POST)
//    @ApiMethod(isLogin = false)
//    public Object getMostThreeGoods(@ApiParam(value = "机构id", required = true) Integer orgId) {
//        return goodsService.getMostThreeGoods(orgId);
//    }
//
//
//    /**
//     * 获取该店铺所有商品的api
//     */
//    @ApiOperation(value = "店铺所有商品", notes = "不用登陆")
//    @RequestMapping(value = "/getGoodsByOrg", method = RequestMethod.POST)
//    @ApiMethod(isLogin = false)
//    public Object getGoodsByOrg(@ApiParam(value = "机构id", required = true) Integer orgId, PageLimit pageLimit,@ApiParam(value = "搜索类型0全部1新品", required = false)Integer type) {
//        if (type==null){
//            type=0;
//        }
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
//        GoodsExample goodsExample=new GoodsExample();
//        goodsExample.createCriteria().andOrgIdEqualTo(orgId).andIsOnlineEqualTo(1).andIsVerfiyEqualTo(2);
//        if (type==1){
//            goodsExample.setOrderByClause("create_time desc");
//        } else {
//            goodsExample.setOrderByClause("sold_out desc");
//        }
//        return goodsService.selectByExample(goodsExample);
//
//    }
//
//}
