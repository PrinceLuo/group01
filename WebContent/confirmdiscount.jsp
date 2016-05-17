<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.enterprise.jdbc.discountDTO,javax.servlet.http.HttpSession"  %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Discount</title>
</head>
<%
	discountDTO discount = (discountDTO)session.getAttribute("discount");
%>
<body>
<form action="dispatcher" method="POST">
 	<h1>Discount detail</h1>
 	<table border = "1">
 		<tr><th>hotel name</th> <td>${discount.getName() }</td></tr>
 		<tr><th>hotel location</th><td>${discounts.getLocation() }</td></tr>
 		<tr><th>room type</th><td>${discount.getType() }</td></tr>
 		<tr><th>start date</th><td>${discount.getStartdate() }</td></tr>
 		<tr><th>end date</th><td>${discount.getEnddate() }</td></tr>
 		<tr><th>rate</th><td>${discount.getRate() }</td></tr>
 	</table>
 	<input type="hidden" name="operation" value="confirmdiscount" />
 	<input type="submit" value="confirm discount">
 </form>
 <input type="button" name="back2home" onclick="window.location.href='ownersuccess.jsp'" value="back to home page" >
 <input type="button" name="back2discount" onclick="window.location.href='discount.jsp'" value="reset discount" >
 </body>
</body>
</html>