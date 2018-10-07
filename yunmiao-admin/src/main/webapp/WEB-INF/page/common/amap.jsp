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
		/* #allmap {
			width: 100%;
			height: 500px;
			overflow: hidden;
			margin: 0;
		}  */
		
		body{
			margin:0;
			height:100%;
			width:100%;
			position:absolute;
			font-size:12px;
		}
		#mapContainer{
			position: absolute;
			top:0;
			left: 0;
			right:0;
			bottom:0;
		}
		
		#tip{
			background-color:#fff;
			border:1px solid #ccc;
			/* padding-left:10px; */
			padding-right:2px;
			position:absolute;
			min-height:25px;
			top:10px;
			font-size:12px;
			right:10px;
			overflow:hidden;
			line-height:20px;
			min-width:400px;
		}
		#tip input[type="text"]{
			height:25px;
			border:0px;
			border-bottom:1px solid #ccc;
			outline:none;
			padding-left:3px;
		}
		
		#result1{
			max-height:300px;
		}
	</style>
</head>
<body>
<div id="mapContainer" ></div>
<div id="tip">
    <input type="text" id="keyword" name="keyword" value="" onkeydown='keydown(event)' style="width: 100%;" placeholder="请输入关键字"/>
    <div id="result1" name="result1"></div>
