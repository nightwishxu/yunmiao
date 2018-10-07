<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <style>

    </style>
    <script type="text/javascript">
        var pawnId = "${id}";

        $(function() {
            if (pawnId != '') {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/userPawn/getPawnerPawnDetail', {
                    pawnId : pawnId
                }, function(result) {
                    if (result) {
                        var image = result.image.split(",")
                        $('#images').html(po.showImg(image[0], 60, 60));

                        $('form').form('load', result);
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
                <th style="width:100px;">当品名称：</th>
                <td>
                    <input class="easyui-textbox" id = "title" name = "title" data-options="editable:false" style="width:100%"/>
                </td>
                <th style="width:100px;">当品图片：</th>
                <td>
                    <div id = "images" name="images"  type="file" multi="true" fileCountLimit="6" showImage="true" fileType="jpg,png,mp4" fileSize="200MB" buttonText="图"></div>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">当号：</th>
                <td>
                    <input class="easyui-textbox" id = "pawnTicketCode" name = "pawnTicketCode" data-options="editable:false"  style="width:100%"/>
                </td>
                <th style="width:100px;">鉴定价：</th>
                <td>
                    <input class="easyui-textbox" id = "authPrice" name = "authPrice" data-options="editable:false"  style="width:100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">当户名：</th>
                <td>
                    <input class="easyui-textbox" id = "pawnerName" name = "pawnerName" data-options="editable:false"  style="width:100%"/>
                </td>
                <th style="width:100px;">地址：</th>
                <td>
                    <input class="easyui-textbox" id = "pawnerAddress" name = "pawnerAddress" data-options="editable:false" style="width:100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">电话：</th>
                <td>
                    <input class="easyui-textbox" id = "pawnerTelNum" name = "pawnerTelNum" data-options="editable:false"  style="width:100%"/>
                </td>
                <th style="width:100px;">已发放当金：</th>
                <td>
                    <input class="easyui-textbox" id = "userMoney" name = "userMoney" data-options="editable:false"  style="width:100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">综合利率：</th>
                <td>
                    <input class="easyui-textbox" id = "rate" name = "rate"  data-options="editable:false" style="width:100%"/>
                </td>
                <th style="width:100px;">利息利率：</th>
                <td>
                    <input class="easyui-textbox" id = "moneyRate" name = "moneyRate" data-options="editable:false"  style="width:100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">综合费：</th>
                <td>
                    <input class="easyui-textbox" id = "firstCost" name = "firstCost"  data-options="editable:false" style="width:100%"/>
                </td>
                <th style="width:100px;">利息：</th>
                <td>
                    <input class="easyui-textbox" id = "moneyCost" name = "moneyCost" data-options="editable:false"  style="width:100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">借款日期：</th>
                <td>
                    <input class="easyui-textbox" id = "loanBeginTime" name = "loanBeginTime" data-options="editable:false"  style="width:100%"/>
                </td>
                <th style="width:100px;">当前应还款日期：</th>
                <td>
                    <input class="easyui-textbox" id = "loanCurrentRepayTime" name = "loanCurrentRepayTime" data-options="editable:false"  style="width:100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">已缴综合费：</th>
                <td>
                    <input class="easyui-textbox" id = "cost" name = "cost" data-options="editable:false" style="width:100%"/>
                </td>
                <th style="width:100px;">当前应还款金额：</th>
                <td>
                    <input class="easyui-textbox" id = "payBack" name = "payBack" data-options="editable:false"  style="width:100%"/>
                </td>
            </tr>
           <%-- <tr>
                <th style="width:100px;">到期/逾期天数：</th>
                <td>
                    <input class="easyui-textbox" id = "days" name = "days" data-options="editable:false" style="width:100%"/>
                </td>

            </tr>--%>
        </table>
    </div>
</form>
</body>
</html>