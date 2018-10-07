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
        var goodsSource = "${goodsSource}";

        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
                obj.platOrgVideo = $('#platOrgVideo1').getFileId();
                var url=sy.contextPath + '/userGoods/paltBackToOrg?id='+id;

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
                $.post(sy.contextPath + '/userGoods/findById', {
                    id : id
                }, function(result) {
                    if (result) {
                        $('form').form('load', result);
                        $('#backVideo1').setFileId(result.backVideo,false,2,true);
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
                <%--<th style="width:100px;">快递公司：</th>
                <td>
                    <input class="easyui-textbox" id = "code" name="code"  data-options="required:true" style="width:100%" missingMessage="顺风快递" readonly="readonly"/>
                </td>--%>
                <th style="width:100px;">快递单号：</th>
                <td colspan="3">
                    <input class="easyui-textbox" id = "shipUser" name = "platOrgExpressCode"  data-options="required:true" style="width:100%" missingMessage="请输入快递单号"/>
                </td>
                <th style="width:100px;">上传打包视频：</th>
                <td colspan="3">
                    <div id="platOrgVideo1" multi="false" fileCountLimit="1" type="file" showImage="true" bestSize="640*320" fileType="mp4"
                         showWidth="250" showHeight="200" fileSize="200MB" buttonText="上传视频" url="fileUpload?dir=video" onUploadSuccess="videoUploadSuccess"></div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>