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
                $("#id").val(id);
            var url=sy.contextPath + '/cache/expressList';
                $.ajax({
                    url:url,
                    type:"GET",
                    dataType:"text",
                    success:function(data){
                        console.log(data)
                        var result=data.split(",")
                        console.log(result[0])
                        // var result=$(data).find("String").text()
                        // var arr= result.split(",")
                        // console.log(arr[0])
                        // console.log(result)
                        // console.log(typeof result=='string')
                        // var obj=JSON.parse(result)
                        var option=""
                        var data = [];
                        for(var i=0; i<result.length; i++){
                            console.log(result[i])
                            var str=result[i].replace("[","")
                            str=str.replace("]","")
                             $("#shipFirm").append("<option value='"+str+"'>"+str+"</option>");
                            // data.push({ "text": result[i], "id": result[i] });

                        }
                        // $("#shipFirm").combobox("loadData", data);
                         // $("#shipFirm").append(option);
                        $("#shipFirm").combobox({});

                    },
                    error:function(data,type, err){
                        console.log(typeof data=='string')
                        console.log(data)
                        console.log("ajax错误类型："+type);
                        console.log(err);
                    }

                });



            }
        )

        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
                obj.state = 3;
                var url=sy.contextPath + '/order/updateState';
                $.post(url, obj, function(result) {
                    if (result.code == 0) {
                        alert("更新成功");
                        $grid.datagrid('load',{});
                        $dialog.dialog('destroy');
                    } else {
                        $pjq.messager.e('更新失败,'+result.msg);
                    }
                }, 'json');
            }
        };

    </script>
</head>
<body>
<form id="form" method="post">
    <input id="id" name="id" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">

            <th style="width:100px;">快递公司：</th>
            <td>
                <%--<input id = "cateCode" name="cateCode"  data-options="required:true" style="width:100%" missingMessage="请选择商品分类"/>--%>
                <select id="shipFirm" class="easyui-combobox" name="shipFirm" style="width:100%;" data-options="required:true,editable:false">
                    <%--<option value="顺丰快递">顺丰快递</option>--%>
                    <%--<option value="中通速递">中通速递</option>--%>
                    <%--<option value="邮政速递">邮政速递</option>--%>
                    <%--<option value="圆通速递">圆通速递</option>--%>
                    <%--<option value="韵达快运">韵达快运</option>--%>
                    <%--<option value="韵达速递">韵达速递</option>--%>
                    <%--<option value="汇通快运">汇通快运</option>--%>
                    <%--<option value="百世汇通">百世汇通</option>--%>
                    <%--<option value="申通快递">申通快递</option>--%>
                </select>
            </td>

            <tr>
                <th style="width:100px;">快递单号：</th>
                <td>
                    <input class="easyui-numberbox" id = "shipCode" name="shipCode"  data-options="required:true" style="width:100%" missingMessage="发货单号"/>
                </td>
            </tr>
           <%-- <tr>
                <th style="width:100px;">快递公司：</th>
                <td>
                    <input class="easyui-textbox" id = "shipFirm" name="shipFirm"  data-options="required:false" style="width:100%" missingMessage="快递公司"/>
                </td>
            </tr>--%>
            <tr>
                <th style="width:100px;">收件人姓名：</th>
                <td>
                    <input class="easyui-textbox" id = "shipUser" name="shipUser"  data-options="required:false" style="width:100%" missingMessage="收件人姓名"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">收件人地址：</th>
                <td>
                    <input class="easyui-textbox" id = "shipAddress" name="shipAddress"  data-options="required:false" style="width:100%" missingMessage="收件人地址"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">收件人电话：</th>
                <td>
                    <input class="easyui-numberbox" id = "shipPhone" name="shipPhone"  data-options="required:false" style="width:100%" missingMessage="收件人电话"/>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<th style="width:100px;">快递公司：</th>--%>
                <%--<td>--%>
                    <%--<input class="easyui-textbox" id = "shipFirm" name = "shipFirm"  data-options="required:true" style="width:100%" missingMessage="发货地址"/>--%>
                <%--</td>--%>
            <%--</tr>--%>
        </table>
    </div>
</form>
</body>
</html>