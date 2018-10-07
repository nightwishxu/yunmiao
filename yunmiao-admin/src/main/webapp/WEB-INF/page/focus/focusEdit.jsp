<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var l = "${location}";
	var id = "${id}";
	var editor;
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('Validate')) {
			var obj=sy.serializeObject($('form'));
			if(id == ''){
				obj.location = l;
			}
			if(obj.redirectType == 0){
				obj.redirectContent = '';
			}else if(obj.redirectType == 1){
				if(obj.redirectContent.indexOf("://") == -1){
					$pjq.messager.w('您输入的网址格式不正确');
					return;
				}
			}else if(obj.redirectType == 2){
				obj.redirectContent = '';
				obj.content = editor.getHtml();
			}
			var url=sy.contextPath + '/focus/save';
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
		$('#redirectType').combobox({   
			onSelect: function(rec){   
				if(rec.code == '0'){
					$('#rc').hide();
					$('#info').hide();
					$('#redirectContent').textbox({required:false});
				}else if(rec.code == '1'){
					$('#rc').show();
					$('#rn').html("网址：");
					$('#redirectContent').textbox({required:true});
					$('#info').hide();
				}else if(rec.code == '2'){
					$('#rc').hide();
					$('#info').show();
					$('#redirectContent').textbox({required:false});
				}
	        }
		});
		
		if (id != '') {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/focus/findById', {
				id : id
			}, function(result) {
				if (result) {
					if(result.redirectType == 0){
					}else if(result.redirectType == 1){
						$('#rc').show();
						$('#rn').html("网址：");
						$('#redirectContent').textbox({required:true});
					}else if(result.redirectType == 2){
						editor.setHtml(result.content);
						$('#info').show();
					}
					
					$('form').form('load', result);
					$('#img').setFileId(result.img,false,true,true);
				}
				parent.$.messager.progress('close');
			}, 'json');

		}else{
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
                    <th style="width:100px;">图片：</th>
                    <td>
                    	<div id="img" multi="false" fileCountLimit='2' required="required" type="file" showImage="true" showBtn='true' bestSize='640*320' fileType="jpg,png,mp4" fileSize="200MB" buttonText="上传图片"></div>
                    	<label style="color: red;">*</label>
                    	<label>建议尺寸：宽度640，高度320，格式JPG,PNG</label>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">排序(倒序)：</th>
                    <td>   
                    	 <input id="sortOrder" name="sortOrder" class="easyui-numberbox" data-options="min:0,max:9999" value="" missingMessage="请输入排序号" prompt="请输入排序号"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">跳转类型：</th>
                    <td>   
                    	 <select id="redirectType" name="redirectType" class="easyui-combobox" missingMessage="请选择跳转类型" editable="false" panelHeight='auto' 
                    	 	data-options="required:true,valueField: 'code',textField: 'name',data: [{name: '不跳转',code: '0',selected:true},{name: '网页',code: '1'},{name: '富文本',code: '2'}]"/>
                    </td>
                </tr>
                <tr id="rc" style="display: none;">
                	<th style="width:100px;" id="rn"></th>
                    <td>
                    	<input id="redirectContent" name="redirectContent" class="easyui-textbox" data-options="validType:['length[0,100]']" missingMessage="请输入"/>
                    </td>
                </tr>
                <tr id="info" style="display: none;">
                	<th>详情:</th>
                	<td>
				  		<textarea id="content" style="width:98%;height: 400px"></textarea>
				  	</td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>