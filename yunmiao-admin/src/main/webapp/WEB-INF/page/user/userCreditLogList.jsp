<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var grid;
	var userId='${id}';

	$(function() {
		grid = $('#grid').datagrid({
			url : sy.contextPath + '/userCreditLog/listByUserId?id='+userId,
			columns : [ [{
				width : $(this).width() * 0.2,
				title : '项目',
				field : 'item',
				align : 'center',
				formatter : function(value, row, index) {
					if(value!=null&&value!="")
				     return "<span  title='"+value+"' >"+value+"</span>";
					
				}
			},{
				width : $(this).width() * 0.1,
				title : '收支变化',
				field : 'num',
				align : 'center',
				formatter : function(value, row, index) {
					if(value!=null){
						return row.type==1?"<span style='color: green;' >+"+value+"</span>":"<span style='color: red;' >-"+value+"</span>";
					}
					}
			}, 
			{
				width : $(this).width() * 0.1,
				title : '积分数量',
				field : 'total',
				align : 'center'
			},{
				width : $(this).width() * 0.3,
				title : '说明',
				field : 'info',
				align : 'center',
				formatter : function(value, row, index) {
					if(value!=null&&value!="")
				     return "<span  title='"+value+"' >"+value+"</span>";
					
				}
			}, 
			{
				width : $(this).width() * 0.2,
				title : '创建时间',
				field : 'createTime',
				align : 'center'
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
			<select id="type" prompt="类型" name="type" editable="false" style="width:150px;" panelHeight='auto' data-options="valueField: 'value',textField: 'name',data: [{name: '收入',value: '1'},{name: '支出',value: '2'}]"></select>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a> 
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
		</form>
	</div>
	<table id="grid" data-options="fit:true,border:false"></table>
</body>
</html>