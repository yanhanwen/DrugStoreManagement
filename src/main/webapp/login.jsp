<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/warn.css" />

<title>登陆</title><%System.out.println(request.getContextPath());%>
	<%String a = (String)request.getAttribute("message");  
		if(a!=null&&!"".equals(a)){ %>
		<div class="alert">
			${message}
		</div>
		<%} %>
	<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/login.js"></script>
</head>
	<body background="img/bg.png">
	   <div class="content">
           <form action="LoginServlet" method="post" class="login-form">
               <div class="username">
                   <input type="text" name="user_id" maxlength=8 value="${user_id}" />
                   <span class="user-icon icon">ID</span>
               </div>
               <div class="password">
                   <input type="password" name="password" maxlength=16 placeholder="*******" />
                   <span class="password-icon icon">密码</span>
               </div>
               <div class="account-control">
                   <button type="submit">登陆</button>
               </div>
           </form>
	   </div>
	</body>
</html>