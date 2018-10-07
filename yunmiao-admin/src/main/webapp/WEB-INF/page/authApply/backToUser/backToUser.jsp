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
                var url=sy.contextPath + '/userGoods/saveByBackToUser.do';

                obj.backVideo = $('#backVideo1').getFileId();
                obj.backImages = $('#backImages1').getFileId();
                obj.backState = 2;
                obj.backExpress = '顺丰快递';
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
                $.post(sy.contextPath + '/userGoods/findById.do', {
                    id : id
                }, function(result) {
                    console.log(result)
                    if (result) {
                        $('form').form('load', result);
                        for(var a in result) {
                            $('#' + a).html(result[a]);
                        }
                        //$("#backVideo").setFileId(result.backVideo,false,1,true);
                        $('#backVideo1').setFileId(result.backVideo,false,2,true);
                        $('#backExpress1').textbox('setValue','顺丰快递');
                        $("#backImages1").setFileId(result.backImages,false,1,true);
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
    <input name="fid" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th style="width:100px;">收件人名字：</th>
                <td>
                    <input class="easyui-textbox" id="backUserName" name="backUserName" data-options="validType:['length[1,5]']" style="width:100%" readonly="readonly"/>
                </td>
                <th style="width:100px;">收件人电话：</th>
                <td>
                    <input class="easyui-textbox" id="backUserPhone" name="backUserPhone" data-options="validType:['length[1,20]']" style="width:100%" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">收件人地址：</th>
                <td>
                    <input class="easyui-textbox" id="backUserExpress" name="backUserExpress" data-options="validType:['length[1,40]']" style="width:100%" readonly="readonly"/>
                </td>
                <th style="width:100px;">快递公司：</th>
                <td>
                    <%--<input class="easyui-textbox" id="backExpress" name="backExpress" data-options="validType:['length[1,10]']" style="width:100%" readonly="readonly"/>--%>
                    顺丰快递
                </td>
            </tr>
            <tr>
                <th style="width:100px;">快递单号：</th>
                <td colspan="3">
                    <input class="easyui-textbox" id="backExpressCode" name="backExpressCode" data-options="validType:['length[1,20]']" style="width:100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">上传物流凭证：</th>
                <td colspan="3">
                    <div id="backImages1" fileCountLimit="1" required="required" type="file" showImage="true" showBtn="true"
                         showWidth="40" showHeight="40" bestSize="640*320" fileType="jpg,png" fileSize="200MB" buttonText="上传物流凭证"></div>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">宝贝装箱视频：</th>
                <td colspan="3">
                    <div id="backVideo1" multi="false" fileCountLimit="1" type="file" showImage="true" bestSize="640*320" fileType="mp4"
                         showWidth="250" showHeight="200" fileSize="200MB" buttonText="上传视频" url="fileUpload?dir=video" onUploadSuccess="videoUploadSuccess"></div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>