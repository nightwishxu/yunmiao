<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var index;
    var goodsSource = "${goodsSource}";

    var addFun = function() {
        var dialog = parent.sy.modalDialog({
            title : '订单添加',
            width : 800,
            height : 600,
            url : sy.contextPath + '/go.do?path=store/order/edit&goodsSource='+goodsSource,
            buttons : [ {
                text : '确定',
                handler : function() {
                    dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                }
            } ]
        });
    };

    var editFun = function() {
        var rows = grid.datagrid('getSelections');
        if (rows.length != 1) {
            parent.$.messager.w('请选择一条记录进行编辑！');
            return;
        }
        var dialog = parent.sy.modalDialog({
            title : '修改',
            width : 800,
            height : 600,
            url : sy.contextPath + '/go?path=store/order/edit&id=' + rows[0].id,
            buttons : [ {
                text : '确定',
                handler : function() {
                    dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                }
            } ]
        });
    };

    var delFun = function() {
        var rows = grid.datagrid('getSelections');
        if (rows.length == 0) {
            parent.$.messager.w('请选择需要删除的记录！');
            return;
        }
        parent.$.messager.confirm('询问', '您确定要删除此记录？', function(r) {
            if (r) {
                var ids = [];
                for ( var i = 0, l = rows.length; i < l; i++) {
                    var r = rows[i];
                    ids.push(r.id);
                }
                var id = ids.join(',');

                $.post(sy.contextPath + '/order/del', {
                    id : id
                }, function() {
                    rows.length = 0;//必须，否则有bug
                    grid.datagrid('reload');
                }, 'json');
            }
        });
    };

	var creditsFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.w('请选择一条记录进行查看！');
			return;
		}

		var url = sy.contextPath + '/go.do?path=serviceOrg/serviceOrgEdit&id=' + rows[0].id;
		var dialog = parent.sy.modalDialog({
			title : '添加机构',
			width:sy.width-150,
			height:sy.height-100,
			//width : 800,
		//	height : 620,
			url : url
		});
		index = dialog.selector.substring(12);
		console.log(dialog.selector.substring(12));
	};
	
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

	$(function() {

		grid = $('#grid').datagrid({
			url : sy.contextPath + '/order/orderAdminList?goodsSource='+1,
			columns : [ [ {
				width : $(this).width() * 0.05,
				title : '订单号',
				field : 'code',
				align : 'center'
			}, {
				width : $(this).width() * 0.05,
				title : '商品名称',
				field : 'goodsName',
				align : 'center',
			}, {
                width : $(this).width() * 0.05,
                title : '订单状态',
                field : 'stateType',
                align : 'center',
				formatter : function (v,r,i) {
					if(r.state == -1){
					    return '已取消';
					}else if( r.state == 1){
					    return '待付款';
					}else if(r.state == 2){
					    return '已付款';
					}else if(r.state == 3){
					    return '已发货';
					}else if(r.state == 4){
					    return '确认收货';
					}else if(r.state == 5){
                        return '已评价';
					}else{
					    return '---'
					}
                }
            },{
                width : $(this).width() * 0.05,
                title : '支付方式',
                field : 'payType',
                align : 'center',
				formatter : function (v,r,i){
                    if(v == 2){
                        return '微信';
					}else if(v == 1){
                        return '支付宝'
					}else{
					    return '---';
					}
				}
			},{
                width : $(this).width() * 0.05,
                title : '收件人姓名',
                field : 'shipUser',
                align : 'center'
            },{
                width : $(this).width() * 0.15,
                title : '收件人地址',
                field : 'shipAddress',
                align : 'center',
            }, {
                width : $(this).width() * 0.1,
                title : '收件人电话',
                field : 'shipPhone',
                align : 'center',
            },{
                width : $(this).width() * 0.05,
                title : '发货',
                field : 'state',
                align : 'center',
                formatter : function (v,r,i) {
                    if(r.id) {
                        var html = '';
                        //无申请退款操作
						if(r.refState == 0){
                            if (v == 1 || v == 2) {
                                html += '<a href="javascript:void(0);" onclick="delivery(\'' + r.id + '\');" class="button button-warning" title="发货">发货</a>'
                            } else if(v == -1) {
                                html += '<a href="javascript:void(0);" class="button button-default" title="已取消">已取消</a>';
							} else {
                                html += '<a href="javascript:void(0);" class="button button-default" title="已发货">已发货</a>';
                            }
						}

                        return html;
                    }
              }
            },{
                width : $(this).width() * 0.05,
                title : '退款',
                field : 'refState',
                align : 'center',
				formatter : function (v,r,i) {
					var html = '';
					var reason = r.refundReason;
					if(v == 1 || v == 2){
					    //申请退款
						html += '<a class="button button-pink" href="javascript:void(0);" onclick="refusing(\''+r.id+'\');" title="'+reason+'">拒绝退款</a>';
						if(r.state == 2){
							//已付款 --未发货
							//同意退款代表已打款
                            html+= '<a class="button button-default" href="javascript:void(0);" onclick="agreeRef(\''+r.id+'\');" title="'+reason+'">同意退款</a>';
						}else{
						    //已发货 --发送回寄地址等等
							//同意退款代表未打款
							html+= '<a class="button button-warning" href="javascript:void(0);" onclick="sendBackData(\''+r.id+'\');" title="'+reason+'">同意退款</a>';
						}

					}else if(v == 3){
                        html += '<a class="button button-default" href="javascript:void(0);" onclick="refSuccess(\''+r.id+'\');" title="确认退款">确认退款</a>';
					}else if(v == 4){
                        html += '已退款';
					}else if(v == 5){
						html += '<a href="javascript:void(0);" title="'+r.refundNotVerifyReason+'">查看</a>'
					}
					return html;
                }
			},{
                width : $(this).width() * 0.1,
                title : '流水单号',
                field : 'tradNo',
                align : 'center',
                formatter : function(v,r,i){
                    if(v){
                        return v
                    }
				}
			},{
                width : $(this).width() * 0.1,
                title : '物流当前位置',
                field : 'expressData',
                align : 'center',
				formatter : function(v,r,i){
                    if(v){
                        //console.log(jQuery.parseJSON(v)[0]);
                        var arr = new Array(jQuery.parseJSON(v));
                        return arr[0].data[0].context;
					}
                    else{
                        return null;
					}
				}
			},{
                width: $(this).width() * 0.05,
                title: '回寄单号',
                field: 'backCode',
                align: 'center',
                formatter : function (v,r,i){
                    if(v){
                        return v;
                    }
                }
            },{
                width: $(this).width() * 0.05,
                title: '查看详情',
                field: 'check',
                align: 'center',
                formatter : function (v,r,i){
                    if(r.id){
                        return '<a href="javascript:void(0);" onclick="check(\''+r.id+'\');" title="点击查看详情">详情</a>';
                    }
                }
            },{
                width: $(this).width() * 0.05,
                title: '创建时间',
                field: 'createTime',
                align: 'center',
                formatter : function (v,r,i){
                    return v.substring(0,10);
                }
			}

            /*,{
			    width: $(this).width() * 0.05,
				title: '联系用户',
				field: 'conUser',
				align: 'center',
				formatter : function(v,r,i){
			        return '<a href="javascript:void(0);" onclick="conUser(\''+r.userId+'\');" title="联系用户">联系用户</a>';
				}
			}*/

			] ]
		});
		

		$('#type').combobox({   
			onSelect: function(rec){   
				grid.datagrid('load',sy.serializeObject($('#searchForm')));
	        } 
		});
	});

    function check(id) {
        var dialog = parent.sy.modalDialog({
            title : '查看详情',
            width : 800,
            height : 600,
            url : sy.contextPath + '/go.do?path=store/order/detils&id='+id,
        });
    };

	function SaveData(data) {
		var url = sy.contextPath + '/serviceOrg/update';
		$.post(url, data, function() {
			grid.datagrid('reload');
		}, 'json');
	}

    function delivery(id) {
        var dialog = parent.sy.modalDialog({
            title : '发货',
            width : 600,
            height : 400,
            url : sy.contextPath + '/go.do?path=store/order/deliveryAddress&id='+id,
            buttons : [ {
                text : '确定',
                handler : function() {
                    dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                }
            } ]
        });
    };

	function conUser(userId){
	    var dialong = parent.sy.modalDialog({
			title : '联系用户',
			width : 800,
			height : 600,
            url : sy.contextPath + '/go.do?path=store/order/conUser&id='+userId,
		});
	}

    function save(data) {
        var url = sy.contextPath + '/order/save';
        $.post(url, data, function() {
            grid.datagrid('reload');
        }, 'json');
    }

    /**
     * 同意退款
     * @param id
     */
    function agreeRef(id){
        var data = {id : id,refState : 3}
        save(data);
	}

    /**
     * 确认退款
     * @param id
     */
	function refSuccess(id){
        var data = {id : id,refState : 4}
        save(data);
	}


    /**
	 * 同意退款并发送回寄信息
     * @param id
     */
	function sendBackData(id){
        var dialog = parent.sy.modalDialog({
            title : '同意退款--并发送回寄信息',
            width : 600,
            height : 500,
            url : sy.contextPath + '/go.do?path=store/order/refund/refusing&id='+id,
            buttons : [ {
                text : '确定',
                handler : function() {
                    dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                }
            } ]
        });
	}


    /**
	 * 拒绝退款
     * @param id
     */
	function refusing(id){
        var dialog = parent.sy.modalDialog({
            title : '拒绝原因',
            width : 500,
            height : 200,
            url : sy.contextPath + '/go.do?path=store/order/refund/refund&id='+id,
            buttons : [ {
                text : '确定',
                handler : function() {
                    dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                }
            } ]
        });
	}

</script>
</head>
<body>
	<div id="toolbar">
		<form id="searchForm">
		<div>
			<input type="text" class="easyui-textbox" name="goodsName" style="width: 150px" prompt="商品名称"/>
			<input type="text" class="easyui-textbox" name="orderCode" style="width: 150px" prompt="订单号"/>
			<select id="state" class="easyui-combobox" name="state" style="width:200px;" prompt="订单状态">
				<option value="0">全部</option>
				<option value="1">待付款</option>
				<option value="2">已付款</option>
				<option value="3">已发货</option>
				<option value="4">确认收货</option>
			</select>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
		</div>
		</form>
		<div class="tbbutton">
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>