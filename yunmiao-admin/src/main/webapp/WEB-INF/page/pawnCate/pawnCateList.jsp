<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;

//    var addFun = function() {
//        var dialog = parent.sy.modalDialog({
//            title : '添加',
//            width : 800,
//            height : 600,
//            url : sy.contextPath + '/go.do?path=pawnCate/pawnCateEdit',
//            buttons : [ {
//                text : '添加',
//                handler : function() {
//                    dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
//                }
//            } ]
//        });
//    };

    var editFun = function() {
        var rows = grid.datagrid('getSelections');
        if (rows.length != 1) {
            parent.$.messager.w('请选择一条记录进行编辑！');
            return;
        }
        var dialog = parent.sy.modalDialog({
            title : '编辑信息',
            width : 800,
            height : 600,
            url : sy.contextPath + '/go.do?path=pawnCate/pawnCateEdit&id=' + rows[0].id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                }
            } ]
        });
    };

//    var delFun = function() {
//        var rows = grid.datagrid('getSelections');
//        if (rows.length == 0) {
//            parent.$.messager.w('请选择需要删除的记录！');
//            return;
//        }
//        parent.$.messager.confirm('询问', '您确定要删除此记录？', function(r) {
//            if (r) {
//                var ids = [];
//                for ( var i = 0, l = rows.length; i < l; i++) {
//                    var r = rows[i];
//                    ids.push(r.id);
//                }
//                var id = ids.join(',');
//
//                $.post(sy.contextPath + '/pawnCate/del', {
//                    id : id
//                }, function() {
//                    rows.length = 0;//必须，否则有bug
//                    grid.datagrid('reload');
//                }, 'json');
//            }
//        });
//    };


	$(function() {
		grid = $('#grid').datagrid({
			url : sy.contextPath + '/pawnCate/list',
			columns : [ [ {
                width : $(this).width() * 0.3,
                title : '编号',
                field : 'code',
                align : 'center'
            },{
				width : $(this).width() * 0.3,
				title : '鉴定名称',
				field : 'name',
				align : 'center'
			}, {
                width : $(this).width() * 0.3,
                title : '鉴定类别',
                field : 'cateType',
                align : 'center'
            }, {
				width : $(this).width() * 0.3,
				title : '图片',
				field : 'icon',
				align : 'center',
				formatter : function (value,row,index) {
				    return po.showImg(value,20,20);
				}
			}, {
				width : $(this).width() * 0.3,
				title : '排序',
				field : 'sortOrder',
				align : 'center',
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
		<form id="searchForm">
		<div>

		</div>
		</form>
		<div class="tbbutton">
			<div>
				<%--<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="addFun();">添加</a>--%>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改</a>
				<%--<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-trash',plain:true" onclick="delFun();">删除</a>--%>
			</div>
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>