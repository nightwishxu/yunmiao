package com.util;

import com.base.ConstantsCode;
import com.base.crypto.DesUtils;
import com.base.crypto.RSAUtils;
import com.base.crypto.SecureUtil;
import com.base.crypto.asymmetric.KeyType;
import com.base.crypto.asymmetric.RSA;
import com.base.lang.Base64;

public class PaidangSecureUtil {

    private static final String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTYhPsoSzpp2NQgU/biSo7rjO22vQny7mCgBOZUT6jSbihBISOS90bJ+qkE1xcsSyUvYaT3lhNIIZYrVt9GJmyx2oBFk9qqPo+Jl7hL+Kcf126+lUppsEYllkutaFwLC/msgDqqs8EGCPt6KXo3lYQ9v/fH+Mw3CPVhM6Ab3JcuQIDAQAB";
    private static final String RSA_PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJNiE+yhLOmnY1CBT9uJKjuuM7ba9CfLuYKAE5lRPqNJuKEEhI5L3Rsn6qQTXFyxLJS9hpPeWE0ghlitW30YmbLHagEWT2qo+j4mXuEv4px/Xbr6VSmmwRiWWS61oXAsL+ayAOqqzwQYI+3opejeVhD2/98f4zDcI9WEzoBvcly5AgMBAAECgYAdCqyGalQhTpyhVnnX9rVdwTvrgkWuOdS6RGaYRYwkPPimse804voUyc7QugfvM/Jm9Nm59YxM1mXiv3ZRtjFC3LO2fgUd5EOLeCExJMIpBbQp7r/x/H9xXyOulZgQlNwX5MA1SdkSJQ8FkzPOyFuLO2yc+cvyNN30fbRePAeSCQJBAPSjVfjlbuMu2xwjChr+Kjb3eBrmmNnnmkN3CwYvMr2WsBgL6oE9e9hPPlKNjPsNhvA+oVQDvBPTE2Afcnq9JqMCQQCaOmnmq1zreF8fEy1GYq+8+jsLUsxXTs+q6xC/m/wTW4wkhVqs1Q0QWbBLpohymbRZnrN10iJ/wilFiLeY2ZDzAkAWiuKGL+Ya6xtnqVbqC9ep/v3DRNJ66duOMe8DH+BGFhed76MpS5gY45xzkPWXwLRZePv2uO1gykdzyRIMe1ePAkAQkdAI4UZFYhROIWBO3JFm6zdmuwmLI8N56HFPNLH7Xm2LCuy3/te9dvVS21xze4H90ugS83WTZkfK2apn+I/zAkBYTE5rDyeRlI8cXB5+dVZHbPsN9HyCTSkZSeBxaXOtFsq798EKboqTLq5C8siKSWhdaxlmddvKTAg95zdqGOur";
    private static final RSA rsa = SecureUtil.rsa(RSA_PRIVATE_KEY,RSA_PUBLIC_KEY);

    private enum encrypt{
        DES,RSA
    }

    /**
     * 拍当网加密
     * @param str
     * @return
     */
    public static String encrypt(String str){
        return ConstantsCode.ENCRYPT.equals(encrypt.DES.name())?DesUtils.encrypt(str):rsa(str);
    }

    public static String encrypt2(String str){
        return rsa.encryptStr(str, KeyType.PrivateKey);
    }


    public static String rsa(String str){
        try {
            byte[] b = RSAUtils.encryptByPrivateKey(str.getBytes(),RSAUtils.PRIVATE_KEY);
            return Base64.encode(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(rsa.encrypt("{\"data\":[{\"cateType\":\"卡地亚/宝格丽/提夫尼\",\"code\":1,\"icon\":\"d0bf1ce45bd64748897000b057028e51\",\"id\":10,\"name\":\"奢侈品珠宝\"},{\"cateType\":\"腕表/ 怀表\",\"code\":2,\"icon\":\"b0c21ee9bb6c46669ec041309beaf001\",\"id\":11,\"name\":\"手表\"},{\"cateType\":\"裸钻/ 钻饰\",\"code\":3,\"icon\":\"3897ffbfc5a04b08bdddc7de109b120e\",\"id\":12,\"name\":\"钻石\"},{\"cateType\":\"黄金/铂金/k金\",\"code\":4,\"icon\":\"8376afaebcd44045aed6f1560e868510\",\"id\":13,\"name\":\"贵金属\"},{\"cateType\":\"手镯/吊坠/ 戒指\",\"code\":5,\"icon\":\"b8d6ab3431d1486fb2013e7b6f7e1768\",\"id\":14,\"name\":\"翡翠玉石\"},{\"cateType\":\"吊坠/摆饰\",\"code\":6,\"icon\":\"c95536e8f3b14c438a770b6910961102\",\"id\":15,\"name\":\"和田玉\"},{\"cateType\":\"其他\",\"code\":7,\"icon\":\"917fdc7f565b48fa818efe9f08ebd5f7\",\"id\":16,\"name\":\"其它\"}],\"errorCode\":0,\"errorMsg\":\"\"}".getBytes(),KeyType.PrivateKey));
//        System.out.println(encrypt2("{\"data\":[{\"cateType\":\"卡地亚/宝格丽/提夫尼\",\"code\":1,\"icon\":\"d0bf1ce45bd64748897000b057028e51\",\"id\":10,\"name\":\"奢侈品珠宝\"},{\"cateType\":\"腕表/ 怀表\",\"code\":2,\"icon\":\"b0c21ee9bb6c46669ec041309beaf001\",\"id\":11,\"name\":\"手表\"},{\"cateType\":\"裸钻/ 钻饰\",\"code\":3,\"icon\":\"3897ffbfc5a04b08bdddc7de109b120e\",\"id\":12,\"name\":\"钻石\"},{\"cateType\":\"黄金/铂金/k金\",\"code\":4,\"icon\":\"8376afaebcd44045aed6f1560e868510\",\"id\":13,\"name\":\"贵金属\"},{\"cateType\":\"手镯/吊坠/ 戒指\",\"code\":5,\"icon\":\"b8d6ab3431d1486fb2013e7b6f7e1768\",\"id\":14,\"name\":\"翡翠玉石\"},{\"cateType\":\"吊坠/摆饰\",\"code\":6,\"icon\":\"c95536e8f3b14c438a770b6910961102\",\"id\":15,\"name\":\"和田玉\"},{\"cateType\":\"其他\",\"code\":7,\"icon\":\"917fdc7f565b48fa818efe9f08ebd5f7\",\"id\":16,\"name\":\"其它\"}],\"errorCode\":0,\"errorMsg\":\"\"}"));
    }
}
