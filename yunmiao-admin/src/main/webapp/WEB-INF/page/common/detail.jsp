<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-touch-fullscreen" content="yes">
		<meta name="full-screen" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="format-detection" content="address=no" />
        <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
        <style type="text/css">
        .pin{ position: relative; box-shadow:none; -webkit-box-shadow:none; border:none;overflow:visible}
        .article-detail{display: block; position: relative; margin: 0 auto;}
		.article-detail .title,.article-detail h1 {font-size:20px; font-weight:700; text-align:left;}
		.article-detail .subtitle{font-size: 12px;text-align:left;}
		.article-detail .article-content img { max-width: 100%; _width:600px; display: block;clear: both; margin: 0 auto; opacity: 1;}
		.article-detail .article-content table{ margin:0 auto; }
		.article-detail .article-content table tr td{border:1px solid #dadada; padding:5px}
		.article-detail .article-content{color: #444; font-size: 16px; line-height: 28px;font-family:Tahoma, Helvetica, Arial, "微软雅黑","华文细黑", "宋体", sans-serif;word-break:break-all;word-wrap:break-word;}
		.article-detail .article-content p { color: #444; font-size: 16px; line-height: 28px; font-family:Tahoma, Helvetica, Arial, "微软雅黑","华文细黑", "宋体", sans-serif;word-break:break-all;word-wrap:break-word;}
		.article-content iframe { max-width: 100%;}
		.article-detail .article-content h5{font-size:14px;	line-height:2em;}
		.article-detail .article-content ul{ margin-left:40px; list-style-type:disc}
		.article-detail .article-content ul li{ line-height:28px;}
        </style>
  </head>
  <body>
	<div class="pin">
		<div class="article-detail">
			<!-- <h1>${news.title}</h1>
			<div class="subtitle">
				<span class="time"><fmt:formatDate value="${news.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
			</div> -->
			<div class="article-content">${obj.content}</div>
		</div>
	</div>
</body>
</html>
