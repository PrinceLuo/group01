<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.enterprise.jdbc.hotelDTO,  javax.servlet.http.HttpSession"  %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Set Discount</title>
</head>
<%
	List<hotelDTO> hotels = (List<hotelDTO>) session.getAttribute("hotels");
%>
<body>
<form action="dispatcher" method="POST">

	<table border = "1">
		<tr>
			<th>hotel name</th>
			<th>hotel location</th>
			<th>room type</th>
		</tr>
		<c:forEach var="hotel" items="${hotels}">
		<tr>
			<td>${hotel.getName() }</td>
			<td>${hotel.getLocation() }</td>
			<td><div>
				<table border = "1">
				<c:forEach var="roomtype" items="${hotel.getRoomtypelist()} }">
				<tr><td>${roomtype.getRoomtype()}</td>
					<td><input type="radio" name="roomtypeid" value=${roomtype.getID() }></td>
				</tr>
				</c:forEach>
				</table>
				</div>
			</td>
		</tr>
		</c:forEach>
	</table>
Start date: <input type = "text" name="startdate" placeholder="YYYY-MM-DD">
End date:<input type = "text" name="enddate" placeholder="YYYY-MM-DD">
Rate:<input type = "text" name="rate" placeholder="higher than 0, lower than 100">
<input type="hidden" name="operation" value="setdiscount" />
<input type="submit" value="set discount">
</form>
<input type="button" name="back" onclick="window.location.href='ownersuccess.jsp'" value="back to home page" >
</body>
</html>