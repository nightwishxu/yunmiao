package com.item.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.view.common.AppVersion;
import com.api.view.common.LoadingImg;
import com.base.CoreConstants;
import com.base.action.CoreController;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.io.IoUtil;
import com.base.util.DFA;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.item.dao.model.Code;
import com.item.dao.model.CodeExample;
import com.item.dao.model.CodeExample.Criteria;
import com.item.service.CodeService;

@RequestMapping("code")
@Controller
@LoginFilter
public class CodeController extends CoreController{
	@Autowired
	private CodeService codeService;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(Integer page,Integer rows,String code){
		PaginationSupport.byPage(page, rows);
		CodeExample example = new CodeExample();
		Criteria criteria = example.createCriteria().andCodeNotLike("%@sys").andCodeNotEqualTo("welcome");//去除单独维护的参数
		if(!StringUtils.isBlank(code)){
			criteria.andCodeEqualTo(code);
		}
		List<Code> list = codeService.selectByExample(example);
		return page(list);
	}
	@RequestMapping("findById")
	@ResponseBody
	public String findById(String code){
		Code codes = codeService.getByCode(code);
		return ok(codes);
	}
	
	@RequestMapping("saveVersion")
	@ResponseBody
	public String saveVersion(String code,AppVersion appVersion){
		Code record = new Code();
		record.setCode(code);
		record.setValue(JSONUtils.serialize(appVersion));
		codeService.updateByPrimaryKeySelective(record);
		return ok();
	}
	
	@RequestMapping("saveLoading")
	@ResponseBody
	public String saveLoading(String code,LoadingImg appVersion){
		Code record = new Code();
		record.setCode(code);
		record.setValue(JSONUtils.serialize(appVersion));
		codeService.updateByPrimaryKeySelective(record);
		return ok();
	}
	
	@RequestMapping("save")
	@ResponseBody
	public String save(Code code){
		int i = this.codeService.updateByPrimaryKeySelective(code);
		if(i == 0){
			codeService.insertSelective(code);
		}
		return ok();
	}
	@RequestMapping("/del")
	@ResponseBody
	public String del(String code)throws Exception{
		String[] ids = code.split(",");
		for (String c : ids) {
			codeService.deleteByPrimaryKey(c);
		}
		return ok();
	}

	@RequestMapping("/checkExists")
	@ResponseBody
	public String checkExists(String value) throws Exception {
		CodeExample example = new CodeExample();
		example.createCriteria().andCodeEqualTo(value);
		int cnt = codeService.countByExample(example);
		if (cnt > 0) return msg(1);
		return ok();
	}
	
	@RequestMapping("/loadSensitiveWords")
	@ResponseBody
	public String loadSensitiveWords()throws Exception{
		String txt = "";
		String filePath = CoreConstants.getProperty("social.sensitive_word_filepath");
		if(StringUtils.isNotBlank(filePath)){
			File file = new File(filePath);
			if (!(file.isFile() && file.exists())){
				file.createNewFile();
			}
			if(file.isFile() && file.exists()){
				try {
					txt = IoUtil.read(new FileInputStream(file), "utf-8");
				} catch (Exception e) {
					e.printStackTrace();
					return JSONUtils.serialize(new Ret(1,"敏感词加载失败"));
				}
			}
		}
		return JSONUtils.serialize(new Ret(0,txt));
	}
	
	@RequestMapping("/saveSensitiveWords")
	@ResponseBody
	public String saveSensitiveWords(String content)throws Exception{
		String filePath = CoreConstants.getProperty("social.sensitive_word_filepath");
		if(StringUtils.isNotBlank(filePath)){
			File file = new File(filePath);
			if(file.isFile() && file.exists()){
				try {
					IoUtil.write(new FileOutputStream(file), true, content.getBytes("utf-8"));
					if(DFA.keyMap != null)
						DFA.reloadData();
				} catch (Exception e) {
					e.printStackTrace();
					return JSONUtils.serialize(new Ret(1,"敏感词保存失败"));
				}
			}
		}
		return JSONUtils.serialize(new Ret(0));
	}
}
