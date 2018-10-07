package com.item.service;

import java.util.List;

import com.item.daoEx.ArticleMapperEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.ArticleMapper;
import com.item.dao.model.Article;
import com.item.dao.model.ArticleExample;

@Service
public class ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private ArticleMapperEx articleMapperEx;

	public int countByExample(ArticleExample example) {
		return this.articleMapper.countByExample(example);
	}

	public Article selectByPrimaryKey(Integer id) {
		return this.articleMapper.selectByPrimaryKey(id);
	}

	public List<Article> selectByExample(ArticleExample example) {
		return this.articleMapper.selectByExample(example);
	}

	public List<Article> selectByExampleWithBLOBs(ArticleExample example) {
		return this.articleMapper.selectByExampleWithBLOBs(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.articleMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Article record) {
		return this.articleMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(Article record) {
		return this.articleMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(Article record) {
		return this.articleMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(ArticleExample example) {
		return this.articleMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Article record, ArticleExample example) {
		return this.articleMapper.updateByExampleSelective(record, example);
	}

	public int updateByExampleWithBLOBs(Article record, ArticleExample example) {
		return this.articleMapper.updateByExampleWithBLOBs(record, example);
	}

	public int updateByExample(Article record, ArticleExample example) {
		return this.articleMapper.updateByExample(record, example);
	}

	public int insert(Article record) {
		return this.articleMapper.insert(record);
	}

	public int insertSelective(Article record) {
		return this.articleMapper.insertSelective(record);
	}


	/**
	 *
	 * @param id
	 * @param num
	 * @param type 0更新评论数1更新收藏数2更新点赞数
	 * @return
	 */
	public Integer updateArticleCount(Integer id,Integer num,Integer type){

		return articleMapperEx.updateArticleCount(id,num,type);
	}

	/**
	 * 获取用户发布动态数
	 * @param userId
	 * @return
	 */
	public Integer getArticleCount(Integer userId){
		return  articleMapperEx.getArticleCount(userId);
	}


}
