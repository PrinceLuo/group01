/**
 * 
 */
package com.enterprise.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.UserDelegateImpl;
import com.enterprise.jdbc.bookingDTO;
import com.enterprise.jdbc.detailDTO;

/**
 * @author user
 *
 */
public class AddCartCommand implements Command {

	private UserDelegateImpl userDelegate;
	
	public AddCartCommand(){
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
		detailDTO re = (detailDTO) session.getAttribute("search_re");
		if(request.getParameter("extrabed")!=null){
			// add extra bed
			String extra = request.getParameter("extrabed");
			re.setExtrabed(1);
		}
		int customer_id = Integer.parseInt(request.getParameter("userID"));
		userDelegate.insertCart(customer_id, re);
		bookingDTO cartlist = userDelegate.getCart(customer_id);
		session.setAttribute("cartlist", cartlist);
		
		// use the userID to access the cart list
		return "/Shopping_Cart.jsp";
	}

}
