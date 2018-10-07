/**
* 登录 js
*/
//验证码
    var waits = 60;

    function counts(target) {
        if (waits == 0) {
            target.removeAttribute('disabled');
            target.value = "获取验证码";
            waits = 60;
        } else {
            target.setAttribute('disabled', true);
            target.value = waits + " s";
            waits--;
            setTimeout(function () {
                counts(target);
            }, 1000)
        }
    }

    function getVerifyCode(obj) {
        /*var phone = $('input[name="phone"]').val();
        if (phone == '') {
            $.ShortModel("手机号不能为空");
            return false;
        }*/

        counts(obj);

    }



    /*$(document).ready(function () {
        /!**
         * 登录
         *!/
        $('.btn-link .a-regist').click(function () {
            var phone = $('input[name="phone"]').val();
            if (phone == '') {
                $.ShortModel("手机号不能为空");
                return false;
            }
            var pattern = /^1[34578]\d{9}$/;
            if (!pattern.test(phone)) {
                $.ShortModel("请填写正确的手机号");
                return false;
            }
            var code = $('input[name="code"]').val();
            if (code == '') {
                $.ShortModel("验证码不能为空");
                return false;
            }
            var code_pattern = /^[0-9]{6}$/;
            if (!code_pattern.test(code)) {
                $.ShortModel("验证码必须为6位数字");
                return false;
            }


        });
    });*/
