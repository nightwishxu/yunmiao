package com.item.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.base.dialect.PaginationSupport;
import com.base.dao.model.Ret;
import com.base.dao.model.Grid;
import com.base.entity.QueryParams;
import com.base.security.util.UserUtils;
import com.paidang.dao.model.VideoOnline;
import com.paidang.dao.model.VideoOnlineExample;
import com.paidang.daoEx.model.GoodsEx;
import com.paidang.service.GoodsService;
import com.paidang.service.VideoOnlineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.base.action.CoreController;
import com.item.dao.model.Ad;
import com.item.dao.model.AdExample;
import com.item.service.AdService;

/**
@author sun
*/
@RequestMapping("ad")
@Controller
@LoginFilter
public class AdController extends CoreController{

    @Autowired
    private AdService adService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private VideoOnlineService videoOnlineService;

	public enum MStoreGoodsCateList {
		zb("1","钟表","0"),
		fc("2","翡翠","0"),
		hty("3","和田玉","0"),
		gdysp("4","古董艺术品","0"),
		sh("5","书画","0"),
		cszb("6","彩色珠宝","0"),
		zs("7","钻石","0"),
		other("8","更多","0"),

		mqyt("9","明清砚台","4"),
		ww("10","文玩","4"),
		zx("11","杂项","4"),
		hlbs("12","红蓝宝石","6"),
		zml("13","祖母绿","6"),
		zz("14","珍珠","6"),
		bx("15","碧玺","6");

		private String code;
		private String name;
		private String fid;
		private MStoreGoodsCateList(String code,String name,String fid) {
			this.code = code;
			this.name = name;
			this.fid = fid;
		}

		public static String getName(String code) {
			for (MStoreGoodsCateList c : MStoreGoodsCateList.values()) {
				if (c.code.equals(code)) {
					return c.name;
				}
			}
			return null;
		}
	}
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows, Integer location){
    	PaginationSupport.byPage(page, rows);
    	AdExample example = new AdExample();
		example.createCriteria().andLocationEqualTo(location);
		example.setOrderByClause("sort_order desc");
    	
    	List<Ad> list = adService.selectByExampleWithBLOBs(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Ad ad){
    	if (ad.getId() == null){
    		if (ad.getLocation() != 4) {
    			ad.setDiscription(null);
			}
			if (ad.getType() == 0) {//不跳转
				//ad.setContent(null);
			}
			if (ad.getType() == 1) {//网址

			}
			if (ad.getType() == 3) {//认证商城商品详情页

			}
			if (ad.getType() == 4) {//绝当商城商品详情页

			}
			if (ad.getType() == 5) {//视频详情页

			}
			if (ad.getSortOrder() == null) {
				ad.setSortOrder(0);
			}
			ad.setCreateTime(new Date());
    		adService.insert(ad);
    	}else{
    		adService.updateByPrimaryKeySelective(ad);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	Ad ad = adService.selectByPrimaryKey(id);
       	return ok(ad);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		adService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }

	@RequestMapping("/goodsList")
	@ResponseBody
	public String goodsList(String q, Integer type){
		QueryParams.Builder builder = QueryParams.newBuilder();
		builder.put("name", q);
		builder.put("type", type);
		List<GoodsEx> list = goodsService.selectGoodsList(builder);
		List<GoodsEx> res = new ArrayList<GoodsEx>();
		for(GoodsEx item : list) {
			item.setName("【" + MStoreGoodsCateList.getName(item.getCateCode().toString()) + "】" + item.getName());
			res.add(item);
		}
		return ok(res);
	}

	@RequestMapping("/videoList")
	@ResponseBody
	public String videoList(String q){
		VideoOnlineExample example = new VideoOnlineExample();
		if (q != null && q != "") {
			example.createCriteria().andTitleLike(q);
		}
		example.setOrderByClause("create_time desc");
		List<VideoOnline> list = videoOnlineService.selectByExample(example);
		return ok(list);
	}
}