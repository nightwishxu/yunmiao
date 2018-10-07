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
        var commentId='${commentId}';
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

                    $.post(sy.contextPath + '/newsCommentReply/del', {
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

        function SaveData(data) {
            var url = sy.contextPath + '/newsCommentReply/save.do';
            $.post(url, data, function() {
                grid.datagrid('reload');
            }, 'json');
        }

        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/newsCommentReply/list',
                queryParams: {
                    commentId:commentId
                },
                singleSelect : false,
                frozenColumns : [ [ {
                    width : '50',
                    checkbox:true,
                    field : 'id',
                    align : 'center'
                }] ],
                columns : [ [ {
                    title : '本回复编号',
                    width : $(this).width() * 0.1,
                    field : 'ids',
                    align : 'center',
                    formatter:function(v,r){
                        return r.id;
                    }
                },{
                    width : $(this).width() * 0.1,
                    title : '被回复编号',
                    field : 'replyId',
                    align : 'center',
                },{
                    width : $(this).width() * 0.2,
                    title : '回复用户编号',
                    field : 'userId',
                    align : 'center',
                },
                    {
                        width : $(this).width() * 0.5,
                        title : '回复内容',
                        field : 'content',
                        align : 'center',
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
 <%--       <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>--%>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>