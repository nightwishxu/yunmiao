package com.webSite.action;

import com.api.view.account.SmsCode;
import com.base.api.ApiException;
import com.base.api.sms.SmsError;
import com.base.cache.bean.MobileCodeRedisCache;
import com.base.dao.model.Ret;
import com.base.util.StringUtil;
import com.item.dao.model.UserExample;
import com.item.service.SmsSendLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/webApi")
public class WebH5Controller extends WebBaseController{
    @Autowired
    private SmsSendLogService smsSendLogService;

    @RequestMapping(value = "/account/getMobileMsg",method= RequestMethod.POST)
    @ResponseBody
    public Ret register(String phone, Integer type) throws Exception {


        // 发送短信
        String mobileCode = StringUtil.getRandomNum(6);
        String content = new String("您的验证码是：" + mobileCode + "。请不要把验证码泄露给其他人。请于5分钟内完成验证！");

        String result = smsSendLogService.sendIdentifySms(phone, null,
                null, content,type);
        if ("2".equals(result)) {
            // 发送成功
            MobileCodeRedisCache.set(phone, mobileCode,86400L);
        } else {
            // 发送失败,可以细化错误原因
            String error = SmsError.getSmsError(result);
        }

//        SmsCode ret = new SmsCode();
//        ret.setCode(mobileCode + "");
        return new Ret(1);
    }

    @RequestMapping(value = "/account/checkCode",method= RequestMethod.POST)
    @ResponseBody
    public Ret checkCode(String phone, String code, String type){
        String key = phone;

        System.out.println(MobileCodeRedisCache.get(key));
        // 验证码验证
        String value = MobileCodeRedisCache.get(key);
        if(!code.equals(value)){
            return new Ret(-1,"验证码不正确");
        }

        return new Ret(1,code);
    }

}
