<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp" %>
    <script type="text/javascript">
        var grid;
        var index;
        var addFun = function () {
            var dialog = parent.sy.modalDialog({
                title: '添加',
                width: 800,
                height: 600,
                url: sy.contextPath + '/go.do?path=pawnOrgs/pawnOrgEdit',
                buttons: [{
                    text: '添加',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                }]
            });
        };

        var editFun = function () {
            var rows = grid.datagrid('getSelections');
            if (rows.length != 1) {
                parent.$.messager.w('请选择一条记录进行编辑！');
                return;
            }
            var dialog = parent.sy.modalDialog({
                title: '修改',
                width: 800,
                height: 600,
                url: sy.contextPath + '/go.do?path=pawnOrgs/pawnOrgEdit&id=' + rows[0].id,
                buttons: [{
                    text: '编辑',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                }]
            });
        };

        var delFun = function () {
            var rows = grid.datagrid('getSelections');
            if (rows.length == 0) {
                parent.$.messager.w('请选择需要删除的记录！');
                return;
            }
            parent.$.messager.confirm('询问', '您确定要删除此记录？', function (r) {
                if (r) {
                    var ids = [];
                    for (var i = 0, l = rows.length; i < l; i++) {
                        var r = rows[i];
                        ids.push(r.id);
                    }
                    var id = ids.join(',');

                    $.post(sy.contextPath + '/pawnOrg/del', {
                        id: id
                    }, function () {
                        rows.length = 0;//必须，否则有bug
                        grid.datagrid('reload');
                    }, 'json');
                }
            });
        };

        var creditsFun = function () {
            var rows = grid.datagrid('getSelections');
            if (rows.length != 1) {
                parent.$.messager.w('请选择一条记录进行查看！');
                return;
            }
            var nickName = "";
            if (rows[0].nickName != null && rows[0].nickName != "") {
                nickName = rows[0].nickName;
            }
            var url = sy.contextPath + '/go.do?path=pawnOrgs/pawnOrgEdit&id=' + rows[0].id;
            var dialog = parent.sy.modalDialog({
                title: '添加机构',
                width: sy.width - 150,
                height: sy.height - 100,
                //width : 800,
                //	height : 620,
                url: url
            });
            index = dialog.selector.substring(12);
            console.log(dialog.selector.substring(12));
        };

        function resize(width, height) {
            if (index) {
                console.log(width);
                console.log(height);
                layer.style(index, {
                    width: (width - 150) + 'px',
                    height: (height - 100) + 'px',
                });
            }

        }

        var pwdFun = function () {
            var rows = grid.datagrid('getSelections');
            if (rows.length != 1) {
                parent.$.messager.alert('请选择一条记录进行编辑！');
                return;
            }
            var dialog = parent.sy.modalDialog({
                title: '修改密码',
                height: 220,
                url: sy.contextPath + '/go.do?path=common/pwdEdit&type=1&id=' + rows[0].id,
                buttons: [{
                    text: '编辑',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                }]
            });
        }
        $(function () {
            grid = $('#grid').datagrid({
                url: sy.contextPath + '/pawnOrg/list?type=1',
                columns: [[{
                    width: $(this).width() * 0.05,
                    title: '机构账号',
                    field: 'account',
                    align: 'center'
                }, {
                    width: $(this).width() * 0.08,
                    title: '机构名称',
                    field: 'name',
                    align: 'center'
                }, {
                    width: $(this).width() * 0.05,
                    title: '机构法人',
                    field: 'legalPerson',
                    align: 'center',
                }, {
                    width: $(this).width() * 0.05,
                    title: '注册资金',
                    field: 'registeredCapital',
                    align: 'center',
                }, {
                    width: $(this).width() * 0.05,
                    title: '机构地址',
                    field: 'adress',
                    align: 'center',
                }, {
                    width: $(this).width() * 0.05,
                    title: '工商许可证',
                    field: 'businessLicenseCode',
                    align: 'center',
                }, {
                    width: $(this).width() * 0.05,
                    title: '电话',
                    field: 'phone',
                    align: 'center',
                }, {
                    width: $(this).width() * 0.05,
                    title: '状态',
                    field: 'stateInfo',
                    align: 'center'
                },{
                    width : $(this).width() * 0.05,
                    title : '操作',
                    field : 'state',
                    align : 'center',
                    formatter : function (v,r,i) {
                        console.error("v="+v)
                        if(r.id){
                            if(v == 2){
                                return '<a href="javascript:void(0);" onclick="changeS(\''+r.id+'\',\''+v+'\');" class="button button-warning" title="审核中">审核</a>';
                            }else if(v == 1){
                                return '<a href="javascript:void(0);" onclick="changeS(\''+r.id+'\',\''+v+'\');" class="button button-default" title="启用">启用</a>';
                            }else if(v == 0){
                                return '<a href="javascript:void(0);" onclick="changeS(\''+r.id+'\',\''+v+'\');" class="button button-warning" title="禁用">禁用</a>';
                            }
                        }
                    }
                }, {
                        width: $(this).width() * 0.1,
                        title: '创建时间',
                        field: 'createTime',
                        align: 'center',
                        formatter: function (v, r, i) {
                            return v.substr(0, 10);
                        }
                    }, {
                        width: $(this).width() * 0.1,
                        title: '操作',
                        field: 'changePwds',
                        align: 'center',
                        formatter: function (v, r, i) {
                            if (r.id) {
                                return '<a href="javascript:void(0);" onclick="changePwds(\'' + r.id + '\');" class="button button-warning" title="修改密码">修改密码</a>';
                            }
                        }
                    }
                ]]
            });


            $('#type').combobox({
                onSelect: function (rec) {
                    grid.datagrid('load', sy.serializeObject($('#searchForm')));
                }
            });
        });

        function changePwds(id) {
            var dialog = parent.sy.modalDialog({
                title: '修改密码',
                width: 500,
                height: 200,
                url: sy.contextPath + '/go.do?path=pawnOrgs/changePwds&id=' + id,
                buttons: [{
                    text: '确定',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                }]
            });
        };


        function changeS(id,v) {
            var url = sy.contextPath + '/pawnOrg/changeState?v='+v+'&id='+id;
            $.post(url, function() {
                grid.datagrid('reload');
            }, 'json');
        };

        function SaveData(data) {
            var url = sy.contextPath + '/user/update';
            $.post(url, data, function () {
                grid.datagrid('reload');
            }, 'json');
        }
    </script>
</head>
<body>
<div id="toolbar">
    <form id="searchForm">
        <div>
            <input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="机构名称"/>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'"
               onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'"
               onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
        </div>
    </form>
    <div class="tbbutton">
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true"
           onclick="addFun();">添加</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true"
           onclick="editFun();">修改</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true"
           onclick="delFun();">删除</a>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>