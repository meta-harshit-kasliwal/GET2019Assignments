<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="left"><a href="index.html">Home</a></p>	
<%
	if(request.getAttribute("message")!=null){
%>
<center><h2><%=request.getAttribute("message").toString() %><h2><center>
<%} %>
<% 
	Student student = (Student)request.getAttribute("update_student");
%>
<center>
<form action = "AddStudent" method = "post">
<h2><b>Enter Student Details</b></h2>
<pre>
<label>Roll NO 	:	</label>	<input type="text" pattern="[0-9]*" name = "roll_no" value=<%=student.getRoll_no() %> readonly="readonly" required>
<label>First Name	:		</label><input type="text" pattern="[A-Z a-z]*" name = "first_name" value=<%=student.getFirst_name() %> required>
<label>Last Name	:		</label><input type="text" pattern="[A-Z a-z]*" name = "last_name" value=<%=student.getLast_name() %> required>
<label>Father Name	:		</label><input type="text" pattern="[A-Z a-z]*" name = "father_name" value=<%=student.getFather_name() %> required>
<label>Email		:		</label><input type="email" name="email" value=<%=student.getEmail() %>  required>
<label>Class		:		</label><input type="number	" name="cls" value=<%=student.getCls() %> required>
<label>Age		:		</label><input type="number" name="age" value=<%=student.getAge()%> required>

		       <input type="submit" name="submit" value="Update" >
</pre>
</form>
</center>

</body>
</html>