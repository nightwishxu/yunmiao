	var mainMenu;
	var mainTabs;

	function addNav(data) {
		$.each(data, function(i, sm) {
			var menulist = "";
			menulist += '<ul>';
			$.each(sm.menus, function(j, o) {
				menulist += '<li><a ref="' + o.menuid + '" href="javascript:void(0)" rel="'
						+ o.url + '" ><i class="fa ' + o.icon + '" style="display: inline-block;width: 18px;"></i><span class="nav" style="margin-left: 5px;">' + o.menuname
						+ '</span></a></li> ';
			});
			menulist += '</ul>';

			$('#mainMenu').accordion('add', {
				title : sm.menuname,
				content : menulist,
				iconCls : sm.icon,
				selected: i==0?true:false
			});
		});

		/*var pp = $('#mainMenu').accordion('panels');
		var t = pp[0].panel('options').title;
		$('#mainMenu').accordion('select', t);*/

	}
	
	function Clearnav() {
		var pp = $('#mainMenu').accordion('panels');

		$.each(pp, function(i, n) {
			if (n) {
				var t = n.panel('options').title;
				$('#mainMenu').accordion('remove', t);
			}
		});

		pp = $('#mainMenu').accordion('getSelected');
		if (pp) {
			var title = pp.panel('options').title;
			$('#mainMenu').accordion('remove', title);
		}
	}

	// 初始化左侧
	function InitLeftMenu() {
		$(document).on('click','#mainMenu li', function() {
			var a = $(this).children('a');
			var tabTitle = a.children('.nav').text();
			var url = a.attr("rel");
			var menuid = a.attr("ref");
			var icon = getIcon(menuid, icon);
			addTab(tabTitle, url, icon);
			$('#mainMenu li').removeClass("super-accordion-selected");
			$(this).addClass("super-accordion-selected");
		});
	}

	// 获取左侧导航的图标
	function getIcon(menuid) {
		var icon = '';
		$.each(_menus, function(i, n) {
			$.each(n.menus, function(k, m){
				if (m.menuid == menuid) {
					icon += m.icon;
					return false;
				}
			});
		});
		return icon;
	}
	
	function addTab(subtitle, url, icon) {
		if (!$('#mainTabs').tabs('exists', subtitle)) {
			var opts = {
				title : subtitle,
				closable : true,
				iconCls : icon,
				content : sy.formatString('<div class="easyui-panel" data-options="fit:true,border:false" style="padding:0px; background:#fff;"><iframe src="'+sy.basePath+'{0}"  allowTransparency="true" style="border:0;width:100%;height:99.5%;" frameBorder="0"></iframe></div>', url),
				border : false,
				fit : true
			};
			$('#mainTabs').tabs('add', opts);
		} else {
			$('#mainTabs').tabs('select', subtitle);
		}
	}
	
	$(function() {
		//初始化左侧
		$("#mainMenu").accordion({
			animate : true
		});
	
		addNav(_menus);
		InitLeftMenu();
		
		//修改密码
		$('#passwordDialog').show().dialog({
			modal : true,
			closable : true,
			iconCls : 'ext-icon-lock_edit',
			buttons : [ {
				text : '修改',
				handler : function() {
					if ($('#passwordDialog form').form('validate')) {
						$.post(sy.contextPath + '/manager/changePwd', {
							'oldpwd' : $('#oldpwd').val(),
							'newpwd' : $('#newpwd').val()
						}, function(result) {
							if (result.code == 0) {
								$.messager.i('密码修改成功！');
								$('.form').form("reset");
								$('#passwordDialog').dialog('close');
							}else{
								$.messager.w('密码错误！');
							}
						}, 'json');
					}
				}
			} ],
			onOpen : function() {
				$('#passwordDialog form :input').val('');
			}
		}).dialog('close');
		
		//tab页菜单
		mainTabs = $('#mainTabs').tabs({
			fit : true,
			border : false,
			tools : [ {
				iconCls : 'fa fa-refresh',
				handler : function() {
					var panel = mainTabs.tabs('getSelected').panel('panel');
					var frame = panel.find('iframe');
					try {
						if (frame.length > 0) {
							for (var i = 0; i < frame.length; i++) {
								frame[i].contentWindow.document.write('');
								frame[i].contentWindow.close();
								frame[i].src = frame[i].src;
							}
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
			}, {
				iconCls : 'fa fa-remove',
				handler : function() {
					var index = mainTabs.tabs('getTabIndex', mainTabs.tabs('getSelected'));
					var tab = mainTabs.tabs('getTab', index);
					if (tab.panel('options').closable) {
						mainTabs.tabs('close', index);
					} else {
						//$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭！', 'error');
					}
				}
			} ]
		});
	});