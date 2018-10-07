package com.paidang.daoEx.model;

import com.paidang.dao.model.Certificate;
import com.paidang.dao.model.CertificateLog;

import java.util.Date;
import java.util.List;

/**
@author sun
*/
public class CertificateEx extends Certificate {

    private String recordTime;

    private String recordPrice;

    private List<CertificateLog> list;

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordPrice() {
        return recordPrice;
    }

    public void setRecordPrice(String recordPrice) {
        this.recordPrice = recordPrice;
    }

    public List<CertificateLog> getList() {
        return list;
    }

    public void setList(List<CertificateLog> list) {
        this.list = list;
    }
}