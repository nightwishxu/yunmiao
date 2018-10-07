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
        $(function() {
                $("#id").val(id);
            });

        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
                console.log(obj);
                var url=sy.contextPath + '/order/save';

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
                        //$('#file_upload').setFileId(result.image,true,true);
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
                <th style="width:100px;">订单号：</th>
                <td>
                    <input class="easyui-textbox" id = "code" name="code"  data-options="required:true" style="width:100%" missingMessage="请输入订单号"/>
                </td>
                <th style="width:100px;">收件人姓名：</th>
                <td>
                    <input class="easyui-textbox" id = "shipUser" name = "shipUser"  data-options="required:true" style="width:100%" missingMessage="请输入姓名"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">商品名称：</th>
                <td>
                    <input class="easyui-textbox" id = "goodsName" name="goodsName"  data-options="required:true,precision:2,min:0,max:9999999999" style="width:100%" missingMessage="请输入商品名称"/>
                </td>
                <th style="width:100px;">收件人地址：</th>
                <td>
                    <input class="easyui-textbox" id = "shipAddress" name="shipAddress"  data-options="required:true,precision:2,min:0,max:9999999999" style="width:100%" missingMessage="请输入地址"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">收件人电话：</th>
                <td>
                    <input class="easyui-numberbox" id = "shipPhone" name = "shipPhone"  data-options="required:true,min:0" style="width:100%" missingMessage="请输入电话"/>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>