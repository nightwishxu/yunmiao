<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
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
				
				$.post(sy.contextPath + '/feedback/del', {
					id : id
				}, function() {
					rows.length = 0;//必须，否则有bug
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};

	$(function() {
		grid = $('#grid').datagrid({
			title : '',
			url : sy.contextPath + '/feedback/list',
			singleSelect : false,
			frozenColumns : [ [ {
				width : '100',
				checkbox:true,
				field : 'id',
				align : 'center'
			}] ],
			
			columns : [ [ {
				width :  $(this).width()*0.2,
				title : '用户',
				field : 'account',
				align : 'center'
			}, {
				width : $(this).width()*0.6,
				title : '内容',
				field : 'info',
				align : 'center',
				formatter:function(v,r,i){
					if(v!=null){
						return UT.addTitle(v);
					}
				}
			}, {
				width :  $(this).width()*0.15,
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
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>