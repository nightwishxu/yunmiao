<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>首页</title>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
	function getCurDate() {
		var d = new Date();
		var week;
		switch (d.getDay()) {
		case 1:
			week = "星期一";
			break;
		case 2:
			week = "星期二";
			break;
		case 3:
			week = "星期三";
			break;
		case 4:
			week = "星期四";
			break;
		case 5:
			week = "星期五";
			break;
		case 6:
			week = "星期六";
			break;
		default:
			week = "星期天";
		}
		var years = d.getYear() < 1000 ? (d.getYear() + 1900)
				: d.getYear();
		var month = add_zero(d.getMonth() + 1);
		var days = add_zero(d.getDate());
		var hours = add_zero(d.getHours());
		var minutes = add_zero(d.getMinutes());
		var seconds = add_zero(d.getSeconds());
		var ndate = years + "年" + month + "月" + days + "日 "
				+ hours + ":" + minutes + ":" + seconds + " "
				+ week;
		document.getElementById('dd').innerHTML = ndate;
	}
	function add_zero(temp) {
		if (temp < 10)
			return "0" + temp;
		else
			return temp;
	}
	
	$(function(){
		getCurDate();
		setInterval("getCurDate()", 1000);
		
		/* var isChrome = window.navigator.userAgent.indexOf("Chrome") !== -1;
		if(!isChrome){
			parent.layer.msg("温馨提示：强烈推荐使用chrome浏览器浏览系统");
		} */
	});
</script>
  </head>
  <body>
  	<h2><span id="dd"></span></h2>
  	<p>欢迎您：${sessionUser.rolename }(${sessionUser.account})</p>
  </body>
</html>
