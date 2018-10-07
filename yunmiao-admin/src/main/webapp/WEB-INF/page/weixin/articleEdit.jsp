<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";
	var resId = "${resId}";
	var editor;
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('Validate')) {
			var obj=sy.serializeObject($('form'));
			obj.content = editor.getHtml();
			if(resId != '')obj.resId = resId;
			var url=sy.contextPath + '/wxarticle/save';
			$.post(url, obj, function(result) {
				if (result.code == 0) {
					$grid.datagrid('reload');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.e('添加失败,'+result.msg);
				}
			}, 'json');
		}
	};
	
	$(function() {
		editor = new HtmlEditor('#content');
		if (id != '') {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/wxarticle/findById', {
				id : id
			}, function(result) {
				if (result) {
					$('form').form('load', result);
					$('#img').setFileId(result.img,false,true,false);
					editor.setHtml(result.content);
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
                    <th style="width:100px;">标题：</th>
                    <td>
                    	 <input id="title" name="title" class="easyui-textbox" data-options="required:true,validType:['length[0,60]']" missingMessage="请输入标题" style="width:90%;" prompt="请输入标题"/>
                    </td>
                </tr>
            	<tr>
                    <th style="width:100px;">封面：</th>
                    <td>
                    	<input id="img" multi="false" required="required" type="file" showImage="true" fileType="*.jpg;*.png" fileSize="300KB" buttonText="上传封面"/>
                    	<label style="color: red;">*</label>
                    	<label>建议尺寸：大图360*200，小图200*200，支持JPG、PNG格式</label>
                    </td>
                </tr>
                <tr>
                	<th style="width:100px;">摘要:</th>
                	<td>
				  		<input id="remark" name="remark" class="easyui-textbox" data-options="multiline:true,validType:['length[0,120]']" style="width:90%;height: 100px" prompt="请输入摘要(单图文时展示)"/>
				  	</td>
                </tr>
                <tr>
                	<th style="width:100px;">正文:</th>
                	<td>
				  		<textarea id="content" style="width:98%;height: 400px"></textarea>
				  	</td>
                </tr>
                <tr>
                    <th style="width:100px;">跳转链接：</th>
                    <td>
                    	 <input id="url" name="url" class="easyui-textbox" data-options="validType:['length[0,200]','url']" missingMessage="请输入链接" style="width:90%;" prompt="请输入链接"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">排序(正序)：</th>
                    <td>   
                    	 <input id="sortOrder" name="sortOrder" class="easyui-numberbox" data-options="required:true,min:0,max:9999" value="" missingMessage="请输入排序号" prompt="请输入排序号" style="width:90%;"/>
                    </td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>