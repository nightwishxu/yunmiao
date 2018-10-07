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

        var addFun = function() {
            var dialog = parent.sy.modalDialog({
                title : '添加',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=orgOperate/myBankCards/edit',
                buttons : [ {
                    text : '添加',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        };

     /*   var editFun = function() {
            var rows = grid.datagrid('getSelections');
            if (rows.length != 1) {
                parent.$.messager.alert('请选择一条记录进行编辑！');
                return;
            }
            var dialog = parent.sy.modalDialog({
                title : '修改',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go.do?path=orgOperate/user/edit&id=' + rows[0].id,
                buttons : [ {
                    text : '编辑',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        }*/

        var delFun = function() {
            var rows = grid.datagrid('getSelections');
            if (rows.length == 0) {
                parent.$.messager.w('请选择需要删除的记录！');
                return;
            }
            parent.$.messager.confirm('询问','您确定要删除此记录？', function(r) {
                if (r) {
                    var ids = [];
                    for ( var i = 0, l = rows.length; i < l; i++) {
                        var r = rows[i];
                        ids.push(r.id);
                    }
                    var id = ids.join(',');

                    $.post(sy.contextPath + '/orgBankCard/del', {
                        id : id
                    }, function() {
                        rows.length = 0;//必须，否则有bug
                        grid.datagrid('reload');
                    }, 'json');
                }
            });
        };

   /*     function changePwd(id) {
            var dialog = parent.sy.modalDialog({
                title : '修改密码',
                width : 500,
                height : 200,
                url : sy.contextPath + '/go.do?path=orgOperate/user/changePwd&id='+id,
                buttons : [ {
                    text : '确定',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        };*/

        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/orgBankCard/list',
                columns : [ [ {
                    width : $(this).width() * 0.1,
                    title : '卡号',
                    field : 'bankCardNo',
                    align : 'center'
                },{
                    width : $(this).width() * 0.05,
                    title : '所属银行',
                    field : 'bankCardName',
                    align : 'center',
                }, {
                    width : $(this).width() * 0.1,
                    title : '银行卡LOGO',
                    field : 'bankLogo',
                    align : 'center',
                    formatter : function(value, row, index) {
                        if (value != null && value != '') {
                            return po.showImg(value, 20, 20);
                        } else {
                            return null;
                        }
                    }
                },{
                    width : $(this).width() * 0.1,
                    title : '姓名',
                    field : 'bankCardUserName',
                    align : 'center'
                },{
                    width : $(this).width() * 0.1,
                    title : '预留手机号',
                    field : 'bankCardPhone',
                    align : 'center'
                },{
                    width : $(this).width() * 0.1,
                    title : '身份证号码',
                    field : 'bankCardIdCard',
                    align : 'center'
                },{
                    width : $(this).width() * 0.05,
                    title : '卡类型',
                    field : 'bankCardType',
                    align : 'center',
                    formatter : function(value, row, index) {
                        if (value == 1) {
                            return UT.addLabel("储蓄卡","blue");
                        } else if (value == 2) {
                            return UT.addLabel("信用卡","orange");
                        } else {
                            return "未知";
                        }
                    }
                }, {
                    width : $(this).width() * 0.08,
                    title : '创建时间',
                    field : 'createTime',
                    align : 'center',
                    formatter : function (v,r,i) {
                        return v.substr(0,10);
                    }
                }/*, {
                    width: $(this).width() * 0.05,
                    title: '修改',
                    field: 'changePwd',
                    align: 'center',
                    formatter : function (v,r,i){
                        if(r.id){
                            return '<a href="javascript:void(0);" onclick="changePwd(\''+r.id+'\');" class="button button-warning" title="修改密码">修改密码</a>';
                        }
                    }
                }*/
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
    <form id="searchForm">
        <%--<div>
            <input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="昵称/手机号"/>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
        </div>--%>
    </form>
    <div class="tbbutton">
    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>
     <%--   <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>--%>
       <%-- <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>--%>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>