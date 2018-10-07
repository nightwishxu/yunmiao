<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var index;
    var addFun = function() {
        var dialog = parent.sy.modalDialog({
            title : '添加',
            width : 800,
            height : 600,
            url : sy.contextPath + '/go.do?path=pawnOrgs/pawnOrgEdit',
            buttons : [ {
                text : '添加',
                handler : function() {
                    dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                }
            } ]
        });
    };

	var creditsFun = function() {
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
	
	var pwdFun = function() {
		var rows = grid.datagrid('getSelections');
		if (rows.length != 1) {
			parent.$.messager.alert('请选择一条记录进行编辑！');
			return;
		}
		var dialog = parent.sy.modalDialog({
			title : '修改密码',
			height : 220,
			url : sy.contextPath + '/go.do?path=common/pwdEdit&type=1&id=' + rows[0].id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	}
	$(function() {
		grid = $('#grid').datagrid({
			url : sy.contextPath + '/userPawn/pawnRecord',
			columns : [ [ {
				width : $(this).width() * 0.05,
				title : '藏品名称',
				field : 'goodsName1',
				align : 'center'
			}, {
				width : $(this).width() * 0.08,
				title : '鉴定结果',
				field : 'authResult',
				align : 'center',
				formatter : function(v, r, i){
					if(v == 0){
					    return '未鉴定';
					}else if(v == 1){
					    return '鉴定中';
					}else if(v == 2){
					    return '无法鉴定';
					}else if(v == 3){
					    return '赝品';
					}else if(v == 4){
					    return '真品';
					}else{
					    return null;
					}
				}
			}, {
				width : $(this).width() * 0.05,
				title : '鉴定价格',
				field : 'authPrice',
				align : 'center',
			}, {
				width : $(this).width() * 0.05,
				title : '宝贝图片',
				field : 'images',
				align : 'center',
				formatter : function (v) {
                    return po.showImg(v,20,20)
                }
			}, {
                width : $(this).width() * 0.05,
                title : '典当状态',
                field : 'state',
                align : 'center',
				formatter : function(v,r,i){
                    if(v == -1){
                        return '典当已取消';
					}else if(v == 1){
                        return '竞拍中';
					}else if(v == 2){
					    return '已典当';
					}else if(v == 3){
					    return '赎当';
					}else if(v == 4){
					    return '绝当';
					}else if(v == 5){
					    return '宝祥兜底';
					}else{
					    return null;
					}
				}
            }, {
                width : $(this).width() * 0.05,
                title : '典当记录',
                field : 'pawnRecordList',
                align : 'center',
                formatter : function(v,r,i){
                    return '<a href="javascript:void(0);" onclick="searchPawnLog(\''+r.goodsId+'\');" class="button button-warning" title="查看典当记录">查看典当记录</a>';
                }
            }, {
                width : $(this).width() * 0.05,
                title : '典当开始时间',
                field : 'pawnBeginTime',
                align : 'center',
				formatter : function(v,r,i){
                    if(r.state != 1 && r.state != -1){
                        if(v){
                            return v.substr(0,10);
                        }
					}

				}
            }, {
                width : $(this).width() * 0.05,
                title : '当前典当到期时间',
                field : 'pawnEndTime',
                align : 'center',
                formatter : function(v,r,i){
                    if(r.state != 1 && r.state != -1){
                        if(v){
                            return v.substr(0,10);
                        }
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

		$('#orgId').combobox({
            url:sy.contextPath+"/pawnOrg/pawnMsg",
            valueField:'id',
            textField:'name',
            editable:false,
			onLoadSuccess:function (data) {
                $("#orgId").combobox('select','全部');
            }
        });


	});


    function searchPawnLog(id) {
        var dialog = parent.sy.modalDialog({
            title : '查看典当记录',
            width:sy.width-150,
            height:sy.height-100,
            url : sy.contextPath + '/go.do?path=pawnRecord/pawnRecordLog&id='+id,
        });
    };
</script>
</head>
<body>
	<div id="toolbar">
		<form id="searchForm">
		<div>
			藏品名称:<input type="text" class="easyui-textbox" name="goodsName" style="width: 150px" prompt="藏品名称"/>
			机构名称:<input type="text" class="easyui-textbox" id="orgId" name="orgId" style="width: 150px" prompt="机构名称"/>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a> 
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
		</div>
		</form>
		<div class="tbbutton">
		</div>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>