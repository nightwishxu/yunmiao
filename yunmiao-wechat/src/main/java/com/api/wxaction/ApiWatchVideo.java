package com.api.wxaction;

import com.api.MEnumError;
import com.api.MErrorEnum;
import com.api.util.PageLimit;
import com.api.view.home.UserInfo;
import com.api.view.toutiao.AppNewsComment;
import com.api.view.user.AppUserCoupon;
import com.api.view.video.AppVideoOnline;
import com.base.api.ApiBaseController;
import com.base.api.ApiException;
import com.base.api.MobileInfo;
import com.base.api.annotation.ApiMethod;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.util.DateUtil;
import com.base.util.StringUtil;
import com.paidang.dao.model.*;
import com.paidang.daoEx.model.CouponEx;
import com.paidang.daoEx.model.VideoOnlineCommentEx;
import com.paidang.daoEx.model.VideoOnlineEx;
import com.paidang.service.CouponService;
import com.paidang.service.UserCouponService;
import com.paidang.service.VideoOnlineCommentService;
import com.paidang.service.VideoOnlineService;
import com.util.PaidangConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/api/watchVideo", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
@Api(tags = "在线视频(用户端)")
public class ApiWatchVideo extends ApiBaseController {
    @Autowired
    private UserCouponService userCouponService;
    @Autowired
    private VideoOnlineService videoOnlineService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private VideoOnlineCommentService videoOnlineCommentService;

    @ApiOperation(value = "视频列表", notes = "分页")
    @RequestMapping("/videoList")
    @ApiMethod(isPage = true, isLogin = false)
    public List<AppVideoOnline> list(MobileInfo mobileInfo, PageLimit pageLimit){
//        VideoOnlineExample example = new VideoOnlineExample();
//        example.createCriteria();
//        example.setOrderByClause("create_time desc");
//        PaginationSupport.byPage(pageLimit.getPage(),pageLimit.getLimit(),false);
//
//        List<VideoOnline> list = videoOnlineService.selectByExample(example);

        //视频列表

        List<VideoOnlineEx> list = videoOnlineService.selectByComment();

        List<AppVideoOnline> ret = new ArrayList<AppVideoOnline>();
        for(VideoOnlineEx ex : list){
            AppVideoOnline record = new AppVideoOnline();
            record.setId(ex.getId());
            record.setTitle(ex.getTitle());
            record.setImg(ex.getImg());
            record.setVideo(ex.getVideo()+ PaidangConst.VIDEO_NORMAL);
            record.setComCnt(ex.getCommCount());
            record.setState(ex.getState());
            ret.add(record);
        }
        return ret;
    }

    @ApiOperation(value = "视频评论列表", notes = "分页")
    @RequestMapping("/videoCommentList")
    @ApiMethod(isPage = true, isLogin = false)
    public List<AppNewsComment> videoCommentList(MobileInfo mobileInfo,
                                                 PageLimit pageLimit,
                                                 @ApiParam(value = "视频id",required = true)Integer id){
        //查询待完善
        PaginationSupport.byPage(pageLimit.getPage(),pageLimit.getLimit(),false);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("video_id",id);
        List<VideoOnlineCommentEx> list = videoOnlineCommentService.selectByUser(map);
        List<AppNewsComment> ret = new ArrayList<>();
        for (VideoOnlineCommentEx ex : list) {
            AppNewsComment c = new AppNewsComment();
            UserInfo userRecord = new UserInfo();
            userRecord.setNickName(ex.getNickName());
            userRecord.setHeadImg(ex.getHeadImg());
            c.setId(ex.getId());
            c.setUserInfo(userRecord);
            c.setContent(ex.getContent());
            c.setTime(DateUtil.dateToStr(ex.getCreateTime()));
            ret.add(c);
        }
        return ret;
    }

    @ApiOperation(value = "视频评论数量", notes = "分页")
    @RequestMapping("/videoCommentCnt")
    @ApiMethod()
    public AppNewsComment videoCommentCnt(MobileInfo mobileInfo,
                                          @ApiParam(value = "视频id",required = true)Integer id){

        VideoOnlineCommentExample example = new VideoOnlineCommentExample();
        example.createCriteria().andVideoIdEqualTo(id);

        Integer count = videoOnlineCommentService.countByExample(example);
        AppNewsComment c = new AppNewsComment();
        c.setReplyCnt(count);
        return c;
    }

