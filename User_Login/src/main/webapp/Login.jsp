<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Login</title>
</head>
<body>
	
	<form action="LoginServlet" method="post">
	
		<label>UserName : </label>
		<input type="text" name="username" id="username"/></br></br>
		<label>Password : </label>
		<input type="password" name="password" id="password"/></br></br>
		<input type="Submit" name="login" value="Login"/>
		
	</form>
	
</body>
</html>