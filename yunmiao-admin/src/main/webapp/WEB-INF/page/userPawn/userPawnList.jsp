<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var index;

	
	function resize(width,height){
		if (index){
			console.log(width);
			console.log(height);
			layer.style(index, {
				width: (width-150)+'px',
				height: (height-100)+'px',
				}); 
		}
		
	}
	
	var pwdFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.alert('请选择一条记录进行编辑！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '修改密码',
			height : 220,
			url : sy.contextPath + '/go.do?path=common/pwdEdit&type=1&id=' + rows[0].id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	}
	$(function() {
		grid = $('#grid').datagrid({
			url : sy.contextPath + '/userPawn/list',
			columns : [ [ {
				width : $(this).width() * 0.1,
				title : '用户账号',
				field : 'account',
				align : 'center'
			}, {
                width : $(this).width() * 0.05,
                title : '手机号',
                field : 'phone',
                align : 'center',
            }, {
                width : $(this).width() * 0.05,
                title : '身份证号',
                field : 'idCard',
                align : 'center',
            }, {
                width : $(this).width() * 0.05,
                title : '身份证是否绑定',
                field : 'isBind',
                align : 'center',
				formatter : function (v,r,i) {
					if(v==0){
                        return UT.addLabel('未绑定','red');
					}else if(v==1){
					    return UT.addLabel('绑定','green');
					}
                }
            }, {
				width : $(this).width() * 0.2,
				title : '创建时间',
				field : 'createTime',
				align : 'center',
				formatter : function (v,r,i) {
					return v.substr(0,10);
                }
			}, {
                width: $(this).width() * 0.05,
                title: '查看详情',
                field: 'check',
                align: 'center',
				formatter : function (v,r,i){
                    if(r.id){
                        return '<a href="javascript:void(0);" onclick="check(\''+r.id+'\');" class="button button-warning" title="点击查看详情">详情</a>';
					}
				}
            }
			] ]
		});

		$('#type').combobox({   
			onSelect: function(rec){   
				grid.datagrid('load',sy.serializeObject($('#searchForm')));
	        } 
		});
	});



	function check(id) {
		var url = sy.contextPath + '/go.do?path=user/detail&id='+id;
        var dialog = parent.sy.modalDialog({
            title : '用户详情',
            width : 800,
            height : 620,
            url : url,
        });
	}
</script>
</head>
<body>
	<div id="toolbar">
		<form id="searchForm">
		<div>
			<input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="昵称/手机号"/>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a> 
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
		</div>
		</form>
		<div class="tbbutton">
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="pwdFun();">修改密码</a>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>