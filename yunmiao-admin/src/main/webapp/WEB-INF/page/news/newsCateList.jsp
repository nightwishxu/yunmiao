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
	var addFun = function() {
		var dialog = parent.sy.modalDialog({
			title : '添加',
			width : 800,
			height : 600,
			url : sy.contextPath + '/go.do?path=news/newsCateEdit',
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
			title : '编辑信息',
			width : 800,
			height : 600,
			url : sy.contextPath + '/go.do?path=news/newsCateEdit&id=' + rows[0].id,
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
		parent.$.messager.confirm('询问', '您确定要删除此记录？(删除后该板块下的所有新闻也将删除)', function(r) {
			if (r) {
				var ids = [];
				for ( var i = 0, l = rows.length; i < l; i++) {
					var r = rows[i];
					ids.push(r.id);
				}
				var id = ids.join(',');
				
				$.post(sy.contextPath + '/newsCate/del', {
					id : id
				}, function() {
					rows.length = 0;//必须，否则有bug
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};

	function SaveData(data) {
		var url = sy.contextPath + '/newsCate/save.do';
		$.post(url, data, function() {
			grid.datagrid('reload');
		}, 'json');
	}

    function getComments(newsId){
        var dialog = parent.sy.modalDialog({
            title : '评论',
            width : 800,
            height : 600,
            url : sy.contextPath + '/go.do?path=news/commentsList&newsId='+newsId,
            /* buttons : [ {
             text : '',
             handler : function() {
             dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
             }
             } ]*/
        });
    };


    $(function() {
		grid = $('#grid').datagrid({
			url : sy.contextPath + '/newsCate/list',
			singleSelect : false,
			frozenColumns : [ [ {
				width : '100',
				checkbox:true,
				field : 'id',
				align : 'center'
			}] ],
			columns : [ [ {
				width : $(this).width() * 0.2,
				title : '名称',
				field : 'name',
				align : 'center',
			},{
				width : $(this).width() * 0.2,
				title : '排序',
				field : 'sortOrder',
				align : 'center',
			},{
				width : $(this).width() * 0.2,
				title : '分类类型',
				field : 'contentType',
				align : 'center',
				formatter : function(value, row, index){
					if(value == 0){
						return "全部";
					}else if(value == 1){
						return "图文";
					}else if(value == 2){
						return "图片";
					}else if(value == 3){
						return "视频";
					}
				}
			},{
				width : $(this).width() * 0.2,
				title : '类型',
				field : 'type',
				align : 'center',
				formatter : function(value, row, index){
					if(value == 1){
						return "公开";
					}else if(value == 2){
						return "地区";
					}
				}
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
				<input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="名称"/>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a> 
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
			</div>
		</form>
		<div>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false">
	
	</table>
</body>
</html>
