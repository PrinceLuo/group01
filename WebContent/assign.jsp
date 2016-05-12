<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.enterprise.jdbc.*, 
    com.enterprise.beans.UserBean, javax.servlet.http.HttpSession"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final</title>
</head>
<%
	
%>
<body>
	<FORM ACTION='dispatcher' METHOD='post'>
	<h1>Assign Rooms for each booking </h1>
	Customer needs <c:out value="${numRooms }"></c:out> Rooms
	
	Available rooms
	<table>
	<tr>
   		<th>
   			Room Number
   		</th>
   		<th>
   			Assign Room
   		</th>
   	</tr>
	<c:forEach var="room" items="${rooms}">
   	<tr>
   		<td>
   			${room.getNumber()}
   		</td>
   		<td>
   			<input type="checkbox" name="roomids" value=${room.getID() }>
   		</td>
   	</tr>
	</c:forEach>
	
	</table>
	

	<input type="hidden" name="operation" value="assign" />
   	<input type="submit" value="assign">
   	</FORM>




</body>
</html>