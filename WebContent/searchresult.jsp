<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page import="com.enterprise.beans.RoomBean, javax.servlet.http.HttpSession"  %>
    <%@ page import="com.enterprise.jdbc.DAO.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1>Welcome to Program Hotel!</h1><br />

<!--jsp:useBean id="rooms" class="com.enterprise.beans.RoomBean" scope="session" /-->


<% int iCount = 0; %>
<h1>Rooms</h1><br />
<table><tr>
	<c:forEach items='${rooms}' var='room'>
		<% iCount++; %>
		<td><table width="298" border=1>
			    <tr><td rowspan='3' width='138' align="center"><a href="userlogin.jsp" class="button"><img src='${room.getImagePath()}' width='138' height='92' style="border-style: none" /></a></td><th width='50'>Room<br />Type</th><td align='center' width='80'>${room.getRoomType()}</td></tr>
			    <tr><TH>City</TH><td align='center'>${room.getCity()}</td></tr>
			    <tr><TH>Price</TH><td align='center'>${room.getPrice()}</td></tr>
		</table></td>
		<% if ((iCount % 3)==0) { %>
		</tr><tr>
		<% } %>
	</c:forEach>
</tr></table>


<% iCount = 0; %>
<h1>Special Deals</h1><br />
<table><tr>
	<c:forEach items='${specials}' var='special'>
		<% iCount++; %>
		<td><table width="298" border=1>
			    <tr><td rowspan='3' width='138' align="center"><a href="userlogin.jsp" class="button"><img src='${special.imagepath}' width='138' height='92' style="border-style: none" /></a></td><th width='50'>Room<br />Type</th><td align='center' width='80'>${special.room_type}</td></tr>
			    <tr><TH>City</TH><td align='center'>${special.city}</td></tr>
			    <tr><TH valign="middle">Price</TH><td align='center' valign="middle"><del>${special.price}</del><br /><red><b>${special.specialprice}</b></red><br /><red><b>${special.rate}% discount!</b></red></td></tr>
		</table></td>
		<% if ((iCount % 3)==0) { %>
		</tr><tr>
		<% } %>
	</c:forEach>
</tr></table>

<% iCount = 0; %>
<h1>Search Result</h1><br />
<table><tr>
	<c:forEach items='${yourrooms}' var='yourroom'>
		<% iCount++; %>
		<td><table width="298" border=1>
			    <tr><td rowspan='3' width='138' align="center"><img src='${yourroom.getImagePath()}' width='138' height='92' style="border-style: none" /></td><th width='50'>Room<br />Type</th><td align='center' width='80'>${yourroom.getRoomType()}</td></tr>
			    <tr><TH>City</TH><td align='center'>${yourroom.getCity()}</td></tr>
			    <tr><TH valign="middle">Price</TH><td align='center' valign="middle">${yourroom.getPrice()}</td></tr>
		</table></td>
		<% if ((iCount % 3)==0) { %>
		</tr><tr>
		<% } %>
	</c:forEach>
</tr></table>



<%
String sCheckIn="";
String sCheckOut="";
String sCity="";
String sNoOfRooms="";
String sMaxPrice="";

String sValue = "";
sValue = (String)request.getSession().getAttribute("checkin");
if (sValue != null)
	sCheckIn = sValue; 
sValue = (String)request.getSession().getAttribute("checkout");
if (sValue != null)
	sCheckOut = sValue; 
sValue = (String)request.getSession().getAttribute("city");
if (sValue != null)
	sCity = sValue;
sValue = (String)request.getSession().getAttribute("noofrooms"); 
if (sValue != null)
	sNoOfRooms = sValue;
sValue = (String)request.getSession().getAttribute("maxprice"); 
if (sValue != null)
	sMaxPrice = sValue;
%>

<form action='dispatcher' method='post'>
<table><tr>
	<th><label for="checkin">Check-In Date</label></th>
	<td><input type="text" value="<%=sCheckIn%>" name='checkin'></td></tr>
	<tr><th><label for="checkout">Check-Out Date</label></th>
	<td><input type="text" value="<%=sCheckOut%>" name='checkout'></td></tr>
	<tr><th><label for="city">City</label></th>
	<td><input type="text" value="<%=sCity%>" name='city'></td></tr>
	<tr><th><label for="noofrooms">No of Rooms</label></th>
	<td><input type="text" value="<%=sNoOfRooms%>" name='noofrooms'></td></tr>
	<tr><th><label for="maxprice">Maximum Price per room </label></th>
	<td><input type="text" value="<%=sMaxPrice%>" name='maxprice'></td></tr>
	<tr><td colspan=2 align=center><input type="hidden" name="operation" value="searchrooms">
    <input type='submit' value='Search' name='search'></td></tr>
</table>
</form>

<div style="position: absolute; top: 0; right: 0;"><a href="userlogin.jsp" class="button">Sigh-in/Sign-up</a></div>
</body>
</html>