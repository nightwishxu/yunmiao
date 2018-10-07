<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<style>
#appmsgItem1 {
	border-bottom: 0;
}

.msg-item-wrapper {
	background-color: #FFF;
}

.cover .msg-t {
	position: absolute;
	bottom: 0;
	width: 100%;
	overflow: hidden;
	margin: 0;
	color: #fff;
	background: rgba(0, 0, 0, 0.6) !important;
	filter: progid:dximagetransform.microsoft.gradient(GradientType=0,
		startColorstr='#82000000', endColorstr='#82000000');
}

.sub-msg-opr {
	margin: 0;
	top: 0;
	left: 100%;
	height: 100%;
	width: 100%;
	background-color: #e5e5e5;
	background: rgba(229, 229, 229, 0.85);
	filter: progid:dximagetransform.microsoft.gradient(GradientType=0,
		startColorstr='#85E5E5E5', endColorstr='#85E5E5E5')
		alpha(opacity = 85);
}

.sub-msg-opr-show .sub-msg-opr {
	left: 0;
}

.cover .sub-msg-opr-item {
	margin-top: 70px;
}

.sub-msg-opr-item {
	margin: 40px 20px 0;
	font-size: 0;
}

.sub-msg-item {
	padding: 12px 14px;
	overflow: hidden;
	zoom: 1;
	border-top: 1px solid #c6c6c6;
}

.msg-item-wrapper .pv-tips {
	position: absolute;
	right: 0;
	top: 0;
	min-width: 100px;
	line-height: 1.8em;
	background: black;
	z-index: 100;
	opacity: .7;
	filter: alpha(opacity = 70);
	border-radius: 5px;
	text-align: center;
	color: white;
	font-weight: bold;
	padding: .2em 1em;
	display: none;
}

.msg-item-wrapper .pv-tips {
	line-height: 1.8em;
	text-align: center;
	color: white;
	font-weight: bold;
}

.thumb {
	float: right;
	font-size: 0;
}

.thumb img {
	width: 70px;
	height: 70px;
	border: 1px solid #b2b8bd;
}

.thumb .default-tip {
	font-size: 16px;
	color: #c0c0c0;
	width: 70px;
	line-height: 70px;
	border: 1px solid #b2b8bd;
}

.sub-msg-item .msg-t {
	margin-left: 0;
	margin-right: 85px;
	margin-top: 0;
	padding-left: 4px;
	padding-top: 12px;
	line-height: 24px;
	max-height: 48px;
	font-size: 14px;
	overflow: hidden;
}

.sub-msg-item .msg-t {
	line-height: 24px;
	font-size: 14px;
}

.sub-add {
	display: none;
	padding: 12px 14px;
	border-top: 1px solid #c6c6c6;
}

.msg-preview .sub-add {
	display: block;
}

.sub-add-btn {
	line-height: 70px;
	color: #222;
	border: 2px dotted #b8b8b8;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
}

body {
	word-wrap: break-word;
	word-break: break-word;
}

.msg-item-wrapper {
	position: relative;
	margin-bottom: 26px;
	border: 1px solid #b8b8b8;
	background-color: #f4f4f4;
	box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
	-webkit-box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
	-moz-box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
}

.msg-item {
	padding: 2px 0;
	background-color: #fff;
	border-bottom: 1px solid #ccc;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
	-webkit-box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
	border-radius: 5px 5px 0 0;
	-webkit-border-radius: 5px 5px 0 0;
	-moz-border-radius: 5px 5px 0 0;
}

.msg-preview .msg-item {
	border-radius: 5px;
	box-shadow: none;
	moz-border-radius: 5px;
	moz-box-shadow: none;
	webkit-border-radius: 5px;
	webkit-box-shadow: none;
}

.msg-t {
	margin: 6px 0 0;
	padding-left: 14px;
	line-height: 28px;
	max-height: 56px;
	overflow: hidden;
	font-size: 16px;
	font-weight: 400;
	letter-spacing: 1px;
	font-weight: bold;
}

.msg-meta {
	margin: 0 14px 6px;
	font-size: 13px;
}

.cover {
	margin: 0 14px 12px;
	position: relative;
	font-size: 0;
	height: 160px;
	overflow: hidden;
}

