<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
  <meta charset="utf-8">
  <title>error</title>


  <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/skeleton.css">
  <link rel="stylesheet" href="css/main.css">
  <link rel="stylesheet" href="css/animate.css">

  <!-- JS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <script src="js/jquery-1.12.0.min.js"></script>
  <script src="js/main.js"></script>



  <!-- typekit
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <script src="https://use.typekit.net/pba0mrg.js"></script>
  <script>try{Typekit.load({ async: true });}catch(e){}</script>
</head>
<body>

<div class="center-div">
  <div class="top-section">
  <div class="container" id="intro-section">
    <div class="row">
      <div class="seven columns">
        <h1 class = "animated fadeIn">Error !!!.
        <p class="intro animatesecond animated fadeIn"><h3>您无权访问</h3></p>
        <p class="intro animatethird animated fadeIn"> 重新登录       <a href="ClearServlet">注销</a> <br> or<br><a href="#" onclick="javascript:history.back(-1);">返回</a>
      </div>
    </div>
  </div>  
</div>
</div>

</body>
</html>