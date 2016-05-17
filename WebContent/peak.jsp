<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Set Peak</title>
</head>
<body>
<form action="dispatcher" method="POST">
name: <input type = "text" name="name">
Start date: <input type = "text" name="startdate" placeholder="YYYY-MM-DD">
End date:<input type = "text" name="enddate" placeholder="YYYY-MM-DD">
Rate:<input type = "text" name="rate" placeholder="higher than 0">
<input type="hidden" name="operation" value="setpeak" >
<input type="submit" value="set peak">
</form>
<input type="button" name="backthome" onclick="window.location.href='ownersuccess.jsp'" value="back to home page" >
 	<%String message =(String) session.getAttribute("p");
 	if ("fr".equals(message)){ %>
 	<h1>Please input right rate</h1>
 	<%session.setAttribute("p", null);} %>
 	<%if ("fd".equals(message)){ %>
 	<h1>Start date must before end date</h1>
 	<%session.setAttribute("p", null);} %>
 	<%if ("dt".equals(message)){ %>
 	<h1>Please follow the date format</h1>
 	<%session.setAttribute("p", null);} %>
</body>
</html>