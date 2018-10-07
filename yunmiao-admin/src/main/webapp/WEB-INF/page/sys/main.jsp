<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/static/admin/jsp/include.jsp"%>
<style type="text/css">
.super-north {
    height: 50px;
    background-color: #3498db;
}
.super-south {
    height: 30px;
    line-height: 28px;
}
.super-navigation {
    height: 50px;
}
.super-navigation-title {
    width: 210px;
    height: 50px;
    float: left;
    line-height: 50px;
    color: #fff;
    font-size: 18px;
    font-weight: bold;
    padding-left: 40px;
    background-color: #2980b9;
}
.super-navigation-main {
    height: 50px;
    width: 100%;
    float: left;
    line-height: 50px;
    color: #fff;
    font-size: 14px;
    text-align: center;
    margin-left: -250px;
}
.super-navigation-main > div {
    height: 100%;
    color: #fff;
    cursor: pointer;
}

.super-setting-left {
    float: left;
    margin-left: 250px;
}

.super-setting-left ul {
    padding-left: 0px;
}

.super-setting-right {
    float: right;
}

.super-setting-right .user>span{
    display: inline-block;
    height:100%;
    float: left;
}
.super-setting-right .user-icon{
    position: relative;
    margin-right: 10px;
    width: 40px;
}
.super-setting-right .user-icon>img{
    position: absolute;
    top: 50%;
    margin-top: -15px;
    left: 10px;
}

.super-navigation-main ul {
    display: block;
    margin: 0;
    float: left;
}

.super-navigation-main li {
    list-style: none;
    display: inline-block;
    float: left;
    height: 50px;
    min-width: 45px;
    padding: 0 5px;
    line-height: 50px;
    cursor: pointer;
    transition: background-color .3s;
}

.super-navigation-main li:hover {
    background-color: #0092dc;
}

.super-setting-right img {
    width: 30px;
    height: 30px;
    border-radius: 50%;
}

.super-setting-right .user {
    width: 100px;
}

/*滚动条样式*/

/*---滚动条默认显示样式--*/

::-webkit-scrollbar-thumb {
    background-color: #9F9F9F;
}

/*---鼠标点击滚动条显示样式--*/

::-webkit-scrollbar-thumb:hover {
    background-color: #939393;
}

/*---滚动条大小--*/

::-webkit-scrollbar {
    width: 8px;
    height: 8px;
}

/*---滚动框背景样式--*/

::-webkit-scrollbar-track-piece {
    background-color: #E2E2E2;
}
/**************************easyui的领地***************************/
/*左侧分类导航*/

.fa {
    font-size: initial;
}

/*panel*/

.panel-header {
    padding: 10px 5px;
    background: #fbfbfb;
}

.layout-expand > .panel-header {
    padding: 5px;
}
.panel-title {
    color: #575765;
}
/*accordion*/

#easyui-layout-west {
    width: 200px;
}
#easyui-layout-west .accordion-expand, .accordion .accordion-collapse:link, .accordion .accordion-collapse:visited, .accordion .accordion-collapse:hover, .accordion .accordion-collapse:active, .accordion .accordion-collapse:focus{
	background-color: inherit !important;
}

.accordion .accordion-header {
    border-width: 0 0 0px;
    background: #fbfbfb;
    transition: background-color .3s;
}

.accordion .accordion-header:hover {
    background: #E2E2E2;
}

.accordion .accordion-header-selected {
    background: #E2E2E2;
    box-shadow: inset 3px 0px 0px 0px #3498db;
}

.accordion .accordion-body {
    border-width: 0 0 0px;
}

.accordion-noborder .accordion-header {
    border-width: 0 0 0px;
}

.accordion-noborder .accordion-body {
    border-width: 0 0 0px;
}

.accordion .accordion-header-selected .panel-title {
    color: #000;
}

.panel-body .accordion-body > ul > li {
    height: 36px;
    line-height: 36px;
    padding-left: 25px;
    transition: background-color .3s;
    cursor: pointer;
}

.panel-body .accordion-body > ul > li:hover {
    background-color: #eee;
}

.super-accordion-selected {
    background: #eee;
}

.panel-with-icon {
    padding-left: 32px;
}

.panel-icon {
    width: 18px;
    left: 15px;
}

/*选项卡*/

.tabs li.tabs-selected a.tabs-inner {
    -webkit-box-shadow: inset 0px 1px 0px 0px #3498db;
    -moz-box-shadow: inset 0px 1px 0px 0px #3498db;
    box-shadow: inset 0px 1px 0px 0px #3498db;
    background: #fff;
    color: #3498db;
    border-top: 1px solid #3498db;
    font-weight: normal;
}
.tabs{height: 33px !important;}
.tabs li a.tabs-inner {
    -webkit-border-radius: 0px 0px 0 0;
    -moz-border-radius: 0px 0px 0 0;
    border-radius: 0px 0px 0 0;
    background: #fff;
    height: 32px !important;
    line-height: 32px !important;
}

.tabs li a.tabs-inner:hover {
    background: #fff;
    color: #3498db;
}

.tabs li.tabs-selected a.tabs-inner:hover {
    background: #fff;
}

