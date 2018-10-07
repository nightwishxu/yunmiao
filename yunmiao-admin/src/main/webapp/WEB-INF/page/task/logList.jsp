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
				$.post(sy.contextPath + '/taskLog/del', {
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
			url : sy.contextPath + '/taskLog/list',
			singleSelect : false,
			columns : [ [ {
				width : $(this).width() * 0.1,
				title : '任务ID',
				field : 'jobId',
				align : 'center'
			}, {
				width : $(this).width() * 0.2,
				title : '执行方法',
				field : 'className',
				align : 'center',
				formatter : function(value, row, index) {
					return value + "." + row.methodName;
				}
			}, {
				width : $(this).width() * 0.1,
				title : '执行参数',
				field : 'param',
				align : 'center'
			}, {
				width : $(this).width() * 0.1,
				title : '结果',
				field : 'status',
				align : 'center',
				formatter : function(value, row, index) {
					switch(value){
						case 1:
							return UT.addLabel("失败", "red");
						default:
							return UT.addLabel("成功", "green");
					}
				}
			}, {
				width : $(this).width() * 0.1,
				title : '用时(秒)',
				field : 'times',
				align : 'center',
				formatter : function(value, row, index) {
					return (value/1000.0).toFixed(3);
				}
			},
			{
				width : $(this).width() * 0.2,
				title : '错误信息',
				field : 'error',
				align : 'center',
				formatter : function(value, row, index) {
					return UT.addTitle(value);
				}
			},
			{
				width : $(this).width() * 0.12,
				title : '时间',
				field : 'createTime',
				align : 'center'
			}
			] ]
		});
		
		$('#status').combobox({   
			onChange: function(rec){   
				grid.datagrid('load',sy.serializeObject($('#searchForm')));
	        } 
		});
	});
</script>
</head>
<body>
	<div id="toolbar">
		<form id="searchForm">
			<div>
				<select id="status" name="status" editable="false" style="width:150px;" panelHeight='auto' data-options="valueField: 'value',textField: 'name',data: [{name: '成功',value: '0'},{name: '失败',value: 1}]"></select>
				<input id="jobId" name="jobId" style="width:150px;" class="easyui-textbox" prompt="任务ID" /> 
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a> 
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
			</div>
		</form>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>