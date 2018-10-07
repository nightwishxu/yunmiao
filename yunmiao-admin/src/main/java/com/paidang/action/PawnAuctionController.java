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
import com.paidang.dao.model.PawnAuction;
import com.paidang.dao.model.PawnAuctionExample;
import com.paidang.service.PawnAuctionService;

/**
@author sun
*/
@RequestMapping("pawnAuction")
@Controller
@LoginFilter
public class PawnAuctionController extends CoreController{

    @Autowired
    private PawnAuctionService pawnAuctionService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	PawnAuctionExample example = new PawnAuctionExample();
    	
    	List<PawnAuction> list = pawnAuctionService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(PawnAuction pawnAuction){
    	if (pawnAuction.getId() == null){
    		pawnAuctionService.insert(pawnAuction);
    	}else{
    		pawnAuctionService.updateByPrimaryKeySelective(pawnAuction);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	PawnAuction pawnAuction = pawnAuctionService.selectByPrimaryKey(id);
       	return ok(pawnAuction);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		pawnAuctionService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}