</div>
<script src="http://webapi.amap.com/maps?v=1.3&key=d3894bebfcae22426384fa82997f04d9" type="text/javascript"></script>
<script type="text/javascript">
	var v_lng = "${lng}";
	var v_lat = "${lat}";
	var v_city = "${city}";
	var v_marker;
	var v_toolBar;
	var v_result = {lat:"",lng:"",address:""};
	var v_map = new AMap.Map("mapContainer",{resizeEnable: true});
	
	$(function(){
		init();
	});
	
    function init(){
    	//地图中添加地图操作ToolBar插件
		v_map.plugin(["AMap.ToolBar"],function(){		
			v_toolBar = new AMap.ToolBar(); //设置地位标记为自定义标记
			v_map.addControl(v_toolBar);		
			AMap.event.addListener(v_toolBar,'location',function callback(e){	
				v_map.setZoomAndCenter(10,e.lnglat);
			});
		});
    	
    	if(v_lng!=null&&v_lng!=""&&v_lat!=null&&v_lat!="") {
    		var point = new AMap.LngLat(v_lng, v_lat);
    		f_setLocal(v_lng, v_lat);
        	v_map.setZoomAndCenter(13,point);
    	} else {
    	}

    	//单击事件
    	AMap.event.addListener(v_map,"click", function(e) {
    		//移除老标签
    		if (v_marker) {
    			v_marker.setMap(null);
    		}

    		// 创建新标注
    		v_marker = new AMap.Marker({map:v_map,position:e.lnglat,animation:'AMAP_ANIMATION_DROP'});

    		v_result.lng = e.lnglat.getLng();
    		v_result.lat = e.lnglat.getLat();
    		AMap.service(["AMap.Geocoder"], function() { //加载地理编码
	    	        geocoder = new AMap.Geocoder({
	    	            radius: 1000,
	    	            extensions: "all"
	    	        });
	    	        geocoder.getAddress(e.lnglat, function(status, result){
	    	            //根据服务请求状态处理返回结果
	    	            if(status=='error') {
	    	            	v_result.lat = '';
	    	                alert("服务请求出错啦！ ");
	    	            }
	    	            if(status=='no_data') {
	    	            	v_result.lat = '';
	    	                alert("无数据返回，请换个坐标点试试～～");
	    	            }
	    	            else {
	    	                v_result.address = result.regeocode.formattedAddress;
	    	            }
	    	        });
	    	});
    	});
    }

	function f_setLocal(v_lng, v_lat) {
		var p = new AMap.LngLat(v_lng, v_lat);
		if (v_marker) {
			v_marker.setMap(null);
		}
		v_marker = new AMap.Marker({map:v_map,position:p});
		v_map.setCenter(p);
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
	<script type="text/javascript">
		var windowsArr = [];
		var marker = [];
	    document.getElementById("keyword").onkeyup = keydown;
		//输入提示
		function autoSearch() {
		    var keywords = document.getElementById("keyword").value;
		    var auto;
		    //加载输入提示插件
		        AMap.service(["AMap.Autocomplete"], function() {
		        var autoOptions = {
		            city: v_city //城市，默认全国
		        };
		        auto = new AMap.Autocomplete(autoOptions);
		        //查询成功时返回查询结果
		        if ( keywords.length > 0) {
		            auto.search(keywords, function(status, result){
		            	autocomplete_CallBack(result);
		            });
		        }
		        else {
		            document.getElementById("result1").style.display = "none";
		        }
		    });
		}
		 
		//输出输入提示结果的回调函数
		function autocomplete_CallBack(data) {
		    var resultStr = "";
		    var tipArr = data.tips;
		    if (tipArr&&tipArr.length>0) {                 
		        for (var i = 0; i < tipArr.length; i++) {
		            resultStr += "<div id='divid" + (i + 1) + "' onmouseover='openMarkerTipById(" + (i + 1)
		                        + ",this)' onclick='selectResult(" + i + ")' onmouseout='onmouseout_MarkerStyle(" + (i + 1)
		                        + ",this)' style=\"font-size: 13px;cursor:pointer;padding:5px 5px 5px 5px;\"" + "data=" + tipArr[i].adcode + ">" + tipArr[i].name + "<span style='color:#C1C1C1;'>"+ tipArr[i].district + "</span></div>";
		        }
		    }
		    else  {
		        resultStr = " π__π 亲,人家找不到结果!<br />要不试试：<br />1.请确保所有字词拼写正确<br />2.尝试不同的关键字<br />3.尝试更宽泛的关键字";
		    }
		    document.getElementById("result1").curSelect = -1;
		    document.getElementById("result1").tipArr = tipArr;
		    document.getElementById("result1").innerHTML = resultStr;
		    document.getElementById("result1").style.display = "block";
		}
		 
		//输入提示框鼠标滑过时的样式
		function openMarkerTipById(pointid, thiss) {  //根据id打开搜索结果点tip 
		    thiss.style.background = '#CAE1FF';
		}
		 
		//输入提示框鼠标移出时的样式
		function onmouseout_MarkerStyle(pointid, thiss) {  //鼠标移开后点样式恢复 
		    thiss.style.background = "";
		}
		 
		//从输入提示框中选择关键字并查询
		function selectResult(index) {
		    if(index<0){
		        return;
		    }
		    if (navigator.userAgent.indexOf("MSIE") > 0) {
		        document.getElementById("keyword").onpropertychange = null;
		        document.getElementById("keyword").onfocus = focus_callback;
		    }
		    //截取输入提示的关键字部分
		    var text = document.getElementById("divid" + (index + 1)).innerHTML.replace(/<[^>].*?>.*<\/[^>].*?>/g,"");
			var cityCode = document.getElementById("divid" + (index + 1)).getAttribute('data');
		    document.getElementById("keyword").value = text;
		    document.getElementById("result1").style.display = "none";
		    //根据选择的输入提示关键字查询
		    v_map.plugin(["AMap.PlaceSearch"], function() {       
		        var msearch = new AMap.PlaceSearch();  //构造地点查询类
		        AMap.event.addListener(msearch, "complete", placeSearch_CallBack); //查询成功时的回调函数
				msearch.setCity(cityCode);
		        msearch.search(text);  //关键字查询查询
		    });
		}
		 
		//定位选择输入提示关键字
		function focus_callback() {
		    if (navigator.userAgent.indexOf("MSIE") > 0) {
		        document.getElementById("keyword").onpropertychange = autoSearch;
		   }
		}
		 
		//输出关键字查询结果的回调函数
		function placeSearch_CallBack(data) {
		    //清空地图上的InfoWindow和Marker
		    windowsArr = [];
		    marker     = [];
		    v_map.clearMap();
		    var resultStr1 = "";
		    var poiArr = data.poiList.pois;
		    var resultCount = poiArr.length;
		    for (var i = 0; i < resultCount; i++) {
		        resultStr1 += "<div id='divid" + (i + 1) + "' onmouseover='openMarkerTipById1(" + i + ",this)' onmouseout='onmouseout_MarkerStyle(" + (i + 1) + ",this)' style=\"font-size: 12px;cursor:pointer;padding:0px 0 4px 2px; border-bottom:1px solid #C1FFC1;\"><table><tr><td><img src=\"http://webapi.amap.com/images/" + (i + 1) + ".png\"></td>" + "<td><h3><font color=\"#00a6ac\">名称: " + poiArr[i].name + "</font></h3>";
		            resultStr1 += TipContents(poiArr[i].type, poiArr[i].address, poiArr[i].tel) + "</td></tr></table></div>";
		            addmarker(i, poiArr[i]);
		    }
		    v_map.setFitView();
		}
		 
		//鼠标滑过查询结果改变背景样式，根据id打开信息窗体
		function openMarkerTipById1(pointid, thiss) {
		    thiss.style.background = '#CAE1FF';
		    windowsArr[pointid].open(v_map, marker[pointid]);
		}
		 
		//添加查询结果的marker&infowindow   
		function addmarker(i, d) {
		    var lngX = d.location.getLng();
		    var latY = d.location.getLat();
		    var markerOption = {
		        map:v_map,
		        icon:"http://webapi.amap.com/images/" + (i + 1) + ".png",
		        position:new AMap.LngLat(lngX, latY)
		    };
		    var mar = new AMap.Marker(markerOption);         
		    marker.push(new AMap.LngLat(lngX, latY));
		 
		    var infoWindow = new AMap.InfoWindow({
		        content:"<h3><font color=\"#00a6ac\">  " + (i + 1) + ". " + d.name + "</font></h3>" + TipContents(d.type, d.address, d.tel),
		        size:new AMap.Size(300, 0),
		        autoMove:true, 
		        offset:new AMap.Pixel(0,-30)
		    });
		    windowsArr.push(infoWindow);
		    var aa = function (e) {infoWindow.open(v_map, mar.getPosition());};
		    AMap.event.addListener(mar, "mouseover", aa);
		}
		 
		//infowindow显示内容
		function TipContents(type, address, tel) {  //窗体内容
		    if (type == "" || type == "undefined" || type == null || type == " undefined" || typeof type == "undefined") {
		        type = "暂无";
		    }
		    if (address == "" || address == "undefined" || address == null || address == " undefined" || typeof address == "undefined") {
		        address = "暂无";
		    }
		    if (tel == "" || tel == "undefined" || tel == null || tel == " undefined" || typeof address == "tel") {
		        tel = "暂无";
		    }
		    var str = "  地址：" + address + "<br />  电话：" + tel + " <br />  类型：" + type;
		    return str;
		}
		function keydown(event){
		    var key = (event||window.event).keyCode;
		    var result = document.getElementById("result1")
		    var cur = result.curSelect;
		    if(key===40){//down
		        if(cur + 1 < result.childNodes.length){
		            if(result.childNodes[cur]){
		                result.childNodes[cur].style.background='';
		            }
		            result.curSelect=cur+1;
		            result.childNodes[cur+1].style.background='#CAE1FF';
		            document.getElementById("keyword").value = result.tipArr[cur+1].name;
		        }
		    }else if(key===38){//up
		        if(cur-1>=0){
		            if(result.childNodes[cur]){
		                result.childNodes[cur].style.background='';
		            }
		            result.curSelect=cur-1;
		            result.childNodes[cur-1].style.background='#CAE1FF';
		            document.getElementById("keyword").value = result.tipArr[cur-1].name;
		        }
		    }else if(key === 13){
		        var res = document.getElementById("result1");
				if(res && res['curSelect'] !== -1){
					selectResult(document.getElementById("result1").curSelect);
				}
		    }else{
		        autoSearch();
		    }
		}
	</script>
</body>
</html>