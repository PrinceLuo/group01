
package com.enterprise.business;

import java.util.HashMap;

/**
 * @author group03
 * Storage of the Delegates
 * Being called the Commands which chosse
 * the very one Delegates in the Factory
 */
public class DelegatesFactory {

	private HashMap delegates = new HashMap();
	private static DelegatesFactory instance = new DelegatesFactory();
	private static String USER_DELE = "userDelegate";
	private static String MANAGER_DELE = "managerDelegate";
	private static String OWNER_DELE = "ownerDelegate";
	
	private DelegatesFactory(){
		delegates.put(USER_DELE, new UserDelegateImpl());
		delegates.put(MANAGER_DELE, new ManagerDelegateImpl());
		delegates.put(OWNER_DELE, new OwnerDelegateImpl());
	}
	public static DelegatesFactory getInstance() {
		return instance;
	}
	
	public UserDelegateImpl getUserDelegate(){
		return (UserDelegateImpl) delegates.get(USER_DELE);
	}
	
	public ManagerDelegateImpl getManagerDelegate(){
		return (ManagerDelegateImpl) delegates.get(MANAGER_DELE);
	}
	
	public OwnerDelegateImpl getOwnerDelegate(){
		return (OwnerDelegateImpl) delegates.get(OWNER_DELE);
	}
}
