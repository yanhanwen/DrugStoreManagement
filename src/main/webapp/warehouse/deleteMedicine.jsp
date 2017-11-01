<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="com.dsm.model.entity.*" %>
<%@ page import="com.dsm.model.dao.impl.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>药品出库</title>
	<link rel="stylesheet" href="../css/table.css">
	<link rel="stylesheet" type="text/css" href="../css/button.css" />
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
	${message}
	<div class="bordered">
		<div id="tab">
			<h2 align="center">药品出库</h2>
			<table>
				<thead>
					<tr>
						<th>出库编号</th>
						<th>药品编号</th>
						<th>仓库编号</th>
						<th>店面编号</th>
						<th>进价</th>
						<th>出库数量</th>
						<th>出库时间</th>
						<th>仓库管理员编号</th>
					</tr>
				</thead>
				
				<tbody>
					<%
						LeaveWareDao leaveware=new LeaveWareDao();
						String sql="select * from leaveware";
						List<LeaveWare> leaveware_list=leaveware.getForList(sql);
						for(int i=0;i<leaveware_list.size();i++){
					%>
					<tr>
						<td><%=leaveware_list.get(i).getLeaveno() %></td>
						<td><%=leaveware_list.get(i).getMedicineno() %></td>
						<td><%=leaveware_list.get(i).getWarehouseno()%></td>
						<td><%=leaveware_list.get(i).getStoreno()%></td>
						<td><%=leaveware_list.get(i).getCost() %></td>
						<td><%=leaveware_list.get(i).getLeavecount() %></td>
						<td><%=leaveware_list.get(i).getLeavetime() %></td>
						<td><%=leaveware_list.get(i).getWaremanno() %></td>
					</tr>
					<%} %>
					
				</tbody>
				
			</table>	
			
		</div>
	
	</div>

	<button class="buttontton whitete" type="button" onclick=" ">出库</button>
	
		<form action="WarehouseServlet"method="post">
			<input type="hidden" name="method" value="deleteMedicine">
			药品编号：<input type="text" name="MedicineNo" value="">		
			仓库编号：<input type="text" name="WarehouseNo" value="">
			出库数量：<input type="text" name="Count" value="">
			店面编号：<input type="text" name="StoreNo" value="">
			<input type="submit" value="确定"><input type="reset" value="重置">
		</form>
</body>
</html>