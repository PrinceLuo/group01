package com.enterprise.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.enterprise.exception.DataAccessException;
import com.enterprise.exception.ServiceLocatorException;
import com.enterprise.jdbc.DBConnectionFactory;

public class hotelDAOImpl implements hotelDAO {

	private Connection conn;
	
	public hotelDAOImpl(){
		try {
			conn = DBConnectionFactory.getConnection();
		} catch (ServiceLocatorException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getHotelIDOfCity(String sCity) throws DataAccessException {
		int iHotelID = 0;
		try 
 	    {
		     PreparedStatement stmt = conn.prepareStatement("SELECT id, location FROM hotel WHERE location=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     stmt.setString(1, sCity);
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
		     rs.close();
		     stmt.close();
		} 
		catch (Exception e) {
			   System.out.println(e.getMessage());
		} 

		return iHotelID;
	}
	
	public void Dispose() {
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
	
}
