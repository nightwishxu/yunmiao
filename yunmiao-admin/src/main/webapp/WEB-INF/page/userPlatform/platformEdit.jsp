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
                var url=sy.contextPath + '/platformGoodsBuy/saveLog';
                obj.ticket = $('#ticket').getFileId();
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
                $.post(sy.contextPath + '/platformGoodsBuy/findById', {
                    id : id
                }, function(result) {
                    if (result) {
                        $('form').form('load', result);
                        $("#ticket").setFileId(result.ticket,false,1,true);
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
                <th style="width:100px;">用户真实姓名：</th>
                <td>
                    <input class="easyui-textbox" id = "userName" name = "userName"  data-options="required:true" style="width:100%" missingMessage="请输入真实姓名"/>
                </td>
                <th style="width:100px;">所属银行：</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardName" name = "bankCardName"  data-options="required:true" style="width:100%" missingMessage="请输入所属银行"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">银行卡：</th>
                <td>
                    <input class="easyui-numberbox" id = "bankCardNo" name="bankCardNo"  data-options="required:true,min:0" style="width:100%" missingMessage="请输入银行卡"/>
                </td>

                <th style="width:100px;" >用户手机号：</th>
                <td>
                    <input class="easyui-numberbox" id = "userPhone" name = "userPhone"  data-options="required:true,min:0" style="width:100%" missingMessage="请输入用户手机号"/>
                </td>
            </tr>
            <tr>

                <th style="width:100px;" >平台收购价：</th>
                <td>
                    <input class="easyui-numberbox" id = "price" name = "price"  data-options="required:true,precision:2,min:0,max:9999999999" style="width:100%" missingMessage="请输入平台收购价"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">付款凭证：</th>
                <td colspan="3">
                    <div id="ticket" fileCountLimit="1" required="required" type="file" showImage="true" showBtn="true" showWidth="200" showHeight="200" bestSize="640*320" fileType="jpg,png" fileSize="200MB" buttonText="上传图片" style="width: 100%" ></div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>