
package com.enterprise.jdbc.DAO;

import java.sql.*;
import java.util.List;

import com.enterprise.exception.DataAccessException;
import com.enterprise.exception.ServiceLocatorException;
import com.enterprise.jdbc.DBConnectionFactory;
import com.enterprise.jdbc.detailDTO;
import com.enterprise.jdbc.roomDTO;
import com.enterprise.jdbc.staffDTO;

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
				staff = new staffDTO(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("staff_type"));
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
	public List<roomDTO> getRooms(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.managerDAO#assignRoom(int)
	 */
	@Override
	public void assignRoom(int id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.managerDAO#returnRoom(int)
	 */
	@Override
	public void returnRoom(int id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.enterprise.jdbc.DAO.managerDAO#getBookings(int)
	 */
	@Override
	public List<detailDTO> getBookings(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
