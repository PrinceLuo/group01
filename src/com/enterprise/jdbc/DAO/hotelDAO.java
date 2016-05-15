package com.enterprise.jdbc.DAO;

import com.enterprise.exception.DataAccessException;

public interface hotelDAO {
	public int getHotelIDOfCity(String sHotelName) throws DataAccessException;
}
