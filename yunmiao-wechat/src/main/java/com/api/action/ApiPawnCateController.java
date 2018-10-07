//package com.api.action;
//
//import com.api.view.pawnCate.AppPawnCate;
//import com.base.api.ApiBaseController;
//import com.base.api.annotation.ApiMethod;
//import com.paidang.dao.model.PawnCate;
//import com.paidang.dao.model.PawnCateExample;
//import com.paidang.service.PawnCateService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/pawnCateList", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
//@Api(tags = "鉴定类型(用户端)")
//public class ApiPawnCateController extends ApiBaseController {
//
//    @Autowired
//    private PawnCateService pawnCateService;
//
//
//    @ApiOperation(value = "鉴定类型", notes = "分页")
//    @RequestMapping("/pawnCateList")
//    @ApiMethod(isPage = false, isLogin = false)
//    public List<AppPawnCate> pawnCateList(){
//        System.out.println("1.0");
//        PawnCateExample example = new PawnCateExample();
//        example.createCriteria();
//        example.setOrderByClause("sort_order asc,create_time desc");
//        List<PawnCate> list = pawnCateService.selectByExample(example);
//
//        List<AppPawnCate> list2 = new ArrayList<AppPawnCate>();
//
//        for(PawnCate ex : list){
//            AppPawnCate record = new AppPawnCate();
//            record.setId(ex.getId());
//            record.setCode(Integer.parseInt(ex.getCode()));
//            record.setIcon(ex.getIcon());
//            record.setName(ex.getName());
//            record.setCateType(ex.getCateType());
//            list2.add(record);
//        }
//        return list2;
//    }
//
////    @ApiOperation(value = "鉴定类型v2", notes = "v2")
////    @RequestMapping("/pawnCateList")
////    @ApiMethod(isPage = false, isLogin = false, version = 2)
////    public List<AppPawnCate> pawnCateListV2(){
////        System.out.println("2.0");
////        PawnCateExample example = new PawnCateExample();
////        example.createCriteria();
////        example.setOrderByClause("sort_order asc,create_time desc");
////        List<PawnCate> list = pawnCateService.selectByExample(example);
////
////        List<AppPawnCate> list2 = new ArrayList<AppPawnCate>();
////
////        for(PawnCate ex : list){
////            AppPawnCate record = new AppPawnCate();
////            record.setId(ex.getId());
////            record.setCode(Integer.parseInt(ex.getCode()));
////            record.setIcon(ex.getIcon());
////            record.setName(ex.getName());
////            record.setCateType(ex.getCateType());
////            list2.add(record);
////        }
////        return list2;
////    }
//}
