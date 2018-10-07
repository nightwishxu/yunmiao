<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url=sy.contextPath + '/task/save';
			$.post(url, sy.serializeObject($('form')), function(result) {
				if (result.code == 0) {
					$grid.datagrid('load');
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
			$.post(sy.contextPath + '/task/findById', {
				id : id
			}, function(result) {
				parent.$.messager.progress('close');
				$('#jobId').textbox({novalidate:true,disabled:true});
				if (result) {
					$('form').form('load', result);
				}
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
                	<th style="width:100px;">任务ID</th>
                    <td>
                    	<input id="jobId" name="jobId" class="easyui-textbox" data-options="required:true,validType:['length[0,20]','unique[\'/task/checkJobId\']']" prompt="请输入任务ID" missingMessage="请输入任务ID"/>
                    </td>
                </tr>
                <tr>
                	<th style="width:100px;">任务名称</th>
                    <td>
                    	<input id="jobName" name="jobName" class="easyui-textbox" data-options="required:true,validType:['length[0,20]']" prompt="请输入任务名称" missingMessage="请输入任务名称"/>
                    </td>
                </tr>
                <tr>
                	<th style="width:100px;">任务组</th>
                    <td>
                    	<input id="jobGroup" name="jobGroup" class="easyui-textbox" data-options="required:true,validType:['length[0,20]']" prompt="请输入任务组" missingMessage="请输入任务组"/>
                    </td>
                </tr>
                <tr>
                	<th style="width:100px;">表达式</th>
                    <td>
                    	<input id="cronExpression" name="cronExpression" class="easyui-textbox" data-options="required:true,validType:['length[0,20]']" prompt="请输入表达式" missingMessage="请输入表达式"/>
                    	<br/><a href="http://cron.qqe2.com/" target="_blank">在线生成</a>
                    </td>
                </tr>
                <tr>
                	<th>备注:</th>
                	<td>
                		<input type="info" name="info" class="easyui-textbox" prompt="请输入备注" data-options="multiline:true,validType:'length[0,500]'" style="height:120px;"/>
				  	</td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>