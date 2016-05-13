<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-in/Sign-up</title>
<script type="text/javascript">
function loginvalidate() {
    var x = document.forms["loginForm"]["username"].value;
    var y = document.forms["loginForm"]["password"].value;
    if (x == null || x == "" || y == "" || y == null) {
        alert("Incorrect username or password!");
        return false;
    }
}
function registervalidate(){
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var x = document.forms["registerForm"]["newuser"].value;
    var y = document.forms["registerForm"]["newpassword"].value;
    var z = document.forms["registerForm"]["newemail"].value;
    if(x == null || x == "" || y == "" || y == null || !re.test(z)){
    	alert("Incorrect username or password or email!")
    	return false;
    }
}
</script>
</head>
<body>
<h1>Login: <br/></h1>
	<form name="loginForm" action="dispatcher" onsubmit="return loginvalidate()" method="post">
Username: 
		<input type="text" name="username" />
Password:
		<input type="password" name="password" />
		<input type="hidden" name="operation" value="customerlogin" />
		<input type="submit" value="Login" />		
	</form>
<br/><br/>
<h1>Registration: <br/></h1>
	<form name="registerForm" action="dispatcher" onsubmit="return registervalidate()" method="post">
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