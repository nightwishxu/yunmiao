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
                url : sy.contextPath + '/go.do?path=authApply/experter/experterList/edit',
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
                url : sy.contextPath + '/go.do?path=authApply/experter/experterList/edit&id=' + rows[0].id,
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

                    $.post(sy.contextPath + '/experter/del', {
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
                url : sy.contextPath + '/experter/list',
                columns : [ [ {
                    width : $(this).width() * 0.1,
                    title : '专家姓名',
                    field : 'expertName',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.1,
                    title : '专家领域',
                    field : 'domainName',
                    align : 'center'
                },{
                    width : $(this).width() * 0.1,
                    title : '联系电话',
                    field : 'phone',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.1,
                    title : '创建时间',
                    field : 'createTime',
                    align : 'center'
                }
                ] ]
            });

            $("#domainId").combobox({
                url:sy.contextPath +'/domain/domainList',
                valueField:'id', //值字段
                textField:'domainName', //显示的字段

            });
        });
	</script>
</head>
<body>
<div id="toolbar">
	<form id="searchForm">
		<div>
			<input class="easyui-combobox" name="domainId" id="domainId" style="width: 150px" prompt="专业领域名称"/>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
		</div>
	</form>
	<div class="tbbutton">
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="addFun();">添加专家</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>

	</div>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>