
package com.enterprise.service;

import java.util.ArrayList;

import com.enterprise.beans.UserBean;
import com.enterprise.jdbc.bookingDTO;
import com.enterprise.jdbc.customerDTO;
import com.enterprise.jdbc.detailDTO;

/**
 * @author group01
 * Warning: All the method will return null; methods need to be written in xxxServiceImpl
 */
public abstract class Service {

	
	/**
	 * Finds a user with the given details
	 * @param username The username to login with
	 * @param password The password to login with
	 * @return A user if one exists with the given details
	 * You may add and exception handler later
	 */
	public UserBean stafflogin(String username, String password){
		return null;
	}
	
	public String register(String newuser, String newpassword, String newemail){
		return null;
	}
	
	public customerDTO customerlogin(String username, String password){
		return null;
	}
	
	public customerDTO editProfile(customerDTO old){
		return null;
	}
	
	public UserBean ownerlogin(String username, String password){
		return null;
	}
	
	public detailDTO search(String from, String to, String city, String roomtype){
		return null;
	}
	
	public void insertCart(int customer_id, detailDTO re){
	}
	
	public bookingDTO getCart(int userID){
		return null;
	}
	/**
	 * Need to add more methods later
	 */
}
