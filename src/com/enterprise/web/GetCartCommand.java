
package com.enterprise.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.UserDelegateImpl;
import com.enterprise.jdbc.bookingDTO;

/**
 * @author group01
 * Load the cart list of the customer
 */
public class GetCartCommand implements Command {

private UserDelegateImpl userDelegate;
	
	public GetCartCommand(){
		userDelegate = DelegatesFactory.getInstance().getUserDelegate();
	}
	/* (non-Javadoc)
	 * @see com.enterprise.web.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		int customer_id = Integer.parseInt(request.getParameter("userID"));
		bookingDTO cartlist = userDelegate.getCart(customer_id);
		session.setAttribute("cartlist", cartlist);
		return "/Shopping_Cart.jsp";
	}

}
