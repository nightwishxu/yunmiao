<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>地图</title>
	<%@ include file="/static/admin/jsp/include.jsp"%>
	<style type="text/css">
		body,html,#allmap {
			width: 100%;
			height: 485px;
			
			margin: 0;
		} 
	
	</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=56fcf9dd3597d584d13c3dd5ae63c40a"></script>
</head>
<body>
	<div>
		<table style="width:100%;">
			<tr>
				<td>
					<input id="search" type="text" style="width:100%;" prompt="请输入关键字" class="easyui-textbox" data-options="icons:[{ iconCls:'icon-search', handler: f_query }]"/>
				</td>
			</tr>
		</table>
	</div>
	<div id="allmap"></div>
<script type="text/javascript">
	var v_lng = "${lng}";
	var v_lat = "${lat}";
	var v_marker;
	var v_result = {lat:"",lng:"",address:""};
	var v_map = new BMap.Map("allmap",{enableMapClick:false});
	
	
	
	$(function(){
		init();
	});
	
    function init(){
    	//创建地图
    	if(v_lng!=null&&v_lng!=""&&v_lat!=null&&v_lat!="") {
    		var point = new BMap.Point(v_lng, v_lat);
    		f_setLocal(v_lng, v_lat);
        	v_map.centerAndZoom(point, 13);
    	} else {
    		//得到当前位置
    		var v_myCity = new BMap.LocalCity();
    		v_myCity.get(function(result) {
    			v_map.centerAndZoom(result.name, 13);
    		});
    	}

    	//设置支持滚动
    	v_map.enableScrollWheelZoom(true);

    	//添加默认缩放平移控件
    	v_map.addControl(new BMap.NavigationControl());

    	//单击事件
    	v_map.addEventListener("click", function(e) {

    		//移除老标签
    		if (v_marker) {
    			v_map.removeOverlay(v_marker);
    		}

    		// 创建新标注
    		v_marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat));

    		// 将标注添加到地图中
    		v_map.addOverlay(v_marker);

    		v_result.lng = e.point.lng;
    		v_result.lat = e.point.lat;
    		var myGeo = new BMap.Geocoder();     
    		myGeo.getLocation(e.point, function(result){     
    			if (result){
    				v_result.address = result.address;
    			}     
    		});
    	});
    }

	function f_setLocal(v_lng, v_lat) {
		var p = new BMap.Point(v_lng, v_lat);
		if (v_marker) {
			v_map.removeOverlay(v_marker);
		}
		v_marker = new BMap.Marker(p);
		v_map.addOverlay(v_marker);
		v_map.panTo(p);
	}
	
	//查询
	function f_query() {
		var v_content = $("#search").val();
		var local = new BMap.LocalSearch(v_map, {
			renderOptions:{map: v_map, autoViewport:true}
		});
		local.search(v_content);
	}
	
	//回车搜索
	document.onkeydown = function(event) {
		var e = event || window.event
				|| arguments.callee.caller.arguments[0];
		if (e.keyCode == 13) {
			f_query();
		}
	}
	
	var submitLocation = function($dialog, callback, $pjq) {
		if (v_result.lat == "") {
			parent.$.messager.confirm('询问', '您还未在地图上选择新的坐标，确定退出吗？', function(r) {
				if (r) {
					callback.call($pjq, v_result);
					$dialog.dialog('destroy');
				}
			});
		}else{
			callback.call($pjq, v_result);
			$dialog.dialog('destroy');
		}
		
		
	};
</script>
</body>
</html>