$.ajaxSetup({type : 'POST'});
$(document).ajaxStart(function(){
	sy.openLoad();
});
$(document).ajaxStop(function(){
});
$(document).ajaxError(function(event,xhr,settings){
	sy.closeLoad();
	switch (xhr.status) {
		case 404:
			sy.msg("该请求不存在，请联系管理员！");
			break;
		case 500:
			if(xhr.responseText=="sessionOut"){
		    	location.href = sy.path + "/m/login";
		    }else{
		    	var msg = "操作异常，请联系管理员！";
		    	try {
		    		msg = $.parseJSON(xhr.responseText).error;
				} catch (e) {
				}
				sy.msg(msg);
		    }
			break;
		default:
			sy.msg(xhr.status+" 未知错误，请联系管理员！");
			break;
	}
});