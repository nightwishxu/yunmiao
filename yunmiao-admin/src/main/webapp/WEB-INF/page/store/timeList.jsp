<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<base href="<%=basePath%>">
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var addFun = function($dialog, $grid, $pjq) {
		var dialog = parent.sy.modalDialog({
			title : '添加时间',
			width : 700,
			height : 500,
			url : sy.contextPath + '/go.do?path=store/timeEdit',
			buttons : [ {
				text : '保存',
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
				
				$.post(sy.contextPath + '/msg/del.do', {
					id : id
				}, function() {
					rows.length = 0;//必须，否则有bug
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};

	$(function() {
		var menu;
		menu={
				url : sy.contextPath + '/time/list',
				toolbar : '#toolbar',
				frozenColumns : [ [ {
					width : '100',
					checkbox:true,
					field : 'id',
					align : 'center'
				}] ],
				columns : [ [ 
				{
					width : $(this).width() * 0.5,
					title : '内容',
					field : 'begin',
					align : 'center',
					formatter : function(value, row, index) {
						return value+'-'+row.end;
					}
				}
				] ]
			};
		
		grid = $('#grid').datagrid(menu);
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">

	<div id="toolbar" style="display: none;">
		<table>
			<tr>
				<td>
					<table>
						<tr>
							<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-note_add',plain:true" onclick="addFun();">添加</a></td>
							<td><div class="datagrid-btn-separator"></div></td>
							<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-table_delete',plain:true" onclick="delFun();">删除</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',fit:true,border:false">
		<table id="grid" data-options="fit:true,border:false"></table>
	</div>
</body>
</html>