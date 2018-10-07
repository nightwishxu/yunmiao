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
            obj.images = $('#images').getFileId();
			var url=sy.contextPath + '/userGoods/save';
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
	    console.log(id);
		if (id != '') {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/userGoods/findById', {
				id : id
			}, function(result) {
				if (result) {
					$('form').form('load', result);
                    $("#images").setFileId(result.images,true,1,true);
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
                    <th style="width:100px;">藏品图片：</th>
                    <td colspan="3">
                        <div id = "images" name="images"  type="file" multi="true" fileCountLimit="9" showImage="true" fileType="jpg,png,mp4" fileSize="200MB" buttonText="上传商品组图"></div>
                    </td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>