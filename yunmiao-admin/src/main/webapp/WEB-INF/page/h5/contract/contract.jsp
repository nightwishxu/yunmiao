<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="/static/m/jsp/include.jsp"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="renderer" content="webkit"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=0.5,maximum-scale=1.5,user-scalable=yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>电子典当合同</title>
    <meta name="description" content="云喵拍当"/>
    <meta name="keywords" content="云喵拍当"/>
    <link href="${path}/static/m/css/certificate/common.css" rel="stylesheet" type="text/css">
    <link href="${path}/static/m/css/certificate/base.css" rel="stylesheet" type="text/css">

</head>
<script>
    $(function() {
    console.log('${htfUrl}')
        if('${info.state}'){
            if(1 == '${info.state}'){
                //机构确认续当申请
                $("#showImgs").attr("ht_over");
                $("#showImgs").show();
                $("#pawnType").html("电子续当合同")

            }else if(0 == '${info.state}'){
                //
                $("#showImgs").attr("ht_pre");
                $("#showImgs").show();
                $("#pawnType").html("电子续当合同")
            }else{
                $("#showImgs").hide();
                $("#pawnType").html("电子典当合同")
            }

        }

})
</script>
<body>
<div class="wrapper">
    <h2 style="text-align: center;font-size: .4rem;color: #333333;line-height: .8rem;" id="pawnType">电子典当合同</h2>
    <div class="c4">
        <div class="top_title pd20 clearfix">
            <h3 class="fl">当号：${info.code}</h3>
            <!-- 待确认 ht_pre ; 已完成 ht_over -->
            <em id="showImgs" class="fr ht_over"></em>
        </div>
        <dl class="ht_txt pd20">
            <dd>${info.title}</dd>
            <dd>蔵品主人：${info.userName}</dd>
            <dd>鉴定价：¥${info.authPrice}</dd>
        </dl>
    </div>

    <div class="c4">
        <div class="top_title pd20 clearfix">
            <h3 class="fl">典当行信息</h3>
        </div>
        <dl class="ht_txt pd20">
            <dd>${info.orgName}</dd>
            <dd>法人代表：${info.legalPerson}</dd>
            <dd>注册资金：${info.registeredCapital}万</dd>
            <dd>注册地址：${info.address}</dd>
        </dl>
        <dl class="ht_txt pd20">
            <dd>当款：${info.money}元</dd>
            <dd>当期：${info.pawnBeginTime}至${info.pawnEndTime}</dd>
            <dd>月费率：${info.rate}%/月</dd>
            <dd>月利率：${info.serverRate}%/月</dd>
            <dd>逾期滞纳费率：${info.overdueRate}%/月</dd>
        </dl>
    </div>

    <div class="c4">
        <div class="top_title pd20 clearfix">
            <h3 class="fl">入账银行卡</h3>
        </div>
        <dl class="ht_txt pd20">
            <dd>${info.bankName} ${info.bankCodeNo}</dd>
        </dl>
    </div>

    <div class="c4">
        <dl class="ht_txt pd20">
            <dd>根据<a href="${htfUrl}">《合同法》</a>、<a href="${msfUrl}">《民事法》</a>、<a href="${ddglfUrl}">《典当管理法》</a>，我都已理解并认可了本合同的所有内容，同意承担各自应承担的权利和义务，忠实地履行本合同。</dd>
        </dl>
    </div>

    <div class="c4">
        <dl class="ht_txt pd20">
            <dd>签订时间：${info.time}</dd>
        </dl>
    </div>







</div>

</body>
<script type="text/javascript" src="${path}/static/m/js/certificate/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="${path}/static/m/js/certificate/common.js"></script>
<script type="text/javascript" src="${path}/static/m/js/certificate/fastclick.js"></script>

</html>