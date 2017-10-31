<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="java.util.Calendar"
%>

<html>
<jsp:include page="../header.jsp"></jsp:include>
	<head>
		<meta charset="UTF-8" />
        <title>财务</title>
        <meta name="description" content="Custom Drop-Down List Styling with CSS3" />
        <meta name="author" content="Codrops" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/scroller.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/button.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/warn.css" />
    </head>

    <body>
    	<%String a = (String)request.getAttribute("message");  
		if(a!=null&&!"".equals(a)){ %>
		<div class="alert">
			${message}
		</div>
		<%} %>
		<br><br>
		<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择年月</h2>
	    <div class="container" style="margin-left:40px">
			<div style="float:left">
				<section class="main" >
					<div class="wrapper-demo">
						<div id="dd" class="wrapper-dropdown-3" tabindex="1">
							<span>年</span>
							<ul class="dropdown scroll" style="height:200px;overflow-y:scroll;" id="v1">
								<%int year;
								for(year=2010;year<=2040;year++){%>
									<li><a href="#"><i class="icon-envelope icon-large"></i><%=year%></a></li>
								<%}%>
							</ul>
						</div>
					​</div>
				</section>
			</div>
			<div style="float:left">
				<section class="main">
					<div class="wrapper-demo" >
						<div id="dd1" class="wrapper-dropdown-3" tabindex="2">
							<span>月</span>
							<ul class="dropdown scroll" style="height:200px;overflow-y:scroll;" id="v2">
								<%int month;
								for(month=1;month<=12;month++){%>
								<li><a href="#"><i class="icon-envelope icon-large"></i><%=month%></a></li>
								<%}%>
							</ul>
						</div>
					​</div>
				</section>
			</div>
			<script type="text/javascript">
				var one;
				var two;
				function ons1()
				{
					var ul = document.getElementById('v1');
					var lis = ul.getElementsByTagName('li');
					for(var i=0;i<lis.length;i++)
					{
						lis[i].onclick = function()
						{
							one = this.innerHTML;
						}
					}
					return;
				}
				function ons2()
				{
					var ul = document.getElementById('v2');
					var lis = ul.getElementsByTagName('li');
					for(var i=0;i<lis.length;i++)
					{
						lis[i].onclick = function()
						{
							two = this.innerHTML;
						}
					}
					return;
				}
				ons1();
				ons2();
				function demo()
				{
					document.getElementById("indate").value=one;
        			document.getElementById("outdate").value=two;
					document.CCCC.submit();
					return;
				}
			</script>
			<div style="float:left;margin-top:60px;margin-left:50px;">
				<form  name="CCCC" method="post" action="<%=request.getContextPath()%>/FinaServlet">
					<input type="hidden" id="indate" value="" name="year"/>
					<input type="hidden" id="outdate" value="" name="month"/>
					<input type="button" class="button blue round" value="提交" onclick="demo()"/>
				</form>
			</div>
		</div>
		<!-- jQuery if needed --><script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
		<script type="text/javascript">	
			function DropDown(el)
			{
				this.dd = el;
				this.placeholder = this.dd.children('span');
				this.opts = this.dd.find('ul.dropdown > li');
				this.val = '';
				this.index = -1;
				this.initEvents();
				return;
			}
			DropDown.prototype = 
			{
				initEvents : function()
				{
					var obj = this;
					obj.dd.on('click', function(event)
					{
						$(this).toggleClass('active');
						return false;
					});
					obj.opts.on('click',function()
					{
						var opt = $(this);
						obj.val = opt.text();
						obj.index = opt.index();
						obj.placeholder.text(obj.val);
					});
				},
				getValue : function() {return this.val;},
				getIndex : function() {return this.index;}
			}
			$(function()
			{
				var dd = new DropDown( $('#dd') );
				$(document).click(function()
				{
					$('.wrapper-dropdown-3').removeClass('active');
				});
			});
			$(function() 
			{
				var dd = new DropDown( $('#dd1') );
				$(document).click(function()
				{
					$('.wrapper-dropdown-3').removeClass('active');
				});
			});
		</script>
	</body>
</html>