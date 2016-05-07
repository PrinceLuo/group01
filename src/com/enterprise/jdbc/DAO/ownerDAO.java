package com.enterprise.jdbc.DAO;

import java.util.List;

import com.enterprise.exception.DataAccessException;
import com.enterprise.jdbc.*;

public interface ownerDAO {
	staffDTO find(String username) throws DataAccessException;
	
	List<roomDTO> getRooms() throws DataAccessException;
	
	void setMaintance(List<roomDTO> rooms) throws DataAccessException;
	
	void insertDiscount(discountDTO discount) throws DataAccessException;
	
}
