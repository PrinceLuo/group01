package com.enterprise.jdbc.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.enterprise.beans.RoomBean;
import com.enterprise.beans.SearchBean;
import com.enterprise.beans.SearchResultBean;
import com.enterprise.exception.DataAccessException;
import com.enterprise.exception.ServiceLocatorException;
import com.enterprise.jdbc.DBConnectionFactory;
import com.enterprise.jdbc.DAO.RoomDAO;

public class RoomDAOImpl implements RoomDAO {
	private DBConnectionFactory services;
	private int iHotelID;
	private String sRoomType;
	private BigDecimal bPrice;
	
	private Connection conn;
	
	public RoomDAOImpl() {
		try {
			conn = DBConnectionFactory.getConnection();
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setRoomType(String sRoom_Type) throws DataAccessException {
		sRoomType = sRoom_Type;
	}

	public void setHotelID(int iHotel_ID) throws DataAccessException {
		iHotelID = iHotel_ID;		
	}
	
	public void setPrice(BigDecimal bPrice) throws DataAccessException {
		this.bPrice = bPrice;
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
		     stmt.setInt(1, iHotelID);
		     ResultSet rs = stmt.executeQuery();
		     
		     int iSize = 0;  
		     if (rs != null)   
		     {  
		    	 rs.beforeFirst();  
		    	 rs.last();  
		    	 iSize = rs.getRow();
		     }
		     if (iSize != 0)
		     {    
			     rs.beforeFirst();
			     rs.next();
			     iHotelID = rs.getInt("id");
		     }
		     
		     
		     
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
		   /*finally {
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
		   }*/
		   return list;
	}
	
	/**
	 * @todo Complete the operation
	 * @see com.enterprise.jdbc.DAO.ContactDAO#findAllForUser(int)
	 */
	public ArrayList<Map<String, String>> findAllByHotelPrice() throws DataAccessException {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// TODO get the connection
		// TODO set the parameters
		// TODO add each contact bean to the list (hint - use createContactBean method)
		// TODO catch and throw all the exceptions
		// TODO close the connections

		try 
		   {
		     PreparedStatement stmt = conn.prepareStatement("select * from room_type where hotel_id=? AND price <= ?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     stmt.setInt(1, iHotelID);
		     stmt.setBigDecimal(2, bPrice);
		     ResultSet rs = stmt.executeQuery();
		     
		     int iSize = 0;  
		     if (rs != null)   
		     {  
		    	 rs.beforeFirst();  
		    	 rs.last();  
		    	 iSize = rs.getRow();
		     }
		     if (iSize != 0)
		     {    
			     rs.beforeFirst();
			     rs.next();
			     iHotelID = rs.getInt("id");
		     }

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
		   /*finally {
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
		   }*/
		   return list;
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
		     stmt.setString(1, sRoomType);
		     stmt.setInt(2, iHotelID);
		     ResultSet rs = stmt.executeQuery();
		     // Fetch each row from the result set
		     while (rs.next()) {
		       int iHotel_ID = rs.getInt("hotel_id");
		       String sRoom_Type = rs.getString("room_type");
		       rb.setHotelID (iHotel_ID);
		       rb.setRoomType(sRoom_Type);
		       
		       DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.US);
		       DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
		       //symbols.setCurrencySymbol(""); // Don't use null.
		       formatter.setDecimalFormatSymbols(symbols);
		       rb.setPrice(formatter.format(rs.getDouble("price")));

		       rb.setHotelName(rs.getString("name"));
		       rb.setCity(rs.getString("location"));
		       
		       String sPath = "images/" + sRoom_Type + ".jpg";
		       rb.setImagePath(sPath);
		     }
		   } 
		   catch (Exception e) {
			   //throw new Exception(e.getMessage());
			   System.out.println(e.getMessage());
		   } 
		   /*finally {
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
		   }*/
		   return rb;
	}

	/**
	 * @todo Complete this method
	 * @see com.enterprise.jdbc.DAO.RoomDAO#getDiscountedRooms4Today(string, int)
	 */
	public ArrayList<Map<String, String>> getDiscountedRooms4Today() throws DataAccessException {
	    ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
	    try 
	    {
		     PreparedStatement stmt = conn.prepareStatement(
		       "SELECT r.hotel_id, r.room_type, r.price, h.name, h.location, d.start_date, d.end_date, d.rate FROM discount as d "
		     + "INNER JOIN room_type as r ON d.room_type_id = r.id INNER JOIN hotel as h ON r.hotel_id = h.id "
		     + "WHERE d.start_date <= CURRENT_DATE and d.end_date >= CURRENT_DATE", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     ResultSet rs = stmt.executeQuery();
		     rs.beforeFirst();
		     // Fetch each row from the result set
		     while (rs.next()) {
		    	  Map<String, String> rm = new HashMap<String, String>();
		    	  rm.put("room_type", rs.getString("room_type"));
		    	  
			      DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.US);
			      DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
			      //symbols.setCurrencySymbol(""); // Don't use null.
			      formatter.setDecimalFormatSymbols(symbols); 
		    	  rm.put("price", formatter.format(rs.getDouble("price")));
		    	  
		    	  rm.put("name", rs.getString("name"));
		    	  rm.put("city", rs.getString("location"));  
			      
		    	  rm.put("rate", String.valueOf(rs.getString("rate")));
		    	  
		    	  int iRate = rs.getInt("rate");
			      double dRate = (double)iRate/100.0;
		    	  rm.put("specialprice", formatter.format(rs.getDouble("price")*(1-dRate)));

		    	  String sPath = "images/" + rs.getString("room_type") + ".jpg";
			      rm.put("imagepath", sPath);
		    	  list.add(rm);
		     }
	    } 
	    catch (Exception e) {
		   //throw new Exception(e.getMessage());
		   System.out.println(e.getMessage());
	    } 
	    /*finally {
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
	   }*/
	   return list;
	}

	/**
	 * @todo Complete this method
	 * @see com.enterprise.jdbc.DAO.RoomDAO#SearchRooms(string, int)
	 */
	public SearchResultBean[] SearchRooms(SearchBean sb) throws DataAccessException {
    	SearchResultBean[] srb = null;
	    try 
	    {
	    	String sQuery = "";
	    		
	    	// Check available Room types of the city
	    	hotelDAOImpl h = new hotelDAOImpl();
	    	setHotelID(h.getHotelIDOfCity(sb.getCity()));
	    	
	    	BigDecimal bMoney = new BigDecimal(0);
	    	
	    	if (sb.getMaxPrice() != null) 
	    		bMoney = new BigDecimal(sb.getMaxPrice());
	    	
	    	BigDecimal bZero = new BigDecimal(0);
	    	ArrayList ar = null;
	    	if (bMoney.compareTo(bZero) > 0)
	    	{
	    		setPrice(bMoney);
	    		ar = findAllByHotelPrice();
	    	}
	    	else
	    		ar = findAllByHotel();
	    	
	        DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.US);
	        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
	        //symbols.setCurrencySymbol(""); // Don't use null.
	       
	        formatter.setDecimalFormatSymbols(symbols);
	        srb = new SearchResultBean[ar.size()];
		    for (int i = 0; i < ar.size(); i++) {
				srb[i] = new SearchResultBean();
				Map<String, String> m = (Map<String, String>) ar.get(i);
				srb[i].setRoomType(m.get("room_type"));

				srb[i].setPrice(formatter.format(Double.parseDouble(m.get("price")))); 
				srb[i].setCity(sb.getCity());
				srb[i].setTotalNum(Integer.parseInt(m.get("total_num")));

		    	String sPath = "images/" + srb[i].getRoomType() + ".jpg";
			    srb[i].setImagePath(sPath);

				// check rooms that are not available -> remove rooms marked as unavailable in room table
				//sb.getCheckIn();
				//sb.getCheckOut();
				//sb.getCity();
				//sb.getNoOfRooms();
				//sb.getMaxPrice();
				PreparedStatement stmt = conn.prepareStatement(
				       "SELECT rt.room_type, rt.hotel_id, rt.id, r.availability FROM room AS r "
				     + "INNER JOIN room_type AS rt ON r.room_type_id = rt.id "
				     + "WHERE rt.room_type=? AND rt.hotel_id=? AND r.availability<>'available'", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			    
				stmt.setString(1, srb[i].getRoomType());
			    stmt.setInt(2, iHotelID);
				     
				ResultSet rs = stmt.executeQuery();
				
			    int iNot2Book = 0;  
			    if (rs != null)   
			    {  
			    	 rs.beforeFirst();  
			    	 rs.last();  
			    	 iNot2Book = rs.getRow();
			    }

    			// check detail table -> exclude rooms booked for the check-in time  			
	
				PreparedStatement stmt2 = conn.prepareStatement(
				       "SELECT d.start_date, d.end_date, d.hotel_id, d.num_rooms, r.room_type, r.hotel_id FROM detail as d "
				     + "INNER JOIN room_type as r ON d.room_type_id = r.id "
				     + "WHERE (d.start_date>=? AND d.start_date<=? OR d.end_date>=? AND d.end_date<=?) AND r.hotel_id=? AND r.room_type=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				stmt2.setString(1, sb.getCheckIn());
				stmt2.setString(2, sb.getCheckOut());
				stmt2.setString(3, sb.getCheckIn());
				stmt2.setString(4, sb.getCheckOut());
			    stmt2.setInt(5, iHotelID);
				stmt2.setString(6, srb[i].getRoomType());
			    ResultSet rs2 = stmt2.executeQuery();
			     
			    rs2.beforeFirst();
			     
			    // Fetch each row from the result set
			    while (rs2.next()) {
			    	iNot2Book += Integer.parseInt(rs2.getString("num_rooms")); 	 
			    }
			    
			    srb[i].setNoOfNot2Book(iNot2Book);
			}
	    } 
	    catch (Exception e) {
		   //throw new Exception(e.getMessage());
		   System.out.println(e.getMessage());
	    } 
	    /*finally {
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
	   }*/
	   return srb;
	}

}

