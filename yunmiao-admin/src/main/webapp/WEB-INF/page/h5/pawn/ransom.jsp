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
    <title>赎当办理</title>
    <meta name="description" content="云喵拍当"/>
    <meta name="keywords" content="云喵拍当"/>
    <link rel="stylesheet" href="${path}/static/m/css/certificate/common.css"/>
    <link rel="stylesheet" href="${path}/static/m/css/certificate/base.css"/>
    <script type="text/javascript">
        $(function(){
            var data = ${info};
            console.log(data)
            if(data.pawnTime == 1){
                $("#month").val("0.5个月");
            }else{
                var time = date.pawnTime % 2;
                $("#month").val(time + "个月");
            }
        })
    </script>

</head>
<body>
<div class="wrapper">
    <!--背景遮罩-->
    <div class="bg-black dis_none" ></div>
    <div class="Img_panel"></div>

    <div class="c3 ran">
        <h2>${info.name}</h2>
        <dl class="clearfix">
            <dd class="fl">鉴定价：<em class="colred">¥<big>${info.authPrice}</big></em></dd>
            <dd class="fr">当号：<em>${info.pawnticketCode}</em></dd>
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
                <em class="fl">已发放当金：<big>¥${info.money}</big></em>
                <em class="fr">上期典当期限：<big id="month">0</big></em>
            </dd>
            <dd class="clearfix">
                <em class="fl">综合费率：<big>${info.rate}%/月</big></em>
                <em class="fr">利息费率：<big>${info.redeemRate}%/月</big></em>
            </dd>
            <dd class="clearfix">
                <em>逾期滞纳费率：<big>${info.monetRate}%/月</big></em>
            </dd>
        </dl>
        <dl class="fourblock">
            <dd class="clearfix">
                <em class="dis_block">贷款日期：<big>${info.beginDate}</big></em>
                <em class="dis_block">应还款日期：<big>${info.endDate} 24:00前</big></em>
                <em class="dis_block">逾期天数：<big>3天</big></em>
                <em class="dis_block">应还款额：<big class="colred">¥${info.allMoney}</big></em>
            </dd>
        </dl>
        <dl class="fourblock">
            <h5>还款明细：</h5>
            <dd class="clearfix">
                <em class="fl">本金：<big>¥${info.beginMoney}</big></em>
                <em class="fr">综合利息：<big>¥${info.totalMoney}</big></em>
            </dd>
            <dd class="clearfix">
                <em class="fl">逾期滞纳金：<big>¥50</big></em>
                <em class="fr">合计：<big class="colred">¥${info.allMoney}</big></em>
            </dd>
        </dl>
        <dl class="fourblock">
            <h5>收款账户：</h5>
            <dd class="clearfix">
                <em class="dis_block">户名：<big>${info.payeeName}</big></em>
                <em class="dis_block">账号：<big>(${info.payeeBankName})${info.payeeBankCardCode}</big></em>
            </dd>
        </dl>
        <%--<dl class="fourblock">
            <h5>打款凭证：</h5>
            <dd class="clearfix">
                <em><img src="image/img-01.png" onclick="showBigImg(this);"> </em>
                <em><img src="image/img-02.png" onclick="showBigImg(this);"> </em>
                <em><img src="image/img-03.png" onclick="showBigImg(this);"> </em>
                <em><img src="image/img-02.png" onclick="showBigImg(this);"> </em>
            </dd>
        </dl>--%>
    </div>

</div>

</body>
<script type="text/javascript" src="${path}/static/m/js/certificate/common.js"></script>
<script type="text/javascript" src="${path}/static/m/js/certificate/fastclick.js"></script>

</html>