<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <style>

    </style>
    <script type="text/javascript">
        var pawnId = "${pawnId}";
        var repawnId = "${repawnId}";

        $(function() {
            console.log("-----pawnId="+pawnId+"|repawnId="+repawnId+"-----")
            if (!repawnId) {$(".repawn").css('display','none');}
            if (pawnId) {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/userPawn/repawnDetail', {
                    pawnId : pawnId,
                    repawnId:repawnId
                }, function(result) {
                    if (result) {
                        var image = result.images.split(",")
                        $('#images').html(po.showImg(image[0], 60, 60));
                        $('#currentPayTicket').html(po.showImg(result.currentPayTicket, 60, 60));
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
                    <input class="easyui-textbox" id = "goodsName" name = "goodsName" data-options="editable:false" style="width:100%"/>
                </td>
                <th style="width:100px;">当品图片：</th>
                <td>
                    <div id = "images" name="images"  type="file" multi="true" fileCountLimit="6" showImage="true" fileType="jpg,png,mp4" fileSize="200MB" buttonText="图"></div>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">当号：</th>
                <td>
                    <input class="easyui-textbox" id = "pawnCode" name = "pawnCode" data-options="editable:false"  style="width:100%"/>
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
                <th style="width:100px;">到期应还款额度：</th>
                <td>
                    <input class="easyui-textbox" id = "payBack" name = "payBack" data-options="editable:false"  style="width:100%"/>
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
                <th style="width:100px;">本次支付凭证：</th>
                <td>
                    <div id = "currentPayTicket" name="currentPayTicket"  type="file" multi="true" fileCountLimit="6" showImage="true" fileType="jpg,png,mp4" fileSize="200MB" buttonText="图"></div>
                </td>
            </tr>

            <%-- 以下内容之前至少续当过一次才显示--%>

            <tr class="repawn">
                <th style="width:100px;">续当至日期：</th>
                <td>
                    <input class="easyui-textbox" id = "dateRepawnTo" name = "dateRepawnTo" data-options="editable:false"  style="width:100%"/>
                </td>
                <th style="width:100px;">本期综合费：</th>
                <td>
                    <input class="easyui-textbox" id = "cost" name = "cost" data-options="editable:false"  style="width:100%"/>
                </td>
            </tr>
            <tr class="repawn">
                <th style="width:100px;">利息：</th>
                <td>
                    <input class="easyui-textbox" id = "preInterest" name = "preInterest" data-options="editable:false"  style="width:100%"/>
                </td>
                <th style="width:100px;">逾期滞纳金：</th>
                <td>
                    <input class="easyui-textbox" id = "demurrage" name = "demurrage" data-options="editable:false"  style="width:100%"/>
                </td>
            </tr>
            <tr class="repawn">
                <th style="width:100px;">收款人姓名：</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardUserName" name = "bankCardUserName" data-options="editable:false"  style="width:100%"/>
                </td>
                <th style="width:100px;">收款银行：</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardName" name = "bankCardName" data-options="editable:false"  style="width:100%"/>
                </td>
            </tr>
            <tr class="repawn">
                <th style="width:100px;">收款账户：</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardCode" name = "bankCardCode" data-options="editable:false"  style="width:100%"/>
                </td>
            </tr>

        </table>
    </div>
</form>
</body>
</html>