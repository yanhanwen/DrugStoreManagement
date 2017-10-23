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
<script src="../js/jquery-3.2.1.min.js"></script>
<script language='javascript'>
	function getChecked(tableName)
	{
		var tbodyObj = document.getElementById(tableName);
        var arr=new Array();
        $("table :checkbox").each(function(key,value)
        {
            if($(value).prop('checked'))
            {
            	for(var i=1; i<9; i++)
            		arr.push(tbodyObj.rows[key+1].cells[i].innerHTML);
            	break;
            }
        })
        return arr;
	}
</script>
<script>
	function storeManagerDefult(arr)
	{
		document.getElementById("storeManagerDefualtNo").value=arr[0];
		document.getElementById("storeManagerDefualtName").value=arr[1];
		if(arr[2]=="男")
			document.getElementById("storeManagerDefualtMale").checked="checked";
		else if(arr[2]=="女")
			document.getElementById("storeManagerDefualtFemale").checked="checked";
		document.getElementById("storeManagerDefualtBirthday").value=arr[3];
		document.getElementById("storeManagerDefualtTelephone").value=arr[4];
		document.getElementById("storeManagerDefualtStoreNo").value=arr[7];
		document.getElementById("storeManagerDefualtSalary").value=arr[8];
	}
</script>

<style> 
	.black_overlay
	{
		display: none;
		position: absolute;
		top: 0%;
		left: 0%;
		width: 100%;
		height: 100%;
		background-color: black;
		z-index:1001;
		-moz-opacity: 0.8;
		opacity:.80;
		filter: alpha(opacity=88);
	}
	.white_content
	{
		display: none;
		position: absolute;
		top: 25%;
		left: 20%;
		width: 55%;
		height: 55%;
		padding: 20px;
		border: 10px solid orange;
		background-color: white;
		z-index:1002;
		overflow: auto;
	}
</style> 

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理</title>
</head>
<body>
	<form method="post" action="PersonnelServlet" id="PersonnelServletForm">
		<input type="hidden" name="method" value="autoQuery" id="method">
		<script>
			document.getElementById("PersonnelServletForm").submit();
		</script>
	<%
		HttpSession session = request.getSession();
		String ID = (String)session.getAttribute("ID");
		if(ID.startsWith("0"))
		{
			List<StoreManager> list1 = (List<StoreManager>)request.getAttribute("storeManager-list");
	%>
		<table id="StoreManagerTable">
			<tr>
				<th></th>
			<%
				for(String s : list1.get(0).getColumns())
				{
					if(s.equals(list1.get(0).getColumns()[8]))
						continue;
			%>
				<th><%=s %></th>
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

		<button onClick="document.getElementById("light").style.display='block'; 
						document.getElementById("fade").style.display='block'">添加
		</button>
		<div id="light" class="white_content">
			编号：<input type="text" name="addStoreManNo">
			姓名：<input type="text" name="addStoreManName">
			性别：<input type="radio" name="addStoreManSex">男	
			<input type="radio" name="addStoreManSex">女
			出生日期：<input type="date" name="addStoreManBirthday">
			联系电话：<input type="text" name="addStoreManTelephone">
			分店编号：<input type="text" name="addStoreNo">
			月薪：<input type="text" name="addStoreManSalary">
			<input type="hidden" name="addStoreManPasswd" value="password">
			头像：<input type="file" name="addIcon">
			<input type="button" value="确定" onClick="document.getElementById("method").value='addStoreManager'; 
							this.form.submit();
							document.getElementById("light").style.display='none'; 
							document.getElementById("fade").style.display='none'">
			<button onClick="document.getElementById("light").style.display='none'; 
							document.getElementById("fade").style.display='none'">取消
			</button>
		</div>
		<div id="fade" class="black_overlay"></div>

		<button onClick="document.getElementById("light-1").style.display='block'; 
						document.getElementById("fade-1").style.display='block';
						var arr=getChecked("StoreManagerTable");
						storeManagerDefault(arr);">修改
		</button>
		<div id="light-1" class="white_content">
			编号：<input type="text" name="no" id="storeManagerDefualtNo" value="" readonly="readonly">
			姓名：<input type="text" name="name" id="storeManagerDefualtName" value="">
			性别：<input type="radio" name="sex" id="storeManagerDefualtMale" checked="">男	
			<input type="radio" name="sex" id="storeManagerDefualtFemale" checked="">女
			出生日期：<input type="date" name="birthday" id="storeManagerDefualtBirthday" value="">
			联系电话：<input type="text" name="telephone" id="storeManagerDefualtTelephone" value="">
			分店编号：<input type="text" name="storeNo" id="storeManagerDefualtStoreNo" value="">
			月薪：<input type="text" name="salary" id="storeManagerDefualtSalary" value="">
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
		<div id="fade-1" class="black_overlay"></div>
		
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
