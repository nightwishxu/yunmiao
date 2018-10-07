package com.h5.view;



/**
 *
 */
public class CertificateLogModel {

    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private Integer certificateId;

    /**
     *流通日期
     */
    private String logTime;

    /**
     *流通价格
     */
    private java.math.BigDecimal price;

    /**
     *
     */
    private java.util.Date createTime;

    public void setId(Integer id) {
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId=certificateId;
    }

    public Integer getCertificateId() {
        return certificateId;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public void setPrice(java.math.BigDecimal price) {
        this.price=price;
    }

    public java.math.BigDecimal getPrice() {
        return price;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime=createTime;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

}
