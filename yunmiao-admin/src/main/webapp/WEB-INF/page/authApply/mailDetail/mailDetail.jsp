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
                $.post(sy.contextPath + '/userGoods/checkDetail.do', {
                    id : id
                }, function(result) {
                    //console.log(result);
                    if (result) {
                        $('form').form('load', result);
                        for(var a in result){
                            $('#'+a).html(result[a]);
//                            if(result.authResult == 0){
//                                $('#authResult').html("未鉴定")
//                            }else if(result.authResult == 1){
//                                $('#authResult').html("鉴定中")
//                            }else if(result.authResult == 2){
//                                $('#authResult').html("无法鉴定")
//                            }else if(result.authResult == 3){
//                                $('#authResult').html("赝品")
//                            }else if(result.authResult == 4){
//                                $('#authResult').html("真品")
//                            }
                        }

                        var html = '';
                        var htmls  = '';
                        if(result.goVideo !== null && result.goVideo !== undefined){
                        html += "<a href='javascript:;' onclick='parent.sy.showVideo(\""+result.goVideo+"\")' class='button button-blue'>播放</a>";
                        $("#dabao").append(html);
                        }else{
                            $("#dabao").append("");
                        }


                        if(result.openGoodsVideo !== null && result.openGoodsVideo !== undefined){
                         htmls += "<a href='javascript:;' onclick='parent.sy.showVideo(\""+result.openGoodsVideo+"\")' class='button button-blue'>播放</a>";
                            $("#chaixiang").append(htmls);
                        }else{
                            $("#chaixiang").append("");
                        }

                        if(result.experterInfoId != 0){
                            //邀请了专家鉴定
                            var html2 = '<th>专家姓名:</th>';
                                html2 +='<td colspan="3" style="color:red">'+result.experterName+'</td>';
                            $("#experterId").append(html2);

                            var htmls = '<th>专家意见</th>';
                                htmls += '<td colspan="3" style="color:red">'+result.experterInfo+'</td>';
                            $("#experterInfos").append(htmls);
                        }
                        if(result.expressData){
                           // console.log(result.expressData)
                            var a = JSON.parse(result.expressData)
//                            console.log(a.data[0].context)
                            $("#expressData").html(a.data[0].context)
                        }
                        if(result.expressData2){
                            // console.log(result.expressData)
                            var a = JSON.parse(result.expressData2)
//                            console.log(a.data[0].context)
                            $("#expressData2").html(a.data[0].context)
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
    <input name="id" type="hidden" />
    <input name="fid" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th>宝贝原始主人账号：</th>
                <td id="oldAccount">

                </td>
                <th>用户账号：</th>
                <td id="account">

                </td>
            </tr>
            <tr>
                <th>用户昵称：</th>
                <td id="nickName">
                </td>
                <th>宝贝名称：</th>
                <td id="name">
                </td>
            </tr>
            <%--<tr>
                <th>宝贝预估价：</th>
                <td id="authPriceTest">
                </td>
            </tr>--%>
            <tr>
                <th>邮寄打包视频：</th>
                <td id="dabao">
                </td>
                <th>拆箱视频：</th>
                <td id="chaixiang">
                </td>
            </tr>
            <%--<tr>
                &lt;%&ndash;<th>宝贝鉴定结果：</th>&ndash;%&gt;
                &lt;%&ndash;<td id="authResult">&ndash;%&gt;

                &lt;%&ndash;</td>&ndash;%&gt;
                <th>宝贝鉴定价：</th>
                <td id="authPrice">

                </td>
            </tr>--%>

            <tr>
                <th>物流单号：</th>
                <td id="postExpressCode">

                </td>
                <th>顺风保价价格：</th>
                <td id="sfProtectPrice">

                </td>
            </tr>
            <tr>
                <th>无法鉴定理由:</th>
                <td colspan="3" id="notVerifyReason">

                </td>
            </tr>
            <tr id="experterId">

            </tr>
            <tr>
                <th>用户物流数据:</th>
                <td colspan="3" id="expressData">

                </td>
            </tr>
            <tr>
                <th>平台回寄单号:</th>
                <td colspan="3" id="backExpressCode">

                </td>
            </tr>
            <tr>
                <th>平台回寄物流数据:</th>
                <td colspan="3" id="expressData2">

                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>