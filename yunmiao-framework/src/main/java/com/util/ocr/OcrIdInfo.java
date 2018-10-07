package com.util.ocr;

public class OcrIdInfo {

    /**
     * 证件姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 民族
     */
    private String nation;
    /**
     * 出生日期
     */
    private String birth;
    /**
     * 地址
     */
    private String address;
    /**
     * 身份证号
     */
    private String id;
    /**
     * valid_date
     */
    private String valid_date;
    /**
     * 发证机关
     */
    private String authority;
    /**
     * OCR识别的身份证正面base64编码照片
     */
    private String frontimage;
    /**
     * OCR识别的证件身份证反面base64编码照片
     */
    private String backimage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValid_date() {
        return valid_date;
    }

    public void setValid_date(String valid_date) {
        this.valid_date = valid_date;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getFrontimage() {
        return frontimage;
    }

    public void setFrontimage(String frontimage) {
        this.frontimage = frontimage;
    }

    public String getBackimage() {
        return backimage;
    }

    public void setBackimage(String backimage) {
        this.backimage = backimage;
    }
}
