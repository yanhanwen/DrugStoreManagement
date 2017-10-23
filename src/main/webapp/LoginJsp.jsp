<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<link rel="stylesheet" type="text/css" href="css/warn.css" />
<meta charset="UTF-8">
<title>登陆</title>
	<script type="text/javascript" charset="UTF-8" src="js/login.js"></script>
	<body background="img/bg.png">
		<%if(request.getParameter("message")!=null){ %>
		<div class="alert">
		${message}
		</div>
		<%} %>
	   <div class="content">
           <form action="LoginServlet" method="post" class="login-form">
               <div class="username">
                   <input type="text" name="user_id" value="${user_id}" />
                   <span class="user-icon icon">ID</span>
               </div>
               <div class="password">
                   <input type="password" name="password" placeholder="*******" />
                   <span class="password-icon icon">密码</span>
               </div>
               <div class="account-control">
                   <button type="submit">登陆</button>
               </div>
           </form>
	   </div>
	</body>
</html>