    @ApiOperation(value = "视频评论", notes = "登录")
    @RequestMapping("/videoComment")
    @ApiMethod(isLogin = true)
    public Ret videoComment(MobileInfo mobileInfo,
                            @ApiParam("视频id") Integer id,
                            @ApiParam("评论内容") String content){
        if(id == null){
            throw new ApiException("id");
        }
        if (StringUtil.isBlank(content)){
            throw new ApiException("content");
        }

        VideoOnlineComment comment = new VideoOnlineComment();
        comment.setContent(content);
        comment.setUserId(mobileInfo.getUserid());
        comment.setIsDel(0);
        comment.setVideoId(id);
        videoOnlineCommentService.insert(comment);
        return ok();
    }

    @ApiOperation(value = "进入视频--获取优惠券信息", notes = "登录")
    @RequestMapping("/userGetCoupon")
    @ApiMethod(isLogin = true)
    public AppUserCoupon userGetCoupon(MobileInfo mobileInfo){
//        CouponExample example2 = new CouponExample();
//        example2.createCriteria();
//        example2.setOrderByClause("value desc");
//        List<Coupon> list2 = couponService.selectByExample(example2);
        AppUserCoupon c = new AppUserCoupon();

        //判断用户当天有没有领过优惠券
        //List<CouponEx> list = couponService.selectGoods();

        Map<String ,Object> map = new HashMap<>();
        map.put("user_id",mobileInfo.getUserid());
        List<CouponEx> list = couponService.selectGoods(map);

        if(list.size() == 0 || null == list){
            return c;
        }

        CouponEx coupon = list.get(0);

        if(coupon.getCnt() == 0){
            //未领过优惠券 --今天
            c.setId(coupon.getId());
            c.setCouponId(coupon.getId());
            c.setValue(coupon.getFull()+"");
            c.setInfo(coupon.getGoodsName());
            c.setPrice(coupon.getGoodsPrice());
            //c.setFull(coupon.getFull()+"");
            c.setEndTime(c.getEndTime());
        }


        return c;

    }

    @ApiOperation(value = "领优惠券", notes = "登录")
    @RequestMapping("/watchVideo")
    @ApiMethod(isPage = false, isLogin = true)
    public Ret watchVideo(MobileInfo mobileInfo,
                          @ApiParam(value = "优惠券id",required = true)Integer id,
                          @ApiParam(value = "优惠券领取方式 1新用户注册 2看视频 3首页领取",required = true)Integer type){
        Ret ret = new Ret();
        UserCouponExample example = new UserCouponExample();
        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andCreateTimeBetween(DateUtil.add(new Date(),1),DateUtil.add(new Date(),-1));
        List<UserCoupon> list = userCouponService.selectByExample(example);
        if(list.size()>0){
            //用户已经抢过券了
            ret.setCode(-1);
            ret.setMsg("领取失败...");
            return ret;
        }

        Coupon coupon = couponService.selectByPrimaryKey(id);
        if(null == coupon){
            throw new ApiException(MErrorEnum.GOODS_NOTEXISTS_ERROR);
        }


        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setUserId(mobileInfo.getUserid());
        userCoupon.setCouponId(coupon.getId());
        userCoupon.setFull(coupon.getFull());
        //userCoupon.setValue(coupon.getValue());
        userCoupon.setEndTime(DateUtil.add(new Date(),coupon.getDays()));
        userCoupon.setState(1);
        userCoupon.setSource(type);
        int result = userCouponService.insert(userCoupon);
        if(result == 0){
            throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
        }

        return ok();
    }

    /**
     * 新闻评论内容封装
     */
    private AppNewsComment getAppNewsComment(VideoOnlineCommentEx ex) {
        AppNewsComment mini = new AppNewsComment();
        mini.setId(ex.getId());
        mini.setContent(ex.getContent());
//        mini.setIsPraise(ex.getIsPraise());
//        mini.setPraiseCnt(ex.getPraiseCnt());
//        mini.setReplyCnt(ex.getReplyCnt());
        mini.setTime(getTime(ex.getCreateTime()));
        UserInfo user = new UserInfo();
        user.setId(ex.getUserId());
        user.setNickName(ex.getNickName());
        user.setHeadImg(ex.getHeadImg());
        mini.setUserInfo(user);
        return mini;
    }

    /**
     * 新闻评论列表封装
     */
    private List<AppNewsComment> getAppNewsComments(List<VideoOnlineCommentEx> list) {
        List<AppNewsComment> ret = new ArrayList<>(list.size());
        for (VideoOnlineCommentEx ex : list) {
            ret.add(getAppNewsComment(ex));
        }
        return ret;
    }

    private String getTime(Date date) {
        return DateUtil.dateAsQQ(date);
    }
}
