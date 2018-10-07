<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="/static/m/jsp/include.jsp"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="renderer" content="webkit"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>专家鉴定</title>
    <meta name="description" content="专家鉴定"/>
    <meta name="keywords" content="专家鉴定"/>
    <script src="${path}/share/js/jquery-1.10.1.min.js"></script>
    <link href="${path}/static/m/css/certificate/common.css" rel="stylesheet" type="text/css">
    <link href="${path}/static/m/css/certificate/base.css" rel="stylesheet" type="text/css">
    <link href="${path}/static/m/css/certificate/slider.css" rel="stylesheet" type="text/css">

</head>
<script type="text/javascript" src="${path}/static/m/js/certificate/common.js"></script>
<script type="text/javascript" src="${path}/static/m/js/certificate/regist.js"></script>
<script type="text/javascript" src="${path}/static/m/js/certificate/fastclick.js"></script>
<script type="text/javascript" src="${path}/static/m/js/certificate/amazeui.js"></script>
<script type="text/javascript">
    $(function(){

        $("#sub").click(function(){
            if($(".apprai").val() == null || $(".apprai").val() == ''){
                return layer.msg("请输入您的评价");
            }
            if($("#phone").val() == null || $("#phone").val() == ''){
                return layer.msg("请输入手机号");
            }
            if($("#code").val() == null || $("#code").val() == ''){
                return layer.msg("请输入验证码");
            }

            //验证验证码
            $.post(sy.contextPath +'/webApi/account/checkCode', {phone : $("#phone").val(),code : $("#code").val(), type : 3}, function(result) {
                console.log(result)
                if(result.code == 1){
                    var url = sy.contextPath +'/m/pawn/saveExperterInfo';
                    var obj = {
                        id : ${info.id},
                        info : $(".apprai").val(),
                    };
                    $.post(url, obj, function(result) {
                        console.log(result)
                        if(result.code == 1){
                            return layer.msg(result.msg);
                        }else {
                            return layer.msg(result.msg)
                        }
                    }, 'json');
                }else {
                    return layer.msg(result.msg)
                }
            }, 'json');




        });

        $("#yzm").click(function(){

            var url2 = sy.contextPath + "/webApi/account/getMobileMsg";
            var obj = {
                phone : $("#phone").val(),
                type : 3
                        }
            $.post(url2, obj, function(result) {
                console.log(result)
            }, 'json');
        });
    });
</script>
<body style="background-image:url(${path}/static/m/images/certificate/a_bg.jpg);background-size: cover;height: 100%;background-attachment:fixed;">
<div class="wrapper">
    <!--背景遮罩-->
    <div class="bg-black dis_none" ></div>

    <div class="a_cont pd20">

    <!--图片概览-->
        <dl class="twoblock">
            <dt>图片概览</dt>
            <dd>
                <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-3 am-avg-lg-4 am-gallery-overlay clearfix" data-am-gallery="{ pureview: true }" >
                <c:forEach items="${info.images}" var="item" >

                        <li>
                            <div class="am-gallery-item">
                                <img src="<c:out value="${path}/download?id=${item}"/>"/>
                            </div>
                        </li>
                </c:forEach>
                </ul>
            </dd>
        </dl>
        <div class="Img_panel"></div>

    <dl class="twoblock appr">
        <dd>
            <span>专家手机号：</span>
            <input id="phone" type="text" class="input-txt" name="phone" placeholder="请输入您的手机号">
        </dd>
        <dd>
            <span>验证码：</span>
            <input id="code" type="text" class="input-txt input-txt-yzm" name="code" placeholder="请输入验证码">
            <input id="yzm" type="button" onclick="getVerifyCode(this)" class="input-yzm" value="获取验证码">
        </dd>
        <dd>
            <span>专家意见：</span>
            <textarea class="apprai" placeholder="请输入您的鉴定和市场流通性评价" rows="3"></textarea>
        </dd>

        <div class="btn-link">
            <a class="a-link a-regist" id="sub">提交</a>
        </div>
    </dl>

</div>
</div>
</body>


</html>