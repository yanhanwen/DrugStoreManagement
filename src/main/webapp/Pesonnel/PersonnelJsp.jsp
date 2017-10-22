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
		HttpSession session = request.getSession();
		String ID = (String)session.getAttribute("ID");
		if(ID.startsWith("0"))
		{
			List<StoreManager> list1 = (List<StoreManager>)request.getAttribute("storeManager-list");
	%>
	<form method="post" action="PersonnelServlet">
		<input type="hidden" name="method" value="" id="method">
		<table>
			<tr>
				<th></th>
			<%
				for(String s : list1.get(0).getColumns())
				{
					if(s.equals(list1.get(0).getColumns()[8]))
						continue;
			%>
				<th><%=s %>></th>
			<%
				}
			%>
			</tr>
			<%
				for(StoreManager iter : list1)
				{
			%>
			<tr>
				<td><input type="checkbox" name="<%=iter.getStoreManNo() %>" /></td>
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
		<input type="hidden" name="method" value="modifyStoreMananger">
		<button onClick="document.getElementById("light").style.display='block'; 
						document.getElementById("fade").style.display='block'">添加
		</button>
		<div id="light" class="white_content">
			编号：<input type="text" name="no">
			姓名：<input type="text" name="name">
			性别：<input type="radio" name="sex">男	
			<input type="radio" name="sex">女
			出生日期：<input type="date" name="birthday">
			联系电话：<input type="text" name="telephone">
			分店编号：<input type="text" name="storeNo">
			月薪：<input type="text" name="salary">
			<input type="hidden" name="passwd" value="password">
			头像：<input type="file" name="icon">
			<input type="button" value="确定" onClick="document.getElementById("method").value='addStoreManager'; 
							this.form.submit();
							document.getElementById("light").style.display='none'; 
							document.getElementById("fade").style.display='none'">
			<button onClick="document.getElementById("light").style.display='none'; 
							document.getElementById("fade").style.display='none'">取消
			</button>
		</div>
		<div id="fade" class="black_overlay"></div>
		<input type="button" value="修改" onClick="document.getElementById("method").value='modifyStoreManager'; 
							this.form.submit(); ">
		<input type="button" value="删除" onClick="document.getElementById("method").value='deleteStoreManager'; 
							this.form.submit(); ">
		<input type="button" value="查看已离职分店经理" onClick="document.getElementById("method").value='storeManagerLeaved'; 
							this.form.submit(); ">
	</form>
	<%
			List<WarehouseManager> list2 = (List<WarehouseManager>)request.getAttribute("warehouseMananger-list");
	%>
	<table>
		<tr>
			<th></th>
		<%
			for(String s : list2.get(0).getColumns())
			{
				if(s.equals(list2.get(0).getColumns()[8]))
					continue;
		%>
			<th>s</th>
		<%
			}
		%>
		</tr>
		<%
			for(WarehouseManager iter : list2)
			{
		%>
		<tr>
			<td><input type="checkbox" name="<%=iter.getWarehouseManNo() %>" /></td>
			<td><%=iter.getWarehouseManNo() %></td>
			<td><%=iter.getWarehouseManName() %></td>
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
			<th></th>
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
			<td><input type="checkbox" name="<%=iter.getSalesmanNo() %>" /></td>
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
