<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.dsm.model.entity.StoreManager"%>
<%@ page import="com.dsm.model.entity.Salesman"%>
<%@ page import="com.dsm.model.entity.WarehouseManager"%>
<%@ page import="com.dsm.model.dao.impl.StoreManagerDao" %>
<%@ page import="com.dsm.model.dao.impl.SalesmanDao" %>
<%@ page import="com.dsm.model.dao.impl.WarehouseManagerDao" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/table.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/gh-buttons.css" />
<script src="../js/jquery-3.2.1.min.js"></script>
<script language='javascript'>
	function getStoreManagerChecked()
	{
		var tbodyObj = document.getElementById('StoreManagerTable');
        var arr=new Array();
        $("table :checkbox").each(function(key,value)
        {
        	if($(value).prop('checked'))
            {
                var a = new Array();
                for(var x = 0; x < tbodyObj.rows[key+1].cells.length; x++)
                    a.push(tbodyObj.rows[key+1].cells[x].innerHTML);
                arr.push(a);
            }
        })
        return arr;
	}
	function getWarehouseManagerChecked()
	{
		var tbodyObj = document.getElementById('WarehouseManagerTable');
        var arr=new Array();
        $("table :checkbox").each(function(key,value)
        {
        	if($(value).prop('checked'))
            {
                var a = new Array();
                for(var x = 0; x < tbodyObj.rows[key+1].cells.length; x++)
                    a.push(tbodyObj.rows[key+1].cells[x].innerHTML);
                arr.push(a);
            }
        })
        return arr;
	}
	function getSalesmanChecked()
	{
		var tbodyObj = document.getElementById('SalesmanTable');
        var arr=new Array();
        $("table :checkbox").each(function(key,value)
        {
        	if($(value).prop('checked'))
            {
                var a = new Array();
                for(var x = 0; x < tbodyObj.rows[key+1].cells.length; x++)
                    a.push(tbodyObj.rows[key+1].cells[x].innerHTML);
                arr.push(a);
            }
        })
        return arr;
	}
</script>
<script>
	function storeManagerSetDefault(arr)
	{
		var a = arr[0];
		document.getElementById("storeManagerDefualtNo").value=a[1];
		document.getElementById("storeManagerDefualtName").value=a[2];
		var male = document.getElementById('storeManagerDefualtMale');
		var female = document.getElementById('storeManagerDefualtFemale')
		if(a[3]=="男")
		{
			if(female.tag == 1)
			{
				female.checked = false;
				female.tag = 0;
			}
			male.checked = true;
			male.tag = 1;
		}
		else if(a[3]=="女")
		{
			if(male.tag == 1)
			{
				male.checked = false;
				male.tag = 0;
			}
			female.checked = true;
			female.tag = 1;
		}
		document.getElementById("storeManagerDefualtBirthday").value=a[4];
		document.getElementById("storeManagerDefualtTelephone").value=a[5];
		document.getElementById("storeManagerDefualtStoreNo").value=a[7];
		document.getElementById("storeManagerDefualtSalary").value=a[8];
	}
