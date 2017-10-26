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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/table.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/button.css" />
	<meta charset="UTF-8">
	<title>财务</title>
</head>
	<body class="bordered">
		<table>
			<tr>
				<td>${time}总收入：${in}</td>
			</tr>
			<tr>
				<td>${time}总支出：${out}</td>
			</tr>
			<tr>
				<td>${time}净收入：${allin}</td>
			</tr>
		</table>
	</body>
</html>