<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style= "background:url(images/main.png) repeat;">
   	<form action="/SupermarketManagement/AddGoodsServlet" method="post" enctype="multipart/form-data" name="form1"    >
   			<table border="1" >
   				<tr>
					<th colspan="2" align="center" >
						出售商品
					</th>
				</tr>   
				<tr>
					<td>商品名称:</td>
					<td><input type="text" name="name"   /><font color="red" >${requestScope.errors.name}</font></td>
				</tr>
				<tr>
					<td>出售数量</td>
					<td><input type="text" name="price"  /><font color="red" >${requestScope.errors.password}</font></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center" >
						<input type="submit" value="出售" />
					</td>
				</tr>   			
   			</table>
   		</form>
   		<font color="red">${requestScope.error }</font>
   
   		
  </body>
</html>
