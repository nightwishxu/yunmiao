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
                var url=sy.contextPath + '/userGoods/beginToOper.do';
                obj.authResult=$('#authResult').combobox('getValue');

                if(obj.authResult == 2){
                    //无法鉴定
                    if(obj.notVerifyReason == "" || obj.notVerifyReason === undefined){
                        obj.moneyRate = null;
                        obj.rate = null;
                        obj.authPrice = null;
                        return $.messager.alert('Warning','请填写无法鉴定理由');
                    }
                }else if(obj.authResult == 3){
                    //赝品

                }else if(obj.authResult == 4){
                    //真品
                    if(obj.authPrice == "" || obj.authPrice === undefined){
                        return $.messager.alert('Warning','鉴定价不能为空');
                    }
                }else{
                    return;
                }

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
            $("#price").hide();
            $("#zhRates").hide();
            $("#lxMoneyRates").hide();
            if (id != '') {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/userGoods/findById.do', {
                    id : id
                }, function(result) {
                    if (result) {
                        $('form').form('load', result);
                    }
                    parent.$.messager.progress('close');
                }, 'json');
            }
            $('#authResult').combobox({
                onChange:function(data) {
                    //选择真品,选择鉴定价格
                    if(data == 4){
                        $("#price").show();
                        $("#zhRates").show();
                        $("#lxMoneyRates").show();
                        $("#reason").hide();
                    }else {
                        $("#price").hide();
                    }
                    //选择无法鉴定，填写无法鉴定理由
                    if(data == 2){
                        $("#reason").show();
                        $("#price").hide();
                        $("#zhRates").hide();
                        $("#lxMoneyRates").hide();
                    }else{
                        $("#reason").hide();
                    }
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
                <th style="width:100px;">鉴定结果：</th>
                <td>
                    <select id="authResult" class="easyui-combobox" style="width: 100%;" editable="false">
                        <option value="2">无法鉴定</option>
                        <%--<option value="3">赝品</option>--%>
                        <option value="4">可以鉴定</option>
                    </select>
                </td>
            </tr>
            <tr id="price">
                <th style="width:100px;">鉴定价：</th>
                <td>
                    <input class="easyui-numberbox" id = "authPrice" name="authPrice" data-options="validType:['length[1,8]']" style="width:100%"/>
                </td>
            </tr>
            <tr id="zhRates">
                <th style="width:100px;">月利率(%)：</th>
                <td>
                    <input class="easyui-textbox" id = "rate" name="rate" data-options="validType:['length[1,8]']" style="width:100%"/>
                </td>
            </tr>
            <tr id="lxMoneyRates">
                <th style="width:100px;">月费率(%)：</th>
                <td>
                    <input class="easyui-textbox" id = "moneyRate" name="moneyRate" data-options="validType:['length[1,8]']" style="width:100%"/>
                </td>
            </tr>
            <tr id="reason">
                <th style="width:100px;">无法鉴定理由：</th>
                <td>
                    <input class="easyui-textbox" id = "notVerifyReason" name="notVerifyReason" data-options="validType:['length[1,100]']" style="width:100%"/>
                </td>
            </tr>
            <
        </table>
    </div>
</form>
</body>
</html>