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
        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
                var url=sy.contextPath + '/videoOnline/save.do';

                obj.video = $('#video').getFileId();
                obj.img = $('#img').getFileId();
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
            $("#img").setFileId(ret.url+"_cut",false,1,true);
        };
        $(function() {
            if (id != '') {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/videoOnline/findById.do', {
                    id : id
                }, function(result) {
                    if (result) {
                        $('form').form('load', result);
                        //$("#backVideo").setFileId(result.backVideo,false,1,true);
                        $('#video').setFileId(result.video,false,2,true);
                        $("#img").setFileId(result.img,false,1,true);
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
                <th style="width:100px;">标题：</th>
                <td>
                    <input class="easyui-textbox" id="title" name="title" data-options="validType:['length[1,25]']" style="width:100%"/>
                </td>
                <th style="width:100px;">是否设置为首页视频：</th>
                <td>
                    <select id="state" class="easyui-combobox" name="state" style="width:100%;" data-options="editable:false">
                        <option value="0">否</option>
                        <option value="1">是</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">封面：</th>
                <td colspan="3">
                    <div id="img" fileCountLimit="1" required="required" type="file" showImage="true" showBtn="true"
                         showWidth="40" showHeight="40" bestSize="640*320" fileType="jpg,png" fileSize="200MB" buttonText="上传封面"></div>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">上传在线视频视频：</th>
                <td colspan="3">
                    <div id="video" multi="false" fileCountLimit="1" type="file" showImage="true" bestSize="640*320" fileType="mp4"
                         showWidth="250" showHeight="200" fileSize="200MB" buttonText="上传视频" url="fileUpload?dir=video" onUploadSuccess="videoUploadSuccess"></div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>