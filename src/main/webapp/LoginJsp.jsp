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
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
<link rel="stylesheet" type="text/css" href="css/font.css" />
<meta charset="UTF-8">
<title>登陆</title>
</head>
	<body>			
	
		${message}
		<form method="post" action="LoginServlet">

			<table class="gridtable" border="1">
				<tr>
					<th>ID:</th>
					<th><input type="text" name="user_id"></th>
				</tr>
				<tr>
					<th>密码:</th>
					<th><input type="password" name="password"></th>
				</tr>
			</table>
			<p>
			<input class="login" id="font1" type="submit" value="提交">
		</form>
	</body>
</html>