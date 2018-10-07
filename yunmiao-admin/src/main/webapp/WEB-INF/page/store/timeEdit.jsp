<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<style>

</style>
<script type="text/javascript">
var id = '${id}';

var submitForm = function($dialog, $grid, $pjq) {
	if ($('form').form('validate')) {
		var obj=sy.serializeObject($('form'));
		var url=sy.contextPath + '/time/save';
		obj.storeId='0';
		obj.begin = $('#beginTime').timespinner('getValue');
		obj.end = $('#endTime').timespinner('getValue');
		$.post(url, obj, function(result) {
			if (result.code == 0) {
				$grid.datagrid('load');
				$dialog.dialog('destroy');
			} else {
				$pjq.messager.e('添加失败,'+result.msg);
			}
		}, 'json');
	}
};

$(function(){
	if (id){
		
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
		    		<th>开始时间：</th>
		    		<td>
		    			<input id='beginTime' class="easyui-timespinner" style="width:90%;"  required='true'  />
		    		</td>
		    	</tr>
		       	<tr>
		       		<th>结束时间:</th>
		    		<td>
		    			<input id='endTime' class="easyui-timespinner" style="width:90%;"  required='true'  />
		    		</td>
		    	</tr>
            </table>
        </div>
	</form>
</body>
</html>