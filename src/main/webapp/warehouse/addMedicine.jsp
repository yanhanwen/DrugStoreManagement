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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<title>药品入库</title>
</style>
	<link rel="stylesheet" href="/website/css/table.css">
	<link rel="stylesheet" type="text/css" href="/website/css/button.css" />
	
</head>
<body  >
		${message}
		<!--  
		<form action="../WarehouseServlet" method="post">
			<input type="hidden" name="method" value="addMedicine"> 
		</form>
		-->
		<% 	String message=(String)request.getAttribute("message");
		%>	
		<div class="bordered">
		<div id="tab" >
			<h2 align="center">药品入库</h2>
			<table >
			
			<thead>
			<tr>
				<th >入库编号</th>
				<th >药品编号</th>		
				<th >仓库编号</th>
				<th >供应商编号</th>
				<th >入库数量</th>
				<th>入库时间</th>
				<th >生产日期</th>
				<th >进价</th>
				<th >仓库管理员编号</th>			
			</tr>
			</thead>
			<tbody>
			<%
				EnterWareDao enterware=new EnterWareDao();
				String sql="select * from enterware";
				List<EnterWare> enterware_list=enterware.getForList(sql);
				for(int i=0;i<enterware_list.size();i++){		
			%>  
			<tr>
				<td><%=enterware_list.get(i).getEnterno() %></td>
				<td><%=enterware_list.get(i).getMedicineno() %></td>
				<td><%=enterware_list.get(i).getWarehouseno() %></td>			  	
				<td><%=enterware_list.get(i).getSupplierno() %></td>
				<td><%=enterware_list.get(i).getEntercount() %></td>
				<td><%=enterware_list.get(i).getEntertime() %></td>
			  	<td><%=enterware_list.get(i).getProductdate() %></td>
				<td><%=enterware_list.get(i).getCost() %></td>
				<td><%=enterware_list.get(i).getWaremanno() %></td>
			
			</tr>
			<%} %>
			</tbody>		
			</table>
		</div>
			
			<div id="addTable" class="bordered">
				<h2 class="basic-green addh1">请输入要入库的药品信息:</h2>
				<form action="/website/WarehouseServlet" method="post" >
					<input type="hidden" name="method" value="addMedicine">

					
					<span >药品编号</span> &nbsp;&nbsp;<input type="text" name="MedicineNo"   size="10">&nbsp;&nbsp;&nbsp;&nbsp;
 					<span >适应症</span> &nbsp;&nbsp;&nbsp; <input type="text" name="Indication"  size="10"><br>
				    <span >药品名称</span> &nbsp;&nbsp;<input type="text" name="MedicineName" size="10">&nbsp;&nbsp;&nbsp;&nbsp;
					<span >存储条件</span> <input type="text" name="StorageCond" size="10"><br>
	       			<span >药品类别</span> &nbsp;&nbsp;<input type="text" name="Category" size="10">&nbsp;&nbsp;&nbsp;&nbsp;
	       			<span >进价</span>   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Cost"  size="10"><br>
	       			<span >仓存编号</span> &nbsp;&nbsp;<input type="text" name="WarehouseNo" size="10">&nbsp;&nbsp;&nbsp;&nbsp;
	       			<span >入库数量</span> <input type="text" name="EnterCount" size="10"><br>
	       			<span >供应商编号</span><input type="text" name="SupplierNo" size="10">&nbsp;&nbsp;&nbsp;&nbsp;
	       			<span >生产日期</span> &#9;<input type="text" name="ProductDate" size="10"><br>
	       			<span >生产厂商</span> &nbsp;&nbsp;<input type="text" name="Factory" size="10">&nbsp;&nbsp;&nbsp;&nbsp;
	       			<span >有效期</span>  &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="LifeTime" size="10"><br>
	       			<span>仓库环境</span> &nbsp; <input type="text" name="Condition" size=10><br>
	       			<input type="submit"  value="确定" style="margin-left:250px;" >       
	       			<input type="reset" value="重置" >
	       			<input type="button" value="关闭" onclick="hideAddInfo()" >
				</form>
			</div>
		</div>	
		<script>
			function showAlert(){
				var message=<%=message%>;
				if(message!=null){
					alert("message="+message);
				}
			}
			
			function showAddInfo(w,h){ 
				//alert("123");
				var baseText = null;
				var popUp = document.getElementById("addTable");
				popUp.style.top = "200px"; 
				popUp.style.left = "200px"; 
				popUp.style.width = w + "px"; 
				popUp.style.height = h + "px"; 
				//if (baseText == null) 
					//baseText = popUp.innerHTML; 
				//popUp.innerHTML = baseText + "<div id=\"statusbar\"><button onclick=\"hideAddInfo();\">关闭<button></div>"; 
				
				//var sbar = document.getElementById("statusbar"); 
				//sbar.style.marginTop = (parseInt(h)-40) + "px"; 
				popUp.style.visibility = "visible"; 
				} 
			function hideAddInfo(){ 
				var popUp = document.getElementById("addTable"); 
				popUp.style.visibility = "hidden"; 
				} 
			function refreshPage(){
				window.location.reload();
			}
			
		</script>	
		<button class="buttontton whitete" type="button" onclick="showAlert()">结果</button>
		<button class="buttontton  whitete" type="button" onclick="showAddInfo()" >添加行</button>
		
</body>
</html>
