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
                $.post(sy.contextPath + '/pawnLog/search', {
                    id : id
                }, function(result) {
                    if (result) {
                        console.log(result)
                        $('form').form('load', result);
                        var htmls = '';
                        var msg = '';
                        var month = '';
                        for(var a=0;a<result.length; a++){
                            var num = Number(a)+1;
                            htmls += '<tr><th colspan="4" style="color:orange">第'+num+'次</th></tr>';
                            htmls += '<tr><th>藏品名称</th><td>'+result[a].goodsName+'</td>';
                            htmls += '<th>机构名称</th><td>'+result[a].orgName+'</td></tr>';
                            htmls += '<tr><th>金额</th><td>'+result[a].money+'</td>';
                            if(result[a].pawnMonth == 1){
                                month = '半个月'
                            }else{
                                month = result[a].pawnMonth/2 + "个月";
                            }
                            htmls += '<th>典当时长</th><td>'+month+'</td></tr>';
                            htmls += '<tr><th>用户姓名</th><td>'+result[a].userName+'</td>';
                            if(result[a].type == 0){
                                msg = '鉴定真品';
                            }else if(result[a].type == 1){
                                msg = '典当';
                            }else if(result[a].type == 2){
                                msg = '续当';
                            }else if(result[a].type == 3){
                                msg = '赎当';
                            }else if(result[a].type == 4){
                                msg = '绝当';
                            }else if(result[a].type == 5){
                                msg = '交易';
                            }else if(result[a].type == 6){
                                msg = '卖给平台';
                            }
                            htmls += '<th>类型</th><td>'+msg+'</td></tr>';
                            htmls += '<tr><th>银行</th><td>'+result[a].tradeCardBank+'</td>';
                            htmls += '<th>交易所用的银行卡</th><td>'+result[a].tradeCardCode+'</td></tr>';
                        }
                        $('#addLog').after(htmls);
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
            <tr id="addLog">
            </tr>
        </table>
    </div>
</form>
</body>
</html>