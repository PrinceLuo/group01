
package com.enterprise.beans;

import java.util.Currency;

/**
 * @author group01
 * Capture the information of a room
 * back to front
 */

public class RoomBean {
	
	/**
	 * It contains members that has to
	 * be the same as the attributes from
	 * table rooms
	 */
	private int iHotelID;
	private String sRoomType;
	private String sPrice;
	private String sHotelName;
	private String sCity;
	private String sImgPath;
	private double dDiscountRate;
	// need more later
	
	/**
	 * Empty constructor
	 */
	public RoomBean() {
	}
	
	public int getHotelID() {
		return iHotelID;
	}
	public void setHotelID(int iValue) {
		iHotelID = iValue;
	}
	public String getRoomType() {
		return sRoomType;
	}
	public void setRoomType(String sValue) {
		sRoomType = sValue;
	}
	public String getHotelName() {
		return sHotelName;
	}
	public void setHotelName(String sValue) {
		sHotelName = sValue;
	}
	public String getCity() {
		return sCity;
	}
	public void setCity(String sValue) {
		sCity = sValue;
	}
	public String getPrice() {
		return sPrice;
	}
	public void setPrice(String sValue) {
		sPrice = sValue;
	}
	public String getImagePath() {
		return sImgPath;
	}
	public void setImagePath(String sValue) {
		sImgPath = sValue;
	}
	public double getDiscountRate() {
		return iHotelID;
	}
	public void setDiscountRate(double dValue) {
		dDiscountRate = dValue;
	}

}
