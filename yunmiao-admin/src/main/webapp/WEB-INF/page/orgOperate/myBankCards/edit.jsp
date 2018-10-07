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
                var url=sy.contextPath + '/orgBankCard/save';
                obj.bankLogo = $('#bankLogo').getFileId();

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

       /* $(function() {
            if (id != '') {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/user/findById.do', {
                    id : id
                }, function(result) {
                    if (result) {
                        $('form').form('load', result);
                        /!* $('#file_upload').setFileId(result.image,true,true);*!/
                    }
                    parent.$.messager.progress('close');
                }, 'json');
            }
        });*/


    </script>
</head>
<body>
<form id="form" method="post">
    <input name="id" type="hidden" />
    <input name="fid" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th style="width:100px;">账号</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardNo" name = "bankCardNo"  data-options="editable:true" style="width:100%"/>
                </td>
                <th style="width:100px;">所属银行名称</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardName" name = "bankCardName"  data-options="editable:true" style="width:100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;"> 持卡人姓名</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardUserName" name = "bankCardUserName"  data-options="editable:true" style="width:100%"/>
                </td>
                <th style="width:100px;">预留手机号码</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardPhone" name = "bankCardPhone"  data-options="editable:true" style="width:100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">身份证号码 </th>
                <td>
                    <input class="easyui-textbox" id = "bankCardIdCard" name = "bankCardIdCard"  data-options="editable:true" style="width:100%"/>
                </td>
                <th style="width:100px;">卡类型 </th>
                <td>
                    <select class="easyui-combobox" name='bankCardType' data-options="required:true,editable:false,panelHeight:'auto'"  style="width:100%">
                        <option value='1' selected="selected">储蓄卡</option>
                        <option value='2'>信用卡</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">银行卡LOGO </th>
                <td>
                    <div id="bankLogo" fileCountLimit="1" required="required" type="file" showImage="true" showBtn="true"
                     showWidth="40" showHeight="40" bestSize="640*320" fileType="jpg,png" fileSize="200MB" buttonText="上传银行LOGO"></div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>