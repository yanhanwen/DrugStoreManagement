<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="java.util.Calendar"
%>

<html>
<head>
<meta charset="UTF-8">
<title>财务</title>
</head>
	<body>
		${message}
		<form method="post" action="FinaServlet">
			选择年月：<input type="date" name="time">
			<br>
			<input type="submit" value="提交">
		</form>
	</body>
</html>