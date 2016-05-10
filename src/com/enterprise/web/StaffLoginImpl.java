/**
 * 
 */
package com.enterprise.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.beans.UserBean;
import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.ManagerDelegateImpl;

/**
 * @author group01
 * Deals with command Login from staff
 */
public class StaffLoginImpl implements Command {

	/* (non-Javadoc)
	 * @see com.enterprise.web.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	private static ManagerDelegateImpl manaDelegate;
	
	public StaffLoginImpl(){
		manaDelegate = DelegatesFactory.getInstance().getManagerDelegate();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserBean staff = manaDelegate.login(request.getParameter("username"), request.getParameter("password"));
		if(staff == null){
			HttpSession session = request.getSession();
			session.setAttribute("user", staff);
			return "/final.jsp"; // Should return a failure page
		} else{
			HttpSession session = request.getSession();
			session.setAttribute("user", staff);
			return "/final.jsp"; // Should return a success page
		}
	}

}
