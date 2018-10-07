var sy = sy || {};
sy.data = sy.data || {};// 用于存放临时的数据或者对象

sy.ns = function() {
	var o = {}, d;
	for (var i = 0; i < arguments.length; i++) {
		d = arguments[i].split(".");
		o = window[d[0]] = window[d[0]] || {};
		for (var k = 0; k < d.slice(1).length; k++) {
			o = o[d[k + 1]] = o[d[k + 1]] || {};
		}
	}
	return o;
};
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
				r.push("\""+i + "\":" + sy.jsonToString(o[i]));
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
sy.stringToJSON = function(obj){   
    return eval('(' + obj + ')');   
}
sy.autoIframeHeight = function(iframe) {
	iframe.style.height = iframe.contentWindow.document.body.scrollHeight + "px";
};
sy.setIframeHeight = function(iframe, height) {
	iframe.height = height;
};
sy.reLoadIframes = function () {
    var iframes = document.getElementsByTagName("iframe");
    for (var i = 0; i < iframes.length; i++) {
        if (!iframes[i].contentWindow.document.body) {
            iframes[i].contentWindow.location.reload();
        } else {
            if (iframes[i].contentWindow.document.body.innerHTML == "") {
                iframes[i].contentWindow.location.reload();
            }
        }
    }
}
sy.cookie = function(key, value, options) {
	if (arguments.length > 1 && (value === null || typeof value !== "object")) {
		options = $.extend({}, options);
		if (value === null) {
			options.expires = -1;
		}
		if (typeof options.expires === 'number') {
			var days = options.expires, t = options.expires = new Date();
			t.setDate(t.getDate() + days);
		}
		return (document.cookie = [ encodeURIComponent(key), '=', options.raw ? String(value) : encodeURIComponent(String(value)), options.expires ? '; expires=' + options.expires.toUTCString() : '', options.path ? '; path=' + options.path : '', options.domain ? '; domain=' + options.domain : '', options.secure ? '; secure' : '' ].join(''));
	}
	options = value || {};
	var result, decode = options.raw ? function(s) {
		return s;
	} : decodeURIComponent;
	return (result = new RegExp('(?:^|; )' + encodeURIComponent(key) + '=([^;]*)').exec(document.cookie)) ? decode(result[1]) : null;
};
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
$.ajaxSetup({
	type : 'POST'
});

$(document).ajaxError(function(event,xhr,settings){
	parent.$.messager.progress('close');
	switch (xhr.status) {
		case 404:
			parent.$.messager.e("该请求不存在，请联系管理员！");
			break;
		case 500:
			if(xhr.responseText=="sessionOut"){
		    	parent.layer.msg('由于您长时间没有操作,请重新登录！',{icon: 11,skin: 'layer-ext-seaning'},function(){
					 parent.location.reload();
				 });
		    }else{
		    	var msg = "操作异常，请联系管理员！";
		    	try {
		    		msg = $.parseJSON(xhr.responseText).error;
				} catch (e) {
				}
				parent.$.messager.e(msg);
		    }
			break;
		case 100:
            parent.location.reload();
			break;
        case 0:
            break;
		default:
			parent.$.messager.e(xhr.status +"未知错误，请联系管理员！");
			break;
	}
});

$.fn.loadJson = function(jsonValue) {
    var obj = this;
    $.each(jsonValue, function(name, ival) {
        var $oinput = obj.find(":input [name=" + name + "]");
        if ($oinput.attr("type") == "radio"
                || $oinput.attr("type") == "checkbox") {
            $oinput.each(function() {
                if (Object.prototype.toString.apply(ival) == '[object Array]') {//是复选框，并且是数组         
                    for (var i = 0; i < ival.length; i++) {
                        if ($(this).val() == ival[i])
                            $(this).attr("checked", "checked");
                    }
                } else {
                    if ($(this).val() == ival)
                        $(this).attr("checked", "checked");
                }
            });
        } else if ($oinput.attr("type") == "textarea") {//多行文本框            
            obj.find("[name=" + name + "]").html(ival);
        } else {
            obj.find("[name=" + name + "]").val(ival);
        }
    });
};

if (!Array.prototype.forEach) {  
    Array.prototype.forEach = function(callback, thisArg) {  
        var T, k;  
        if (this == null) {  
            throw new TypeError(" this is null or not defined");  
        }  
        var O = Object(this);  
        var len = O.length >>> 0; // Hack to convert O.length to a UInt32  
        if ({}.toString.call(callback) != "[object Function]") {  
            throw new TypeError(callback + " is not a function");  
        }  
        if (thisArg) {  
            T = thisArg;  
        }  
        k = 0;  
        while (k < len) {  
            var kValue;  
            if (k in O) {  
                kValue = O[k];  
                callback.call(T, kValue, k, O);  
            }  
            k++;  
        }  
    };  
}  

if (!Array.prototype.remove){
	Array.prototype.remove = function(elm, count, rect){
	  count = count || -1 // 加入count参数, 默认删除全部, 若只要删除第一个, 传1, 0和负数都删除全部
	  rect = []
	  for(var i=0,l=this.length;i<l;i++){
	    if(this[i]===elm){ // 注意一定要三个等号, 不然删除0, 会发现 false, null, "" 等都会被删除
	      rect.push.apply(rect, this.splice(i,1)); i--; l--;
	      if(count>0 && rect.length>=count) return rect;
	    }
	  }
	  return rect; // 返回已删除的元素列
	};
}

sy.showImg = function(src,title){
	var json = {
	  "title": "", //相册标题
	  "id": 1, //相册id
	  "start": 0, //初始显示的图片序号，默认0
	  "data": [   //相册包含的图片，数组格式
	    {
	      "alt": title,
	      "pid": 1, //图片id
	      "src": src, //原图地址
	      "thumb": "" //缩略图地址
	    }
	  ]
	};
	layer.photos({photos: json});
};


sy.showVideo = function(id){
	var loadstr = ''+
	'<video id="my-video" class="video-js" controls preload="auto" width="600" height="500">'+
	'<source src="'+(sy.contextPath+'/download?id='+id)+'" type="video/mp4">'+
	 ' </video>';
	layer.open({
		  type:1,
		  title: false,
		  shadeClose: true,
		  shade: 0.8,
		  area: ['600px', '500px'],
		  closeBtn: 1,
		  content: loadstr,
		  success:function(){
			  var myPlayer = videojs("my-video");
				  myPlayer.ready(function(){
	      		  		this.play();
	      		  	});
			 
		  },
		  cancel:function(index, layero){
			  var myPlayer = videojs("my-video");
			  myPlayer.dispose();
		  },
		  end:function(){
			  var video = $('#my-video');
			  if (video){
				  var myPlayer = videojs("my-video");
				  myPlayer.dispose();
			  }
		  }
		});
}
