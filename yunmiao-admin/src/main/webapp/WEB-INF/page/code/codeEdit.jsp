<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";

	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url = sy.contextPath + '/code/save';
			$.post(url, sy.serializeObject($('form')), function(result) {
				if (result.code==0) {
					$grid.datagrid('reload');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.w('操作失败');
				}
			}, 'json');
		}
	};
	
	$(function() {
		if (id != '') {
			$("#code").textbox({readonly:true,required:false,validType:''});
			if(sy.system != 'administrator'){
				$("#remark").textbox({readonly:true,required:false});
			}
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/code/findById', {
				code : id
			}, function(result) {
				parent.$.messager.progress('close');
				if (result) {
					$('form').form('load', result);
				}
			}, 'json');
		
		}
	});
</script>
</head>
<body>
	<form id="form" method="post">
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            	<tr>
                    <th style="width:100px;">名称：</th>
                    <td>   
                    	 <input id="code" name="code" class="easyui-textbox" required="true" data-options="validType:['unique[\'/code/checkExists\']']"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">值：</th>
                    <td>   
                    	 <input id="value" name="value" style="height:100px;" class="easyui-textbox" data-options="required:true,multiline:true,validType:['length[0,500]']"></input>
                    </td>
                </tr> 
                <tr>
                    <th style="width:100px;">描述：</th>
                    <td>   
                    	 <input id="remark" name="remark" class="easyui-textbox" required="true" data-options="multiline:true" style="height:80px;"/>
                    </td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>