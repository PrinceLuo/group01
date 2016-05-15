<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.enterprise.jdbc.hotelDTO, com.enterprise.jdbc.roomDTO,com.enterprise.jdbc.roomtypeDTO, javax.servlet.http.HttpSession"  %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Owner</title>
</head>
<%
	List<hotelDTO> hotels = (List<hotelDTO>) session.getAttribute("hotels");
%>
<body>
	<h1>Welcome Back Owner</h1><br/><br/>
	<input type="button" name="setdiscount" onclick="window.location.href='discount.jsp'" value="set discount" ><br/><br/>
	<input type="button" name="setpeak" onclick="window.location.href='peak.jsp'" value="set peak" ><br/><br/>
	<FORM ACTION='dispatcher' METHOD='post'>
	Hotels Detail
	<table border = "1">
		<tr>
			<th>hotel name</th>
			<th>room detail</th>
			<th>total available</th>
			<th>total occupied</th>
		</tr>
		<c:forEach var="hotel" items="${hotels}">
		<tr>
			<td>${hotel.getName()}</td>
			<td><div>
				<table border = "1">
				<tr>
					<th>room type</th> <th>rooms</th><th>available</th><th>occupied</th>
				</tr>
				<c:forEach var="roomtype" items="${hotel.getRoomtypelist()} }">
				<tr><td>${roomtype.getRoomtype()}</td>
					<td><div>
						<table border = "1">
						<tr><th>room num</th><th>maintenance</th></tr>
						<c:forEach var="room" items="${roomtype.getRoomlist()}">
						<tr>
							<td>${room.getNumber()}</td>
							<td><input type="checkbox" name="roomids" value=${room.getID() }></td>
						</tr>
						</c:forEach>
						</table>
						</div>
					</td>
					<td>${roomtype.getAva() }</td>
					<td>${roomtype.getOcc() }</td>
				</tr>
				</c:forEach>
				</table>
				</div>
			</td>
			<td>${hotel.getAva()}</td>
			<td>${hotel.getOcc()}</td>
		</tr>
		</c:forEach>
	</table>
	<input type="hidden" name="operation" value="setmaintenance" />
   	<input type="submit" value="set maintenance">
	</FORM>
	
</body>
</html>