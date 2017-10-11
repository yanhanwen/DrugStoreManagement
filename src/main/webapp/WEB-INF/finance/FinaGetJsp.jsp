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
		<%
	    List a = (ArrayList)request.getAttribute("a");
	    for(int i=0;i<a.size();i++)
	    {
	    	
	    %>
	    <table border="1">
	    	<%for(){%>
				<tr>
				<td><%= %>月,收入:<%= %>,支出:<%= %></td>
				</tr>
	    	<%}%>
		</table>
	    <%
	    }
		%>
	</body>
</html>