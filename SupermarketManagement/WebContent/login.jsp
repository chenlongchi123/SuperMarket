<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >

<title>Wopop</title>
<link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="./Wopop_files/style.css">
<link rel="stylesheet" type="text/css" href="./Wopop_files/userpanel.css">
<link rel="stylesheet" type="text/css" href="./Wopop_files/jquery.ui.all.css">

</head>

<body class="login" mycollectionplug="bind">
<div class="login_m">
<div class="login_logo"><img src="./Wopop_files/logo.png" width="196" height="46"></div>
<div class="login_boder">

<div class="login_padding" id="login_model">
<form action="/SupermarketManagement/LoginServlet" method="post" name="form1"   >
  <h2>USERNAME</h2>
  <label>
    <input type="text" id="username" name="name" class="txt_input txt_input2"  onfocus="if (value ==&#39;Your name&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;Your name&#39;}" value="Your name"><font color="red" >${requestScope.errors.name}</font>
  </label>
  <h2>PASSWORD</h2>
  <label>
    <input type="password" name="password" id="userpwd" class="txt_input"  onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}" value="******"><font color="red" >${requestScope.errors.password}</font>
  </label>
 
 <input type="submit" value="登录" />
<input type="button" value="注册" onclick="window.location.href='/SupermarketManagement/register.jsp'" />
 
  





<!--login_padding  Sign up end-->
</div><!--login_boder end-->
</div><!--login_m end-->
 <br> <br>


</form>
<font color="red">${requestScope.error }</font>
<img src="./images/gongzhonghao.jpg" width="100" height="100"/>
<h7>扫描二维码关注官方公众号</h7>
<img src="./images/app.png" width="100" height="120"/>

</body></html>