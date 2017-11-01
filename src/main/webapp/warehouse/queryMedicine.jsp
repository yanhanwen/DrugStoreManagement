<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="com.dsm.model.entity.*" %>
<%@ page import="com.dsm.model.dao.impl.*" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<style type="text/css">
.show{
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

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>库存查询</title>
	<link rel="stylesheet" href="../css/table.css">
	<link rel="stylesheet" type="text/css" href="../css/button.css" />
</head>
<body >
<jsp:include page="../header.jsp"></jsp:include>
	<h2 align="center">库存查询</h2>	
	<%!boolean submit=true; 
		String message=null;
		
	%>
	<script type="text/javascript">
		function QATDrugNo(){
				
		}
		function isSubmit(){
			//alert("submit="+submit);
			message=document.getElementById("mno").value;
			//alert("submit="+submit);
		}
		function hello(){
			document.thisform.submit();
		}
		
		function showAddInfo(str){ 
			var popUp = document.getElementById(str);	
			popUp.style.top = "200px"; 
			popUp.style.left = "200px"; 
			popUp.style.visibility = "visible"; 
			} 
		function showtable(str){ 
			var popUp = document.getElementById(str);	
			popUp.style.top = "200px"; 
			popUp.style.left = "200px"; 
			alert("hello");
			popUp.style.visibility = "visible"; 
			} 
		function hideAddInfo(str){ 
			var popUp = document.getElementById(str); 
			popUp.style.visibility = "hidden"; 
			} 
	</script>
	<button class="buttontton whitete" type="button" onclick="showAddInfo('inputMedicineNo')">按照药品编号查询</button>
	<button class="buttontton whitete" type="button" onclick="showAddInfo('inputEnterNo')">按照入库编号查询</button>
	<button class="buttontton whitete" type="button" onclick="showAddInfo('inputStockNo')">按照库存编号查询</button><br><br><br><br><br>
	<!--  <form name="thisform" method="post" >-->
	<div id="inputMedicineNo" class="show">
	<form>
		请输入药品编号：<input   type="text" name="medicineno" >	<br>
		<button class="buttontton whitete" type="button" onclick="this.form.submit()">提交</button>
		
	</form>
	</div>
	
	<div id="inputEnterNo" class="show">
	<form>	
		请输入入库编号：<input   type="text" name="aaaa" >	<br>
		<button class="buttontton whitete" type="button" onclick="this.form.submit()">提交</button>		
	</form>
	</div>
	
	<div id="inputStockNo" class="show">
	<form>
		请输入库存编号：<input   type="text" name="stockno" >	<br>
		<button class="buttontton whitete" type="button" onclick="this.form.submit()">提交</button>	
	</form>
	</div> 

	<button class="buttontton whitete" type="button" onclick="showAddInfo('addMedicineNoTable')">显示药品查询记录</button>
	<button class="buttontton whitete" type="button" onclick="showtable('addEnterNoTable')">显示入库查询记录</button>
	<button class="buttontton whitete" type="button" onclick="showAddInfo('addStockNoTable')">显示库存查询记录</button>
	
	<div id="addMedicineNoTable" class="show" >	
		<div class="bordered">	
			<%
				String medicineno =request.getParameter("medicineno");
				String sql="select * from medicine where medicineno ='"+medicineno +"'";
				MedicineDao medicine=new MedicineDao();
				Medicine medicine2=medicine.getSingleObject(sql);
				if(medicine2!=null){
			%>
		<table>
			<thead>
			<tr>
				<th>药品编号</th>
				<th>药品名称</th>
				<th>药品类别</th>
				<th>生产厂商</th>
				<th>适应症</th>
				<th>存储条件</th>
				<th>保质期</th>
			</tr>
			</thead>
				
			<tbody>
			<tr>				
				<td><%=medicine2.getMedicineno() %></td>	
				<td><%=medicine2.getMedicinename() %></td>
				<td><%=medicine2.getCategory() %></td>
				<td><%=medicine2.getFactory() %></td>
				<td><%=medicine2.getIndication() %></td>
				<td><%=medicine2.getStoragecond() %></td>
				<td><%=medicine2.getLifetime() %></td>
			</tr>	
			</tbody>
		</table>
		</div>
			<%
				}else{
			%>
						<p> 不存在该药品编号</p>	
			<% 		
				}		
			%>	
			
			<input type="button" class="buttontton whitete" value="关闭" onclick="hideAddInfo('addMedicineNoTable')"  style="margin-left:150px;">		
	</div>
	
	
	<div id="addEnterNoTable" class="show" >	
		<div class="bordered">	
		
			<%
				String enterno =request.getParameter("aaaa");
				String sql2="select * from enterware where enterno ='"+enterno +"'";
				EnterWareDao enterware=new EnterWareDao();
				EnterWare enterware2=enterware.getSingleObject(sql2);
				if(enterware2!=null){
			%>
			<table>
			<thead>
			<tr>
				<th>入库编号</th>
				<th>药品编号</th>
				<th>仓库编号</th>
				<th>供应商编号</th>
				<th>入库数量</th>
				<th>入库时间</th>
				<th>生产日期</th>
				<th>进价</th>
				<th>仓库管理员编号</th>
			</tr>
			</thead>
				
			<tbody>
			<tr>				
				<td><%=enterware2.getEnterno() %></td>	
				<td><%=enterware2.getMedicineno() %></td>
				<td><%=enterware2.getWarehouseno() %></td>
				<td><%=enterware2.getSupplierno() %></td>
				<td><%=enterware2.getEntercount() %></td>
				<td><%=enterware2.getEntertime() %></td>
				<td><%=enterware2.getProductdate() %></td>
				<td><%=enterware2.getCost() %></td>
				<td><%=enterware2.getWaremanno() %></td>
			</tr>	
			</tbody>
		</table>
		</div>
			<%
				}else{
			%>
						<p> 不存在该入库编号</p>	
			<% 		
					}		
			%>	
			
			<input type="button" class="buttontton whitete" value="关闭" onclick="hideAddInfo('addEnterNoTable')"  style="margin-left:150px;">		
	</div>
	
	
	<div id="addStockNoTable" class="show" >	
		<div class="bordered">	
		
			<%
				String stockno =request.getParameter("stockno");
				String sql3="select * from stock where stockno ='"+stockno +"'";
				StockDao stock=new StockDao();
				Stock stock2=stock.getSingleObject(sql3);
				if(stock2!=null){
			%>
			<table>
			<thead>
			<tr>
				<th>库存编号</th>
				<th>药品编号</th>
				<th>仓库编号</th>
				<th>货架号</th>
				<th>数量</th>
				<th>进价</th>
				<th>生产日期</th>	
				<th>有效期</th>
			</tr>
			</thead>
				
			<tbody>
			<tr>				
				<td><%=stock2.getStockno() %></td>	
				<td><%=stock2.getMedicineno() %></td>
				<td><%=stock2.getWarehouseno() %></td>
				<td><%=stock2.getShelfno() %></td>
				<td><%=stock2.getCount() %></td>
				<td><%=stock2.getCost() %></td>
				<td><%=stock2.getProductdate() %></td>
				<td><%=stock2.getValidperiod()%></td>
			</tr>	
			</tbody>
		</table>
		</div>
			<%
					}else{
			%>
						<p> 不存在该库存编号</p>	
			<% 		
					}		
			%>	
			
			<input type="button" class="buttontton whitete" value="关闭" onclick="hideAddInfo('addStockNoTable')"  style="margin-left:150px;">		
	</div>
	
</body>
</html>