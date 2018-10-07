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
				$.post(sy.contextPath + '/adminLog/del', {
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
			url : sy.contextPath + '/adminLog/list',
			singleSelect : false,
			columns : [ [ {
				width : '100',
				checkbox : true,
				field : 'id',
				align : 'center'
			}, {
				width : $(this).width() * 0.05,
				title : '来源',
				field : 'source',
				align : 'center',
				formatter : function(value, row, index) {
					if (value == 1) {
						return UT.addLabel("操作","blue");
					} else{
						return UT.addLabel("异常","orange");
					}
				}
			}, {
				width : $(this).width() * 0.06,
				title : '类型',
				field : 'type',
				align : 'center',
				formatter : function(value, row, index) {
					switch(value){
						case 1:
							return "测试";
						default:
							return value;
					}
				}
			}, {
				width : $(this).width() * 0.08,
				title : '用户组',
				field : 'groupCode',
				align : 'center'
			},{
				width : $(this).width() * 0.08,
				title : '角色',
				field : 'roleCode',
				align : 'center'
			},{
				width : $(this).width() * 0.06,
				title : '用户ID',
				field : 'userId',
				align : 'center'
			},{
				width : $(this).width() * 0.08,
				title : '账号',
				field : 'account',
				align : 'center'
			},{
				width : $(this).width() * 0.08,
				title : 'IP',
				field : 'ip',
				align : 'center',
				formatter : function(value, row, index) {
					if (value)
						return UT.addTitle(value);
				}
			},{
				width : $(this).width() * 0.18,
				title : 'URL',
				field : 'url',
				align : 'center',
				formatter : function(value, row, index) {
					if (value)
						return UT.addTitle(value);
				}
			},
			{
				width : $(this).width() * 0.12,
				title : '创建时间',
				field : 'createTime',
				align : 'center'
			},
			{
				width : $(this).width() * 0.1,
				title : '操作',
				field : 'fid',
				align : 'center',
				formatter : function(value, row, index) {
					return "<a href='javascript:;' class='button button-info' onclick=\"viewFunc('"+row.id+"')\">查看描述</a>";
				}
			}
			] ]
		});
		
		$('#source').combobox({   
			onChange: function(rec){   
				grid.datagrid('load',sy.serializeObject($('#searchForm')));
	        } 
		});
	});
	
	var viewFunc = function(id){
		$.post(sy.contextPath +"/adminLog/findById", {
			id:id
		},function(data) {
			if(data){
				var content = data.content.replace(/\n/g,"<br/>");
				parent.sy.modalDialog({
					type:1,
					title : '详情描述',
					content : "<p style=\"margin:10px\">"+content+"</p>"
				});
			}
		},"json");
	}
	var addFun = function(){
		$.post(sy.contextPath +"/adminLog/errorLog", {
		},function(data) {
		},"json");
	}
</script>
</head>
<body>
	<div id="toolbar">
		<form id="searchForm">
			<div>
				<select id="source" name="source" editable="false" style="width:150px;" panelHeight='auto' data-options="valueField: 'value',textField: 'name',data: [{name: '操作日志',value: '1'},{name: '异常日志',value: '2'}]"></select>
				<input id="type" name="userId" style="width:150px;" class="easyui-textbox" prompt="用户ID" /> 
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a> 
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
			</div>
		</form>
		<div class="tbbutton">
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除记录</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="addFun();">添加一个异常日志</a>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>