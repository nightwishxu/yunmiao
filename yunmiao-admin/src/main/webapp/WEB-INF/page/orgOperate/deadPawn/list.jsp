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
            var url = sy.contextPath + '/go.do?path=orgOperate/deadPawn/deadPawnDetail&id='+id;
            var dialog = parent.sy.modalDialog({
                title : '绝当详情',
                width : 800,
                height : 620,
                url : url,
            });
        }

        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/userPawn/getDeadPawnList',
                columns : [ [ {
                    width : $(this).width() * 0.1,
                    title : '当品名称',
                    field : 'goodsName1',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.1,
                    title : '图片',
                    field : 'images',
                    align : 'center',
                    formatter : function(value, row, index) {
                        if (value != null && value != '') {
                            var imgs = value.split(",");
                            return po.showImg(imgs[0], 20, 20);
                        } else {
                            return null;
                        }
                    }
                },  {
                    width : $(this).width() * 0.05,
                    title : '当号',
                    field : 'pawnTicketCode',
                    align : 'center',
                }, {
                    width : $(this).width() * 0.1,
                    title : '鉴定价',
                    field : 'authPrice',
                    align : 'center',
                },  {
                    width : $(this).width() * 0.08,
                    title : '已发放当金',
                    field : 'userMoney',
                    align : 'center',
                    formatter : function (v,r,i) {
                        if (r.beginMoney != null && r.beginMoney != '' && r.pawnMoney != null && r.pawnMoney != '') {
                            return r.beginMoney - r.pawnMoney
                        }else{
                            return ''; //v.substr(0,10);
                        }

                    }
                },  {
                    width: $(this).width() * 0.05,
                    title: '查看绝当详情',
                    field: 'check',
                    align: 'center',
                    formatter : function (v,r,i){
                        if(r.id){
                            return '<a href="javascript:void(0);" onclick="check(\''+r.id+'\');" class="button button-warning" title="查看绝当详情">查看绝当详情</a>';
                        }
                    }
                }
                ] ]
            });
            /*
             $('#type').combobox({
             onSelect: function(rec){
             grid.datagrid('load',sy.serializeObject($('#searchForm')));
             }
             });*/
        });

    </script>
</head>
<body>
<div id="toolbar">
    <%-- <form id="searchForm">
         <div>
             <input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="昵称/手机号"/>
             <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
             <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
         </div>
     </form>
     <div class="tbbutton">
         <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
         <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
         <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>
     </div>--%>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>