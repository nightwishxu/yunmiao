package com.util.apiStore;

/**
 * 银行卡基本信息
 */
public class BankCardInfo {
    private String abbreviation;
    private String bankimage;
    private String bankname;
    private String banknum;
    private String bankurl;
    private String cardlength;
    private String cardname;
    private String cardprefixlength;
    private String cardprefixnum;
    private String cardtype;
    private String enbankname;
    private boolean isLuhn;
    private int iscreditcard;
    private String servicephone;


    public String getServicephone() {
        return servicephone;
    }

    public void setServicephone(String servicephone) {
        this.servicephone = servicephone;
    }

    public int getIscreditcard() {
        return iscreditcard;
    }

    public void setIscreditcard(int iscreditcard) {
        this.iscreditcard = iscreditcard;
    }

    public boolean isLuhn() {
        return isLuhn;
    }

    public void setLuhn(boolean luhn) {
        isLuhn = luhn;
    }

    public String getEnbankname() {
        return enbankname;
    }

    public void setEnbankname(String enbankname) {
        this.enbankname = enbankname;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardprefixnum() {
        return cardprefixnum;
    }

    public void setCardprefixnum(String cardprefixnum) {
        this.cardprefixnum = cardprefixnum;
    }

    public String getCardprefixlength() {
        return cardprefixlength;
    }

    public void setCardprefixlength(String cardprefixlength) {
        this.cardprefixlength = cardprefixlength;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardlength() {
        return cardlength;
    }

    public void setCardlength(String cardlength) {
        this.cardlength = cardlength;
    }

    public String getBankurl() {
        return bankurl;
    }

    public void setBankurl(String bankurl) {
        this.bankurl = bankurl;
    }

    public String getBanknum() {
        return banknum;
    }

    public void setBanknum(String banknum) {
        this.banknum = banknum;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankimage() {
        return bankimage;
    }

    public void setBankimage(String bankimage) {
        this.bankimage = bankimage;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
