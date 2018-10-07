<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <style>

    </style>
    <script type="text/javascript">
        var id = "${id}";
        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
                var url=sy.contextPath + '/userGoods/save.do';
                $.post(url, obj, function(result) {
                    if (result.code == 0) {
                        $grid.datagrid('reload');
                        $dialog.dialog('destroy');
                    } else {
                        $pjq.messager.e('添加失败,'+result.msg);
                    }
                }, 'json');
            }
        };
        $(function() {
            if (id != '') {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/userGoods/findById.do', {
                    id : id
                }, function(result) {
                    if (result) {
                        $('form').form('load', result);
                    }
                    parent.$.messager.progress('close');
                }, 'json');
            }

        });
    </script>
</head>
<body>
<form id="form" method="post">
    <input name="id" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th style="width:100px;">设置宝贝名称：</th>
                <td>
                    <input class="easyui-textbox" id = "name" name="name" data-options="validType:['length[1,20]']" style="width:100%"/>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>