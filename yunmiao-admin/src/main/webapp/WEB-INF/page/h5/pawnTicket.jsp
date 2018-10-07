<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="/static/m/jsp/include.jsp"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="renderer" content="webkit"/>
    <!--<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=0.5,maximum-scale=1.5,user-scalable=yes"/>-->
    <meta name="format-detection" content="telephone=no"/>
    <title>当票</title>
    <meta name="description" content="云喵拍当"/>
    <meta name="keywords" content="云喵拍当"/>
    <link href="${path}/static/m/css/pawnTickets/common.css" rel="stylesheet" type="text/css">
    <link href="${path}/static/m/css/pawnTickets/base.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
    var pawnId = "${pawnId}";
    var model = avalon.define({
        $id: "pawnTicketsController",
        pawnObj:{
            pawnTicketCode:'',
            orgName:'',
            orgTel:'',
            orgAddr:'',
            businessLicense:'',
            orgSeal:'',
            pawnerName:'',
            pawnerTel:'',
            pawnerIdCard:'',
            pawnerCert:'',
            pawnerAddr:'',
            goodsName:'',
            authPriceTest:'',
            authPrice:'',
            equivalentRatio:'',
            loanMoney:'',
            userMoney:'',
            pawnMoney:'',
            loanMoneyCN:'',
            userMoneyCN:'',
            pawnMoneyCN:'',
            pawnBeginTime:'',
            pawnEndTime:'',
            rate:'',
            moneyRate:''
        },
        repawnObj:{
           orgName:'',
           orgSeal:'',
           pawnTicketCode:'',
           pawnerName:'',
           contactor:'',
           loanMoney:'',
           cost:'',
           moneyCost:'',
           loanMoneyCN:'',
           costCN:'',
           moneyCostCN:'',
           repawnBeginTime:'',
           repawnEndTime:'',
           rate:'',
           moneyRate:''
       },
        repawnObjs:[],
        getSrc:function (url) {
            return sy.basePath+'/download?id='+url;
        }

    });

    $(function() {
        if (pawnId){
            $.ajax({
                type:"post",
                data:{ pawnId:pawnId},
                async: true,
                url:sy.basePath+"m/pawn/loadTicketData",
                dataType:"json",
                success:function(data){
                    if (data){
                        model.pawnObj=data[0];
                       if(data[1]){
                            for (var i = 0;i < data[1].length;i++){
                                model.repawnObj = data[1][i];
                                model.repawnObjs.push(model.repawnObj);
                            }
                        }
                    }
                    layer.closeAll();
                }
            });
            /*$.post(sy.basePath+"m/pawn/loadTicketData", {
                pawnId:pawnId
            },function(data) {
                if (data){
                    model.pawnObj.pawnTicketCode = data[0].pawnTicketCode;

                }
            },"json");*/
        }
    });

