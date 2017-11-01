<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="java.util.List"%>
<%@ page import="com.dsm.model.dao.impl.StoreDao"%>
<%@ page import="com.dsm.model.entity.Store"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分店管理</title>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/button.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/table.css" />
    <style type="text/css">
	input{
	    border:none;}
	    a{
	    text-decoration:none}
	    a:hover {
	    color:red
	}</style>
</head>
<body class="bordered">
	<jsp:include page="../header.jsp"></jsp:include>
	<h1>分店列表</h1>
    <div style="width:100%; height:100%; overflow:scroll;" id="table div">
	<table id="mytable" > 
		<tr>
			<th>分店编号</th>
			<th>店面名称</th>
			<th>省</th>
			<th>市</th>
			<th>区</th>
			<th>街道</th>
			<th>详细地址</th>
			<th>联系电话</th>
			<th>开业日期</th>
			<th>月固定开销</th>
			<th colspan="2">操作</th>
		</tr>
		<%  StoreDao storeDao=new StoreDao();
		    List<Store> list =(List<Store>)storeDao.getForList("select * from Store where isOpen=1");
		%>
		<%	for (Store s : list) {
		%>
		<tr>
			<form action="/website/StoreServlet" method="post">
				<td><input value=<%=s.getStoreno()%> name="StoreNo"
					readonly="readonly" size=2></td>
				<td><input value=<%=s.getStorename()%> name="StoreName"></td>

				<td><input value=<%=s.getProvince()%> name="Province" size=3></td>
				<td><input value=<%=s.getCity()%> name="City" size=5></td>
				<td><input value=<%=s.getDistrict()%> name="District" size=4></td>
				<td><input value=<%=s.getStreet()%> name="Street"></td>
				<td><input value=<%=s.getAddrdetail()%> name="AddrDetail"></td>
				<td><input value=<%=s.getTelephone()%> name="Telephone" size=11></td>
				<td><input value=<%=s.getOpendate()%> readonly="readonly" size=7></td>
				<td><input value=<%=s.getMonthlycost()%> name="Monthlycost" ></td> 
				<input type="hidden" name="method" value="modifyStoreInfo" id="hidden">
				<td><input type="submit" value="修改"></td>
			</form>
			<form action="/website/StoreServlet" method="post">
				<input value=<%=s.getStoreno()%> name="StoreNo"
					readonly="readonly" type="hidden">
				<input type="hidden" name="method" value="closeStore" id="hidden">
				<td><input type="submit" value="删除"></td>
			</form>

		</tr>
		<%
			}
		%>
	</table>
	</div>
	<a href="/website/store/storeadd.jsp">添加分店</a>
	 <%
	String message=(String)request.getAttribute("message");
	if(!(message==null||message==""))
		out.print(message);
	%>
</body>
</html>