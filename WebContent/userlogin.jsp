<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login: <br/></h1>
	<form action="dispatcher" method="post">
Username: 
		<input type="text" name="username" />
Password:
		<input type="password" name="password" />
		<input type="hidden" name="operation" value="userlogin" />
		<input type="submit" value="Login" />		
	</form>
<br/><br/>
<h1>Registration: <br/></h1>
	<form action="dispatcher" name="username">
Username: 
		<input type="text" name="newuser" /><br/>
Password: 
		<input type="password" name="newpassword" /><br/>
E-mail: 
		<input type="text" name="newemail" /><br/>
		<input type="hidden" name="operation" value="register" />
		<input type="submit" value="Sign Up Now!" />
	</form>	
</body>
</html>