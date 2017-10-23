<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<div>
		<form action="SupplierServlet" method="post">
		    <span>供应商编号:</span><input id="ph" type="text"/>
		    <br>
			<span>供应商姓名:</span><input id="ph" type="text"/>
			<br>
			<span>联系人:</span><input id="ph" type="text"/>
			<br>
			<span>联系人号码:</span><input id="ph" type="text"/>
			<br>
			<span>省:</span><input id="ph" type="text"/>
			<br>
			<span>市:</span><input id="ph" type="text"/>
			<br>
			<span>区:</span><input id="ph" type="text"/>
			<br>
			<span>街道:</span><input id="ph" type="text"/>
			<br>
			<span>详细地址:</span><input id="ph" type="text"/>
			<br>
			<span>评级:</span><input id="ph" type="text"/>
			<br>
			<span>备注:</span><input id="ph" type="text"/>
			<br>
			<input type="hidden" name="method" value="addSupplier">
			<input type="submit" name="method" value="添加"></
	</form>
	</div>
</body>
</html>