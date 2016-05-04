
package com.enterprise.service;

import com.enterprise.beans.*;

/**
 * @author group01
 * Services that handle the requests from front
 * Methods are implemented in ServiceImpl
 */
public interface Service {
	
	/**
	 * Finds a user with the given details
	 * @param username The username to login with
	 * @param password The password to login with
	 * @return A user if one exists with the given details
	 * You may add and exception handler later
	 */
	UserBean login(String username, String password);
	
	/**
	 * Need to add more methods later
	 */
}
