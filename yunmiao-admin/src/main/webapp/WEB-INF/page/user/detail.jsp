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
    $(function() {
        if (id != '') {
            parent.$.messager.progress({
                text : '数据加载中....'
            });
            $.post(sy.contextPath + '/user/findById.do', {
                id : id
            }, function(result) {
                if (result) {

                    if(result.sex == 1){
                        $("#sex").textbox("setValue", "男");
                    }else if(result.sex == 2){
                        $("#sex").textbox("setValue","女");
                    }else{
                        return null;
                    }

                    if(result.isBind == 0){
                        $("#isBind").textbox("setValue", "未绑定");
                    }else if(result.isBind == 1){
                        $("#isBind").textbox("setValue", "已绑定");
                    }else{
                        return null;
                    }

                    if(result.type == 0){
                        $("#type").textbox("setValue", "普通用户");
                    }else if(result.type == 1){
                        $("#type").textbox("setValue", "机构员工");
                    }else{
                        return null;
                    }
                    $('form').form('load', result);
                    $('#idCardImg').setFileId(result.idCardImg,true,true);
                    $('#idCardReverse').setFileId(result.idCardReverse,true,true);
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
                    <th style="width:100px;">用户账号：</th>
                    <td>
                        <input class="easyui-textbox" id = "account" name = "account"  data-options="editable:false" style="width:100%"/>
                    </td>
                    <th style="width:100px;">用户昵称：</th>
                    <td>
                        <input class="easyui-textbox" id = "nickName" name = "nickName"  data-options="editable:false" style="width:100%" readonly="readonly"/>
                    </td>            
                </tr>   
                <tr>    
                    <th style="width:100px;">性别：</th>
                    <td>
                        <input class="easyui-textbox" id = "sex"  data-options="editable:false" style="width:100%" readonly="readonly"/>
                    </td>
                    <th style="width:100px;">手机号：</th>
                    <td>
                        <input class="easyui-textbox" id = "phone" name = "phone"  data-options="editable:false" style="width:100%"/>
                    </td>
                </tr>
                <tr>    
                    <th style="width:100px;">身份证：</th>
                    <td>
                        <input class="easyui-textbox" id = "idCard" name = "idCard"  data-options="editable:false" style="width:100%"/>
                    </td>
                    <th style="width:100px;">身份证正面：</th>
                    <td>
                        <input class="easyui-textbox" id = "idCardImg" name = "idCardImg"  data-options="editable:false" style="width:100%"/>
                    </td>
                </tr>
                <tr>
                    
                    <th style="width:100px;">身份证反面：</th>
                    <td>
                        <input class="easyui-textbox" id = "idCardReverse" name = "idCardReverse"  data-options="editable:false" style="width:100%"/>
                    </td>
                   <%-- <th style="width:100px;">身份证手持：</th>
                    <td>
                        <input class="easyui-textbox" id = "idCardHand" name = "idCardHand"  data-options="editable:false" style="width:100%"/>
                    </td>--%>
                </tr>
                <tr>

                    <th style="width:100px;">身份证是否绑定：</th>
                    <td>
                        <input class="easyui-textbox" id = "isBind"  data-options="editable:false" style="width:100%"/>
                    </td>
                    <th style="width:100px;">用户类别：</th>
                    <td>
                        <input class="easyui-textbox" id = "type"  data-options="editable:false" style="width:100%"/>
                    </td>
                </tr>
                <tr>

                    <th style="width:100px;">机构id：</th>
                    <td>
                        <input class="easyui-textbox" id = "orgId" name = "orgId"  data-options="editable:false" style="width:100%"/>
                    </td>
                </tr>

            </table>
        </div>
    </form>
</body>
</html>