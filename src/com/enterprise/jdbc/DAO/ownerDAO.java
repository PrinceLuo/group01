package com.enterprise.jdbc.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.enterprise.exception.DataAccessException;
import com.enterprise.jdbc.*;

public interface ownerDAO {
	staffDTO find(String username) throws DataAccessException;
	
	List<roomDTO> getRooms(int hotel_id, int room_type_id) throws DataAccessException;
	
	List<hotelDTO> getHotels() throws DataAccessException;
	List<roomtypeDTO> getRoomtype(int hotel_id) throws DataAccessException;
	hotelDTO getHotelbyTypeid(int room_type_id) throws DataAccessException;
	int countAllRooms(int hid) throws DataAccessException;
	int countFullRooms(int hid) throws DataAccessException;
	roomtypeDTO getType(int id) throws DataAccessException;
	void setMaintenance(int roomid) throws DataAccessException;
	
	void insertDiscount(discountDTO discount) throws DataAccessException;
	
	void setPeak(String name, String current, String start,String end,int rate) throws DataAccessException;

	boolean checkAvailabiblity(int roomid) throws DataAccessException;
}
