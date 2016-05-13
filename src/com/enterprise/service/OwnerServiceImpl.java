
package com.enterprise.service;

import com.enterprise.beans.UserBean;
import com.enterprise.jdbc.staffDTO;
import com.enterprise.jdbc.DAO.managerDAOImpl;
import com.enterprise.jdbc.DAO.ownerDAO;
import com.enterprise.jdbc.DAO.ownerDAOImpl;

/**
 * @author group01
 * Methods that call the DAOs to access into the Database 
 * So you need a factory and extract the OwnererDAO from it
 * Also remember to add methods that inherit from interface
 */
public class OwnerServiceImpl extends Service{
	private ownerDAOImpl ownerDAO;
	/* (non-Javadoc)
	 * @see com.enterprise.service.Service#login(java.lang.String, java.lang.String)
	 */
	public OwnerServiceImpl(){
		ownerDAO = new ownerDAOImpl();
	}
	
	@Override
	public UserBean ownerlogin(String username, String password) {
		// TODO Auto-generated method stub
		
		UserBean owner = new UserBean();
		staffDTO ownerInfo =ownerDAO.find(username);
		if(ownerInfo.getPassword().equals(password)){
			owner.setUsername(username);
			owner.setPassword(password);
			owner.setType(ownerInfo.getType());
			return owner;
		} else {
			return null;
		}
		
	}
	

}
