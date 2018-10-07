<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
<meta charset="utf-8">
<meta content="yes" name="apple-mobile-web-app-capable">     
<meta content="black" name="apple-mobile-web-app-status-bar-style">     
<meta content="telephone=no" name="format-detection">
<!-- <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=d3894bebfcae22426384fa82997f04d9"></script> -->
<script src="${path}/static/wx/js/lib/jquery-1.9.1.js"></script>
<script src="${path}/static/wx/js/lib/jquery.cookie.js"></script>
<script src="${path}/static/wx/js/lib/vue.js"></script>
<%-- <script src="${path}/static/wx/js/flexible.js"></script> --%>
<script src="${path}/static/wx/js/syJquery.js" type="text/javascript" charset="utf-8"></script>
<script src="${path}/static/wx/js/init.js" type="text/javascript" charset="utf-8"></script>
<script src="${path}/static/wx/js/layer_mobile/layer.js" type="text/javascript"></script>
<script src="${path}/static/wx/js/vue.extend.js"></script>
<script type="text/javascript">
if (window.top != window) {
	window.top.location = window.location;
}
var sy = sy || {};
sy.path = "${path}";
if(location.href.indexOf("/login") == -1){
	sessionStorage.lastUnloginUrl = location.href;
}
</script>
<style>
[v-cloak] {
  display: none;
}
body{
-moz-user-select:none; 
-webkit-user-select: none; 
-ms-user-select: none; 
-khtml-user-select: none; 
user-select: none; 
}
</style>