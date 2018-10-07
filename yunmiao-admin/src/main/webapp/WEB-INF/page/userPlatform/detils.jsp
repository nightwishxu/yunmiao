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
        $(function() {
            if (id != '') {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/platformGoodsBuy/findById', {
                    id : id
                }, function(result) {
                    if (result) {
                        console.log(result);
                        $('form').form('load', result);
                        //$('#file_upload').setFileId(result.image,true,true);
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
    <input id="id" name="id" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th style="width:100px;">用户真实姓名：</th>
                <td>
                    <input class="easyui-textbox" id = "userName" name="userName" readonly="readonly" data-options="editable:false" style="width:100%" missingMessage="用户真实姓名"/>
                </td>
                <th style="width:100px;">所属银行：</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardName" name="bankCardName"  readonly="readonly" data-options="editable:false" style="width:100%" missingMessage="所属银行"/>
                </td>
            <tr/>
            <tr>
                <th style="width:100px;">银行卡：</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardNo" name="bankCardNo"  readonly="readonly" data-options="editable:false" style="width:100%" missingMessage="银行卡"/>
                </td>
                <th style="width:100px;">用户手机号：</th>
                <td>
                    <input class="easyui-textbox" id = "userPhone" name="userPhone"  readonly="readonly" data-options="editable:false" style="width:100%" missingMessage="用户手机号"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">平台收购价：</th>
                <td>
                    <input class="easyui-textbox" id = "price" name="price"  readonly="readonly" data-options="editable:false" style="width:100%" missingMessage="平台收购价"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">付款凭证：</th>
                <td>
                    <div id = "ticket" name="ticket"  type="file" multi="true" fileCountLimit="6" showImage="true" fileType="jpg,png,mp4" fileSize="200MB" readonly="readonly" buttonText="付款凭证"></div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>