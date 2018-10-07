<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var l = "${location}";
        var grid;
        var addFun = function() {
            var dialog = parent.sy.modalDialog({
                title : '添加头条信息',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go?path=focus/topLineEdit&location='+l,
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
                title : '编辑图片信息',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go?path=focus/topLineEdit&id=' + rows[0].id,
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

                    $.post(sy.contextPath + '/focus/del', {
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
                width : 640,
                height : 500,
                url :sy.contextPath +'/detail?id=' +id+'&type=2'
            });
        };

        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/focus/list?location='+l,
                singleSelect : false,
                frozenColumns : [ [ {
                    width : '100',
                    checkbox:true,
                    field : 'id',
                    align : 'center'
                }] ],
                columns : [ [
                    {
                        width : $(this).width() * 0.3,
                        title : '内容',
                        field : 'content',
                        align : 'center',
                        formatter : function(value, row, index) {
                                return value;
                        }
                    },
                    {
                        width : $(this).width() * 0.1,
                        title : '排序',
                        field : 'sortOrder',
                        align : 'center'
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
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>