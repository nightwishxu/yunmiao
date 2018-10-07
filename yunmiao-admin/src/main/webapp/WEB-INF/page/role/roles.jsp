<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = '${id}';
	var grid;
	var addFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.w('请选择一个父节点！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '添加角色',
			url : sy.contextPath + '/go?path=role/roleEdit&parent='+rows[0].id+'&level='+(rows[0].level+1)+'&groupId='+id,
			buttons : [ {
				text : '添加',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	};
	
	var editFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.alert('请选择一条记录进行编辑！');
			return;
		}
		if(rows[0].id == '0'){
			parent.$.messager.alert('根节点无法编辑！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '编辑角色信息',
			url : sy.contextPath + '/go?path=role/roleEdit&id=' + rows[0].id+'&parent='+rows[0].parentId,
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	};
	
	var delFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length == 0) {
			parent.$.messager.w('请选择需要删除的记录！');
			return;
		}
		if(rows[0].id == '0'){
			parent.$.messager.w('根节点无法编辑！');
			return;
		}
		parent.$.messager.confirm('询问', '您确定要删除此记录？', function(r) {
			if (r) {
				var ids = [];
				for ( var i = 0, l = rows.length; i < l; i++) {
					var r = rows[i];
					ids.push(r.id);
				}
				var id = ids.join(',');
				
				$.post(sy.contextPath + '/role/delrole', {
					id : id
				}, function() {
					grid.treegrid('reload');
				}, 'json');
			}
		});
	};

	$(function() {
		grid = $('#grid').treegrid({
			url : sy.contextPath + '/role/rolelist?id='+id,
			idField : 'id',
			treeField : 'name',
			parentField : 'parentId',
			frozenColumns : [ [ {
				width : $(this).width() * 0.2,
				title : '名称',
				align : 'left',
				field : 'name'
			} ] ],
			columns : [ [{
				width : $(this).width() * 0.1,
				title : 'code',
				align : 'center',
				field : 'code'
			}, {
				width : $(this).width() * 0.1,
				title : '描述',
				field : 'info',
				align : 'center'
			}, {
				width : $(this).width() * 0.1,
				title : '更新时间',
				field : 'modifyTime',
				align : 'center'
			}, {
				width :$(this).width() * 0.1,
				title : '创建时间',
				field : 'createTime',
				align : 'center'
			}
			]]
		});
	});
</script>
</head>
<body>
	<div id="toolbar">
		<div>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>