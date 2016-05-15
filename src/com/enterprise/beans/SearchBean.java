
package com.enterprise.beans;

import java.util.Currency;
import java.util.Date;

/**
 * @author group01
 * Capture the information of a room
 * back to front
 */

public class SearchBean {
	
	/**
	 * It contains members that has to
	 * be the same as the attributes from
	 * table rooms
	 */
	private String sCheckIn;
	private String sCheckOut;
	private String sCity;
	private int iNoOfRooms;
	private String sMaxPrice;

	/**
	 * Empty constructor
	 */
	public SearchBean() {
	}
	
	public String getCheckIn() {
		return sCheckIn;
	}
	public void setCheckIn(String sValue) {
		sCheckIn = sValue;
	}
	
	public String getCheckOut() {
		return sCheckOut;
	}
	public void setCheckOut(String sValue) {
		sCheckOut = sValue;
	}
	
	public String getCity() {
		return sCity;
	}
	public void setCity(String sValue) {
		sCity = sValue;
	}
	
	public int getNoOfRooms() {
		return iNoOfRooms;
	}
	public void setNoOfRooms(int iValue) {
		iNoOfRooms = iValue;
	}

	public String getMaxPrice() {
		return sMaxPrice;
	}
	public void setMaxPrice(String sValue) {
		sMaxPrice = sValue;
	}
}
