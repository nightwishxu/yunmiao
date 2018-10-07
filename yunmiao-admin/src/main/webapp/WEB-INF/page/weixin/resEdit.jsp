<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var obj=sy.serializeObject($('form'));
			var url=sy.contextPath + '/wxres/save';
			$.post(url, obj, function(result) {
				if (result.code == 0) {
					$grid.datagrid('reload');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.e('添加失败,'+result.msg);
				}
			}, 'json');
		}
	};
	
	$(function() {
		if (id != '') {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/wxres/findById', {
				id : id
			}, function(result) {
				if (result) {
					$('form').form('load', result);
				}
				parent.$.messager.progress('close');
			}, 'json');
		}
		
		
	});
</script>
</head>
<body>
	<form id="form" method="post">
        <input name="id" type="hidden" />
        <input name="fid" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
		    	<tr>
		    		<th style="width:100px;">名称：</th>
		    		<td>
		    			<input class="easyui-textbox" data-options="validType:['length[0,100]'],required:true" name="title" type="text" missingMessage="请输入名称" prompt="请输入名称" id="title"  />
		    		</td>
		    	</tr>
            </table>
        </div>
	</form>
</body>
</html>