</script>
<body  ms-controller="pawnTicketsController">
<div class="wrap">
    <h1><img src="${path}/static/m/images/pawnTickets/title_01.png"></h1>
    <p class="p-no" ><big>NO.</big>{{@pawnObj.pawnTicketCode}}</p>
    <table class="table_inv">
        <tr>
            <th rowspan="2">典当行</th><th>名称</th><td colspan="3">{{@pawnObj.orgName}}</td><th>电话</th><td colspan="2">{{@pawnObj.orgTel}}</td>
        </tr>
        <tr>
            <th>地址</th><td colspan="3">{{@pawnObj.orgAddr}}</td><th>经营许可证编码</th><td colspan="2">{{@pawnObj.businessLicense}}</td>
        </tr>
        <tr>
            <th rowspan="3">当户</th><th>名称</th><td colspan="3" >{{@pawnObj.pawnerName}}</td><th>电话</th><td colspan="2">{{@pawnObj.pawnerTel}}</td>
        </tr>
        <tr>
            <th>地址</th><td colspan="3">{{@pawnObj.pawnerAddr}}</td><th>联系人</th><td colspan="2">{{@pawnObj.pawnerName}}</td>
        </tr>
        <tr>
            <th>证件名称</th><td colspan="3">{{@pawnObj.pawnerCert}}</td><th>证件号码</th><td colspan="2">{{@pawnObj.pawnerIdCard}}</td>
        </tr>
        <tr>
            <th rowspan="2">序号</th><th rowspan="2">当物名称</th><th rowspan="2">规格和状况</th><th rowspan="2">数量</th><th rowspan="2">估价</th><th rowspan="2">折当率<br>%</th><th colspan="2">典当金额</th>
        </tr>
        <tr>
            <td colspan="2" title="典当金额"></td>
        </tr>
        <tr>
            <td title="序号">1</td><td title="当物名称">{{@pawnObj.goodsName}}</td><td title="规格和状况"></td><td title="数量">1</td><td title="估价">{{@pawnObj.authPriceTest}}元</td><td title="折当率">{{@pawnObj.equivalentRatio}}</td><td colspan="2" title="典当金额">{{@pawnObj.loanMoney}} 元</td>
        </tr>
        <%--<tr>
            <td title="序号">2</td><td title="当物名称"></td><td title="规格和状况"></td><td title="数量"></td><td title="估价"></td><td title="折当率"></td><td colspan="2" title="典当金额"></td>
        </tr>
        <tr>
            <td title="序号">3</td><td title="当物名称"></td><td title="规格和状况"></td><td title="数量"></td><td title="估价"></td><td title="折当率"></td><td colspan="2" title="典当金额"></td>
        </tr>--%>
        <tr>
            <td colspan="3"><big>典当金额（大写）</big>{{@pawnObj.loanMoneyCN}}</td><th colspan="3"><big>合计</big></th><td colspan="2">{{@pawnObj.loanMoney}} 元</td>
        </tr>
        <tr>
            <td colspan="3"><big>综合费用（大写）</big>{{@pawnObj.pawnMoneyCN}}</td><td colspan="3"><big>小写金额¥ </big>{{@pawnObj.pawnMoney}} 元</td><td><big>月费率</big>{{@pawnObj.rate}}<big>%</big></td><td><big>月利率</big>{{@pawnObj.moneyRate}}<big>%</big></td>
        </tr>
        <tr>
            <td colspan="3"><big>实付金额（大写）</big>{{@pawnObj.userMoneyCN}}</td><td colspan="3"><big>小写金额¥ </big>{{@pawnObj.userMoney}} 元</td><th rowspan="3" style="vertical-align: top;position: relative;">当户签章<img class="dh_img" src=""></th><th rowspan="3" style="vertical-align: top;position:relative;">典当行签章<img class="ddh_img"  ms-attr="{src:@getSrc(@pawnObj.orgSeal)}"/></th>
        </tr>
        <tr>
            <td colspan="6"><big>典当期限：由&nbsp;</big>{{@pawnObj.pawnBeginTime}}<big>&nbsp;起&nbsp;&nbsp;至&nbsp;</big>{{@pawnObj.beginPawnEndTime}}<big>&nbsp;止</big></td>
        </tr>
        <tr>
            <td colspan="5" style="vertical-align: top;"><big>备注：</big></td><td><big>除当票外<br>双方<br>其他约定</big></td>
        </tr>
        <tr>
            <td colspan="2"><big>复核：</big></td><td><big>经办：</big></td><td colspan="2"><big>保管：</big></td><td><big>制单时间：</big></td><td colspan="2">{{@pawnObj.pawnBeginTime}}</td>
        </tr>
    </table>

    <div ms-for="el in @repawnObjs">
    <h1><img src="${path}/static/m/images/pawnTickets/title_02.png"></h1>
    <table class="table_inv table_xdinv" >
        <tr>
            <th colspan="2">典当行名称</th><td>{{el.orgName}}</td><th>原当票号</th><td>{{el.pawnTicketCode}}</td>
        </tr>
        <tr>
            <th colspan="2">当户名称</th><td>{{el.pawnerName}}</td><th>联系人</th><td>{{el.contactor}}</td>
        </tr>
        <tr>
            <td colspan="3"><big>原典当金额（大写）</big> {{el.loanMoneyCN}} </td><td colspan="2"><big>小写金额¥ </big> {{el.loanMoney}} </td>
        </tr>
        <tr>
            <td colspan="3"><big>续当综合费用（大写）</big> {{el.costCN}} </td><td colspan="2"><big>小写金额¥ </big> {{el.cost}} </td>
        </tr>
        <tr>
            <td colspan="3"><big>当户应付上期利息（大写）</big> {{el.moneyCostCN}} </td><td colspan="2"><big>小写金额¥ </big> {{el.moneyCost}} </td>
        </tr>
        <tr>
            <td colspan="3"><big>当户总计交付金额（大写）</big></td><td colspan="2"><big>小写金额¥ </big> {{el.repawnTotal}} </td>
        </tr>
        <tr>
            <td colspan="5"><big>续当期限：由</big>  {{el.repawnBeginTime}}   <big>起至</big> {{el.repawnEndTime}} <big>止</big></td>
        </tr>
        <tr>
            <td><big>月费率</big> {{el.rate}}  <big> %</big></td><th colspan="2" rowspan="2" style="position: relative;">当户签章<img class="dh_img" src="" ></th><th colspan="2" rowspan="2" style="position: relative;">典当行签章<img class="ddh_img" src="" ms-attr="{src:@getSrc(el.orgSeal)}"></th>
        </tr>
        <tr>
            <td><big>月利率</big>  {{el.moneyRate}}  <big>%</big></td>
        </tr>
        <tr>
            <td ><big>复核：</big></td><td><big>经办：</big></td><td><big>保管：</big></td><td><big>制单时间：</big></td><td><big> </big>  {{el.repawnBeginTime}} </td>
        </tr>
    </table>

    </div>
</div>

</body>

</html>