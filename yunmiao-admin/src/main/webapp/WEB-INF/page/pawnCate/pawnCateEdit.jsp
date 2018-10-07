<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var id = "${id}";
        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
                var url=sy.contextPath + '/pawnCate/save';
                obj.icon = $("#images").getFileId();
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

            if (id != '') {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/pawnCate/findById', {
                    id : id
                }, function(result) {
                    if (result) {
                        $('form').form('load', result);
                        $('#images').setFileId(result.icon,false,1,true);
                    }
                    parent.$.messager.progress('close');
                }, 'json');

            }
    </script>
</head>
<body>
<form id="form" method="post">
    <input name="id" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th style="width:100px;">鉴定名称:</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,11]']" name="name"
                           type="text" missingMessage="请输入鉴定名称" prompt="请输入鉴定名称" id="name"  style="width: 100%"/>
                </td>
                <th style="width:100px;">编号:</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,11]']" name="cId"
                           type="text" missingMessage="编号" prompt="编号" id="cId"  style="width: 100%"/>
                </td>

            </tr>
            <tr>
                <th style="width:100px;">鉴定类别:</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,50]']" name="cateType"
                           type="text" missingMessage="请输入鉴定类别" prompt="请输入鉴定类别" id="cateType"  style="width: 100%"/>
                </td>
                <th>图片：</th>
                <td>
                    <div id="images" fileCountLimit="1" required="required" type="file" showImage="true" showBtn="true" showWidth="40" showHeight="40" bestSize="640*320" fileType="jpg,png" fileSize="200MB" buttonText="上传图片" style="width: 100%" ></div>
                </td>
            </tr>
            <tr>
                <th>排序:</th>
                <td>
                    <input class="easyui-textbox" name="sortOrder" type="text" missingMessage="排序" prompt="排序" id="sortOrder" style="width: 100%" />
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>