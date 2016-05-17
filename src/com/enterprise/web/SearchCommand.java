
package com.enterprise.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.UserDelegateImpl;
import com.enterprise.jdbc.detailDTO;

/**
 * @author group01
 * Search the rooms for the customers
 */
public class SearchCommand implements Command {

	private UserDelegateImpl userDelegate;
	
	public SearchCommand(){
		userDelegate = DelegatesFactory.getInstance().getUserDelegate();
	}
	/* (non-Javadoc)
	 * @see com.enterprise.web.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fromyear = request.getParameter("fromyear");
		String frommonth = request.getParameter("frommonth");
		String fromday = request.getParameter("fromday");
		String from = fromyear + "-" + frommonth + "-" +fromday;
		String toyear = request.getParameter("toyear");
		String tomonth = request.getParameter("tomonth");
		String today = request.getParameter("today");
		String to = toyear + "-" + tomonth + "-" +today;
		String city = request.getParameter("city");
		String roomtype = request.getParameter("roomtype");
		detailDTO re = userDelegate.search(from, to, city, roomtype);
		HttpSession session = request.getSession();
		session.setAttribute("search_re", re);
		return "/search_re.jsp";
	}

}
