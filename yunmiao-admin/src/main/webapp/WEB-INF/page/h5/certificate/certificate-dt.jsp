<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@ include file="/static/m/jsp/include.jsp"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="renderer" content="webkit"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=0.5,maximum-scale=1.5,user-scalable=yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>证书详情</title>
    <meta name="description" content="云喵拍当"/>
    <meta name="keywords" content="云喵拍当"/>
    <link href="${path}/static/m/css/certificate/common.css" rel="stylesheet" type="text/css">
    <link href="${path}/static/m/css/certificate/base.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="wrapper">
    <!--背景遮罩-->
    <div class="bg-black dis_none" ></div>

    <div class="c2">
        <dl class="oneblock clearfix">
            <dt>名称：</dt>
            <dd>${certificate.name}</dd>
        </dl>
        <dl class="oneblock clearfix">
            <dt>编号：</dt>
            <dd>${certificate.code}</dd>
        </dl>
        <dl class="oneblock clearfix">
            <dt>尺寸：</dt>
            <dd>${certificate.length}×${certificate.width}×${certificate.height}cm</dd>
        </dl>
        <dl class="oneblock clearfix">
            <dt>重量：</dt>
            <dd>${certificate.weight}g</dd>
        </dl>
        <dl class="oneblock clearfix">
            <dt>材质：</dt>
            <dd>${certificate.material}</dd>
        </dl>
        <dl class="oneblock clearfix">
            <dt>主体材质：</dt>
            <dd>${certificate.mainMaterial}</dd>
        </dl>
        <dl class="oneblock clearfix">
            <dt>其他辅材：</dt>
            <dd>${certificate.otherMaterial}</dd>
        </dl>
        <dl class="oneblock clearfix">
            <dt>创作年代：</dt>
            <dd>${certificate.createYear}</dd>
        </dl>
        <dl class="oneblock clearfix">
            <dt>其他：</dt>
            <dd>${certificate.other}</dd>
        </dl>
    </div>

    <!--图片概览-->
    <div class="c2">
        <dl class="twoblock">
            <dt>图片概览</dt>
            <dd>
                <c:forEach items="${certificate.imgs}" var="item" >
                    <em>
                        <img src="<c:out value="${path}/download?id=${item}"/>" onclick="showBigImg(this);"/>
                    </em>
                    <br>
                </c:forEach>
                <%--<em><img src="image/img-01.png" onclick="showBigImg(this);"> </em>
                <em><img src="image/img-02.png" onclick="showBigImg(this);"> </em>
                <em><img src="image/img-03.png" onclick="showBigImg(this);"> </em>
                <em><img src="image/img-04.png" onclick="showBigImg(this);"> </em>--%>
            </dd>
        </dl>
        <div class="Img_panel"></div>
    </div>

    <!--显示评价 *注：满分5分-->
    <div class="c2">
        <dl class="oneblock pos-r clearfix">
            <dt>市场流通性:</dt>
            <dd class="atar_Show">
                <div class=${certificate.marketLiquidity}></div>
            </dd>
        </dl>
        <dl class="oneblock pos-r clearfix">
            <dt>价值稳定性:</dt>
            <dd class="atar_Show">
                <div class=${certificate.valueStability}></div>
            </dd>
        </dl>
        <dl class="oneblock pos-r clearfix">
            <dt>材质易损性:</dt>
            <dd class="atar_Show">
                <div class=${certificate.materialVulnerability}></div>
            </dd>
        </dl>
    </div>

    <!--存放条件-->
    <div class="c2">
        <dl class="twoblock">
            <dt>存放条件：</dt>
            <dd>
                <p>${certificate.storageCondition}</p>
            </dd>
        </dl>
    </div>

    <!--肉眼可见缺陷描述-->
    <div class="c2">
        <dl class="twoblock">
            <dt>肉眼可见缺陷描述：</dt>
            <dd>
                <p>${certificate.nakedEyeDefect}</p>
            </dd>
        </dl>
    </div>

    <!--流通记录-->
    <div class="c2">
        <dl class="twoblock">
            <dt>流通记录：</dt>
            <dd>

                <c:forEach items="${certificateLog}" var="item" >
                    <div class="one">
                        <em class="dot"></em><span>日期：${item.logTime}</span>
                        <div class="clearfix"></div>
                        <p>流通价格：¥${item.price}</p>
                    </div>
                    <br>
                </c:forEach>

                <%--<div class="one">
                    <em class="dot"></em><span>日期：2010年10月2日</span>
                    <div class="clearfix"></div>
                    <p>流通价格：¥5600</p>
                </div>

                <div class="one">
                    <em class="dot"></em><span>日期：2010年10月2日</span>
                    <div class="clearfix"></div>
                    <p>流通价格：¥5600</p>
                </div>--%>

            </dd>
        </dl>
    </div>

    <!--艺术品金融记录-->
    <div class="c2">
        <dl class="twoblock">
            <dt>艺术品金融记录：</dt>
            <dd>
                <p>${certificate.financeLog}</p>
            </dd>
        </dl>
    </div>

    <!--其他事项-->
    <div class="c2">
        <dl class="twoblock">
            <dt>其他事项：</dt>
            <dd>
                <p>${certificate.otherBusiness}</p>
            </dd>
        </dl>
    </div>

</div>

</body>
<%--<script type="text/javascript" src="${path}/static/m/js/certificate/jquery-1.10.1.min.js"></script>--%>
<script type="text/javascript" src="${path}/static/m/js/certificate/common.js"></script>
<script type="text/javascript" src="${path}/static/m/js/certificate/fastclick.js"></script>
<script>
    $(function(){
        //显示分数
        $(".atar_Show div").each(function() {
            var num=$(this).attr("class");
            var starWidth=num*.43;//一个星星的宽度是43px
            $(this).css({width:starWidth+'rem'});
        });
    })
</script>

</html>