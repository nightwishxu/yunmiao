<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var obj=sy.serializeObject($('form'));
			var url=sy.contextPath + '/msg/save';
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
		$('#type').combobox({   
			onSelect: function(rec){   
				if(rec.code == '2'){
					$('#account').show();
					$('#target').textbox({required:true});
				}else {
					$('#account').hide();
					$('#target').textbox("reset");
					$('#target').textbox({required:false});
				}
	        }
		});
		
		if (id != '') {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/msg/findById', {
				id : id
			}, function(result) {
				if (result) {
					if(result.type != 2){
						$('#account').hide();
						$('#target').textbox("reset");
						$('#target').textbox({required:false});
					}else{
						$('#account').show();
						$('#target').textbox({required:true});
					}
					
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
            		<th style="width:100px;">类型:</th>
		    		<td>
		    			<select id="type" name="type" class="easyui-combobox" missingMessage="请选择类型" editable="false" panelHeight='auto' 
                    	 	data-options="required:true,valueField: 'code',textField: 'name',data: [{name: '全部',code: '1',selected:true},{name: '个人',code: '2'}]"/>
		    		</td>
		    	</tr>
		    	<tr id="account" style="display: none;">
		    		<th>用户账号：</th>
		    		<td>
		    			<input class="easyui-numberbox" data-options="validType:['length[0,11]','exist[\'/msg/userIsNoExist\']']" name="target" type="text" missingMessage="请输入用户账号" prompt="请输入用户账号" id="target"  />
		    		</td>
		    	</tr>
		       	<tr>
		       		<th>消息内容:</th>
		    		<td>
		    			<input id="content" name="content" class="easyui-textbox" style="height: 200px"  data-options="required:true,multiline:true,validType:['length[0,50]']" missingMessage="请输入消息内容" prompt="请输入消息内容"></input>
		    			<p style="color: gray;">推送内容长度不要过长，否则有被截断的风险。</p>
		    		</td>
		    	</tr>
            </table>
        </div>
	</form>
</body>
</html>