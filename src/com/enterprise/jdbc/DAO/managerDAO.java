package com.enterprise.jdbc.DAO;

import java.util.List;

import com.enterprise.exception.DataAccessException;
import com.enterprise.jdbc.*;

public interface managerDAO {
	staffDTO find(String username) throws DataAccessException;
	
	List<roomDTO> getRooms(int id) throws DataAccessException;//use user id to get rooms in DB
	
	void assignRoom(int id) throws DataAccessException;// use room id to assign a room 
	void returnRoom(int id) throws DataAccessException;//use room id to return a room
	List<detailDTO> getBookings(int id) throws DataAccessException;// use user id to find hotel_id then find all bookings
}
