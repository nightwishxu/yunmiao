//package com.api.action;
//
//import com.api.MErrorEnum;
//import com.api.view.userInfoIsBind.AppUserInfoIsBind;
//import com.base.CoreConstants;
//import com.base.api.ApiBaseController;
//import com.base.api.ApiException;
//import com.base.api.MobileInfo;
//import com.base.api.annotation.ApiMethod;
//import com.base.dao.model.BFile;
//import com.base.dao.model.Ret;
//import com.base.service.BFileService;
//import com.base.util.StringUtil;
//import com.item.dao.model.User;
//import com.item.service.UserService;
//import com.util.face.FacePlusUtil;
//import com.util.face.FaceYouTuUtil;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.File;
//
//@RestController
//@RequestMapping(value = "/api/userFace", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
//@Api(tags = "人脸识别+身份证绑定(用户端)")
//public class ApiUserFaceController extends ApiBaseController {
//    @Autowired
//    private BFileService bFileService;
//    @Autowired
//    private UserService userService;
//
////    @ApiOperation(value = "人脸录入", notes = "登陆")
////    @RequestMapping("/updateMyFace")
////    @ApiMethod(isPage = false, isLogin = true)
////    public Ret updateMyFace(MobileInfo mobileInfo,
////                            //@ApiParam(value = "摇一摇图片id", required = true) String headShake,
////                            //@ApiParam(value = "点点头图片id", required = true) String headNod,
////                            //@ApiParam(value = "眨眼睛图片id", required = true) String headEye
////                             @ApiParam(value = "图片id", required = true) String headImage) {
////        User user = userService.selectByPrimaryKey(mobileInfo.getUserid());
////        user.setHeadShake(headImage);
////
////        int result = userService.updateByPrimaryKeySelective(user);
////        if (result == 0) {
////            throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
////        }
////        return ok();
////    }
//
//
//    @ApiOperation(value = "人脸识别", notes = "登陆")
//    @RequestMapping("/userFace")
//    @ApiMethod(isPage = false, isLogin = true)
//    public Ret userFace(MobileInfo mobileInfo,
//                            @ApiParam(value = "图片", required = true) String image) {
//        //初始化状态为识别失败
//
//        User user = userService.selectByPrimaryKey(mobileInfo.getUserid());
//
//        //判断人脸是否已经录入
//        if(1 != user.getIsBind()){
//            throw new ApiException(-1,"请先录入身份证");
//        }
//
//        BFile ex = bFileService.selectByPrimaryKey(image);
//        File file1 = new File(CoreConstants.FILE_PATH+ex.getFilePath());
//        File file2 = null;
//        BFile file = null;
//        file = bFileService.selectByPrimaryKey(user.getHeadShake());
//
//        file2 = new File(CoreConstants.FILE_PATH+file.getFilePath());
//
//       // float p = FaceYouTuUtil.compare(file1, file2);
//        float p =FacePlusUtil.compare(file1,file2);
//        System.out.println("人脸识别配对比例："+p);
//        if (p < 60) {
//            throw new ApiException(-1,"人脸识别失败");
//        }
//        return new Ret(1,p);
//    }
//
////    @ApiOperation(value = "人脸是否已经识别过(1已经录入过 2未识别过),   身份证是否已经绑定(1已绑定  2未绑定)", notes = "登陆")
////    @RequestMapping("/isFaceAuth")
////    @ApiMethod(isPage = false, isLogin = true)
////    public AppUserInfoIsBind isFaceAuth(MobileInfo mobileInfo){
////        AppUserInfoIsBind appUserInfoIsBind = new AppUserInfoIsBind();
////        User user = userService.selectByPrimaryKey(mobileInfo.getUserid());
////        if(StringUtil.isBlank(user.getHeadShake())){
////            appUserInfoIsBind.setFaceBind(2);
////        }
////        if(0 == user.getIsBind()){
////            appUserInfoIsBind.setIdCardBind(2);
////        }
////        appUserInfoIsBind.setFaceBind(1);
////        appUserInfoIsBind.setIdCardBind(1);
////        return appUserInfoIsBind;
////    }
//
//    @ApiOperation(value = "去绑定用户信息--人脸识别+身份证正面", notes = "登陆")
//    @RequestMapping("/bindUserMsg")
//    @ApiMethod(isLogin = true)
//    public Ret bindUserMsg(MobileInfo mobileInfo,
//                          @ApiParam(value = "身份证正面", required = true) String idCardImg,
//                           @ApiParam(value = "身份证反面", required = true) String idCardReverse,
//                          @ApiParam(value = "人脸图片", required = true) String headImage,
//                           @ApiParam(value = "用户姓名", required = true) String userName,
//                           @ApiParam(value = "用户身份证号码", required = true) String idCard){
//        User user = userService.selectByPrimaryKey(mobileInfo.getUserid());
//
//        //判断是否已经绑定身份证和是否已经录入人脸
//        if(StringUtil.isNotBlank(user.getIdCardImg()) || StringUtil.isNotBlank(user.getHeadShake())){
//            throw new ApiException(-1,"绑定状态出现异常，请联系客户人员");
//        }
//
//        //身份证正面
//        user.setIdCardImg(idCardImg);
//
//        //身份证反面
//        user.setIdCardReverse(idCardReverse);
//
//
//        //人脸录入
//        user.setHeadShake(headImage);
//
//        //录入身份证
//        user.setIdCard(idCard);
//        user.setName(userName);
//
//        user.setIsBind(1);
//
//        //获取身份证正面图片
//        BFile idImage = bFileService.selectByPrimaryKey(user.getIdCardImg());
//        File file1 = new File(CoreConstants.FILE_PATH+idImage.getFilePath());
//
//        //获取人脸录入图片
//        BFile headShake = bFileService.selectByPrimaryKey(user.getHeadShake());
//        File file = new File(CoreConstants.FILE_PATH+headShake.getFilePath());
//
//        float p = FacePlusUtil.compare(file, file1);
//        System.out.println("人脸与身份证返回配对："+p);
////        if (p < 10) {
////            System.out.println("-----------------"+p);
////            throw new ApiException(-1,"照片与身份证不匹配");
////        }
//
//        int result = userService.updateByPrimaryKeySelective(user);
//        if(result == 0){
//            throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
//        }
//
//        return ok();
//    }
//
//}
