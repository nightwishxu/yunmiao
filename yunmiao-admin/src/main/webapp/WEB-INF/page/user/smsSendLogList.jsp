<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var delFun = function(id) {
		var rows = grid.datagrid('getSelections');
		if (rows.length == 0) {
			parent.$.messager.w('请选择需要删除的记录！');
			return;
		}
		parent.$.messager.confirm('询问', '您确定要删除此记录？', function(r) {
			if (r) {
				var ids = [];
				for (var i = 0, l = rows.length; i < l; i++) {
					var r = rows[i];
					ids.push(r.id);
				}
				var id = ids.join(',');
				$.post(sy.contextPath + '/smsSendLog/del', {
					id : id
				}, function() {
					rows.length = 0; //必须，否则有bug
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};

	$(function() {
		grid = $('#grid').datagrid({
			url : sy.contextPath + '/smsSendLog/list',
			singleSelect : false,
			columns : [ [ {
				width : '100',
				checkbox : true,
				field : 'id',
				align : 'center'
			}, {
				width : $(this).width() * 0.2,
				title : '手机号',
				field : 'phone',
				align : 'center',
				formatter : function(value, row, index) {
					if (value)
						return UT.addTitle(value);

				}
			}, {
				width : $(this).width() * 0.2,
				title : '设备id',
				field : 'deviceId',
				align : 'center'
			},
				{
					width : $(this).width() * 0.1,
					title : 'ip地址',
					field : 'ip',
					align : 'center'
				}, {
					width : $(this).width() * 0.3,
					title : '短信发送情况',
					field : 'errorName',
					align : 'center',
					formatter : function(value, row, index) {
						if (value)
							return UT.addTitle(value);
					}
				},
				{
					width : $(this).width() * 0.2,
					title : '创建时间',
					field : 'createTime',
					align : 'center'
				}
			] ]
		});
	});
</script>
</head>
<body>
	<div id="toolbar">
		<form id="searchForm">
		<div>
			<input id="type" name="phone" style="width:150px;" class="easyui-textbox" prompt="手机号"/>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a> 
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
		</div>
		</form>
		<div class="tbbutton">
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除记录</a>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>