<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>test</title>
	<%@ include file="/static/admin/jsp/include.jsp"%>
  </head>
  <body>
  <table style="width: 90%">
	  <tr>
	  	<td style="width: 150px">文件上传：</td>
	  	<td><input id="file_upload" fileCountLimit="3" formData='{"a":1}' multi="true" type="file" showBtn='true' bestSize='300*300'  showImage="true"  fileType="*.jpg;*.png" fileSize="500KB" buttonText="上传图标"/></td>
	  </tr>
	  <tr>
	  	<td>图片放大:</td>
	  	<td>
	  	<img class='simple-img' src='base/images/error.png' width='50'/>
	  	<div id='ccc'></div>
	  	<div id='ddd'></div>
	  	</td>
	  </tr>
	  <tr>
	  	<td>地图：</td>
	  	<td>
	  	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'ext-icon-search'" onclick="showamap()">高德地图</a>  
	  	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'ext-icon-search'" onclick="showbmap()">百度地图</a>  
	  	</td>
	  </tr>
	  <tr>
	  	<td>message：</td>
	  	<td>
	  		info:
	  		<a id="btn" href="#" class="easyui-linkbutton" data-options="" onclick="$.messager.i('info')">$.messager.i('info')</a>  
	  		<a id="btn" href="#" class="easyui-linkbutton" data-options="" onclick="$.messager.i('xxx','info')">$.messager.i('xxx','info')</a>  
	  		<br>
	  		warning:
	  		<a id="btn" href="#" class="easyui-linkbutton" data-options="" onclick="$.messager.w('warning')">$.messager.w('warning')</a>  
	  		<a id="btn" href="#" class="easyui-linkbutton" data-options="" onclick="$.messager.w('xxx','warning')">$.messager.w('xxx','warning')</a>  
	  		<br>
	  		question:
	  		<a id="btn" href="#" class="easyui-linkbutton" data-options="" onclick="$.messager.q('question')">$.messager.q('question')</a>  
	  		<a id="btn" href="#" class="easyui-linkbutton" data-options="" onclick="$.messager.q('xxx','question')">$.messager.q('xxx','question')</a>
	  		<br>
	  		error:
	  		<a id="btn" href="#" class="easyui-linkbutton" data-options="" onclick="$.messager.e('error')">$.messager.e('error')</a>  
	  		<a id="btn" href="#" class="easyui-linkbutton" data-options="" onclick="$.messager.e('xxx','error')">$.messager.e('xxx','error')</a>  
	  	</td>
	  </tr>
	  <tr>
	  	<td>layer：</td>
	  	<td>
	  		见：http://sentsin.com/jquery/layer/
	  	</td>
	  </tr>
	  <tr> 
	  <tr>
	  	<td>富文本：</td>
	  	<td>
	  		<textarea id="content" style="width:98%;height: 200px"></textarea>
	  		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'ext-icon-search'" onclick="alert(editor.getHtml());">获取内容</a>
	  	</td>
	  </tr>
	 <!--  <tr>
	  	<td>autoComplete：</td>
	  	<td><input id="store" fieldText="name" fieldValue="id" url="store/getStoreName.do"/><button id="tt">获取内容</button></td>
	  </tr> -->
	  <tr>
	  	<td>复制id</td>
	  	<td><input id='copy' value='example' /><a href='javascript:void(0);' onclick='copy()'>复制</a></td>
	  </tr>
	  <tr>
	  	<td>银联支付</td>
	  	<td><input id='upmp' name='upmp'/><a href='javascript:void(0);' onclick='upmp()'>银联支付</a></td>
	  </tr>
	  <tr>
	  	<td>微信支付</td>
	  	<td><input id='wx' name='wx'/><a href='javascript:void(0);' onclick='wx()'>微信支付</a><img id='wxImg'/></td>
	  </tr>
	  <tr>
	  	<td>开关</td>
	  	<td>
	  		<input class="easyui-switchbutton"  onText="开" offText="关" value="1"/>
		</td>
	  </tr>
	  <tr>
	  	<td>取色器</td>
	  	<td>
	  		<input type="remark" id="remark" class="color"/>
		</td>
	  </tr>
  </table>
 <script type="text/javascript">
 function showColor(){
	 var color = $('#remark').val();
	 alert(color);
 }
//复制
	
 
$(function(){
	$('.color').val("#000000");
	$('.color').colorPicker({opacity:false});
	
	$('#ccc').append(po.showImg('base/images/error.png',80));
	$('#ddd').append(po.showImg({id:'base/images/error.png',width:100}));
	
	//自动补全
/* 	autoComplete('#store','store/getStoreName.do');
	$('#tt').click(function(){
		alert($('#store').attr('fieldValue'));
	}); */
 });
 
 var upmp = function(){
	var orderId = $('#upmp').val();
	window.open('upmpPay?orderId='+orderId);
 };
 
 var wx = function(){
	 var orderId = $('#wx').val();
	 $.ajax({
		 url:'wxPay',
		 data : {id:orderId},
		 dataType : 'json',
		 success : function(data){
			 $('#wxImg').attr('src',"qr?size=10&msg="+encodeURI(data.msg));
		 }
	 });
 };

  var editor = new HtmlEditor('#content');
  editor.setHtml("test");
  
  function copy(){
		sy.getId(editor.getHtml(),'复制');
	}
  
  	var retMap = function(ret) {
		if (ret.lat != "") {
			alert("lng:"+ret.lng+",lat:"+ret.lat+",address:"+ret.address);
			console.log(ret);
		}
	}
	
	function showamap() {
		var lng = "119.697987";
		var lat = "31.995258";
		sy.amap(retMap, lat, lng);
	}
	function showbmap() {
		var lng = "119.697987";
		var lat = "31.995258";
		sy.bmap(retMap, lat, lng);
	}
</script>
  </body>
</html>
