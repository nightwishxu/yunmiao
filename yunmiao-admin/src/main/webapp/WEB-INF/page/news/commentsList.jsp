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
        var newsId='${newsId}';
        var grid;

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

                    $.post(sy.contextPath + '/newsComment/del', {
                        id : id
                    }, function() {
                        rows.length = 0;//必须，否则有bug
                        grid.datagrid('reload');
                    }, 'json');
                }
            });
        };

        function getRepleys(commentId){
            var dialog = parent.sy.modalDialog({
                title : '评论回复',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=news/repleyList&commentId='+commentId,
               /* buttons : [ {
                    text : '',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]*/
            });
        }

        var infoFun=function (id){
            var dialog = parent.sy.modalDialog({
                title : '详情页',
                height : 500,
                url :sy.contextPath +'/detail?id='+id+'&type=8'
            });
        };

        function SaveData(data) {
            var url = sy.contextPath + '/news/save.do';
            $.post(url, data, function() {
                grid.datagrid('reload');
            }, 'json');
        }

        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/newsComment/list',
                queryParams: {
                    newsId:newsId
                },
                singleSelect : false,
                frozenColumns : [ [ {
                    width : '100',
                    checkbox:true,
                    field : 'id',
                    align : 'center'
                }] ],
                columns : [ [ {
                    width : $(this).width() * 0.2,
                    title : '评论用户编号',
                    field : 'userId',
                    align : 'center',
                },
                    {
                        width : $(this).width() * 0.5,
                        title : '评论内容',
                        field : 'content',
                        align : 'center',
                        /*formatter : function(value, row, index) {
                            return "<a href='javascript:;' onclick=\"infoFun('"+row.id+"')\">查看</a>";
                        }*/
                    },
                    {
                        width : $(this).width() * 0.2,
                        title : '创建时间',
                        field : 'createTime',
                        align : 'center'
                    },
                    {
                        width : $(this).width() * 0.2,
                        title : '操作',
                        field : 'operation',
                        align : 'center',
                        formatter : function(value, row, index) {

                            return "<a href='javascript:;' onclick = \"getRepleys('"+row.id+"')\">查看该评论回复</a>";
                        }
                    }
                ] ]
            });
        });

    </script>
</head>
<body>
<div id="toolbar">
    <div>
<%--    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>--%>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>