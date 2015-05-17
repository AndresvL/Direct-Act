package DBUtil;

import java.sql.*;

public class SQLCon {
private static Connection conn = null;
	public static void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("Database is connected!");
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}
	public Connection getConnection() {
		connect();
		String url = "jdbc:mysql://localhost:8889/Rekentoets";
		String username = "root";
		String passwd = "root";
		try {
			conn = DriverManager.getConnection(url, username, passwd);
			System.out.println("joepie gelukt");
		} catch (SQLException e) {
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
