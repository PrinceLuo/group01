package com.enterprise.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.ManagerDelegateImpl;
import com.enterprise.business.OwnerDelegateImpl;
import com.enterprise.jdbc.hotelDTO;
import com.enterprise.jdbc.roomDTO;
import com.enterprise.jdbc.roomtypeDTO;
import com.enterprise.jdbc.DAO.ownerDAO;
import com.enterprise.jdbc.DAO.ownerDAOImpl;


public class SetMaintanceCommand implements Command {
	private OwnerDelegateImpl oDelegate;
	
	public SetMaintanceCommand(){
		oDelegate = DelegatesFactory.getInstance().getOwnerDelegate();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String step = "findrooms";
		String message = null;
		if(step.equals(request.getParameter("step"))) {
			if(request.getParameter("hotelid") == null){
				message = "rid";
				session.setAttribute("mm", message);
				return "/ownersuccess.jsp";
			}
			int id = Integer.parseInt(request.getParameter("hotelid"));
			ownerDAO o=new ownerDAOImpl();
			List<roomDTO> rooms = o.getRoomsbyHotel(id);
			session.setAttribute("rooms", rooms);
			return "/setmaintenance.jsp";
			
		}
		step = "maintenance";
		if(request.getParameterValues("roomids")!=null  && step.equals(request.getParameter("step"))){
			String[] roomids=request.getParameterValues("roomids");
			
			for(int i=0;i<roomids.length;i++){
				int roomid=Integer.parseInt(roomids[i]);
				ownerDAO o=new ownerDAOImpl();
				if(o.checkAvailabiblity(roomid)){
					ownerDAO o1=new ownerDAOImpl();
					o1.setMaintenance(roomid);
				}else{
					message = "fail";
					session.setAttribute("mm", message);
				    return "/setmaintenance.jsp";
				}
					
			}
			ownerDAO o2=new ownerDAOImpl();
			List<hotelDTO> hotels = o2.getHotels();
			for(hotelDTO hotel : hotels){
				int occ = 0, ava = 0;
				int id = hotel.getID();
				ownerDAO o3=new ownerDAOImpl();
				List<roomtypeDTO> roomt = o3.getRoomtype(id);
				hotel.setRoomtypelist(roomt);
				for(roomtypeDTO roomtype : roomt){
					ownerDAO o4=new ownerDAOImpl();
					List<roomDTO> rooms = o4.getRooms(hotel.getID(), roomtype.getID());
					
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
			message = "success";
			session.setAttribute("mm",message);
			session.setAttribute("hotels", hotels);
			return "/ownersuccess.jsp"; 
		}
		message = "fail";
		session.setAttribute("mm",message);
		return "/ownersuccess.jsp";

		// TODO Auto-generated method stub
	}

}
