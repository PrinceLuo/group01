
package com.enterprise.beans;

/**
 * @author group01
 * Capture the information of a registered user
 * back to front
 * Suit for all 3 types
 */
public class UserBean{

	/**
	 * It contain members that has be the same
	 * as the attributes from the table users
	 */
	
	private String username;
	private String password;
	private String type;
	// more need to be add later
	
	/**
	 * Empty constructor
	 */
	public UserBean() {
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
