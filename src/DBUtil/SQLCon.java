package DBUtil;

import java.sql.*;

public class SQLCon {
	private static Connection conn=null;
	private static String username = "root";
	private static String passwd = "root";
	

	public static Connection getConnection() {
		try{			
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tho7",username,passwd);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("failed to connect to database");
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn){
		try{
			conn.close();
		}catch(Exception e){
			e.getMessage();
		}
	}
}
