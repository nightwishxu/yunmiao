<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="/static/m/jsp/include.jsp"%>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>分享详情</title>
    <meta name="description" content="分享详情"/>
    <meta name="keywords" content="分享详情"/>
    <link rel="stylesheet" href="${path}/share/css/common.css"/>
    <link rel="stylesheet" href="${path}/share/css/base.css"/>

</head>
<body style="background-image:url(${path}/share/image/v_bg.jpg);background-size: cover;height: 100%;background-attachment:fixed;">
<div class="wrapper">

    <div class="v_cont">
        <video src=${path}/download?id=${videoOnline.video} controls="controls" preload="auto"></video>
        <p>${videoOnline.title}</p>

        <div class="v_ewm">
            <img src="${path}/share/image/erm_img.png" class="v_line">
            <img src="${path}/share/image/v_ewm.png" class="ewm_i">
        </div>
    </div>
</div>

</body>
<script src="${path}/share/js/jquery-1.10.1.min.js"></script>
<script src="${path}/share/js/fastclick.js"></script>
<script src="${path}/share/js/common.js"></script>

</html>