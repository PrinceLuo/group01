
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
 * Edit the customers' profiles
 */
public class ProfileEditCommand implements Command {

	private UserDelegateImpl userDelegate;
	
	public ProfileEditCommand(){
		userDelegate = DelegatesFactory.getInstance().getUserDelegate();
	}
	/* (non-Javadoc)
	 * @see com.enterprise.web.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		customerDTO old = new customerDTO();
		old.setUsername(request.getParameter("username"));
		old.setNickname(request.getParameter("nickname"));
		old.setFirstname(request.getParameter("firstname"));
		old.setLastname(request.getParameter("lastname"));
		old.setEmail(request.getParameter("email"));
		old.setAdd(request.getParameter("address"));
		old.setCardnum(request.getParameter("cardnum"));
		old.setCardtype(request.getParameter("cardtype"));
		customerDTO change = userDelegate.editProfile(old);
		HttpSession session = request.getSession();
		session.setAttribute("customer", change);
		return "/customer_info.jsp";
	}

}
