<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2018/2/3
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var grid;
        var index;
        var goodsSource = 2;//1平台2机构3服务商
 //     var goodsSource = "${goodsSource}";

/*        var addFun = function() {
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
        };*/

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
                url : sy.contextPath + '/order/orgOrderList?goodsSource='+goodsSource,
                columns : [ [ {
                    width : $(this).width() * 0.08,
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
                    field : 'estate',
                    align : 'center',
                },  {
                    width : $(this).width() * 0.05,
                    title : '快递公司',
                    field : 'shipFirm',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.05,
                    title : '快递单号',
                    field : 'shipCode',
                    align : 'center'
                },
                    {
                    width : $(this).width() * 0.02,
                    title : '收件人姓名',
                    field : 'shipUser',
                    align : 'center'
                },{
                    width : $(this).width() * 0.05,
                    title : '收件人地址',
                    field : 'shipAddress',
                    align : 'center',
                }, {
                    width : $(this).width() * 0.1,
                    title : '收件人电话',
                    field : 'shipPhone',
                    align : 'center',
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
                 },/*{
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
                },*/{
                    width: $(this).width() * 0.05,
                    title: '发货',
                    field: 'deliver',
                    align: 'center',
                    formatter : function (v,r,i){
                        if(r.shipCode){
                            return '<p>已填写发货信息</p>';
                        }else{
                            return '<a href="javascript:void(0);" onclick="deliver(\''+r.id+'\');" title="发货">发货</a>';
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
                    title: '退款',
                    field: 'refState',
                    align: 'center',
                    formatter : function(v,r,i){
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
                        width : $(this).width() * 0.05,
                        title : '支付方式',
                        field : 'payType',
                        align : 'center',
                        formatter : function (v,r,i){
                            if(v == 1){
                                return '微信';
                            }else if(v == 2){
                                return '支付宝'
                            }else{
                                return '---';
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

        function deliver(id) {
            var dialog = parent.sy.modalDialog({
                title : '发货',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=orgOperate/myDeadPawnStore/delivery&id='+id,
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
                url : sy.contextPath + '/go.do?path=orgOperate/myDeadPawnStore/orderDetail&id='+id,
            });
        };

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

        function save(data) {
            var url = sy.contextPath + '/order/save';
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
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
        </div>
    </form>
   <%-- <div class="tbbutton">
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
    </div>--%>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>