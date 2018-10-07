<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<style>
</style>
<script type="text/javascript">
	var id = "${id}";
	
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url = sy.contextPath + '/wxkw/save';
			var obj = sy.serializeObject($('form'));
			$.post(url,obj, function(result) {
				if (result.code == 0) {
					$grid.datagrid('reload');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.e('操作失败,'+result.msg);
				}
			}, 'json');
		}
	};

	$(function() {
		$('#replyType').combobox({
			valueField: 'value',
			textField: 'name',
			data: [{name: '文本',value: '1',selected:true},{name: '图文',value: '2'}],
			onSelect : cbSelect
		});
		
		$('#resId').combobox({
			valueField: 'id',
			textField: 'title',
			url:sy.contextPath + '/wxres/all'
		});
		
		if (id != '') {
			$.post(sy.contextPath + '/wxkw/findById', {
				id : id
			}, function(result) {
				if (result) {
					cbSelect(result.replyType);
					$('form').form('load', result);
				}
			}, 'json');
		}
	});
	
	function cbSelect(record) {
		var v = record.value | record;
		if(v == 1){
			$("#contentTr").show();
			$("#replyContent").textbox({required:true});
			$("#resIdTr").hide();
			$("#resId").combobox({required:false});
		}else if(v == 2){
			$("#resIdTr").show();
			$("#resId").combobox({required:true});
			$("#contentTr").hide();
			$("#replyContent").textbox({required:false});
		}
	}
</script>
</head>
<body>
	<form id="form" method="post">
        <input name="id" type="hidden" />
        <input name="fid" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            	<tr>
                    <th style="width:100px;">关键字：</th>
                    <td>
                    	 <input id="keyword" name="keyword" class="easyui-textbox" data-options="required:true,validType:['length[0,100]']" missingMessage="请输入关键字" prompt="请输入关键字"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">类型：</th>
                    <td>
                    	<select id="replyType" name="replyType" editable="false" panelHeight='auto' data-options="" />
                    </td>
                </tr>
                <tr id="contentTr">
                	<th style="width:100px;">正文：</th>
                	<td>
				  		<input id="replyContent" name="replyContent" class="easyui-textbox" data-options="required:true,multiline:true" style="height: 200px" prompt="请输入正文" missingMessage="请输入正文"/>
				  	</td>
                </tr>
                <tr style="display: none;" id="resIdTr">
                    <th style="width:100px;">图文：</th>
                    <td>
                    	 <select id="resId" name="resId" editable="false" panelHeight='auto'/>
                    </td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>