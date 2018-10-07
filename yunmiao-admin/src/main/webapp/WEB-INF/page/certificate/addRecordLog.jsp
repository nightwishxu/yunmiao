<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var id = "{id}";
        var certificateId = "${certificateId}";
        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
                obj.certificateId = certificateId;
                obj.logTime = obj.logTime+" 00:00:00";
                var url=sy.contextPath + '/certificateLog/save';
                $.post(url, obj, function(result) {
                    console.log(result)
                    if (result.code == 0) {
                        $grid.datagrid('reload');
                        $dialog.dialog('destroy');
                    } else {
                        $pjq.messager.e('添加失败,'+result.msg);
                    }
                }, 'json');
            }
        };

//        $(function() {
//            if (id != '') {
//                parent.$.messager.progress({
//                    text : '数据加载中....'
//                });
//                $.post(sy.contextPath + '/certificateLog/findById', {
//                    id : id
//                }, function(result) {
//                    if (result) {
//                        $('form').form('load', result);
//                    }
//                    parent.$.messager.progress('close');
//                }, 'json');
//
//            }
//        })


    </script>
</head>
<body>
<form id="form" method="post">
    <input name="id" type="hidden" />
    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th style="width:100px;">流通日期:</th>
                <td>
                    <input class="easyui-datebox" data-options="validType:['length[0,15]'],editable:false" name="logTime"
                            missingMessage="请输入流通日期" prompt="请输入流通日期" id="logTime"  style="width: 100%"/>
                </td>
                <th style="width:100px;">流通价格:</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,11]']" name="price"
                           type="text" missingMessage="流通价格" prompt="流通价格" id="price"  style="width: 100%"/>
                </td>

            </tr>
        </table>
    </div>
</form>
</body>
</html>