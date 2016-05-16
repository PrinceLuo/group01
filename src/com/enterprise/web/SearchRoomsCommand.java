package com.enterprise.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.jdbc.DAO.RoomDAOImpl;
import com.enterprise.beans.SearchBean;
import com.enterprise.beans.SearchResultBean;

/**
 * @author group01
 *
 */
public class SearchRoomsCommand implements Command{

	public SearchRoomsCommand(){
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		// get search option & text
		SearchBean sb = new SearchBean();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		//surround below line with try catch block as below code throws checked exception
		try {
		Date dDate = sdf.parse(request.getParameter("checkin"));
		sb.setCheckIn(dDate);
		Date dDate2 = sdf.parse(request.getParameter("checkout"));
		sb.setCheckOut(dDate2);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		sb.setCity(request.getParameter("city"));
		sb.setNoOfRooms(Integer.parseInt(request.getParameter("noofrooms")));
		if (request.getParameter("maxprice")!=null && !request.getParameter("maxprice").equals("")) 
			sb.setMaxPrice(request.getParameter("maxprice"));	

		session.setAttribute("checkin", request.getParameter("checkin"));
		session.setAttribute("checkout", request.getParameter("checkout"));
		session.setAttribute("city", request.getParameter("city"));
		session.setAttribute("noofrooms", request.getParameter("noofrooms"));
		if (request.getParameter("maxprice")!=null && !request.getParameter("maxprice").equals("") && !request.getParameter("maxprice").equals("0")) 
			session.setAttribute("maxprice", request.getParameter("maxprice"));
		else
			session.setAttribute("maxprice","");
		
		// search result
		RoomDAOImpl roomDAO = new RoomDAOImpl();

		SearchResultBean[] l = roomDAO.SearchRooms(sb);
		session.setAttribute("yourrooms", l);
			
		// close db connection
		roomDAO.Dispose();
		
		return "/searchresult.jsp";
	}

}
