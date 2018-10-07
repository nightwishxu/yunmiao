var sy = sy || {};

/**
 * 更改easyui加载panel时的提示文字
 * @requires jQuery,EasyUI
 */
$.extend($.fn.panel.defaults, {
	loadingMessage : '加载中....'
});

$.extend($.fn.combobox.defaults, {
	prompt : '请选择'
});
$.extend($.fn.passwordbox.defaults, {
	prompt : '请输入密码',iconWidth:28
});
$.extend($.fn.combotree.defaults, {
	prompt : '请选择'
});
$.extend($.fn.textbox.defaults, {
	prompt : '请输入'
});

$.extend($.fn.textbox.defaults,{width:400});
$.extend($.fn.passwordbox.defaults,{width:400});
$.extend($.fn.combobox.defaults,{width:400});
$.extend($.fn.combogrid.defaults,{width:400});
$.extend($.fn.combotree.defaults,{width:400});
$.extend($.fn.combotreegrid.defaults,{width:400});
$.extend($.fn.datebox.defaults,{width:400});
$.extend($.fn.datetimebox.defaults,{width:400});
$.extend($.fn.numberbox.defaults,{width:400});

/**
 * 更改easyui加载grid时的提示文字
 * @requires jQuery,EasyUI
 */
$.extend($.fn.datagrid.defaults, {
	loadMsg : '数据加载中....',
	striped : true,
	rownumbers : true,
	singleSelect : true,
	ctrlSelect : false,
	fitColumns : true,
	pagination : true,
	toolbar : '#toolbar',
	pageSize : 20,
	pageList : [ 10, 20, 50, 100],
	idField : 'id',
	emptyMsg:'暂无数据！',
	onLoadSuccess : function(data) {
		$(this).datagrid("clearSelections");
		$('.button').linkbutton({});
	}
});

/**
 * 更改easyui加载grid时的提示文字
 * @requires jQuery,EasyUI
 */
$.extend($.fn.treegrid.defaults, {
	loadMsg : '数据加载中....',
	singleSelect : true,
	fitColumns : true,
	emptyMsg:'暂无数据！',
	rownumbers : true,
	toolbar : '#toolbar',
	pagination : false
});

/**
 * panel关闭时回收内存，主要用于layout使用iframe嵌入网页时的内存泄漏问题
 * @requires jQuery,EasyUI
 * 
 */
$.extend($.fn.panel.defaults, {
	onBeforeDestroy : function() {
		var frame = $('iframe', this);
		try {
			if (frame.length > 0) {
				for (var i = 0; i < frame.length; i++) {
					frame[i].src = '';
					frame[i].contentWindow.document.write('');
					frame[i].contentWindow.close();
				}
				frame.remove();
				if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
					try {
						CollectGarbage();
					} catch (e) {
					}
				}
			}
		} catch (e) {
		}
	}
});

/**
 * 防止panel/window/dialog组件超出浏览器边界
 * @requires jQuery,EasyUI
 */
sy.onMove = {
	onMove : function(left, top) {
		var l = left;
		var t = top;
		if (l < 1) {
			l = 1;
		}
		if (t < 1) {
			t = 1;
		}
		var width = parseInt($(this).parent().css('width')) + 14;
		var height = parseInt($(this).parent().css('height')) + 14;
		var right = l + width;
		var buttom = t + height;
		var browserWidth = $(window).width();
		var browserHeight = $(window).height();
		if (right > browserWidth) {
			l = browserWidth - width;
		}
		if (buttom > browserHeight) {
			t = browserHeight - height;
		}
		$(this).parent().css({/* 修正面板位置 */
			left : l,
			top : t
		});
	}
};
$.extend($.fn.dialog.defaults, sy.onMove);
$.extend($.fn.window.defaults, sy.onMove);
$.extend($.fn.panel.defaults, sy.onMove);

/**
 * 
 * 通用错误提示
 * 
 * 用于datagrid/treegrid/tree/combogrid/combobox/form加载数据出错时的操作
 * 
 * @requires jQuery,EasyUI
 */
sy.onLoadError = {
	onLoadError : function(XMLHttpRequest) {
		if (parent.$ && parent.$.messager) {
			parent.$.messager.progress('close');
			//parent.$.messager.alert('错误', XMLHttpRequest.responseText);
		} else {
			$.messager.progress('close');
			//$.messager.alert('错误', XMLHttpRequest.responseText);
		}
	}
};
$.extend($.fn.datagrid.defaults, sy.onLoadError);
$.extend($.fn.treegrid.defaults, sy.onLoadError);
$.extend($.fn.tree.defaults, sy.onLoadError);
$.extend($.fn.combogrid.defaults, sy.onLoadError);
$.extend($.fn.combobox.defaults, sy.onLoadError);
$.extend($.fn.form.defaults, sy.onLoadError);

