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
    <script type="text/javascript">
    location.href = sy.basePath+'druid';
    </script>	
  </body>
</html>
