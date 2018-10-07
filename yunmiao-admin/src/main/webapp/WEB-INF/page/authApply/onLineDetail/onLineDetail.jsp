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
//                parent.$.messager.progress({
//                    text : '数据加载中....'
//                });
                $.post(sy.contextPath + '/userGoods/checkDetail.do', {
                    id : id
                }, function(result) {
                    console.log(result);
                    if (result) {
                        //$('form').form('load', result);
                        var data = result.content
                        if (data){
                            var htmls = '';
                            for(var i = 0; i<data.length; i++){
                                var json = data[i];
                                var content = json.content;
                                if (json.contentType == 3){
                                    content = po.showImg(content,20,20);
                                }else if (json.contentType == 4){
                                    content = "<a href='javascript:;' onclick='parent.sy.showVideo(\""+content+"\")' class='button button-blue'>播放</a>";
                                }
                                htmls += "<tr>"
                                htmls += '<th>'+json.name+'</th>';
                                htmls +=     '<td  colspan="3">'+content+'</td>';
                                htmls += "</tr>"
                            }
                            $("table").append(htmls);
                        }

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
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th>用户账号：</th>
                <td id="account" colspan="3">

                </td>
            </tr>
            <tr>
                <th>用户昵称：</th>
                <td id="nickName">
                </td>
                <th>估价：</th>
                <td id="authPriceTest">
                </td>
            </tr>
        </table>
</body>
</html>