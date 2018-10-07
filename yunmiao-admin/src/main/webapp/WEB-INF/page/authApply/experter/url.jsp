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
                obj.goodsId = id;
                var url=sy.contextPath + '/experterInfo/saveInfo';
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
                $.post(sy.contextPath + '/experterInfo/findById', {
                    id : id
                }, function(result) {
                    if (result) {
                        $("#url").textbox('setValue',"http://223.111.180.77/paidangAdmin/m/pawn/H5GetExperterInfo?id="+id);

                            $('form').form('load', result);

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
            <tr style="width: 100%">
                <th style="width:100px;">链接地址：</th>
                <td>
                    <input id="url" name="url" class="easyui-textbox" data-options="validType:['length[0,100]'],editable:false" missingMessage="请输入领域名称"/>
                </td>

            </tr>
        </table>
    </div>
</form>
</body>
</html>