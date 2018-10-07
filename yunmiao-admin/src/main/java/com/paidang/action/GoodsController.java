package com.paidang.action;

import com.base.action.CoreController;
import com.base.dialect.PaginationSupport;
import com.base.entity.QueryParams;
import com.base.security.util.UserUtils;
import com.base.web.annotation.LoginFilter;
import com.item.dao.model.Admin;
import com.item.service.AdminService;
import com.paidang.dao.model.Goods;
import com.paidang.dao.model.GoodsExample;
import com.paidang.daoEx.model.GoodsEx;
import com.paidang.service.GoodsService;
import com.util.PaidangConst;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
@author sun
*/
@RequestMapping("goods")
@Controller
@LoginFilter
public class GoodsController extends CoreController{

    @Autowired
    private GoodsService goodsService;
	@Autowired
	private AdminService adminService;

    @RequestMapping("/serviceList")
	@ResponseBody
	public String serviceList(Integer page, Integer rows,String name,Integer type,Integer source){
		QueryParams.Builder builder = QueryParams.newBuilder();
    	String id = UserUtils.getPrincipal().getId();
		builder.put("source",source);
		builder.put("type",type);
    	builder.put("name",name);
    	builder.put("orgId",id);

		PaginationSupport.byPage(page, rows);
		List<GoodsEx> list = goodsService.selectGoodsList(builder);
		return page(list);
	}

	@RequestMapping("/serviceAdminList")
	@ResponseBody
	public String serviceAdminList(Integer page, Integer rows,String name,Integer type,Integer source){
		QueryParams.Builder builder = QueryParams.newBuilder();
		builder.put("source",source);
		builder.put("type",type);
		builder.put("name",name);

		PaginationSupport.byPage(page, rows);
		List<GoodsEx> list = goodsService.selectGoodsList(builder);
		return page(list);
	}

	@RequestMapping("/save")
	@ResponseBody
	public String save(Goods goods){
		if (goods.getId() == null){
			goodsService.insert(goods);
		}else{
			goodsService.updateByPrimaryKeySelective(goods);
		}
		return ok();
	}

	@RequestMapping("/findByType")
	@ResponseBody
	public String findBySource(Integer type,Integer code){
		QueryParams.Builder builder = QueryParams.newBuilder();
		builder.put("type",type);
		builder.put("cateCode",code);
		List<GoodsEx> list = goodsService.selectGoodsList(builder);
		return ok(list);
	}
	@RequestMapping("/serviceSave")
	@ResponseBody
	public String serviceSave(Goods goods,Integer cateCode,Integer type,Integer source){
		if (goods.getPrice() == null){
			return msg(-1,"请输入出售价格");
		}
		/*if (goods.getPrice().compareTo(PaidangConst.BOUNDARY_PRICE) > 0){
			return msg(-1,"您上传的物品鉴定价格不能超过"+PaidangConst.BOUNDARY_PRICE.toString());
		}*/
		int w;
		int h;
		if (StringUtils.isEmpty(goods.getWidth()) && StringUtils.isEmpty(goods.getHeight())){
			return msg(-1,"请输入封面宽高");
		}
		try{
			w = Integer.valueOf(goods.getWidth());
			h = Integer.valueOf(goods.getHeight());
		}catch (NumberFormatException e){
			return msg(-1,"您输入的数字不正确");
		}
		int gy = gongyue(w,h);
		if (goods.getId() == null){
			goods.getImg();
			goods.setIsOnline(1);//1上架0下架
			goods.setIsVerfiy(1);//1审核中2通过3不通过
			goods.setSource(source);//1平台2机构3服务商
			goods.setState(1);//(针对竞拍)- 0已失效 1有效；现后台只能上传3万以下物品，且不是拍卖，是直接买卖
			goods.setSoldOut(0);//已售
			if (goods.getTotal()==null){
				goods.setTotal(1);//库存
			}
			goods.setCost(goods.getPrice());
			goods.setType(type);//1新品2绝当品
			goods.setCateCode(cateCode);

			Admin admin = adminService.selectByPrimaryKey(Integer.parseInt(UserUtils.getPrincipal().getId()));
			if(null != admin){
				if("admin".equals(admin.getRoleCode()) || "authAdmin".equals(admin.getRoleCode())){
					goods.setOrgId(0);
				}
			}else{
				goods.setOrgId(Integer.parseInt(UserUtils.getPrincipal().getId()));
			}


			//
			goods.setWidth(w/gy+"");
			goods.setHeight(h/gy+"");
			goodsService.insert(goods);
		}else{
			goodsService.updateByPrimaryKeySelective(goods);
		}
		return ok();
	}

	//求最大公约数
	public static int gongyue(int a,int b)
	{
		int gongyue=0;
		if(a<b)
		{   //交换a、b的值
			a=a+b;
			b=a-b;
			a=a-b;
		}
		if(a%b==0)
		{
			gongyue = b;
		}
		while(a % b>0)
		{
			a=a%b;
			if(a<b)
			{
				a=a+b;
				b=a-b;
				a=a-b;
			}
			if(a%b==0)
			{
				gongyue = b;
			}
		}
		return gongyue;
	}

	@RequestMapping("/changeState")
	@ResponseBody
		public String changeState(Integer id,Integer v,GoodsEx goods){
			goods.setId(id);
			goods.setIsVerfiy(v);
			if(goods.getIsVerfiy() != 3){
				goodsService.changeStateByPrimaryKey(goods);
			}else{
				goods.setIsVerfiy(1);
				goodsService.changeStateByPrimaryKey(goods);
			}
		return ok();
	}

	@RequestMapping("/soldOut")
	@ResponseBody
	public String soldOut(Integer id){
			if(id != null){
				Goods goods = goodsService.selectByPrimaryKey(id);
				goods.setState(0);
				goodsService.updateCreatTime(goods);
			}
		return ok();
	}
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	GoodsEx goods = goodsService.selectByPrimaryId(id);
       	return ok(goods);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		goodsService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


	@RequestMapping("/getOrgDeadPawnStoreList")
	@ResponseBody
	public String getOrgDeadPawnStoreList(){
    	String orgId = getSessionParameter("id");
		GoodsExample example = new GoodsExample();
		example.createCriteria().andOrgIdEqualTo(Integer.valueOf(orgId)).andSourceEqualTo(2);
		List<Goods> list = goodsService.selectByExample(example);
		return ok(list);
	}

	@RequestMapping("/saveOrgGoods")
	@ResponseBody
	public String saveOrgGoods(Goods goods){
		String orgId = getSessionParameter("id");
		if(goods.getId() == null){
			goods.setSource(2);//1平台2机构3服务商
			goods.setType(1);//1新品2绝当品
//			goods.setOrgId(Integer.valueOf(orgId));
			goods.setSoldOut(0);//已售
			goods.setIsOnline(1);//1上架0下架
			goods.setIsVerfiy(2);//1审核中2通过3不通过
			goodsService.insert(goods);
		}else{
			goodsService.updateByPrimaryKey(goods);
		}
		return ok();
	}

}