<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.enterprise.jdbc.hotelDTO, com.enterprise.jdbc.roomDTO, javax.servlet.http.HttpSession"  %>
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
	<h1>Welcome Back Owner</h1>
	<FORM ACTION='dispatcher' METHOD='post'>
	Hotels Detail
	<table border = "1">
		<tr>
			<th>hotel name</th>
			<th>room detail</th>
			<th>available</th>
			<th>occupied</th>
		</tr>
		<c:forEach var="hotel" items="${hotels}">
		<tr>
			<td>${hotel.getName()}</td>
			<td><div>
					<table border = "1">
						<tr><th>room num</th></tr>
						<c:forEach var="room" items="${hotels.getRoomlist()}">
						<tr>
							<td>${room.getNumber()}</td>
							<td><input type="checkbox" name="roomids" value=${room.getNumber() }></td>
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
	<input type="hidden" name="operation" value="setmaintance" />
   	<input type="submit" value="maintance">
	</FORM>
	
</body>
</html>