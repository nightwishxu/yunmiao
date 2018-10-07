package com.item.daoEx;

import com.item.dao.model.UserFollow;
import com.item.daoEx.model.UserFollowEx;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/**
@author sun
*/
public interface UserFollowMapperEx {

    /**
     * 获取用户关注数
     * @param userId
     * @return
     */
    Integer getUserFollowCount(Integer userId);

    /**
     * 我的关注
     * @param userId
     * @return
     */
    List<UserFollowEx> getUserFollow(Integer userId);

    /**
     * 获取用户粉丝数
     * @param userId
     * @return
     */
    Integer getUserFansCount(Integer userId);

    Integer getIsFollow(@Param("userId") Integer userId,@Param("followUserId") Integer followUserId);
}
