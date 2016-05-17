package com.enterprise.jdbc.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enterprise.exception.DataAccessException;
import com.enterprise.exception.ServiceLocatorException;
import com.enterprise.jdbc.DBConnectionFactory;
import com.enterprise.jdbc.discountDTO;
import com.enterprise.jdbc.hotelDTO;
import com.enterprise.jdbc.roomDTO;
import com.enterprise.jdbc.roomtypeDTO;
import com.enterprise.jdbc.staffDTO;

public class ownerDAOImpl implements ownerDAO {
	private Connection con = null;
	
	public ownerDAOImpl() {
		
		try {
			con = DBConnectionFactory.getConnection();
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public staffDTO find(String username) throws DataAccessException {
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		staffDTO user = new staffDTO();
		// TODO Auto-generated method stub
		try{
			PreparedStatement stmt  = con.prepareStatement("select * from staff where username = ? ");
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				
				user.setID(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("staff_type"));
				stmt.close();
				return user;
			}
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}
			
		
		return user;
	}
	@Override
	public List<roomDTO> getRooms(int hotel_id, int room_type_id) throws DataAccessException {
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<roomDTO> rooms = new ArrayList<roomDTO>();
		try{
			PreparedStatement stmt  = con.prepareStatement("select * from room where hotel_id = ? and room_type_id = ?");
			stmt.setInt(1, hotel_id);
			stmt.setInt(2, room_type_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				roomDTO r = new roomDTO();
				r.setID(rs.getInt("id"));
				r.setNumber(rs.getInt("room_number"));
				r.setAvailability(rs.getString("availability"));
				rooms.add(r);
			}
			stmt.close();
			return rooms;
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}	
	}

	@Override
	public List<hotelDTO> getHotels() throws DataAccessException {
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<hotelDTO> hotels = new ArrayList<hotelDTO>();
		// TODO Auto-generated method stub
		try{
			PreparedStatement stmt  = con.prepareStatement("select * from hotel");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				hotelDTO h = new hotelDTO();
				h.setID(rs.getInt("id"));
				h.setName(rs.getString("name"));
				h.setLocation(rs.getString("location"));
				hotels.add(h);
			}
			stmt.close();
			return hotels;
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public int countAllRooms(int hid) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countFullRooms(int hid) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMaintenance(int roomid) throws DataAccessException {
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		try{
			PreparedStatement stmt  = con.prepareStatement("update room set availability = 'maintenance' where id = ? ");
			stmt.setInt(1, roomid);
			stmt.executeUpdate();
			//PreparedStatement stmt1  = con.prepareStatement("select room_type_id from room where id = ? ");
			//stmt1.setInt(1, roomid);
			//ResultSet rs = stmt1.executeQuery();
			//int id = rs.getInt("room_type_id");
			//PreparedStatement stmt2 = con.prepareStatement("select total_num from room_type where id=? ");
			//stmt2.setInt(1, id);
			//int cur_num = rs.getInt("total_num");
			//cur_num = cur_num -1;
			//PreparedStatement stmt3  = con.prepareStatement("update room_type set total_num = ? where id = ? ");
			//stmt3.setInt(1, cur_num);
			//stmt3.setInt(2, id);
			//stmt3.executeUpdate();
			stmt.close();
			//stmt1.close();
			//stmt2.close();
			//stmt3.close();
		}catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}

	}
	@Override
	public boolean checkAvailabiblity(int roomid) throws DataAccessException{
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try{
			PreparedStatement stmt  = con.prepareStatement("select availability from room where id = ?");
			stmt.setInt(1, roomid);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				if ("available".equals(rs.getString("availability")) )
					return true;
				return false;
			}
			stmt.close();
				
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public void insertDiscount(discountDTO discount) throws DataAccessException {
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		try{
			PreparedStatement stmt  = con.prepareStatement("insert into discount (id,room_type_id,hotel_id,cur_date,start_date,end_date,rate) values (default,?,?,?,?,?,?)");
			stmt.setInt(1, discount.getRoomtypeid());
			stmt.setInt(2, discount.getHotelid());
			stmt.setString(3, discount.getCurrentdate());
			stmt.setString(4, discount.getStartdate());
			stmt.setString(5, discount.getEnddate());
			stmt.setInt(6, discount.getRate());
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void setPeak(String name, String current, String start, String end, int rate) throws DataAccessException {
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try{
			PreparedStatement stmt = con.prepareStatement("insert into peak (id, name, cur_date, start_date, end_date, rate) values (default,?,?,?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, current);
			stmt.setString(3, start);
			stmt.setString(4, end);
			stmt.setInt(5, rate);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}	
	}


	@Override
	public List<roomtypeDTO> getRoomtype(int hotel_id) throws DataAccessException {
		// TODO Auto-generated method stub
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<roomtypeDTO> roomt = new ArrayList<roomtypeDTO>();
		try{
			PreparedStatement stmt  = con.prepareStatement("select * from room_type where hotel_id = ?");
			stmt.setInt(1, hotel_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				roomtypeDTO r = new roomtypeDTO();
				r.setID(rs.getInt("id"));
				r.setRoomtype(rs.getString("room_type"));
				r.setNum(rs.getInt("total_num"));
				roomt.add(r);
			}
			stmt.close();
			return roomt;
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}	
	}
	@Override
	public hotelDTO getHotel(int id) throws DataAccessException {
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try{
			PreparedStatement stmt  = con.prepareStatement("select * from hotel where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				hotelDTO h = new hotelDTO();
				h.setID(rs.getInt("id"));
				h.setName(rs.getString("name"));
				h.setLocation(rs.getString("location"));
				stmt.close();
				return h;
			}

		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}
		return null;
	}
	@Override
	public roomtypeDTO getType(String type, int hotelid) throws DataAccessException {
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try{
			PreparedStatement stmt  = con.prepareStatement("select * from room_type where hotel_id = ? and room_type = ?");
			stmt.setInt(1, hotelid);
			stmt.setString(2, type);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				roomtypeDTO r = new roomtypeDTO();
				r.setID(rs.getInt("id"));
				r.setRoomtype(rs.getString("room_type"));
				stmt.close();
				return r;
			}

		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}
		return null;
	}
	@Override
	public List<roomDTO> getRoomsbyHotel(int hotel_id) throws DataAccessException {
		// TODO Auto-generated method stub
		if (con == null){
			try {
				con = DBConnectionFactory.getConnection();
			} catch (ServiceLocatorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<roomDTO> rooms = new ArrayList<roomDTO>();
		try{
			PreparedStatement stmt  = con.prepareStatement("select * from room where hotel_id = ?");
			stmt.setInt(1, hotel_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				roomDTO r = new roomDTO();
				r.setID(rs.getInt("id"));
				r.setNumber(rs.getInt("room_number"));
				r.setAvailability(rs.getString("availability"));
				rooms.add(r);
			}
			stmt.close();
			return rooms;
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}	
	}



}
