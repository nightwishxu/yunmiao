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
                $.post(sy.contextPath + '/certificate/checkDetail.do', {
                    id : id
                }, function(result) {

                    if (result) {
                        $('form').form('load', result);
                        for(var a in result){
                            $('#'+a).html(result[a]);

                        }
                        var htmls = '';
                        for(var rep = 0; rep<result.list.length; rep++){
                            htmls += '<tr><th>流通记录时间</th><td>'+result.list[rep].logTime.substr(0,11)+'</td>';
                            htmls += '<th>流通记录价格</th><td>'+result.list[rep].price+'</td></tr>';
                        }
                        $('#addLog').after(htmls);
                        $('#size').html(result.length+'*'+result.width+'*'+result.height);
                        $('#imgs').html(po.showImg(result.imgs,20,20));
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
                <th>名称：</th>
                <td id="name">

                </td>
                <th>编号：</th>
                <td id="code">

                </td>
            </tr>
            <tr>
                <th>尺寸(单位：cm)：</th>
                <td id="size">
                </td>
                <th>重量(单位：g)：</th>
                <td id="weight">
                </td>
            </tr>
            <tr>
                <th>材质：</th>
                <td id="material">
                </td>
                <th>主体材质：</th>
                <td id="mainMaterial">
                </td>
            </tr>
            <tr>
                <th>其他辅材：</th>
                <td id="otherMaterial">

                </td>
                <th>创作年代：</th>
                <td id="createYear">

                </td>
            </tr>

            <tr>
                <th>其他：</th>
                <td id="other">

                </td>
                <th>图片概况:</th>
                <td id="imgs">

                </td>
            </tr>
            <tr>
                <th>市场流通性:</th>
                <td id="marketLiquidity">

                </td>
                <th>价值稳定性:</th>
                <td id="valueStability">

                </td>
            </tr>
            <tr>
                <th>材质易损性:</th>
                <td id="materialVulnerability">

                </td>
                <th>存放条件:</th>
                <td id="storageCondition">

                </td>
            </tr>
            <tr>
                <th>肉眼可见缺陷:</th>
                <td id="nakedEyeDefect">

                </td>
                <th>金融记录:</th>
                <td id="financeLog">

                </td>
            </tr>
            <tr>
                <th>其他事项:</th>
                <td id="otherBusiness" colspan="3">

                </td>
            </tr>
            <tr id="addLog">

            </tr>
            <%--<tr id="log">
                <c:forEach items="${certificateEx.list}" var="item" >
                    <th>流通记录时间:</th>
                    <td>
                        ${item.longTime}
                    </td>
                    <th>流通记录价格:</th>
                    <td>
                        ${item.price}
                    </td>
                </c:forEach>

            </tr>--%>
        </table>
    </div>
</form>
</body>
</html>