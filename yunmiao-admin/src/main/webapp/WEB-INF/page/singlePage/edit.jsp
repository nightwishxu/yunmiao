<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";
	var editor;
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('Validate')) {
			var obj=sy.serializeObject($('form'));
			obj.content = editor.getHtml();
			var url=sy.contextPath + '/sp/save';
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
		editor = new HtmlEditor('#content');
		if (id != '') {
			$("#code").textbox({readonly:true,required:false,validType:''});
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/sp/findByCode', {
				code : id
			}, function(result) {
				if (result) {
					$('form').form('load', result);
					editor.setHtml(result.content);
				}
				parent.$.messager.progress('close');
			}, 'json');

		}
		
		
	});
</script>
</head>
<body>
	<form id="form" method="post">
		<c:if test="${sessionScope.sessionUser.sys != 'administrator'}">
        <input name="code" type="hidden" />
        </c:if>
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            	<c:if test="${sessionScope.sessionUser.sys == 'administrator'}">
            	<tr>
                    <th style="width:100px;">编号：</th>
                    <td>   
                    	 <input id="code" name="code" class="easyui-textbox" required="true" data-options="validType:['unique[\'/sp/checkExists\']']"/>
                    </td>
                </tr>
                <tr>
                	<th style="width:100px;">名称:</th>
                	<td>
				  		<input id="remark" name="remark" class="easyui-textbox" data-options="required:true,validType:['length[0,20]']" prompt="请输入名称"/>
				  	</td>
                </tr>
                 <tr>
                    <th style="width:100px;">排序(倒序)：</th>
                    <td>   
                    	 <input id="sortOrder" name="sortOrder" class="easyui-numberbox" data-options="required:true,min:0,max:9999" value="" missingMessage="请输入排序号" prompt="请输入排序号"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">列表展示：</th>
                    <td>   
                    	 <select id="isShow" name="isShow" editable="false" class="easyui-combobox" panelHeight='auto' data-options="valueField: 'value',textField: 'name',data: [{name: '展示',value: '1',selected:true},{name: '隐藏',value: '0'}]"></select>
                    </td>
                </tr>
                
                </c:if>
                <tr>
                	<th style="width:100px;">内容:</th>
                	<td>
				  		<textarea id="content" style="width:98%;height: 400px"></textarea>
				  	</td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>