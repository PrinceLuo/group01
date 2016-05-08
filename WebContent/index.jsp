<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.enterprise.beans.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.enterprise.dao.*"%>
<%@ page import="com.enterprise.dao.support.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
Welcome to Program Hotel!

<table width="100%" border=1>
<tr>
<th>Short Name</th><TH>Complete Name</TH><TH>Email</TH><TH>Phone</TH><TH>&nbsp;</TH></tr>

<% 
RoomDAOImpl room_dao_impl = new RoomDAOImpl();
for (int i = 0; i < 2; i++) { 
	List list = room_dao_impl.findAllByHotel(i);%>
	<!--jsp:useBean id="room" class="com.enterprise.beans.RoomBean"/-->
	<% RoomBean room = room_dao_impl.getRoom("Queen", i);%>
	<tr>
		<td><%=room.getRoomType()%></td>
		<Td><%=room.getHotelID()%></Td>
		<td><a href='send a request to the dispatcher servlet and pass it the operation delete and give it the id of the entry as a parameter'>Delete</a></TD>
	</tr>
	<tr>
		<TD><strong>test</strong></TD>
		<Td colspan="4"></Td>
	</tr>
<% } %>
</TABLE>
</body>
</html>