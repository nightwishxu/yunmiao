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
        });
        $(function() {
            if (id != '') {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/userGoods/detail', {
                    id : id
                }, function(result) {
                    if (result) {
                        $('form').form('load', result);
                        var htmls = '';
                        if(result.content != ''){
                            var data = eval('(' + result.content + ')');
                            if (data){

                                for(var i = 0; i<data.length; i++){
                                    var json = data[i];
                                    var content = json.content;
                                    if (json.contentType == 3){
                                        content = po.showImg(content,20,20);
                                    }else if (json.contentType == 4){
                                        content = "<a href='javascript:;' onclick='parent.sy.showVideo(\""+content+"\")' class='button button-blue'>播放</a>";
                                    }
                                }
                                htmls += "<tr>"
                                htmls += '<th>'+json.name+'</th>';
                                htmls +=     '<td  colspan="3">'+content+'</td>';
                                htmls += "</tr>"
                            }
                        }

                        $("table").append(htmls);
                        for(var a in result){
                            $('#'+a).html(result[a]);
                        }


                    }
                    parent.$.messager.progress('close');
                }, 'json');
            }
        });

    </script>
</head>
<body>
<form id="form" method="post">
    <input id="id" name="id" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th style="width:100px;">宝贝名称：</th>
                <td id="name">

                </td>
                <th style="width:100px;">鉴定价：</th>
                <td id="authPrice">

                </td>
            <tr/>
            <%--<tr>
                <th style="width:100px;">银行卡：</th>
                <td>
                    <input class="easyui-textbox" id = "bankCardNo" name="bankCardNo"  readonly="readonly" data-options="editable:false" style="width:100%" missingMessage="银行卡"/>
                </td>
            </tr>--%>
        </table>
    </div>
</form>
</body>
</html>