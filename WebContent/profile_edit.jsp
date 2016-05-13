<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.enterprise.jdbc.customerDTO"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
<script type="text/javascript">
function validate(){
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var z = document.forms["editForm"]["email"].value;
    if(!re.test(z)){
    	alert("Incorrect email!")
    	return false;
    }
}
</script>
</head>
<body>
<%
	customerDTO customer = (customerDTO) session.getAttribute("customer");
%>
<h1>Profile</h1>
<form name="editForm" action="dispatcher" onsubmit="return validate()" method="post">
	<table>
		<tr><td>Nickname</td><td><input type="text" name="nickname" value="<%=customer.getNickname() %>" ></td></tr>
		<tr><td>Firstname</td><td><input type="text" name="firstname" value="<%=customer.getFirstname() %>" ></td></tr>
		<tr><td>Lastname</td><td><input type="text" name="lastname" value="<%=customer.getLastname() %>" ></td></tr>
		<tr><td>Email</td><td><input type="text" name="email" value="<%=customer.getEmail() %>" ></td></tr>
		<tr><td>Address</td><td><input type="text" name="address" value="<%=customer.getAdd() %>" ></td></tr>
		<tr><td>CardNum</td><td><input type="text" name="cardnum" value="<%=customer.getCardnum() %>" ></td></tr>
		<tr><td>CardType</td><td><select name="cardtype"><option>VISA</option><option>MasterCard</option><option>America Express</option><option>JCB</option><option>UnionPay</option></select></td></tr>
	</table>
	<input type="hidden" name="operation" value="profileedit" >
	<input type="hidden" name="username" value="<%=customer.getUsername() %>" >
	<input type="submit" value="submit">
</form>
</body>
</html>