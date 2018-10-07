<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <!--同意退款 --发送回寄信息-->
    <script type="text/javascript">
        var id = "${id}";
        $(function() {
                $("#id").val(id);
            });

        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
                //var url=sy.contextPath + '/order/refund';
                var url = sy.contextPath + '/order/sendRefData';
                obj.refState = 2; //同意退款
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
                $.post(sy.contextPath + '/order/findById', {
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
    <input id="id" name="id" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
<%--                <th style="width:100px;">退款回寄单号：</th>
                <td>
                    <input class="easyui-textbox" id = "backCode" name="backCode"  data-options="required:true" style="width:100%" missingMessage="退款回寄单号"/>
                </td>--%>
                <th style="width:100px;">退款回寄地址：</th>
                <td>
                    <input class="easyui-textbox" id = "backAddress" name="backAddress"  data-options="required:true" style="width:100%" missingMessage="退款回寄地址"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">退款回寄收件人：</th>
                <td>
                    <input class="easyui-textbox" id = "backUser" name="backUser"  data-options="required:true" style="width:100%" missingMessage="退款回寄收件人"/>
                </td>
                <th style="width:100px;">退款回寄联系电话：</th>
                <td>
                    <input class="easyui-textbox" id = "backPhone" name="backPhone"  data-options="required:true" style="width:100%" missingMessage="退款回寄联系电话"/>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>