package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author Revature
 *
 *         This is a paceholder class to hold the configurations of your db
 *         connection. You should change the url, username, and password. DO NOT
 *         CHANGE THE MODIFIERS OR THE NAMES OF THE VARIABLES. These are used to
 *         test your db schema.
 */
public class ConnectionUtil {
	//for singleton instance
	private static ConnectionUtil cu;
	
	// add your jdbc url
	public static final String URL = "jdbc:oracle:thin:@rev2004.crnv2jkczn6e.us-east-2.rds.amazonaws.com:1521:ORCL";
	// add your jdbc username
	public static final String USERNAME = "admin";
	// add your jdbc password
	public static final String PASSWORD = "password";
	// name of the created stored procedure in tier 3
	public static final String TIER_3_PROCEDURE_NAME = "user_study_sets";
	// name of the created sequence in tier 3
	public static final String TIER_3_SEQUENCE_NAME = "";

	// implement this method to connect to the db and return the connection object
//	public Connection connect(){
//		return null;
//	}
	public Connection connect(){
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} // end try
		catch (Exception e)
		{
			e.printStackTrace();
		} // end catch
		return conn;
	}


	//implement this method with a callable statement that calls the absolute value sql function
//	public long callAbsoluteValueFunction(long value){
//		return value;
//	}
	public long callAbsoluteValueFunction(long value){
		long abs = 0;
		try (Connection conn = cu.connect()) {

			String sql = "select ABS(?) from dual";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, value);

			ResultSet rs = pstmt.executeQuery(sql);
			
			abs = rs.getLong(0);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return abs;
	}
	

	//make the class into a singleton
	private ConnectionUtil(){
		super();
	}

	public static ConnectionUtil getInstance(){
		if(cu == null){
			cu = new ConnectionUtil();
		}
		return cu;
	}
}
