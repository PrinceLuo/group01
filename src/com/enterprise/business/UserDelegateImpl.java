
package com.enterprise.business;

import com.enterprise.service.Service;
import com.enterprise.service.ServicesFactory;

/**
 * @author user
 * This class just simply take the program into the 
 * User service layer
 */
public class UserDelegateImpl extends Delegate{

	@Override
	protected Service getService() {
		// TODO Auto-generated method stub
		return ServicesFactory.getInstance().getUserService();
	}

	
}