</script>
<script>
function salesmanSetDefault(arr)
{
	var a = arr[0];
	document.getElementById("salesmanDefualtNo").value=a[1];
	document.getElementById("salesmanDefualtName").value=a[2];
	var male = document.getElementById('salesmanDefualtMale');
	var female = document.getElementById('salesmanDefualtFemale')
	if(a[3]=="男")
	{
		if(female.tag == 1)
		{
			female.checked = false;
			female.tag = 0;
		}
		male.checked = true;
		male.tag = 1;
	}
	else if(a[3]=="女")
	{
		if(male.tag == 1)
		{
			male.checked = false;
			male.tag = 0;
		}
		female.checked = true;
		female.tag = 1;
	}
	document.getElementById("salesmanDefualtBirthday").value=a[4];
	document.getElementById("salesmanDefualtTelephone").value=a[5];
	document.getElementById("salesmanDefualtStoreNo").value=a[7];
	document.getElementById("salesmanDefualtSalary").value=a[8];
}
</script>
<script>
function warehouseManagerSetDefault(arr)
{
	var a = arr[0];
	document.getElementById("warehouseManagerDefualtNo").value=a[1];
	document.getElementById("warehouseManagerDefualtName").value=a[2];
	var male = document.getElementById('warehouseManagerDefualtMale');
	var female = document.getElementById('warehouseManagerDefualtFemale')
	if(a[3]=="男")
	{
		if(female.tag == 1)
		{
			female.checked = false;
			female.tag = 0;
		}
		male.checked = true;
		male.tag = 1;
	}
	else if(a[3]=="女")
	{
		if(male.tag == 1)
		{
			male.checked = false;
			male.tag = 0;
		}
		female.checked = true;
		female.tag = 1;
	}
	document.getElementById("warehouseManagerDefualtBirthday").value=a[4];
	document.getElementById("warehouseManagerDefualtTelephone").value=a[5];
	document.getElementById("warehouseManagerDefualtStoreNo").value=a[7];
	document.getElementById("warehouseManagerDefualtSalary").value=a[8];
}
</script>
<script>
	function deleteStoreManager(arr)
	{
		for(var i = 0; i < arr.length; i++)
		{
			document.getElementById('deleteStoreManagerNos[]').value = arr[i][1];
		}
	}
</script>
<script>
	function deleteWarehouseManager(arr)
	{
		for(var i = 0; i < arr.length; i++)
		{
			document.getElementById('deleteWarehouseManagerNos[]').value = arr[i][1];
		}
	}
</script>
<script>
	function deleteSalesmanManager(arr)
	{
		for(var i = 0; i < arr.length; i++)
		{
			document.getElementById('deleteSalesmanNos[]').value = arr[i][1];
		}
	}
</script>

<style> 
	.black_overlay
	{
		display: none;
		position: absolute;
		top: 0%;
		left: 0%;
		width: 100%;
		height: 100%;
		background-color: black;
		z-index:1001;
		-moz-opacity: 0.8;
		opacity:.80;
		filter: alpha(opacity=88);
	}
	.white_content
	{
		display: none;
		position: absolute;
		top: 20%;
		left: 35%;
		width: 30%;
		height: 55%;
		padding: 20px;
		border: 10px solid orange;
		background-color: white;
		z-index:1002;
		overflow: auto;
	}
