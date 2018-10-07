<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var grid;
        var index;
        var type = "${type}";
        $(function() {
            $("#type").val(type);
        });
        var addFun = function() {
            var dialog = parent.sy.modalDialog({
                title : '添加商品',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go?path=pawnOrgs/goods/edit&type='+type,
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
                url : sy.contextPath + '/go?path=pawnOrgs/goods/edit&id=' + rows[0].id,
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

                    $.post(sy.contextPath + '/goods/del', {
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
                url : sy.contextPath + '/goods/serviceList',
                columns : [ [ {
                    width : $(this).width() * 0.05,
                    title : '商品编号',
                    field : 'goodsId',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.08,
                    title : '名称',
                    field : 'name',
                    align : 'center'
                },{
                    width : $(this).width() * 0.08,
                    title : '图片',
                    field : 'img',
                    align : 'center',
                    formatter:function (v,r) {
                        return po.showImg(v,20,20);
                    }
                }, {
                    width : $(this).width() * 0.05,
                    title : '成本',
                    field : 'cost',
                    align : 'center',
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
                },{
                    width : $(this).width() * 0.05,
                    title : '商品类型',
                    field : 'type',
                    align : 'center',
                    hidden: true,
                }
                ] ],
                onBeforeLoad: function (param) {
                    param.type = type;
                }
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
                width:sy.width-150,
                height:sy.height-100,
                url : sy.contextPath + '/go.do?path=pawnOrgs/goods/detils&id='+id,
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
            <input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="商品名称"/>
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
<table id="grid" data-options="fit:true,border:false"><input name="type" type="hidden"  /></table>
</body>
</html>