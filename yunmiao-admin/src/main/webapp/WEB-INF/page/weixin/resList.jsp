<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var addFun = function() {
		var dialog = parent.sy.modalDialog({
			title : '添加图文模板',
			height : 200,
			url : sy.contextPath + '/go?path=weixin/resEdit',
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
			parent.$.messager.w('请选择一条记录进行编辑！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '编辑图文模板',
			height : 200,
			url : sy.contextPath + '/go?path=weixin/resEdit&id=' + rows[0].id,
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
		parent.$.messager.confirm('询问', '您确定要删除此记录？', function(r) {
			if (r) {
				var ids = [];
				for ( var i = 0, l = rows.length; i < l; i++) {
					var r = rows[i];
					ids.push(r.id);
				}
				var id = ids.join(',');
				
				$.post(sy.contextPath + '/wxres/del', {
					id : id
				}, function() {
					rows.length = 0;//必须，否则有bug
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};
	
	var viewFunc=function (id){
		var dialog = parent.sy.modalDialog({
			title : '图文预览',
			width : 400,
			height : 600,
			url :sy.contextPath +'/go?path=weixin/resInfo&id='+id
		});
	};
	
	var articleFunc=function (id){
		var dialog = parent.sy.modalDialog({
			title : '图文列表',
			width : 1000,
			height : 600,
			url :sy.contextPath +'/go?path=weixin/articleList&id='+id,
			onClose:function(){
				grid.datagrid("reload");
			}
		});
	};

	$(function() {
		grid = $('#grid').datagrid({
			url : sy.contextPath + '/wxres/list',
			singleSelect : false,
			frozenColumns : [ [ {
				width : '100',
				checkbox:true,
				field : 'id',
				align : 'center'
			}] ],
			columns : [ [ {
				width : $(this).width() * 0.3,
				title : '名称',
				field : 'title',
				align : 'center'
			},{
				width : $(this).width() * 0.2,
				title : '文章数',
				field : 'cnt',
				align : 'center'
			},
			{
				width : $(this).width() * 0.2,
				title : '创建时间',
				field : 'createTime',
				align : 'center'
			},
			{
				width : $(this).width() * 0.3,
				title : '操作',
				field : 'fid',
				align : 'center',
				formatter : function(value, row, index) {
					return "<a href='javascript:;' class='button button-default' onclick=\"articleFunc('"+row.id+"')\">图文列表</a> <a href='javascript:;' class='button button-info' onclick=\"viewFunc('"+row.id+"')\">查看图文</a>";
				}
			}
			] ]
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