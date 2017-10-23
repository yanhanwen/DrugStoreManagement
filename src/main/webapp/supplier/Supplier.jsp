<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="java.util.List"%>
<%@ page import="com.dsm.model.entity.Supplier"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript" type="text/javascript">
	function autoQuery() {
		var url = window.location.href;
		window.open("url" + "SupplierServlet?method=autoQuery");
	}
	function alertMessgae(message){
		alert(message);
	}
</script>
</head>
<body>
	<h1>供应商管理</h1>

	<table id="mytable" cellspacing="0px" border="3" bordercolor="red">
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
			<th colspan="3">操作</th>
		</tr>
		<%
		    List<Supplier> list = (List<Supplier>) request.getAttribute("supplier-list");
			for (Supplier s : list) {
		%>
		<tr>
			<form action="SupplierServlet" method="post">
				<td><input value=<%=s.getSupplierNo()%> name="SupplierNo"
					readonly="true"></td>
				<td><input value=<%=s.getSupplierName()%> name="SupplierName"
					readonly="false"></td>
				<td><input value=<%=s.getContactName()%> name="ContactName"
					readonly="false"></td>
				<td><input value=<%=s.getTelephone()%> name="Telephone"
					readonly="false"></td>
				<td><input value=<%=s.getProvince()%> name="Province"
					readonly="false"></td>
				<td><input value=<%=s.getCity()%> name="City" readonly="false"></td>
				<td><input value=<%=s.getDistrict()%> name="District"
					readonly="false"></td>
				<td><input value=<%=s.getStreet()%> name="Street"
					readonly="false"></td>
				<td><input value=<%=s.getAddrDetail()%> name="AddrDetail"
					readonly="false"></td>
				<td><input value=<%=s.getRate()%> name="Rate" readonly="false"></td>
				<td><input value=<%=s.getAddDate()%> readonly="true"></td>
				<td><input value=<%=s.getRemark()%> name="Remark"
					readonly="false"></td> 
				<input type="hidden" name="method"
					value="" id="method">
				<td><a href="#"
					onclick=' document.getElementById("method").value="deleteSupplier";this.form.submit()'>删除</a></td>
				<td><a href="#"
					document.getElementById("method").value="modifySupplier"
					;onclick='this.form.submit()'>修改</a></td>
			</form>

		</tr>
		<%
			}
		%>
	</table>
	<%
	String message=(String)request.getAttribute("message");
	if(!message.equals("autoQuery")){
		out.print(message);
	}
	%>


</body>
</html>