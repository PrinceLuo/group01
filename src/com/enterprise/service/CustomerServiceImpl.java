package com.enterprise.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.enterprise.beans.UserBean;
import com.enterprise.exception.DataAccessException;
import com.enterprise.exception.ServiceLocatorException;
import com.enterprise.jdbc.DAO.*;
import com.enterprise.jdbc.*;

public class CustomerServiceImpl implements customerDAO{
	private DBConnectionFactory services;
	/* (non-Javadoc)
	 * @see com.enterprise.business.Service#login(java.lang.String, java.lang.String)
	 */
	public CustomerServiceImpl(){
		try {
			services = new DBConnectionFactory();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
	}
	public CustomerServiceImpl(DBConnectionFactory services) {
		this.services = services;
	}
	

	@Override
	
	
	public void insertCustomer(customerDTO customer) throws DataAccessException {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try {
			con = services.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"insert into customers (id, username, password, nickname, firstname, lastname,"
					+ " email, address, creditcardlist , bookinglist) values (?, ?, ?, ?, ?, ?,?,?,?,?)");
			stmt.setInt(1, customer.getID());
			stmt.setString(2, customer.getUsername());
			stmt.setString(3, customer.getPassword());
			stmt.setString(4, customer.getNickname());
			stmt.setString(5, customer.getFirstname());
			stmt.setString(6, customer.getLastname());
			stmt.setString(7, customer.getEmail());
			stmt.setString(8, customer.getAdd());
			stmt.setObject(9, customer.getCreditcardlist());
			stmt.setObject(10, customer.getBookinglist());
			int n = stmt.executeUpdate();
			if (n != 1)
				throw new DataAccessException("Did not insert one row into database");
		}catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; " + e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	private customerDTO createCustomerDTO(ResultSet rs) throws SQLException {
		customerDTO c = new customerDTO();
		c.setID(rs.getInt("id"));
		c.setFirstname(rs.getString("firstname"));
		c.setLastname(rs.getString("lastname"));
		c.setNickname(rs.getString("nickname"));
		c.setUsername(rs.getString("username"));
		c.setPassword(rs.getString("password"));
		c.setAdd(rs.getString("address"));
		c.setBookinglist((List<bookingDTO>) rs.getObject("bookinglist"));
		c.setCreditcardlist((List<creditcardDTO>) rs.getObject("creditcardlist"));
		c.setEmail(rs.getString("email"));
		return c;
	}
	
	
	@Override
	public customerDTO find(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try {
			con = services.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"select * from customers where username=?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				customerDTO customer = createCustomerDTO(rs);
				stmt.close(); 
				return customer;
			}
		}catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; " + e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void updateCustomer(customerDTO customer) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCart(int customer_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertConfirm(bookingDTO booking) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBooking(detailDTO detail) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBooking(int detail_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmBooking(int cart_id, int confirm_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteconBooking(int confirm_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addconBooking(detailDTO detail) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
