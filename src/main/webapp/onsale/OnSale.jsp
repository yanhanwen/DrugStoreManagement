<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dsm.model.dao.impl.OnSaleDao" %>
<%@page import="java.util.List" %>
<%@page import="com.dsm.model.entity.OnSale" %>
<%@page import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <link rel="stylesheet" type="text/css" href="../css/onsale.css" />
     <script type="text/javascript" src="../js/OnSale.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="div1">
<img alt="" src="../img/title.png" style="width:100%;height:180px">
</div>
<div class="formDiv1">
	    <form action="OnSale.jsp" method="post">
	       <span class="basic-grey">药品编号</span> <input type="text" name="medicineNo" class="inputmargin basic-grey1">
	        <span class="basic-grey">分店编号</span><input type="text" name="storeNo" class="inputmargin basic-grey1">
	       <span class="basic-grey"> 药架编号</span><input type="text" name="frameNo" class="inputmargin basic-grey1">
	     <input type="submit" name="search" value="查询" class="button white">
	    </form>
    </div>
  
<hr style="height:1px;border:none;border-top:1px solid #ccc;width:87%;margin-left:200px;" />

<table border="1" class="altrowstable medicineInfo" id="alternatecolor" >
    <tr>
    <td>在售编号</td>
    <td>药品编号</td>
    <td>药店编号</td>
    <td>在售数量</td>
    <td>售价</td>
    <td>进价</td>
    <td>有效期</td>
    <td>药架编号</td>
    <td>是否选中</td>
    </tr>
    <%!
    String frameno = null;
    String medicineno = null;
    String storeno = null;
    %>
    <%
    frameno = request.getParameter("frameNo");
    medicineno =request.getParameter("medicineNo");
    storeno =request.getParameter("storeNo");
    %>
    <%!
    String sql = "select * from OnSale where medicineno like '%'||?||'%' and storeno like '%'||?||'%' and frameno like'%'||?||'%'";
    %>
    <%
    OnSaleDao dao = new OnSaleDao ();
    List<OnSale> list = dao.getForList(sql,medicineno,storeno,frameno);
        for(OnSale onSale:list){       
                       %>
        <tr">
                <td>
                <label><%=onSale.getOnsaleno()%></label>
                </td>
                <td>
                <label><%=onSale.getMedicineno()%></label>
                </td>
                <td>
                <label><%=onSale.getStoreno()%></label>
                </td>
                <td>
               <label><%=onSale.getCount()%></label>
                </td>
                <td>
                <label><%=onSale.getPrice()%></label>
                </td>
                <td>
                <label><%=onSale.getCost()%></label>
                </td>
                 <td>
                <label><%=onSale.getValidperiod()%></label>
                </td>
                <td>
               <label><%=onSale.getFrameno()%></label>
                </td>
                 <td>
               <label><input type="checkbox"></label>
                </td>
        </tr>
        	
    <% }
    %>


</table>
<input type="button" name="addMedicine" value="更新上架" class="button white" style="margin-left:480px;margin-top:20px" onclick="showAddInfo()">
<input type="button" name="sellMedicine" value="售出" class="button white" onclick="showSellInfo()">
<div id="addInfo">
<h1 class="basic-grey addh1">请输入要上架的药品信息:</h1>
<form action="../OnSaleServlet" method="post" name="addMedicine" style="align-content: center;margin-top:20px;" id="addMedicineForm">
<span class="basic-grey cost" id="No1">在售编号</span> <input type="text" name="onSaleNo" class="basic-grey1" id="onSaleNo">
 &nbsp&nbsp<span class="basic-grey cost" id="No2">药品编号</span><input type="text" name="medicineNo" class="basic-grey1" id="medicineNo"><br>
	       <span class="basic-grey cost" id="No3"> 店面编号</span>&nbsp<input type="text" name="storeNo" class="basic-grey1" id="storeNo">
 &nbsp&nbsp<span class="basic-grey cost" id="No4">上架数量</span><input type="text" name="saleNum" class="basic-grey1" id="saleNum"><br>
	       <span class="basic-grey cost" id="No5" >售价</span><input type="text" name="price" class="basic-grey1" id="price">
	       <span class="basic-grey cost" id="No6" >进价</span><input type="text" name="cost" class="basic-grey1" id="cost">
	       <span class="basic-grey cost" id="No7">有效期</span><input type="text" name="validPeriod" class="basic-grey1" id="validPeriod">
	       <span class="basic-grey cost" id="No8">售架号</span><input type="text" name="frameNo" class="basic-grey1" id="frameNo"><br>
	       <input type="hidden"  name="choose" value="addMedicine">
	       <input type="button" value="确定" class="button white" onclick="checkAddInfo()">       
	       <input type="reset" class="button white">
	       <input type="button" class="button white" value="取消" onclick="hideAddInfo()">
</form>
</div>

<%!
HttpSession  session=null;
%>
 <%
 session= request.getSession();
%>
<input type="hidden" id="message" value="<%=session.getAttribute("message")%>">
<div id="sellInfo">
<h1 class="basic-grey sellh1">请输入要售出的药品信息:</h1>
<form action="../OnSaleServlet" method="post" name="sellMedicine" style="align-content: center;margin-top:20px;" id="sellMedicineForm">
 &nbsp&nbsp<span class="basic-grey cost" id="No1">在售编号</span> <input type="text" name="onSaleNo" class="basic-grey1" id="sellNo">
 &nbsp&nbsp<span class="basic-grey cost" id="No4">售出数量</span><input type="text" name="saleNum" class="basic-grey1" id="sellNum"><br>
	            <input type="hidden"  name="choose" value="sellMedicineForm">
	       <input type="submit" value="确定" class="button white" onclick="showMessage()">       
	       <input type="reset" class="button white">
	       <input type="button" class="button white" value="取消" onclick="hideSellInfo()">
</form>
</div>
</body>
</html>
