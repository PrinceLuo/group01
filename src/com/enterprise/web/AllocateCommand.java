/**
 * 
 */
package com.enterprise.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.enterprise.jdbc.bookingDTO;
import com.enterprise.jdbc.detailDTO;
import com.enterprise.jdbc.roomDTO;
import com.enterprise.jdbc.DAO.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.jdbc.*;
import com.enterprise.beans.AssignBean;
import com.enterprise.beans.UserBean;
import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.ManagerDelegateImpl;

/**
 * @author group01
 * Staff function
 * Deals with command Login from staff
 */
public class AllocateCommand implements Command {

	/* (non-Javadoc)
	 * @see com.enterprise.web.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	private ManagerDelegateImpl manaDelegate;
	
	public AllocateCommand(){
		manaDelegate = DelegatesFactory.getInstance().getManagerDelegate();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String roomtype=request.getParameter("roomtype");
		String numRooms=request.getParameter("numRooms");
		int tid=Integer.parseInt(roomtype);
		int n=Integer.parseInt(numRooms);
		UserBean staff=(UserBean) session.getAttribute("user");
		String name = staff.getUsername();
		managerDAO manager=new managerDAOImpl();
		staffDTO sdto=manager.find(name);
		int hid=sdto.getHotelid();
		
		
		List<roomDTO> rooms=manager.getRooms(hid,tid);
		session.setAttribute("numRooms", n);
		session.setAttribute("rooms", rooms);
			
			return "/assign.jsp"; 
		}
	}



	
	


