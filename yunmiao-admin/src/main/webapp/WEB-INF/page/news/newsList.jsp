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
			url : sy.contextPath + '/go.do?path=news/newsEdit',
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
			url : sy.contextPath + '/go.do?path=news/newsEdit&id=' + rows[0].id,
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
				
				$.post(sy.contextPath + '/news/del', {
					id : id
				}, function() {
					rows.length = 0;//必须，否则有bug
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};


	var infoFun=function (id){
		var dialog = parent.sy.modalDialog({
			title : '详情页',
			height : 500,
			url :sy.contextPath +'/detail?id='+id+'&type=8'
		});
	};


	//删除记录(逻辑删除)
	function delRecord(id) {
		parent.$.messager.confirm('询问',"确定删除吗？", function(r) {
			if (r) {
				var data = {
					id : id,
					isDel : 1
				};
				SaveData(data);
			}
		});
	}

	
	//设置置顶

	function tops(newsId, id){
		var data = {
				id : newsId,
				isTop : id
		}
		SaveData(data);
	}
	
	//设置热门
	function hot(newsId, id){
		var data = {
				id : newsId,
				isHot : id
		}
		SaveData(data);
	}

	function SaveData(data) {
		var url = sy.contextPath + '/news/save.do';
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
			url : sy.contextPath + '/news/list',
			singleSelect : false,
			frozenColumns : [ [ {
				width : '100',
				checkbox:true,
				field : 'id',
				align : 'center'
			}] ],
			columns : [ [ {
				width : $(this).width() * 0.2,
				title : '板块',
				field : 'cateName',
				align : 'center',
			},{
				width : $(this).width() * 0.2,
				title : '发布人',
				field : 'nickName',
				align : 'center',
				formatter:function(v,r,i){
					if (r.userId == 0){
						return '平台';
					}else{
						return v;
					}
				}
			},{
				width : $(this).width() * 0.2,
				title : '标题',
				field : 'title',
				align : 'center',
				formatter : function(value, row, index) {
					if (row.type != 3){
						return "<a href='javascript:;' onclick='detail(\""+row.id+"\",\""+value+"\")'>"+value+"</a>";
					}else{
						return "<a href='javascript:;' onclick='parent.sy.showVideo(\""+row.content+"\",\""+value+"\")'>"+value+"</a>";
					}
					//return UT.addTitle(value);
				}
			},
			{
				width : $(this).width() * 0.2,
				title : '创建时间',
				field : 'createTime',
				align : 'center'
			},
			{
				width : $(this).width() * 0.2,
				title : '类型',
				field : 'type',
				align : 'center',
				formatter : function(value, row, index) {
						if(value == 1){
							return "<span>图文</span>";
						}else if(value == 2){
							return "<span>图片</span>";
						}else if(value == 3){
							return "<span>视频</span>";
						}
				}
			},
			{
				width : $(this).width() * 0.2,
				title : '设置热门',
				field : 'isHot',
				align : 'center',
				formatter : function(value, row, index) {
						if(value == 0){
							return '<a href="javascript:void(0);" onclick="hot(\''+row.id+'\',1);"  ><img src="static/admin/images/no.png" title="设置此条为热门" > </img></a>'
						}else if(value == 1){
							return '<a href="javascript:void(0);" onclick="hot(\''+row.id+'\',0);" ><img src="static/admin/images/yes.png" title="取消此条为热门" > </img></a>'
						}
				}
			},
			{
				width : $(this).width() * 0.2,
				title : '置顶',
				field : 'isTop',
				align : 'center',
				formatter : function(value, row, index){
					if(value == 0){
						return '<span onclick = "tops(\''+row.id+'\',1);">置顶</span>';
					}else if(value == 1){
						return '<span onclick = "tops(\''+row.id+'\',0);">取消置顶</span>';
					}
				}
			} ,
			{
				width : $(this).width() * 0.2,
				title : '是否已删除',
				field : 'isDel',
				align : 'center',
				formatter : function(value, row, index){
					if(value == 0){
						return '<span>否</span>';
					}else if(value == 1){
						return '<span>是</span>';
					}
				}
			} ,
			{
				width : $(this).width() * 0.2,
				title : '操作',
				field : 'isDels',
				align : 'center',
				formatter : function(value, row, index) {
				        var html = "";
						if(value == 0){
							html+= '<span onclick = "delRecord(\''+row.id+'\');">点击删除</span>&nbsp;';
						}
						return html+= "<a href='javascript:;' onclick=\"getComments('"+row.id+"')\">查看评论</a>"

				}
			}
			] ]
		});
	});

    function detail(id,title){
    	parent.sy.modalDialog({
            title : title,
            width : 400,
            height : 600,
            url : sy.contextPath + '/go.do?path=news/content&id='+id,
        });
    }
</script>
</head>
<body>
	<div id="toolbar">
		<form id="searchForm">
			<div>
				<input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="标题"/>
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