</style> 

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<%
		//String ID = (String)request.getAttribute("ID");
		String ID = "00000001";
		if(ID.startsWith("0"))
		{
			StoreManagerDao storeManager = new StoreManagerDao();
	    	String sql = "select StoreManNo, StoreManName, Sex, Birthday, Telephone, Hiredate, StoreNo, salary "
	    			+ "from StoreManager where OnDuty = 1";
	    	List<StoreManager> list1 = storeManager.getForList(sql, null);
	%>
		<table id="StoreManagerTable" class="bordered">
			<tr>
				<th></th>
			<% 
				String storeManagerCols[] = null;
				storeManagerCols = new String[9];
				storeManagerCols[0] = "编号";
				storeManagerCols[1] = "姓名";
				storeManagerCols[2] = "性别";
				storeManagerCols[3] = "出生日期";
				storeManagerCols[4] = "联系电话";
				storeManagerCols[5] = "就职日期";
				storeManagerCols[6] = "就职店面编号";
				storeManagerCols[7] = "月薪";
				storeManagerCols[8] = "登录密码";
				for(String s : storeManagerCols)
				{
					if(s.equals(storeManagerCols[8]))
						continue;
			%>
				<th><%=s %></th>
			<%
				}
			%>
			</tr>
			<%
				for(StoreManager iter : list1)
				{
			%>
			<tr>
				<td><input type="checkbox" name="<%=iter.getStoremanno() %>" /></td>
				<td><%=iter.getStoremanno() %></td>
				<td><%=iter.getStoremanname() %></td>
				<td><%=iter.getSex() %></td>
				<td><%=iter.getBirthday().toString().substring(0, 10) %></td>
				<td><%=iter.getTelephone() %></td>
				<td><%=iter.getHiredate().toString().substring(0, 10) %></td>
				<td><%=iter.getStoreno() %></td>
				<td><%=iter.getSalary() %></td>
			</tr>
			<%
				}
			%>
		</table>

		<button onClick="document.getElementById('light').style.display='block'; document.getElementById('fade').style.display='block';" class="button big">添加</button>
		<form method="post" action="/website/PersonnelFileUpload" id="AddStoreManForm" enctype="multipart/form-data">
			<div id="light" class="white_content">
				<h2>添加分店经理</h2>
				<input type="hidden" name="method" value="addStoreManager">
				<table>
					<tr>
						<td>编号：</td>
						<td><input type="text" name="addStoreManNo"></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="addStoreManName"></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input type="radio" name="addStoreManSex" value="男">男<input type="radio" name="addStoreManSex" value="女">女</td>
					</tr>
					<tr>
						<td>出生日期：</td>
						<td><input type="date" name="addStoreManBirthday"></td>
					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" name="addStoreManTelephone"></td>
					</tr>
					<tr>
						<td>分店编号：</td>
						<td><input type="text" name="addStoreManStoreNo"></td>
					</tr>
					<tr>
						<td>月薪：</td>
						<td><input type="text" name="addStoreManSalary"></td>
					</tr>
					<tr>
						<td>头像：</td>
						<td><input type="file" name="addIcon"></td>
					</tr>
				</table>
				<input type="hidden" name="addStoreManPasswd" value="password">
				<input type="hidden" name="addStoreManManagerNo" value="<%=ID %>">
				<br><button onClick="this.form.submit();document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'" class="button big">确定</button>
				<br><button type="button" onClick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'" class="button big">取消</button>
			</div>
			<div id="fade" class="black_overlay"></div>
		</form>
		<button onClick="document.getElementById('light-1').style.display='block';document.getElementById('fade-1').style.display='block';var arr=getStoreManagerChecked();storeManagerSetDefault(arr)" class="button big">修改</button>
		<form method="post" action="/website/PersonnelFileUpload" id="ModifyStoreManForm" enctype="multipart/form-data">
			<div id="light-1" class="white_content">
				<h2>修改分店经理信息</h2>
				<input type="hidden" name="method" value="modifyStoreManager">
				<table>
					<tr>
						<td>编号：</td>
						<td><input type="text" name="modifyStoreManNo" id="storeManagerDefualtNo" value="" readonly="readonly"></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="modifyStoreManName" id="storeManagerDefualtName" value=""></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input type="radio" name="modifyStoreManSex" id="storeManagerDefualtMale" value="男" disabled>男<input type="radio" name="sex" id="storeManagerDefualtFemale" value="女" disabled>女</td>
					</tr>
					<tr>
						<td>出生日期：</td>
						<td><input type="date" name="modifyStoreManBirthday" id="storeManagerDefualtBirthday" value=""></td>
					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" name="modifyStoreManTelephone" id="storeManagerDefualtTelephone" value=""></td>
					</tr>
					<tr>
						<td>分店编号：</td>
						<td><input type="text" name="modifyStoreManStoreNo" id="storeManagerDefualtStoreNo" value=""></td>
					</tr>
					<tr>
						<td>月薪：</td>
						<td><input type="text" name="modifyStoreManSalary" id="storeManagerDefualtSalary" value=""></td>
					</tr>
					<tr>
						<td>头像：</td>
						<td><input type="file" name="modifyStoreManIcon"></td>
					</tr>
				</table>
				<br><button onClick="this.form.submit();document.getElementById('light-1').style.display='none';document.getElementById('fade-1').style.display='none'" class="button big">确定</button>
				<br><button type="button" onClick="document.getElementById('light-1').style.display='none';document.getElementById('fade-1').style.display='none'" class="button big">取消</button>
			</div>
			<div id="fade-1" class="black_overlay"></div>
		</form>
		
		<form method="post" action="/website/PersonnelServlet" id="deleteStoreManForm">
			<input type="hidden" name="method" value="deleteStoreManager">
			<input type="hidden" id="deleteStoreManagerNos[]" name="nos" value="">
			<input type="button" value="删除" onClick="var arr = getStoreManagerChecked(); deleteStoreManager(arr); this.form.submit();" class="button big danger">
		</form>
	<%
		WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
		sql = "select WareManNo, WareManName, Sex, Birthday, Telephone, HireDate, WarehouseNo, salary "
				+ "from WarehouseManager where OnDuty = 1";
		List<WarehouseManager> list2 = warehouseManager.getForList(sql, null);
	%>
	<table class="bordered" id="WarehouseManagerTable">
		<tr>
			<th></th>
		<%
			String warehouseManagerCols[] = null;
			warehouseManagerCols = new String[9];
			warehouseManagerCols[0] = "编号";
			warehouseManagerCols[1] = "姓名";
			warehouseManagerCols[2] = "性别";
			warehouseManagerCols[3] = "出生日期";
			warehouseManagerCols[4] = "联系电话";
			warehouseManagerCols[5] = "就职日期";
			warehouseManagerCols[6] = "管理仓库编号";
			warehouseManagerCols[7] = "月薪";
			warehouseManagerCols[8] = "登录密码";
			for(String s : warehouseManagerCols)
			{
				if(s.equals(warehouseManagerCols[8]))
					continue;
		%>
			<th><%=s %></th>
		<%
			}
		%>
		</tr>
		<%
			for(WarehouseManager iter : list2)
			{
		%>
		<tr>
			<td><input type="checkbox" name="<%=iter.getWaremanno() %>" /></td>
			<td><%=iter.getWaremanno() %></td>
			<td><%=iter.getWaremanname() %></td>
			<td><%=iter.getSex() %></td>
			<td><%=iter.getBirthday().toString().substring(0, 10) %></td>
			<td><%=iter.getTelephone() %></td>
			<td><%=iter.getHiredate().toString().substring(0, 10) %></td>
			<td><%=iter.getWarehouseno() %></td>
			<td><%=iter.getSalary() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<button onClick="document.getElementById('light-2').style.display='block'; document.getElementById('fade-2').style.display='block';" class="button big">添加</button>
		<form method="post" action="/website/PersonnelFileUpload" id="AddWareManForm" enctype="multipart/form-data">
			<div id="light-2" class="white_content">
				<h2>添加仓库管理员</h2>
				<input type="hidden" name="method" value="addWarehouseManager">
				<table>
					<tr>
						<td>编号：</td>
						<td><input type="text" name="addWareManNo"></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="addWareManName"></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input type="radio" name="addWareManSex" value="男">男<input type="radio" name="addWareManSex" value="女">女</td>
					</tr>
					<tr>
						<td>出生日期：</td>
						<td><input type="date" name="addWareManBirthday"></td>
					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" name="addWareManTelephone"></td>
					</tr>
					<tr>
						<td>仓库编号：</td>
						<td><input type="text" name="addWareManStoreNo"></td>
					</tr>
					<tr>
						<td>月薪：</td>
						<td><input type="text" name="addWareManSalary"></td>
					</tr>
					<tr>
						<td>头像：</td>
						<td><input type="file" name="addIcon"></td>
					</tr>
				</table>
				<input type="hidden" name="addWareManPasswd" value="password">
				<input type="hidden" name="addWareManManagerNo" value="<%=ID %>">
				<br><button onClick="this.form.submit();document.getElementById('light-2').style.display='none';document.getElementById('fade-2').style.display='none'" class="button big">确定</button>
				<br><button type="button" onClick="document.getElementById('light-2').style.display='none';document.getElementById('fade-2').style.display='none'" class="button big">取消</button>
			</div>
			<div id="fade-2" class="black_overlay"></div>
		</form>
		<button onClick="document.getElementById('light-3').style.display='block';document.getElementById('fade-3').style.display='block';var arr=getWarehouseManagerChecked();warehouseManagerSetDefault(arr)" class="button big">修改</button>
		<form method="post" action="/website/PersonnelFileUpload" id="ModifyWareManForm" enctype="multipart/form-data">
			<div id="light-3" class="white_content">
				<h2>修改仓库管理员信息</h2>
				<input type="hidden" name="method" value="modifyWareManager">
				<table>
					<tr>
						<td>编号：</td>
						<td><input type="text" name="modifyWareManNo" id="warehouseManagerDefaultNo" value="" readonly="readonly"></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="modifyWareManName" id="warehouseManagerDefaultName" value=""></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input type="radio" name="modifyWareManSex" id="warehouseManagerDefaultMale" value="男" disabled>男<input type="radio" name="sex" id="storeManagerDefualtFemale" value="女" disabled>女</td>
					</tr>
					<tr>
						<td>出生日期：</td>
						<td><input type="date" name="modifyWareManBirthday" id="warehouseManagerDefaultBirthday" value=""></td>
					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" name="modifyWareManTelephone" id="warehouseManagerDefaultTelephone" value=""></td>
					</tr>
					<tr>
						<td>仓库编号：</td>
						<td><input type="text" name="modifyWareManStoreNo" id="warehouseManagerDefaultStoreNo" value=""></td>
					</tr>
					<tr>
						<td>月薪：</td>
						<td><input type="text" name="modifyWareManSalary" id="warehouseManagerDefaultSalary" value=""></td>
					</tr>
					<tr>
						<td>头像：</td>
						<td><input type="file" name="modifyWareManIcon"></td>
					</tr>
				</table>
				<br><button onClick="this.form.submit();document.getElementById('light-3').style.display='none';document.getElementById('fade-3').style.display='none'" class="button big">确定</button>
				<br><button type="button" onClick="document.getElementById('light-3').style.display='none';document.getElementById('fade-3').style.display='none'" class="button big">取消</button>
			</div>
			<div id="fade-3" class="black_overlay"></div>
		</form>
		<form method="post" action="/website/PersonnelServlet" id="deleteWareManForm">
			<input type="hidden" name="method" value="deleteWarehouseManager">
			<input type="hidden" id="deleteWarehouseManagerNos[]" name="nos" value="">
			<input type="button" value="删除" onClick="var arr = getWarehouseManagerChecked(); deleteWarehouseManager(arr); this.form.submit();" class="button big danger">
		</form>
	<%
		}
		else
		{
			SalesmanDao salesman = new SalesmanDao();
	    	String sql = "select SalesmanNo, SalesmanName, Sex, Birthday, Telephone, HireDate, StoreNo, salary "
	    			+ "from Salesman where OnDuty = 1";
	    	List<Salesman> list3 = salesman.getForList(sql, null);
	%>
	<table class="bordered" id="SalesmanTable">
		<tr>
			<th></th>
		<%
			String salesmanCols[] = null;
			salesmanCols = new String[9];
			salesmanCols[0] = "编号";
			salesmanCols[1] = "姓名";
			salesmanCols[2] = "性别";
			salesmanCols[3] = "出生日期";
			salesmanCols[4] = "联系电话";
			salesmanCols[5] = "就职日期";
			salesmanCols[6] = "就职店面编号";
			salesmanCols[7] = "月薪";
			salesmanCols[8] = "登录密码";
			for(String s : salesmanCols)
			{
				if(s.equals(salesmanCols[8]))
					continue;
		%>
			<th><%=s %></th>
		<%
			}
		%>
		</tr>
		<%
			for(Salesman iter : list3)
			{
		%>
		<tr>
			<td><input type="checkbox" name="<%=iter.getSalesmanno() %>" /></td>
			<td><%=iter.getSalesmanno() %></td>
			<td><%=iter.getSalesmanname() %></td>
			<td><%=iter.getSex() %></td>
			<td><%=iter.getBirthday().toString().substring(0, 10) %></td>
			<td><%=iter.getTelephone() %></td>
			<td><%=iter.getHiredate().toString().substring(0, 10) %></td>
			<td><%=iter.getStoreno() %></td>
			<td><%=iter.getSalary() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<button onClick="document.getElementById('light-4').style.display='block'; document.getElementById('fade-4').style.display='block';" class="button big">添加</button>
		<form method="post" action="/website/PersonnelFileUpload" id="AddSalesmanForm" enctype="multipart/form-data">
			<div id="light-4" class="white_content">
				<h2>添加店员</h2>
				<input type="hidden" name="method" value="addSalesman">
				<table>
					<tr>
						<td>编号：</td>
						<td><input type="text" name="addSalesmanNo"></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="addSalesmanName"></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input type="radio" name="addSalesmanSex" value="男">男<input type="radio" name="addSalesmanSex" value="女">女</td>
					</tr>
					<tr>
						<td>出生日期：</td>
						<td><input type="date" name="addSalesmanBirthday"></td>
					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" name="addSalesmanTelephone"></td>
					</tr>
					<tr>
						<td>分店编号：</td>
						<td><input type="text" name="addSalesmanStoreNo"></td>
					</tr>
					<tr>
						<td>月薪：</td>
						<td><input type="text" name="addSalesmanSalary"></td>
					</tr>
					<tr>
						<td>头像：</td>
						<td><input type="file" name="addIcon"></td>
					</tr>
				</table>
				<input type="hidden" name="addSalesmanPasswd" value="password">
				<br><button onClick="this.form.submit();document.getElementById('light-4').style.display='none';document.getElementById('fade-4').style.display='none'" class="button big">确定</button>
				<br><button type="button" onClick="document.getElementById('light-4').style.display='none';document.getElementById('fade-4').style.display='none'" class="button big">取消</button>
			</div>
			<div id="fade-4" class="black_overlay"></div>
		</form>
		<button onClick="document.getElementById('light-5').style.display='block';document.getElementById('fade-5').style.display='block';var arr=getSalesmanChecked();salesmanSetDefault(arr)" class="button big">修改</button>
		<form method="post" action="/website/PersonnelFileUpload" id="ModifySalesmanForm" enctype="multipart/form-data">
			<div id="light-5" class="white_content">
				<h2>修改店员信息</h2>
				<input type="hidden" name="method" value="modifySalesman">
				<table>
					<tr>
						<td>编号：</td>
						<td><input type="text" name="modifySalesmanNo" id="salesmanDefualtNo" value="" readonly="readonly"></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="modifySalesmanName" id="salesmanDefualtName" value=""></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input type="radio" name="modifySalesmanSex" id="salesmanDefualtMale" value="男" disabled>男<input type="radio" name="sex" id="salesmanDefualtFemale" value="女" disabled>女</td>
					</tr>
					<tr>
						<td>出生日期：</td>
						<td><input type="date" name="modifySalesmanBirthday" id="salesmanDefualtBirthday" value=""></td>
					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" name="modifySalesmanTelephone" id="salesmanDefualtTelephone" value=""></td>
					</tr>
					<tr>
						<td>分店编号：</td>
						<td><input type="text" name="modifySalesmanStoreNo" id="salesmanDefualtStoreNo" value=""></td>
					</tr>
					<tr>
						<td>月薪：</td>
						<td><input type="text" name="modifySalesmanSalary" id="salesmanDefualtSalary" value=""></td>
					</tr>
					<tr>
						<td>头像：</td>
						<td><input type="file" name="modifySalesmanIcon"></td>
					</tr>
				</table>
				<br><button onClick="this.form.submit();document.getElementById('light-5').style.display='none';document.getElementById('fade-5').style.display='none'" class="button big">确定</button>
				<br><button type="button" onClick="document.getElementById('light-5').style.display='none';document.getElementById('fade-5').style.display='none'" class="button big">取消</button>
			</div>
			<div id="fade-5" class="black_overlay"></div>
		</form>
		
		<form method="post" action="/website/PersonnelServlet" id="deleteSalesmanForm">
			<input type="hidden" name="method" value="deleteSalesman">
			<input type="hidden" id="deleteSalesmanNos[]" name="nos" value="">
			<input type="button" value="删除" onClick="var arr = getSalesmanChecked(); deleteSalesman(arr); this.form.submit();" class="button big danger">
		</form>
	<%} %>
	
</body>
</html>
