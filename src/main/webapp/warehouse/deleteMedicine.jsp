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
<style type="text/css">
#addTable{
position: absolute; 
visibility: hidden; 
overflow: hidden; 
border:1px solid #CCC; 
background-color:#F9F9F9; 
border:1px solid #ccc; 
padding:5px; 
margin-left:150px;
margin-right:300px;

}

</style>
	
	<link rel="stylesheet" href="/website/css/table.css">
	<link rel="stylesheet" type="text/css" href="/website/css/button.css" />
</head>
<body>
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

	  <button class="buttontton whitete" type="button" onclick=" showTable()">出库</button>
	
		<form action="/website/WarehouseServlet" method="post">
			<input type="hidden" name="method" value="deleteMedicine">
			<div id="addTable" class="bordered">
			<table>
				<thead>
					<tr>
						<th>药品编号</th>
						<th>仓库编号</th>
						<th>出库数量</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="MedicineNo" value="010101"></td>
						<td><input type="text" name="WareHouseNo" value="0000"></td>
						<td><input type="text" name="Count" value="5"></td>
					</tr>
				
				</tbody>
			</table>
			<input type="submit" value="提交" class="buttontton whitete" style="margin-left:250px;">
			<input type="button" value="关闭" class="buttontton whitete" onclick="hideTable()">
			</div>
			
		</form>
		<script type="text/javascript">
		function showTable(){ 
			var popUp = document.getElementById("addTable");
			popUp.style.top = "200px"; 
			popUp.style.left = "200px"; 
			popUp.style.visibility = "visible"; 
			}
		function hideTable(){
			var popUp = document.getElementById("addTable");
			popUp.style.visibility="hidden";
		}
		</script>
	
</body>
</html>
