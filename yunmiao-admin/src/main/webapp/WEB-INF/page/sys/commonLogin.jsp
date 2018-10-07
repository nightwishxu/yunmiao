<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
	<%@ include file="/static/admin/jsp/include.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<script type="text/javascript">
var sy = sy || {};
sy.contextPath = '${path}';
sy.basePath = "${pageContext.request.scheme}" + "://" + "${pageContext.request.serverName}" + ":" + "${pageContext.request.serverPort}" + "${pageContext.request.contextPath}"+"/";
var projectPath = sy.basePath;
sy.roleCode = '${sessionScope.sessionUser.roleCode}';
sy.areaCode = '${sessionScope.sessionUser.areaCode}';
sy.system = '${sessionScope.sessionUser.sys}';
sy.pixel_0 = '${path}/static/admin/images/pixel_0.gif';//0像素的背景，一般用于占位
</script>
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="${path }/static/admin/login2/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="${path }/static/admin/login2/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="${path }/static/admin/login2/css/component.css" />
<!--[if IE]>
<script src="${path }/static/admin/login2/js/html5.js"></script>
<![endif]-->
<%-- 引入jQuery --%>
<script src="${path}/static/admin/js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>

<%-- 引入jquery扩展 --%>
<script src="${path}/static/admin/js/syJquery.js" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript">
	if (window != top)
		top.location.href = location.href;
</script>
<script language="javascript">

var sys = '${sys}';
var contextPath = '${path}';
function myRegister() {
	// window.location.href=sy.contextPath + '/manager/'+'commonRegister'


    layer.msg('请选择注册的角色', {
        skin: 'layui-layer-molv', //样式类名  自定义样式
        btn: ['供应商', '典当行']
        ,yes: function(index, layero){
            var dialog = parent.sy.modalDialog({
                title : '供应商注册',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=sys/register/edit',
                buttons : [ {
                    text : '确定',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, parent.$);
                    }
                } ]
            });
        }
        ,btn2: function(index, layero){
            // return false //开启该代码可禁止点击该按钮关闭
            var dialog = parent.sy.modalDialog({
                title : '典当行注册',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=sys/register/edit2',
                buttons : [ {
                    text : '确定',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, parent.$);
                    }
                } ]
            });
        }
    });


}


$(function(){	
	// 请求上次存储的Cookies
	var account = sy.getCookie(sys+"_account");
	
	//设定sys的cookie
	var temp = sy.getCookie('sys');
	if (temp != sys){
		sy.delCookie('sys');
		sy.setCookie('sys',sys,100,contextPath);
	}
	
	if (account!=null) {
		$("#account").val(account);
        // 密码框赋值
        $("#pwd").val(sy.getCookie(sys+"_pwd"));
        // 并设置勾选记住密码
        //$("#remember").attr("checked","checked");
	}
	
	$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
		$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	});
	
	$('form :input').keyup(function(event) {
		if (event.keyCode == 13) {
			loginFun();
		}
	});
});  

var loginFun = function() {
	if($("#account").val() == '' || $("#pwd").val() == ''){
		alert("账号或密码不能为空");
		return;
	}
	
	var $form = $('form');
	if ($form.length == 1) {
		$.post(sy.contextPath + '/manager/'+sys+'/login', $form.serialize(), function(result) {
			if (result.code == 0) {
				sy.setCookie(sys+"_account",$("#account").val(),100,contextPath);
				sy.setCookie(sys+"_pwd",$("#pwd").val(),100,contextPath);
				sy.setCookie("sys",sys,100,contextPath);
				location.replace(sy.contextPath + '/manager/'+sys);
			} else {
                alert(result.msg);
                return;
			}
		}, 'json');
	}
};
</script>

</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>${sysName}</h3>
						<form action="#" name="f" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户" id="account" name="account">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码" id="pwd" name="pwd">
							</div>
							<div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF" onclick="loginFun()">登录</a></div>
						</form>
						<a onclick="myRegister()"  style="color: red;size: A4">没有账号？请先注册</a>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="${path }/static/admin/login2/js/TweenLite.min.js"></script>
		<script src="${path }/static/admin/login2/js/EasePack.min.js"></script>
		<script src="${path }/static/admin/login2/js/rAF.js"></script>
		<script src="${path }/static/admin/login2/js/demo-1.js"></script>
		<script src="${path}/static/admin/js/syEasyUI.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>