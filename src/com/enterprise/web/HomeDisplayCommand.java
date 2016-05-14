package com.enterprise.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.UserDelegateImpl;

import com.enterprise.jdbc.DAO.RoomDAOImpl;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
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
		RoomDAOImpl[] roomDAO = new RoomDAOImpl[6];
		HttpSession session = request.getSession();
		Random randomGenerator = new Random();

		RoomBean[] rb = new RoomBean[6];
		for  (int i = 0; i < 6; i++) {
			// show a random room type of hotel 1
			roomDAO[i] = new RoomDAOImpl();
			roomDAO[i].setHotelID(i+1);		
			int randomInt = randomGenerator.nextInt(5)+1;
			roomDAO[i].setRoomType(Int2RoomType(randomInt));
			
			rb[i] = roomDAO[i].getRoom();
		}
		session.setAttribute("rooms", rb);
		
		/*RoomBean rb = new RoomBean();
			roomDAO.setHotelID(1);		
			roomDAO.setRoomType("Queen");
			
			rb = roomDAO.getRoom();
			session.setAttribute("oneroom", rb);*/
		

		
		// display all room types in a hotel
		RoomDAOImpl roomDAO2 = new RoomDAOImpl();
		roomDAO2.setHotelID(1);
		ArrayList<Map<String, String>> l = roomDAO2.findAllByHotel();
		session.setAttribute("roomlist", l);
		
		return "/home.jsp";
	}

}