/**
 * 扩展combobox在自动补全模式时，检查用户输入的字符是否存在于下拉框中，如果不存在则清空用户输入
 * 
 * @requires jQuery,EasyUI
 */
$.extend($.fn.combobox.defaults, {
	onShowPanel : function() {
		var _options = $(this).combobox('options');
		if (_options.mode == 'remote') {/* 如果是自动补全模式 */
			var _value = $(this).combobox('textbox').val();
			var _combobox = $(this);
			if (_value.length > 0) {
				$.post(_options.url, {
					q : _value
				}, function(result) {
					if (result && result.length > 0) {
						_combobox.combobox('loadData', result);
					}
				}, 'json');
			}
		}
	},
	onHidePanel : function() {
		var _options = $(this).combobox('options');
		if (_options.mode == 'remote') {/* 如果是自动补全模式 */
			var _data = $(this).combobox('getData');/* 下拉框所有选项 */
			var _value = $(this).combobox('getValue');/* 用户输入的值 */
			var _b = false;/* 标识是否在下拉列表中找到了用户输入的字符 */
			for (var i = 0; i < _data.length; i++) {
				if (_data[i][_options.valueField] == _value) {
					_b = true;
				}
			}
			if (!_b) {/* 如果在下拉列表中没找到用户输入的字符 */
				$(this).combobox('setValue', '');
			}
		}
	}
});

/**
 * 扩展combogrid在自动补全模式时，检查用户输入的字符是否存在于下拉框中，如果不存在则清空用户输入
 * 
 * @requires jQuery,EasyUI
 */
$.extend($.fn.combogrid.defaults, {
	onShowPanel : function() {
		var _options = $(this).combogrid('options');
		if (_options.mode == 'remote') {/* 如果是自动补全模式 */
			var _value = $(this).combogrid('textbox').val();
			if (_value.length > 0) {
				$(this).combogrid('grid').datagrid("load", {
					q : _value
				});
			}
		}
	},
	onHidePanel : function() {
		var _options = $(this).combogrid('options');
		if (_options.mode == 'remote') {/* 如果是自动补全模式 */
			var _data = $(this).combogrid('grid').datagrid('getData').rows;/* 下拉框所有选项 */
			var _value = $(this).combogrid('getValue');/* 用户输入的值 */
			var _b = false;/* 标识是否在下拉列表中找到了用户输入的字符 */
			for (var i = 0; i < _data.length; i++) {
				if (_data[i][_options.idField] == _value) {
					_b = true;
				}
			}
			if (!_b) {/* 如果在下拉列表中没找到用户输入的字符 */
				$(this).combogrid('setValue', '');
			}
		}
	}
});

/**
 * 扩展tree和combotree，使其支持平滑数据格式
 * @requires jQuery,EasyUI
 * 
 */
sy.loadFilter = {
	loadFilter : function(data, parent) {
		var opt = $(this).data().tree.options;
		var idField, textField, parentField;
		if (opt.parentField) {
			idField = opt.idField || 'id';
			textField = opt.textField || 'text';
			parentField = opt.parentField || 'pid';
			var i, l, treeData = [], tmpMap = [];
			for (i = 0, l = data.length; i < l; i++) {
				tmpMap[data[i][idField]] = data[i];
			}
			for (i = 0, l = data.length; i < l; i++) {
				if (tmpMap[data[i][parentField]] && data[i][idField] != data[i][parentField]) {
					if (!tmpMap[data[i][parentField]]['children'])
						tmpMap[data[i][parentField]]['children'] = [];
					data[i]['text'] = data[i][textField];
					tmpMap[data[i][parentField]]['children'].push(data[i]);
				} else {
					data[i]['text'] = data[i][textField];
					treeData.push(data[i]);
				}
			}
			return treeData;
		}
		return data;
	}
};
$.extend($.fn.combotree.defaults, sy.loadFilter);
$.extend($.fn.tree.defaults, sy.loadFilter);

/**
 * 扩展treegrid，使其支持平滑数据格式
 * @requires jQuery,EasyUI
 * 
 */
