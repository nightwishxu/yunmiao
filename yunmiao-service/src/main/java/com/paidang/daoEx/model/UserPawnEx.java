package com.paidang.daoEx.model;

import com.paidang.dao.model.UserPawn;

import java.math.BigDecimal;

/**
@author sun
*/
public class UserPawnEx extends UserPawn {

    //当品名称
    private String goodsName1;

    //当品图片
    private String images;

    //当品鉴定价
    private BigDecimal authPrice;

    //当品估价
	private BigDecimal authPriceTest;

	//参与对该当品竞拍的机构总数量
    private String bidTimes;

    //某一当户在某一机构下贷款总额
    private BigDecimal totalAmountForPawner;

    //到期剩余天数
    private String expireDays;

    //用户银行卡名称
    private String bankCardName;

    //用户银行卡号
    private String bankCardNo;

    //宝贝鉴定类别code
    private Integer cateCode;

    //宝贝鉴定类别id
    private Integer cateId;

    //机构竞拍次数
    private Integer cnt;

    //鉴定结果
    private Integer authResult;

    private Integer goSellType;

 /*
    //确认的 机构名称
    private String orgName;

    //机构联系电话
    private String orgPhone;

    //机构地址
    private String orgAddress;

    //经营许可证
    private String businessLicense;

    //机构印章
    private  String orgSeal;*/

    //用户头像
    private String headImg;

    //最新一期续当状态 -1机构拒绝1申请2机构确认3用户打款并上传凭证4机构确认5机构未收到
    private Integer pawnContinueState;
   /*
    //用户姓名
    private String userName;

    //用户手机号码
    private String userPhone;

    //用户身份证
    private String userIdCard;

    // 用户地址
    private String userAddress;*/

    private Integer pawnLogId;


    public String getGoodsName1() {
        return goodsName1;
    }

    public void setGoodsName1(String goodsName1) {
        this.goodsName1 = goodsName1;
    }

    public BigDecimal getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(BigDecimal authPrice) {
        this.authPrice = authPrice;
    }

    public BigDecimal getAuthPriceTest() {
        return authPriceTest;
    }

    public void setAuthPriceTest(BigDecimal authPriceTest) {
        this.authPriceTest = authPriceTest;
    }

    public String getBidTimes() {
        return bidTimes;
    }

    public void setBidTimes(String bidTimes) {
        this.bidTimes = bidTimes;
    }

    public BigDecimal getTotalAmountForPawner() {
        return totalAmountForPawner;
    }

    public void setTotalAmountForPawner(BigDecimal totalAmountForPawner) {
        this.totalAmountForPawner = totalAmountForPawner;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

   /* public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

     @Override
    public String getOrgAddress() {
        return orgAddress;
    }

    @Override
    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }


    @Override
    public String getOrgSeal() {
        return orgSeal;
    }

    @Override
    public void setOrgSeal(String orgSeal) {
        this.orgSeal = orgSeal;
    }
*/
   /* public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserPhone() {
        return userPhone;
    }

    @Override
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String getUserIdCard() {
        return userIdCard;
    }

    @Override
    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }*/

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getExpireDays() {
        return expireDays;
    }

    public void setExpireDays(String expireDays) {
        this.expireDays = expireDays;
    }


    public String getBankCardName() {
        return bankCardName;
    }

    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public Integer getCateCode() {
        return cateCode;
    }

    public void setCateCode(Integer cateCode) {
        this.cateCode = cateCode;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getPawnContinueState() {
        return pawnContinueState;
    }

    public void setPawnContinueState(Integer pawnContinueState) {
        this.pawnContinueState = pawnContinueState;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Integer getAuthResult() {
        return authResult;
    }

    public void setAuthResult(Integer authResult) {
        this.authResult = authResult;
    }

    public Integer getGoSellType() {
        return goSellType;
    }

    public void setGoSellType(Integer goSellType) {
        this.goSellType = goSellType;
    }

    public Integer getPawnLogId() {
        return pawnLogId;
    }

    public void setPawnLogId(Integer pawnLogId) {
        this.pawnLogId = pawnLogId;
    }
}