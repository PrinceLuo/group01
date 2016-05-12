package com.enterprise.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

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
	
	public HomeDisplayCommand(){
		userDelegate = DelegatesFactory.getInstance().getUserDelegate();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RoomDAOImpl roomDAO = new RoomDAOImpl();
		HttpSession session = request.getSession();
		
		// display a room
		roomDAO.setHotelID(1);
		roomDAO.setRoomType("Queen");
		
		RoomBean rb = roomDAO.getRoom();
		session.setAttribute("oneroom", rb);

		// display all room types in a hotel
		RoomDAOImpl roomDAO2 = new RoomDAOImpl();
		roomDAO2.setHotelID(1);
		ArrayList<Map<String, String>> l = roomDAO2.findAllByHotel();
		session.setAttribute("roomlist", l);
		
		
		return "/home.jsp";
	}

}
