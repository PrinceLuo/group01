/**
 * 
 */
package com.enterprise.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.enterprise.exception.DataAccessException;
import com.enterprise.exception.ServiceLocatorException;
import com.enterprise.jdbc.DBConnectionFactory;
import com.enterprise.jdbc.bookingDTO;
import com.enterprise.jdbc.customerDTO;
import com.enterprise.jdbc.detailDTO;
import com.enterprise.jdbc.staffDTO;

/**
 * @author user
 *
 */
public class customerDAOImpl implements customerDAO {

	private Connection conn;
	
	public customerDAOImpl() {
		try {
			conn = DBConnectionFactory.getConnection();
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.customerDAO#insertCustomer(com.enterprise.jdbc.customerDTO)
	 */
	@Override
	public void insertCustomer(customerDTO customer) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer (id,username,password,email) VALUES (default,?,?,?)");
			stmt.setString(1, customer.getUsername());
			stmt.setString(2, customer.getPassword());
			stmt.setString(3, customer.getEmail());
			stmt.executeUpdate(); //The statement was aborted because it would have caused a duplicate key value in a unique or primary key constraint or unique index identified by 'SQL160509020941410' defined on 'CUSTOMER'
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.customerDAO#find(java.lang.String)
	 */
	@Override
	public customerDTO find(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		
		customerDTO customer = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE username=?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			//if(rs.isBeforeFirst()==true){
			while (rs.next()){
				customer = new customerDTO(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"));
				customer.setNickname(rs.getString("nickname"));
				customer.setFirstname(rs.getString("firstname"));
				customer.setLastname(rs.getString("lastname"));
				customer.setAdd(rs.getString("address"));
				customer.setCardnum(rs.getString("card_num"));
				customer.setCardtype(rs.getString("card_type"));
			} 
			stmt.close();
			//}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.customerDAO#updateCustomer(com.enterprise.jdbc.customerDTO)
	 */
	@Override
	public void updateCustomer(customerDTO customer) throws DataAccessException {
		// TODO Auto-generated method stub

		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE customer SET nickname=?,firstname=?,lastname=?,email=?,address=?,card_num=?,card_type=? WHERE username=?");
			stmt.setString(1, customer.getNickname());
			stmt.setString(2, customer.getFirstname());
			stmt.setString(3, customer.getLastname());
			stmt.setString(4, customer.getEmail());
			stmt.setString(5, customer.getAdd());
			stmt.setString(6, customer.getCardnum());
			stmt.setString(7, customer.getCardtype());
			stmt.setString(8, customer.getUsername());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.customerDAO#insertCart(int)
	 */
	@Override
	public void insertCart(int customer_id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.customerDAO#insertConfirm(com.enterprise.jdbc.bookingDTO)
	 */
	@Override
	public void insertConfirm(bookingDTO booking) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.customerDAO#insertBooking(com.enterprise.jdbc.detailDTO)
	 */
	@Override
	public void insertBooking(detailDTO detail) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.customerDAO#deleteBooking(int)
	 */
	@Override
	public void deleteBooking(int detail_id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.customerDAO#confirmBooking(int, int)
	 */
	@Override
	public void confirmBooking(int cart_id, int confirm_id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.customerDAO#deleteconBooking(int)
	 */
	@Override
	public void deleteconBooking(int confirm_id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.customerDAO#addconBooking(com.enterprise.jdbc.detailDTO)
	 */
	@Override
	public void addconBooking(detailDTO detail) throws DataAccessException {
		// TODO Auto-generated method stub

	}

}
