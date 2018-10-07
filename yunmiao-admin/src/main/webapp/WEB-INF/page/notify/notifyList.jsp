<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var addFun = function($dialog, $grid, $pjq) {
		var dialog = parent.sy.modalDialog({
			title : '创建草稿',
			height : 500,
			url : sy.contextPath + '/go?path=notify/notifyEdit',
			buttons : [ {
				text : '保存',
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
		if(rows[0].state == 2){
			parent.$.messager.w('已发送的记录无法修改！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '编辑信息',
			height : 500,
			url : sy.contextPath + '/go?path=notify/notifyEdit&id=' + rows[0].id,
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
		parent.$.messager.confirm('询问', '您确定要删除此记录(将同时删除用户接收到的消息)？', function(r) {
			if (r) {
				var ids = [];
				for ( var i = 0, l = rows.length; i < l; i++) {
					var r = rows[i];
					ids.push(r.id);
				}
				var id = ids.join(',');
				
				$.post(sy.contextPath + '/notify/del', {
					id : id
				}, function() {
					rows.length = 0;//必须，否则有bug
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};
	
	function send(id) {
		parent.$.messager.confirm('询问',"确定发送此消息吗？", function(r) {
			if (r) {
				var data = {
					id : id
				};
				var url = sy.contextPath + '/notify/send';
				$.post(url, data, function() {
					grid.datagrid('reload');
				}, 'json');
			}
		});
	}

	$(function() {
		grid = $('#grid').datagrid({
			url : sy.contextPath + '/notify/list',
			singleSelect : false,
			frozenColumns : [ [ {
				width : '100',
				checkbox:true,
				field : 'id',
				align : 'center'
			}] ],
			columns : [ [ {
				width : $(this).width() * 0.2,
				title : '标题',
				field : 'title',
				align : 'center'
			},
			{
				width : $(this).width() * 0.1,
				title : '对象',
				field : 'userId',
				align : 'center',
				formatter : function(value, row, index) {
					if(row.userId==null ||row.userId ==''){
						return "全部";
					}
					return row.account+"("+row.nickName+")";
				}
			},
			{
				width : $(this).width() * 0.3,
				title : '内容',
				field : 'content',
				align : 'center',
				formatter : function(value, row, index) {
					return UT.addTitle(value);
				}
			}, 
			{
				width : $(this).width() * 0.1,
				title : '状态',
				field : 'state',
				align : 'center',
				formatter : function(value, row, index) {
					switch (value) {
					case 2:
						return UT.addSpanColor("已发送","green");
					case 1:
						return '<a href="javascript:void(0);" onclick="send(\''+row.id+'\')" style="color:red" title="点击发送">发送</a>';
					}
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
		<div>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">创建草稿</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改未发送消息</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>