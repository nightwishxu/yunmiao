package com.paidang.action;

import java.util.List;
import com.base.dialect.PaginationSupport;
import com.base.dao.model.Ret;
import com.base.dao.model.Grid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.base.action.CoreController;
import com.paidang.dao.model.GoodsAuction;
import com.paidang.dao.model.GoodsAuctionExample;
import com.paidang.service.GoodsAuctionService;

/**
@author sun
*/
@RequestMapping("goodsAuction")
@Controller
@LoginFilter
public class GoodsAuctionController extends CoreController{

    @Autowired
    private GoodsAuctionService goodsAuctionService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	GoodsAuctionExample example = new GoodsAuctionExample();
    	
    	List<GoodsAuction> list = goodsAuctionService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(GoodsAuction goodsAuction){
    	if (goodsAuction.getId() == null){
    		goodsAuctionService.insert(goodsAuction);
    	}else{
    		goodsAuctionService.updateByPrimaryKeySelective(goodsAuction);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	GoodsAuction goodsAuction = goodsAuctionService.selectByPrimaryKey(id);
       	return ok(goodsAuction);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		goodsAuctionService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}