<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		
	</head>
	<body style= "background:url(images/timg.jpg) repeat;">
		<h3>管理货物</3>
		<ul type="square">
			<li><a href='/SupermarketManagement/ListServlet?format=json' target="content"> 货物列表</a></li>
			<li><a href='/SupermarketManagement/goods/addGoods.jsp?format=json' target="content"> 增加货物</a></li>
		</ul>
	</body>
</html>