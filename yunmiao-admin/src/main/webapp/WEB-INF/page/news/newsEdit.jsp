<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<style>
.uploader-hide{ position: absolute; opacity: 0; filter:Alpha(opacity=0); /* 不占据空间，可以点击 */ }
</style>
<script type="text/javascript">
	var id = "${id}";
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var obj=sy.serializeObject($('form'));
			//图文
			if(obj.type == 1 || obj.type == 2){
				var data = [];
				for (var i = 0; i <= tuwen; i++){
					if ($('#content'+i).length == 0) continue;
					var content = $('#content'+i).val();
					var img = $('#images'+i).getFileId();
					if (!content&&!img){
						continue;
					}
					var imgs = img?img:'';
					var json = {content:content,img:imgs};
					data.push(json);
				}
				if (data.length == 0){
					$pjq.messager.e('内容或图片不能都为空');
					return;
				}
				obj.content = sy.jsonToString(data);
			}else{
				obj.content = $('#images'+0).getFileId();
				if (!obj.content){
					$pjq.messager.e('请上传视频');
					return;
				}
				var cut = $('#cutImg').getFileId();
				if (!cut){
					$pjq.messager.e('请上传视频封面');
					return;
				}
				obj.imgs = cut;
			}
			obj.isDel = 0;
			var url=sy.contextPath + '/news/save';
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

	function videoUploadSuccess(ret){
		if (ret){
			if($("#cutImg").getFileId()==''){
				$("#cutImg").setFileId(ret.file,false,1,true);
			}
		}
	}
	
	var tuwen = 0;
	
	function add(type){
		var htmls = '';
		if (type == 1 || type == 2){
			htmls += '<tr id="tuwen'+tuwen+'" class="tuwen'+tuwen+'"><th style="width:100px;">'+(type == 1?'内容':'图片描述')+'</th>'+
	        '<td>'+
	    	'<input id="content'+tuwen+'" name="content'+tuwen+'" class="easyui-textbox" data-options="validType:['+'length[0,300]'+']" missingMessage="请输入'+(type == 1?'内容':'图片描述')+'"/>'+
	    	(tuwen > 0 ? '<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:\'fa-trash\',plain:true" onclick="delTuwen('+tuwen+')">删除</a>' : '')+
			'</td>'+    
			'</tr>'+
			'<tr class="tuwen'+tuwen+'">'+
			'<th style="width:100px;">图片：</th>'+
			'<td>'+
			'<div class="easyui-linkbutton" id="images'+tuwen+'" multi="'+(type == 1?false:false)+'" fileCountLimit="9" required="required" type="file" showImage="true" showBtn="true" showWidth="40" showHeight="40" bestSize="640*320" fileType="jpg,png" fileSize="200MB" buttonText="上传图片"></div>'+
			'<label style="color: red;">*</label>'+
			'<label>建议尺寸：宽度640，高度320，格式JPG,PNG</label>'+
	    	'</td></tr>';
		}else if (type == 3){
			htmls += '<tr>'+
				'<td><div id="images0" multi="false" fileCountLimit="1" type="file" showImage="true" bestSize="640*320" fileType="mp4" showWidth="160" showHeight="90" fileSize="200MB" buttonText="上传视频" url="fileUpload?dir=video" onUploadSuccess="videoUploadSuccess"></div></td>'
			+'</tr>';
			htmls += '<tr>'+
				'<td><div id="cutImg" multi="false" fileCountLimit="1" type="file" showImage="true" bestSize="640*320" fileType="jpg" showWidth="40" showHeight="40" fileSize="2MB" buttonText="上传视频封面" url="fileUpload"></div></td>'
			+'</tr>';
		}
		
		$("#tuwen").append(htmls);
		$.parser.parse('#tuwen'+tuwen);
		sy.initFileUpload('images'+tuwen);
		if (type == 3){
			sy.initFileUpload('cutImg');
		}
		tuwen++;
	}
	
	function delTuwen(index){
		$('.tuwen'+index).remove();
	}

	var typeStr = {
			1:'图文',
			2:'图片',
			3:'视频'
	};
	
	$(function() {
		if (id != '') {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/news/findById', {
				id : id
			}, function(result) {
				parent.$.messager.progress('close');
				if (result) {
					$('form').form('load', result);
					if (result.type != 3){
						var data = sy.stringToJSON(result.content);
						var multi = result.type == 1?false:false;
						for (var i in data){
							if (i > 0)
								add(result.type);
							$('#content'+i).textbox('setValue',data[i].content);
							if (data[i].img)
								$('#images'+i).setFileId(data[i].img,multi,1,true);
						}
					}else{
						//add(result.type);
						$('#images0').setFileId(result.content,false,2,true);
						if (result.imgs){
							$("#cutImg").setFileId(result.imgs,false,1,true);
						}
					}
				}
			}, 'json'); 

		}
		
		$('#cateId').combobox({           	
    		url:sy.contextPath + '/newsCate/listName.do',
            valueField:'id',
            textField:'name',   
            onChange:function(data){
            }
    	});
		
		
		$('#type').combobox({           	
            onChange:function(data){
            	$('#tuwen').html('');
            	$('#tuwenType').html(typeStr[data]);
            	$('#addBtn').remove();
            	tuwen = 0;
            	add(data);
            	if (data != 3){
            		var button = '<div id="addBtn"><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:\'fa-plus-circle\',plain:true" onclick="add('+data+')">添加</a></div>';
            		$('#tuwenAdd').append(button);
            		$.parser.parse('#addBtn');
            	}
            }
    	});
		
		
		
	});
	
</script>
</head>
<body>
	<form id="form" method="post">
        <input name="id" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
               <tr>
                    <th style="width:100px;">板块：</th>
                    <td>   
                    	 <input id="cateId" name="cateId" class="easyui-combobox" data-options="required:true,validType:['length[0,50]'],editable:false"  missingMessage="请输入板块"/>
                    </td>
               </tr>
               <tr>
                    <th style="width:100px;">标题：</th>
                    <td>   
                    	 <input id="title" name="title" class="easyui-textbox" data-options="required:true,validType:['length[0,12]']"  missingMessage="请输入标题" style="width:90%"/>
                    </td>
                </tr>
               <tr>
                    <th style="width:100px;">来源：</th>
                    <td>   
                    	 <input id="source" name="source" class="easyui-textbox" data-options="validType:['length[0,20]']"  missingMessage="请输入来源" style="width:90%"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">类型：</th>
                    <td>   
                    
						<select id="type" name="type" class="easyui-combobox" missingMessage="请选择跳转类型" editable="false" panelHeight='auto' 
                    	 	data-options="required:true,valueField: 'code',textField: 'name',data: [{name: '图文',code: '1',selected:true},{name: '图片',code: '2'},{name: '视频',code: '3'}]" ></select>
                    
                    </td>                                      
                </tr>
                <tr >
                	<th id='tuwenType'>图文</th>
                	<td id='tuwenAdd'>
                		<table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable" id='tuwen'>
                		</table>
                	</td>
                </tr>
                <tr>
                	<th style="width:100px;">设置为热门：</th>
                    <td>   
						否<input type="radio" name="isHot" id="isHot" value="0" checked="checked" />
						是<input type="radio" name="isHot" id="isHot" value="1" />
                    </td>
                </tr>
                <tr>
                	<th style="width:100px;">是否置顶：</th>
                    <td>   
						否<input type="radio" name="isTop" id="isTop" value="0" checked="checked"/>
						是<input type="radio" name="isTop" id="isTop" value="1" />
                    </td>
                </tr>




            </table>
        </div>
	</form>
</body>
</html>
