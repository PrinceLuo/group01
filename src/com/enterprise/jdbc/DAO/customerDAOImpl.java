/**
 * 
 */
package com.enterprise.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	public void insertCart(int customer_id, detailDTO re) throws DataAccessException {
		// TODO Auto-generated method stub
		
		int bookingID = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO booking (id,customer_id) VALUES (default,?)");
			stmt.setInt(1, customer_id);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM booking WHERE customer_id=? AND pin IS null");
			stmt.setInt(1, customer_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				bookingID = rs.getInt("id");
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// add detail
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO detail (id,booking_id, start_date, end_date, hotel_id, room_type_id, extra_bed, level, price) VALUES (default,?,?,?,?,?,?,'pend',?)");
			stmt.setInt(1, bookingID);
			stmt.setString(2, re.getStartdate());
			stmt.setString(3, re.getEnddate());
			stmt.setInt(4, re.getHotelid());
			stmt.setInt(5, re.getRoomtypeid());
			stmt.setInt(6, re.getExtrabed());
			stmt.setBigDecimal(7, re.getPrice());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	@Override
	public detailDTO search(String from, String to, String city, String roomtype) throws DataAccessException {
		// TODO Auto-generated method stub
		
		//calculate the price here
		int hotel_id = 0;
		int avail_num = 0;
		int room_type_id = 0;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date st = new Date();
		Date ed = new Date();
		detailDTO re = new detailDTO();
		re.setStartdate(from);
		re.setEnddate(to);
		//re.setRoomtype(roomtype);
		try {
			st = format.parse(from);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ed = format.parse(to);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayList<Integer> bookinglist = new ArrayList<Integer>();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM hotel WHERE location=?");
			stmt.setString(1, city);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				hotel_id = rs.getInt("id");
				re.setHotelid(hotel_id);;
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM room_type WHERE hotel_id=? AND room_type=?");
			stmt.setInt(1, hotel_id);
			stmt.setString(2, roomtype);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				avail_num = rs.getInt("total_num");
				room_type_id = rs.getInt("id");
				re.setRoomtypeid(room_type_id);
				re.setPrice(rs.getBigDecimal("price"));
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//String type = "maintenance";
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM room WHERE hotel_id=? AND room_type_id=? AND availability=?");
			stmt.setInt(1, hotel_id);
			stmt.setInt(2, room_type_id);
			stmt.setString(3, "maintenance");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				avail_num--;
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM booking WHERE pin IS NOT null");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				bookinglist.add(rs.getInt("id"));
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		while(i<bookinglist.size() && avail_num>0){
			Date start_d = new Date();
			Date end_d = new Date();
			int id = bookinglist.get(i).intValue();
			try {
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM detail WHERE booking_id=?");
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					String start = rs.getString("start_date");
					String end = rs.getString("end_date");
					try {
						start_d = format.parse(start);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						end_d = format.parse(end);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(start_d.after(ed) || end_d.before(st)){
					}else{
						avail_num--;
					}
					
				}
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		if(avail_num>0){
		}else{
			re = null; // no such kind of room 
		}
		return re;
	}

	public bookingDTO getCart(int userID) throws DataAccessException{
		// calculate the price here
		bookingDTO cartlist = new bookingDTO();
		ArrayList<Integer> booking = null;
		ArrayList<detailDTO> details = new ArrayList<detailDTO>();
		try {
			booking = new ArrayList<Integer>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM booking WHERE customer_id=? AND pin is NULL");
			stmt.setInt(1, userID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				booking.add(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(booking!=null){
		for(int i = 0; i<booking.size(); i++){
			try {
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM detail WHERE booking_id=? AND level = 'pend'");
				stmt.setInt(1, booking.get(i));
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					detailDTO detail = new detailDTO();
					detail.setID(rs.getInt("id"));
					detail.setBookingid(rs.getInt("booking_id"));
					detail.setEnddate(rs.getString("end_date"));
					detail.setStartdate(rs.getString("start_date"));
					detail.setExtrabed(rs.getInt("extra_bed"));
					detail.setHotelid(rs.getInt("hotel_id"));
					detail.setRoomtypeid(rs.getInt("room_type_id"));
					detail.setPrice(rs.getBigDecimal("price"));
					details.add(detail);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		if(booking!=null){
			cartlist.setCustomerid(userID);
			cartlist.setDetaillist(details);
			return cartlist;
		}else{
			return null;
		}
	}
}
