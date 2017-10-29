<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="java.util.List"%>
<%@ page import="com.dsm.model.dao.impl.SupplierDao"%>
<%@ page import="com.dsm.model.entity.Supplier"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商管理</title>
<script language="javascript" type="text/javascript">
	function autoQuery() {
		var url = window.location.href;
		window.open("url" + "SupplierAutoServlet?method=autoQuery");
	}
	function alertMessgae(message){
		alert(message);
	}
</script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/button.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/table.css" />
    <style type="text/css">
    input{
    border:none;}
    a{
    text-decoration:none}
    a:hover {
    color:red}</style>
</head>
<body class="bordered">
	<h1>供应商列表</h1>
    <div style="width:100%; height:100%; overflow:scroll;" id="table div">
	<table id="mytable" > 
		<tr>
			<th>供应商编号</th>
			<th>供应商名称</th>
			<th>联系人</th>
			<th>联系人号码</th>
			<th>省</th>
			<th>市</th>
			<th>区</th>
			<th>街道</th>
			<th>详细地址</th>
			<th>评级</th>
			<th>添加日期</th>
			<th>备注</th>
			<th colspan="2">操作</th>
		</tr>
		<%  SupplierDao supplierDao=new SupplierDao();
		    List<Supplier> list =(List<Supplier>)supplierDao.getForList("select * from Supplier where onduty=1");
		%>
		<%	for (Supplier s : list) {
		%>
		<tr>
			<form action="/website/SupplierServlet" method="post">
				<td><input value=<%=s.getSupplierno()%> name="SupplierNo"
					readonly="readonly" size=2></td>
				<td><input value=<%=s.getSuppliername()%> name="SupplierName"></td>
				<td><input value=<%=s.getContactname()%> name="ContactName" size=5></td>
				<td><input value=<%=s.getTelephone()%> name="Telephone" size=11></td>
				<td><input value=<%=s.getProvince()%> name="Province" size=3></td>
				<td><input value=<%=s.getCity()%> name="City" size=5></td>
				<td><input value=<%=s.getDistrict()%> name="District" size=4></td>
				<td><input value=<%=s.getStreet()%> name="Street"></td>
				<td><input value=<%=s.getAddrdetail()%> name="AddrDetail"></td>
				<td><input value=<%=s.getRate()%> name="Rate" size=3></td>
				<td><input value=<%=s.getAdddate()%> readonly="readonly" size=7></td>
				<td><input value=<%=s.getRemark()%> name="Remark" ></td> 
				<input type="hidden" name="method" value="modifySupplier" id="hidden">
				<td><input type="submit" value="修改"></td>
			</form>
			<form action="/website/SupplierServlet" method="post">
				<input value=<%=s.getSupplierno()%> name="SupplierNo"
					readonly="readonly" type="hidden">
				<input type="hidden" name="method" value="deleteSupplier" id="hidden">
				<td><input type="submit" value="删除"></td>
			</form>

		</tr>
		<%
			}
		%>
	</table>
	</div>
	<a href="/website/supplier/SupplierAdd.jsp">添加供应商</a>
	 <%
	String message=(String)request.getAttribute("message");
	if(!(message==null||message==""))
		out.print(message);
	
	%>


</body>
</html>
