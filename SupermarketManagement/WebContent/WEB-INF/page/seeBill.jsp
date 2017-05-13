<%@page import="com.chen.bean.Cost"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		
	</script>
	
  </head>
  
  <body  style= "background:url(images/main.png) repeat;">
   	<%
      Cost cost=(Cost)request.getAttribute("cost");
     %>
   	<h1>账单</h1>
   	<table border="1" id="one" >
   	 <tr>
      <td>出售货物总进价:</td><td><%=cost.getJjprice()%></td>
      </tr>
      <tr>
      <td>出售货物总收入:</td><td><%=cost.getCsprice()%></td>
      </tr>
      <tr>
      <td>其他总支出:</td><td><%=cost.getHfprice()%></td>
      </tr>
      <tr>
      <td>盈利:</td><td><%=cost.getCsprice()-cost.getJjprice()-cost.getHfprice()%></td>
      </tr>
      
   	</table>
  </body>
</html>
