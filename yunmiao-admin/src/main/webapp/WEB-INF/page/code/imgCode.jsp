<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var code = "${code}";

	var save = function() {
		var obj = {code:code};
		var fid=$('#file_upload').getFileId();
		if(fid==null||fid==''){
			$.messager.e('您还未上传图片');
			return ;
		}
		obj.value = fid;
		var url = sy.contextPath + '/code/save';
		$.post(url, obj, function(result) {
			if (result.code==0) {
				$.messager.i('保存成功');
			} else {
				$.messager.e('操作失败');
			}
		}, 'json');
	};
	
	$(function() {
		parent.$.messager.progress({
			text : '数据加载中....'
		});
		$.post(sy.contextPath + '/code/findById', {
			code : code
		}, function(result) {
			parent.$.messager.progress('close');
			if (result) {
				$("#remark").html(result.remark);
				$('#file_upload').setFileId(result.value,false,true,true);
			}
		}, 'json');
	});
</script>
</head>
<body>
	<form id="form" method="post">
        <div style="padding:15px;font-size: 12px">
        	<a class="easyui-linkbutton" onclick="save()" data-options="iconCls:'fa-save'">保存</a>
			<h3 id="remark"></h3>
        	<div id="file_upload" multi="false" type="file" showImage="true" showBtn='false' fileType="jpg,png,gif" fileSize="500KB" buttonText="上传图片"></div>
        </div>
	</form>
</body>
</html>