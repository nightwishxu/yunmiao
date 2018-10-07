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
	var editor;
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var obj=sy.serializeObject($('form'));
			var url=sy.contextPath + '/coupon/save';
			obj.fid = 0
			obj.type = 2;
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

    $(function() {
        if (id != '') {
            parent.$.messager.progress({
                text : '数据加载中....'
            });
            $.post(sy.contextPath + '/coupon/findById', {
                id : id
            }, function(result) {
                parent.$.messager.progress('close');
                if (result) {
                    $('form').form('load', result);
                }
            }, 'json');

        }

        /*$("#fid").combobox({
            url:sy.contextPath + '/videoOnline/listName.do',
            valueField:'id',
            textField:'title',
            onChange:function(data){
            }
        });*/
    });

	
</script>
</head>
<body>
	<form id="form" method="post">
        <input name="id" type="hidden" />
        <div style="padding:15px;font-size: 12px">
            <table style="table-layout:fixed;" border="0" cellspacing="0" class="formtable">
               <tr>
                    <th style="width:100px;">优惠金额：</th>
                    <td>   
                    	 <input class="easyui-numberbox" id="full" name="full" data-options="required:true,validType:['length[0,10]']" style="width:100%"/>
                    </td>
               </tr>
               <%--<tr>
                    <th style="width:100px;">减：</th>
                    <td>   
                    	 <input class="easyui-numberbox" id="value" name="value" data-options="required:true,validType:['length[0,10]']"   style="width:100%"/>
                    </td>
                </tr>--%>
                <tr>
                    <th style="width:100px;">领取后有效天数：</th>
                    <td>   
                   	     <input class="easyui-numberbox" name="days" data-options="required:true,validType:['length[1,11]']" style="width:100%"/>
                    </td>                                      
                </tr>
            </table>
        </div>
	</form>
</body>
</html>
