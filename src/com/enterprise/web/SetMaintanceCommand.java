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
		String[] roomids=new String[0];
		HttpSession session = request.getSession();
		if(request.getParameterValues("roomids")!=null && !request.getParameter("roomids").isEmpty()){
			roomids=request.getParameterValues("roomids");
		}
		
		ownerDAO o=new ownerDAOImpl();
		for(int i=0;i<roomids.length;i++){
			int roomid=Integer.parseInt(roomids[i]);
			if(o.checkAvailabiblity(roomid)){
				o.setMaintenance(roomid);
			}else{
				System.out.println("set maintance error");
			}
				
		}
		List<hotelDTO> hotels = o.getHotels();
		for(hotelDTO hotel : hotels){
			int occ = 0, ava = 0;
			int id = hotel.getID();
			List<roomDTO> rooms = o.getRooms(id);
			for(roomDTO room : rooms){
				if(room.getAvailability().equals("available")){
					ava += 1;
				}else if(room.getAvailability().equals("booked") || room.getAvailability().equals("occupied") ){
					occ += 1;
				}
			}
			hotel.setRoomlist(rooms);
			hotel.setAva(ava);
			hotel.setOcc(occ);

		}
		session.setAttribute("hotels", hotels);
		return "/ownersuccess.jsp"; 
		// TODO Auto-generated method stub
	}

}
