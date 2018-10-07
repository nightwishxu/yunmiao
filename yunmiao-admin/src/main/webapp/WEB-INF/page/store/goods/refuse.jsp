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
        var v = "${v}";
     v
        $(function() {
            $("#id").val(id);
            $("#v").val(v);
            console.debug('id='+id+'  v='+v)
        });
        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
                var url=sy.contextPath + '/goods/changeState';
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


        });
    </script>
</head>
<body>
<form id="form" method="post">
    <input name="id" id="id" type="hidden" />
    <input name="v" id="v" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th >原因：</th>
                <td>
                    <input class="easyui-textbox" id = "refuseInfo" name = "refuseInfo"  data-options="required:true" style="width:100%" missingMessage="请输入原因"/>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>