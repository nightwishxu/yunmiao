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
			if(l == 4){
			    obj.img="";
            }
			if(id == ''){
				obj.location = l;
			}
			if(obj.type == 0){
				obj.content = null;
			}else if(obj.type == 1){
                if($('#url').val().indexOf("://") == -1){
					$pjq.messager.w('您输入的网址格式不正确');
					return;
				} else {
                    obj.content = $('#url').val();
                }
			}else if(obj.type == 2){
				obj.content = editor.getHtml();
			}else if(obj.type == 3){
			    if ($('#sel_rz_goods').val() == '') {
                    $pjq.messager.w('请选择认证商城商品');
                    return;
                } else {
                    obj.content = $('#sel_rz_goods').val();
                }
            }else if(obj.type == 4){
                if ($('#sel_jd_goods').val() == '') {
                    $pjq.messager.w('请选择绝当商城商品');
                    return;
                } else {
                    obj.content = $('#sel_jd_goods').val();
                }
            }else if(obj.type == 5){
                if ($('#sel_videos').val() == '') {
                    $pjq.messager.w('请选择视频');
                    return;
                } else {
                    obj.content = $('#sel_videos').val();
                }
            }
			var url=sy.contextPath + '/ad/save';
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
        if(l == 4){
            $("#showImgs").hide();
        }
        $('#sel_rz_goods').combobox({
            textField: 'name',
            valueField: 'id',
            url : sy.contextPath + '/ad/goodsList?type=1',
            filter: function(q, row){
                var opts = $(this).combobox('options');
                return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) != -1;
            },
        });
        $('#sel_jd_goods').combobox({
            textField: 'name',
            valueField: 'id',
            url : sy.contextPath + '/ad/goodsList?type=2',
            filter: function(q, row){
                var opts = $(this).combobox('options');
                return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) != -1;
            },
        });
        $('#sel_videos').combobox({
            textField: 'title',
            valueField: 'id',
            url : sy.contextPath + '/ad/videoList',
            filter: function(q, row){
                var opts = $(this).combobox('options');
                return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) != -1;
            },
        });

		editor = new HtmlEditor('#content');
		$('#type').combobox({   
			onSelect: function(rec){   
				if(rec.code == '0'){
					$('#rc').hide();
					$('#info').hide();
                    $('#rz_goods').hide();
                    $('#jd_goods').hide();
                    $('#videos').hide();
				}else if(rec.code == '1'){
                    $('#rc').show();
                    $('#info').hide();
                    $('#rz_goods').hide();
                    $('#jd_goods').hide();
                    $('#videos').hide();
				}else if(rec.code == '2'){
                    $('#rc').hide();
                    $('#info').show();
                    $('#rz_goods').hide();
                    $('#jd_goods').hide();
                    $('#videos').hide();
                }else if(rec.code == '3'){
                    $('#rc').hide();
                    $('#info').hide();
                    $('#rz_goods').show();
                    $('#jd_goods').hide();
                    $('#videos').hide();
                }else if(rec.code == '4'){
                    $('#rc').hide();
                    $('#info').hide();
                    $('#rz_goods').hide();
                    $('#jd_goods').show();
                    $('#videos').hide();
                }else if(rec.code == '5'){
                    $('#rc').hide();
                    $('#info').hide();
                    $('#rz_goods').hide();
                    $('#jd_goods').hide();
                    $('#videos').show();
                }
	        }
		});
		
		if (id != '') {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/ad/findById', {
				id : id
			}, function(result) {
				if (result) {
					if(result.type == 0){
					}else if(result.type == 1){
                        $('#rc').show();
                        $('#info').hide();
                        $('#rz_goods').hide();
                        $('#jd_goods').hide();
                        $('#videos').hide();
						$('#url').textbox('setValue', result.content);
					}else if(result.type == 2){
                        $('#rc').hide();
                        $('#info').show();
                        $('#rz_goods').hide();
                        $('#jd_goods').hide();
                        $('#videos').hide();
						editor.setHtml(result.content);
                        $('#content').textbox({required:true});
					}else if(result.type == 3){
                        $('#rc').hide();
                        $('#info').hide();
                        $('#rz_goods').show();
                        $('#jd_goods').hide();
                        $('#videos').hide();
                        $('#sel_rz_goods').combobox('select', result.content);
                    }else if(result.type == 4){
                        $('#rc').hide();
                        $('#info').hide();
                        $('#rz_goods').hide();
                        $('#jd_goods').show();
                        $('#videos').hide();
                        $('#sel_jd_goods').combobox('select', result.content);
                    }else if(result.type == 5){
                        $('#rc').hide();
                        $('#info').hide();
                        $('#rz_goods').hide();
                        $('#jd_goods').hide();
                        $('#videos').show();
                        $('#sel_videos').combobox('select', result.content);
                    }

					$('form').form('load', result);
                    if(result.img){
                        $('#img').setFileId(result.img,false,true,true);
                    }

				}
				parent.$.messager.progress('close');
			}, 'json');

		}else{

		}

        if (l == "4") {
            $('#dis').show();
            $('#discription').textbox({required:true});
        } else {
            $('#dis').hide();
            $('#discription').textbox({required:false});
        }

	});
</script>
</head>
<body>
	<form id="form" method="post">
        <input name="id" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            	<tr id="showImgs">
                    <th style="width:100px;">图片：</th>
                    <td>
                    	<div id="img" multi="false" fileCountLimit='2'  type="file" showImage="true" showBtn='true' bestSize='640*320' fileType="jpg,png,mp4" fileSize="200MB" buttonText="上传图片"></div>
                    	<label style="color: red;">*</label>
                    	<label>建议尺寸：宽度640，高度320，格式JPG,PNG</label>
                    </td>
                </tr>
                <tr id="dis" style="display: none;">
                    <th style="width:100px;">文字简介：</th>
                    <td>
                        <input id="discription" name="discription" class="easyui-textbox" data-options="validType:['length[0,100]']" missingMessage="请输入"/>
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
                    	 <select id="type" name="type" class="easyui-combobox" missingMessage="请选择类型" editable="false" panelHeight='auto'
                    	 	data-options="required:true,valueField: 'code',textField: 'name',data: [{name: '不跳转',code: '0',selected:true},{name: '网页',code: '1'},{name: '富文本',code: '2'},{name: '认证商城商品详情',code: '3'},{name: '绝当商城商品详情',code: '4'},{name: '视频详情',code: '5'}]"/>
                    </td>
                </tr>
                <tr id="rc" style="display: none;">
                	<th style="width:100px;" id="rn">网址：</th>
                    <td>
                    	<input id="url" name="url" class="easyui-textbox" data-options="validType:['length[0,100]']" missingMessage="请输入"/>
                    </td>
                </tr>
                <tr id="info" style="display: none;">
                	<th>详情:</th>
                	<td>
				  		<textarea id="content" style="width:98%;height: 400px"></textarea>
				  	</td>
                </tr>
                <tr id="rz_goods" style="display: none;">
                    <th>认证商城商品:</th>
                    <td>
                        <input id="sel_rz_goods" name="sel_rz_goods" editable="true" style="width:400px;" panelHeight='150' />
                    </td>
                </tr>
                <tr id="jd_goods" style="display: none;">
                    <th>绝当商城商品:</th>
                    <td>
                        <input id="sel_jd_goods" name="sel_jd_goods" editable="true" style="width:400px;" panelHeight='150' />
                    </td>
                </tr>
                <tr id="videos" style="display: none;">
                    <th>视频:</th>
                    <td>
                        <input id="sel_videos" name="sel_videos" editable="true" style="width:400px;" panelHeight='150' />
                    </td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>