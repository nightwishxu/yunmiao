<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/static/admin/jsp/include.jsp"%>
<script type="text/javascript">
	var submitForm = function() {
		if ($('form').form('validate')) {
			var url = sy.contextPath + '/wx/save';
			var obj = sy.serializeObject($('form'));
			$.post(url,obj, function(result) {
				if (result.code == 0) {
					parent.$.messager.i('设置成功！');
				} else {
					parent.$.messager.e('操作失败,'+result.msg);
				}
			}, 'json');
		}
	};

	$(function() {
		$.post(sy.contextPath + '/wx/findById', {
		}, function(result) {
			if (result) {
				$("#url").html(result.url);
				$("#token").html(result.token);
				$('form').form('load', result);
			}
		}, 'json');
	});

</script>
</head>
<body>
	<form id="form" method="post">
        <input name="userId" type="hidden"/>
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
            	<tr>
            		<th style="width:100px;">注意事项:</th>
            		<td>
            		1. 要在微信公众平台“开发模式”下使用自定义菜单，首先要在公众平台申请自定义菜单使用的AppId和AppSecret，然后填入下边表单。<br/>
					2. 提交完id和密钥后，可以在【菜单设置】中设置各个菜单项，然后进行发布，您的微信公众号便支持自定义菜单了。<br/>
					3. 公众平台规定，菜单发布24小时后生效。如果为新增粉丝，则可马上看到菜单。
            		</td>
            	</tr>
            	<tr>
            		<th style="width:100px;">接口配置信息:</th>
            		<td>
            			<b>URL：</b><span id="url"></span><br/>
            			<b>Token：</b><span id="token"></span>
            		</td>
            	</tr>
                <tr>
                	<th style="width:100px;">appID:</th>
                	<td>
				  		<input id="appid" name="appid" class="easyui-textbox" data-options="required:true" style="width:90%;" prompt="公众平台申请到的AppId" missingMessage="请输入appID"/>
				  	</td>
                </tr>
                <tr>
                	<th style="width:100px;">appsecret:</th>
                	<td>
				  		<input id="appsecret" name="appsecret" class="easyui-textbox" data-options="required:true" style="width:90%;" prompt="公众平台申请到的AppSecret" missingMessage="请输入appsecret"/>
				  	</td>
                </tr>
                <tr>
                	<th colspan="2" style="text-align: center;"><a class="easyui-linkbutton" onclick="submitForm()" data-options="iconCls:'fa-save'">保存</a></th>
                </tr>
            </table>
        </div>
	</form>
</body>
</html>