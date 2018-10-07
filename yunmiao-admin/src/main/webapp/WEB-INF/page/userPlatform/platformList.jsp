<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var grid;
        var index;
        <%--var type = "${type}";--%>
        var addFun = function() {
            var dialog = parent.sy.modalDialog({
                title : '添加用户与平台交易信息',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go?path=userPlatform/platformEdit',
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
                url : sy.contextPath + '/go?path=userPlatform/platformEdit&id=' + rows[0].id,
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

                    $.post(sy.contextPath + '/platformGoodsBuy/del', {
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
                url : sy.contextPath + '/platformGoodsBuy/list',
                columns : [ [  {
                    width : $(this).width() * 0.08,
                    title : '用户真实姓名',
                    field : 'userName',
                    align : 'center'
                },{
                    width : $(this).width() * 0.08,
                    title : '所属银行',
                    field : 'bankCardName',
                    align : 'center',
                }, {
                    width : $(this).width() * 0.05,
                    title : '银行卡',
                    field : 'bankCardNo',
                    align : 'center',
                }, {
                    width : $(this).width() * 0.05,
                    title : '用户手机号',
                    field : 'userPhone',
                    align : 'center',
                },{
                    width : $(this).width() * 0.05,
                    title : '状态',
                    field : 'state',
                    align : 'center',
                    formatter : function (v,r,i) {
                        if(r.id){
                            if(v == 1){
                                return '平台待支付';
                            }else if(v == 2){
                                return '平台已付款';
                            }
                        }
                    }
                },{
                    width: $(this).width() * 0.05,
                    title: '付款凭证',
                    field: 'ticket',
                    align: 'center',
                    formatter : function (v,r,i) {
                        if(v){
                            return po.showImg(v,20,20);
                        }else{
                            return "<a href='javascript:;' onclick='uploadTicket(\""+r.id+"\")' class='button button-red'>上传凭证</a>";
                        }
                    }
                }, {
                        width: $(this).width() * 0.05,
                        title: '查看详情',
                        field: 'check',
                        align: 'center',
                        formatter : function (v,r,i){
                            if(r.id){
                                return '<a href="javascript:void(0);" onclick="check(\''+r.id+'\');" title="点击查看详情">详情</a>';
                            }
                        }
                    }, {
                    width: $(this).width() * 0.05,
                    title: '商品详情',
                    field: 'goodsCheck',
                    align: 'center',
                    formatter : function (v,r,i){
                        if(r.id){
                            return '<a href="javascript:void(0);" onclick="goodsCheck(\''+r.goodsId+'\');" title="点击查看详情">查看商品详情</a>';
                        }
                    }
                }
                ] ],
            });
        });
        function uploadTicket(id){
            var url = sy.contextPath +'/go.do?path=userPlatform/uploadTicket&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '上传凭证',
                width : 400,
                height : 420,
                url : url,
                buttons : [ {
                    text : '确认',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        }

        function check(id) {
            var dialog = parent.sy.modalDialog({
                title : '查看详情',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=userPlatform/detils&id='+id,
            });
        };
        function goodsCheck(id) {
            var dialog = parent.sy.modalDialog({
                title : '查看商品详情',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=userPlatform/goodsDetail/goodsDetail&id='+id,
                buttons : [ {
                    text : '确定',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        };

//        function SaveData(data) {
//            var url = sy.contextPath + '/serviceOrg/update';
//            $.post(url, data, function() {
//                grid.datagrid('reload');
//            }, 'json');
//        }
    </script>
</head>
<body>
<div id="toolbar">
    <form id="searchForm">
        <div>
            <input type="text" class="easyui-textbox" name="userName" style="width: 150px" prompt="用户名"/>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
        </div>
    </form>
    <div class="tbbutton">
        <%--<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>--%>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>