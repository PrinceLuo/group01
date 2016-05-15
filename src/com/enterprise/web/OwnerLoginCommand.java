package com.enterprise.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.beans.UserBean;
import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.ManagerDelegateImpl;
import com.enterprise.business.OwnerDelegateImpl;
import com.enterprise.jdbc.detailDTO;
import com.enterprise.jdbc.hotelDTO;
import com.enterprise.jdbc.roomDTO;
import com.enterprise.jdbc.roomtypeDTO;
import com.enterprise.jdbc.staffDTO;
import com.enterprise.jdbc.DAO.managerDAO;
import com.enterprise.jdbc.DAO.managerDAOImpl;
import com.enterprise.jdbc.DAO.ownerDAO;
import com.enterprise.jdbc.DAO.ownerDAOImpl;

public class OwnerLoginCommand implements Command {

	private OwnerDelegateImpl oDelegate;
	
	public OwnerLoginCommand(){
		oDelegate = DelegatesFactory.getInstance().getOwnerDelegate();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserBean owner = oDelegate.ownerlogin(username, password);
		if(owner == null){
			HttpSession session = request.getSession();
			session.setAttribute("user", owner);
			return "/ownerfail.jsp"; 
		} else{
			HttpSession session = request.getSession();
			session.setAttribute("user", owner);
			//add attribute to provide access to database
			ownerDAO o=new ownerDAOImpl();
			List<hotelDTO> hotels = o.getHotels();
			for(hotelDTO hotel : hotels){
				int t_occ = 0, t_ava = 0;
				int id = hotel.getID();
				List<roomtypeDTO> roomt = o.getRoomtype(id);
				hotel.setRoomtypelist(roomt);
				for(roomtypeDTO roomtype : roomt){
					List<roomDTO> rooms = o.getRooms(hotel.getID(), roomtype.getID());
					int occ = 0, ava = 0;
					roomtype.setRoomlist(rooms);
					for(roomDTO room : rooms){
						if(room.getAvailability().equals("available")){
							ava += 1;
						}else if(room.getAvailability().equals("booked") || room.getAvailability().equals("occupied") ){
							occ += 1;
						}
					}
					roomtype.setAva(ava);
					roomtype.setOcc(occ);
					t_occ = t_occ + occ;
					t_ava = t_ava + ava;
				}
				hotel.setAva(t_ava);
				hotel.setOcc(t_occ);

			}
			session.setAttribute("hotels", hotels);
			return "/ownersuccess.jsp"; 
		}
	}
}
