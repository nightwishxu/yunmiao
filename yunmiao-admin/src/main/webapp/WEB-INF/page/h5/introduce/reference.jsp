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
    <title>照片参考</title>
    <meta name="description" content="云喵拍当"/>
    <meta name="keywords" content="云喵拍当"/>
    <script src="${path}/share/js/jquery-1.10.1.min.js"></script>
    <link rel="stylesheet" href="${path}/pawn_part/css/common.css"/>
    <link rel="stylesheet" href="${path}/pawn_part/css/base.css"/>

</head>
<script type="text/javascript">
//    $(function(){
//        if(1 == code){
//            //奢侈品珠宝
//        }else if(2 == code){
//            //手表
//        }else if(3 == code){
//            //钻石
//        }else if(4 == code){
//            //贵金属
//        }else if(5 == code){
//            //翡翠玉石
//        }else if(6 == code){
//            //和田玉
//        }else if(7 == code){
//            //其他
//        }else if(8 == code){
//            //彩色宝石
//        }
//    });

</script>
<body>
<div class="wrapper" style="padding: .15rem;width: 100%;box-sizing: border-box;">
    <dl class="demo">
        <dt>正面</dt>
        <dd>
            <c:if test="${code eq 1}">
                <img src="${path}/pawn_part/image/scp1.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 2}">
                <img src="${path}/pawn_part/image/sb1.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 3}">
                <img src="${path}/pawn_part/image/zs1.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 4}">
                <img src="${path}/pawn_part/image/gjs1.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 5}">
                <img src="${path}/pawn_part/image/fc1.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 6}">
                <img src="${path}/pawn_part/image/hty1.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 7}">
                <img src="${path}/pawn_part/image/qt1.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 8}">
                <img src="${path}/pawn_part/image/cszb1.png" onclick="showBigImg(this);">
            </c:if>
        </dd>
    </dl>
    <dl class="demo">
        <dt>反面</dt>
        <dd>
            <c:if test="${code eq 1}">
                <img src="${path}/pawn_part/image/scp2.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 2}">
                <img src="${path}/pawn_part/image/sb2.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 3}">
                <img src="${path}/pawn_part/image/zs2.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 4}">
                <img src="${path}/pawn_part/image/gjs2.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 5}">
                <img src="${path}/pawn_part/image/fc2.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 6}">
                <img src="${path}/pawn_part/image/hty2.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 7}">
                <img src="${path}/pawn_part/image/qt2.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 8}">
                <img src="${path}/pawn_part/image/cszb2.png" onclick="showBigImg(this);">
            </c:if>
        </dd>
    </dl>
    <dl class="demo">
        <dt>局部</dt>
        <dd>
            <c:if test="${code eq 1}">
                <img src="${path}/pawn_part/image/scp3.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 2}">
                <img src="${path}/pawn_part/image/sb3.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 3}">
                <img src="${path}/pawn_part/image/zs3.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 4}">
                <img src="${path}/pawn_part/image/gjs3.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 5}">
                <img src="${path}/pawn_part/image/fc3.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 6}">
                <img src="${path}/pawn_part/image/hty3.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 7}">
                <img src="${path}/pawn_part/image/qt3.png" onclick="showBigImg(this);">
            </c:if>
            <c:if test="${code eq 8}">
                <img src="${path}/pawn_part/image/cszb3.png" onclick="showBigImg(this);">
            </c:if>
        </dd>
    </dl>

</div>

</body>
<script type="text/javascript" src="${path}/pawn_part/js/common.js"></script>
<script type="text/javascript" src="${path}/pawn_part/js/fastclick.js"></script>

</html>