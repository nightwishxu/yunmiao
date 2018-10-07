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
//			if(obj.redirectType == 0){
//				obj.redirectContent = '';
//			}else if(obj.redirectType == 1){
//				if(obj.redirectContent.indexOf("://") == -1){
//					$pjq.messager.w('您输入的网址格式不正确');
//					return;
//				}
//			}
			var url=sy.contextPath + '/notify/save';
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

		$('#redirectType').combobox({   
			onSelect: function(rec){   
				if(rec.code == '0'){
					$('#rc').hide();
					$('#redirectContent').textbox({required:false});
				}else if(rec.code == '1'){
					$('#rc').show();
					$('#rn').html("网址：");
					$('#redirectContent').textbox({required:true});
				}
	        }
		});
    $(function() {
		if (id != '') {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/notify/findById', {
				id : id
			}, function(result) {
				if (result) {
//					if(result.userId == null || result.userId ==''){
//						$('#account').hide();
//						$('#userId').textbox("reset");
//						$('#userId').textbox({required:false});
//					}else{
//						$('#account').show();
//						$('#userId').textbox({required:true});
//					}
//
//					if(result.redirectType == 0){
//					}else if(result.redirectType == 1){
//						$('#rc').show();
//						$('#rn').html("网址：");
//						$('#redirectContent').textbox({required:true});
//					}
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
            		<th style="width:100px;">标题:</th>
		    		<td>
						<input class="easyui-textbox" data-options="multiline:true,validType:['length[0,50]']" id="title" name="title" type="text" missingMessage="系统通知" prompt="系统通知" readonly="readonly"/>
		    		</td>
		    	</tr>
		    	<%--<tr id="account" style="display: none;">
		    		<th>用户ID：</th>
		    		<td>
		    			<input class="easyui-textbox" data-options="validType:['length[0,50]']" name="userId" type="text" missingMessage="请输入用户ID" prompt="请输入用户ID" id="userId"  />
		    		</td>
		    	</tr>--%>
		       	<tr>
		       		<th>消息内容:</th>
		    		<td>
		    			<input id="content" name="content" class="easyui-textbox" style="height: 200px"  data-options="required:true,multiline:true,validType:['length[0,500]']" missingMessage="请输入消息内容" prompt="请输入消息内容"></input>
		    		</td>
		    	</tr>
            </table>
        </div>
	</form>
</body>
</html>