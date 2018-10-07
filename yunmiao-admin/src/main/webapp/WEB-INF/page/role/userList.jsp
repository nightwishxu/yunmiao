<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var addFun = function() {
		var dialog = parent.sy.modalDialog({
			title : '添加用户',
			height : 350,
			url : sy.contextPath + '/go?path=role/userEdit',
			buttons : [ {
				text : '添加',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$, parent.mainMenu);
				}
			} ]
		});
	};
	
	var editFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.alert('warning', '请选择一条记录进行编辑！','warning');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '编辑用户信息',
			height : 250,
			url : sy.contextPath + '/go?path=role/userEdit&id=' + rows[0].id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	};
	var pwdFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.alert('请选择一条记录进行编辑！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '修改密码',
			height : 220,
			url : sy.contextPath + '/go.do?path=common/pwdEdit&type=0&id=' + rows[0].id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	}
	var delFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length == 0) {
			parent.$.messager.alert('warning', '请选择需要删除的记录！','warning');
			return;
		}
		if(rows[0].id == '0'){
			parent.$.messager.alert('warning', '根节点无法编辑！','warning');
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
				
				$.post(sy.contextPath + '/role/deluser', {
					id : id
				}, function() {
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};

	$(function() {	
		grid = $('#grid').datagrid({
			url : sy.contextPath + '/role/userlist',
			frozenColumns : [ [ {
				width : '250',
				title : '账户',
				align : 'center',
				field : 'account'
			} ] ],
			columns : [ [{
				width : '150',
				title : '用户组',
				align : 'center',
				field : 'groupName'
			}, {
				width : '200',
				title : '角色',
				field : 'roleName',
				align : 'center'
			},  {
				width : '200',
				title : '更新时间',
				field : 'modifyTime',
				align : 'center'
			}, {
				width : '200',
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
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-key',plain:true" onclick="pwdFun();">修改密码</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>