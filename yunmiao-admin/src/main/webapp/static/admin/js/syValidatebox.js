//扩展easyui表单的验证
$.extend($.fn.textbox.defaults.rules, {
	//验证时间段
	periodDate : {
		validator : function(value, param) {
			return value >= $(param[0]).datebox('getValue');;
		},
		message : '请输入正确的时间段！'
	},
	//验证时间段(含时分秒)
	periodDateTime : {
		validator : function(value, param) {
			return value >= $(param[0]).datetimebox('getValue');;
		},
		message : '请输入正确的时间段！'
	},
	//验证两次密码是否一致功能 
	eqPwd : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '密码不一致！'
	},
	//验证汉字+符号
    chs_: {
        validator: function (value) {
            return /^[\u0391-\uFFE5]+$/.test(value);
        },
        message: '只能输入汉字'
    },
    //验证汉字
    chs: {
        validator: function (value) {
            return /^[\u4e00-\u9fa5]+$/.test(value);
        },
        message: '只能输入汉字'
    },
    //验证sn
    sn: {
        validator: function (value) {
            return /^[A-Za-z0-9\u4e00-\u9fa5]+$/.test(value);
        },
        message: '只能输入汉字数字字母'
    },
    //移动手机号码验证
    mobile: {
        validator: function (value) {
            var reg = /^1[3|4|5|7|8|9]\d{9}$/;
            return reg.test(value);
        },
        message: '手机号码格式不准确'
    },
  //座机+手机号码验证
    phone: {
        validator: function (value) {
        	var regexp=/^((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/;
            return regexp.test(value);
        },
        message: '请输入正确的号码格式'
    },
    //国内邮编验证
    zipcode: {
        validator: function (value) {
            var reg = /^[1-9]\d{5}$/;
            return reg.test(value);
        },
        message: '邮编必须是非0开始的6位数字'
    },
    //用户账号验证(只能包括 _ 数字 字母) 
    account: {
        validator: function (value) {
            if (!/^[\w]+$/.test(value)) {
                return false;
            } else {
                return true;
            }
        }, message: '用户名只能数字、字母、下划线组成'
    },
    //校验数据库唯一
    unique: {
        validator: function (value,url) {
        	var result = $.ajax({ 
        	    type : "post", 
        	    url : sy.contextPath + url, 
        	    data : {value : value}, 
        	    async : false,
        	    dataType:'json'
        	}).responseText;
	  	  result = eval("(" + result + ")"); 
	  	  return result.code == 0;
        }, message: '已存在'
    },
    //校验数据库存在
    exist: {
        validator: function (value,url) {
        	var result = $.ajax({ 
        	    type : "post", 
        	    url : sy.contextPath + url, 
        	    data : {value : value}, 
        	    async : false,
        	    dataType:'json'
        	}).responseText;
	  	  result = eval("(" + result + ")"); 
	  	  return result.code == 0;
        }, message: '不存在'
    },
    //校验余额是否充足
    enough: {
        validator: function (value,url) {
        	var result = $.ajax({ 
        	    type : "post", 
        	    url : sy.contextPath + url, 
        	    data : {value : value}, 
        	    async : false,
        	    dataType:'json'
        	}).responseText;
	  	  result = eval("(" + result + ")"); 
	  	  return result.code == 0;
        }, message: '余额不足'
    },
    //数字
    number: {
        validator: function (value) {
            return /^\d+$/.test(value);
        },
        message: '请输入数字'
    },
    //小数且小数点保留一到两位
    numbertwo: {
        validator: function (value) {
        	var regexp=/^[0]+(\.\d{1,2}){1,1}$/;
            return regexp.test(value);
        },
        message: '请输入正确的格式,保留两位小数'
    },
    //qq
    qq: {
    	validator: function (value) {
    		return /^[1-9]\d{4,10}$/.test(value);
    	},
    	message: 'QQ号码格式不正确'
	},
	ip:{
		validator: function (value) {
			return /^((([1-9]\d?)|(1\d{2})|(2[0-4]\d)|(25[0-5]))\.){3}(([1-9]\d?)|(1\d{2})|(2[0-4]\d)|(25[0-5]))$/.test(value);
		},
		message: 'IP地址不合法'
	}
	
});