$.extend($.fn.treegrid.defaults, {
	loadFilter : function(data, parentId) {
		var opt = $(this).data().treegrid.options;
		var idField, treeField, parentField;
		if (opt.parentField) {
			idField = opt.idField || 'id';
			treeField = opt.textField || 'text';
			parentField = opt.parentField || 'pid';
			var i, l, treeData = [], tmpMap = [];
			for (i = 0, l = data.length; i < l; i++) {
				tmpMap[data[i][idField]] = data[i];
			}
			for (i = 0, l = data.length; i < l; i++) {
				if (tmpMap[data[i][parentField]] && data[i][idField] != data[i][parentField]) {
					if (!tmpMap[data[i][parentField]]['children'])
						tmpMap[data[i][parentField]]['children'] = [];
					data[i]['text'] = data[i][treeField];
					tmpMap[data[i][parentField]]['children'].push(data[i]);
				} else {
					data[i]['text'] = data[i][treeField];
					treeData.push(data[i]);
				}
			}
			return treeData;
		}
		return data;
	}
});
/** 
 * 扩展树表格级联勾选方法： 
 * @param {Object} container 
 * @param {Object} options 
 * @return {TypeName}  
 */  
$.extend($.fn.treegrid.methods,{  
    /** 
     * 级联选择 
     * @param {Object} target 
     * @param {Object} param  
     *      param包括两个参数: 
     *          id:勾选的节点ID 
     *          deepCascade:是否深度级联 
     * @return {TypeName}  
     */  
    cascadeCheck : function(target,param){  
        var opts = $.data(target[0], "treegrid").options;  
        if(opts.singleSelect)  
            return;  
        var idField = opts.idField;//这里的idField其实就是API里方法的id参数  
        var status = false;//用来标记当前节点的状态，true:勾选，false:未勾选  
        var selectNodes = $(target).treegrid('getSelections');//获取当前选中项  
        for(var i=0;i<selectNodes.length;i++){  
            if(selectNodes[i][idField]==param.id)  
                status = true;  
        }  
        //级联选择父节点  
       // selectParent(target[0],param.id,idField,status);  
        selectChildren(target[0],param.id,idField,param.deepCascade,status);  
        /** 
         * 级联选择父节点 
         * @param {Object} target 
         * @param {Object} id 节点ID 
         * @param {Object} status 节点状态，true:勾选，false:未勾选 
         * @return {TypeName}  
         */  
        function selectParent(target,id,idField,status){  
            var parent = $(target).treegrid('getParent',id);  
            if(parent){  
                var parentId = parent[idField];  
                if(status)  
                    $(target).treegrid('select',parentId);  
                else  
                    $(target).treegrid('unselect',parentId);  
                selectParent(target,parentId,idField,status);  
            }  
        }  
        /** 
         * 级联选择子节点 
         * @param {Object} target 
         * @param {Object} id 节点ID 
         * @param {Object} deepCascade 是否深度级联 
         * @param {Object} status 节点状态，true:勾选，false:未勾选 
         * @return {TypeName}  
         */  
        function selectChildren(target,id,idField,deepCascade,status){  
            //深度级联时先展开节点  
            if(!status&&deepCascade)  
                $(target).treegrid('expand',id);  
            //根据ID获取下层孩子节点  
            var children = $(target).treegrid('getChildren',id);  
            for(var i=0;i<children.length;i++){  
                var childId = children[i][idField];  
                if(status)  
                    $(target).treegrid('select',childId);  
                else  
                    $(target).treegrid('unselect',childId);  
                selectChildren(target,childId,idField,deepCascade,status);//递归选择子节点  
            }  
        }  
    }  
}); 


/**
 * 创建一个模式化的dialog
 */
sy.modalDialog = function(options) {
	if(options.width && options.height){
		options.area = [options.width+'px', options.height+'px'];
	}else if(options.width && !options.height){
		options.area = [options.width+'px'];
	}else if(!options.width && options.height){
		options.area = ['600px',options.height+'px'];
	}else if(!options.width && !options.height){
		options.area = ['600px','400px'];
	}
	
	if(options.buttons && options.buttons.length > 0){
		options.btn=[];
		for(var i = 0 ; i <  options.buttons.length ; i++){
			options.btn.push(options.buttons[i].text);
			if(i==0) {
				options.yes = options.buttons[0].handler;
			}else{
				options['btn'+(i+1)] = options.buttons[i].handler;
			}
		}
	}
	
	var opts = $.extend({
		type: 2,
		title : '&nbsp;',
		shadeClose: true,
	    shade: 0.8,
	    maxmin:false
	}, options);
	
	if (options.onClose){
		opts.end = options.onClose;
	}
	
	if (options.url) {
		opts.content = options.url;
	}
	
	opts.index = layer.open(opts);

	var obj = $("#layui-layer"+opts.index);
	obj.extend({
		dialog: function(op){ 
			if(op == 'destroy'){
				layer.close(opts.index);
			}else if(op == 'index'){
				return opts.index;
			} 
		}
	});
	return obj;
	
	
/*	//easyui dialog
 	var opts = $.extend({
		title : '&nbsp;',
		width : 640,
		height : 480,
		modal : true,
		resizable:true,
		onClose : function() {
			$(this).dialog('destroy');
		}
	}, options);
	opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
	if (options.url) {
		opts.content = '<iframe id="" src="' + options.url + '" allowTransparency="true" scrolling="auto" width="100%" height="98%" frameBorder="0" name=""></iframe>';
	}
	return $('<div/>').dialog(opts);*/
};

