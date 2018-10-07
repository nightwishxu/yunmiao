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
<link href="${path}/static/admin/css/500.css" type="text/css" rel="stylesheet" />
</head>
<body style="background:#edf6fa;">
	<!-- <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">404错误提示</a></li>
    </ul>
    </div> -->
    <div class="error">
    <h2>非常遗憾，内部服务器错误！</h2>
    <p>看到这个提示，就自认倒霉吧!</p>
    <!-- <div class="reindex"><a href="main.html" target="_parent">返回首页</a></div> -->
    </div>
</body>
</html>