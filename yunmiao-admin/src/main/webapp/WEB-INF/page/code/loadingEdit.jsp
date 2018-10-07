<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = 'welcome';

	var save = function() {
		if ($('form').form('validate')) {
			var url = sy.contextPath + '/code/saveLoading';
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
					$('#img').setFileId(result.img,false,true,true);
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
            		<th style="width:100px;">图片：</th>
            		<td>
                		<div id="img" name='img' multi="false" type="file" showImage="true" fileType="jpg,png,gif" showWidth='350' showHeight='600' fileSize="2MB" buttonText="上传图片"></div>
            		</td>
            	</tr>
                <tr>
                    <th style="width:100px;">地址：</th>
                    <td>   
                    	 <input id="url" name="url" class="easyui-textbox" required="true"  style='width:90%;'/>
                    </td>
                </tr>
                <tr>
                	<th style="width:100px;">时间</th>
                	<td>   
                    	<input id="seconds" name="seconds" class="easyui-numberbox" data-options="required:true,min:1,max:60"></input>
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