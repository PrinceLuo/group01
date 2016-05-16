package com.enterprise.web;

import java.io.IOException;
import java.util.ArrayList;
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
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		// get search option & text
		SearchBean sb = new SearchBean();
		
		sb.setCheckIn(request.getParameter("checkin"));
		sb.setCheckOut(request.getParameter("checkout"));
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
