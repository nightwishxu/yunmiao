package com.util;

import java.math.BigDecimal;

/**
 * 拍档项目常量
 */
public interface PaidangConst {
    /**
     * 竞拍时间 30min * 60 = 1800 seconds
     */
    int AUCTION_TIME = 10*60;

    /*
    * 用户选择中标机构，该机构需要在 PAY_LIMIT_TIME 分钟内支付贷款
    * */
    int PAY_LIMIT_TIME = 2*60;
    /**
     * 服务商角色编号
     */
    String SERVICE_ORG_ROLE = "service_org_admin";

    /**
     * 机构角色
     */
    String ORG_ROLE = "org_admin";


    String SUPPLIER_ROLE = "supplier_admin";

    /*
    * 用户赎当逾期滞纳利率   2.5‰（废弃，改由机构后台灵活设置）
    * */

//    BigDecimal REDEEM_OVERRATE = new BigDecimal( "2.5");

    /*
    * 到期典当变绝当，缓冲天数
    * */
    int BUFFER_DAYS = 5;

    String INIT_PASSWORD = "123456";

    /**
     * 视频截图
     */
    String VIDEO_CUR_IMG = "_cut";

    /**
     * 视频压缩
     */
    String VIDEO_NORMAL = "_normal";

    /**
     * 视频分辨率
     */
    String VIDEO_SCREEN = "640x360";

    /**
     * 在线鉴定钻石常量
     */
    Double num = 0.3;

    /**
     * 一小时
     */
    int EXPRESS_QUERY_TIME = 60;

    /**
     * 绝当商场竞拍24小时 = 24*60*60秒
     */
    int JD_GOODS_TIME = 24*60*60;

    /*
    *
    * 物流公司
    * */

    String EXPRESSS_COMPANY = "顺丰快递";

    /*
    * 平台利率
    * */
    BigDecimal  PLATFORM_INTEREST = new BigDecimal("0.001");

    /*
    * 绝当拍卖价格分水岭
    * */
    BigDecimal BOUNDARY_PRICE = new BigDecimal("30000");

    /**
     * 订单24小时未付款 = 24*60*60秒
     */
    int ORDER_TIME = 24*60*60;
}
