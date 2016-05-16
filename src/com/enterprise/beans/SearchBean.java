
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
	private Date dCheckIn;
	private Date dCheckOut;
	private String sCity;
	private int iNoOfRooms;
	private String sMaxPrice;

	/**
	 * Empty constructor
	 */
	public SearchBean() {
	}
	
	public Date getCheckIn() {
		return dCheckIn;
	}
	public void setCheckIn(Date dValue) {
		dCheckIn = dValue;
	}
	
	public Date getCheckOut() {
		return dCheckOut;
	}
	public void setCheckOut(Date dValue) {
		dCheckOut = dValue;
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
