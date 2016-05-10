/**
 * 
 */
package com.enterprise.service;

import com.enterprise.beans.UserBean;
import com.enterprise.jdbc.staffDTO;
import com.enterprise.jdbc.DAO.managerDAOImpl;

/**
 * @author group01
 * Methods that call the DAOs to access into the Database 
 * So you need a factory and extract the ManagerDAO from it
 * Also remember to add methods that inherit from interface
 */
public class ManagerServiceImpl extends Service {

	private managerDAOImpl managerDAO;
	/* (non-Javadoc)
	 * @see com.enterprise.service.Service#login(java.lang.String, java.lang.String)
	 */
	
	public ManagerServiceImpl(){
		managerDAO = new managerDAOImpl();
	}
	
	@Override
	public UserBean login(String username, String password) {
		// TODO Auto-generated method stub
		
		UserBean staff = new UserBean();
		staffDTO staffInfo = managerDAO.find(username);
		if(staffInfo.getPassword().equals(password)){
			staff.setUsername(username);
			staff.setPassword(password);
			staff.setType(staffInfo.getType());
			return staff;
		} else {
			return null;
		}
		
	}

}
