package com.paidang.daoEx;

import com.paidang.daoEx.model.VideoOnlineCommentEx;

import java.util.List;
import java.util.Map; /**
@author sun
*/
public interface VideoOnlineCommentMapperEx {
    List<VideoOnlineCommentEx> selectByUser(Map<String, Object> map);
}
