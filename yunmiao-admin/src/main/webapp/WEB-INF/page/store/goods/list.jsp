<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var grid;
        var index;
        var type = "${type}";
        var source = "${source}"
        var addFun = function() {
            var dialog = parent.sy.modalDialog({
                title : '添加商品',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go?path=store/goods/edit&type='+type+'&source='+source,
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
                url : sy.contextPath + '/go?path=store/goods/edit&id=' + rows[0].id,
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
                url : sy.contextPath + '/goods/serviceAdminList?type='+1+'&source='+3,
                columns : [ [  {
                    width : $(this).width() * 0.08,
                    title : '类别',
                    field : 'cateCode',
                    align : 'center',
                    formatter : function(v,r,i){
                        if(v == 1){
                            return '钟表';
                        }else if(v == 2){
                            return '翡翠';
                        }else if(v == 3){
                            return '和田玉'
                        }else if(v == 4){
                            return '古董艺术';
                        }else if(v == 5){
                            return '书画';
                        }else if(v == 6){
                            return '彩色珠宝';
                        }else if(v == 7){
                            return '钻石';
                        }else if(v == 8){
                            return '更多'
                        }else if(v == 9 || v == 10 || v == 11){
                            return '古董艺术品';
                        }else if(v == 12 || v == 13 || v == 14 || v == 15){
                            return '彩色珠宝';
                        }
                    }
                },{
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
                },{
                    width : $(this).width() * 0.05,
                    title : '库存',
                    field : 'total',
                    align : 'center',
                },{
                    width : $(this).width() * 0.05,
                    title : '状态',
                    field : 'estate',
                    align : 'center',
                }, {
                    width : $(this).width() * 0.05,
                    title : '审核信息',
                    field : 'refuseInfo',
                    align : 'center',
                },{
                    width : $(this).width() * 0.05,
                    title : '排序',
                    field : 'sortOrder',
                    align : 'center',
                },{
                    width : $(this).width() * 0.05,
                    title : '操作',
                    field : 'isVerfiy',
                    align : 'center',
                    formatter : function (v,r,i) {
                        if(r.id){
                            if(v == 1){
                                return '<a href="javascript:void(0);" onclick="changeS(\''+r.id+'\',\''+v+'\');" class="button button-warning" title="审核">开始审核</a>';
                            }else if(v == 2){
                                return '<a href="javascript:void(0);" onclick="changeS(\''+r.id+'\',\''+v+'\');" class="button button-default" title="审核通过">审核通过</a>';
                            }else if(v == 3){
                                return '<a href="javascript:void(0);" onclick="changeS(\''+r.id+'\',\''+v+'\');" class="button button-warning" title="审核不通过">审核不通过</a>';
                            }
                        }
                    }
                },{
                    width : $(this).width() * 0.05,
                    title : '是否设置未推荐',
                    field : 'isSuggest',
                    align : 'center',
                    formatter : function(v,r,i){
                        if(v == 0){
                            return '<a href="javascript:void(0);" onclick="setIndex(\''+r.id+'\',1);" class="button button-warning" title="设置为首页推荐">设置为首页推荐</a>';
                        }else if(v == 1){
                            return '<a href="javascript:void(0);" onclick="setIndex(\''+r.id+'\',0);" class="button button-default" title="取消首页推荐">取消首页推荐</a>';
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
                    title: '查看商品编辑详情',
                    field: 'checkFWB',
                    align: 'center',
                    formatter : function (v,r,i){
                        if(r.id){
                            return '<a href="javascript:void(0);" onclick="checkFWB(\''+r.id+'\');" title="查看商品编辑详情">查看商品编辑详情</a>';
                        }
                    }
                }
                ] ],
            });
        });

        function changeS(id,v) {
            var url = sy.contextPath + '/goods/changeState?v='+v+'&id='+id;
            if(v==2){
                //审核不通过需要填写原因
                var dialog = parent.sy.modalDialog({
                    title : '审核不通过原因',
                    width : 600,
                    height : 150,
                    url : sy.contextPath + '/go?path=store/goods/refuse&v='+v+'&id='+id,
                    buttons : [ {
                        text : '确定',
                        handler : function() {
                            dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                        }
                    } ]
                });
            }else {
                $.post(url, function() {
                    grid.datagrid('reload');
                }, 'json');
            }
            $.post(url, function() {
                grid.datagrid('reload');
            }, 'json');
        };

        function changeO(id,v) {
            var url = sy.contextPath + '/goods/changeOnline?v='+v+'&id='+id;
            $.post(url, function() {
                grid.datagrid('reload');
            }, 'json');
        };

        function check(id) {
            var dialog = parent.sy.modalDialog({
                title : '查看详情',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=store/goods/detils&id='+id,
                buttons : [ {
                    text : '确定',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        };

        function checkFWB(id) {
            var dialog = parent.sy.modalDialog({
                title : '查看商品内容编辑',
                width : 800,
                height : 600,
                url : sy.contextPath + '/detail?type=1&id='+id
            });
        };

        function SaveData(data) {
            var url = sy.contextPath + '/serviceOrg/update';
            $.post(url, data, function() {
                grid.datagrid('reload');
            }, 'json');
        };

        function setIndex(id,isSuggest){
            var data = {id : id,
                        isSuggest : isSuggest};
            var url = sy.contextPath + '/goods/save';
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
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>