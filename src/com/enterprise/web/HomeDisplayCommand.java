package com.enterprise.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.UserDelegateImpl;

import com.enterprise.jdbc.DAO.RoomDAOImpl;
import com.enterprise.beans.RoomBean;

/**
 * @author group01
 *
 */
public class HomeDisplayCommand implements Command{

	private UserDelegateImpl userDelegate;

	private String Int2RoomType(int i) {
		if (i == 1)
			return "Single";
		if (i == 2)
			return "Twin";
		if (i == 3)
			return "Queen";
		if (i == 4)
			return "Executive";
		if (i == 5)
			return "Suite";
		return "";
	}

	public HomeDisplayCommand(){
		userDelegate = DelegatesFactory.getInstance().getUserDelegate();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Random randomGenerator = new Random();

		RoomDAOImpl roomDAO = new RoomDAOImpl();
		RoomBean[] rb = new RoomBean[6];
		for  (int i = 0; i < 6; i++) {
			// show a random room type of hotel 1
			roomDAO.setHotelID(i+1);
			int randomInt = randomGenerator.nextInt(5)+1;
			roomDAO.setRoomType(Int2RoomType(randomInt));
			
			rb[i] = roomDAO.getRoom();
		}
		session.setAttribute("rooms", rb);

		// special deals
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		ArrayList<Map<String, String>> l = roomDAO.getDiscountedRooms(date, date);
		session.setAttribute("specials", l);
		
		// close data src
		roomDAO.Dispose();
	
		return "/home.jsp";
	}
}
