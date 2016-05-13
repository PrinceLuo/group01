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
import com.enterprise.jdbc.staffDTO;

public class ownerDAOImpl implements ownerDAO {
	private Connection con;
	
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
		staffDTO user = new staffDTO();
		// TODO Auto-generated method stub
		try{
			PreparedStatement stmt  = con.prepareStatement("select * from staff where username = ? ");
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				
				user.setID(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("paswword"));
				user.setType(rs.getString("type"));
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
	public List<roomDTO> getRooms(int hotel_id) throws DataAccessException {
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

	@Override
	public List<hotelDTO> getHotels() throws DataAccessException {
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
		// TODO Auto-generated method stub
		try{
			PreparedStatement stmt  = con.prepareStatement("update room set availability = 'maintenance' where id = ? ");
			stmt.setInt(1, roomid);
			int rs = stmt.executeUpdate();
			if(rs!=1)
				System.out.println("set maintenance error");
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
		try{
			PreparedStatement stmt  = con.prepareStatement("select availability from room where id = ?");
			stmt.setInt(1, roomid);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				if (rs.getString("availability") == "available" )
					return true;
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
		return false;
	}

	@Override
	public void insertDiscount(discountDTO discount) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPeak(String name, Date start, Date end) throws DataAccessException {
		// TODO Auto-generated method stub

	}

}
