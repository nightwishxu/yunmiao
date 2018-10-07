<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
	<%@ include file="/static/admin/jsp/include.jsp"%>
  </head>
  <body>
  <div style="font-size: 12px">
  	<table style="width: 100%" id="showTable">
  		<tr>
    		<td>
    			<a class="easyui-linkbutton" onclick="$('#showTable').hide();$('#editTable').show();" data-options="iconCls:'ext-icon-database_edit'">编辑</a>  
    			<span id="total"></span>
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
    			<a class="easyui-linkbutton" onclick="save()" data-options="iconCls:'ext-icon-database_save'">保存</a>  
    			<a class="easyui-linkbutton" onclick="back()" data-options="iconCls:'ext-icon-arrow_undo'">返回</a> 
    			<label style="color: red;">*</label>
                <label>敏感词之间用英文","隔开</label>
    		</td>
    	</tr>
		<tr>
			<td style="width: 100%">
				<textarea id="content" style="width:98%;height: 550px"></textarea>
			</td>
		</tr>
     </table>
    </form>
  </div>
    <script type="text/javascript">
    $(function(){
    	$.post(sy.contextPath + '/code/loadSensitiveWords.do', {
		}, function(result) {
			if(result.code == 0){
				$("#show").html(result.msg);
				$("#content").val(result.msg);
				$("#total").html("共收录"+result.msg.split(",").length+"个敏感词");
			}else{
				parent.$.messager.w(data.msg);
			}
		}, 'json');
    });
    
   	function save(){
   		if ($('form').form('validate')) {
   			parent.$.messager.progress({
   				text : '保存中....'
   			});
    		$.ajax({
    			type:"post",
    			data:{content:$("#content").val()},
    			url:sy.contextPath + "/code/saveSensitiveWords",
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
   		location.href = "go?path=common/sensitiveWords";
   	}
   </script>	
  </body>
</html>
