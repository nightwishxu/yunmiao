package com.base.api;

import com.base.ConstantsCode;
import com.base.CoreConstants;
import com.base.api.base.ErrorResult;
import com.util.PaidangSecureUtil;
import com.base.dao.model.Result;
import com.base.dao.model.Ret;
import com.base.util.JSONUtils;
import com.base.util.ResponseUtils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ApiBaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public ApiBaseController() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public void handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ErrorResult ret;
        if (ex instanceof ApiException) {
            ApiException se = (ApiException)ex;
            ret = new ErrorResult(se.getCode(), ex.getMessage());
        } else {
            this.logger.error(ex.getMessage(), ex);
            ret = new ErrorResult(500, ex.getMessage());
        }
        if (ConstantsCode.DEBUG || isAjax(request)){
            ResponseUtils.renderJson(response, ret);
        }else{
            ResponseUtils.renderText(response, PaidangSecureUtil.encrypt(JSONUtils.serialize(ret)));
        }

    }

    private boolean isAjax(HttpServletRequest request){
        boolean isAjax = false;
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            isAjax = true;
        }
        return ConstantsCode.AJAX_DEBUG&&isAjax;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    protected String getUrl(String fileid) {
        return this.getUrl(fileid, (Integer)null, (Integer)null);
    }

    protected String getUrl(String fileid, Integer width, Integer height) {
        if (StringUtils.isNotBlank(fileid)) {
            String url = CoreConstants.SERVER_URL + "download?id=" + fileid;
            if (width != null) {
                url = url + "&w=" + width;
            }

            if (height != null) {
                url = url + "&h=" + height;
            }

            return url;
        } else {
            return "";
        }
    }

    protected String getPage(Integer id, Integer type) {
        return CoreConstants.SERVER_URL + "detail?id=" + id + "&type=" + type;
    }

    protected Ret ok() {
        return new Ret();
    }

    protected Ret msg(int code, String msg) {
        return new Ret(code, msg);
    }

    protected Ret msg(String msg) {
        return this.msg(0, msg);
    }

    /**
     * 商品详情
     * @param id
     * @return
     */
    protected String getGoodsDetail(int id){
        return getPage(id,1);
    }
}
