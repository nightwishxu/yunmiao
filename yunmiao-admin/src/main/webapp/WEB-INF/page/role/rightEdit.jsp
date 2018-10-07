<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<style>
</style>
<script type="text/javascript">
	var id = "${id}";
	var parent = "${parent}";
	var level = "${level}";
	
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url = sy.contextPath + '/role/addright';
			var obj = sy.serializeObject($('form'));
			if(level!=""){
				obj.level = level;
				obj.parentId = parent;
			}
			obj.appId = '0';
			$.post(url,obj , function(result) {
				if (result.success) {
					$grid.treegrid('reload',parent);
					$grid.treegrid('expand',parent);
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.e('操作失败');
				}
			}, 'json');
		}
	};

	$(function() {
		if(level == 2){
			$("#url").textbox({required:true});
		}
		
		if (id != '') {
			$("#pid").show();
			$("#parentId").textbox({required:true});
			$.post(sy.contextPath + '/role/findright', {
				id : id
			}, function(result) {
				if (result) {
					if(result.parentId == '0'){
						$("#hot").show();
					}
					$('form').form('load', result);
					parent = result.parentId;
				}
			}, 'json');
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
            	<tr id="pid" style="display: none;">
                    <th style="width:100px;">ParentId：</th>
                    <td>
                    	 <input id="parentId" name="parentId" class="easyui-textbox" prompt="请输入上级ID"/>
                    </td>
                </tr>
            	<tr>
                    <th style="width:100px;">名称：</th>
                    <td>
                    	 <input id="name" name="name" class="easyui-textbox" data-options="required:true,validType:['length[0,15]']" prompt="请输入名称"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">跳转：</th>
                    <td>   
                    	 <input id="url" name="url" class="easyui-textbox" data-options="required:false" prompt="请输入跳转地址"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">排序(倒序)：</th>
                    <td>   
                    	 <input id="info" name="sortOrder" class="easyui-textbox" data-options="required:true,validType:'number'" prompt="请输入序号(倒序)"/>
                    </td>
                </tr>
                 <tr>
                    <th style="width:100px;">图标：</th>
                    <td>
                    	 <input id="icon" name="icon" class="easyui-textbox" data-options="required:true,validType:['length[0,30]']" prompt="请输入font-awesome图标名称"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">描述：</th>
                    <td>   
                    	 <input id="info" name="info" class="easyui-textbox" data-options="" prompt="请输入描述"/>
                    </td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>