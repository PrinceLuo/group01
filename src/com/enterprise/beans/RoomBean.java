
package com.enterprise.beans;

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
	private int HotelID;
	private String roomType;
	// need more later
	
	/**
	 * Empty constructor
	 */
	public RoomBean() {
	}
	
	public int getHotelID() {
		return HotelID;
	}
	public void setHotelID(int id) {
		HotelID = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String sRoomType) {
		roomType = sRoomType;
	}
	
	
}
