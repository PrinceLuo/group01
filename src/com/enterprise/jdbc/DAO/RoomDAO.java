package com.enterprise.jdbc.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enterprise.beans.RoomBean;
import com.enterprise.exception.DataAccessException;

public interface RoomDAO {
	/**
	 * Finds all the phone book entries for a particular user
	 * @param id The id of the user to find
	 * @return A list of all the phonebookbeans owned by this user
	 * @throws DataAccessException When error occurs whle connecting 
	 * to the database
	 */
	ArrayList<Map<String, String>> findAllByHotel() throws DataAccessException;
	void setRoomType(String sRoomType) throws DataAccessException;
	void setHotelID(int iHotelID) throws DataAccessException;
	RoomBean getRoom() throws DataAccessException;

}
