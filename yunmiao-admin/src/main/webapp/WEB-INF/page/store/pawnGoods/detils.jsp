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
        var editor;
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
                        $("#imgs").setFileId(result.imgs,false,1,true);
                        $("#info").html(result.info);
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
                    <input class="easyui-textbox" id = "name" name="name"  data-options="editable:false" style="width:100%" readonly="readonly" missingMessage="商品名称"/>
                </td>
                <th style="width:100px;">鉴定价：</th>
                <td>
                    <input class="easyui-textbox" id = "cost" name="cost"  data-options="editable:false" readonly="readonly" style="width:100%" missingMessage="鉴定价"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">售价：</th>
                <td>
                    <input class="easyui-textbox" id = "price" name="price"  data-options="editable:false" readonly="readonly" style="width:100%" missingMessage="鉴定价"/>
                </td>
                <th style="width:100px;">库存：</th>
                <td>
                    <input class="easyui-textbox" id = "total" name="total"  data-options="editable:false" readonly="readonly" style="width:100%" missingMessage="鉴定价"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">已售出：</th>
                <td>
                    <input class="easyui-textbox" id = "soldOut" name="soldOut"  data-options="editable:false" readonly="readonly" style="width:100%" missingMessage="鉴定价"/>
                </td>
                <th style="width:100px;">商品状态：</th>
                <td>
                    <input class="easyui-textbox" id = "shelfDown" name="shelfDown"  data-options="editable:false" readonly="readonly" style="width:100%" missingMessage="商品上下架"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">商品规格：</th>
                <td>
                    <input class="easyui-textbox" id = "spec" name="spec"  data-options="editable:false" style="width:100%" readonly="readonly" missingMessage="商品名称"/>
                </td>
            </tr>
            <tr>
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