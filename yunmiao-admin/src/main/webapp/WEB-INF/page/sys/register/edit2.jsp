<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <style>

    </style>
    <script type="text/javascript">
        $.messager.e = function(){
            if(arguments.length == 1){
                layer.msg(arguments[0],{icon: 11});
            }else{
                layer.msg(arguments[1],{icon: 11});
            }
        }
        var id = "${id}";
        <%--var type = "${type}";--%>
        var source = "${source}";

        var editor;
        $(function() {
            $("#id").val(id);
            // $("#type").val(type);
            $("#source").val(source);
        });
        $.extend($.fn.validatebox.defaults.rules, {
            equals: {
                validator: function(value,param){
                    return value == $(param[0]).val();
                },
                message: '输入的密码不匹配!'
            }
        });
        var submitForm = function($dialog, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
//                if(obj.cateCode == 4 || obj.cateCode == 6){
//                    obj.cateCode = $("#cateCode2").combobox('getValue');
//                }else{
//                    obj.cateCode = $("#cateCode").combobox('getValue');
//                }

                var url=sy.contextPath + '/manager/register';
                obj.img = $('#img').getFileId();
                obj.businessLicense=$('#businessLicense').getFileId();


                layer.msg('注册成功',{icon: 11},function () {
                    $dialog.dialog('destroy')
                });
                $.post(url, obj, function(result) {
                    if (result.code == 0) {
                        layer.msg('注册成功',{icon: 11},function () {
                            $dialog.dialog('destroy')
                        });
                    } else {
                        layer.msg('添加失败,'+result.msg,{icon: 11});
                    }
                }, 'json');
            }
        };
        function des($dialog) {
            $dialog.dialog('destroy')
        }
        $(function() {
            editor = new HtmlEditor('#info');
//            $('#cateCode').combobox({
//                url:sy.contextPath+"/pawnCate/all",
//                textField:'name',
//                valueField:'code',
//                editable:false
//            })


         /*   if (id != '') {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/goods/findById', {
                    id : id
                }, function(result) {
                    if (result) {
                        console.log(result.cateCode);
                        $('form').form('load', result);
                        $("#img").setFileId(result.img,false,1,true);
                        $("#imgs").setFileId(result.imgs,false,1,true);
                        editor.setHtml(result.info);
                    }
                    parent.$.messager.progress('close');
                }, 'json');
            }*/
        });
    </script>
</head>
<body>
<form id="form" method="post">
    <input name="id" type="hidden" />
    <input name="type" id="type" type="hidden" value="1"/>
    <input name="source" id="source" type="hidden" />

    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">

            <tr>
                <th style="width:100px;">账号：</th>
                <td>
                    <input class="easyui-textbox" id = "account" name="account"  data-options="required:true" style="width:100%" missingMessage="请输入账号"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">密码：</th>
                <td>
                    <input class="easyui-textbox" type="password" id = "password" name="password"  data-options="required:true" style="width:100%" missingMessage="请输入账号"/>
                </td>
            </tr>

            <tr>
                <th style="width:100px;">确认密码：</th>
                <td>
                    <input class="easyui-textbox" type="password" id = "confirmPassword" name="confirmPassword"  data-options="required:true" style="width:100%" missingMessage="请输入账号"
                           validType="equals['#password']"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">机构名称：</th>
                <td>
                    <input class="easyui-textbox" id = "name" name = "name"  data-options="required:true" style="width:100%" missingMessage="请输入店铺名"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">机构法人：</th>
                <td>
                    <input class="easyui-textbox" id = "legalPerson" name="legalPerson"  data-options="required:true" style="width:100%" missingMessage="请输入供应商负责人"/>
                </td>
            </tr>

            <tr>
                <th style="width:100px;">注册资金：</th>
                <td>
                    <input class="easyui-textbox" id = "registeredCapital" name="registeredCapital"  data-options="required:true,min:1" style="width:100%" missingMessage="请输入供应商负责人"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">机构地址：</th>
                <td>
                    <input class="easyui-textbox" id = "adress" name="adress"  data-options="required:true" style="width:100%" missingMessage="请输入地址"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">工商许可证号：</th>
                <td>
                    <input class="easyui-textbox" id = "businessLicenseCode" name="businessLicenseCode"  data-options="required:true" style="width:100%" missingMessage="请输入工商许可证号"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">电话：</th>
                <td>
                    <input class="easyui-numberbox" id = "phone" name = "phone"  data-options="required:true,min:0" style="width:100%" missingMessage="请输入联系方式"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">工商许可证图：</th>
                <td>
                    <div id = "businessLicense" name="businessLicense"  type="file" multi="false" showImage="true" fileType="jpg,png" fileSize="20MB" buttonText="工商许可证图" ></div>
                </td>
            </tr>

            <tr>
                <th style="width:100px;">机构logo：</th>
                <td>
                    <div id = "img" name="orgLogo"  type="file" multi="false" showImage="true" fileType="jpg,png" fileSize="20MB" buttonText="店铺logo" ></div>
                </td>
            </tr>

        </table>
    </div>
</form>
</body>
</html>