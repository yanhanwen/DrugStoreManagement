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
	${time}总收入：${in}
	<br>
	${time}总支出：${out}
	<br>
	${time}净收入：${allin}
	</body>
</html>