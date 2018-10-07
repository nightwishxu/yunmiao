package com.paidang.daoEx.model;

import com.paidang.dao.model.OrgBalanceLog;

/**
@author sun
*/
public class OrgBalanceLogEx extends OrgBalanceLog {

    //当户名称
    private String pawnerName;

	//当户手机号码
    private String pawnerTel;

    //当户账号
    private String pawnerAccount;

    public String getPawnerName() {
        return pawnerName;
    }

    public void setPawnerName(String pawnerName) {
        this.pawnerName = pawnerName;
    }

    public String getPawnerTel() {
        return pawnerTel;
    }

    public void setPawnerTel(String pawnerTel) {
        this.pawnerTel = pawnerTel;
    }

    public String getPawnerAccount() {
        return pawnerAccount;
    }

    public void setPawnerAccount(String pawnerAccount) {
        this.pawnerAccount = pawnerAccount;
    }
}