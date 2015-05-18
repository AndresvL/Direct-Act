package DBUtil;

import java.sql.*;

public class SQLCon {
private static Connection conn = null;
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/rekenen";
		String username = "root";
		String passwd = "admin";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, username, passwd);
			System.out.println("joepie gelukt");
		} catch (Exception e) {
			System.out.print("niet gelukt");
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
