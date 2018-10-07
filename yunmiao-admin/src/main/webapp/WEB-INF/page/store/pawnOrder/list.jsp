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
                url : sy.contextPath + '/order/orderAdminList?goodsSource='+3,
                columns : [ [ {
                    width : $(this).width() * 0.1,
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
                    title : '宝贝所属机构端名称',
                    field : 'orgName',
                    align : 'center',
					formatter : function(v,r,i){
                        if(r.orgId == 0){
							return '宝祥典当';
						}else{
                            return v;
						}
					}
                },{
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
                }, {
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
                },
					/*{
                    width : $(this).width() * 0.1,
                    title : '操作',
                    field : 'state',
                    align : 'center',
                    formatter : function (v,r,i) {
                        if(r.id){
                            if(v != 3){
                                return '<a href="javascript:void(0);" onclick="delivery(\''+r.id+'\');" class="button button-warning" title="发货">发货</a>';
                            }else{
                                return  '<a href="javascript:void(0);" class="button button-default" title="已发货">已发货</a>';
                            }
                        }
                    }
                },*/
					{
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
                    title: '订单时间',
                    field: 'createTime',
                    align: 'center',
                    formatter : function (v,r,i){
                        return v.substring(0,10);
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

        function delivery(id) {
            var dialog = parent.sy.modalDialog({
                title : '发货详情',
                width : 500,
                height : 200,
                url : sy.contextPath + '/go.do?path=serviceOrderCenter/order/deliveryAddress&id='+id,
                buttons : [ {
                    text : '确定',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        };
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