<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var id = "${id}";
	var parent = "${parent}";
	var level = "${level}";
	var groupId= '${groupId}';
	var tree;
	var getValues = function(){
		var obj = [];
		var tt = $('#ss');
        var nodes = tt.tree('getChecked');
		if (!nodes) return obj;
		for (var i=0;i<nodes.length;i++){
			obj.push(nodes[i].id);
			if (tt.tree('isLeaf',nodes[i].target)){
				var node = tt.tree('getParent',nodes[i].target);
				if (!isHave(obj,node.id)){obj.push(node.id);}
			}
		}
		return obj;
	};
	
	var setValues = function(rid){
		if (!rid) return;
		var array = rid.split(',');
		for (var i=0;i<array.length;i++){
			var node = tree.tree('find',array[i]);
			if (!node) continue;
			tree.tree('check',node.target);
		}
	};
	
	var isHave = function(obj,node){
		for (var i=0;i<obj.length;i++){
			if (node== obj[i])
				return true;
		}
		return false;
	};
	
	
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url = sy.contextPath + '/role/addrole';
			var obj = sy.serializeObject($('form'));
			var rids = getValues();
			if (rids){
				obj.rid = rids.join(',');
			}
			if(level!=""){
				obj.level = level;
				obj.parentId = parent;
			}
			obj.appId = '0';
			if (groupId)
				obj.groupId = groupId;	
			$.ajax({
				url : url,
				cache : false,
				data : obj,
				type : 'post',
				success : function(result) {
					if (result.success) {
						$grid.treegrid('reload');
						$dialog.dialog('destroy');
					} else {
						$pjq.messager.e('操作失败');
					}
				},
				dataType : 'json'
			});
		}
	};

	$(function() {	
		tree = $('#ss').tree({
			checkbox:true,
			url:sy.contextPath + '/role/listsByParent?parentId='+parent,
			parentField:'parentId',
			idField:'id',
			textField:'name',
			onLoadSuccess : function(node,data){
				if (id != ''){
					$.ajax({
						url: sy.contextPath + '/role/findrole',
						data : {id:id},
						type : 'post',
						cache : true,
						dataType:'json',
						success:function(result) {
							if (result) {		
								$('form').form('load', result);
								setValues(result.rid);
							}
						}
					});
					$('#code').textbox({novalidate:true,disabled:true});
				}
			}
			
		});
	});
</script>
</head>
<body>
	<form id="form" method="post">
        <input name="id" type="hidden" />
        <input name='groupId' type="hidden"/>
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            	
            	<tr>
                    <th style="width:100px;">名称：</th>
                    <td>
                    	 <input id="name" name="name" class="easyui-textbox" data-options="required:true,validType:['length[0,15]']"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">标识：</th>
                    <td>   
                    	 <input id="code" name="code" class="easyui-textbox" data-options="required:true"/>
                    </td>
                </tr>
                <tr>
                    <th style="width:100px;">描述：</th>
                    <td>   
                    	 <input id="info" name="info" class="easyui-textbox"/>
                    </td>
                </tr>
                <tr>
                	<th style="width:100px;">授权：</th>
                	<td>   
                    	 <ul id="ss"></ul> 	
                    </td>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>