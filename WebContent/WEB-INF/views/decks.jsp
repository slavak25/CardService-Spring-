<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Card Service</title>
</head>
<body>
 
		<ul>
			<c:forEach var="elem" items="${map.entrySet()}">
       			<li> ${elem.getValue()}        				
				<a href="<c:url value="/shuffle?id=${elem.getKey()}" />">Shuffle the deck</a>
				<a href="<c:url value="/sort?id=${elem.getKey()}" />">Sort the deck</a>
				<a href="<c:url value="/jsonShuffle?id=${elem.getKey()}" />">RestShuffle the deck</a>    
    			<a href="<c:url value="/jsonSort?id=${elem.getKey()}" />">RestSort the deck</a>
    			<a href="<c:url value="/delete?id=${elem.getKey()}" />">Delete the deck</a>
				</li>
			</c:forEach>
		</ul> 
	
    <a href="<c:url value="/create" />">Create a deck</a>
    <a href="<c:url value="/jsonCreate" />">RestCreate a deck</a>    
</body>
</html>