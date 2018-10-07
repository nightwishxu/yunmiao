<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
</head>
<body>
	<div style="padding: 10px">
		<div>
			<input id="account" name="account" readonly value="${id}" style="border:0px;width:100%" />
		</div>
		<div class="layui-layer-btn" style="position:absolute; right:0px; bottom:0px;"><a class="layui-layer-btn0" id='copy'>复制</a></div>
	</div>
	<script type="text/javascript" src="./static/admin/js/zclip/jquery.zclip.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$('#copy').zclip({
	        path: './static/admin/js/zclip/ZeroClipboard.swf',
	        copy: function () {
	            return $("#account").val();
	        },
	        afterCopy: function () {
	        	layer.msg("复制成功！",{time:500},function(){
	        		parent.layer.closeAll();
	        	});
	        }
	    });
	})
	</script>
</body>
</html>
