/**
 * 
 */
package com.enterprise.web;

import java.io.IOException;
import java.util.List;

import com.enterprise.jdbc.*;
import com.enterprise.jdbc.DAO.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.beans.UserBean;
import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.ManagerDelegateImpl;

/**
 * @author group01
 * Staff function
 * Deals with command Login from staff
 */
public class StaffLoginCommand implements Command {

	/* (non-Javadoc)
	 * @see com.enterprise.web.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	private ManagerDelegateImpl manaDelegate;
	
	public StaffLoginCommand(){
		manaDelegate = DelegatesFactory.getInstance().getManagerDelegate();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserBean staff = manaDelegate.stafflogin(username, password);
		if(staff == null){
			HttpSession session = request.getSession();
			session.setAttribute("user", staff);
			return "/staffinfo.jsp"; // Should return a failure page
		} else{
			HttpSession session = request.getSession();
			session.setAttribute("user", staff);
			//add attribute to provide access to database
			managerDAO manager=new managerDAOImpl();
			staffDTO sdto=manager.find(username);
			int hid=sdto.getHotelid();
			List<roomDTO> rooms = manager.getFullRooms(hid);
			
			List<detailDTO> bookings=manager.getAllBookings(hid);
			session.setAttribute("rooms", rooms);
			session.setAttribute("bookings", bookings);
			
			return "/staffinfo.jsp"; // Should return a success page
		}
	}

}
