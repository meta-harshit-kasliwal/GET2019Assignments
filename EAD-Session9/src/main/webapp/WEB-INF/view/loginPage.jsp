<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<fieldset  style="width:20%">
<legend>Login Details</legend>
<pre>
<form action="Verification" method="post">
Email 		: 	<input type="text" name = "email" required>
Password	:	<input type="password" name = "password" required>

				    <input type="submit" value = "Log In">
</form>
</pre>
</fieldset>
<h4>${message}</h4>
</center>
</body>
</html>