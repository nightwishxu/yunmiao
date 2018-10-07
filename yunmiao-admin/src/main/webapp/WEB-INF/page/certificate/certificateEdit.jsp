<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var id = "${id}";
        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
                var url=sy.contextPath + '/certificate/save';
                obj.imgs = $("#imgs").getFileId();
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

            if (id != '') {
                parent.$.messager.progress({
                    text: '数据加载中....'
                });
                $.post(sy.contextPath + '/certificate/findById', {
                    id: id
                }, function (result) {
                    if (result) {
                        $('form').form('load', result);
                        $('#imgs').setFileId(result.imgs, false, 1, true);
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
                <th style="width:100px;">名称:</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,11]']" name="name"
                           type="text" missingMessage="名字" prompt="名字" id="name"  style="width: 100%"/>
                </td>
                <th style="width:100px;">编号:</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="code"
                           type="text" missingMessage="编号" prompt="编号" id="code"  style="width: 100%"/>
                </td>

            </tr>
            <tr>
                <th style="width:100px;">尺寸(长  单位cm):</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="length"
                           type="text" missingMessage="请输入尺寸:长" prompt="请输入尺寸:长" id="length"  style="width: 100%"/>
                </td>
                <th style="width:100px;">尺寸(宽  单位cm):</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="width"
                           type="text" missingMessage="请输入尺寸:宽" prompt="请输入尺寸:宽" id="width"  style="width: 100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">尺寸(高  单位cm):</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="height"
                           type="text" missingMessage="请输入尺寸:高" prompt="请输入尺寸:高" id="height"  style="width: 100%"/>
                </td>
                <th>重量(单位g)：</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="weight"
                           type="text" missingMessage="请输入重量" prompt="请输入重量" id="weight"  style="width: 100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">材质:</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="material"
                           type="text" missingMessage="请输入材质" prompt="请输入材质" id="material"  style="width: 100%"/>
                </td>
                <th>主体材质：</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="mainMaterial"
                           type="text" missingMessage="请输入主体材质" prompt="请输入主体材质" id="mainMaterial"  style="width: 100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">其他辅材:</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="otherMaterial"
                           type="text" missingMessage="请输入其他辅材" prompt="请输入其他辅材" id="otherMaterial"  style="width: 100%"/>
                </td>
                <th>创作年代：</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="createYear"
                           type="text" missingMessage="请输入创作年代" prompt="请输入创作年代" id="createYear"  style="width: 100%"/>
                </td>
            </tr>
            <tr>
                <th>其他：</th>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="other"
                           type="text" missingMessage="其他" prompt="其他" id="other"  style="width: 100%"/>
                </td>
            </tr>
            <tr>
                <th>图片：</th>
                <td colspan="3">
                    <div id="imgs" fileCountLimit="6" multi="true" required="required" type="file" showImage="true" showBtn="true"
                         showWidth="40" showHeight="40" bestSize="640*320" fileType="jpg,png" fileSize="200MB" buttonText="上传图片" style="width: 100%" ></div>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">市场流通性:</th>
                <td>
                    <select id="marketLiquidity" class="easyui-combobox" name="marketLiquidity" style="width:100%;" data-options="editable:false">
                        <option value="1">一颗星</option>
                        <option value="2">两颗星</option>
                        <option value="3">三颗星</option>
                        <option value="4">四颗星</option>
                        <option value="5">五颗星</option>
                    </select>
                </td>
                <th>价值稳定性：</th>
                <td>
                    <select id="valueStability" class="easyui-combobox" name="valueStability" style="width:100%;" data-options="editable:false">
                        <option value="1">一颗星</option>
                        <option value="2">两颗星</option>
                        <option value="3">三颗星</option>
                        <option value="4">四颗星</option>
                        <option value="5">五颗星</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">材质易损性:</th>
                <td>
                    <select id="materialVulnerability" class="easyui-combobox" name="materialVulnerability" style="width:100%;" data-options="editable:false">
                        <option value="1">一颗星</option>
                        <option value="2">两颗星</option>
                        <option value="3">三颗星</option>
                        <option value="4">四颗星</option>
                        <option value="5">五颗星</option>
                    </select>
                </td>
                <th>存放条件：</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="storageCondition"
                           type="text" missingMessage="请输入存放条件" prompt="请输入存放条件" id="storageCondition"  style="width: 100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">肉眼可见缺陷:</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="nakedEyeDefect"
                           type="text" missingMessage="请输入肉眼可见缺陷" prompt="请输入肉眼可见缺陷" id="nakedEyeDefect"  style="width: 100%"/>
                </td>
                <th>金融记录：</th>
                <td>
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="financeLog"
                           type="text" missingMessage="请输入金融记录" prompt="请输入金融记录" id="financeLog"  style="width: 100%"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">其他事项:</th>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="validType:['length[0,15]']" name="otherBusiness"
                           type="text" missingMessage="请输入其他事项" prompt="请输入其他事项" id="otherBusiness"  style="width: 100%"/>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>