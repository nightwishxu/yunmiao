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
			url : sy.contextPath + '/user/list',
			columns : [ [ {
                width : $(this).width() * 0.1,
                title : 'id',
                field : 'id',
                align : 'center'
            },{
				width : $(this).width() * 0.1,
				title : '账号',
				field : 'account',
				align : 'center'
			}, {
				width : $(this).width() * 0.1,
				title : '昵称',
				field : 'nickName',
				align : 'center'
			}, {
				width : $(this).width() * 0.1,
				title : '头像',
				field : 'headImg',
				align : 'center',
				formatter : function(value, row, index) {
					if (value != null && value != '') {
						return po.showImg(value, 20, 20);
					} else {
						return null;
					}
				}
			}, {
				width : $(this).width() * 0.05,
				title : '性别',
				field : 'sex',
				align : 'center',
				formatter : function(value, row, index) {
					if (value == 1) {
						return UT.addLabel("男","blue");
					} else if (value == 0) {
						return UT.addLabel("女","orange");
					} else {
						return "未知";
					}
				}
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
            },{
                width : $(this).width() * 0.1,
                title : '账号禁用',
                field : 'state',
                align : 'center',
                formatter : function (v,r,i) {
                    if(v == 1){
                        //正常--变更为禁用
                        return '<a href="javascript:void(0);" onclick="forbiddenUser(\''+0+'\',\''+r.id+'\');" class="button button-warning" title="禁用用户">禁用</a>';
					}else if(v == 0){
                        //禁用解封
                        return '<a href="javascript:void(0);" onclick="forbiddenUser(\''+1+'\',\''+r.id+'\');" class="button button-warning" title="解封用户">解封用户</a>';
					}

                }
            },{
                width : $(this).width() * 0.1,
                title : '账号状态',
                field : 'userState',
                align : 'center',
                formatter : function (v,r,i) {
                    if(r.state == 1){
                        return '正常';
                    }else if(r.state == 0){
                        //禁用解封
                        return '冻结中';
                    }

                }
            },{
				width : $(this).width() * 0.1,
				title : '创建时间',
				field : 'createTime',
				align : 'center',
				formatter : function (v,r,i) {
				    if(v){
                        return v.substring(0,10);
					}

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

    function forbiddenUser(state,id) {
	    data = {
	        id : id,
			state : state
		}
        $.post(sy.contextPath +'/user/save', data, function() {
            grid.datagrid('reload');
        }, 'json');
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