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
            var url=sy.contextPath + '/pawnOrg/save.do';

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
            $.post(sy.contextPath + '/pawnOrg/findById.do', {
                id : id
            }, function(result) {
                if (result) {
                    $('#account').textbox({readonly:true});
                    $('form').form('load', result);
                    $('#businessLicense').setFileId(result.businessLicense,false,true,true);
                    $('#orgLogo').setFileId(result.orgLogo,false,true,true);
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
        <input name="type" value="3" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
                <tr>
                    <th style="width:100px;">账号：</th>
                    <td>
                        <input class="easyui-textbox" id = "account" name="account"  data-options="required:true" style="width:100%" missingMessage="请输入账号"/>
                    </td>
                </tr>

                <tr>
                    <th style="width:100px;">店铺名：</th>
                    <td>
                        <input class="easyui-textbox" id = "name" name = "name"  data-options="required:true" style="width:100%" missingMessage="请输入店铺名"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">供应商负责人：</th>
                    <td>
                        <input class="easyui-textbox" id = "legalPerson" name="legalPerson"  data-options="required:true" style="width:100%" missingMessage="请输入供应商负责人"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">供应商地址：</th>
                    <td>
                        <input class="easyui-textbox" id = "adress" name="adress"  data-options="required:true" style="width:100%" missingMessage="请输入地址"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">供应商联系方式：</th>
                    <td>
                        <input class="easyui-numberbox" id = "phone" name = "phone"  data-options="required:true,min:0" style="width:100%" missingMessage="请输入联系方式"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">店铺logo：</th>
                    <td>
                        <div id = "img" name="orgLogo"  type="file" multi="false" showImage="true" fileType="jpg,png" fileSize="20MB" buttonText="店铺logo" ></div>
                    </td>
                </tr>

            </table>
        </div>
    </form>
</body>
</html>