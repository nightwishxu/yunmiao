package com.item.action;

import java.util.HashMap;
import java.util.Map;

import com.item.dao.model.Ad;
import com.item.service.AdService;
import com.paidang.dao.model.Goods;
import com.paidang.service.GoodsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.action.CoreController;
import com.item.dao.model.Focus;
import com.item.dao.model.SinglePage;
import com.item.service.FocusService;
import com.item.service.SinglePageService;
import com.weixin.service.ArticleService;

@Controller
public class SystemController extends CoreController {
	@Autowired
	private SinglePageService singlePageService;
	@Autowired
	private FocusService focusService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private AdService adService;

	/**
	 * webview
	 * @param id
	 * @param type 类型
	 */
	@RequestMapping("/detail")
	public String detail(Integer id, Integer type, ModelMap map) throws Exception {
		if (id == null || type == null) {
			return null;
		}
		Map<String,Object> ret = new HashMap<String,Object>();
		switch (type) {
		case 1:
			//type==1 商城
			Goods goods = goodsService.selectByPrimaryKey(id);
			if (goods != null){
				ret.put("content", goods.getInfo());
				map.put("obj", ret);
			}else {
				return "common/404";
			}
			break;
		case 2:
			// type==2 焦点图
			Focus focus = focusService.selectByPrimaryKey(id);
			if (focus != null) {
				ret.put("content", focus.getContent());
				map.put("obj", ret);
			} else {
				return "common/404";
			}
			break;
		case 3:
			// type==3 微信详情页
			break;
		case 8:
			// type==8 新闻
			break;
		case 9:
			break;
		case 10:
			//type==10 新广告轮播图——add by dml
			Ad ad = adService.selectByPrimaryKey(id);
			if (ad != null){
				ret.put("content", ad.getContent());
				map.put("obj", ret);
			}else {
				return "common/404";
			}
			break;
		default:
			break;
		}
		return "common/detail";
	}

	@RequestMapping("/singlePage/{code}")
	public String detail(@PathVariable("code")String code,ModelMap map) throws Exception {
		if (StringUtils.isBlank(code)) {
			return null;
		}
		SinglePage page = singlePageService.selectByPrimaryKey(code);
		if(page == null) page = new SinglePage();
		map.put("obj", page);
		return "common/detail";
	}
}