<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加供应商</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/supplierAdd.css">

<script>
function checkAddInfo(){
	supplierNo=document.getElementsByName("SupplierNo")[0].value;
}
</script>
<body style="background:#F5FAFF">
		<div id="add">
		<h1 style="text-align:center">添加供应商</h1>
		<form action="../SupplierServlet" method="post">
		<table class="bordered">
		   <tr>
		    <td>供应商编号:</td><td><input name="SupplierNo" type="text" maxlength=2 onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/"/></td>
		    </tr>
			<tr><td>供应商姓名:</td><td><input name="SupplierName"type="text"/></td>
			</tr>
			<tr><td>联系人:</td><td><input name="ContactName" type="text"/></td>
			</tr>
			<tr><td>联系人号码:</td><td><input name="Telephone" type="text"/></td>
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
			<tr><td>评级:</td><td><input name="Rate" type="text"/></td>
			</tr>
			<tr><td>备注:</td><td><input name="Remark" type="text"/></td>
			</tr>
			</table>
			<input type="hidden" name="method" value="addSupplier">
			<div id="button">
			<input type="submit" name="method" value="添加"></div>
	</form>
	
	</div>
</body>
</html>