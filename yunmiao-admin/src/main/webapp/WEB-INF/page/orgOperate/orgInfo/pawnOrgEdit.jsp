<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
<style>

</style>
<script type="text/javascript">
    var id = '${sessionScope.sessionUser.id}';
//    var editor;
    var save = function($dialog, $grid, $pjq) {
        if ($('form').form('validate')) {
            var obj=sy.serializeObject($('form'));
//          obj.introduction = editor.getHtml();
            var url=sy.contextPath + '/pawnOrg/save';

            $.post(url, obj, function(result) {
                if (result.code==0) {
                    parent.$.messager.i('保存成功');
                } else {
                    parent.$.messager.w('操作失败');
                }
            }, 'json');
        }
    };


    $(function() {
//        editor = new HtmlEditor('#introduction');
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
                    $('#orgImages').setFileId(result.orgImages,false,true,true);
                }
//                editor.setHtml(result.introduction);
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
                    <th style="width:100px;">账号：</th>
                    <td>
                        <input class="easyui-textbox" id = "account" name = "account"  data-options="required:true" style="width:100%"/>
                    </td>
                    <th style="width:100px;">逾期滞纳费率：</th>
                    <td>
                        <input class="easyui-textbox" id = "redeemOverrate" name = "redeemOverrate"  data-options="required:true" style="width:100%"/>
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
                <tr>
                    <th style="width:100px;">公司环境：</th>
                    <td>
                        <div id = "orgImages" name="orgImages"  type="file" multi="true"  showImage="true" fileType="jpg,png,mp4" fileSize="10MB" buttonText="上传公司环境图片"></div>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">公司简介:</th>
                    <td colspan="3">
                        <textarea id="introduction" name="introduction"  style="width: 100%;height: 100px"></textarea>
                    </td>
                </tr>
            </table>
        </div>
        <div style="padding:15px;font-size: 12px;width:50%;margin:0 auto;">
            <div style="width:10%;;margin:0 auto;">
                <a  href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="save();">保存</a>
            </div>
        </div>
    </form>
</body>
</html>