$.messager.alert = function(){
	if(arguments.length == 1){
		layer.msg(arguments[0],{shift: 6,icon: 8});
	}else{
		layer.msg(arguments[1],{shift: 6,icon: 8});
	}
}

$.messager.i = function(){
	if(arguments.length == 1){
		layer.msg(arguments[0],{icon: 6});
	}else{
		layer.msg(arguments[1],{icon: 6});
	}
}

$.messager.e = function(){
	if(arguments.length == 1){
		layer.msg(arguments[0],{icon: 11});
	}else{
		layer.msg(arguments[1],{icon: 11});
	}
}

$.messager.q = function(){
	if(arguments.length == 1){
		layer.msg(arguments[0],{icon: 4});
	}else{
		layer.msg(arguments[1],{icon: 4});
	}
}

$.messager.w = function(){
	if(arguments.length == 1){
		layer.msg(arguments[0], {shift: 6,icon: 8});
	}else{
		layer.msg(arguments[1], {shift: 6,icon: 8});
	}
}

$.messager.confirm = function(title,content,func){
	layer.confirm(content, {
		icon: 4, 
		title:title
	}, function(index){
		layer.close(index);
		func(true);
	}, function(){
		
	});
}

$.messager.prompt = function(muti,content,func){
	layer.prompt({
	    formType: muti?2:0,
	    title: content
	}, function(value, index, elem){
		func(value);
		layer.close(index);
	});
}

$.messager.progress = function(config){
	if(config == undefined){
		layer.closeAll('dialog');
		layer.msg("数据加载中....", {icon: 16,time:0,shade: [0.3, '#000']});
	}else if(typeof config == 'object'){
		layer.closeAll('dialog');
		layer.msg(config.text, {icon: 16,time:0,shade: [0.3, '#000']});
	}else{
		layer.closeAll('dialog');
	}
}

sy.yearmonth = function(id){
	$(id).datebox({
	    onShowPanel: function () {//显示日趋选择对象后再触发弹出月份层的事件，初始化时没有生成月份层
	        span.trigger('click'); //触发click事件弹出月份层
	        if (!tds) setTimeout(function () {//延时触发获取月份对象，因为上面的事件触发和对象生成有时间间隔
	            tds = p.find('div.calendar-menu-month-inner td');
	            tds.click(function (e) {
	                e.stopPropagation(); //禁止冒泡执行easyui给月份绑定的事件
	                var year = /\d{4}/.exec(span.html())[0]//得到年份
	                , month = parseInt($(this).attr('abbr'), 10); //月份，这里不需要+1
	                $(id).datebox('hidePanel')//隐藏日期对象
	                .datebox('setValue', year + '-' + month); //设置日期的值
	            });
	        }, 0);
	        yearIpt.unbind();//解绑年份输入框中任何事件
	    },
	    parser: function (s) {
	        if (!s) return new Date();
	        var arr = s.split('-');
	        return new Date(parseInt(arr[0], 10), parseInt(arr[1], 10) - 1, 1);
	    },
	    formatter: function (d) {
	    	var m = d.getMonth() + 1;
	    	if (m < 10) m = "0" + m;
	    	return d.getFullYear() + '-' + m;
	    }
	});
	var p = $(id).datebox('panel'), //日期选择对象
	tds = false, //日期选择对象中月份
	yearIpt = p.find('input.calendar-menu-year'),//年份输入框
	span = p.find('span.calendar-text'); //显示月份层的触发控件
}

/**
 * id:待查看复制的id
 **/
sy.getId = function(id){
	parent.sy.modalDialog({
		width : 300,
		height : 150,
		title:"",
		shadeClose: true, //开启遮罩关闭
		closeBtn: 0, //不显示关闭按钮
		maxmin:false,
		url :sy.contextPath +'/go?path=common/getid&id=' +id
	});
};

$.extend($.fn.form.methods, {
	Validate : function(jq) {//加入对文件上传控件必输项的支持
		var ret = true;
		if(this.validate(jq)){
			$.each($("input[type=hidden][id$='_hidden']"),function(i,o){
				var required = ("required" == $(o).attr('required'));
				if(required){
					var v = $(o).val();
					if(v = null || v == ''){
						var missingMessage=$(o).attr("missingMessage")||'请上传文件';
						parent.$.messager.w(missingMessage);
						ret = false;
						return false;
					}
				}
			});
		}else{
			ret = false;
		}
		return ret;
	}
});