<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html> <body> <users  >
<c:forEach items="${list}" var="list">
	<user id="${list.id }"> 
	<name>${list.name } </name>
	<price>${list.price} </price>
	<pnum>${list.pnum} </pnum>
	<type>${list.type}</type>
	<description>${list.description} </description></user>
</c:forEach>  <users></body> </html>