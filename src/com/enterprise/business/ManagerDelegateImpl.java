
package com.enterprise.business;

import com.enterprise.service.Service;
import com.enterprise.service.ServicesFactory;

/**
 * @author group01
 * This class just simply take the program into the 
 * Manager service layer
 */
public class ManagerDelegateImpl extends Delegate {

	@Override
	protected Service getService() {
		// TODO Auto-generated method stub
		return ServicesFactory.getInstance().getManaerService();
	}

	
}
