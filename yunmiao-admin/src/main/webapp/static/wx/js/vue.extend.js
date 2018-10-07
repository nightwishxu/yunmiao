Vue.directive('sy-img', function (e,obj) {
	var w = $(e).attr("w");
	var h = $(e).attr("h");
	var init = $(e).attr("init-src");
	e.src = sy.getSrc(obj.value,w,h,init);
});

Vue.filter('currency', function(value){
	if(!isNaN(value))return value.toFixed(2);
	return "";
});
