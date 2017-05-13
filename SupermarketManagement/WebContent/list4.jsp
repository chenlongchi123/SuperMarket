<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html> <body> <users  >
<c:forEach items="${list}" var="list">
	<user > 
	<jjprice>${list.jjprice } </jjprice>
	<csprice>${list.csprice} </csprice>
	<hfprice>${list.hfprice} </hfprice>
	</user>
</c:forEach>  </users></body> </html>