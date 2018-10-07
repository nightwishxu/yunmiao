<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";
	var parentId = "${parentId}";
	
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url = sy.contextPath + '/wxmenu/save';
			var obj = sy.serializeObject($('form'));
			if(parentId!=""){
				obj.parentId = parentId;
			}
			$.post(url,obj, function(result) {
				if (result.code == 0) {
					$grid.treegrid('reload',parentId);
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.e('操作失败,'+result.msg);
				}
			}, 'json');
		}
	};

	$(function() {
		if (id != '') {
			$.post(sy.contextPath + '/wxmenu/findById', {
				id : id
			}, function(result) {
				if (result) {
					cbSelect(result.type);
					if(result.parentId == '00'){
						$('#type').combobox({
							valueField: 'value',
							textField: 'name',
							data: [{name: '一级菜单',value: '0',selected:true},{name: 'URL',value: '1'},{name: '关键字',value: '2'}],
							onSelect : cbSelect
						});
					}else{
						$('#type').combobox({
							valueField: 'value',
							textField: 'name',
							data: [{name: 'URL',value: '1'},{name: '关键字',value: '2'}],
							onSelect : cbSelect
						});
					}
					
					$('form').form('load', result);
				}
			}, 'json');
		}else{
			if(parentId == '00'){
				$('#type').combobox({
					valueField: 'value',
					textField: 'name',
					data: [{name: '一级菜单',value: '0',selected:true},{name: 'URL',value: '1'},{name: '关键字',value: '2'}],
					onSelect : cbSelect
				});
			}else{
				$('#type').combobox({
					valueField: 'value',
					textField: 'name',
					data: [{name: 'URL',value: '1',selected:true},{name: '关键字',value: '2'}],
					onSelect : cbSelect
				});
				$("#urlTr").show();
				$("#url").textbox({required:true});
			}
		}
		
		
	});
	
	function cbSelect(record) {
		var v = record.value | record;
		if(v == 0){
			$("#urlTr").hide();
			$("#url").textbox({required:false});
			$("#keyTr").hide();
			$("#actionKey").textbox({required:false});
		}else if(v == 1){
			$("#urlTr").show();
			$("#url").textbox({required:true});
			$("#keyTr").hide();
			$("#actionKey").textbox({required:false});
		}else if(v == 2 || v == 3){
			$("#keyTr").show();
			$("#actionKey").textbox({required:true});
			$("#urlTr").hide();
			$("#url").textbox({required:false});
		}
	}
</script>
</head>
<body>
	<form id="form" method="post">
        <input name="id" type="hidden" />
        <input name="fid" type="hidden" />
        <input name="parentId" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            	<tr>
                    <th style="width:100px;">名称：</th>
                    <td>
                    	 <input id="name" name="name" class="easyui-textbox" data-options="required:true,validType:['length[0,100]']" missingMessage="请输入名称" prompt="请输入名称"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">类型：</th>
                    <td>
                    	<select id="type" name="type" editable="false" panelHeight='auto' data-options="" />
                    </td>
                </tr>
                <tr style="display: none;" id="urlTr">
                    <th style="width:100px;">URL：</th>
                    <td>
                    	 <input id="url" name="url" class="easyui-textbox" data-options="validType:['length[0,200]','url']" missingMessage="请输入网址" prompt="请输入网址"/>
                    </td>
                </tr>
                <tr style="display: none;" id="keyTr">
                    <th style="width:100px;">关键字：</th>
                    <td>
                    	 <input id="actionKey" name="actionKey" class="easyui-textbox" data-options="validType:['length[0,100]']" missingMessage="请输入关键字" prompt="请输入关键字"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">排序(正序)：</th>
                    <td>   
                    	 <input id="sortOrder" name="sortOrder" class="easyui-numberbox" data-options="required:true,min:1,max:5" value="" missingMessage="请输入排序号" prompt="请输入排序号"/>
                    </td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>