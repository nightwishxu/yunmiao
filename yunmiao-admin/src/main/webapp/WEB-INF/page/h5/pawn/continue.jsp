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
    <title>续当办理</title>
    <meta name="description" content="云喵拍当"/>
    <meta name="keywords" content="云喵拍当"/>
    <link rel="stylesheet" href="${path}/static/m/css/certificate/common.css"/>
    <link rel="stylesheet" href="${path}/static/m/css/certificate/base.css"/>

</head>
<body>
<div class="wrapper">
    <!--背景遮罩-->
    <div class="bg-black dis_none" ></div>
    <div class="Img_panel"></div>

    <div class="c3 ran">
        <h2>${info.title}</h2>
        <dl class="clearfix">
            <dd class="fl">鉴定价：<em class="colred">¥<big>${info.authPrice}</big></em></dd>
            <dd class="fr">当号：<em>${info.goodsId}</em></dd>
        </dl>
        <dl class="twoblock">
            <dd>
                <c:forEach items="${info.images}" var="item" >
                    <em>
                        <img src="<c:out value="../../${path}/download?id=${item}"/>" onclick="showBigImg(this);"/>
                    </em>
                    <br>
                </c:forEach>
            </dd>
        </dl>
    </div>

    <div class="c3">
        <dl class="fourblock">
            <dd class="clearfix">
                <em class="dis_block">典当行：<big>${info.orgName}</big></em>
                <em class="fl">综合费率：<big>${info.rate}</big></em>
                <em class="fr">已发放当金：<big>¥${info.money}</big></em>
                <div class="clearfix"></div>
                <em class="dis_block">利息费率：<big>${info.moneyRate}%/月</big></em>
            </dd>
        </dl>

        <dl class="fourblock">
            <h5>贷款起始日期：</h5>
            <dd class="clearfix">
                <em class="dis_block">借款日期：<big>${info.beginTime}</big></em>
                <em class="dis_block">当前应还款日期：<big>${info.endTime}</big></em>
            </dd>
        </dl>
    </div>

</div>

</body>
<script type="text/javascript" src="${path}/static/m/js/certificate/common.js"></script>
<script type="text/javascript" src="${path}/static/m/js/certificate/fastclick.js"></script>

</html>