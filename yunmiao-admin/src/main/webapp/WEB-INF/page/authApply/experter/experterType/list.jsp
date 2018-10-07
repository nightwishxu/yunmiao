<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/static/admin/jsp/include.jsp"%>
	<script type="text/javascript">
        var grid;
        var index;

        var addFun = function() {
            var dialog = parent.sy.modalDialog({
                title : '添加',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=authApply/experter/experterType/edit',
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
                title : '编辑',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=authApply/experter/experterType/edit&id=' + rows[0].id,
                buttons : [ {
                    text : '编辑',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        };

        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/domain/list',
                columns : [ [ {
                    width : $(this).width() * 0.1,
                    title : '专业领域名称',
                    field : 'domainName',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.1,
                    title : '创建时间',
                    field : 'createTime',
                    align : 'center'
                }
                ] ]
            });

            $('#type').combobox({
                onSelect: function(rec){
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
			<input type="text" class="easyui-textbox" name="domainName" style="width: 150px" prompt="专业领域名称"/>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
		</div>
	</form>
	<div class="tbbutton">
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="addFun();">添加专家</a>
	</div>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>