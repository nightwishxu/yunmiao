<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var addFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.w('请选择一个父节点！');
			return;
		}
		if (rows[0].parentId.length > 2) {
			parent.$.messager.w('最多添加到第二级');
			return;
		}
		if (rows[0].parentId.length == 2 && rows[0].type != 0) {
			parent.$.messager.w('请将该菜单设为一级菜单');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '添加菜单信息',
			height : 300,
			url : sy.contextPath + '/go?path=weixin/menuEdit&parentId='+rows[0].id,
			buttons : [ {
				text : '添加',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	};
	var editFun = function(id) {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.i('请选择一条记录进行编辑！');
			return;
		}
		if(rows[0].id == '00'){
			parent.$.messager.i('根节点无法编辑！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '编辑菜单信息',
			height : 300,
			url : sy.contextPath + '/go?path=weixin/menuEdit&id=' + rows[0].id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	};
	var delFun = function(id) {
		var rows = grid.datagrid('getSelections');
		if (rows.length == 0) {
			parent.$.messager.w('请选择需要删除的记录！');
			return;
		}
		if(rows[0].id == '00'){
			parent.$.messager.w('根节点无法删除！');
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
				
				$.post(sy.contextPath + '/wxmenu/del', {
					code : id
				}, function() {
					grid.treegrid('reload',r.parentId);
				}, 'json');
			}
		});
	};
	
	function publishFun(){
		parent.$.messager.progress({
			text : '发布中....'
		});
		$.post(sy.contextPath + '/wxmenu/publish', {
		}, function(result) {
			parent.$.messager.progress('close');
			if(result.code == 0){
				parent.$.messager.i('发布成功！');
			}else{
				parent.$.messager.w(result.msg);
			}
		}, 'json');
	}
	
	$(function() {
		grid = $('#grid').treegrid({
			url:'wxmenu/tree',
			idField : 'id',
			treeField : 'name',
			parentField : 'parentId',
			columns : [ [{
				width : $(this).width() * 0.3,
				title : '名称',
				align : 'left',
				halign:'center',
				field : 'name'
			},{
				width : $(this).width() * 0.2,
				title : '类型',
				align : 'center',
				field : 'type',
				formatter : function(value, row, index) {
					if(value == 0){
						return '一级菜单';
					}else if(value == 1){
						return 'URL';
					}else if(value == 2){
						return '关键字';
					}else if(value == 3){
						return '动作指令';
					}
					return "";
				}
			},{
				width : $(this).width() * 0.3,
				title : '关联值',
				align : 'center',
				field : 'actionKey',
				formatter : function(value, row, index) {
					if(row.type == 0){
						return '';
					}else if(row.type == 1){
						return row.url;
					}else if(row.type == 2){
						return value.substring(8,value.length);
					}else if(row.type == 3){
						return value;
					}
					return "";
				}
			}
			]]
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
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-send',plain:true" onclick="publishFun();">发布</a>
		</div>
		<div style="margin-left: 5px;margin-top: 5px">
			<span>1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。</span><br/>
			<span>2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。</span><br/>
			<span>3、创建自定义菜单后，由于微信客户端缓存，需要24小时微信客户端才会展现出来。测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。</span>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>