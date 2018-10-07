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
		if(rows[0].level > 1){
			parent.$.messager.w('暂支持2级目录！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '添加菜单',
			height : 350,
			url : sy.contextPath + '/go?path=role/rightEdit&parent='+rows[0].id+'&level='+(rows[0].level+1),
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
			parent.$.messager.w('请选择一条记录进行编辑！');
			return;
		}
		if(rows[0].id == '0'){
			parent.$.messager.w('根节点无法编辑！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '编辑菜单',
			height : 370,
			url : sy.contextPath + '/go?path=role/rightEdit&id=' + rows[0].id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$, parent.mainMenu);
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
				
				$.post(sy.contextPath + '/role/delright', {
					id : id
				}, function() {
					grid.treegrid('reload',r.parent);
					grid.treegrid('expand',r.parent);
				}, 'json');
			}
		});
	};

	$(function() {
		grid = $('#grid').treegrid({
			url : sy.contextPath + '/role/rightlist',
			idField : 'id',
			treeField : 'name',
			parentField : 'parentId',
			frozenColumns : [ [ {
				width : $(this).width() * 0.15,
				title : '名称',
				align : 'left',
				field : 'name'
			} ] ],
			columns : [ [{
				width : $(this).width() * 0.05,
				title : 'ID',
				field : 'id',
				align : 'center'
			}, {
				width : $(this).width() * 0.05,
				title : 'ParentId',
				field : 'parentId',
				align : 'center'
			}, {
				width : $(this).width() * 0.05,
				title : '图标',
				field : 'icon',
				align : 'center',
				formatter : function(value,row,index){
					if (value)
						return "<i class='fa " + value + "'></i>";
				}
			},{
				width : $(this).width() * 0.05,
				title : '排序',
				field : 'sortOrder',
				align : 'center'
			}, {
				width : $(this).width() * 0.2,
				title : '跳转',
				field : 'url',
				align : 'center'
			}, {
				width : $(this).width() * 0.2,
				title : '描述',
				field : 'info',
				align : 'center'
			}, {
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
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>