<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="java.util.Calendar"
%>


<html>
<script type="text/javascript">
function demo()
{
	document.getElenmentById("indate").value="";
	document.getElenmentById("outdate").value="";
	document.CCCC.submit();
}
</script>
    <head>

	<meta charset="UTF-8" />
        <title>财务</title>

        <meta name="description" content="Custom Drop-Down List Styling with CSS3" />

        <meta name="author" content="Codrops" />

        <link rel="shortcut icon" href="../favicon.ico"> 

        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/scroller.css" />
    </head>

    <body>
	<br><br>
	
	<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择年月</h2>
        <div class="container">
			<div style="float:left">
			<section class="main" >

				<div class="wrapper-demo">

					<div id="dd" class="wrapper-dropdown-3" tabindex="1">

						<span>年</span>

						<ul class="dropdown scroll-1" style="height:200px;overflow-y:scroll;" id="v1">
							
							<%for(int year=2010;year<=2040;year++){%>
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

						<ul class="dropdown scroll-1" style="height:200px;overflow-y:scroll;" id="v2">
							<%for(int month=1;month<=12;month++){%>
							<li><a href="#"><i class="icon-envelope icon-large"></i><%=month%></a></li>
							<%}%>
						</ul>

					</div>

				​</div>

			</section>
			</div>
		</div>
		<script type="text/javascript">
		function demo()
		{
			document.getElenmentById("indate").value=document.getElenmentById("v1").value;
			document.getElenmentById("outdate").value=document.getElenmentById("v2").value;
			document.CCCC.submit();
		}
		</script>

		<!-- jQuery if needed --><script src="http://www.jq22.com/jquery/2.1.1/jquery.min.js"></script>

		<script type="text/javascript">

			

			function DropDown(el) {

				this.dd = el;

				this.placeholder = this.dd.children('span');

				this.opts = this.dd.find('ul.dropdown > li');

				this.val = '';

				this.index = -1;

				this.initEvents();

			}

			DropDown.prototype = {

				initEvents : function() {

					var obj = this;



					obj.dd.on('click', function(event){

						$(this).toggleClass('active');

						return false;

					});



					obj.opts.on('click',function(){

						var opt = $(this);

						obj.val = opt.text();

						obj.index = opt.index();

						obj.placeholder.text(obj.val);

					});

				},

				getValue : function() {

					return this.val;

				},

				getIndex : function() {

					return this.index;

				}

			}



			$(function() {



				var dd = new DropDown( $('#dd') );



				$(document).click(function() {

					// all dropdowns

					$('.wrapper-dropdown-3').removeClass('active');

				});



			});
		$(function() {



				var dd = new DropDown( $('#dd1') );



				$(document).click(function() {

					// all dropdowns

					$('.wrapper-dropdown-3').removeClass('active');

				});



			});



		</script>

	</body>

</html>