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
        if ($('form').form('validate')) {
            var obj=sy.serializeObject($('form'));
            var url=sy.contextPath + '/domain/save';
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
			$.post(sy.contextPath + '/domain/findById', {
				id : id
			}, function(result) {
				if (result) {
                    if (result.type == 0) {
                    } else if (result.type == 1) {

                        $('form').form('load', result);
                    }
                    parent.$.messager.progress('close');
                }
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
                <tr id="dis" style="width: 100%">
                    <th style="width:100px;">领域名称：</th>
                    <td>
                        <input id="domainName" name="domainName" class="easyui-textbox" data-options="validType:['length[0,100]']" missingMessage="请输入领域名称"/>
                    </td>
                </tr>
                <tr>
            </table>
        </div>
	</form>
</body>
</html>