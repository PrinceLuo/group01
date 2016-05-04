
package com.enterprise.service;

import com.enterprise.beans.UserBean;

/**
 * @author group01
 * Methods that call the DAOs to access into the Database 
 * So you need a factory and extract the UserDAO from it
 * Also remember to add methods that inherit from interface
 */
public class UserServiceImpl implements Service {

	/* (non-Javadoc)
	 * @see com.enterprise.business.Service#login(java.lang.String, java.lang.String)
	 */
	
	public UserServiceImpl(){
	}
	
	@Override
	public UserBean login(String username, String password) {
		// TODO Auto-generated method stub
		// Shall call the tb_userDAO
		return null;
	}

	/**
	 * Methods that inherit from the interface Service
	 */
}
