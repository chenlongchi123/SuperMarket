<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html> <body> <users  >
<c:forEach items="${list}" var="list">
	<user id="${list.id }"> 
	<name>${list.name } </name>
	<password>${list.password} </password>
	<email>${list.email} </email>
	<status>${list.status} </status>
	</user>
</c:forEach>  </users></body> </html>