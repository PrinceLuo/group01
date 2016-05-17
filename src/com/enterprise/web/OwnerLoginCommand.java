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
		ownerDAO o=new ownerDAOImpl();
		UserBean owner = new UserBean();
		staffDTO ownerInfo =o.find(username);
		if(!password.equals(ownerInfo.getPassword())){
			HttpSession session = request.getSession();
			session.setAttribute("user", owner);
			return "/ownerfail.jsp";
		} else{	
			owner.setUsername(username);
			owner.setPassword(password);
			owner.setType(ownerInfo.getType());
			HttpSession session = request.getSession();
			session.setAttribute("user", owner);
			//add attribute to provide access to database
			ownerDAO o1=new ownerDAOImpl();
			List<hotelDTO> hotels = o1.getHotels();
			for(hotelDTO hotel : hotels){
				int occ = 0, ava = 0;
				int id = hotel.getID();
				ownerDAO o2=new ownerDAOImpl();
				List<roomtypeDTO> roomt = o2.getRoomtype(id);
				hotel.setRoomtypelist(roomt);
				for(roomtypeDTO roomtype : roomt){
					ownerDAO o3=new ownerDAOImpl();
					List<roomDTO> rooms = o3.getRooms(hotel.getID(), roomtype.getID());
					roomtype.setRoomlist(rooms);
					for(roomDTO room : rooms){
						if(room.getAvailability().equals("available")){
							ava += 1;
						}else if(room.getAvailability().equals("booked") || room.getAvailability().equals("occupied") ){
							occ += 1;
						}
					}
				}
				hotel.setAva(ava);
				hotel.setOcc(occ);
			}
			String m = null;
			session.setAttribute("mm", m);
			session.setAttribute("d", m);
			session.setAttribute("p", m);
			session.setAttribute("hotels", hotels);
			return "/ownersuccess.jsp"; 
		
		
		}
	}
}
