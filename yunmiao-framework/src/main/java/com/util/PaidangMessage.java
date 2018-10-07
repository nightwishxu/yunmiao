package com.util;

/**
 * 拍当网消息模板
 */
public enum PaidangMessage {
    SYS_NOTIFY(1,"系统通知","{}",0),
    PAWN_SUCCESS_NOTIFY(0,"典当成功通知","您的藏品{}已经被{}成功竞拍得，您的贷款款项将在2小时内到款至您的{}账户!",1),
    PAWN_END_NOTIFY(0,"典当到期通知","您的藏品{}在{}典当行的典当还款日期即将到期，请您尽快做还款处理！逾期您的藏品将被视作放弃拥有权，即归为{}典当行所有",2),
    PAWN_REDEEM_NOTIFY(0,"赎当通知","您的藏品{}，在{}典当行的赎当申请已成功受理，将在7个工作日内邮寄至你处",3),
    PAWN_REDEEM_POST_NOTIFY(1,"赎当邮寄通知","{}",4),
    //POST_NOTIFY(0,"邮寄通知","{}",5),
    MONEY_RECEIVE_NOTIFY(0,"到款通知","您的账户收到一笔新款项，请前去查看",6),
    TRADE_SUCCESS_NOTIFY(0,"平台交易信息","平台已打款",10),
    AUTH_MAIL_OPER(0,"鉴宝信息","您的藏品{}已评估为真品",0),
    AUTH_MAIL_OPER_YP(0,"鉴宝信息","您的藏品{}已评估为赝品",0),
    AUTH_MAIL_OPER_CANNOT_AUTH(0,"鉴宝信息","您的藏品{}无法鉴定,理由{}",0),
    PAWN_WAS_BEEN_BID(0,"当品被竞拍通知","您的藏品被{}典当行竞拍了，请前去查看",8),
    PAWN_GOODS_END(0,"绝当通知","当品已经绝当",9),


    //以下是推送至机构端的，即写入p_org_notify表中
    USER_REPAWN_NOTIFY(0,"续当通知","当户{}续当成功了，续当时间为{}个月，续当费用为{}，请前去查看",1),
    USER_OVERDUE_NOTIFY(0,"滞纳通知", "当户{}已经逾期{}了，马上要变成绝当了，要去跟当户联系了",2),
    ORG_BIDWON_NOFIFY(0,"竞拍成功","您竞拍的当品{}，竞拍成功，请尽快支付当款",3),
    USER_REDEEM_NOTIFY(0,"赎当通知","当户{}在{}申请赎当，赎当费用为{}",4),
    PAWN_DEAD_NOTIFY(0,"绝当通知","当品{}已经逾期，已绝当",5),
    BAOXIANG_DOUDI(0,"平台兜底","当品{}已经被您兜底获得，请尽快支付当款",6)
    //USER_EXPIRE_NOTIFY(0,"到期提醒通知","用户{}的当品{}还有{}就要到期了，请注意查看",6),
    ;

    /**
     * 消息类型1:系统通知
     */
    private int type;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容模板
     */
    private String template;
    /**
     * 消息跳转类型
     */
    private int redirectType;

    PaidangMessage(int type,String title, String template,int redirectType){
        this.type = type;
        this.title = title;
        this.template = template;
        this.redirectType = redirectType;
    }

    public int getRedirectType() {
        return redirectType;
    }

    public String getTemplate() {
        return template;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }
}

