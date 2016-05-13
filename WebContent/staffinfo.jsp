<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.enterprise.jdbc.roomDTO, com.enterprise.beans.UserBean, javax.servlet.http.HttpSession"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final</title>
</head>
<%
	UserBean staff = (UserBean) session.getAttribute("user");
	List<roomDTO> rooms=(List<roomDTO>) session.getAttribute("rooms");
%>
<body>
	<h1>Hello! <%=staff.getType() %> <%=staff.getUsername() %> from <%=staff.getPassword() %></h1>
	<c:if test="${staff.getType().equals('manager') }"> 
	
	<FORM ACTION='dispatcher' METHOD='post'>
	Occupied Rooms
	<table>
	<tr>
   		<th>
   			Room Number
   		</th>
   		<th>
   			Checkout
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
	<input type="hidden" name="operation" value="checkout" />
   	<input type="submit" value="checkout">
   	</FORM>
	
	Bookings(Not checked in)
	<table>
	<tr>
   		<th>
   			Booking PIN
   		</th>
   		<th>
   			Start
   		</th>
   		<th>
   			End
   		</th>
   		<th>
   			Details
   		</th>
   	</tr>
	<c:forEach var="booking" items="${bookings}">
	<tr>
   		<td>
   			${booking.getPin()}
   		</td>
   		<td>
   			${booking.getStartdate()}
   		</td>
   		<td>
   			${booking.getEnddate()}
   		</td>
   		<td>
   			<FORM ACTION='dispatcher' METHOD='post'>
			<input type="hidden" name="operation" value="allocate" />
			<input type="hidden" name="numRooms" value=${bookings.getNumRooms() } />
			<input type="hidden" name="roomtype" value=${bookings.getRoomtypeid() } />
   			<input type="submit" value="submit">
   			</FORM>
   		</td>
   	</tr>
	</c:forEach>
	</table>
	
	</c:if>
	<c:if test="${staff.getType().equals('owner') }">
		
	</c:if>
	
</body>
</html>