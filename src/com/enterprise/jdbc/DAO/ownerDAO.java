package com.enterprise.jdbc.DAO;

import java.sql.Date;
import java.util.List;

import com.enterprise.exception.DataAccessException;
import com.enterprise.jdbc.*;

public interface ownerDAO {
	staffDTO find(String username) throws DataAccessException;
	
	List<roomDTO> getRooms() throws DataAccessException;
	
	List<hotelDTO> getHotels() throws DataAccessException;
	
	int countAllRooms(int hid) throws DataAccessException;
	int countFullRooms(int hid) throws DataAccessException;
	
	void setMaintance(int roomid) throws DataAccessException;
	
	void insertDiscount(discountDTO discount) throws DataAccessException;
	
	void setPeak(String name, Date start,Date end) throws DataAccessException;
	
}
