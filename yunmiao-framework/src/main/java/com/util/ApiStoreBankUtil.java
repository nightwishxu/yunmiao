package com.util;

import com.base.http.HttpRequest;
import com.base.http.HttpResponse;
import com.base.http.Method;
import com.base.support.LogKit;
import com.base.util.JSONUtils;
import com.base.util.StringUtil;
import com.util.apiStore.BankCardApiResult;
import com.util.apiStore.BankCardResult;
import io.swagger.annotations.Api;
import springfox.documentation.service.ApiKey;

/**
 * apistore 银行卡四要素接口工具类
 */
public class ApiStoreBankUtil {
    private static final String API_URL = "http://v.apistore.cn/api/bank/v4";
    private static final String API_KEY = "9e9adfe14193f3e829c3b8fa806e64e1";
    private static final boolean TEST = false;
    /**
     * 过滤信用卡验证
     */
    private static final String DC = "DC";
    /**
     * 过滤借记卡验证
     */
    private static final String CC = "CC";

    /**
     * 银行卡验证
     * @param name
     * @param phone
     * @param idCard
     * @param bankCard
     * @param cardType
     * @return BankCardResult
     */
    public static BankCardResult verifyJson(String name, String phone, String idCard, String bankCard, String cardType){
        String result = verify(name,phone,idCard,bankCard,cardType);
        if (result == null) return null;
        BankCardApiResult apiResult = JSONUtils.deserialize(result,BankCardApiResult.class);
        if (apiResult != null && apiResult.getError_code() == 0){
            return apiResult.getResult();
        }
        return null;
    }

    /**
     *
     * @param name 身份证姓名
     * @param phone 手机号码
     * @param idCard 身份证号码
     * @param bankCard 银行卡卡号
     * @return String
     */
    public static String verify(String name,String phone,String idCard, String bankCard, String cardType){
        if (StringUtil.isBlank(API_KEY) || TEST){
            return null;
        }
        HttpRequest request = new HttpRequest(API_URL);
        request.method(Method.POST);
        request.contentType("application/x-www-form-urlencoded");
        request.charset("utf-8");
        request.form("key",API_KEY).form("bankcard",bankCard).form("realName",name)
                .form("cardNo",idCard).form("Mobile",phone).form("information",1);
        if (StringUtil.isNotBlank(cardType)){
            request.form("cardtype", cardType);
        }
        HttpResponse response = request.execute();
        LogKit.debug(response.body());
        return response.body();
    }

    /**
     * 借记卡验证
     * @param name
     * @param phone
     * @param idCard
     * @param bankCard
     * @return BankCardResult
     */
    public static BankCardResult verifyDC(String name,String phone,String idCard, String bankCard){
        return verifyJson(name,phone,idCard,bankCard,DC);
    }

    /**
     * 信用卡验证
     * @param name
     * @param phone
     * @param idCard
     * @param bankCard
     * @return BankCardResult
     */
    public static BankCardResult verifyCC(String name,String phone,String idCard, String bankCard){
        return verifyJson(name,phone,idCard,bankCard,CC);
    }
}
