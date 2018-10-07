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

    //弹出框取消
    $('.confirm_wrap').click(function(){
        $(this).hide();
    });
    $('.confirm_box').click(function(e){
        e.stopPropagation();
    });
    $('.close_confirm').click(function(){
        $(this).parents('.confirm_wrap').hide();
    });



})(window);