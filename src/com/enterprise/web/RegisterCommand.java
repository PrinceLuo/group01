
package com.enterprise.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.UserDelegateImpl;

/**
 * @author group01
 *
 */
public class RegisterCommand implements Command{

	private UserDelegateImpl userDelegate;
	
	public RegisterCommand(){
		userDelegate = DelegatesFactory.getInstance().getUserDelegate();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newuser = request.getParameter("newuser");
		String newpassword = request.getParameter("newpassword");
		String newemail = request.getParameter("newemail");
		String registerInfo = userDelegate.register(newuser, newpassword, newemail);
		// According the registerInfo
		HttpSession session = request.getSession();
		session.setAttribute("register_info", registerInfo);
		return "/register_result.jsp";
	}

}
