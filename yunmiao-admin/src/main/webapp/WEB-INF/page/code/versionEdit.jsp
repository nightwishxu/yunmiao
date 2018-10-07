<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";

	var save = function() {
		if ($('form').form('validate')) {
			var url = sy.contextPath + '/code/saveVersion';
			var obj = sy.serializeObject($('form'));
			obj.code = id;
			$.post(url, obj, function(result) {
				if (result.code==0) {
					parent.$.messager.i('保存成功');
				} else {
					parent.$.messager.w('操作失败');
				}
			}, 'json');
		}
	};
	
	$(function() {
		if (id != '') {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/code/findById', {
				code : id
			}, function(result) {
				parent.$.messager.progress('close');
				if (result) {
					var version = sy.stringToJSON(result.value);
					$.extend(result,version);
					$('form').form('load', result);
				}
			}, 'json');
		
		}
	});
</script>
</head>
<body>
	<form id="form" method="post">
		<input type='hidden' name='code'/>
        <div style="padding:15px;font-size: 12px;width:50%;margin:0 auto;">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
                <tr>
                    <th style="width:100px;">版本：</th>
                    <td>   
                    	 <input id="version" name="version" class="easyui-numberbox" data-options="required:true,precision:2"></input>
                    </td>
                </tr> 
                <tr>
                    <th style="width:100px;">地址：</th>
                    <td>   
                    	 <input id="url" name="url" class="easyui-textbox" required="true"  style='width:90%;'/>
                    </td>
                </tr>
                <tr>
                	<th style="width:100px;">强制更新</th>
                	<td>   
                    	<select class="easyui-combobox" name='isFlag' data-options="required:true,editable:false,panelHeight:'auto'">
                    		<option value='0' selected="selected">否</option>
                    		<option value='1'>是</option>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">更新内容：</th>
                    <td>   
                    	 <input id="info" name="info" class="easyui-textbox" multiline='true' style='height:100px;width:90%;'/>
                    </td>
                </tr>
            </table>
        </div>
        <div style="padding:15px;font-size: 12px;width:50%;margin:0 auto;">
        	<div style="width:10%;;margin:0 auto;">
        		<a  href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-plus-circle',plain:true" onclick="save();">保存</a>
        	</div>
        </div>
	</form>
</body>
</html>