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
  
  <body>
   	<form action="/SupermarketManagement/EditServlet" method="post" enctype="multipart/form-data" name="form1"    style= "background:url(images/timg.jpg) repeat;">
   			<table border="1" >
   				<tr>
					<th colspan="2" align="center" >
						修改商品
					</th>
				</tr>   
				<tr>
					<td>商品名称:</td>
					<td><input type="text" name="name"  value="${requestScope.goods.name}" /><font color="red" >${requestScope.errors.name}</font></td>
				</tr>
				<tr>
					<td>商品价格:</td>
					<td><input type="text" name="price"  value="${requestScope.goods.price}"/><font color="red" >${requestScope.errors.password}</font></td>
				</tr>
				<tr>
					<td>库存:</td>
					<td><input type="text" name="pnum" value="${requestScope.goods.pnum}"/><font color="red" ></font></td>
				</tr> 
				<tr>
					<td>类别:</td>
					<td>
						<select name="type" >
							<option value="日用百货" ${requestScope.goods.type=="日用百货"?"selected":"" }>日用百货</option>
							<option value="电子产品" ${requestScope.goods.type=="电子产品"?"selected":"" }>电子产品</option>
							<option value="床上用品" ${requestScope.goods.type=="床上用品"?"selected":"" }>床上用品</option>
						</select>
					</td>
				</tr>    
				<tr>
					<td>商品图片:</td>
					<td>
					<img src="/SupermarketManagement${requestScope.goods.imgurl}" width="100" height="100">
					<input type="file" name="img" />
					<font color="red" ></font></td>
				</tr> 
				<tr>
					<td>商品描述:</td>
					<td><textarea name="description" cols="50" rows="10"  >
					${requestScope.goods.description}
					</textarea></td>
				</tr> 
				<tr>
					<td colspan="2" align="center" >
						<input type="submit" value="修改" />
						<input type="button" value="删除"  onclick="window.location.href='/SupermarketManagement/DeleteServlet?id=${requestScope.goods.id}'"/>
					</td>
				</tr>   			
   			</table>
   			<input type="hidden" name="id" value="${requestScope.goods.id}">
   		</form>
   		<font color="red">${requestScope.error }</font>
  </body>
</html>
