<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link href="<%=request.getContextPath()%>/css/head.css" rel="stylesheet">
</head>
<body>
<div class="htmleaf-container">
	<nav class="animenu"> 
	  <button class="animenu__toggle">
		<span class="animenu__toggle__bar"></span>
		<span class="animenu__toggle__bar"></span>
		<span class="animenu__toggle__bar"></span>
	  </button>
	  <ul class="animenu__nav">
		<li>
		  <a href="<%=request.getContextPath()%>/index.jsp">主页</a>
		</li>
		
		<li>
		  <a href="#">Archive</a>
		  <ul class="animenu__nav__child">
			<li><a href="">Sub Item 1</a></li>
			<li><a href="">Sub Item 2</a></li>
			<li><a href="">Sub Item 3</a></li>
		  </ul>
		</li>    
		 
		<li>
		  <a href="#">Categories</a>
		  <ul class="animenu__nav__child">
			<li><a href="">Sub Item 1</a></li>
			<li><a href="">Sub Item 2</a></li>
			<li><a href="">Sub Item 3</a></li>
		  </ul>
		</li>
		
		<li>
		  <a href="#">About</a>
		</li>
		<li>
		  <a href=<%=request.getContextPath()%>/login.jsp>注销</a>
		</li> 
		                
	  </ul>
	</nav>
</div>

<script type="text/javascript">
	(function(){
	  var animenuToggle = document.querySelector('.animenu__toggle'),
		  animenuNav    = document.querySelector('.animenu__nav'),
		  hasClass = function( elem, className ) {
			return new RegExp( ' ' + className + ' ' ).test( ' ' + elem.className + ' ' );
		  },
		  toggleClass = function( elem, className ) {
			var newClass = ' ' + elem.className.replace( /[\t\r\n]/g, ' ' ) + ' ';
			if( hasClass(elem, className ) ) {
			  while( newClass.indexOf( ' ' + className + ' ' ) >= 0 ) {
				newClass = newClass.replace( ' ' + className + ' ' , ' ' );
			  }
			  elem.className = newClass.replace( /^\s+|\s+$/g, '' );
			} else {
			  elem.className += ' ' + className;
			}
		  },           
		  animenuToggleNav =  function (){        
			toggleClass(animenuToggle, "animenu__toggle--active");
			toggleClass(animenuNav, "animenu__nav--open");        
		  }

	  if (!animenuToggle.addEventListener) {
		  animenuToggle.attachEvent("onclick", animenuToggleNav);
	  }
	  else {
		  animenuToggle.addEventListener('click', animenuToggleNav);
	  }
	})()
</script>
</body>
</html>