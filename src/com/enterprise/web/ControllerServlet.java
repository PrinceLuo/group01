package com.enterprise.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Servlet implementation class ControlServlet
 */
//@WebServlet("/dispatcher")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, Command> commands;

    /**
     * @see HttpServlet#HttpServlet()
     */
	public ControllerServlet() {
    	/**
    	 * Add command here first before you write any new method
    	 */
        super();
        commands = new HashMap<String, Command>();
        commands.put("stafflogin", new StaffLoginCommand());
        commands.put("register", new RegisterCommand());
        commands.put("assign", new AllocateCommand());
        commands.put("allocate", new AllocateCommand());
        commands.put("checkout", new CheckoutCommand());
        commands.put("customerlogin", new CustomerLoginCommand());
        commands.put("profileedit", new ProfileEditCommand());
        commands.put("homedisplay", new HomeDisplayCommand());
        // TODO Auto-generated constructor stub
    }
    
	/** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 */

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		String operation = request.getParameter("operation");
		if(request.getParameter("operation")==null){
			operation="homedisplay";
		}
		Command cmd = (Command) commands.get(operation);
		String next = cmd.execute(request, response);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(next);
		dispatcher.forward(request, response);
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
}