.default-tip {
	display: block;
	text-align: center;
	background-color: #ececec;
	text-shadow: 0 1px 0 #fff;
	-webkit-text-shadow: 0 1px 0 #fff;
	-moz-text-shadow: 0 1px 0 #fff;
}

.cover .default-tip {
	font-size: 22px;
	color: #aaa;
	line-height: 160px;
}

.cover img {
	width: 100%;
}

.msg-text {
	margin: 0 14px;
	font-size: 14px;
	line-height: 1.6;
	padding-bottom: 8px;
	text-align: left;
}

.msg-preview .msg-opr {
	display: none;
}

.msg-preview .msg-opr {
	display: none;
}

.msg-opr-list {
	padding: 10px 0;
	letter-spacing: -5px;
	border-radius: 0 0 5px 5px;
	-webkit-border-radius: 0 0 5px 5px;
	-moz-border-radius: 0 0 5px 5px;
}

.opr-item {
	width: 50%;
	font-size: 14px;
	letter-spacing: normal;
}

.edit-btn {
	border-right: 1px solid #a3a3a3;
}

.opr-btn {
	padding: 2px 0;
}

.opr-btn:hover .edit-icon {
	background-position: -28px -139px;
}

.opr-btn:hover .del-icon {
	background-position: -28px -195px;
}

.block {
	display: block;
}

.b-dib {
	display: inline-block;
	zoom: 1;
	*display: inline;
}

.edit-icon {
	background-position: 0 -139px;
}

.del-icon {
	background-position: 0 -195px;
}

.tc {
	text-align: center;
}

.th {
	line-height: 150px;
	overflow: hidden;
}

.vm {
	vertical-align: middle;
}

.msg-hover-mask {
	display: none;
	position: absolute;
	top: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.6) !important;
	filter: progid:dximagetransform.microsoft.gradient(GradientType=0,
		startColorstr='#60000000', endColorstr='#60000000');
}

.msg-mask {
	display: none;
	position: absolute;
	top: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.6) !important;
	filter: progid:dximagetransform.microsoft.gradient(GradientType=0,
		startColorstr='#60000000', endColorstr='#60000000');
}

.dib {
	display: inline-block;
}

.msg-editer-wrapper {
	position: relative;
}

.msg-editer {
	background-color: #f8f8f8;
	border: 1px solid #b8b8b8;
	border-radius: 5px;
	box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
	moz-border-radius: 5px;
	moz-box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
	padding: 14px 0 20px 20px;
	webkit-border-radius: 5px;
	webkit-box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
}

.msg-arrow {
	border-style: dashed solid dashed dashed;
	font-size: 0;
	height: 0;
	width: 0;
}

.a-out {
	border-color: transparent #b8b8b8 transparent transparent;
	border-width: 12px 14px 12px 0;
	left: -13px;
	top: 43px;
}

.a-in {
	border-color: transparent #f8f8f8 transparent transparent;
	border-width: 11px 13px 11px 0;
	left: -12px;
	top: 44px;
}

.abs {
	position: absolute;
}

.rel {
	position: relative;
}

.msg-input,.cover-area,.msg-txta {
	background-color: #fff;
	border: 1px solid #d3d3d3;
	color: #666;
	max-width: 480px;
	padding: 2px 8px;
	width: 480px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
}

.cover-area {
	max-width: 496px;
	padding: 0;
	width: 496px;
	position: relative;
}

.cover-hd {
	padding: 2px 8px 3px;
	position: relative;
}

.upload-tip {
	color: #666;
	font-size: 12px;
	line-height: 28px;
	text-align: right;
	position: absolute;
	top: 3px;
	right: 8px;
}

.cover-bd {
	border-top: 1px solid #ccc;
	font-size: 0;
	overflow: hidden;
	padding: 8px;
}

.cover-bd img {
	width: 100px;
}

.cover-del {
	font-size: 14px;
	margin-left: 5px;
}

.url-link {
	margin-bottom: 6px;
}

.container {
	margin: 0 auto;
	width: 760px;
}

.containerBox {
	margin-top: 20px;
	box-shadow: 0 3px 3px #DDD;
	-moz-box-shadow: 0 3px 3px #ddd;
	-webkit-box-shadow: 0 3px 3px #DDD;
	border-radius: 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	background-color: white;
	border: 1px solid lightGrey;
}

