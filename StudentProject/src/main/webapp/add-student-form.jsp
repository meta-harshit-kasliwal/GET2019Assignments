<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <center>
   <pre>
   <a href="home.jsp">Home</a>
   <h1> add student details</h1>
   
   <mvc:form method="post" action="addstudentdetail" modelAttribute="student">
   
   First Name : <mvc:input path="first_name" /><mvc:errors path="first_name"></mvc:errors>
   Last Name : 	<mvc:input  path="last_name" /><mvc:errors path="last_name"></mvc:errors>
   Father Name: <mvc:input path="father_name" /><mvc:errors path="father_name"></mvc:errors>
   Email:		<mvc:input path="email" /><mvc:errors path="email"></mvc:errors>
   Class:       <mvc:input path="cls" /><mvc:errors path="cls"></mvc:errors>
   Age:         <mvc:input path="age" /><mvc:errors path="age"></mvc:errors>
   
   					<input type="submit" value="Add Student">
   </mvc:form>
   <h4>${message}</h4>
  </pre>
  </center>
</body>
</html>