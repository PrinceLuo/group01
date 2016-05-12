
package com.enterprise.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.UserDelegateImpl;
import com.enterprise.jdbc.customerDTO;

/**
 * @author group01
 * Deals with the login from public customers
 */
public class CustomerLoginCommand implements Command {

	private UserDelegateImpl userDelegate;
	
	public CustomerLoginCommand(){
		userDelegate = DelegatesFactory.getInstance().getUserDelegate();
	}
	/* (non-Javadoc)
	 * @see com.enterprise.web.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		customerDTO customer = userDelegate.customerlogin(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
		return "/customer_info.jsp";
	}

}
