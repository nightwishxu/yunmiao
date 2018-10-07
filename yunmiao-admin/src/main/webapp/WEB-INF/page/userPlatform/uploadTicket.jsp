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
                obj.ticket = $("#ticket").getFileId();
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
        var videoUploadSuccess = function (ret) {
            $("#ticket").setFileId(ret.url+"_cut",false,1,true);
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
    <input name="id" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th style="width:100px;">付款凭证：</th>
                <td colspan="3">
                    <div id="ticket" fileCountLimit="1" required="required" type="file" showImage="true" showBtn="true"
                         showWidth="40" showHeight="40" bestSize="640*320" fileType="jpg,png" fileSize="200MB" buttonText="上传凭证"></div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>