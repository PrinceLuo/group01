
package com.enterprise.beans;

import java.util.Date;

/**
 * @author group01
 * Capture the information of a room
 * back to front
 */

public class SearchResultBean {
	
	/**
	 * It contains members that has to
	 * be the same as the attributes from
	 * table rooms
	 */
	
	// search texts
	private Date dCheckIn;
	private Date dCheckOut;
	private String sCity;
	private int iNoOfRooms;
	private String sMaxPrice;

	// a room type, price, tot_num obtained from room_type table based on City searchtext
	private String sPrice;
	private String sRoomType;
	private int iTotalNum;
	private int iNoOfNot2Book;

	// can be set if found in discount deal list
	private String sSpecialPrice;
	private int iDiscountRate;
	
	// set for displaying the image
	private String sImgPath;

	/**
	 * Empty constructor
	 */
	public SearchResultBean() {
	}
	
	public Date geCheckIn() {
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

	public String getPrice() {
		return sPrice;
	}
	public void setPrice(String sValue) {
		sPrice = sValue;
	}

	public String getSpecialPrice() {
		return sSpecialPrice;
	}
	public void setSpecialPrice(String sValue) {
		sSpecialPrice = sValue;
	}
	public String getMaxPrice() {
		return sMaxPrice;
	}
	public void setMaxPrice(String sValue) {
		sMaxPrice = sValue;
	}
	
	public String getImagePath() {
		return sImgPath;
	}
	public void setImagePath(String sValue) {
		sImgPath = sValue;
	}
	public int getDiscountRate() {
		return iDiscountRate;
	}
	public void setDiscountRate(int iValue) {
		iDiscountRate = iValue;
	}
	public String getRoomType() {
		return sRoomType;
	}
	public void setRoomType(String sValue) {
		sRoomType = sValue;
	}
	public int getTotalNum() {
		return iTotalNum;
	}
	public void setTotalNum(int iValue) {
		iTotalNum = iValue;
	}
	public int getNoOfNot2Book() {
		return iNoOfNot2Book;
	}
	public void setNoOfNot2Book(int iValue) {
		iNoOfNot2Book = iValue;
	}
}