.tabs-header,
.tabs-tool {
    background-color: #fbfbfb;
}
.tabs-header{
    padding-top: 0px;
}
.tabs-tool{height: 31px !important;}
.tabs-with-icon {
    padding-left: 10px;
}
.tabs-tool .l-btn:HOVER {
	border-color: transparent; 
}
.panel-header {
    border-color: #c5c5c5;
}
</style>
<script>
    $(function(){
        /*布局部分*/
        $('#master-layout').layout({
             fit:true/*布局框架全屏*/
        });   
        var _sysname = "${sessionUser.sysname}";
    	$("#sysName").html(_sysname);
    	document.title = _sysname;
    	
    	$('.user').on('click', function() {
    		$('#mm').menu('show', {
    			top: 50,
    			left: document.body.scrollWidth - 130
    		});
    	});
    });
	var logoutFun = function() {
		location.replace(sy.contextPath + '/manager/logout');
	};
	var _menus = ${sessionUser.menu}['_menus'];
	
</script>
<script type="text/javascript" src="${path}/static/admin/js/main.js"></script>
</head>
<body id="main" class="easyui-layout">
	<div data-options="region:'north',border:false" class="super-north" style="height: 50px;">
		<!--顶部-->
		<div class="super-navigation">
			<div class="super-navigation-title" style="width: 160px;" id="sysName"></div>
			<div class="super-navigation-main" style="margin-left: -210px;">
				<!-- <div class="super-setting-left">
					<ul>
						<li><i class="fa fa-commenting-o"></i></li>
						<li><i class="fa fa-envelope-o"></i></li>
						<li><i class="fa fa-bell-o"></i></li>
					</ul>
				</div> -->
				<div class="super-setting-right">
					<ul>
						<li class="user" style="width: inherit;">
							<span class="user-icon"><img src="${path}/static/admin/js/EasyUI-1.5.1-InsdepTheme-1.0.4/themes/insdep/images/portrait86x86.png"/></span>
							<span>${sessionUser.account}</span>
						</li>
						<div id="mm" class="easyui-menu">
							<div onclick="$('#passwordDialog').dialog('open');">修改密码</div>
							<div class="menu-sep"></div>
							<div onclick="logoutFun();">退出</div>
						</div>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="easyui-layout-west" data-options="region:'west',title:'导航菜单',border:false">
		<!--左侧导航-->
		<div class="easyui-accordion" data-options="border:false,fit:true,selected:true" id="mainMenu">
		</div>
	</div>
	<div data-options="region:'center'" style="padding-top: 2px;">
		<!--主要内容-->
		<div id="mainTabs" class="easyui-tabs" data-options="border:false,fit:true">
			<div title="首页" data-options="iconCls:'fa fa-home'">
				<div class="easyui-panel" data-options="fit:true,border:false" style="padding:10px; background:#fff;">
					<iframe src="${path}/go?path=${sessionUser.groupWelcome}" allowTransparency="true" style="border: 0; width: 100%; height: 99.5%;" frameBorder="0"></iframe>
				</div>
			</div>
		</div>
	</div>
	<div id="passwordDialog" title="修改密码" style="padding:15px;width: 350px;display: none;">
		<form method="post" class="form" onsubmit="return false;">
			<table style="table-layout:fixed;" border="0" cellspacing="0"  class="formtable">
				<tr>
					<th style="width: 100px;">旧密码</th>
					<td><input id="oldpwd" type="text" name="oldpwd" style="width: 100%" class="easyui-passwordbox" data-options="required:true" missingMessage="请输入旧密码"/></td>
				</tr>
				<tr>
					<th>新密码</th>
					<td><input id="newpwd" type="text" name="newpwd" style="width: 100%" class="easyui-passwordbox" data-options="required:true" missingMessage="请输入新密码" /></td>
				</tr>
				<tr>
					<th>重复密码</th>
					<td><input type="text" class="easyui-passwordbox" style="width: 100%" data-options="required:true,validType:'eqPwd[\'#newpwd\']'" missingMessage="请输入确认密码" /></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="${path}/static/admin/js/sockjs.min.js"></script>
	<script type="text/javascript">
	  	var wsIESupport = true;
    </script>
	<!--[if lte IE 9]>
	  <script type="text/javascript">
	  	wsIESupport = false;
	  </script>
	<![endif]-->
	<script type="text/javascript">
		function setupWebSocket(){
			if(wsIESupport){
				try {
					var websocket = null;
					var pp = window.location.host + sy.contextPath;
					if ('WebSocket' in window) {
			            websocket = new WebSocket("ws://" + pp + "/wsServer");
			        } else if ('MozWebSocket' in window) {
			            websocket = new MozWebSocket("ws://" + pp + "/wsServer");
			        } else {
			            websocket = new SockJS("http://" + pp + "/sockjs/wsServer");
			        }
					websocket.onopen = function(event) {
					};
					websocket.onerror = function (evnt) {
			        };
			        websocket.onclose = function (evnt) {
			        	//setTimeout(setupWebSocket, 1000);
			        };
					websocket.onmessage = function(event) {
						var json = sy.stringToJSON(event.data);
						
						layer.open({
						    type: 0,
						    move:false,
						    title: "新消息",
						    closeBtn: 1,
						    shade: false,
						    area: ['340px', '215px'],
						    offset: 'rb',
						    time: 0,
						    shift: 2,
						    content: json.msg,
//						    yes: function(index){
//
//						    }
						});
					};
				} catch (ex) {
		        }
			}
		}
		setupWebSocket();
	</script>
</body>
</html>