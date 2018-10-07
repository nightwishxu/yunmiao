<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var grid;

        var addFun = function() {
            var dialog = parent.sy.modalDialog({
                title : '添加',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=certificate/certificateEdit',
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
                url : sy.contextPath + '/go.do?path=certificate/certificateEdit&id=' + rows[0].id,
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

                    $.post(sy.contextPath + '/pawnCate/del', {
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
                url : sy.contextPath + '/certificate/list',
                columns : [ [ {
                    width : $(this).width() * 0.2,
                    title : '证书编号',
                    field : 'code',
                    align : 'center'
                },{
                    width : $(this).width() * 0.2,
                    title : '名称',
                    field : 'name',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.3,
                    title : '尺寸(长*宽*高)(单位:cm)',
                    field : 'size',
                    align : 'center',
                    formatter : function(value,row,index){
                        return row.length + "*" + row.width + "*" + row.height;
                    }
                },{
                    width : $(this).width() * 0.2,
                    title : '重量(单位:g)',
                    field : 'weight',
                    align : 'center'
                },{
                    width : $(this).width() * 0.2,
                    title : '材质',
                    field : 'material',
                    align : 'center'
                },{
                    width : $(this).width() * 0.2,
                    title : '图片概览',
                    field : 'imgs',
                    align : 'center',
                    formatter : function (value,row,index) {
                        return po.showImg(value,20,20);
                    }
                },{
                    width : $(this).width() * 0.2,
                    title : '添加流通记录',
                    field : 'addRecord',
                    align : 'center',
                    formatter : function(value,row,index){
                        var html = "";
                        return html+= "<a href='javascript:;' onclick=\"addRecord('"+row.id+"')\">添加流通记录</a>"
                    }
                },{
                    width : $(this).width() * 0.2,
                    title : '详情',
                    field : 'operation',
                    align : 'center',
                    formatter : function(value,row,index){
                        var html = "";
                        return html+= "<a href='javascript:;' onclick=\"getDetail('"+row.id+"')\">查看详情</a>"
                    }
                },
                ] ]
            });
        });

        function addRecord(id){
            var dialog = parent.sy.modalDialog({
                title : '添加流通记录',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=certificate/addRecordLog&certificateId='+id,
                buttons : [ {
                    text : '添加',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        };

        //查看详情
        function getDetail(id){
            var url = sy.contextPath +'/go.do?path=certificate/certificateDetail&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '查看详情',
                width : 800,
                height : 600,
                url : url,
            });
        }
    </script>
</head>
<body>
<div id="toolbar">
    <form id="searchForm">
        <div>
            <input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="名称"/>
            <input type="text" class="easyui-textbox" name="code" style="width: 150px" prompt="编号"/>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
        </div>
    </form>
    <div class="tbbutton">
        <div>
            <div>
                <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
                <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
                <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
            </div>
        </div>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false">


</table>
</body>
</html>