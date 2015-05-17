package DBUtil;

import java.sql.*;

public class SQLCon {
	public static void getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.print("Database is connected!");
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}
	public static void connect(){
		String url = "jdbc:mysql://localhost:8889/Rekentoets";
		String username = "root";
		String passwd = "root";
		try {
			DriverManager.getConnection(url, username, passwd);
			System.out.print("gelukt");
		} catch (SQLException e) {
			System.out.print("niet gelukt"+e);
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection conn){
		try{
			conn.close();
		}catch(Exception e){
			e.getMessage();
		}
	}
}
