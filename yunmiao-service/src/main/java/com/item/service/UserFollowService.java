package com.item.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.item.daoEx.UserFollowMapperEx;
import com.item.daoEx.model.UserFollowEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserFollowMapper;
import com.item.dao.model.UserFollow;
import com.item.dao.model.UserFollowExample;

@Service
public class UserFollowService {
	@Autowired
	private UserFollowMapper userFollowMapper;

	@Autowired
	private UserFollowMapperEx userFollowMapperEx;

	public int countByExample(UserFollowExample example) {
		return this.userFollowMapper.countByExample(example);
	}

	public UserFollow selectByPrimaryKey(Integer id) {
		return this.userFollowMapper.selectByPrimaryKey(id);
	}

	public List<UserFollow> selectByExample(UserFollowExample example) {
		return this.userFollowMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userFollowMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserFollow record) {
		return this.userFollowMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserFollow record) {
		return this.userFollowMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserFollowExample example) {
		return this.userFollowMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserFollow record, UserFollowExample example) {
		return this.userFollowMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserFollow record, UserFollowExample example) {
		return this.userFollowMapper.updateByExample(record, example);
	}

	public int insert(UserFollow record) {
		return this.userFollowMapper.insert(record);
	}

	public int insertSelective(UserFollow record) {
		return this.userFollowMapper.insertSelective(record);
	}


	public   Integer getUserFollowCount(Integer userId){
		return userFollowMapperEx.getUserFollowCount(userId);
	}

//	public   List<UserFollowEx> getUserFollow(Integer userId){
//		return userFollowMapperEx.getUserFollow(userId);
//	}

	public   Integer getUserFansCount(Integer userId){
		return userFollowMapperEx.getUserFansCount(userId);
	}

	/**
	 * 判断是否关注
	 * @param userId 关注者
	 * @param followUserId 被关注者
	 * @return
	 */
	public Integer getIsFollow(Integer userId,Integer followUserId){
		return userFollowMapperEx.getIsFollow(userId,followUserId);
	}


    /**
     * 查看关注状态
     * @param userId 用户id
     * @param followUserId 被关注用户
     * @return  0没有关注关系1关注2被关注3互相关注
     */
    public Integer getFollowStatus(Integer userId,Integer followUserId){
        UserFollowExample example1=new UserFollowExample();
        example1.createCriteria().andUserIdEqualTo(userId).andFollowIdEqualTo(followUserId);
        example1.or().andUserIdEqualTo(followUserId).andFollowIdEqualTo(userId);
        List<UserFollow> list=userFollowMapper.selectByExample(example1);
        Integer status=0;
        if (list!=null && list.size()>0){
//        	UserFollow follow=list.get(0);
//            map.put("userFollow",follow);
//            if (follow.getUserId()==userId){
//                if (follow.getStatus()==3){
//                    status= 3;
//                }else if (follow.getStatus()==1){
//					status= 1;
//                }else if (follow.getStatus()==2){
//					status= 2;
//                }
//            }else if (follow.getUserId()==followUserId){
//                if (follow.getStatus()==3){
//					status= 4;
//                }else if (follow.getStatus()==1){
//					status= 2;
//                }else if (follow.getStatus()==2){
//					status= 1;
//                }
//            }
			if (list.size()==2){
				status= 3;
			}else {
				if (list.get(0).getUserId()==userId){
					status=1;
				}else {
					status=2;
				}
			}

        }else {
			status= 0;
        }
        return status;
    }
}
