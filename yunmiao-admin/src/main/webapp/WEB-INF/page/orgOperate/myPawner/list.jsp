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

        function check(id) {
            var url = sy.contextPath + '/go.do?path=orgOperate/myPawner/pawnList&id='+id;
            var dialog = parent.sy.modalDialog({
                title : '用户全部当品',
                width : 800,
                height : 620,
                url : url,
            });
        }


        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/userPawn/getMypawners',
                columns : [ [ {
                    width : $(this).width() * 0.1,
                    title : '当户名',
                    field : 'userName',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.1,
                    title : '手机号',
                    field : 'userPhone',
                    align : 'center',
                }, {
                    width : $(this).width() * 0.1,
                    title : '身份证号',
                    field : 'userIdCard',
                    align : 'center',
                }, {
                    width : $(this).width() * 0.1,
                    title : '地址',
                    field : 'userAddress',
                    align : 'center',
                },{
                    width : $(this).width() * 0.1,
                    title : ' 贷款额度',
                    field : 'totalAmountForPawner',
                    align : 'center',
                }

                    /*{
                    width : $(this).width() * 0.05,
                    title : '创建时间',
                    field : 'createTime',
                    align : 'center',
                    formatter : function (v,r,i) {
                        if(v){
                            return v.substring(0,10);
                        }

                    }
                }*/, {
                    width: $(this).width() * 0.1,
                    title: '查看该当户所有当品',
                    field: 'check',
                    align: 'center',
                    formatter : function (v,r,i){
                        return '<a href="javascript:void(0);" onclick="check(\''+r.userId+'\');" class="button button-warning" title="查看该当户所有当品">查看该当户所有当品</a>';
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
   <%-- <form id="searchForm">
        <div>
            <input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="当户名/手机号码"/>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
        </div>
    </form>--%>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>