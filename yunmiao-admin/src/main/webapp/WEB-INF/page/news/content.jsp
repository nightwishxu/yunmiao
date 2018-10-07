<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/> 
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
        <script src="${path}/static/admin/js/syJquery.js" type="text/javascript" charset="utf-8"></script>
        <%-- 浏览大图 --%>
		<link rel="stylesheet" href="${path}/static/admin/js/img/img.css" type="text/css">
		<script type="text/javascript" src="${path}/static/admin/js/img/img.js"></script>
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
        <script type="text/javascript">
			var sy = sy || {};
			sy.basePath = "${pageContext.request.scheme}" + "://" + "${pageContext.request.serverName}" + ":" + "${pageContext.request.serverPort}" + "${pageContext.request.contextPath}"+"/";
		</script>
        <script src="https://unpkg.com/vue"></script>
  </head>
  <body>
	<div class="pin" id='app'>
		<div class="article-detail" v-for="(item,index) in data">
			<div class="article-content">
				<p>{{item.content}}</p>
				<img :src="'${path }/download?id='+item.img+'&w=367'" data-layer='true' :data-layer-src='imgs' :data-layer-index='item.index' onclick='po.clickImg(this)'/>
			</div>
		</div>
	</div>
	<script type="text/javascript">
        var _id = '${id}';
        	var app = new Vue({
        		el:'#app',
        		data:{
        			data:[],
        			imgs:''
        		},
        		methods:{
        			loadData:function(){
        				var that = this;
        				$.post(sy.basePath + 'news/findById', {
            				id : _id
            			}, function(result) {
            				if (result) {
            					if (result.type != 3){
            						var data = eval('('+result.content+')');
            						var img = [];
            						for (var i = 0; i < data.length; i++){
            							var item = data[i];
            							if (item.img){
            								item.index = img.length;
            								img.push(item.img);
            							}
            						}
            						that.data = data;
            						that.imgs = img.join(',');
            					}else{
            					}
            				}
            			}, 'json'); 
        			}
        		},
        		mounted:function(){
        			var that = this;
        			that.loadData();
        		}
        	});
        </script>
</body>

</html>
