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


})(window);

