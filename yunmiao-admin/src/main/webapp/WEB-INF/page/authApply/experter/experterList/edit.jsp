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
                var url=sy.contextPath + '/experter/save';
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
                $.post(sy.contextPath + '/experter/findById', {
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

            $("#domainId").combobox({
                url:sy.contextPath +'/domain/domainList',
                valueField:'id', //值字段
                textField:'domainName', //显示的字段

            });

        });
    </script>
</head>
<body>
<form id="form" method="post">
    <input name="id" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr style="width: 100%">
                <th style="width:100px;">领域名称：</th>
                <td>
                    <input id="domainId" name="domainId" class="easyui-combobox" data-options="validType:['length[0,100]'],editable:false" missingMessage="请输入领域名称"/>
                </td>

            </tr>
            <tr style="width: 100%">
                <th style="width:100px;">专家姓名：</th>
                <td>
                    <input id="expertName" name="expertName" class="easyui-textbox" data-options="validType:['length[0,100]']" missingMessage="请输入专家名称"/>
                </td>
            <tr>
            <tr style="width: 100%">
                <th style="width:100px;">联系电话 ：</th>
                <td>
                    <input id="phone" name="phone" class="easyui-textbox" data-options="validType:['length[0,100]']" missingMessage="请输入联系电话"/>
                </td>
            <tr>
        </table>
    </div>
</form>
</body>
</html>