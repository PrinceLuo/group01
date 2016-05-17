package com.enterprise.web;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.OwnerDelegateImpl;
import com.enterprise.jdbc.discountDTO;
import com.enterprise.jdbc.hotelDTO;
import com.enterprise.jdbc.roomtypeDTO;
import com.enterprise.jdbc.DAO.ownerDAOImpl;

public class DiscountCommand implements Command {
	private OwnerDelegateImpl oDelegate;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date sd = null;
	Date ed = null;
	
	public DiscountCommand(){
		oDelegate = DelegatesFactory.getInstance().getOwnerDelegate();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ownerDAOImpl o = new ownerDAOImpl();
		if(request.getParameter("roomtypeid")==null){
			return "/discount.jsp"; 	
		}
		String roomtypeid = request.getParameter("roomtypeid");
		int rate = Integer.parseInt(request.getParameter("rate"));
		if (rate<=0 || rate >=100)
			return "/discount.jsp";
		if(isValidDate(request.getParameter("startdate"), request.getParameter("startdate"))){
			 this.sd =  parsedate(request.getParameter("startdate").trim()); 
			 this.ed =  parsedate(request.getParameter("enddate").trim());
			if(sd.after(ed) || sd.equals(ed)){
				return "/discount.jsp";
			}
				
				discountDTO d = new discountDTO();
				int id = Integer.parseInt(roomtypeid);
				hotelDTO h = o.getHotelbyTypeid(id);
				roomtypeDTO rt = o.getType(id);
				d.setRate(rate);
				d.setStartdate(dateFormat.format(this.sd));
				d.setEnddate(dateFormat.format(this.ed));
				d.setRoomtypeid(id);
				d.setType(rt.getRoomtype());
				d.setHotelid(h.getID());
				d.setName(h.getName());
				d.setLocation(h.getLocation());
				session.setAttribute("discount", d);
				return "/confirmdiscount.jsp";
				
			
		}else{
			return "/discount.jsp";
		}
		

		
	}

		  public boolean isValidDate(String sDate, String eDate) {

		    if (sDate == null || eDate == null)
		      return false;
		    
		    if (sDate.trim().length() != dateFormat.toPattern().length() || eDate.trim().length() != dateFormat.toPattern().length())
		      return false;
		    dateFormat.setLenient(false);
		    try {
		       dateFormat.parse(sDate.trim());
		       dateFormat.parse(eDate.trim());
		    }
		    catch (ParseException pe) {
		      return false;
		    }
		    return true;
		  }
		  public Date parsedate(String inDate) { 
			  Date d = null;
				try {
					d =  dateFormat.parse(inDate.trim());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return d;
		
		  }

}