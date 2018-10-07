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
                $.post(sy.contextPath + '/goods/findById', {
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
                <th style="width:100px;">商品名称：</th>
                <td>
                    <input class="easyui-textbox" id = "name" name="name"  data-options="required:true" style="width:100%" missingMessage="商品名称"/>
                </td>
            <tr/>
            <tr>
                <th style="width:100px;">售价：</th>
                <td>
                    <input class="easyui-textbox" id = "price" name = "price"  data-options="required:true" style="width:100%" missingMessage="售价"/>
                </td>
                <th style="width:100px;">鉴定价：</th>
                <td>
                    <input class="easyui-textbox" id = "cost" name="cost"  data-options="required:true" style="width:100%" missingMessage="鉴定价"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">物品描述：</th>
                <td>
                    <input class="easyui-textbox" id = "info" name="info"  data-options="required:true" style="width:100%" missingMessage="物品描述"/>
                </td>
                <th style="width:100px;">组图：</th>
                <td>
                    <div id = "imgs" name="imgs"  type="file" multi="true" fileCountLimit="6" showImage="true" fileType="jpg,png,mp4" fileSize="200MB" buttonText="组图"></div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>