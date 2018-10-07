<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var addFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.w('请选择一个父节点！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '添加用户组',
			height:300,
			url : sy.contextPath + '/go?path=role/groupEdit&parent='+rows[0].id+'&level='+(rows[0].level+1),
			buttons : [ {
				text : '添加',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	};
	
	var roleFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.w('请选择一个父节点！');
			return;
		}
		if(rows[0].id == '0'){
			parent.$.messager.w('根节点无法编辑！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '用户组角色',
			url : sy.contextPath + '/go?path=role/roles&id='+rows[0].id,
			width : '900',
			height : '600'
		});
	};
	
	var menuFun = function() {
		var dialog = parent.sy.modalDialog({
			title : '菜单',
			url : sy.contextPath + '/go?path=role/menus',
			width : '900',
			height : '600'
		});
	};
	
	var editFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.w('请选择一条记录进行编辑！');
			return;
		}
		if(rows[0].id == '0'){
			parent.$.messager.w('根节点无法编辑！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '编辑用户组信息',
			height:300,
			url : sy.contextPath + '/go?path=role/groupEdit&id=' + rows[0].id,
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
				
				$.post(sy.contextPath + '/role/delgroup', {
					id : id
				}, function() {
					grid.treegrid('reload');
				}, 'json');
			}
		});
	};

	$(function() {	
		grid = $('#grid').treegrid({
			url : sy.contextPath + '/role/grouplist',
			idField : 'id',
			treeField : 'name',
			parentField : 'parentId',
			frozenColumns : [ [ {
				width : $(this).width() * 0.2,
				title : '名称',
				align : 'left',
				halign:'center',
				field : 'name'
			} ] ],
			columns : [ [{
				width : $(this).width() * 0.1,
				title : '编号',
				align : 'center',
				field : 'code'
			}, {
				width : $(this).width() * 0.1,
				title : '映射类',
				field : 'className',
				align : 'center'
			},{
				width : $(this).width() * 0.1,
				title : '欢迎页地址',
				field : 'url',
				align : 'center'
			}, /* {
				width : $(this).width() * 0.1,
				title : '描述',
				field : 'info',
				align : 'center'
			} , */{
				width : $(this).width() * 0.15,
				title : '更新时间',
				field : 'modifyTime',
				align : 'center'
			},{
				width : $(this).width() * 0.15,
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
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-user-circle',plain:true" onclick="roleFun();">角色</a>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>