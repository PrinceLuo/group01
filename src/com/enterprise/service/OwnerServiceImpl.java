
package com.enterprise.service;

import com.enterprise.beans.UserBean;

/**
 * @author group01
 * Methods that call the DAOs to access into the Database 
 * So you need a factory and extract the OwnererDAO from it
 * Also remember to add methods that inherit from interface
 */
public class OwnerServiceImpl extends Service{

	/* (non-Javadoc)
	 * @see com.enterprise.service.Service#login(java.lang.String, java.lang.String)
	 */
	
	public OwnerServiceImpl(){
	}
	
	@Override
	public UserBean login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
