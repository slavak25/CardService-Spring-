<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Card Service</title>
</head>
<body>
    <c:out value="${deck}" />
    <a href="<c:url value="/sort?id=${elem.getKey()}" />">Sort the deck</a>
    <a href="<c:url value="/jsonSort?id=${elem.getKey()}" />">RestSort the deck</a>    
    <a href="<c:url value="/redirect" />">Back to the decks view</a>
    <form action="redirect">
		<input type="submit" value="Home">
	</form>   
</body>
</html>