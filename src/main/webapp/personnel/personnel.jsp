<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.dsm.model.entity.StoreManager"%>
<%@ page import="com.dsm.model.entity.Salesman"%>
<%@ page import="com.dsm.model.entity.WarehouseManager"%>
<%@ page import="com.dsm.model.dao.impl.StoreManagerDao" %>
<%@ page import="com.dsm.model.dao.impl.SalesmanDao" %>
<%@ page import="com.dsm.model.dao.impl.WarehouseManagerDao" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/table.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/button.css" />
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
		top: 20%;
		left: 35%;
		width: 30%;
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
	<%
		//String ID = (String)request.getAttribute("ID");
		String ID = "00000001";
		if(ID.startsWith("0"))
		{
			StoreManagerDao storeManager = new StoreManagerDao();
	    	String sql = "select StoreManNo, StoreManName, Sex, Birthday, Telephone, Hiredate, StoreNo, salary "
	    			+ "from StoreManager where OnDuty = 1";
	    	List<StoreManager> list1 = storeManager.getForList(sql, null);
			if(list1 == null)
			{
				System.out.println("null");
			}
	%>
		<table id="StoreManagerTable" class="bordered">
			<tr>
				<th></th>
			<% 
				String storeManagerCols[] = null;
				storeManagerCols = new String[9];
				storeManagerCols[0] = "编号";
				storeManagerCols[1] = "姓名";
				storeManagerCols[2] = "性别";
				storeManagerCols[3] = "出生日期";
				storeManagerCols[4] = "联系电话";
				storeManagerCols[5] = "就职日期";
				storeManagerCols[6] = "就职店面编号";
				storeManagerCols[7] = "月薪";
				storeManagerCols[8] = "登录密码";
				for(String s : storeManagerCols)
				{
					if(s.equals(storeManagerCols[8]))
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
				<td><input type="checkbox" name="<%=iter.getStoremanno() %>" /></td>
				<td><%=iter.getStoremanno() %></td>
				<td><%=iter.getStoremanname() %></td>
				<td><%=iter.getSex() %></td>
				<td><%=iter.getBirthday().toString() %></td>
				<td><%=iter.getTelephone() %></td>
				<td><%=iter.getHiredate().toString() %></td>
				<td><%=iter.getStoreno() %></td>
				<td><%=iter.getSalary() %></td>
			</tr>
			<%
				}
			%>
		</table>

		<button onClick="document.getElementById('light').style.display='block'; document.getElementById('fade').style.display='block';">添加</button>
		<form method="post" action="<%=request.getContextPath()%>/PersonnelServlet" id="AddStoreManForm">
			<div id="light" class="white_content">
				<h2>添加分店经理</h2>
				<input type="hidden" name="method" value="addStoreManager">
				<table>
					<tr>
						<td>编号：</td>
						<td><input type="text" name="addStoreManNo"></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="addStoreManName"></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input type="radio" name="addStoreManSex">男<input type="radio" name="addStoreManSex">女</td>
					</tr>
					<tr>
						<td>出生日期：</td>
						<td><input type="date" name="addStoreManBirthday"></td>
					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" name="addStoreManTelephone"></td>
					</tr>
					<tr>
						<td>分店编号：</td>
						<td><input type="text" name="addStoreManStoreNo"></td>
					</tr>
					<tr>
						<td>月薪：</td>
						<td><input type="text" name="addStoreManSalary"></td>
					</tr>
					<tr>
						<td>头像：</td>
						<td><input type="file" name="addIcon"></td>
					</tr>
				</table>
				<input type="hidden" name="addStoreManPasswd" value="password">
				<input type="hidden" name="addStoreManManagerNo" value="<%=ID %>>">
				<br><button onClick="document.getElementById('method').value='addStoreManager';this.form.submit();document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">确定</button>
				<br><button type="button" onClick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">取消</button>
			</div>
		</form>
			<div id="fade" class="black_overlay"></div>
			<button onClick="document.getElementById('light-1').style.display='block';document.getElementById('fade-1').style.display='block';var arr=getChecked('StoreManagerTable');storeManagerDefault(arr)">修改</button>
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
		WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
		sql = "select WareManNo, WareManName, Sex, Birthday, Telephone, HireDate, WarehouseNo, salary "
				+ "from WarehouseManager where OnDuty = 1";
		List<WarehouseManager> list2 = warehouseManager.getForList(sql, null);
	%>
	<table class="bordered">
		<tr>
			<th></th>
		<%
			String warehouseManagerCols[] = null;
			warehouseManagerCols = new String[9];
			warehouseManagerCols[0] = "编号";
			warehouseManagerCols[1] = "姓名";
			warehouseManagerCols[2] = "性别";
			warehouseManagerCols[3] = "出生日期";
			warehouseManagerCols[4] = "联系电话";
			warehouseManagerCols[5] = "就职日期";
			warehouseManagerCols[6] = "管理仓库编号";
			warehouseManagerCols[7] = "月薪";
			warehouseManagerCols[8] = "登录密码";
			for(String s : warehouseManagerCols)
			{
				if(s.equals(warehouseManagerCols[8]))
					continue;
		%>
			<th><%=s %></th>
		<%
			}
		%>
		</tr>
		<%
			for(WarehouseManager iter : list2)
			{
		%>
		<tr>
			<td><input type="checkbox" name="<%=iter.getWaremanno() %>" /></td>
			<td><%=iter.getWaremanno() %></td>
			<td><%=iter.getWaremanname() %></td>
			<td><%=iter.getSex() %></td>
			<td><%=iter.getBirthday().toString() %></td>
			<td><%=iter.getTelephone() %></td>
			<td><%=iter.getHiredate().toString() %></td>
			<td><%=iter.getWarehouseno() %></td>
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
			SalesmanDao salesman = new SalesmanDao();
	    	String sql = "select SalesmanNo, SalesmanName, Sex, Birthday, Telephone, HireDate, StoreNo, salary "
	    			+ "from Salesman where OnDuty = 1";
	    	List<Salesman> list3 = salesman.getForList(sql, null);
	%>
	<table class="bordered">
		<tr>
			<th></th>
		<%
			String salesmanCols[] = null;
			salesmanCols = new String[9];
			salesmanCols[0] = "编号";
			salesmanCols[1] = "姓名";
			salesmanCols[2] = "性别";
			salesmanCols[3] = "出生日期";
			salesmanCols[4] = "联系电话";
			salesmanCols[5] = "就职日期";
			salesmanCols[6] = "就职店面编号";
			salesmanCols[7] = "月薪";
			salesmanCols[8] = "登录密码";
			for(String s : salesmanCols)
			{
				if(s.equals(salesmanCols[8]))
					continue;
		%>
			<th><%=s %></th>
		<%
			}
		%>
		</tr>
		<%
			for(Salesman iter : list3)
			{
		%>
		<tr>
			<td><input type="checkbox" name="<%=iter.getSalesmanno() %>" /></td>
			<td><%=iter.getSalesmanno() %></td>
			<td><%=iter.getSalesmanname() %></td>
			<td><%=iter.getSex() %></td>
			<td><%=iter.getBirthday().toString() %></td>
			<td><%=iter.getTelephone() %></td>
			<td><%=iter.getHiredate().toString() %></td>
			<td><%=iter.getStoreno() %></td>
			<td><%=iter.getSalary() %></td>
		</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>
