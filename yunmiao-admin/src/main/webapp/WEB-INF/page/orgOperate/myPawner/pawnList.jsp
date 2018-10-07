<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var grid;
        var index;
        var pawnerId = '${id}'


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

        function check(id) {
            var url = sy.contextPath + '/go.do?path=orgOperate/myPawner/pawnDetail&id='+id;
            var dialog = parent.sy.modalDialog({
                title : '用户当品详情',
                width : 800,
                height : 620,
                url : url,
            });
        }

        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/userPawn/getPawnerzPawnList?pawnerId='+pawnerId,
                columns : [ [ {
                    width : $(this).width() * 0.1,
                    title : '当品名称',
                    field : 'title',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.05,
                    title : '当号',
                    field : 'pawnTicketCode',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.05,
                    title : '鉴定价',
                    field : 'authPrice',
                    align : 'center',
                }, {
                    width : $(this).width() * 0.05,
                    title : '贷款',
                    field : 'loanMoney',
                    align : 'center',
                }, {
                    width : $(this).width() * 0.1,
                    title : '到期/逾期天数',
                    field : 'days',
                    align : 'center',
                    formatter:function (v,r,i) {
                        if(r.pawnState == 0){
                            return '到期剩余'+v+'天'
                        }else if(r.pawnState == 1){
                            return '逾期'+v+'天'
                        }else if(r.pawnState == 2){
                            return '物品已绝当'
                        }else {
                            return ''
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

    </script>
</head>
<body>
<div id="toolbar">
 <%--   <form id="searchForm">
        <div>
            <input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="昵称/手机号"/>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
        </div>
    </form>--%>

</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>