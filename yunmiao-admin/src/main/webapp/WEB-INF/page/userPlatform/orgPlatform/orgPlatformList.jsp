<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var grid;
        var index;

//        var creditsFun = function() {
//            var rows = grid.datagrid('getSelections');
//            if (rows.length != 1) {
//                parent.$.messager.w('请选择一条记录进行查看！');
//                return;
//            }
//
//            var url = sy.contextPath + '/go.do?path=serviceOrg/serviceOrgEdit&id=' + rows[0].id;
//            var dialog = parent.sy.modalDialog({
//                title : '添加机构',
//                width:sy.width-150,
//                height:sy.height-100,
//                //width : 800,
//                //	height : 620,
//                url : url
//            });
//            index = dialog.selector.substring(12);
//            console.log(dialog.selector.substring(12));
//        };

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
                url : sy.contextPath + '/userGoods/goodsByOrgList',
                columns : [ [  {
                    width : $(this).width() * 0.08,
                    title : '宝贝名称',
                    field : 'name',
                    align : 'center'
                },{
                    width : $(this).width() * 0.08,
                    title : '宝贝图片',
                    field : 'images',
                    align : 'center',
                    formatter : function(v,r,i){
                        return po.showImg(v,20,20);
                    }
                }, {
                    width : $(this).width() * 0.05,
                    title : '宝贝所属',
                    field : 'belongType',
                    align : 'center',
                    formatter : function (v,r,i) {
                        if(v == 0){
                            return '平台';
                        }else if(v == 1){
                            return '用户';
                        }else if(v == 2){
                            return '机构';
                        }
                    }
                }, {
                    width : $(this).width() * 0.05,
                    title : '所属机构名称',
                    field : 'orgName',
                    align : 'center',
                },{
                    width : $(this).width() * 0.05,
                    title : '快递单号',
                    field : 'platOrgExpressCode',
                    align : 'center',
                },{
                    width : $(this).width() * 0.05,
                    title : '机构申请状态',
                    field : 'platOrgState',
                    align : 'center',
                    formatter : function (v,r,i) {
                        if(v == 1){
                            return '<a href="javascript:void(0);" onclick="backGoodsToOrg(\''+r.id+'\');" class="button button-warning" title="寄给机构">寄给机构</a>';
                        }else{
                            return '机构未申请取回';
                        }
                    }
                },{
                    width: $(this).width() * 0.05,
                    title: '创建时间',
                    field: 'createTime',
                    align: 'center'
                }
                ] ],
            });
        });
        function backGoodsToOrg(id){
            var url = sy.contextPath +'/go.do?path=userPlatform/orgPlatform/backGoodsToOrg&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '回寄详情',
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
            <input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="宝贝名称"/>
            <input type="text" class="easyui-textbox" name="code" style="width: 150px" prompt="快递单号"/>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
        </div>
    </form>
    <div class="tbbutton">
        <%--<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>--%>
        <%--<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>--%>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>