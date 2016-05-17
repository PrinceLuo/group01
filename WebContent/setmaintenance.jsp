<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.enterprise.jdbc.roomDTO,javax.servlet.http.HttpSession"  %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Owner</title>
</head>
<%
	List<roomDTO> rooms = (List<roomDTO>) session.getAttribute("rooms");
%>
<body>
 	<h1>Set maintenance</h1>
 	<input type="button" name="back1" onclick="window.location.href='ownersuccess.jsp'" value="back to home page" ></br>
 	
 	<FORM ACTION='dispatcher' METHOD='post'>
 	Rooms detail
 	<table border = "1">
 		<tr>
 			<th>room num</th>
 			<th>situation</th>
 		</tr>
 		<c:forEach var="room" items="${rooms}">
 		<tr>
 			<td>${room.getNumber()}</td>
 			<td>${room.getAvailability() }</td>
 			<td><input type="checkbox" name="roomids" value=${room.getID() }></td>
 		</tr>
 		</c:forEach>
 	</table>
 	<input type="hidden" name="operation" value="setmaintenance" />
 	<input type="hidden" name="step" value="maintenance" />
    <input type="submit" value="maintance">
 	</FORM>
 	<% String message =(String) session.getAttribute("mm");
 	if("fail".equals(message)){
 	%><h1>Some errors occur, back to home page please and try again!</h1>
 	<%session.setAttribute("mm", null);} %>
	
</body>
</html>