.containerBox .boxHeader {
	height: 30px;
	padding-left: 20px;
	border-bottom: 1px solid lightGrey;
	background-color: whiteSmoke;
}

.containerBox .boxHeader h4 {
	margin-top: 0;
	padding-top: 5px;
}

.containerBox .sideBar {
	width: 180px;
	float: left;
	padding: 10px 0;
}

.containerBox .content {
	width: 737px;
	float: right;
	margin-left: -2px;
	border-left: 1px solid lightGrey;
	padding-left: 20px;
}

.page-bd {
	padding-top: 20px;
}

.menu {
	display: block;
	bottom: 0;
	z-index: 7;
	overflow: auto;
}

.clr {
	clear: both;
}

.tj {
	text-align: justify;
}

.vt {
	vertical-align: top;
}

.msg-col {
	width: 350px;
	font-size: 14px;
}

.msg-hover .msg-hover-mask {
	display: block;
}

.msg-hover-mask {
	display: none;
	position: absolute;
	top: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.6) !important;
	filter: progid:dximagetransform.microsoft.gradient(GradientType=0,
		startColorstr='#60000000', endColorstr='#60000000');
}

.msg-selected .msg-mask {
	display: block;
}

.msg-item-wrapper {
	position: relative;
	margin-bottom: 26px;
	border: 1px solid #B8B8B8;
	background-color: #F4F4F4;
	box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
	-webkit-box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
	-moz-box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
}

.page-sub-hd {
	font-size: 16px;
	font-weight: 700;
	line-height: 34px;
}

.msg-opr-list {
	margin-bottom: 0;
}

.group::after {
	content: "\200B";
	display: block;
	height: 0;
	clear: both;
}

.sub-msg-item {
	padding: 12px 14px;
	overflow: hidden;
	zoom: 1;
	border-top: 1px solid #c6c6c6;
}

.thumb {
	float: right;
	font-size: 0;
}

.thumb .default-tip {
	font-size: 16px;
	color: #c0c0c0;
	width: 70px;
	line-height: 70px;
	border: 1px solid #b2b8bd;
}

.thumb img {
	width: 70px;
	height: 70px;
	border: 1px solid #b2b8bd;
}

.sub-msg-item .msg-t {
	margin-left: 0;
	margin-right: 85px;
	margin-top: 0;
	padding-left: 4px;
	padding-top: 12px;
	line-height: 24px;
	max-height: 48px;
	font-size: 14px;
	overflow: hidden;
}
.multi-access {
	background-position: 50% -342px;
}
</style>
<script type="text/javascript">
	var id = "${id}";
	$(function() {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/wxarticle/findByResId', {
				id : id
			}, function(result) {
				var htmlContent = "";
				if (result) {
					if(result.length == 0)$(".msg-item-wrapper").hide();
					$.each(result,function(i,o){
						if(i == 0){
							$("#topImg").attr("src",sy.contextPath + "/download?id="+o.img);
							$("#topTitle").html(o.title);
							if(result.length == 1){
								$(".msg-text").html(o.remark);
							}
						}else{
							htmlContent += "<div class=\"rel sub-msg-item appmsgItem\">";
							htmlContent += "	<span class=\"thumb\">";           
							htmlContent += "		<img class=\"i-img m-img\" src=\""+sy.contextPath + "/download?id="+o.img+"\" style=\"width: 72px;height: 72px;\">";
							htmlContent += "	</span>";       
							htmlContent += "	<h4 class=\"msg-t\">";                    
							htmlContent += "		<span class=\"i-title m-title\">"+o.title+"</span>";                
							htmlContent += "	</h4>";       
							htmlContent += "</div>";
						}
					});
					$("#appmsgItem1").after(htmlContent);
				}
				parent.$.messager.progress('close');
			}, 'json');
		
		
	});
</script>
</head>
<body>
	<div class="msg-item-wrapper" relid="">
		<div id="appmsgItem1" class="appmsgItem msg-item">
			<p class="msg-meta">
				<span class="msg-date">&nbsp;</span>
			</p>
			<div class="cover">
				<img class="i-img m-img" src="" style="height: 200px;" id="topImg">
				<h4 class="msg-t">
					<span class="i-title m-title" id="topTitle">标题</span>
				</h4>
			</div>
			<p class="msg-text"></p>
		</div>
	</div>
</body>
</html>