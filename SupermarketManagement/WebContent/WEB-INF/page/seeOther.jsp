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
		function fun1(){
			var table = document.getElementById("one");
			//获得所有商品的数组
			var jsonArray =  eval(${requestScope.json});
			//遍历数组,将商品添加到页面中的列表中
			for(var i = 0 ; i<jsonArray.length; ){
				//创建tr对象
				var tr = document.createElement("tr");
				//取出一个商品
				var good1 =  jsonArray[i++];
				//创建td对象
				var td = document.createElement("td");
				td.innerHTML="支出用途：    "+good1["oname"]+"<br>"+"支出金额：    "+good1["money"]+"元"+"<br>支出id：    "+good1["id"]+"<br>支出日期：    "+good1["odate"];
				//将td添加到tr中
				tr.appendChild(td);
				//判断,是否还有下一个商品
				if(i <= jsonArray.length-1 ){
							//取出一个商品
							var good2 =  jsonArray[i++];
							//创建td对象
							var td2 = document.createElement("td");
							td2.innerHTML="支出用途：    "+good1["oname"]+"<br>"+"支出金额：    "+good1["money"]+"元"+"<br>支出id：    "+good1["id"]+"<br>支出日期：    "+good1["odate"];
							//将td添加到tr中
							tr.appendChild(td2);
				}
				//tr添加到表格中
				table.appendChild(tr);
			}
			
		}	
	
	</script>
	
  </head>
  
  <body onload="fun1()" style= "background:url(images/main.png) repeat;">
   	<h1>支出费用历史清单</h1>
   	<table border="1" id="one" >
   	</table>
  </body>
</html>
