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

import com.enterprise.beans.UserBean;
import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.ManagerDelegateImpl;

/**
 * @author group01
 * Staff function
 * Deals with command Login from staff
 */
public class AssignCommand implements Command {

	/* (non-Javadoc)
	 * @see com.enterprise.web.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	private ManagerDelegateImpl manaDelegate;
	
	public AssignCommand(){
		manaDelegate = DelegatesFactory.getInstance().getManagerDelegate();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] roomids=new String[0];
		HttpSession session = request.getSession();
		if(request.getParameterValues("roomids")!=null && !request.getParameter("roomids").isEmpty()){
			roomids=request.getParameterValues("roomids");
		}
		
		
		managerDAO manager=new managerDAOImpl();
		
		for(int i=0;i<roomids.length;i++){
			int roomid=Integer.parseInt(roomids[i]);
			manager.assignRoom(roomid);
		}
		
		return "/staffinfo.jsp"; 
		//how to return to manager page without relogin
		}
	}
	
	


