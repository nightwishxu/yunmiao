package com.util;

import com.base.pay.MPayType;

public enum MPaidangPayType implements MPayType {
    NORMAL_BUY, //商城
    ORG_RATE,    //机构给平台手续费
    ORG_CONTINUE    //机构续当手续费
    ;

    private MPaidangPayType() {
    }
}
