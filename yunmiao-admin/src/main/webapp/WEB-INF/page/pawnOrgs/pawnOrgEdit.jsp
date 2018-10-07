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
        <input name="type" value="1" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
                <tr>
                    <th style="width:100px;">账号：</th>
                    <td colspan="3">
                        <input class="easyui-textbox" id = "account" name = "account"  data-options="required:true" style="width:100%"/>
                    </td>
                    <input type="hidden" id = "password" name = "password"/>
                </tr>   
                <tr>
                    <th style="width:100px;">机构名称：</th>
                    <td>
                        <input class="easyui-textbox" id = "name" name = "name"  data-options="required:true" style="width:100%"/>
                    </td>
                    <th style="width:100px;">机构法人：</th>
                    <td >
                        <input class="easyui-textbox" id = "legalPerson" name = "legalPerson"  data-options="required:true,validType:'length[1,25]'" style="width:100%"/>
                    </td>
                </tr>         
                <tr>
                    <th style="width:100px;">注册资金：</th>
                    <td>
                        <input class="easyui-textbox" id = "registeredCapital" name = "registeredCapital"  data-options="required:true,validType:'length[1,10]'" style="width:100%"/>
                    </td>
                    <th style="width:100px;">机构地址：</th>
                    <td>
                        <input class="easyui-textbox" id = "adress" name = "adress"  data-options="required:true,validType:'length[1,25]'" style="width:100%"/>
                    </td>
                </tr>
                <tr>

                    <th style="width:100px;">工商许可证号：</th>
                    <td>
                        <input class="easyui-textbox" id = "businessLicenseCode" name = "businessLicenseCode"  data-options="required:false,validType:'length[1,50]'" style="width:100%"/>
                    </td>
                    <th style="width:100px;">电话：</th>
                    <td>
                        <input class="easyui-textbox" id = "phone" name = "phone"  data-options="required:true,validType:'phone'" style="width:100%"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">工商许可证：</th>
                    <td>
                        <div id = "businessLicense" name="businessLicense"  type="file" multi="false" showImage="true" fileType="jpg,png,mp4" fileSize="10MB" buttonText="上传工商许可证图片" ></div>
                    </td>
                    <th style="width:100px;">机构LOGO：</th>
                    <td>
                        <div id = "orgLogo" name="orgLogo"  type="file" multi="false"  showImage="true" fileType="jpg,png,mp4" fileSize="10MB" buttonText="上传机构LOGO"></div>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>