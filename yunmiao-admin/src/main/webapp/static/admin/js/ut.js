var UT = UT||{};
//标点map key：中文标点unicode value：要转换成的英文标点
UT.punctMap={ff0c:',',3002:'.',2018:'\'',2019:'\'',ff1a:':',ff10:'!',ff1b:';',ff08:'\(',ff09:'\)',3010:'\[',3011:'\]',ff1f:'\?',"201c":'\"',"201d":'\"'};
//是否整数
UT.isInt=function(v,l){
	if(arguments[1]){
		var reg = eval("/^[\d]{0,"+l+"}$/");
		return  reg.test(v);
	}	
	return /^[\d]*$/.test(v);
};
//是否非零整数
UT.IntNotZero = function(v,l){
	if(arguments[1]){
		var reg = eval("/^[1-9]{1}[\d]{0,"+l+"}$/");
		return reg.test(v);
	}
	return /^[1-9]{1}[\d]*$/.test(v);
};
//截取左边n个
UT.left=function(str,n){
	 if(str.length > 0)
    {
        if(n>str.length) n = str.length;
        return str.substring(0,n);
    }else
    {
        return;
    }
}
//截取右边n个
UT.right=function(str,n){
	if(str.length > 0)
    {
        if(n>=str.length) return str;
        return str.substring(str.length-n,n);
    }else
    {
        return;
    }
}
//去空格
UT.trim=function (str){
	if (typeof str == 'string') return str.replace(/(^\s*)|(\s*$)/g, '');
}
//yyyy-MM-dd 转 yyyy/MM/dd
UT.dateToSpecial = function(str){
	if(arguments[0] != 'undefined'){
		return str.replace(/-/g,   "/");
	}else{
		return str;
	}
}
//string 转date类型 格式不正确返回undeined yyyy-MM-dd (hh:mm:ss) 时分秒可选 
UT.strToDate= function (str) { 
	var t = str.split(" ");
	var ds = t[0].split("-");
	var r = new Date();
	if(ds.length!=3)
		return;
	r.setFullYear(ds[0],ds[1] - 1, ds[2]);
	if(t.length>1){
		var ts = t[1].split(":");
		if(ts.length==1){
			r.setHours(ts[0], 0, 0, 0);
		}else if(ts.length==2){
			r.setHours(ts[0], ts[1], 0, 0);
		}else{
			r.setHours(ts[0], ts[1], ts[2], 0);
		}
	}else{
		r.setHours(0, 0, 0, 0);
	}
	return r;
}
//不包含标点
UT.isChinese=function(str){
	return /^([\u4E00-\u9FA5]+?)+$/.test(str);
}
//存在中文
UT.haveChinese=function(str){
	return /^([\u4E00-\u9FA5]+?)+$/i.test(str);
}
//替换中文逗号
UT.replaceComma = function(str){
	var reg = new RegExp(/[\，]/g);
	str = str.replace(reg,function(v,i,s){
		var hex = v.charCodeAt(0).toString(16);
		return UT.punctMap[hex];
	});
	return str;
}
//替换中文标点为英文标点
UT.replacePunct = function(str){
	var reg = new RegExp(/[\，|\。|\：|\‘|\’|\！|\；|\（|\）|\【|\】|\？]/g);
	str = str.replace(reg,function(v,i,s){
		var hex = v.charCodeAt(0).toString(16);
		return UT.punctMap[hex];
	});
	return str;
}

//增加一个v_editor 属性 用于赋值
UT.loadForm = function(id,result){
	if($('#'+id).get(0).tagName!='FORM'){
		return -1;
	}
	$('#'+id).form('load', result);
	for(var k in result){
		$('#'+id).find('[v_editor='+k+']').each(function(i,o){
			this.options.editor.html(result[k]);
		});
	}
}

//去除中文及中文标点其中  ^\x00-\x80(注意有个非) 是全角字符的范围，而\uFE30-\uFFA0是全角字符中的一些字母数字等
UT.removeChinese = function (str){
	return str.replace(/([\u4E00-\u9FA5]|[\x00-\x80\uFE30-\uFFA0])+/g,'');
}
UT.isPhone = function (value) {
	var regexp=/^1[3|4|5|7|8|9]\d{9}$/;
    return regexp.test(value);
}
//为str 添加颜色
UT.addSpanColor = function(str,color){
	return UT.addLabel(str,color);
}
UT.addLabel = function(str,color){
	if( typeof str !='undefined'){
		return "<span class='newlabel color-"+color+"'>"+str+"<span>";
	}else{
		return "";
	}
}
//为str 添加title
UT.addTitle = function(str){
	if( typeof str !='undefined'){
		return "<span title='"+str+"'>"+str+"<span>";
	}else{
		return "";
	}
}