<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.enterprise.jdbc.customerDTO"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Profile</title>
<!-- table css -->
<link rel="stylesheet" href="table.css" type="text/css" media="screen, projection">
</head>
<body>
<%
	customerDTO customer = (customerDTO) session.getAttribute("customer");
	if(customer == null){
%>
<h1>Incorrect username or pasword</h1>
<!-- link to home page here -->
<%
	}else{
%>
<!-- show info in table -->
<h1>Hello, <%=customer.getUsername() %></h1>
<h3>Profile</h3>
	<table>
		<tr><td>Nickname</td><td><%=customer.getNickname() %></td></tr>
		<tr><td>Firstname</td><td><%=customer.getFirstname() %></td></tr>
		<tr><td>Lastname</td><td><%=customer.getLastname() %></td></tr>
		<tr><td>Email</td><td><%=customer.getEmail() %></td></tr>
		<tr><td>Address</td><td><%=customer.getAdd() %></td></tr>
		<tr><td>CardNum</td><td><%=customer.getCardnum() %></td></tr>
		<tr><td>CardType</td><td><%=customer.getCardtype() %></td></tr>
	</table>
<%
	}
%>
<form method="get" action="profile_edit.jsp">
    <button type="submit">Edit My Profile</button>
</form>
<br/><br/>
<!-- Search -->
<form action="dispatcher" method="post">
<h1>Search rooms:</h1><br/>
<h3>From:</h3>
<input type="text" name="fromyear" />-<input type="text" name="frommonth" />-<input type="text" name="fromday" /> 
<h3>To:</h3>
<input type="text" name="toyear" />-<input type="text" name="tomonth" />-<input type="text" name="today" /> 
<br/>
City: <select name="city"><option selected="selected">Sydney</option>
				<option>Melbourne</option>
				<option>Brisbane</option>
				<option>Adelaide</option>
				<option>Hobart</option>
				<option>Perth</option></select> RoomType: <select name="roomtype"><option selected="selected">Single</option>
				<option>Twin</option>
				<option>Queen</option>
				<option>Executive</option>
				<option>Suite</option></select>
<input type="hidden" name="operation" value="search" />
<input type="submit" value="Search" />
</form>
<form action="dispatcher" method="get">
	<input type="hidden" name="operation" value="shopping_cart" />
	<input type="hidden" name="userID" value="<%=customer.getID()  %>">
<input type="submit" value="Go To Shopping Cart" />
</form>
</body>
</html>