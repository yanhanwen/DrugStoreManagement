<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List"%>
<%@ page import="com.dsm.model.entity.StoreManager"%>
<%@ page import="com.dsm.model.entity.Salesman"%>
<%@ page import="com.dsm.model.entity.WarehouseManager"%>

<html>
<head>
<script language='javascript'>
	function autoQuery()
	{
		var url = window.location.href;
		window.open("url" + "PersonnelAutoServlet?method=autoQuery");
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理</title>
</head>
<body onLoad=autoQuery()>
	<%
		String ID = (String)request.getAttribute("ID");
		if(ID.startsWith("0"))
		{
			List<StoreManager> list1 = (List<StoreManager>)request.getAttribute("storeManager-list");
	%>
	<table>
		<tr>
		<%
			for(String s : list1.get(0).getColumns())
			{
				if(s.equals(list1.get(0).getColumns()[8]))
					continue;
		%>
		<th>s</th>
		<%
			}
		%>
		</tr>
		<%
			for(StoreManager iter : list1)
			{
		%>
		<tr>
			<td><%=iter.getStoreManNo() %></td>
			<td><%=iter.getStoreManName() %></td>
			<td><%=iter.getSex() %></td>
			<td><%=iter.getBirthday().toString() %></td>
			<td><%=iter.getTelephone() %></td>
			<td><%=iter.getHireDate().toString() %></td>
			<td><%=iter.getStoreNo() %></td>
			<td><%=iter.getSalary() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<form method="post" action="PersonnelServlet">
		
	</form>
	<%
			List<WarehouseManager> list2 = (List<WarehouseManager>)request.getAttribute("warehouseMananger-list");
	%>
	<table>
		<tr>
		<%
			for(String s : list1.get(0).getColumns())
			{
				if(s.equals(list1.get(0).getColumns()[8]))
					continue;
		%>
		<th>s</th>
		<%
			}
		%>
		</tr>
		<%
			for(StoreManager iter : list1)
			{
		%>
		<tr>
			<td><%=iter.getStoreManNo() %></td>
			<td><%=iter.getStoreManName() %></td>
			<td><%=iter.getSex() %></td>
			<td><%=iter.getBirthday().toString() %></td>
			<td><%=iter.getTelephone() %></td>
			<td><%=iter.getHireDate().toString() %></td>
			<td><%=iter.getStoreNo() %></td>
			<td><%=iter.getSalary() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
		else
		{
			List<Salesman> list1 = (List<Salesman>)request.getAttribute("salesman-list");
	%>
	<table>
		<tr>
		<%
			for(String s : list1.get(0).getColumns())
			{
				if(s.equals(list1.get(0).getColumns()[8]))
					continue;
		%>
		<th>s</th>
		<%
			}
		%>
		</tr>
		<%
			for(Salesman iter : list1)
			{
		%>
		<tr>
			<td><%=iter.getSalesmanNo() %></td>
			<td><%=iter.getSalesmanName() %></td>
			<td><%=iter.getSex() %></td>
			<td><%=iter.getBirthday().toString() %></td>
			<td><%=iter.getTelephone() %></td>
			<td><%=iter.getHireDate().toString() %></td>
			<td><%=iter.getStoreNo() %></td>
			<td><%=iter.getSalary() %></td>
		</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>
