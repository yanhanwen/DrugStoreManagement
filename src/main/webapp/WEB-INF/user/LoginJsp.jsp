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
		<form method="post" action="LoginServlet">
			ID:<input type="text" name="user_id">
			密码:<input type="text" name="password">
			<input type="submit">
	</body>
</html>