package com.enterprise.dao;

import java.util.List;

import com.enterprise.beans.RoomBean;

public interface RoomDAO {
	/**
	 * Finds all the phone book entries for a particular user
	 * @param id The id of the user to find
	 * @return A list of all the phonebookbeans owned by this user
	 * @throws DataAccessException When error occurs whle connecting 
	 * to the database
	 */
	List findAllByHotel(int iHotelID);
	
	RoomBean getRoom(String sRoomType, int iHotelID);

}
