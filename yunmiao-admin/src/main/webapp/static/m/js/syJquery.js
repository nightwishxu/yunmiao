var sy = sy || {};
sy.data = sy.data || {};// 用于存放临时的数据或者对象

sy.serializeObject = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (this['value'] != undefined && this['value'].length > 0) {// 如果表单项的值非空，才进行序列化操作
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		}
	});
	return o;
};

sy.formatString = function(str) {
	for (var i = 0; i < arguments.length - 1; i++) {
		str = str.replace("{" + i + "}", arguments[i + 1]);
	}
	return str;
};

sy.stringToList = function(value) {
	if (value != undefined && value != '') {
		var values = [];
		var t = value.split(',');
		for (var i = 0; i < t.length; i++) {
			values.push('' + t[i]);/* 避免他将ID当成数字 */
		}
		return values;
	} else {
		return [];
	}
};

sy.jsonToString = function(o) {
	var r = [];
	if (typeof o == "string")
		return "\"" + o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
	if (typeof o == "object") {
		if (!o.sort) {
			for ( var i in o)
				r.push(i + ":" + sy.jsonToString(o[i]));
			if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {
				r.push("toString:" + o.toString.toString());
			}
			r = "{" + r.join() + "}";
		} else {
			for (var i = 0; i < o.length; i++)
				r.push(sy.jsonToString(o[i]));
			r = "[" + r.join() + "]";
		}
		return r;
	}
	return o.toString();
};
sy.stringToJson = function(obj){   
    return eval('(' + obj + ')');   
}
sy.trim = function(str) {
	return str.replace(/(^\s*)|(\s*$)/g, '');
};
sy.ltrim = function(str) {
	return str.replace(/(^\s*)/g, '');
};
sy.rtrim = function(str) {
	return str.replace(/(\s*$)/g, '');
};
sy.startWith = function(source, str) {
	var reg = new RegExp("^" + str);
	return reg.test(source);
};
sy.endWith = function(source, str) {
	var reg = new RegExp(str + "$");
	return reg.test(source);
};

