<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<style>
.uploader-hide{ position: absolute; opacity: 0; filter:Alpha(opacity=0); /* 不占据空间，可以点击 */ }
</style>
<script type="text/javascript">
	var id = "${id}";
	var editor;
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var obj=sy.serializeObject($('form'));
			var url=sy.contextPath + '/newsCate/save';
			$.post(url, obj, function(result) {
				if (result.code == 0) {
					$grid.datagrid('reload');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.e('添加失败 '+result.msg);
				}
			}, 'json');
		}
	};

	
	$(function() {
		if (id != '') {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/newsCate/findById', {
				id : id
			}, function(result) {
				if (result) {					
					$('form').form('load', result);					
				}
				parent.$.messager.progress('close');
			}, 'json');

		}
		
		
	});
	
</script>
</head>
<body>
	<form id="form" method="post">
        <input name="id" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
               <tr>
                    <th style="width:100px;">名称：</th>
                    <td>   
                    	 <input id="name" name="name" class="easyui-textbox" data-options="required:true,validType:['length[0,50]']"  missingMessage="请输入板块"/>
                    </td>
               </tr>
               <tr>
                    <th style="width:100px;">排序：</th>
                    <td>   
                    	 <input id="sortOrder" name="sortOrder" class="easyui-numberbox" data-options="required:true,validType:['length[0,12]']"  style="width:100%"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">分类类型：</th>
                    <td>   
                   	     <select id="contentType" name="contentType" class="easyui-combobox" missingMessage="请选择跳转类型" editable="false" panelHeight='auto' 
                    	 	data-options="required:true,valueField: 'code',textField: 'name',data: [{name: '全部',code: '0',selected:true},{name: '图文',code: '1'},{name: '图片',code: '2'},{name: '视频',code: '3'}]" style="width:100%"></select>
                    </td>                                      
                </tr>
                <tr>
                	<th style="width:100px;">类型：</th>
                    <td>   
						<select id="type" name="type" class="easyui-combobox" missingMessage="请选择跳转类型" editable="false" panelHeight='auto' 
                    	 	data-options="required:true,valueField: 'code',textField: 'name',data: [{name: '公开',code: '1',selected:true},{name: '地区',code: '2'}]" style="width:100%"></select>
                    </td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>
