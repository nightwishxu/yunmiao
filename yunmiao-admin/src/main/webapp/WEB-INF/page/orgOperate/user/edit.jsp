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
            var url=sy.contextPath + '/user/saveOrgUser';

            $.post(url, obj, function(result) {
                if (result.code == 0) {
                    $grid.datagrid('reload');
                    $dialog.dialog('destroy');
                } else {
                    $pjq.messager.e('添加失败，'+result.msg);
                }
            }, 'json');
        }
    };

    $(function() {
        $("#account").numberbox({
            onChange:function(newValue,oldValue){
//                alert(newValue+"  "+oldValue);
                var url=sy.contextPath + '/user/duplicateCheck';
                $.post(url, {accountInput:newValue}, function(result) {
                    if (result.code == -1) {
                        alert(result.msg);
                    }
                }, 'json');
            }
        })

        if (id) {
            parent.$.messager.progress({
                text : '数据加载中....'
            });
            $.post(sy.contextPath + '/user/findById.do', {
                id : id
            }, function(result) {
                if (result) {
                    $('form').form('load', result);
                   /* $('#file_upload').setFileId(result.image,true,true);*/
                }
                parent.$.messager.progress('close');
            }, 'json');
        }else {
            $("#account").numberbox({editable:true})
        }

        $.extend($.fn.validatebox.defaults.rules, {
            checkIdCard: {
                validator: function(value, param){
                    var reg = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
                    var r = new RegExp(reg);
               //     console.log(value);
               //     console.log(r.test(value));
                    return r.test(value);
                },
                message: '您输入的身份证号码不正确',
            }
        });
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
                    <th style="width:100px;">用户账号：</th>
                    <td>
                        <input class="easyui-numberbox" id = "account" name = "account"  data-options="editable:false" style="width:100%"/>
                    </td>
                    <th style="width:100px;">性别：</th>
                    <td>
                        <select id="sex" name="sex" class="easyui-combobox" missingMessage="请选择性别" editable="false" panelHeight='auto' style="width:100%"
                          data-options="required:true,valueField: 'sex',textField: 'name',data: [{name: '男',sex: '1',selected:true},{name: '女',sex: '0'}]"/>
                    </td>
                </tr>   
                <tr>
                    <th style="width:100px;">身份证：</th>
                    <td>
                        <input class="easyui-validatebox" id = "idCard" name = "idCard"  data-options="editable:true,required:true,validType:'checkIdCard'" style="width:100%"/>
                    </td>
                    <th style="width:100px;">手机号：</th>
                    <td>
                        <input class="easyui-textbox" id = "phone" name = "phone"  data-options="editable:true" style="width:100%"/>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>