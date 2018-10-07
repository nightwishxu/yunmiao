<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
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

<%-- 引入jQuery --%>
<script src="${path}/static/admin/js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>

<%-- 引入jquery扩展 --%>
<script src="${path}/static/admin/js/syJquery.js" type="text/javascript" charset="utf-8"></script>

<%-- 引入javascript扩展 --%>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<title>${sysName}-用户登录</title>
<script type="text/javascript">
  	//防止嵌套页面
	if (window.top != window) {
		window.top.location = window.location;
	}
</script>
<link rel="stylesheet" href="${path}/static/admin/login/bootstrap.css" />
<link href="${path}/static/admin/font/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${path}/static/admin/login/ace.css" />
<!--[if lt IE 9]>
<script language="javascript">
alert("温馨提示：强烈推荐使用chrome或IE9以上浏览器浏览系统");
</script>
<![endif]-->
<script language="javascript">
var sys = '${sys}';
var contextPath = '${path}';
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
        $("#remember").attr("checked","checked");
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
				if(document.getElementById("remember").checked){
					sy.setCookie(sys+"_account",$("#account").val(),100,contextPath);
					sy.setCookie(sys+"_pwd",$("#pwd").val(),100,contextPath);
					sy.setCookie("sys",sys,100,contextPath);
				}else{
					sy.delCookie(sys+"_account",contextPath);
					sy.delCookie(sys+"_pwd",contextPath);
				}
				location.replace(sy.contextPath + '/manager/'+sys);
			} else {
				$("#msgContent").html(result.msg);
				$("#msg").show();
			}
		}, 'json');
	}
};
</script> 
</head>
<body class="login-layout blur-login">
	<div class="main-container">
		<div class="main-content">
			<div class="row" style="margin:8% auto 0;">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<span class="red">${sysName}</span>
								<span class="white" id="id-text2">用户登录</span>
							</h1>
							<h4 class="light-blue" id="id-company-text">&copy; 拍当网</h4>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box" class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main" ng-init="showMsg = false">
										<h4 class="header blue lighter bigger">
											请输入您的账号信息
										</h4>
										<div class="text-warning bigger-110 orange" style="display: none;" id="msg">
											<button type="button" class="close" data-dismiss="alert" onclick="$('#msg').hide()">
												<i class="ace-icon fa fa-times"></i>
											</button>
											<i class="ace-icon fa fa-exclamation-triangle"></i>&nbsp;<span id="msgContent"></span>
										</div>
										<div class="space-6"></div>
										<form>
											<fieldset>
												<label class="block clearfix"> 
													<span class="block input-icon input-icon-right"> 
													<input type="text" class="form-control" placeholder="用户名" id="account" name="account"/> <i class="ace-icon fa fa-user"></i>
													</span>
												</label>
												<label class="block clearfix"> 
													<span class="block input-icon input-icon-right"> 
														<input type="password" class="form-control" placeholder="密码" id="pwd" name="pwd"/> <i class="ace-icon fa fa-lock"></i>
													</span>
												</label>
												<div class="space"></div>
												<div class="clearfix">
													<label class="inline"> <input type="checkbox" class="ace" id="remember" name="remember"/> <span class="lbl" style="color: gray;">&nbsp;记住密码</span>
													</label>

													<button type="button" class="width-35 pull-right btn btn-sm btn-primary" onclick="loginFun()">
														<i class="ace-icon fa fa-key"></i> <span class="bigger-110">登录</span>
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>
									</div>
									<!-- /.widget-main -->
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.login-box -->
						</div>
						<!-- /.position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>
</body>
</html>


