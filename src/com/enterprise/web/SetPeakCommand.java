package com.enterprise.web;
 
 import java.io.IOException;
 import java.text.DateFormat;
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 
 import com.enterprise.business.DelegatesFactory;
 import com.enterprise.business.OwnerDelegateImpl;
 import com.enterprise.jdbc.discountDTO;
 import com.enterprise.jdbc.DAO.ownerDAOImpl;
 
 public class SetPeakCommand implements Command {
 	private OwnerDelegateImpl oDelegate;
 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 	
 	public SetPeakCommand(){
 		oDelegate = DelegatesFactory.getInstance().getOwnerDelegate();
 	}
 	@Override
 	public String execute(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		// TODO Auto-generated method stub
 		HttpSession session = request.getSession();
 		ownerDAOImpl o = new ownerDAOImpl();
 		Date cd = new Date();
 		String n = request.getParameter("name");
 		String sd = request.getParameter("startdate");
 		String ed = request.getParameter("enddate");
 		int rate = Integer.parseInt(request.getParameter("rate"));
 		if (!isValidDate(sd) || !isValidDate(ed))
 			return "/peak.jsp";
 		Date s = parsedate(sd);
 		Date e = parsedate(ed);
 		if(s.after(e))
 			return "/peak.jsp";
 		String c = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cd));
 		o.setPeak(n, c, sd, ed, rate);
 		return "/ownersuccess.jsp";
 	}
 	  public boolean isValidDate(String sDate) {
 
 		    if (sDate == null )
 		      return false;
 		    
 		    if (sDate.trim().length() != dateFormat.toPattern().length() )
 		      return false;
 		    dateFormat.setLenient(false);
 		    try {
 		    	dateFormat.parse(sDate.trim());
 		     
 		    }
 		    catch (ParseException pe) {
 		      return false;
 		    }
 		    return true;
 		  }
 		  public Date parsedate(String inDate) { 
 			  Date d = null;
 				try {
 					d =  dateFormat.parse(inDate.trim());
 				} catch (ParseException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 				return d;
 		
 		  }
 
 }