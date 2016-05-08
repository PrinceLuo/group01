package com.enterprise.dao.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enterprise.beans.RoomBean;
import com.enterprise.jdbc.DBConnectionFactory;
import com.enterprise.dao.RoomDAO;

public class RoomDAOImpl implements RoomDAO {
	private DBConnectionFactory services;
	
	public RoomDAOImpl() {}
	
	/**
	 * @todo Complete the operation
	 * @see com.enterprise.dao.ContactDAO#findAllForUser(int)
	 */
	public List findAllByHotel(int id) {
		List list = new ArrayList();
		// TODO get the connection
		// TODO set the parameters
		// TODO add each contact bean to the list (hint - use createContactBean method)
		// TODO catch and throw all the exceptions
		// TODO close the connections
		   Connection con = null;
		   try 
		   {
		     con = services.getConnection();
		     PreparedStatement stmt = con.prepareStatement(
		       "select * from room_type where hotel_id=?");
		     stmt.setInt(1, id);
		     ResultSet rs = stmt.executeQuery();
		  // Fetch each row from the result set
		     while (rs.next()) {
		       //int i = rs.getInt("hotel_id");
		       String str = rs.getString("room_type");

		       list.add(str);	
		     }
		   } 
		   catch (Exception e) {
			   //throw new Exception(e.getMessage());
			   System.out.println(e.getMessage());
		   } 
		   finally {
		      if (con != null) 
		      {
		         try {
		           con.close();
		         } 
		         catch (SQLException e1) 
		         {
		           e1.printStackTrace();
		         }
		      }
		   }
		   return list;
	}
	
	/**
	 * @todo Complete this method
	 * @see com.enterprise.dao.RoomDAO#getRoom(string, int)
	 */
	public RoomBean getRoom(String sRoomType, int iHotelID) {

		// TODO get the connection
		// TODO create the prepared statement
		// TODO set the parameters
		// TODO create the contact bean
		// TODO catch and throw all the required parameters 
		// TODO close the connections and result sets
		RoomBean rb = new RoomBean();
		   Connection con = null;
		   try 
		   {
		     con = services.getConnection();
		     PreparedStatement stmt = con.prepareStatement(
		       "select * from room_type where room_type='?' and hotel_id=?");
		     stmt.setInt(1, sRoomType);
		     stmt.setInt(1, iHotelID);
		     ResultSet rs = stmt.executeQuery();
		  // Fetch each row from the result set
		     while (rs.next()) {
		       int i = rs.getInt("hotel_id");
		       String str = rs.getString("room_type");
		       rb.setHotelID (i);
		       rb.setRoomType(str);
		     }
		   } 
		   catch (Exception e) {
			   //throw new Exception(e.getMessage());
			   System.out.println(e.getMessage());
		   } 
		   finally {
		      if (con != null) 
		      {
		         try {
		           con.close();
		         } 
		         catch (SQLException e1) 
		         {
		           e1.printStackTrace();
		         }
		      }
		   }
		   return rb;
	}

}
