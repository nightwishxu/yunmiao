<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript" src="${path}/static/admin/js/datagrid-cellediting.js"></script>
    <script type="text/javascript">
        var grid;
        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/userPawn/baoxiangGet',
                columns : [ [ {
                    width : $(this).width() * 0.15,
                    title : '当号',
                    field : 'pawnTicketCode',
                    align : 'center',
                    formatter : function(value,row,index){
                        if(value){
                            return value;
                        }else{
                            return '暂无';
                        }
                    }
                },{
                    width : $(this).width() * 0.15,
                    title : '商品名称',
                    field : 'goodsName1',
                    align : 'center'
                },{
                    width : $(this).width() * 0.15,
                    title : '操作',
                    field : 'operations',
                    align : 'center',
                    formatter : function(value,row,index){
                        return '<a href="javascript:void(0);" onclick="setGoodsCode(\''+row.id+'\');" class="button button-warning" title="填写宝祥兜底当号">填写宝祥兜底当号</a>';
                    }
                }
                ] ],
                onBeforeEdit:function (index, row) {
                    if (row.postState > 2){
                        return true;
                    }
                    return false;
                },
                onEndEdit:function (index, row, changes) {
                    if (!$.isEmptyObject(changes)){
                        changes.id = row.id;
                        save(changes);
                    }else{
                        grid.datagrid('resize');
                    }
                }
            });
            $('#type').combobox({
                onSelect: function(rec){
                    grid.datagrid('load',sy.serializeObject($('#searchForm')));
                }
            });
        });

        //设置宝贝名称
        function setGoodsCode(id){
            var url = sy.contextPath +'/go.do?path=userPawn/baoXiangGet/setBaoxiangCode&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '宝祥兜底当号',
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
    </script>
</head>
<body>
<div id="toolbar">
    <form id="searchForm">
        <div>
            <input type="text" class="easyui-textbox" name="pawnTicketCode" style="width: 150px" prompt="当号"/>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
        </div>
    </form>
    <div class="tbbutton">
    </div>
</div>
<table id="grid" data-options="fit:true,border:false">


</table>
</body>
</html>