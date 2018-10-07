<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var addFun = function() {
		var dialog = parent.sy.modalDialog({
			title : '添加静态页面',
			width : 1000,
			height : 600,
			url : sy.contextPath + '/go?path=singlePage/edit',
			buttons : [ {
				text : '添加',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	};
	
	var editFun = function(id) {
		var dialog = parent.sy.modalDialog({
			title : '编辑静态页面',
			width : 1000,
			height : 600,
			url : sy.contextPath + '/go?path=singlePage/edit&id=' + id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	};
	var viewFun=function (id){
		var dialog = parent.sy.modalDialog({
			title : '预览',
			width : 640,
			height : 500,
			url :sy.contextPath +'/singlePage/' +id
		});
	};
	var delFun = function(id) {
		parent.$.messager.confirm('询问', '您确定要删除此记录？', function(r) {
			if (r) {
				$.post(sy.contextPath + '/sp/del', {
					id : id
				}, function() {
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};

	$(function() {
		grid = $('#grid').datagrid({
			url : sy.contextPath + '/sp/list',
			columns : [ [ {
				width : $(this).width() * 0.3,
				title : '名称',
				field : 'remark',
				align : 'center'
			},{
				width : $(this).width() * 0.1,
				title : '排序号',
				field : 'sortOrder',
				hidden : sy.system != 'administrator',
				align : 'center'
			},{
				width : $(this).width() * 0.1,
				title : '列表显示',
				field : 'isShow',
				hidden : sy.system != 'administrator',
				align : 'center',
				formatter : function(value, row, index) {
					switch (value) {
					case 0:
						return '<a href="javascript:void(0);" onclick="show(1,\'' + row.code + '\')" ><img src="static/admin/images/no.png" title="点击展示" > </img></a>';
					case 1:
						return '<a href="javascript:void(0);" onclick="show(0,\'' + row.code + '\')" ><img src="static/admin/images/yes.png" title="点击隐藏" > </img></a>';
					}
				}
			},{
				width : $(this).width() * 0.2,
				title : '操作',
				field : 'op',
				align : 'center',
				formatter : function(value, row, index) {
					var html = "<a href='javascript:;' class='button button-info' onclick=\"viewFun('"+row.code+"')\">预览</a> ";
					html+="<a href='javascript:;' class='button button-default' onclick=\"editFun('"+row.code+"')\">编辑</a>"
					return html;
				}
			}
			] ]
		});
		
	});
	
	function show(state, id) {
		var data = {
			code : id,
			isShow : state
		};
		SaveData(data);
	}
	function SaveData(data) {
		var url = sy.contextPath + '/sp/save';
		$.post(url, data, function() {
			grid.datagrid('reload');
		}, 'json');
	}
</script>
</head>
<body>
	<div id="toolbar">
		<c:if test="${sessionScope.sessionUser.sys == 'administrator'}">
		<div>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
		</div>
		</c:if>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>