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
    var source = "${source}";
    $(function() {
        $("#id").val(id);
        $("#source").val(source);
    });
    var submitForm = function($dialog, $grid, $pjq) {
        if ($('form').form('validate')) {
            var obj=sy.serializeObject($('form'));
            var url=sy.contextPath + '/goods/serviceSave';
            obj.img = $('#img').getFileId();
            obj.imgs = $('#imgs').getFileId();

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
        $('#cateCode').combobox({
            url:sy.contextPath+"/pawnCate/all",
            textField:'name',
            valueField:'code',
            editable:false
        })

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
                    $("#img").setFileId(result.img,false,1,true);
                    $("#imgs").setFileId(result.imgs,false,1,true);
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
        <input name="source" id="source" type="hidden"/>
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
                <tr>
                    <th style="width:100px;">分类：</th>
                    <td>
                        <input id = "cateCode" name="cateCode"  data-options="required:true" style="width:100%" missingMessage="请选择商品分类"/>
                    </td>
                    <th style="width:100px;">名称：</th>
                    <td>
                        <input class="easyui-textbox" id = "name" name = "name"  data-options="required:true" style="width:100%" missingMessage="请输入商品名称"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">封面：</th>
                    <td>
                        <div id = "img" name="img"  type="file" multi="false" showImage="true" fileType="jpg,png,mp4" fileSize="200MB" buttonText="上传商品封面"></div>
                    </td>
                    <th style="width:100px;">组图：</th>
                    <td>
                        <div id = "imgs" name="imgs"  type="file" multi="true" fileCountLimit="6" showImage="true" fileType="jpg,png,mp4" fileSize="200MB" buttonText="上传商品组图"></div>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">成本：</th>
                    <td>
                        <input class="easyui-numberbox" id = "cost" name="cost"  data-options="required:true,precision:2,min:0,max:9999999999" style="width:100%" missingMessage="请输入成本"/>
                    </td>

                   <th style="width:100px;" >库存：</th>
                    <td>
                        <input class="easyui-numberbox" id = "total" name = "total"  data-options="required:true,min:0" style="width:100%" missingMessage="请输入库存"/>
                    </td>

                </tr>
                <tr>
                    <th style="width:100px;">详情：</th>
                    <td colspan="3">
                        <textarea id="info" name="info"></textarea>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>