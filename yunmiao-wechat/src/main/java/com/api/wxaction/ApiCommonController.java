package com.api.wxaction;

import com.paidang.service.CacheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.MEnumError;
import com.api.view.common.AppVersion;
import com.api.view.common.LoadingImg;
import com.base.api.ApiBaseController;
import com.base.api.ApiException;
import com.base.api.MobileInfo;
import com.base.api.annotation.ApiMethod;
import com.base.api.model.ApiFile;
import com.base.dao.model.Ret;
import com.base.service.BFileService;
import com.base.util.JSONUtils;
import com.base.util.StringUtil;
import com.item.dao.model.Feedback;
import com.item.service.CodeService;
import com.item.service.FeedbackService;

@RestController
@RequestMapping(value="/api/common", produces = {"application/json;charset=UTF-8"})
@Api(tags = "公共接口")
public class ApiCommonController extends ApiBaseController{

	@Autowired
    private BFileService fileService;
	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private CodeService codeService;

	@Autowired
	private CacheService cacheService;
	
	private static final String[] DEVICE = new String[]{"android","ios"};
	
	@ApiOperation(value = "文件读取", notes = "")
    @RequestMapping(value = "/download",method = {RequestMethod.GET,RequestMethod.POST})
    @ApiMethod
    public void download(@RequestParam(value = "id", required = true) @ApiParam(value="文件id",required = true)String id,
			@RequestParam(value = "w", required = false) @ApiParam(value="图片宽度:60",required = false)String w,
			@RequestParam(value = "h", required = false) @ApiParam(value="图片高度:60",required = false)String h,
			@RequestParam(value = "q", required = false) @ApiParam(value="图片的质量，0~25：差，50~75：中等，75~100高",required = false)String q,
			@RequestParam(value = "type", required = false) @ApiParam(value="类型,图片类型默认inline直接显示",required=false)String type,
			@ApiParam(hidden = true)HttpServletResponse resp,
			@ApiParam(hidden = true)HttpServletRequest request)throws Exception{
		fileService.getFile(id, w, h, null, resp, type,request);
	}
	
    @ApiOperation(value = "文件上传", notes = "")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiMethod
    public ApiFile upload(HttpServletRequest request) throws Exception {
    	if (!ServletFileUpload.isMultipartContent(request)){
			throw new ApiException("files");
		}
    	
    	FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		
		List<FileItem> list = upload.parseRequest(request);
		
		ApiFile  ret = new ApiFile();
		
		int max = list == null ? -1 : list.size() - 1;
		if (max == -1){
			throw new ApiException("files");
		}
		
		StringBuffer sb = new StringBuffer();
		StringBuffer url = new StringBuffer();
		for (int i = 0; ; i++){
			FileItem file = list.get(i);
			if (!file.isFormField()){
				if (sb.length() > 0){
					sb.append(",");
					url.append(",");
				}
				String temp = fileService.uploadFile(file.get(), file.getName(), BFileService.LOCAL);
				sb.append(temp);
				url.append(getUrl(temp));
			}
			if (i == max){
				ret.setId(sb.toString());
				ret.setPath(url.toString());
				return ret;
			}
		}
    }
	
	/**
	 * 用户反馈
	 * @param content 内容
	 */
    @ApiMethod
    @RequestMapping(value="/feedback", method = RequestMethod.POST)
    @ApiOperation(value = "用户反馈", notes = "不需要登录")
    public Ret feddBack(@ApiParam(value="反馈内容",required = true) String content,
    		@ApiParam(value="手机号",required = false) String phone,MobileInfo mobileInfo) throws Exception{
    	if (StringUtils.isBlank(content)) {
			throw new ApiException("content");
		}
		if (StringUtils.isBlank(phone)) {
			throw new ApiException("phone");
		}
		Feedback record = new Feedback();
		record.setCreateTime(new Date());
		record.setInfo(content);
//		record.setPhone(phone);
		if (mobileInfo != null){
			record.setUserId(mobileInfo.getUserid());
		}
		feedbackService.insert(record);
		return new Ret(1, "反馈成功");
    }
	
	/**
	 * 获取系统常量
	 */
	
	/**
	 * 获取单个系统常量
	 */
	
	/**
	 * 焦点图列表
	 * @param restraint //地区编号
	 * @param location //焦点图位置 1:首页
	 */
	
	/**
	 * 通知列表(需要登录,分页)
	 * @param type //类型 1:系统通知
	 * @param showType //显示类型 1:只显示标题 2:全部显示
	 */
	
	/**
	 * 删除通知
	 * @param id 无则清空
	 * @param type //类型 1:系统通知
	 */
	
	/**
	 * 通知未读个数(需要登录)
	 * @param number type //类型 1:系统通知
	 */
	
	/**
	 * 通知设为已读
	 * @param id
	 */
	
	/**
	 * 通知详情
	 * @param id
	 */
	
	/**
	 * 积分日志列表
	 * @param type	//0:全部 1:来源 2:消费记录
	 */
    
    /**
     * 欢迎页
     */
    @ApiMethod
    @RequestMapping(value="/loadingImg", method = RequestMethod.POST)
    @ApiOperation(value = "欢迎页", notes = "不需要登录")
    public LoadingImg loadingImg(){
    	String reuslt = codeService.getCode("welcome");
    	if (StringUtil.isBlank(reuslt)){
    		throw new ApiException(MEnumError.APP_VERSION_NULL);
    	}
    	LoadingImg loadingImg = JSONUtils.deserialize(reuslt, LoadingImg.class);
    	if (loadingImg == null){
    		throw new ApiException(MEnumError.APP_VERSION_NULL);
    	}
    	return loadingImg;
    }
    
    /**
     * 版本更新
     */
    @ApiMethod
    @RequestMapping(value="/appVerion", method = RequestMethod.POST)
    @ApiOperation(value = "APP版本获取", notes = "不需要登录")
    public AppVersion getVersion(@ApiParam(value = "设备类型 1:android 2:ios", required = true) Integer deviceType){
    	if (deviceType == null){
    		throw new ApiException("deviceType");
    	}
    	String reuslt = codeService.getCode(DEVICE[deviceType - 1]+"@sys");
    	if (StringUtil.isBlank(reuslt)){
    		throw new ApiException(MEnumError.APP_VERSION_NULL);
    	}
    	AppVersion version = JSONUtils.deserialize(reuslt, AppVersion.class);
    	if (version == null){
    		throw new ApiException(MEnumError.APP_VERSION_NULL);
    	}
    	return version;
    }

	@ApiMethod
	@RequestMapping(value="/express", method = RequestMethod.POST)
    @ResponseBody
	@ApiOperation(value = "物流公司获取", notes = "不需要登录")
	public List<String> express(){
		return CacheService.expressList;
	}
}