//获取url中的参数
sy.getUrlParam = function(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
sy.getCookie = function(name) {
    var aCookie = document.cookie.split("; ");
    var lastMatch = null;
    for (var i = 0; i < aCookie.length; i++) {
        var aCrumb = aCookie[i].split("=");
        if (name == aCrumb[0]) {
            lastMatch = aCrumb;
        }
    }
    if (lastMatch) {
        var v = lastMatch[1];
        if (v === undefined) return v;
        return unescape(v);
    }
    return null;
}
sy.setCookie = function(name,value,days,path){   
    var name = escape(name);   
    var value = escape(value);   
    var expires = new Date();   
    expires.setTime(expires.getTime() + days*24*3600000);   
    path = path == "" ? "" : ";path=" + path;   
    _expires = (typeof hours) == "string" ? "" : ";expires=" + expires.toGMTString();   
    document.cookie = name + "=" + value + _expires + path;   
}   
sy.delCookie = function(name,path){//为了删除指定名称的cookie，可以将其过期时间设定为一个过去的时间
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var value = sy.getCookie(name);
	path = path == "" ? "" : ";path=" + path;   
	if (value != null) document.cookie = name + "=" + value + ";expires=" + exp.toGMTString() + path;
}

/**IE下解决new Date(str)
 * */	
sy.newDateAndTime = function(dateStr){
	if (!dateStr) return new Date();
	var ds = dateStr.split(" ")[0].split("-");
	var ts = dateStr.split(" ")[1].split(":");
	var r = new Date();
	r.setFullYear(ds[0],ds[1] - 1, ds[2]);
	r.setHours(ts[0], ts[1], ts[2], 0);
	return r;
};

sy.loadNum = 0;
sy.openLoad = function(){
	if(sy.loadNum == 0){
		layer.closeAll();
		layer.open({type: 2});
	}
	sy.loadNum++;
}
sy.closeLoad = function(flag){
	if(flag == 1){
		sy.loadNum = 0;
		layer.closeAll();
	}else if(sy.loadNum > 0){
		if(sy.loadNum == 1){
			layer.closeAll();
		}
		sy.loadNum--;
	}
}

sy.alert = function(msg,yes){
	layer.open({
	    content: msg,
	    btn: '确定',
	    shadeClose:false,
	    yes:function(){
	    	if(yes){
	    		yes();
	    	}
	    	layer.closeAll();
	    }
	});
}

sy.msg = function(msg){
	layer.open({
	    content: msg
	    ,skin: 'msg'
    	,anim:'up'
	    ,time: 2 //2秒后自动关闭
	  });
}

sy.confirm = function(msg,yes){
	layer.open({
	    content: msg,
	    btn: ['确认', '取消'],
	    shadeClose: false,
	    yes: function(index){
	        if(yes)yes();
	        layer.close(index);
	    }
	});
}

sy.getGeoLocation = function(callBack){
	sy.openLoad();
	if(localStorage.geoLat!=undefined && localStorage.geoLng!=undefined){
		if(callBack){
			sy.closeLoad();
			callBack();
		}
	}else{
		/*  // 判断是否支持 获取本地位置
		if (navigator.geolocation) {
			var options = {enableHighAccuracy: true}; 
			navigator.geolocation.getCurrentPosition(function(position){
				sessionStorage.geoLat = position.coords.latitude;
				sessionStorage.geoLng = position.coords.longitude;
				if(callBack){
					sy.closeLoad();
					callBack();
				}
			}, function(error){
				sessionStorage.geoLat = 39.90923;
				sessionStorage.geoLng = 116.397428;
				if(callBack){
					sy.closeLoad();
					callBack();
				}
				console.log(error);
				alert(error);
			}, options);
		} else {
			sessionStorage.geoLat = 39.90923;
			sessionStorage.geoLng = 116.397428;
			if(callBack){
				sy.closeLoad();
				callBack();
			}
	        alert("浏览器不支持定位");
		}
		return;*/
		
		var map, geolocation;
	    //加载地图，调用浏览器定位服务
	    map = new AMap.Map('');
	    map.plugin('AMap.Geolocation', function() {
			geolocation = new AMap.Geolocation({
	            enableHighAccuracy: true,//是否使用高精度定位，默认:true
	            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
	            maximumAge: 1000        //定位结果缓存0毫秒，默认：0
	        });
			map.addControl(geolocation);
			AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
			AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
			geolocation.getCurrentPosition();
			//解析定位结果
		    function onComplete(data) {
		    	localStorage.geoLat = data.position.getLat();
		    	localStorage.geoLng = data.position.getLng();
				if(callBack){
					sy.closeLoad();
					callBack();
				}
		    }
		    //解析定位错误信息
		    function onError(data) {
		    	sy.closeLoad(1);
		        var str = '定位失败!';
		        str += '[错误信息：'
		        switch (data.info) {
		            case 'PERMISSION_DENIED':
		                str += '浏览器阻止了定位操作';
		                break;
		            case 'POSITION_UNAVAILBLE':
		                str += '无法获得当前位置';
		                break;
		            case 'TIMEOUT':
		                str += '定位超时';
		                break;
		            default:
		                str += '未知错误';
		                break;
		        }
		        
		        localStorage.geoLat = 39.90923;
		        localStorage.geoLng = 116.397428;
				if(callBack){
					sy.closeLoad();
					callBack();
				}
		        
		        alert(str+"]");
		    }
	    });
	}
}

sy.getAddress = function(callback){
	sy.openLoad();
	if(localStorage.geoCity && localStorage.geoAddress){
		sy.closeLoad();
		if (callback){
     	   callback();
        }
	}else{
		var mapCity,geocoder;
		var mapCity = new AMap.Map("container", {
	        resizeEnable: true,
			zoom: 18
	    }); 
		mapCity.plugin('AMap.Geocoder', function() {
			 geocoder = new AMap.Geocoder({
		        radius: 1000,
		        extensions: "all"
			 });
			 geocoder.getAddress([localStorage.geoLng,localStorage.geoLat], function(status, result) {
				sy.closeLoad();
		        if (status === 'complete' && result.info === 'OK') {
		           var city = result.regeocode.addressComponent.city||result.regeocode.addressComponent.province; //返回地址描述
		           if(city.substring(city.length,city.length-1) == "市"){
		        	   city = city.substring(0,city.length-1);
				   }
		           localStorage.geoCity = city;
		           localStorage.geoAddress = result.regeocode.formattedAddress;
		           if (callback){
		        	   callback();
		           }
		        }
		    });    
		});
	}
}

sy.isWeixin = function(){
    var ua = navigator.userAgent.toLowerCase();
    if(ua.match(/MicroMessenger/i)=="micromessenger") {
        return true;
    } else {
        return false;
    }
}
sy.isIphone = function(){
    var sUserAgent = navigator.userAgent.toLowerCase();
	return sUserAgent.match(/iphone/i) == "iphone";
}

sy.isAndroid = function(){
	var sUserAgent = navigator.userAgent.toLowerCase();
	return sUserAgent.match(/android/i) == "android" || sUserAgent.match(/Linux/i) == "Linux";
}
sy.isPhone = function (value) {
	var regexp=/^1[3|4|5|7|8|9]\d{9}$/;
    return regexp.test(value);
}

sy.post = function(url,params,callback){
	$.post(sy.path + url, params,function(ret){
		sy.closeLoad();
		callback(ret);
	}, 'json');
}

sy.getSrc = function(id,w,h,initSrc){
	if(id){
		var url = sy.path + "/download?id="+id;
		if(w)url = url + "&w="+w;
		if(h)url = url + "&h="+h;
		return url;
	}else{
		if(initSrc)return initSrc;
		else return "";
	}
}


