package com.enterprise.web;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.enterprise.jdbc.discountDTO;
import com.enterprise.jdbc.DAO.ownerDAOImpl;
import com.enterprise.business.DelegatesFactory;
import com.enterprise.business.OwnerDelegateImpl;

public class ConfirmDiscountCommand implements Command {
	private OwnerDelegateImpl oDelegate;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public ConfirmDiscountCommand(){
		oDelegate = DelegatesFactory.getInstance().getOwnerDelegate();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		discountDTO d = (discountDTO) session.getAttribute("discount");
		ownerDAOImpl o = new ownerDAOImpl();
		Date cd = new Date();
		d.setCurrentdate(dateFormat.format(cd));
		o.insertDiscount(d);
		return "/ownersuccess.jsp";
	}

}