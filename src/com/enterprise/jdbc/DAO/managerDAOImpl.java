
package com.enterprise.jdbc.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.enterprise.exception.DataAccessException;
import com.enterprise.exception.ServiceLocatorException;
import com.enterprise.jdbc.DBConnectionFactory;
import com.enterprise.jdbc.detailDTO;
import com.enterprise.jdbc.roomDTO;
import com.enterprise.jdbc.*;

/**
 * @author group01
 *
 */
public class managerDAOImpl implements managerDAO {
	private Connection conn;
	
	public managerDAOImpl() {
		
		try {
			conn = DBConnectionFactory.getConnection();
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.managerDAO#find(java.lang.String)
	 */
	@Override
	public staffDTO find(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		staffDTO staff = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM staff WHERE username=?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			//if(rs.isBeforeFirst()==true){
			while (rs.next()){
				int id = rs.getInt("id");
				String managername = rs.getString("username");
				String password = rs.getString("password");
				String type = rs.getString("staff_type");
				int hotelid=rs.getInt("hotelid");
				staff = new staffDTO(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("staff_type"),hotelid);
			}
			stmt.close();
			//}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;
	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.managerDAO#getRooms(int)
	 */
	
	@Override
	public List<detailDTO> getAllBookings(int hotelid) throws DataAccessException {
		// TODO Auto-generated method stub
		List<detailDTO> bookings=new ArrayList();
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT * FROM detail where hotel_id=? and (select curdate()) <=end_date and pin is not null");
			stmt.setInt(1, hotelid);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				int id = rs.getInt("id");
				int bid = rs.getInt("booking_id");
				String pin=rs.getString("pin");
				Date start=rs.getDate("start_date");
				Date end=rs.getDate("end_date");
				int hid=rs.getInt("hotel_id");
				int tid=rs.getInt("room_type_id");
				int extrabed=rs.getInt("extra_bed");
				int numRooms=rs.getInt("num_rooms");
				detailDTO d = new detailDTO(id,bid,pin,start,end,hid,tid,extrabed,numRooms,null);
				bookings.add(d);
			}
			stmt.close();
			return bookings;
			//}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<roomDTO> getFullRooms(int hotelid) throws DataAccessException {
		// TODO Auto-generated method stub
		List<roomDTO> rooms=new ArrayList();
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT * FROM room WHERE availability=? and hotel_id=?");
			stmt.setString(1, "occupied");
			stmt.setInt(2, hotelid);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				int id = rs.getInt("id");
				int rtid = rs.getInt("room_type_id");
				int hid = rs.getInt("hotel_id");
				int n=rs.getInt("number");
				String a = rs.getString("availability");
				roomDTO room = new roomDTO(id,rtid,hid,n,a);
				rooms.add(room);
			}
			stmt.close();
			return rooms;
			//}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<detailDTO> getBookings(String pin) throws DataAccessException {
		// TODO Auto-generated method stub
		List<detailDTO> details=null;
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT * FROM booking where pin=?");
			stmt.setString(1, pin);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			List<detailDTO> d=(List<detailDTO>) rs.getObject("detaillist");
			details=d;
			
			stmt.close();
			return details;
			//}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<roomDTO> getRooms(int hotelid,int tid) throws DataAccessException {
		// TODO Auto-generated method stub
		List<roomDTO> rooms=new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT * FROM room where hotel_id=? and room_type_id=? and availability=?");
			stmt.setInt(1, hotelid);
			stmt.setInt(2, tid);
			stmt.setString(3, "available");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				int id = rs.getInt("id");
				int rtid = rs.getInt("room_type_id");
				int hid = rs.getInt("hotel_id");
				int n=rs.getInt("number");
				String a = rs.getString("availability");
				roomDTO room = new roomDTO(id,rtid,hid,n,a);
				rooms.add(room);
			}
			stmt.close();
			return rooms;
			//}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.managerDAO#assignRoom(int)
	 */
	@Override
	public void assignRoom(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"update room set availability=? where room_id=?  ");
			stmt.setString(1, "occupied");
			stmt.setInt(2, id);
			int n= stmt.executeUpdate();
			stmt.close();
			if(n!=1){
				System.out.println("assignRoom error");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.managerDAO#returnRoom(int)
	 */
	@Override
	public void returnRoom(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"update room set availability=? where room_id=?  ");
			stmt.setString(1, "available");
			stmt.setInt(2, id);
			int n= stmt.executeUpdate();
			stmt.close();
			if(n!=1){
				System.out.println("returnRoom error");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.managerDAO#getBookings(int)
	 */
	

}
