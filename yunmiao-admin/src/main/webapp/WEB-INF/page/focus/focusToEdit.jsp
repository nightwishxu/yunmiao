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
                    obj.redirectContent = obj.storeContent;
                    l = 2;
                }else if(obj.redirectType == 3){
                    obj.redirectContent = obj.storeContent;
                    l = 3;
                }else if(obj.redirectType == 4){
                    obj.areaCode = obj.pawnCate;
                    obj.redirectContent = obj.storeContent;
                    l = 6;
                }
                var url=sy.contextPath + '/focus/save?location='+l;
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
            $('#redirectState').combobox({
                onSelect: function(rec){
                    if(rec.code == '1'){
                        $('#rt').hide();
                        $('#rc').hide();
                        $('#store').hide();
                        $('#cate').hide();
                    }else if(rec.code == '2'){
                        $('#rt').show();
                        $('#rc').hide();
                        $('#rn').html("网址：");
                    }else if(rec.code == '3'){
                        $('#store').show();
                        $('#rc').hide();
                        $('#cate').hide();
                        $('#stop').html("网址: ");
                        $('#storeContent').combobox({
                            url:sy.contextPath+"/goods/findByType?type="+1,
                            textField:'name',
                            valueField:'id',
                            editable:false
                        });
                    }else if(rec.code == '4'){
                        $('#store').show();
                        $('#rc').hide();
                        $('#cate').hide();
                        $('#stop').html("网址: ");
                        $('#storeContent').combobox({
                            url:sy.contextPath+"/goods/findByType?type="+2,
                            textField:'name',
                            valueField:'id',
                            editable:false
                        });
                    }else if(rec.code == '4'){
                        $('#store').hide();
                        $('#rc').hide();
                        $('#cate').show();
                        $('#pawnCate').combobox({
                            url:sy.contextPath+"/pawnCate/all",
                            textField:'name',
                            valueField:'code',
                            required:true,
                            onLoadSuccess: function () {
                                var val = $(this).combobox("getData");
                                for (var item in val[0]) {
                                    if (item == "id") {
                                        $(this).combobox("select", val[0][""]);
                                    }
                                }
                            },
                            onHidePanel: function(){
                                var code = $('#pawnCate').combobox('getValue');
                                if(code != null){
                                    $('#store').show();
                                    $('#storeContent').combobox({
                                        url:sy.contextPath+"/goods/findByType?code="+code,
                                        textField:'name',
                                        valueField:'id',
                                        editable:false
                                    });
                                }
                            },
                            editable:false
                        });
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
                            $('#store').show();
                            $('#shop').html("网址：");
                            $('#pawnCate').combobox({
                                url:sy.contextPath+"/pawnCate/all",
                                textField:'name',
                                valueField:'code',
                                required:true,
                                editable:false
                            });
                            $('#storeContent').combobox({
                                url:sy.contextPath+"/goods/findByType",
                                textField:'name',
                                valueField:'id',
                                required:true,
                                editable:false
                            });
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
                <th style="width:100px;">类型：</th>
                <td>
                    <select id="redirectState" name="redirectState" class="easyui-combobox" missingMessage="请选择跳转类型" editable="false" panelHeight='auto'
                            data-options="required:true,valueField: 'code',textField: 'name',data: [{name: '首页',code: '1',selected:true},{name: '认证商城',code: '2'},{name: '绝当商城',code: '3'}]"/>
                </td>
            </tr>
            <tr id="rt">
                <th style="width:100px;">跳转类型：</th>
                <td>
                    <select id="redirectType" name="redirectType" class="easyui-combobox" missingMessage="请选择跳转类型" editable="false" panelHeight='auto'
                            data-options="required:true,valueField: 'state',textField: 'name',data: [{name: '不跳转',state: '0',selected:true},{name: '网页',state: '1'},{name: '内部链接',state: '2'}]"/>
                </td>
            </tr>
            <tr id="vg" style="display: none;">
                <th style="width:100px;">视频/商品：</th>
                <td>
                    <select id="vedioGood" name="vedioGood" class="easyui-combobox" missingMessage="请选择跳转类型" editable="false" panelHeight='auto'
                            data-options="required:true,valueField: 'code',textField: 'name',data: [{name: '不跳转',code: '0',selected:true},{name: '视频',code: '1'},{name: '商品',code: '2'}]"/>
                </td>
            </tr>
            <tr id="rc" style="display: none;">
                <th style="width:100px;" id="rn"></th>
                <td>
                    <input id="redirectContent" name="redirectContent" class="easyui-textbox" data-options="validType:['length[0,100]']" missingMessage="请输入"/>
                </td>
            </tr>
            <tr id="ac" style="display: none;">
                <th style="width:100px;" id="an"></th>
                <td>
                    <input id="areaCode" name="areaCode" class="easyui-textbox" data-options="validType:['length[0,100]']" missingMessage="请输入"/>
                </td>
            </tr>
            <tr id="cate" style="display: none;">
                <th style="width:100px;">类别：</th>
                <td>
                    <input id = "pawnCate" name="pawnCate"  data-options="required:true" style="width:100%" missingMessage="请选择商品"/>
                </td>
            </tr>
            <tr id="store" style="display: none;">
                <th style="width:100px;">请选择商品：</th>
                <td>
                    <input id = "storeContent" name="storeContent"  data-options="required:true" style="width:100%" missingMessage="请选择商品"/>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>