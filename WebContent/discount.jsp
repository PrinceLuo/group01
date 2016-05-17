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
		</tr>
		<c:forEach var="hotel" items="${hotels}">
		<tr>
			<td>${hotel.getName() }</td>
			<td>${hotel.getLocation() }</td>
			<td><input type="radio" name="hotelid" value=${hotel.getID() }></td>
		</tr>
		</c:forEach>
	</table>
Room type:
<select name="roomtype">
	<option value = "Single">Single</option>
	<option value = "Twin">Twin</option>
	<option value = "Queen">Queen</option>
	<option value = "Executive">Executive</option>
	<option value = "Suite">Suite</option>
</select>
Start date: <input type = "text" name="startdate" placeholder="YYYY-MM-DD">
End date:<input type = "text" name="enddate" placeholder="YYYY-MM-DD">
Rate:<input type = "text" name="rate" placeholder="between 0 to 100">
<input type="hidden" name="operation" value="setdiscount" />
<input type="submit" value="set discount">
</form>
<input type="button" name="back" onclick="window.location.href='ownersuccess.jsp'" value="back to home page" >
	<% String message =(String) session.getAttribute("d");
 	if("noid".equals(message)){
 	%><h1>Choose one hotel and try again!</h1>
 	<%session.setAttribute("d", null);} %>
 	<%if ("fr".equals(message)){ %>
 	<h1>Please input right rate</h1>
 	<%session.setAttribute("d", null);} %>
 	<%if ("fd".equals(message)){ %>
 	<h1>Start date must before end date</h1>
 	<%session.setAttribute("d", null);} %>
 	<%if ("dt".equals(message)){ %>
 	<h1>Please follow the date format</h1>
 	<%session.setAttribute("d", null);} %>
 	<%if ("nr".equals(message)){ %>
 	<h1>Please choose one room type</h1>
 	<%session.setAttribute("d", null);} %>
 	
</body>
</html>