<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript" src="${path}/static/admin/js/datagrid-cellediting.js"></script>
    <script type="text/javascript">
        var grid;
        var addFun = function() {
            var dialog = parent.sy.modalDialog({
                title : '添加',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=coupon/couponEdit',
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
                url : sy.contextPath + '/go.do?path=coupon/couponEdit&id=' + rows[0].id,
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

                    $.post(sy.contextPath + '/coupon/del', {
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
                url : sy.contextPath + '/coupon/list',
                columns : [ [ {
                    width : $(this).width() * 0.2,
                    title : '优惠金额',
                    field : 'full',
                    align : 'center'
                }/*,{
                    width : $(this).width() * 0.3,
                    title : '减',
                    field : 'value',
                    align : 'center',
                }*/,{
                    width : $(this).width() * 0.2,
                    title : '领取后有效天数',
                    field : 'days',
                    align : 'center',
                },{
                    width : $(this).width() * 0.2,
                    title : '创建时间',
                    field : 'createTime',
                    align : 'center'
                }
                ] ],
                onBeforeEdit:function (index, row) {
                    if (row.postState > 2){
                        return true;
                    }
                    return false;
                },
                onEndEdit:function (index, row, changes) {
                    if (!$.isEmptyObject(changes)){
                        changes.id = row.id;
                        save(changes);
                    }else{
                        grid.datagrid('resize');
                    }
                }
            });
            /*grid.datagrid('enableCellEditing').datagrid('gotoCell', {
                index: 0,
                field: 'name'
            });*/
        });

        function save(data) {
            $.post(sy.contextPath +'userGoods/save', data, function() {
                grid.datagrid('reload');
            }, 'json');
        }
    </script>
</head>
<body>
<div id="toolbar">
    <form id="searchForm">
        <div>
        </div>
    </form>
    <div class="tbbutton">
        <div>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
        </div>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false">


</table>
</body>
</html>