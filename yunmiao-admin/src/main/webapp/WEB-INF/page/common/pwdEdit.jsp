<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";
	var type = "${type}";
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url ;
			if(type == 0){
				url = sy.contextPath + '/role/adduser';
			}else if(type == 1){
				url = sy.contextPath + '/user/update';
			}
			
			$('#id').val(id);
			$.post(url, sy.serializeObject($('form')), function(result) {
				if (result.code == 0) {
					$grid.datagrid('load');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.e('操作失败');
				}
			}, 'json');
		}
	};
	
</script>
</head>
<body>
	<form id="form" method="post">
        <input id="id" name="id" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
                <tr>
                    <th style="width:100px;">密码：</th>
                    <td>   
                    	<input id="password" name="password" class="easyui-passwordbox" data-options="required:true" missingMessage="请输入密码"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">确认密码：</th>
                    <td>
                    	<input class="easyui-passwordbox" data-options="required:true,validType:'eqPwd[\'#password\']'" missingMessage="请输入确认密码"/>
					</td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>