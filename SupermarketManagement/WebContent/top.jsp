<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<title>top</title>
		<script language="javascript" type="text/javascript">
		function updateDate(){
			var nd=new Date();
			var y=nd.getYear();
			var m=nd.getMonth();
			var d=nd.getDate();
			var w=nd.getDay();
			var h=nd.getHours();
			var mm=nd.getMinutes();
			var ss=nd.getSeconds();
			var dateStr=y+"年"+m+"月"+d+"日 星期"+w+" "+h+":"+mm+":"+ss;
			var sd=document.getElementById("showDate");
			sd.innerHTML=dateStr;
			setTimeout("updateDate()",1000);
		}
		
			
		</script>
	</head>
	<body>
	<table border="0" width="100%">
		<tr>
			<td colspan="3" background="white">
				<img src="images/ny_top_img.gif" height="108"width="650"></img>
			</td>
		</tr>
		<tr>
			<td width="20%">当前位置：所有用户管理</td>
			<td width="50%" align="right">
			<marquee direction="right" >欢迎您,${sessionScope.user.name}</marquee></td>
			<td width="20%"><span id="showDate"><span></td>	
			<td width="10%"><a href="/SupermarketManagement/LogoutServlet" target="_parent">退出</a></td>
		</tr>
		
	</table>
		<script language="javascript" type="text/javascript">
			setTimeout("updateDate()",0);
		</script>
	</body>
</html>