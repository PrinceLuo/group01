package com.enterprise.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.enterprise.beans.RoomBean;
import com.enterprise.exception.DataAccessException;
import com.enterprise.exception.ServiceLocatorException;
import com.enterprise.jdbc.DBConnectionFactory;
import com.enterprise.jdbc.DAO.RoomDAO;

public class RoomDAOImpl implements RoomDAO {
	private DBConnectionFactory services;
	private int HotelID;
	private String RoomType;
	
	private Connection conn;
	
	public RoomDAOImpl() {
		try {
			conn = DBConnectionFactory.getConnection();
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @todo Complete the operation
	 * @see com.enterprise.jdbc.DAO.ContactDAO#findAllForUser(int)
	 */
	public ArrayList<Map<String, String>> findAllByHotel() throws DataAccessException {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// TODO get the connection
		// TODO set the parameters
		// TODO add each contact bean to the list (hint - use createContactBean method)
		// TODO catch and throw all the exceptions
		// TODO close the connections

		try 
		   {
		     PreparedStatement stmt = conn.prepareStatement("select * from room_type where hotel_id=?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     stmt.setInt(1, HotelID);
		     ResultSet rs = stmt.executeQuery();
		     rs.beforeFirst();
		     
		  // Fetch each row from the result set
		     while (rs.next()) {
		         //int i = rs.getInt("hotel_id");
		    	
		    	  Map<String, String> rm = new HashMap<String, String>();
		    	  rm.put("room_type", rs.getString("room_type"));
		    	  rm.put("price", rs.getString("price"));
		    	  rm.put("total_num", rs.getString("total_num"));
		    	  rm.put("hotel_id", rs.getString("hotel_id"));
		    	  list.add(rm);
		     }
		   } 
		   catch (Exception e) {
			   //throw new Exception(e.getMessage());
			   System.out.println(e.getMessage());
		   } 
		   finally {
		      if (conn != null) 
		      {
		         try {
		           conn.close();
		         } 
		         catch (SQLException e1) 
		         {
		           e1.printStackTrace();
		         }
		      }
		   }
		   return list;
	}
	
	public void setRoomType(String sRoomType) throws DataAccessException {
		RoomType = sRoomType;
	}

	public void setHotelID(int iHotelID) throws DataAccessException {
		HotelID = iHotelID;		
	}
	
	/**
	 * @todo Complete this method
	 * @see com.enterprise.jdbc.DAO.RoomDAO#getRoom(string, int)
	 */
	public RoomBean getRoom() throws DataAccessException {

		// TODO get the connection
		// TODO create the prepared statement
		// TODO set the parameters
		// TODO create the contact bean
		// TODO catch and throw all the required parameters 
		// TODO close the connections and result sets
		RoomBean rb = new RoomBean();
		   try 
		   {
		     PreparedStatement stmt = conn.prepareStatement(
		       "SELECT r.hotel_id, r.room_type, r.price, h.id, h.name, h.location FROM room_type AS r INNER JOIN hotel AS h ON r.hotel_id = h.id WHERE r.room_type=? and h.id=?", ResultSet.TYPE_SCROLL_SENSITIVE,
	            ResultSet.CONCUR_UPDATABLE);
		     stmt.setString(1, RoomType);
		     stmt.setInt(2, HotelID);
		     ResultSet rs = stmt.executeQuery();
		     // Fetch each row from the result set
		     while (rs.next()) {
		       int iHotelID = rs.getInt("hotel_id");
		       String sRoomType = rs.getString("room_type");
		       rb.setHotelID (iHotelID);
		       rb.setRoomType(sRoomType);
		       
		       DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.US);
		       DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
		       //symbols.setCurrencySymbol(""); // Don't use null.
		       formatter.setDecimalFormatSymbols(symbols);
		       rb.setPrice(formatter.format(rs.getDouble("price")));

		       rb.setHotelName(rs.getString("name"));
		       rb.setCity(rs.getString("location"));
		       
		       String sPath = "images/" + sRoomType + ".jpg";
		       rb.setImagePath(sPath);
		     }
		   } 
		   catch (Exception e) {
			   //throw new Exception(e.getMessage());
			   System.out.println(e.getMessage());
		   } 
		   finally {
		      if (conn != null) 
		      {
		         try {
		           conn.close();
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
