package com.item.daoEx.model;

import com.item.dao.model.Comment;

import java.util.List;

/**
@author sun
*/
public class CommentEx extends Comment {


    /**
     * 回复
     */
    List<CommentReplyEx> commentReplyExList;
}