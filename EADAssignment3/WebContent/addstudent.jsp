<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <center> Enter Student Details:</center>
 <form action="AddStudent">
 <center>
 	Roll_no: <input type ="number" name ="roll_no"><br><br>
 	 First_Name:<input type ="text" name ="first_name"><br><br>
 	 Last_Name:<input type ="text" name ="last_name"><br><br>
   	Father_Name:<input type ="text" name ="father_name"><br><br>
    Email:<input type ="email" name ="email"><br><br>
    Class:<input type ="number" name ="cls"><br><br>
    Age:<input type ="number" name ="age"><br><br>
    <input type="submit" name ="submit" value="Add student">
    </center>
 </form>
</body>
</html>