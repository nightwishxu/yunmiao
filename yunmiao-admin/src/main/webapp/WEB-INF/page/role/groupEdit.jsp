<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";
	var parent = "${parent}";
	var level = "${level}";
	
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url = sy.contextPath + '/role/addgroup';
			var obj = sy.serializeObject($('form'));
			if(parent!=""){
				obj.level = level;
				obj.parentId = parent;
			}
			obj.appId = '0';
			$.post(url,obj , function(result) {
				if (result.success) {
					$grid.treegrid('reload');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.e('操作失败');
				}
			}, 'json');
		}
	};

	$(function() {
		if (id != '') {
			$.post(sy.contextPath + '/role/findgroup', {
				id : id
			}, function(result) {
				if (result) {
					if(result.parentId == '0'){
						$("#hot").show();
					}
					$('form').form('load', result);
					
				}
			}, 'json');
			$('#code').textbox({novalidate:true,disabled:true});
		}else{
			if(parent == '0'){
				$("#hot").show();
			}
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
                    <th style="width:100px;">名称：</th>
                    <td>
                    	 <input id="name" name="name" class="easyui-textbox" data-options="required:true,validType:['length[0,15]']" missingMessage="请输入名称"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">标识：</th>
                    <td>   
                    	 <input id="code" name="code" class="easyui-textbox" data-options="required:true" missingMessage="请输入标识"/>
                    </td>
                </tr>
                 <tr>
                    <th style="width:100px;">映射类：</th>
                    <td>   
                    	 <input id="className" name="className" class="easyui-textbox" data-options="required:true" missingMessage="(如:AdminService)"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">欢迎页地址：</th>
                    <td>   
                    	 <input id="url" name="url" class="easyui-textbox" data-options="required:false" missingMessage="请输入欢迎页地址"/>
                    </td>
                </tr>
                <!-- <tr>
                    <th style="width:100px;">描述：</th>
                    <td>   
                    	 <input id="info" name="info" class="easyui-textbox" data-options="" missingMessage="请输入编号"/>
                    </td>
                </tr> -->
            </table>
        </div>
	</form>
</body>
</html>