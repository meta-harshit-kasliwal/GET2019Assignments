<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="mvc" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<a href="home">HOME</a>
<table align="center">
	<tr>
		<th>Name</th>
		<th>Father Name</th>
		<th>Email</th>
		<th>Class</th>
		<th>Age</th>
	</tr>
	<mvc:forEach var="list" items="${list}">
	<tr>
		<td>${list.first_name} ${list.last_name}</td>
		<td>${list.father_name}</td>
		<td>${list.email}</td>
		<td>${list.cls}</td>
		<td>${list.age}</td>
	</tr>
	</mvc:forEach>
</table>
	<center><mvc:if test="${empty student_list}">
		<h4>No Records Found</h4>
	</mvc:if>
</center>
</body>
</html>