/**
 * Created by Administrator on 2017/3/9.
 */
(function (global){
    //计算页面rem单位值
    function remChange ()
    {
        var deviceWidth = document.documentElement.clientWidth;
        if(deviceWidth > 640) deviceWidth = 640;
        document.documentElement.style.fontSize = deviceWidth / 6.4 + 'px';
    }
    remChange();
    global.addEventListener('resize',remChange,false);

    //解决click延迟300s
    $(function () {
        FastClick.attach(document.body);
    });

})(window);


//预览图片
function showBigImg(target){
    var picPath = $(target).attr("src");
    var img = document.createElement("img");
    $(".Img_panel").append(img);
    var bigPic = $(".Img_panel img");
    bigPic.attr("src", picPath); //将小图的路径传给大图
    bigPic.css({
        'width': '100%',
        'z-index': '120'
    });
    BGimgshow()

    //大图点击消失
    bigPic.on("click",function(){
        bigPic.remove();
        closeBGimg()
    })

    //    背景遮罩点击弹框消失
    $(".bg-black").unbind("click").click(function () {
        bigPic.remove();
        closeBGimg()
    })
}

//关闭遮罩
function closeBGimg(){
    $(".bg-black").animate({
        opacity:0
    },300,function(){
        $(".bg-black").removeClass("dis_block");
    })
}
//显示遮罩
function BGimgshow(){
    $(".bg-black").addClass("dis_block").animate({
        opacity:1
    },300);
}
$.extend({

    ShortModel:function(txt){
        var alertFrame=$('<div class="mask_model tip_model Alert_m" style="background-color: rgb(255,255,255);background-image: none;height: auto;">'
            +'<div class="tip_txt" style="height: 2rem;line-height: 2rem;"><p>'+txt+'</p></div>'
//            +'<div class="btn_box">'
//            +'<a class="tip_btn">'+btnText+'</a>'
//            +'</div>'
            +'</div>'
            +'<div class="mask_layer Alert_l"></div>');
        $('body').append(alertFrame);
        $('.mask_layer,.tip_model').show();
        setSite();
        setTimeout(function(){
            $('.Alert_l,.Alert_m').remove();
        },2000)
    }

});
//弹出层居中
function setSite(){
    var model=$('.mask_model'),
        screenWidth=$(window).width(),
        screenHeight=$(window).height(),
        modelLeft=(screenWidth-model.width())/ 2,
        modelTop=(screenHeight-model.height())/2;
    model.css({
        left:modelLeft+'px'
//        top:modelTop+'px'
    });
};
//确定、蒙版、x 点击之后移除提示框
$(document).on('click','.tip_btn',function(){
    $('.mask_layer,.tip_model').remove();
    $("body").css({
        "height":"auto",
        "overflow":"auto"
    });
});

//禁止遮罩滑动
$(document).on('touchmove','.mask_layer,.mask_model',function(e){
    e.preventDefault();
})