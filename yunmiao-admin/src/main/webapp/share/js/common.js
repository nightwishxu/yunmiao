/**
 * 其他 js
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


//弹框
//提示文字框 调用方法:$.tipModel(提示的内容，确定之后转向地址（url或javascript:void(0);）)
$.extend({
    tipModel:function(txt,btnText,href){
        btnText = typeof(btnText) == 'undefined' ? '确定' : btnText;
        href = typeof(href) == 'undefined' ? '' : href;
        var alertFrame=$('<div class="mask_model tip_model"><div class="model_head">提示<i class="doctor_icon close_icon"></i></div>'
            +'<div class="tip_txt"><p>'+txt+'</p></div>'
            +'<div class="btn_box">'
            +'<a '+ href +' class="tip_btn">'+btnText+'</a>'
            +'</div>'
            +'</div>'
            +'<div class="mask_layer"></div>');
        $('body').append(alertFrame);
        $('.mask_layer,.tip_model').show();
        setSite();
    },

    ShortModel:function(txt){
        var alertFrame=$('<div class="mask_model tip_model" style="background-color: rgb(255,255,255);background-image: none;height: auto;">'
            +'<div class="tip_txts" style="height: 2rem;line-height: 2rem;text-align: center;color: #333333;font-size:.28rem;"><p>'+txt+'</p></div>'
            +'</div>'
            +'<div class="mask_layer Alert_l"></div>');
        $('body').append(alertFrame);
        $('.mask_layer,.tip_model').show();
        setSite();
        setTimeout(function(){
            $('.mask_layer,.tip_model').remove();
        },1500)
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
        left:modelLeft+'px',
        top:modelTop+'px'
    });

};
//确定、蒙版、x 点击之后移除提示框
$(document).on('click','.tip_btn,.mask_layer,.close_icon',function(){
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



