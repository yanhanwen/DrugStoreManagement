<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dsm.model.dao.impl.SaleDao" %>
<%@page import="com.dsm.model.dao.impl.OnSaleDao" %>
<%@page import="java.util.List" %>
<%@page import="com.dsm.model.entity.Sale" %>
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
<div class="divleft">
<a href="OnSale.jsp" style="margin-left:60px;">在售信息</a><br><br><br><br>
 <a href="sale.jsp" style="margin-left:60px;">销售记录</a>
</div>
<div>
<h1><font class="basic-grey" style="font-size:30px;color:blue;padding-left:100px;">以下是历史销售记录:</font></h1>
</div>
<table border="1" class="altrowstable medicineInfo" id="alternatecolor" >
    <tr>
    <td>流水号</td>
    <td>药品编号</td>
    <td>售货员编号</td>
    <td>销售数量</td>
    <td>单价</td>
    <td>总价</td>
    <td>销售时间</td>
    </tr>
 <%!
    String sql = "select * from Sale";
    String priceSql = "select price from onsale where medicineno =?";
    %>
    <%
    SaleDao dao = new SaleDao ();
    List<Sale> list = dao.getForList(sql);
        for(Sale sale:list){   %>
        <tr>
                <td>
                <label><%=sale.getSerialno()%></label>
                </td>
                <td>
                <label><%=sale.getMedicineno()%></label>
                </td>
                
                <td>
                <label><%=sale.getSalesmanno()%></label>
                </td>
                <td>
               <label><%=sale.getCount()%></label>
                </td>
                 <% 
                OnSaleDao onSaleDao = new OnSaleDao();
                %>
                <td>
                <label><%=onSaleDao.getSingleValue(priceSql, sale.getMedicineno()) %></label>
                </td>
                <td>
                <label><%=sale.getTotal()%></label>
                </td>
                <td>
                <label><%=sale.getSaletime()%></label>
                </td>
        </tr>
        	
    <% }
    %>
    </table>
</body>
</html>