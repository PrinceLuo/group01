package com.enterprise.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.naming.*;
import javax.sql.DataSource;
import com.enterprise.exception.ServiceLocatorException;

public class DBConnectionFactory {
	
	static Logger logger = Logger.getLogger(DBConnectionFactory.class.getName());
	private static DBConnectionFactory factory = null;
	private DataSource ds = null;
	private InitialContext ctx;
<<<<<<< HEAD
=======
	private Context subctx;
>>>>>>> e511cfb679815ec157a9bae9c53bbc3ad83768c3
	
	private DBConnectionFactory() throws ServiceLocatorException{
		try{
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Derby");
			logger.info("Database found:"+ds.toString());
		}catch(NamingException e){
			logger.severe("Cannot find context, throwing exception"+e.getMessage());
			e.printStackTrace();
			throw new ServiceLocatorException();
		}
	}
	
	public DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection() throws ServiceLocatorException, SQLException{
		
		if(factory==null)
			factory = new DBConnectionFactory();
		Connection conn = factory.getDataSource().getConnection();
		return conn;
	}

}