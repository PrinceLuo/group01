<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.enterprise.jdbc.hotelDTO,javax.servlet.http.HttpSession"  %>
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
 	<input type="button" name="setdiscount" onclick="window.location.href='discount.jsp'" value="set discount" ><br/><br/>
 	<input type="button" name="setpeak" onclick="window.location.href='peak.jsp'" value="set peak" ><br/><br/>
 	<FORM ACTION='dispatcher' METHOD='post'>
 	Hotels Detail
 	<table border = "1">
 		<tr>
 			<th>hotel name</th>
 			<th>available</th>
 			<th>occupied</th>
 		</tr>
 		<c:forEach var="hotel" items="${hotels}">
 		<tr>
 			<td>${hotel.getName()}</td>
 			<td>${hotel.getAva()}</td>
 			<td>${hotel.getOcc()}</td>
 			<td><input type="radio" name="hotelid" value=${hotel.getID() }></td>
 		</tr>
 		</c:forEach>
 	</table>
 	<input type="hidden" name="operation" value="setmaintenance" />
 	<input type="hidden" name="step" value="findrooms" />
    <input type="submit" value="maintance">
 	</FORM>
	<% String message =(String) session.getAttribute("mm");
 	if("rid".equals(message)){
 	%><h1>Please choose one hotel</h1>
 	<%session.setAttribute("mm", null);} %>
 	<% if("fail".equals(message)){
 	%><h1>Fail to set maintenance, please try again!</h1>
 	<%session.setAttribute("mm", null);} %>
 	<%if ("seccess".equals(message)){ %>
 	<h1>Success to set maintenance</h1>
 	<%} %>
 	<% message =(String) session.getAttribute("d");
 	if ("seccess".equals(message)){ %>
 	<h1>Success to set maintenance</h1>
 	<%} %>
 	<% message =(String) session.getAttribute("p");
 	if ("seccess".equals(message)){ %>
 	<h1>Success to set peak</h1>
 	<%} %>
</body>
</html>