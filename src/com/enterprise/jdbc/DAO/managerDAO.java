package com.enterprise.jdbc.DAO;

import java.util.List;

import com.enterprise.exception.DataAccessException;
import com.enterprise.jdbc.*;

public interface managerDAO {
	staffDTO find(String username) throws DataAccessException;
	List<roomDTO> getFullRooms(int hid) throws DataAccessException;
	List<roomDTO> getRooms(int hid,int tid) throws DataAccessException;//use user id to get rooms in DB
	
	void assignRoom(int roomid) throws DataAccessException;// use room id to assign a room 
	void returnRoom(int roomid) throws DataAccessException;//use room id to return a room
	
	List<detailDTO> getBookings(String pin) throws DataAccessException;// use user id to find hotel_id then find all bookings
	List<detailDTO> getAllBookings(int hid) throws DataAccessException;
}
