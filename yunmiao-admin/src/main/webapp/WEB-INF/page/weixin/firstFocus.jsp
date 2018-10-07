<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<style>
</style>
<script type="text/javascript">
	var submitForm = function() {
		if ($('form').form('validate')) {
			var url = sy.contextPath + '/wxfa/save';
			var obj = sy.serializeObject($('form'));
			$.post(url,obj, function(result) {
				if (result.code == 0) {
					parent.$.messager.i('设置成功！');
				} else {
					parent.$.messager.e('操作失败,'+result.msg);
				}
			}, 'json');
		}
	};

	$(function() {
		$('#type').combobox({
			valueField: 'value',
			textField: 'name',
			data: [{name: '文字',value: '0',selected:true},{name: '图文',value: '1'}],
			onSelect : cbSelect
		});
		
		$('#resId').combobox({
			valueField: 'id',
			textField: 'title',
			url:sy.contextPath + '/wxres/all'
		});
		
		$.post(sy.contextPath + '/wxfa/findById', {
		}, function(result) {
			if (result) {
				cbSelect(result.type);
				$('form').form('load', result);
			}
		}, 'json');
	});

	function cbSelect(record) {
		var v = record.value | record;
		if(v == 0){
			$("#resIdTr").hide();
			$("#resId").combobox({required:false});
			$("#contentTr").show();
			$("#content").textbox({required:true});
		}else if(v == 1){
			$("#resIdTr").show();
			$("#resId").combobox({required:true});
			$("#contentTr").hide();
			$("#content").textbox({required:false});
		}
	}
</script>
</head>
<body>
	<form id="form" method="post">
        <input name="fid" type="hidden"/>
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
                <tr>
                    <th style="width:100px;">类型：</th>
                    <td>
                    	<select id="type" name="type" editable="false" style="width:150px;" panelHeight='auto' data-options="" />
                    </td>
                </tr>
                <tr id="contentTr">
                	<th style="width:100px;">摘要:</th>
                	<td>
				  		<input id="content" name="content" class="easyui-textbox" data-options="required:true,multiline:true" style="width:90%;height: 200px" prompt="请输入欢迎语" missingMessage="请输入欢迎语"/>
				  	</td>
                </tr>
                <tr style="display: none;" id="resIdTr">
                    <th style="width:100px;">图文：</th>
                    <td>
                    	 <select id="resId" name="resId" editable="false" style="width:150px;" panelHeight='auto' data-options="" />
                    </td>
                </tr>
                <tr>
                	<th colspan="2" style="text-align: center;"><a class="easyui-linkbutton" onclick="submitForm()" data-options="iconCls:'fa-save'">保存</a></th>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>