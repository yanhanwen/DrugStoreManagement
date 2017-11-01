<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>开分店</title>
</head>

<link rel="stylesheet" href= "<%=request.getContextPath()%>/css/supplierAdd.css">

<script>
function checkAddInfo(){
	storeNo=document.getElementsByName("storeNo")[0].value;
}
</script>

<body style="background:#F5FAFF">
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="add">
			<h1 style="text-align:center">添加</h1>
			<form action="../StoreServlet" method="post">
			<table class="bordered">
				<tr>
			    <td><span style="color:red">*</span>分店编号:</td><td><input name="StoreNo" type="text"/></td>
			    </tr>
			    <tr><td><span style="color:red">*</span>分店名称:</td><td><input name="StoreName"type="text"/></td>
				</tr>
				<tr><td><span style="color:red">*</span>分店电话:</td><td><input name="Telephone" type="text"/></td>
				</tr>
				<tr><td>省:</td><td><input name="Province" type="text"/></td>
				</tr>
				<tr><td>市:</td><td><input name="City" type="text"/></td>
				</tr>
				<tr><td>区:</td><td><input name="District" type="text"/></td>
				</tr>
				<tr><td>街道:</td><td><input name="Street" type="text"/></td>
				</tr>
				<tr><td>详细地址:</td><td><input name="AddrDetail" type="text"/></td>
				</tr>
				<tr><td>月固定支出:</td><td><input name="MonthlyCost" type="text"/></td>
				</tr>
			</table>
			<input type="hidden" name="method" value="addStore">
			<div id="button">
			<input type="submit" name="method" value="添加"></div>
		</form>
		
	</div>
</body>
</html>