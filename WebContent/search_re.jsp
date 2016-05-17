<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.enterprise.jdbc.detailDTO, java.text.*, java.util.*, java.util.concurrent.TimeUnit,
    com.enterprise.jdbc.customerDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
<!-- table css -->
<link rel="stylesheet" href="table.css" type="text/css" media="screen, projection" />
</head>
<body>
<%
			customerDTO customer = (customerDTO) session.getAttribute("customer");
			detailDTO re = (detailDTO) session.getAttribute("search_re");
			if(re == null){
%>
<!-- no rooms available -->
<h1>Sorry! No such room available.</h1>
<%
			
			}else{
				String city = null;
				if(re.getHotelid() == 1){
					city = "Sydney";
				}else if(re.getHotelid() == 2){
					city = "Melbourne";
				}else if(re.getHotelid() == 3){
					city = "Brisbane";
				}else if(re.getHotelid() == 4){
					city = "Adelaide";
				}else if(re.getHotelid() == 5){
					city = "Hobart";
				}else{
					city = "Perth";
				}
				// Calculate the total price
				// Get the discount and the peak time on Session
				String start = re.getStartdate();
				String end = re.getEnddate();
				long days = 0;
				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date st = format.parse(start);
					Date ed = format.parse(end);
					days = ed.getTime() - st.getTime();
					days = TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
				}catch (ParseException e) {
				    e.printStackTrace();
				}
				float total = re.getPrice().floatValue() * days;
%>
<!-- show result -->
<h1>There are rooms available</h1>
<form action="dispatcher" method="post">
<table>
	<tr>
		<th>Start-Date</th>
		<th>End-Date</th>
		<th>City</th>
		<th>RoomType</th>
		<th>Price/Day</th>
		<th>Total-Price</th>
<%				if(!re.getRoomtype().equals("Single")){
%>
		<th>Extra-Bed</th>
<%	
				}
%>	
	</tr>
	<tr>
		<td><%=re.getStartdate() %></td>
		<td><%=re.getEnddate() %></td>
		<td><%=city %></td>
		<td><%=re.getRoomtype() %></td>
		<td><%=re.getPrice() %></td>
		<td><%=total %></td>
<%				if(!re.getRoomtype().equals("Single")){
%>
		<td><input type="checkbox" name="extrabed" value="1" /></td>
<%	
				}
%>	
	</tr>
</table>

	<input type="hidden" name="operation" value="addCart" />
	<input type="hidden" name="userID" value="<%=customer.getID() %>" />
	<input type="submit" value="Add to ShoppingCart" />
</form>
<%				
			}
%>
<form method="get" action="customer_info.jsp">
    <button type="submit">Back to Profile</button>
</form>
</body>
</html>