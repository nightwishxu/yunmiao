<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <style>

    </style>
    <script type="text/javascript">
        var id = "${id}";
        var type = "${type}";
        var source = "${source}";
        var editor;
        $(function() {
            $("#id").val(id);
            $("#type").val(type);
            $("#source").val(source);
        });
        var submitForm = function($dialog, $grid, $pjq) {
            if ($('form').form('validate')) {
                var obj=sy.serializeObject($('form'));
//                if(obj.cateCode == 4 || obj.cateCode == 6){
//                    obj.cateCode = $("#cateCode2").combobox('getValue');
//                }else{
//                    obj.cateCode = $("#cateCode").combobox('getValue');
//                }
                if($("#cateCode2").combobox('getValue') == ''){
                    obj.cateCode = $("#cateCode").combobox('getValue');
                }else{
                    obj.cateCode = $("#cateCode2").combobox('getValue');
                }

                var url=sy.contextPath + '/goods/serviceSave';
                obj.img = $('#img').getFileId();
                obj.imgs = $('#imgs').getFileId();
                obj.info = editor.getHtml();

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
            editor = new HtmlEditor('#info');
//            $('#cateCode').combobox({
//                url:sy.contextPath+"/pawnCate/all",
//                textField:'name',
//                valueField:'code',
//                editable:false
//            })
            $("#cateCode").combobox({
                onChange: function (value) {
                    if(value == 4){
                        $("#cateCode2").combobox({
                            valueField: 'label',
                            textField: 'value',
                            data: [{
                                label: '9',
                                value: '明清砚台'
                            },{
                                label: '10',
                                value: '文玩'
                            },{
                                label: '11',
                                value: '杂项'
                            }]
                        });
                    }else if(value == 6){
                        $("#cateCode2").combobox({
                            valueField: 'label',
                            textField: 'value',
                            data: [{
                                label: '12',
                                value: '红蓝宝石'
                            },{
                                label: '13',
                                value: '祖母绿'
                            },{
                                label: '14',
                                value: '珍珠'
                            },{
                                label: '15',
                                value: '碧玺'
                            }]
                        });
                    }else{
                        $("#cateCode2").combobox('clear')
                        $("#cateCode2").combobox('loadData', {});
                    }
                }
            });

            if (id != '') {
                parent.$.messager.progress({
                    text : '数据加载中....'
                });
                $.post(sy.contextPath + '/goods/findById', {
                    id : id
                }, function(result) {
                    if (result) {
                        console.log(result.cateCode);
                        if(result.cateCode){
                            var cateName = '';
                            if(result.cateCode == 4 || result.cateCode == 6){
                                $("#cateCode").combobox('setValue',result.cateCode);
                            }else{
                                if(result.cateCode == 9){
                                    cateName = '明清砚台'
                                    $("#cateCode").combobox('setValue',4);
                                }else if(result.cateCode == 10){
                                    cateName = '文玩'
                                    $("#cateCode").combobox('setValue',4);
                                }else if(result.cateCode == 11){
                                    cateName = '杂项'
                                    $("#cateCode").combobox('setValue',4);
                                }else if(result.cateCode == 12){
                                    cateName = '红蓝宝石'
                                    $("#cateCode").combobox('setValue',6);
                                }else if(result.cateCode == 13){
                                    cateName = '祖母绿'
                                    $("#cateCode").combobox('setValue',6);
                                }else if(result.cateCode == 14){
                                    cateName = '珍珠'
                                    $("#cateCode").combobox('setValue',6);
                                }else if(result.cateCode == 15){
                                    cateName = '碧玺'
                                    $("#cateCode").combobox('setValue',6);
                                }
                                $("#cateCode2").combobox('setValue',cateName);
                            }


                        }
                        $('form').form('load', result);
                        $("#img").setFileId(result.img,false,1,true);
                        $("#imgs").setFileId(result.imgs,false,1,true);
                        editor.setHtml(result.info);
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
    <input name="type" id="type" type="hidden" />
    <input name="source" id="source" type="hidden" />

    <div style="padding:15px;font-size: 12px">
        <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            <tr>
                <th style="width:100px;">分类：</th>
                <td>
                    <%--<input id = "cateCode" name="cateCode"  data-options="required:true" style="width:100%" missingMessage="请选择商品分类"/>--%>
                    <select id="cateCode" class="easyui-combobox" style="width:100%;" data-options="editable:false">
                        <option value="1">钟表</option>
                        <option value="2">翡翠</option>
                        <option value="3">和田玉</option>
                        <option value="4">古董艺术</option>
                        <option value="5">书画</option>
                        <option value="6">彩色珠宝</option>
                        <option value="7">钻石</option>
                        <option value="8">其他</option>
                    </select>
                </td>
                <th style="width:100px;">子分类</th>
                <td>
                    <select id="cateCode2" class="easyui-combobox" style="width:100%;" data-options="editable:false">

                    </select>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">名称：</th>
                <td colspan="3">
                    <input class="easyui-textbox" id = "name" name = "name"  data-options="required:true" style="width:100%" missingMessage="请输入商品名称"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">封面：</th>
                <td>
                    <div id = "img" name="img"  type="file" multi="false" showImage="true" fileType="jpg,png,mp4" fileSize="200MB" buttonText="上传商品封面" ></div>
                </td>
                <th style="width:100px;">组图：</th>
                <td>
                    <div id = "imgs" name="imgs"  type="file" multi="true" fileCountLimit="6" showImage="true" fileType="jpg,png,mp4" fileSize="200MB" buttonText="上传商品组图"></div>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">封面高度：</th>
                <td>
                    <input class="easyui-numberbox" id = "height" name="height"  data-options="required:true,min:0" style="width:100%" missingMessage="请输入封面高度"/>
                </td>
                <th style="width:100px;" >封面宽度：</th>
                <td>
                    <input class="easyui-numberbox" id = "width" name = "width"  data-options="required:true,min:0" style="width:100%" missingMessage="请输入封面宽度"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">成本：</th>
                <td>
                    <input class="easyui-numberbox" id = "cost" name="cost"  data-options="required:true,precision:2,min:0,max:9999999999" style="width:100%" missingMessage="请输入成本"/>
                </td>
                <th style="width:100px;" >库存：</th>
                <td>
                    <input class="easyui-numberbox" id = "total" name = "total"  data-options="required:true,min:0" style="width:100%" missingMessage="请输入库存"/>
                </td>
            </tr>
            <tr>
                <th style="width:100px;">售价：</th>
                <td>
                    <input class="easyui-numberbox" id = "price" name="price"  data-options="required:true,precision:2,min:0,max:9999999999" style="width:100%" missingMessage="请输入成本"/>
                </td>
                <th style="width:100px;">排序：</th>
                <td>
                    <input class="easyui-numberbox" id = "sortOrder" name="sortOrder"  data-options="required:true" style="width:100%" missingMessage="请输入排序"/>
                </td>
            </tr>

            <tr>
                <th style="width:100px;">规格：</th>
                <td colspan="3">
                    <input class="easyui-textbox" id = "spec" name = "spec"  data-options="required:true" style="width:100%" missingMessage="请输入商品规格"/>
                </td>
            </tr>

            <tr>
                <%--<th style="width:100px;">详情：</th>
                <td colspan="3">
                    <textarea id="info" name="info"></textarea>
                </td>--%>

                <th style="width:100px;">详情:</th>
                <td colspan="3">
                    <textarea id="info"></textarea>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>