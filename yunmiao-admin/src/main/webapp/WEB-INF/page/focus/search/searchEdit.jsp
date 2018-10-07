<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var l = "${location}";
	var id = "${id}";
	var editor;
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('Validate')) {
			var obj=sy.serializeObject($('form'));
			obj.location = '5';
			obj.img = '';
			obj.type = '0'
			var url=sy.contextPath + '/ad/save';
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
			$.post(sy.contextPath + '/focus/findById', {
				id : id
			}, function(result) {
				if (result) {
					$('form').form('load', result);
				}
				parent.$.messager.progress('close');
			}, 'json');

		}else{
		}
		
		
	});
</script>
</head>
<body>
	<form id="form" method="post">
        <input name="id" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            	<tr>
                    <th style="width:100px;">设置搜索关键词：</th>
                    <td>
                        <input id="content" name="content" class="easyui-textbox" data-options="validType:['length[0,100]']" missingMessage="请输入"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">排序(倒序)：</th>
                    <td>   
                    	 <input id="sortOrder" name="sortOrder" class="easyui-numberbox" data-options="min:0,max:9999" value="" missingMessage="请输入排序号" prompt="请输入排序号"/>
                    </td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>