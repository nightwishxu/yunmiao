package com.api.wxaction;

import ch.qos.logback.core.util.DatePatternToRegexUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.MErrorEnum;
import com.api.view.home.*;
import com.api.view.store.AppJdGoodsAuc;
import com.api.view.store.AppMyStoreGoods;
import com.api.view.user.AppUserCapital;
import com.base.util.BeanUtils;
import com.base.util.JSONUtils;
import com.item.dao.model.*;
import com.item.daoEx.model.UserEx;
import com.item.service.*;
import com.paidang.dao.model.*;
import com.paidang.daoEx.model.*;
import com.paidang.service.*;
import com.util.ApiStoreBankUtil;
import com.util.PaidangConst;
import com.util.apiStore.BankCardResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import org.dom4j.util.UserDataDocumentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.MEnumError;
import com.api.util.PageLimit;
import com.base.api.ApiBaseController;
import com.base.api.ApiException;
import com.base.api.MobileInfo;
import com.base.api.annotation.ApiMethod;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.util.DateUtil;
import com.base.util.StringUtil;

@RestController
@RequestMapping(value = "/api/home", produces = {"application/json;charset=UTF-8"})
@Api(tags = "用户个人中心")
public class ApiHomeController extends ApiBaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserNotifyService userNotifyService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserFollowService userFollowService;

    @Autowired
    private CollectPraiseService collectPraiseService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private WxUserInfoService wxUserInfoService;

    @Autowired
    private WxUserNotifyService wxUserNotifyService;

    @Autowired
    private PlatformAuthenticationApplyService platformAuthenticationApplyService;

    @Autowired
    private UserWorksService userWorksService;
    /**
     * 个人资料
     */
    @ApiOperation(value = "个人资料*", notes = "登陆")
    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public UserInfo getUserInfo(MobileInfo mobileInfo) {
        User record = userService.selectByPrimaryKey(mobileInfo.getUserid());
        if (record == null) {
            throw new ApiException(MEnumError.USER_NOEXIST_ERROR);
        }
        UserInfo userInfo = new UserInfo();
        try {
            BeanUtils.copyProperties(record,userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    /**
     * 修改个人资料
     */
    @ApiOperation(value = "修改个人资料*", notes = "登陆")
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public UserInfo editUser(MobileInfo mobileInfo, UserInfo userInfo) {
        boolean update = false;
        User temp = new User();
        temp.setId(mobileInfo.getUserid());
        userInfo.setId(mobileInfo.getUserid());
        if (StringUtil.isNotBlank(userInfo.getHeadImg())) {
            update = true;
            temp.setHeadImg(userInfo.getHeadImg());
        }
//        if(StringUtil.isNotBlank(userInfo.getIdCardReverse())){
//            update = true;
//            temp.setIdCardReverse(userInfo.getIdCardReverse());
//        }
        if (StringUtil.isNotBlank(userInfo.getNickName())) {
            update = true;
            // 校验登录
            UserExample example = new UserExample();
            example.createCriteria().andNickNameEqualTo(userInfo.getNickName());
            int i = userService.countByExample(example);
            if (i > 0) {
                throw new ApiException(MEnumError.NICK_EXISTS_ERROR);
            }
            temp.setNickName(userInfo.getNickName());
        }
        if (StringUtil.isNotBlank(userInfo.getAddress())) {
            update = true;
            temp.setAddress(userInfo.getAddress());
        }

        if (userInfo.getSex()!=null) {
            update = true;
            temp.setSex(userInfo.getSex());
        }
        if (StringUtil.isNotBlank(userInfo.getSignature())) {
            update = true;
            temp.setSignature(userInfo.getSignature());
        }
        if (update) {
            //更新
            userService.updateByPrimaryKeySelective(temp);
        }
        temp = userService.selectByPrimaryKey(mobileInfo.getUserid());
        if (temp != null){
            try {
                BeanUtils.copyProperties(temp,userInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return userInfo;
    }






    @ApiOperation(value = "个人主页*", notes = "登陆")
    @RequestMapping(value = "/homePage", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public UserInfo userHomePage(MobileInfo mobileInfo,@ApiParam(value = "用户id", required = true) Integer userId) {
        User record = userService.selectByPrimaryKey(userId);
        if (record == null) {
            throw new ApiException(MEnumError.USER_NOEXIST_ERROR);
        }
        UserInfo userInfo = new UserInfo();
        try {
            BeanUtils.copyProperties(record,userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArticleExample articleExample=new ArticleExample();
        articleExample.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(2);
        List<Article> articles =articleService.selectByExample(articleExample);
        if (articles!=null && articles.size()>0){
            userInfo.setArticles(articles);
            Integer praiseCount=0;
            for (Article article:articles){
                praiseCount+=article.getPraiseCount();
            }
            userInfo.setPraiseCount(praiseCount);
        }
        WxUserInfo wxUserInfo=wxUserInfoService.selectByPrimaryKey(userId);
        //用户关注数
//        Integer followCount =userFollowService.getUserFollowCount(userId);
        userInfo.setFollowCount(wxUserInfo.getFollowCount());
        //用户粉丝数
//        Integer userFansCount=userFollowService.getUserFansCount(userId);
        userInfo.setFansCount(wxUserInfo.getFansCount());
        userInfo.setIsFollow(userFollowService.getIsFollow(mobileInfo.getUserid(),userId)==0?0:1);
        return userInfo;
    }



    @ApiOperation(value = "获赞与收藏", notes = "登陆,分页")
    @RequestMapping(value = "/collectPraise/list", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object getCollectPraise(MobileInfo mobileInfo) {

        CollectPraiseExample example=new CollectPraiseExample();
        example.setOrderByClause("create_time desc");
        example.createCriteria().andAuthorIdEqualTo(mobileInfo.getUserid());
        List<CollectPraise> list=collectPraiseService.selectByExample(example);
        return list;
    }


    @ApiOperation(value = "评价", notes = "登陆")
    @RequestMapping(value = "/comment/list", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object getUserComment(MobileInfo mobileInfo) {

        CommentExample example=new CommentExample();
        example.setOrderByClause("create_time desc");
        example.createCriteria().andAuthorIdEqualTo(mobileInfo.getUserid());
        List<Comment> list=commentService.selectByExample(example);
        return list;
    }


    @ApiOperation(value = "用户赞过的和我的收藏", notes = "登陆,分页")
    @RequestMapping(value = "/userPraise/list", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object userPraise(MobileInfo mobileInfo,@ApiParam(value = "0用户赞过的1用户收藏", required = true) Integer type) {
        if (type!=0 && type!=1){
            throw new ApiException("type参数非法");
        }
        CollectPraiseExample example=new CollectPraiseExample();
        example.setOrderByClause("create_time desc");
        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andTypeEqualTo(type);
        List<CollectPraise> list=collectPraiseService.selectByExample(example);
        if (list!=null && list.size()>0){
            List<Integer> ids=new ArrayList<>();
            for (CollectPraise cp:list){
                ids.add(cp.getArticleId());
            }
            ArticleExample articleExample=new ArticleExample();
            articleExample.setOrderByClause("create_time desc");
            articleExample.createCriteria().andIdIn(ids).andStatusEqualTo(2);
            return articleService.selectByExample(articleExample);
        }
        return null;
    }



    @ApiOperation(value = "我的关注", notes = "登陆,分页")
    @RequestMapping(value = "/userFollow/list", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object userFollow(MobileInfo mobileInfo) {
        return userService.getUserFollow(mobileInfo.getUserid());
    }



    @ApiOperation(value = "我的关注-可能感兴趣的人", notes = "登陆,分页")
    @RequestMapping(value = "/userFollow/list", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object userFollowInterest(MobileInfo mobileInfo) {
        List<UserEx> list=userService.getUserFollowInterest(mobileInfo.getUserid());
        if (list!=null && list.size()>0){
            return list;
        }else {
            return userService.getUserFollowInterestByFans(mobileInfo.getUserid());
        }
    }





    @ApiOperation(value = "通知", notes = "登陆,分页")
    @RequestMapping(value = "/userNotify/list", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object userNotify(MobileInfo mobileInfo,@ApiParam(value = "1未读2已读", required = false) Integer status) {
        WxUserNotifyExample example=new WxUserNotifyExample();
        example.setOrderByClause("create_time desc");
        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andStatusEqualTo(status);
        return wxUserNotifyService.selectByExample(example);
    }

    @ApiOperation(value = "阅读通知", notes = "登陆")
    @RequestMapping(value = "/userNotify/update", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object userNotifyRead(MobileInfo mobileInfo,@ApiParam(value = "通知id", required = true) Integer id) {
        WxUserNotify entity=new WxUserNotify();
        entity.setId(id);
        entity.setStatus(2);
        return wxUserNotifyService.updateByPrimaryKeySelective(entity);
    }


    @ApiOperation(value = "非遗认证申请", notes = "登陆")
    @RequestMapping(value = "/platformAuthentication/apply", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object platformAuthenticationApply(MobileInfo mobileInfo,
                                              @ApiParam(value = "非遗类目", required = true) String heritageType,
                                              @ApiParam(value = "真实姓名", required = true) String realName,
                                              @ApiParam(value = "身份证号", required = true) String idCard,
                                              @ApiParam(value = "身份证正面", required = true) String idCardImg,
                                              @ApiParam(value = "身份证反面", required = true) String idCardReverse,
                                              @ApiParam(value = "申请时间格式2018-10-20", required = true) String applyTime,
                                              @ApiParam(value = "地域", required = true) String address,
                                              @ApiParam(value = "作品json格式字符串例：{id1:price1,id2:price2}", required = true) String works
    ) {
        List<Integer> status=new ArrayList<>();
        status.add(0);
        status.add(1);
        PlatformAuthenticationApplyExample example=new PlatformAuthenticationApplyExample();
        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andStatusIn(status);
        List<PlatformAuthenticationApply> list=platformAuthenticationApplyService.selectByExample(example);
        if (list!=null && list.size()>0){
            if (list.get(0).getStatus()==0){
                throw new ApiException("非遗认证正在认证过程中,请等待");
            }else if(list.get(0).getStatus()==1){
                throw new ApiException("非遗认证已通过");
            }

        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        User user=userService.selectByPrimaryKey(mobileInfo.getUserid());
        PlatformAuthenticationApply apply=new PlatformAuthenticationApply();
        apply.setAccount(user.getAccount());
        apply.setAddress(address);
        apply.setCreateTime(new Date());
        apply.setIdCard(idCard);
        apply.setNickName(user.getNickName());
        apply.setUserId(user.getId());
        apply.setHeritageType(heritageType);
        apply.setIdCardImg(idCardImg);
        apply.setRealName(realName);
        apply.setIdCardReverse(idCardReverse);
        apply.setStatus(0);
        user.setPlatformAuthentication(1);
        try {
            apply.setApplyTime(sdf.parse(applyTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int num=platformAuthenticationApplyService.insert(apply);
        Map<String,Object> map=JSONUtils.deserialize(works,Map.class);
        for(Map.Entry<String,Object> entry:map.entrySet()){
            UserWorks entity=new UserWorks();
            entity.setApplyId(apply.getId());
            entity.setCreateTime(new Date());
            entity.setImg(entry.getKey());
            entity.setPrice(new BigDecimal((String)entry.getValue()));
            entity.setStatus(1);
            entity.setUserId(user.getId());
            userWorksService.insert(entity);
        }
        userService.updateByPrimaryKeySelective(user);
        return num;
    }


    @ApiOperation(value = "实名认证申请", notes = "登陆")
    @RequestMapping(value = "/realNameAuthentication/apply", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object realNameAuthenticationApply(MobileInfo mobileInfo,
                                              @ApiParam(value = "真实姓名", required = true) String realName,
                                              @ApiParam(value = "身份证号", required = true) String idCard,
                                              @ApiParam(value = "身份证正面", required = true) String idCardImg,
                                              @ApiParam(value = "身份证反面", required = true) String idCardReverse,
                                              @ApiParam(value = "证件类型", required = true) String cardType

    ) {
        User user=userService.selectByPrimaryKey(mobileInfo.getUserid());
        if (user.getRealNameAuthentication()==1){
            throw new ApiException("实名认证正在认证中，请等待");
        }
        if (user.getRealNameAuthentication()==2){
            throw new ApiException("实名认证已认证成功");
        }
        User entity=new User();
        entity.setTrueName(realName);
        entity.setId(mobileInfo.getUserid());
        entity.setIdCard(idCard);
        entity.setIdCardImg(idCardImg);
        entity.setIdCardReverse(idCardReverse);
        entity.setCardType(cardType);
        entity.setUpdateTime(new Date());
        return userService.updateByPrimaryKeySelective(entity);
    }


//
//    /**
//     * 获取用户未读消息数量
//     */
//    @ApiOperation(value = "获取用户未读消息数量", notes = "登陆")
//    @RequestMapping(value = "/getUserIsReadCount", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public UserIsReadCountInfo getUserIsReadCount(MobileInfo mobileInfo) {
//        int count = 0;
//        UserNotifyExample example = new UserNotifyExample();
//        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andIsReadEqualTo(0);
//        count = userNotifyService.countByExample(example);
//        UserIsReadCountInfo userIsReadCountInfo = new UserIsReadCountInfo();
//        userIsReadCountInfo.setCount(count);
//        return userIsReadCountInfo;
//    }
//
//    /**
//     * 获取用户消息列表
//     */
//    @ApiOperation(value = "获取用户消息列表", notes = "登陆,分页")
//    @RequestMapping(value = "/getUserMsgList", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true, isPage = true)
//    public List<UserNotifyInfo> getUserMsgList(MobileInfo mobileInfo,
//                                               PageLimit pageLimit) {
//        UserNotifyExample example = new UserNotifyExample();
//        example.setOrderByClause("create_time desc");
//        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid());
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(), false);
//        List<UserNotify> list = userNotifyService.selectByExample(example);
//        return getAppInfo(list);
//    }
//
//    /**
//     * 封装返回用户列表数据
//     *
//     * @param list
//     * @return
//     */
//    private List<UserNotifyInfo> getAppInfo(List<UserNotify> list) {
//        List<UserNotifyInfo> ret = new ArrayList<>(list.size());
//        for (UserNotify ex : list) {
//            ret.add(getAppInfo(ex));
//        }
//        return ret;
//    }
//
//    /**
//     * 封装返回UserNotifyInfo
//     *
//     * @param ex
//     * @return
//     */
//    private UserNotifyInfo getAppInfo(UserNotify ex) {
//        UserNotifyInfo mini = new UserNotifyInfo();
//        mini.setId(ex.getId());
//        mini.setTitle(ex.getTitle());
//        mini.setContent(ex.getContent());
//        mini.setCreateTime(DateUtil.dateToStr(ex.getCreateTime()));
//        mini.setType(ex.getType());
//        mini.setRedirectType(ex.getRedirectType());
//        mini.setRedirectContent(ex.getRedirectContent());
//        mini.setCreateTime(DateUtil.dateToStr(ex.getCreateTime()));
//        return mini;
//    }
//
//    /**
//     * 用户点击详情
//     */
//    @ApiOperation(value = "用户点击详情", notes = "可以不登陆")
//    @RequestMapping(value = "/enterUserNotifyDetail", method = RequestMethod.POST)
//    @ApiMethod
//    public UserNotifyInfo enterUserNotifyDetail(MobileInfo mobileInfo,
//                                                @ApiParam(value = "消息id", required = true) Integer id) {
//        if (id == null) {
//            throw new ApiException("id");
//        }
//        UserNotify ex = userNotifyService.selectByPrimaryKey(id);
//        if (ex == null) {
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//        UserNotifyInfo record = new UserNotifyInfo();
//        record.setTitle(ex.getTitle());
//        record.setId(ex.getId());
//        record.setType(ex.getType());
//        record.setContent(ex.getContent());
//        record.setRedirectType(ex.getRedirectType());
//        record.setIsRead(ex.getIsRead());
//        if (mobileInfo.getUserid() != null) {
//
//            ex.setIsRead(1);
//            userNotifyService.updateByPrimaryKey(ex);
//        }
//        return record;
//    }




//    /**
//     * 我的银行卡列表
//     */
//    @ApiOperation(value = "我的银行卡管理*", notes = "登陆")
//    @RequestMapping(value = "/myBankCardList", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public List<ApiUserBankCard> myBankCardList(MobileInfo mobileInfo) {
//        UserBankCardExample example = new UserBankCardExample();
//        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid());
//        example.setOrderByClause("create_time desc");
//        List<UserBankCard> list = userBankCardService.selectByExample(example);
//        List<ApiUserBankCard> list2 = new ArrayList<ApiUserBankCard>();
//        for (UserBankCard ex : list) {
//            ApiUserBankCard record = new ApiUserBankCard();
//            record.setId(ex.getId());
//            record.setBankCardNo(ex.getBankCardNo());
//            record.setBankCardName(ex.getBankCardName());
//            record.setIsDefault(ex.getIsDefault());
//            list2.add(record);
//        }
//        return list2;
//    }
//
//    /**
//     * 删除我银行卡
//     *
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "删除我银行卡", notes = "登陆")
//    @RequestMapping(value = "/updateMyBankCard", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret updateMyBankCard(MobileInfo mobileInfo,
//                                @ApiParam(value = "id", required = true) Integer id) {
//
//        int result = userBankCardService.deleteByPrimaryKey(id);
//        if (result == 0) {
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//
//        return ok();
//    }
//
//    /**
//     * 设置我的银行卡为默认银行卡
//     *
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "设置我的银行卡为默认银行卡", notes = "登陆")
//    @RequestMapping(value = "/setDefBankCard", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret setDefBankCard(MobileInfo mobileInfo,
//                              @ApiParam(value = "id", required = true) Integer id) {
//        UserBankCardExample example = new UserBankCardExample();
//        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid());
//        UserBankCard userBankCard = new UserBankCard();
//        userBankCard.setIsDefault(0);
//        int result = userBankCardService.updateByExampleSelective(userBankCard, example);
//        if (result == 0) {
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//
//        userBankCard.setIsDefault(1);
//        userBankCard.setId(id);
//        int result2 = userBankCardService.updateByPrimaryKeySelective(userBankCard);
//        if (result2 == 0) {
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//
//        return ok();
//
//    }
//
//    /**
//     * 添加银行卡
//     *
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "添加银行卡", notes = "登陆")
//    @RequestMapping(value = "/addMyBankCard", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret addMyBankCard(MobileInfo mobileInfo,
//                             @ApiParam(value = "银行卡号", required = true) String bankCardNo,
//                             @ApiParam(value = "预留手机号", required = true) String account,
//                             @ApiParam(value = "姓名", required = true) String userName,
//                             @ApiParam(value = "身份证号", required = true) String idCard) {
//        Ret ret = new Ret();
//        User user = userService.selectByPrimaryKey(mobileInfo.getUserid());
//
//
//        //银行卡验证--借记卡
//        BankCardResult bankCardResult = ApiStoreBankUtil.verifyDC(userName, account, idCard, bankCardNo);
//        if (null == bankCardResult) {
//            throw new ApiException(MEnumError.BANKCARD_BIND_ERROR);
//        }
//        System.out.println(bankCardResult.getRealName());
//
//        if (0 == user.getIsBind()) {
//            ret.setCode(-1);
//            ret.setMsg("身份证未绑定，请先绑定身份证");
//        }
////		if(user.getIdCard() == ){
////			return ok();
////		}
//
////        if(!user.getName().equals(userName)){
////            throw new ApiException(MEnumError.NAME_ERROE);
////        }
//
//        UserBankCard record = new UserBankCard();
//        record.setUserId(mobileInfo.getUserid());
//        record.setBankLogo(bankCardResult.getInformation().getBankimage());
//        record.setBankCardType(1);
//        record.setBankCardNo(bankCardNo);
//        record.setBankCardName(bankCardResult.getInformation().getBankname());
//        record.setBankCardPhone(account);
//        record.setBankCardIdCard(idCard);
//        record.setIsDefault(0);
//
//        int result = userBankCardService.insert(record);
//        if (result == 0) {
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//
//        return ok();
//
//    }
//
//    /**
//     * 我的地址列表
//     */
//    @ApiOperation(value = "我的地址管理*", notes = "登陆")
//    @RequestMapping(value = "/myAddressList", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public List<AppUserAddress> myAddressList(MobileInfo mobileInfo) {
//        UserAddressExample example = new UserAddressExample();
//        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid());
//        example.setOrderByClause("is_default desc, create_time desc");
//        List<UserAddress> list = userAddressService.selectByExample(example);
//        List<AppUserAddress> list2 = new ArrayList<AppUserAddress>();
//        for (UserAddress ex : list) {
//            AppUserAddress record = new AppUserAddress();
//            record.setId(ex.getId());
//            record.setAddress(ex.getAddress());
//            record.setArea(ex.getArea());
//            record.setIs_default(ex.getIsDefault());
//            record.setName(ex.getUserName());
//            record.setPhone(ex.getPhone());
//            list2.add(record);
//        }
//
//        return list2;
//    }
//
//    /**
//     * 修改或删除我的地址
//     *
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "修改我的地址", notes = "登陆")
//    @RequestMapping(value = "/updateMyAddress", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret updateMyAddress(MobileInfo mobileInfo,
//                               @ApiParam(value = "id", required = true) Integer id,
//                               @ApiParam(value = "新省市区", required = true) String area,
//                               @ApiParam(value = "新详细地址", required = true) String address,
//                               @ApiParam(value = "收件人名字", required = true) String userName,
//                               @ApiParam(value = "收件人电话", required = true) String phone,
//                               @ApiParam(value = "操作1修改 2删除", required = true) Integer type) {
//        if (1 == type) {
//            UserAddress userAddress = new UserAddress();
//            userAddress.setId(id);
//            userAddress.setUserName(userName);
//            userAddress.setPhone(phone);
//            userAddress.setArea(area);
//            userAddress.setAddress(address);
//            int result = userAddressService.updateByPrimaryKeySelective(userAddress);
//            if (result == 0) {
//                throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//            }
//        } else if (2 == type) {
//            int result = userAddressService.deleteByPrimaryKey(id);
//            if (result == 0) {
//                throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//            }
//        }
//
//        return ok();
//    }
//
//
//    /**
//     * 设置我的地址为默认地址
//     *
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "设置我的地址为默认地址", notes = "登陆")
//    @RequestMapping(value = "/setDefAddress", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret setDefAddress(MobileInfo mobileInfo,
//                             @ApiParam(value = "id", required = true) Integer id) {
//        UserAddressExample userAddressExample = new UserAddressExample();
//        userAddressExample.createCriteria().andUserIdEqualTo(mobileInfo.getUserid());
//        UserAddress address = new UserAddress();
//        address.setIsDefault(0);
//        int result = userAddressService.updateByExampleSelective(address, userAddressExample);
//        if (result == 0) {
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//
//        address.setIsDefault(1);
//        address.setId(id);
//        int result2 = userAddressService.updateByPrimaryKeySelective(address);
//        if (result2 == 0) {
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//
//        return ok();
//
//    }
//
//    /**
//     * 添加地址
//     *
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "添加地址", notes = "登陆")
//    @RequestMapping(value = "/addMyAddress", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret addMyAddress(MobileInfo mobileInfo,
//                            @ApiParam(value = "收件人名字", required = true) String userName,
//                            @ApiParam(value = "收件人联系方式", required = true) String phone,
//                            @ApiParam(value = "省市区", required = true) String area,
//                            @ApiParam(value = "详细地址", required = true) String address) {
//        UserAddress record = new UserAddress();
//        record.setUserId(mobileInfo.getUserid());
//        record.setUserName(userName);
//        record.setArea(area);
//        record.setAddress(address);
//        record.setIsDefault(0);
//        record.setPhone(phone);
//
//        int result = userAddressService.insert(record);
//        if (result == 0) {
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//
//        return ok();
//
//    }
//
////	@ApiOperation(value = "绑定身份证",notes="登陆")
////	@RequestMapping(value="/bindIdCard", method = RequestMethod.POST)
////	@ApiMethod(isLogin = true)
////	public Ret bindIdCard(MobileInfo mobileInfo,
////						  @ApiParam(value = "身份证正面", required = true)String idCardImage,
////						  @ApiParam(value = "身份证反面", required = true)String idCardReverse){
////			UserExample example = new UserExample();
////			example.createCriteria().andIdEqualTo(mobileInfo.getUserid()).andIsBindEqualTo(0);
////			List<User> list = userService.selectByExample(example);
////			User user = list.get(0);
////			user.setIdCardImg(idCardImage);
////			user.setIdCardReverse(idCardReverse);
////			int result = userService.insertSelective(user);
////			if(result == 0){
////				throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
////			}
////
////			return ok();
////
////	}
//
//    @ApiOperation(value = "我的个人信息中--我的银行卡--当前当款总额", notes = "登陆")
//    @RequestMapping(value = "/getMyPayeeTotal", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public String getMyPayeeTotal(MobileInfo mobileInfo) {
//        UserPawnExample userPawnExample = new UserPawnExample();
//        userPawnExample.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andPayeeStateEqualTo(1);
//        List<UserPawn> list = userPawnService.selectByExample(userPawnExample);
//        BigDecimal totalPrice = new BigDecimal(0);
//        for (UserPawn ex : list) {
//            totalPrice = totalPrice.add(ex.getMoney());
//        }
//        return totalPrice + "";
//
//    }
//
//    @ApiOperation(value = "我的个人信息中--我的银行卡--资金明细列表", notes = "登陆")
//    @RequestMapping(value = "/getMyPayeeList", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true, isPage = true)
//    public List<AppUserCapital> getMyPayeeList(MobileInfo mobileInfo,
//                                               PageLimit pageLimit) {
//        UserBalanceLogExample example = new UserBalanceLogExample();
//        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid());
//        example.setOrderByClause("create_time desc");
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(), false);
//        List<UserBalanceLog> list = userBalanceLogService.selectByExample(example);
//        List<AppUserCapital> ret = new ArrayList<AppUserCapital>();
//        for (UserBalanceLog ex : list) {
//            AppUserCapital record = new AppUserCapital();
//            record.setId(ex.getCid());
//            record.setPawnCode(ex.getTradeNo());
//            record.setMoney(ex.getAmount() + "");
//            record.setOrgName(ex.getOrgName());
//            record.setPawnCode(ex.getTradeNo());
//            record.setBankName(ex.getTradeCardBank());
//            record.setBankCode(ex.getTradeCardCode());
//            record.setPhone(ex.getOrgPhone());
//            record.setTicket(ex.getTradeTicket());
//            record.setTime(DateUtil.dateToStr(ex.getCreateTime()));
//            record.setState(ex.getItem());
//            ret.add(record);
//        }
//        return ret;
//    }
//
//    /**
//     * 交易记录列表
//     *
//     * @param mobileInfo
//     * @param pageLimit
//     * @return
//     */
//    @ApiOperation(value = "交易记录列表", notes = "登陆")
//    @RequestMapping(value = "/tradeRecordList", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true, isPage = true)
//    public List<ApiUserTradeRecord> tradeRecordList(MobileInfo mobileInfo,
//                                                    PageLimit pageLimit) {
//        List<ApiUserTradeRecord> ret = new ArrayList<>();
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(), false);
//        Map<String, Object> map = new HashMap<>();
//        map.put("user_id", mobileInfo.getUserid());
//        List<UserGoodsEx> list = userGoodsService.selectTradeRecordList(map);
//        for (UserGoodsEx ex : list) {
//            ApiUserTradeRecord c = new ApiUserTradeRecord();
//            c.setId(ex.getUserPawnId());
//            c.setGoodsId(ex.getId());
//            c.setImages(ex.getImages());
//            c.setTitle(ex.getName());
//            c.setCreateTime(DateUtil.dateToStr(ex.getCreateTime()));
//            c.setAuthPrice(ex.getAuthPrice() + "");
//            c.setType(ex.getUserPawnState());
//            ret.add(c);
//        }
//        return ret;
//    }
//
//    /**
//     * 交易记录详情流水
//     *
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "交易记录详情流水", notes = "登陆")
//    @RequestMapping(value = "/tradeRecordDetail", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public ApiUserTradeRecord tradeRecordDetail(MobileInfo mobileInfo,
//                                                @ApiParam(value = "id", required = true) Integer id,
//                                                @ApiParam(value = "宝贝id", required = true) Integer goodsId) {
//
//        //查找出当前商品
//        UserGoods userGoods = userGoodsService.selectByPrimaryKey(goodsId);
//        //查找出当前典当
//        UserPawn userPawn = userPawnService.selectByPrimaryKey(id);
//        //查找出当前流通记录
//        PawnLogExample pawnLogExample = new PawnLogExample();
//        pawnLogExample.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andGoodsIdEqualTo(userGoods.getId());
//        pawnLogExample.setOrderByClause("create_time desc");
//        List<PawnLog> list = pawnLogService.selectByExample(pawnLogExample);
//
//        ApiUserTradeRecord record = new ApiUserTradeRecord();
//        if (null != userPawn) {
//            if (userPawn.getState() != 1 && userPawn.getState() != -1) {
//                record.setTitle(userGoods.getName());
//                record.setAuthPrice(userGoods.getAuthPrice() + "");
//                record.setType(userPawn.getState());
//                record.setOrgName(userPawn.getOrgName());
//                record.setPawnTicketCode(userPawn.getPawnTicketCode());
//                record.setImages(userGoods.getImages());
//                List<ApiUserPawnRecord> list2 = new ArrayList<ApiUserPawnRecord>();
//                for (PawnLog ex : list) {
//                    ApiUserPawnRecord c = new ApiUserPawnRecord();
//                    c.setBeginTime(DateUtil.dateToStr(ex.getCreateTime()));
//                    c.setOrgName(ex.getOrgName());
//                    c.setPrice(ex.getMoney() + "");
//                    c.setState(ex.getType());
//                    list2.add(c);
//                }
//                record.setList(list2);
//            }
//        } else {
//            record.setTitle(userGoods.getName());
//            record.setAuthPrice(userGoods.getAuthPrice() + "");
//            record.setImages(userGoods.getImages());
//            List<ApiUserPawnRecord> list2 = new ArrayList<ApiUserPawnRecord>();
//            for (PawnLog ex : list) {
//                ApiUserPawnRecord c = new ApiUserPawnRecord();
//                c.setBeginTime(DateUtil.dateToStr(ex.getCreateTime()));
//                c.setOrgName(ex.getOrgName());
//                c.setPrice(userGoods.getAuthPrice() + "");
//                c.setState(ex.getType());
//                list2.add(c);
//            }
//            record.setList(list2);
//            return record;
//        }
//
//
//        return record;
//    }
//
//    @ApiOperation(value = "商场订单列表", notes = "登陆")
//    @RequestMapping(value = "/myStoreGoodsList", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true, isPage = true)
//    public List<AppMyStoreGoods> myStoreGoodsList(MobileInfo mobileInfo,
//                                                  PageLimit pageLimit,
//                                                  @ApiParam(value = "状态 0全部 1待付款 3待收货 4完成(确认收货) 5退款", required = true) Integer orderState
//            ,@ApiParam(value = "评价状态0未评价，1已经评价", required = true)Integer commentState) {
////        MobileInfo mobileInfo=new MobileInfo();
////        mobileInfo.setUserid(userId);
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<AppMyStoreGoods> list = new ArrayList<AppMyStoreGoods>();
//        map.put("user_id", mobileInfo.getUserid());
//        map.put("is_del", 0);
//        map.put("orderState", orderState);
//        map.put("commentState", commentState);
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(), false);
//        //List<GoodsEx> goodsList = goodsService.selectMyGoodsList(map);
//        List<OrderEx> goodsList = orderService.selectMyStoreOrderList(map);
//        for (OrderEx ex : goodsList) {
//            AppMyStoreGoods record = new AppMyStoreGoods();
//            if(ex.getRefState() != 0){
//                //申请退款
//                record.setState(5);
//            }else{
//                //真实状态
//                record.setState(ex.getState());
//            }
//            record.setCommentState(ex.getCommentState());
//            record.setId(ex.getId());
//            record.setGoodsId(ex.getGoodsId());
//            record.setImages(ex.getGoodsImg());
//            record.setOrderCode(ex.getCode());
//            record.setGoodsName(ex.getGoodsName());
//            record.setPrice(ex.getPrice().toString());
//            record.setCouponPrice(ex.getCouponValue() == null? "" : ex.getCouponValue()+"");
//
//            if(null != ex.getExpressId()){
//                record.setExpressState(ex.getExpressState());
//                record.setExpressId(ex.getExpressId());
//            }
//            record.setRefState(ex.getRefState());
//            record.setRefundNotVerifyReason(ex.getRefundNotVerifyReason() == null? "" : ex.getRefundNotVerifyReason());
//            if (1 == ex.getGoodsSource() || 3 == ex.getGoodsSource()) {
//                //平台上传、服务商上传认证
//                record.setGoodsType(1);
//            } else {
//                if(ex.getOrgId() == 0){
//                    //宝祥上传
//                    record.setGoodsType(1);
//                }else{
//                    record.setGoodsType(2);
//                }
//
//            }
//            list.add(record);
//        }
//        return list;
//    }
//
//    @ApiOperation(value = "商场订单 -- 申请退款", notes = "登陆")
//    @RequestMapping(value = "/refundOrder", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret refundOrder(MobileInfo mobileInfo,
//                           @ApiParam(value = "订单id", required = true) Integer orderId,
//                           @ApiParam(value = "退款原因", required = true) String refundReason){
//        Order order = orderService.selectByPrimaryKey(orderId);
//
//        if(order.getGoodsSource() == 2){
//            //绝当商场订单
//            if(order.getState() == 3){
//                //已经发货--不予退款
//                throw new ApiException(MEnumError.CAN_NOT_REFUND);
//            }
//        }
//
//        if(StringUtil.isBlank(refundReason)){
//            throw new ApiException(MEnumError.CONTENT_CAN_NOT_BE_NULL);
//        }
//        if(null == order){
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//
//        if(order.getRefState() != 0){
//            throw new ApiException(MEnumError.ORDER_IS_HANDLE);
//        }
//        order.setRefState(1);//申请退款
//        order.setRefundReason(refundReason);
//        orderService.updateByPrimaryKeySelective(order);
//        return new Ret(1);
//    }
//
//    @ApiOperation(value = "商场订单 -- 申请成功后填写物流单号", notes = "登陆")
//    @RequestMapping(value = "/refundOrderSendCode", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret refundOrderSendCode(MobileInfo mobileInfo,
//                           @ApiParam(value = "回寄单号", required = true) String expressCode,
//                           @ApiParam(value = "订单id", required = true) Integer orderId){
//        Order order = orderService.selectByPrimaryKey(orderId);
//        User user = userService.selectByPrimaryKey(mobileInfo.getUserid());
//        if(!order.getUserId().equals(mobileInfo.getUserid())){
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
////        if(order.getState() != 7){
////            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
////        }
//        if(order.getRefState() != 2){
//            //未同意退款
//            throw new ApiException(MEnumError.ORDER_IS_HANDLE);
//        }
//        order.setBackCode(expressCode);
//        orderService.updateByPrimaryKeySelective(order);
//
////        Express express = new Express();
////        express.setSourceId(1);
////        express.setSourceId(mobileInfo.getUserid());
////        express.setFid(order.getId());
////        express.setType(7); //7用户退款回寄到平台(认证商城)
////        express.setExpressCode(expressCode);
////        //寄件人 --用户
////        express.setPostName(user.getName() == null? user.getPhone() : user.getName());
////        express.setPostPhone(user.getPhone());
////        //收件人
////        express.setReceiveName(order.getBackUser());
////        express.setReceivePhone(order.getBackPhone());
////        express.setReceviceAddress(order.getBackAddress());
////        expressService.insert(express);
//        order.setRefState(3);
//        orderService.updateByPrimaryKeySelective(order);
//        return ok();
//    }
//
//    @ApiOperation(value = "商场订单物流信息", notes = "登陆")
//    @RequestMapping(value = "/expressInfoByStore", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true, isPage = false)
//    public String expressInfoByStore(MobileInfo mobileInfo,
//                                     @ApiParam(value = "物流id", required = true) Integer expressId) {
//        Express express = expressService.selectByPrimaryKey(expressId);
//        if (null == express) {
//            throw new ApiException(MEnumError.STATE_ERROR);
//        }
//        if (null == express.getExpressData()) {
//            throw new ApiException(MEnumError.STATE_ERROR);
//        }
//
//        return express.getExpressData();
//    }
//
//
//    @ApiOperation(value = "商场订单列表--删除订单", notes = "登陆")
//    @RequestMapping(value = "/delMyStoreGoods", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret delMyStoreGoods(MobileInfo mobileInfo,
//                               @ApiParam(value = "id", required = true) Integer id) {
//        Order order = orderService.selectByPrimaryKey(id);
//        order.setIsDel(1);
//        int result = orderService.updateByPrimaryKey(order);
//        if (result == 0) {
//            throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
//        }
//        return ok();
//    }
//
//    @ApiOperation(value = "商场订单列表--取消订单", notes = "登陆")
//    @RequestMapping(value = "/cencelMyStoreGoods", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret cencelMyStoreGoods(MobileInfo mobileInfo,
//                                  @ApiParam(value = "id", required = true) Integer id) {
//        Order order = orderService.selectByPrimaryKey(id);
//        if (null == order) {
//            throw new ApiException(MErrorEnum.WM_ORDER_NOTEXISTS);
//        }
//        order.setState(-1);
//        int result = orderService.updateByPrimaryKey(order);
//        if (result == 0) {
//            throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
//        }
//        //释放库存
//        Goods goods = goodsService.selectByPrimaryKey(order.getGoodsId());
//        if (null == goods) {
//            throw new ApiException(MErrorEnum.GOODS_NOTEXISTS_ERROR);
//        }
//
//
//        return ok();
//    }
//
//    @ApiOperation(value = "商场订单详情", notes = "登陆")
//    @RequestMapping(value = "/myStoreGoodsDetail", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public AppMyStoreGoods myStoreGoodsDetail(MobileInfo mobileInfo,
//                                              @ApiParam(value = "id", required = true) Integer id) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        AppMyStoreGoods record = new AppMyStoreGoods();
//        Order ex = orderService.selectByPrimaryKey(id);
//        Goods goods = goodsService.selectByPrimaryKey(ex.getGoodsId());
//        record.setId(ex.getId());
//        record.setShipUser(ex.getShipUser());
//        record.setShipPhone(ex.getShipPhone());
//        record.setShipAddress(ex.getShipAddress());
//        record.setImages(ex.getGoodsImg());
//        record.setGoodsType(goods.getType());
//        record.setAuthPrice(ex.getGoodsCost().toString());
//        record.setCouponPrice(ex.getCouponValue() + "");
//        record.setGoodsPirce(ex.getGoodsPrice() + "");
//        record.setPrice(ex.getPrice() + "");
//        record.setGoodsName(ex.getGoodsName());
//        return record;
//    }
//
//    @ApiOperation(value = "签收商城商品", notes = "登陆")
//    @RequestMapping(value = "/getMyGoods", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret getMyGoods(MobileInfo mobileInfo,
//                          @ApiParam(value = "id", required = true) Integer id) {
////		OrderExample orderExample = new OrderExample();
////		orderExample.createCriteria().andGoodsIdEqualTo(id).andUserIdEqualTo(mobileInfo.getUserid());
////
////		Order order = new Order();
////		order.setState(4);
//
////		int result = orderService.updateByExample(order,orderExample);
////		if(result == 0){
////			throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
////		}
//        Order order = orderService.selectByPrimaryKey(id);
//        if (null == order) {
//            throw new ApiException(MErrorEnum.WM_ORDER_NOTEXISTS);
//        }
//        order.setState(4);
//        orderService.updateByPrimaryKeySelective(order);
//
//        return ok();
//    }
//
//    @ApiOperation(value = "删除订单", notes = "登陆")
//    @RequestMapping(value = "/delMyOrder", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret delMyOrder(MobileInfo mobileInfo,
//                          @ApiParam(value = "id", required = true) Integer id) {
//        OrderExample orderExample = new OrderExample();
//        orderExample.createCriteria().andGoodsIdEqualTo(id).andUserIdEqualTo(mobileInfo.getUserid());
//
//        Order order = new Order();
//        order.setIsDel(1);
//
//        int result = orderService.updateByExample(order, orderExample);
//        if (result == 0) {
//            throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
//        }
//
//        return ok();
//    }
//
//    /**
//     * 绝当商场竞拍列表
//     *
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "绝当商场竞拍列表", notes = "登陆")
//    @RequestMapping(value = "/jdStoreGoodsAucList", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public List<AppJdGoodsAuc> jdStoreGoodsAucList(MobileInfo mobileInfo) {
//        List<AppJdGoodsAuc> ret = new ArrayList<AppJdGoodsAuc>();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("user_id", mobileInfo.getUserid());
//
//        List<GoodsEx> goodsExList = goodsService.selectMyAucList(map);
//
//
//        if (goodsExList != null && goodsExList.size() != 0) {
//            for (GoodsEx ex : goodsExList) {
//                if (null == ex) {
//                    return ret;
//                }
//                AppJdGoodsAuc c = new AppJdGoodsAuc();
//                c.setId(ex.getId());
//                c.setGoodsImg(ex.getImg());
//                c.setTitle(ex.getName());
//                c.setAuthPrice(ex.getCost() + "");
//                c.setPrice(ex.getCost() + "");
//                c.setMaxPirce(ex.getMaxAuction() + "");
//                c.setMyPrice(ex.getMyPrice());
//
//                //查询时间
//                int second = DateUtil.secondsAfter(com.base.date.DateUtil.addMinute(ex.getCreateTime(), (PaidangConst.AUCTION_TIME) / 60), new Date());
//                if (second > 0) {
//                    c.setTime(second + "");
//                } else {
//                    c.setTime("0");
//                }
//                if (ex.getUserId().equals(mobileInfo.getUserid())) {
//                    //如果查出来的相等，那就是中标
//                    c.setState(2);
//                } else {
//                    //未中标
//                    c.setState(3);
//                }
//                ret.add(c);
//            }
//        }
//
//        return ret;
//    }
//


//    /**
//     * 删除用户消息列表
//     */
//    @ApiOperation(value = "删除用户消息列表", notes = "登陆")
//    @RequestMapping(value = "/delNotifyDetail", method = RequestMethod.POST)
//    @ApiMethod(isLogin = true)
//    public Ret delNotifyDetail(MobileInfo mobileInfo,
//                               @ApiParam(value = "消息id", required = true) Integer id) {
//        if (id == null) {
//            throw new ApiException("id");
//        }
//        UserNotify record = userNotifyService.selectByPrimaryKey(id);
//        if (record == null) {
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//        userNotifyService.deleteByPrimaryKey(id);
//        Ret ret = new Ret();
//        ret.setCode(0);
//        return ret;
//    }

//    /**
//     * 证书查询--编号查询
//     */
//    @ApiOperation(value = "证书查询--编号查询", notes = "")
//    @RequestMapping(value = "/checkCertificateByNumer", method = RequestMethod.POST)
//    @ApiMethod(isLogin = false)
//    public ApiUserCertificate checkCertificateByNumer(MobileInfo mobileInfo,
//                                                      @ApiParam(value = "编号", required = true) String code) {
//        ApiUserCertificate c = new ApiUserCertificate();
//        CertificateExample example = new CertificateExample();
//        example.createCriteria().andCodeLike(code);
//        List<Certificate> list = certificateService.selectByExample(example);
//        if (0 == list.size() || null == list) {
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//        Certificate ex = list.get(0);
//        if (null != ex) {
//            c.setId(ex.getId());
//            c.setName(ex.getName());
//            c.setCode(ex.getCode());
//            c.setSize(ex.getLength() + "×" + ex.getWidth() + "×" + ex.getHeight());
//            c.setWeight(ex.getWeight());
//            c.setMaterial(ex.getMaterial());
//            String img[] = ex.getImgs().split(",");
//            c.setImg(img[0]);
//        } else {
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//
//        return c;
//    }
//
//    /**
//     * 证书查询列表--高级搜索
//     */
//    @ApiOperation(value = "证书查询列表--高级搜索", notes = "")
//    @RequestMapping(value = "/checkCertificate", method = RequestMethod.POST)
//    @ApiMethod(isLogin = false)
//    public List<ApiUserCertificate> checkCertificate(MobileInfo mobileInfo,
//                                                     @ApiParam(value = "藏品名称", required = true) String name,
//                                                     @ApiParam(value = "藏品尺寸--长", required = false) String length,
//                                                     @ApiParam(value = "藏品尺寸--宽", required = false) String width,
//                                                     @ApiParam(value = "藏品尺寸--高", required = false) String height,
//                                                     @ApiParam(value = "质量", required = true) String weight,
//                                                     @ApiParam(value = "材质", required = true) String material,
//                                                     @ApiParam(value = "主体材质", required = false) String mainMaterial,
//                                                     @ApiParam(value = "其他辅材", required = false) String otherMaterial,
//                                                     @ApiParam(value = "创作年代", required = false) String createYear,
//                                                     @ApiParam(value = "其他", required = false) String other) {
//        List<ApiUserCertificate> ret = new ArrayList<ApiUserCertificate>();
//        CertificateExample example = new CertificateExample();
//        example.createCriteria().andNameLike("%" + name + "%").andLengthLike("%" + length + "%").andWidthLike("%" + width + "%").andHeightLike("%" + height + "%").
//                andWeightLike("%" + weight + "%").andMaterialLike("%" + material + "%").andMainMaterialLike("%" + mainMaterial + "%").
//                andOtherMaterialLike("%" + otherMaterial + "%").andCreateYearLike("%" + createYear + "%").andOtherLike("%" + other + "%");
//        example.setOrderByClause("create_time desc");
//        List<Certificate> list = certificateService.selectByExample(example);
//        for (Certificate ex : list) {
//            ApiUserCertificate c = new ApiUserCertificate();
//            c.setId(ex.getId());
//            c.setName(ex.getName());
//            c.setSize(ex.getLength() + "×" + ex.getWidth() + "×" + ex.getHeight());
//            c.setCode(ex.getCode());
//            c.setWeight(ex.getWeight());
//            c.setMaterial(ex.getMaterial());
//            String img[] = ex.getImgs().split(",");
//            c.setImg(img[0]);
//            ret.add(c);
//        }
//        return ret;
//    }
//
//    /**
//     * 合同记录列表
//     */
//    @ApiOperation(value = "合同记录列表", notes = "")
//    @RequestMapping(value = "/getContractList", method = RequestMethod.POST)
//    @ApiMethod(isLogin = false)
//    public List<ApiContractList> getContractList(MobileInfo mobileInfo) {
//        List<ApiContractList> ret = new ArrayList<>();
//        Map<String, Object> map = new HashMap<>();
//        map.put("user_id", mobileInfo.getUserid());
//        List<UserPawnEx> list = userPawnService.selectConList(map);
//        for (UserPawnEx ex : list) {
//            ApiContractList c = new ApiContractList();
//            c.setId(ex.getId());
//            c.setImg(ex.getImages());
//            c.setTitle(ex.getGoodsName());
//            c.setCode(ex.getPawnTicketCode());
//            c.setPawnMoney(ex.getBeginMoney() + "");
//            c.setVerifyTime(DateUtil.dateToStr(ex.getPawnBeginTime()).substring(0, 10));
//            ret.add(c);
//        }
//        return ret;
//    }
//
//    /**
//     * 合同类型列表
//     */
//    @ApiOperation(value = "合同类型列表", notes = "")
//    @RequestMapping(value = "/getContractType", method = RequestMethod.POST)
//    @ApiMethod(isLogin = false)
//    public List<ApiContractType> getContractType(MobileInfo mobileInfo,
//                                                 @ApiParam(value = "id", required = true) Integer id) {
//        List<ApiContractType> ret = new ArrayList<>();
//        UserPawn userPawn = userPawnService.selectByPrimaryKey(id);
//
//        if (null == userPawn) {
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//        if (null == userPawn.getLastPawnContinueId()) {
//            ApiContractType c = new ApiContractType();
//            //没有续当
//            c.setId(userPawn.getId());
//            c.setType(1);
//            c.setVerifyTime(DateUtil.dateToStr(userPawn.getPawnBeginTime()));
//            ret.add(c);
//            return ret;
//        } else {
//            //先加入典当
//            ApiContractType b = new ApiContractType();
//            b.setId(userPawn.getId());
//            b.setVerifyTime(DateUtil.dateToStr(userPawn.getPawnBeginTime()));
//            b.setType(1);
//            ret.add(b);
//
//            //存在续当
//            PawnContinueExample pawnContinueExample = new PawnContinueExample();
//            pawnContinueExample.createCriteria().andPawnIdEqualTo(id);
//            pawnContinueExample.setOrderByClause("create_time desc");
//            List<PawnContinue> list = pawnContinueService.selectByExample(pawnContinueExample);
//            if (null == list || 0 == list.size()) {
//                throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//            }
//            for (PawnContinue ex : list) {
//                ApiContractType c = new ApiContractType();
//                //还在典当中
//                c.setId(ex.getId());
//                c.setVerifyTime(DateUtil.dateToStr(ex.getCreateTime()).substring(0, 10));
//                c.setType(2);
//                ret.add(c);
//            }
//
//        }
//        return ret;
//    }
//
//    /**
//     * 合同详情
//     */
//    @ApiOperation(value = "合同详情", notes = "")
//    @RequestMapping(value = "/getContractInfo", method = RequestMethod.POST)
//    @ApiMethod(isLogin = false)
//    public ApiContractInfo getContractInfo(MobileInfo mobileInfo,
//                                           @ApiParam(value = "id", required = true) Integer id,
//                                           @ApiParam(value = "类型(1典当合同 2续当合同)", required = true) Integer type) {
//        ApiContractInfo c = new ApiContractInfo();
//        if (1 == type) {
//            //典当
//            UserPawn ex = userPawnService.selectByPrimaryKey(id);
//            c.setId(ex.getId());
//            c.setCode(ex.getPawnTicketCode());
//            c.setTitle(ex.getGoodsName());
//            c.setUserName(ex.getUserName());
//            c.setAuthPrice(userGoodsService.selectByPrimaryKey(ex.getGoodsId()).getAuthPrice() + "");
//            c.setOrgName(ex.getOrgName());
//            PawnOrg pawnOrg = pawnOrgService.selectByPrimaryKey(ex.getOrgId());
//            c.setLegalPerson(pawnOrg.getLegalPerson());
//            c.setRegisteredCapital(pawnOrg.getRegisteredCapital());
//            c.setAddress(ex.getOrgAddress());
//            c.setMoney(ex.getBeginMoney() + "");
//            c.setPawnBeginTime(DateUtil.dateToStr(ex.getPawnBeginTime()));
//            c.setPawnEndTime(DateUtil.dateToStr(ex.getPawnEndTime()));
//            c.setRate(ex.getRate() + "");
//            c.setServerRate(ex.getMoneyRate() + "");
//            c.setOverdueRate(ex.getOverdueRate() + "");
//            c.setBankName(ex.getPayeeBankName());
//            c.setBankCodeNo(ex.getPayeeBankCardCode());
//            c.setTime(DateUtil.dateToStr(ex.getPawnBeginTime()));
//            c.setState(1);
//        } else if (2 == type) {
//            //续当
//            PawnContinue ex = pawnContinueService.selectByPrimaryKey(id);
//            c.setId(ex.getId());
//            c.setCode(ex.getPawnTicketCode());
//
//            UserPawn userPawn = userPawnService.selectByPrimaryKey(ex.getPawnId());
//
//            c.setTitle(userPawn.getGoodsName());
//            c.setUserName(ex.getUserName());
//            c.setAuthPrice(userGoodsService.selectByPrimaryKey(userPawn.getGoodsId()).getAuthPrice() + "");
//            c.setOrgName(userPawn.getOrgName());
//            PawnOrg pawnOrg = pawnOrgService.selectByPrimaryKey(userPawn.getOrgId());
//            c.setLegalPerson(pawnOrg.getLegalPerson());
//            c.setRegisteredCapital(pawnOrg.getRegisteredCapital());
//            c.setAddress(userPawn.getOrgAddress());
//            c.setMoney(ex.getPawnMoney() + "");
//            c.setPawnBeginTime(DateUtil.dateToStr(ex.getPawnLastEndTime()));
//            c.setPawnEndTime(DateUtil.dateToStr(ex.getPawnEndTime()));
//            c.setRate(userPawn.getRate() + "");
//            c.setServerRate(userPawn.getMoneyRate() + "");
//            c.setOverdueRate(userPawn.getOverdueRate() + "");
//            c.setBankName(userPawn.getPayeeBankName());
//            c.setBankCodeNo(userPawn.getPayeeBankCardCode());
//            c.setTime(DateUtil.dateToStr(ex.getCreateTime()));
//            if (4 == ex.getState()) {
//                //机构确认续当费用已经收到
//                c.setState(1);
//            } else {
//                //机构未确认续当费用
//                c.setState(0);
//            }
//        }
//        return c;
//    }
//
//    /**
//     * 法律条文
//     */
//    @ApiOperation(value = "法律条文", notes = "")
//    @RequestMapping(value = "/lawList", method = RequestMethod.POST)
//    @ApiMethod(isLogin = false)
//    public List<ApiUrl> getLawList(MobileInfo mobileInfo) {
//        List<ApiUrl> ret = new ArrayList<>();
//        CodeExample example = new CodeExample();
//        example.createCriteria().andCodeLike("%@law");
//        List<Code> list = codeService.selectByExample(example);
//        for (Code ex : list) {
//            ApiUrl c = new ApiUrl();
//            c.setCode(ex.getCode());
//            c.setValue(ex.getValue());
//            c.setRemark(ex.getRemark());
//            ret.add(c);
//        }
//        return ret;
//    }
//
//    @ApiOperation(value = "物流公司信息", notes = "不需要登陆")
//    @RequestMapping(value = "/expressList", method = RequestMethod.POST)
//    @ResponseBody
//    @ApiMethod(isLogin = false)
//    public List<String> expressList(MobileInfo mobileInfo) {
//        List<String> list=CacheService.expressList;
//        return list;
//    }
}
