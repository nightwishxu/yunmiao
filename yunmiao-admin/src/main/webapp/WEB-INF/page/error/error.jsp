<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script language="javascript">
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
</script> 
<link href="${path}/static/admin/css/error.css" type="text/css" rel="stylesheet" />
</head>
<body style="background:#edf6fa;">
    <div class="error">
    <h2>非常遗憾，出错啦！</h2>
    <p>异常名称：${errorName}</p>
    <p>异常描述：${errorMsg}</p>
    </div>
</body>
</html>
