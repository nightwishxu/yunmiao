<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	<%@ include file="/static/admin/jsp/include.jsp"%>
  </head>
  <body>
  <div style="font-size: 12px">
  	<table style="width: 100%" id="showTable">
  		<tr>
    		<td>
    			<a class="easyui-linkbutton" onclick="$('#showTable').hide();$('#editTable').show();" data-options="iconCls:'fa-pencil'">编辑</a>  
    		</td>
    	</tr>
		<tr>
			<td style="width: 100%" id="show">
			
			</td>
		</tr>
     </table>
    <form id="form" method="post">
    <table style="width: 100%;display: none;" id="editTable" >
    	<tr>
    		<td>
    			<a class="easyui-linkbutton" onclick="save()" data-options="iconCls:'fa-save'">保存</a>  
    			<a class="easyui-linkbutton" onclick="back()" data-options="iconCls:'fa-reply'">返回</a> 
    		</td>
    	</tr>
		<tr>
			<td style="width: 100%"><textarea id="content" style="width:98%;height: 550px"></textarea></td>
		</tr>
     </table>
    </form>
  </div>
    <script type="text/javascript">
    var editor = new HtmlEditor('#content');
	var code = "${code}";
    $(function(){
    	$.post(sy.contextPath + '/sp/findByCode', {
    		code : code
		}, function(result) {
			$("#show").html(result.content);
			editor.setHtml(result.content);
		}, 'json');
    });
    
   	function save(){
   		if ($('form').form('validate')) {
   			parent.$.messager.progress({
   				text : '发送中....'
   			});
    		$.ajax({
    			type:"post",
    			data:{code:code,content:editor.getHtml()},
    			url:"sp/save.do",
    			dataType:"json",
    			success:function(data){
    				parent.$.messager.progress('close');
    				if(data.code == 0){
    					back();
    				}else{
    					parent.$.messager.w(data.msg);
    				}
    			}
    		});
   		}
   	}
   	
   	function back(){
   		location.href = "go.do?path=common/single&code="+code;
   	}
   </script>	
  </body>
</html>
