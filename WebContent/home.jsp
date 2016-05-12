<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page import="com.enterprise.beans.RoomBean, javax.servlet.http.HttpSession"  %>
    <%@ page import="com.enterprise.jdbc.DAO.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
Welcome to Program Hotel!<br /><br />

<%
String sWhat2Search = "";
//if (request.getParameter("searchtext")!=null)
//	sWhat2Search = request.getParameter("searchtext");
%>
<jsp:useBean id="oneroom" class="com.enterprise.beans.RoomBean" scope="session" />

<h1>One room</h1><br />
<table width="100%" border=1>
<tr>
    <th>Room Type</th><TH>Hotel ID</TH>
</tr>
</tr>
		<tr>
			<td><%=oneroom.getRoomType()%></td>
			<td><%=oneroom.getHotelID()%></td>
		</tr>

</TABLE>

<h1>All rooms in one hotel</h1><br />
<table width="100%" border=1>
<tr>
    <th>Room Type</th><TH>Price</TH><TH>Total No</TH><TH>Hotel ID</TH>
</tr>
</tr>
	<c:forEach items='${roomlist}' var='room'>
		<tr>
			<td>${room.room_type}</td>
			<td>${room.price}</td>
			<td>${room.total_num}</td>
			<td>${room.hotel_id}</td>
		</tr>
	</c:forEach>

</TABLE>

<!-- form action='dispatcher' method='post'>
	<input type="text" value="<%=sWhat2Search %>" name='searchtext'>
    <input type='submit' value='Search' name='search'></form-->

<div style="position: absolute; top: 0; right: 0;"><a href="userlogin.jsp" class="button">Sigh-in/Sign-up</a></div>
</body>
</html>