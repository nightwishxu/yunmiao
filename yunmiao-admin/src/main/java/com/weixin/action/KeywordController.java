package com.weixin.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.Grid;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.weixin.dao.model.Keyword;
import com.weixin.dao.model.KeywordExample;
import com.weixin.daoEx.model.KeywordEx;
import com.weixin.service.KeywordService;

@RequestMapping("wxkw")
@Controller
@LoginFilter
public class KeywordController extends CoreController{

    @Autowired
    private KeywordService keywordService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows,HttpSession session)throws Exception{
    	String fid = WeixinController.getFid(session);
    	PaginationSupport.byPage(page, rows);
    	List<KeywordEx> list = keywordService.selectList(fid);
      	return JSONUtils.serialize(new Grid(PaginationSupport.getContext().getTotalCount(), list));
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Keyword keyword,HttpSession session){
    	String fid = WeixinController.getFid(session);
    	if (StringUtils.isBlank(keyword.getId())){
    		KeywordExample example = new KeywordExample();
    		example.createCriteria().andFidEqualTo(fid).andKeywordEqualTo(keyword.getKeyword());
			int cnt = keywordService.countByExample(example);
			if(cnt>0){
				return JSONUtils.serialize(new Ret(1,"该关键字已存在"));
			}
			keyword.setCreateTime(new Date());
    		keyword.setFid(fid);
    		keyword.setMatchType(2);
    		keywordService.insert(keyword);
    	}else{
    		KeywordExample example = new KeywordExample();
    		example.createCriteria().andFidEqualTo(fid).andKeywordEqualTo(keyword.getKeyword()).andIdNotEqualTo(keyword.getId());
			int cnt = keywordService.countByExample(example);
			if(cnt>0){
				return JSONUtils.serialize(new Ret(1,"该关键字已存在"));
			}
    		keywordService.updateByPrimaryKeySelective(keyword);
    	}
       	return JSONUtils.serialize(new Ret(0));
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(String id){
    	Keyword keyword = keywordService.selectByPrimaryKey(id);
       	return JSONUtils.serialize(keyword);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		keywordService.deleteByPrimaryKey(str);
    	}
       	return JSONUtils.serialize(new Ret(0));
    }


}
