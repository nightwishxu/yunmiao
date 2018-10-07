<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
sy.roleCode = '${sessionScope.sessionUser.roleCode}';
sy.areaCode = '${sessionScope.sessionUser.areaCode}';
sy.system = '${sessionScope.sessionUser.sys}';
sy.pixel_0 = '${path}/static/admin/images/pixel_0.gif';//0像素的背景，一般用于占位
sy.width = window.innerWidth;
sy.height = window.innerHeight;
sy.layerIndex = [];
</script>
<link href="${path}/static/admin/font/font-awesome.min.css" rel="stylesheet" type="text/css">
<%-- 引入EasyUI of InsdepTheme--%>
<link href="${path}/static/admin/js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
<link href="${path}/static/admin/js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/easyui_animation.css" rel="stylesheet" type="text/css">
<link href="${path}/static/admin/js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/easyui_plus.css" rel="stylesheet" type="text/css">
<link href="${path}/static/admin/js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/insdep_theme_default.css" rel="stylesheet" type="text/css">
<link href="${path}/static/admin/js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/icon.css" rel="stylesheet" type="text/css">
<%-- 引入jQuery --%>
<script src="${path}/static/admin/js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${path}/static/admin/js/EasyUI-1.5.1-InsdepTheme-1.0.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/static/admin/js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/jquery.insdep-extend.min.js"></script>
<%-- 引入jquery扩展 --%>
<script src="${path}/static/admin/js/syJquery.js" type="text/javascript" charset="utf-8"></script>
<%-- 引入easyui扩展 --%>
<script src="${path}/static/admin/js/syEasyUI.js" type="text/javascript" charset="utf-8"></script>
<script src="${path}/static/admin/js/syValidatebox.js" type="text/javascript" charset="utf-8"></script>
<%-- 引入colorpicker --%>
<script type="text/javascript" src="${path}/static/admin/js/colorPicker/colors.js" charset="utf-8"></script>
<script type="text/javascript" src="${path}/static/admin/js/colorPicker/jqColorPicker.js" charset="utf-8"></script>
<%-- 引入kindeditor控件 --%>
<script src="${path}/static/admin/js/kindeditor-4.1.10/kindeditor-all.js" type="text/javascript" charset="utf-8"></script>
<%-- 引入uploadify --%>
<link href="${path}/static/admin/js/uploadifive/uploadifive.css" type="text/css" rel="stylesheet" />
<link href="${path }/static/admin/js/webuploader/uploader.css" type="text/css" rel="stylesheet" />
<link href="${path }/static/admin/js/webuploader/webuploader.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${path }/static/admin/js/webuploader/webuploader.js"></script>
<%-- web弹层组件 --%>
<script type="text/javascript" src="${path}/static/admin/js/layer/layer.js" ></script>

<%-- 引入ui扩展 --%>
<script src="${path}/static/admin/js/core.ui2.js" type="text/javascript" charset="utf-8"></script>
<%-- 引入图片裁剪
<link rel="stylesheet" href="${path}/static/admin/js/tapmodo-Jcrop-1902fbc/css/jquery.Jcrop.css" type="text/css">
<script type="text/javascript" src="${path}/static/admin/js/tapmodo-Jcrop-1902fbc/js/jquery.Jcrop.min.js"></script>--%>
<%-- 浏览大图 --%>
<link rel="stylesheet" href="${path}/static/admin/js/img/img.css" type="text/css">
<script type="text/javascript" src="${path}/static/admin/js/img/img.js"></script>
<%-- 引入util --%>
<script type="text/javascript" src="${path}/static/admin/js/ut.js" ></script>
<%-- 引入自定义css --%>
<link rel="stylesheet" href="${path}/static/admin/css/syCss.css" type="text/css">

<link href="${path}/static/admin/css/video-js.css" rel="stylesheet">


<script type="text/javascript" src="${path}/static/admin/js/video.min.js" ></script>
<script type="text/javascript">
$(window).on('resize', function(){
	sy.width = window.innerWidth;
	sy.height = window.innerHeight;
});
</script>