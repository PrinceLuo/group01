
package com.enterprise.business;

import com.enterprise.service.Service;
import com.enterprise.service.ServicesFactory;

/**
 * @author group01
 * This class just simply take the program into the 
 * Owner service layer
 */
public class OwnerDelegateImpl extends Delegate {

	@Override
	protected Service getService() {
		// TODO Auto-generated method stub
		return ServicesFactory.getInstance().getOwnerService();
	}

}
