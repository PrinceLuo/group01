package com.enterprise.jdbc.DAO;

import com.enterprise.exception.DataAccessException;
import com.enterprise.jdbc.*;

public interface customerDAO {
	void insertCustomer(customerDTO customer) throws DataAccessException;
	
	customerDTO find(String username) throws DataAccessException;
	
	void updateCustomer(customerDTO customer) throws DataAccessException;
	
	void insertCart(int customer_id) throws DataAccessException;//before the first time user adding detail to cart should employ this 
	
	void insertConfirm(bookingDTO booking) throws DataAccessException;// insert a row in booking table with pin
	
	void insertBooking(detailDTO detail) throws DataAccessException; // insert detail to detail table, bound with booking_id
	
	void deleteBooking(int detail_id) throws DataAccessException;//delete booking detail in detail table
	
	void confirmBooking(int cart_id, int confirm_id) throws DataAccessException;//use cart_id(booking_id without pin), find the booking detail with pending level and change them to confirm, then change their booking_ids to new booking_id = confirm_id(with pin)
	
	void deleteconBooking(int confirm_id) throws DataAccessException;//delete confirmed booking in booking table and detail table
	
	void addconBooking(detailDTO detail) throws DataAccessException;//add booking to detail table with and bond with booking_id (have pin)
	
	
}
