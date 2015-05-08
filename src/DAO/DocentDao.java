package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import DBUtil.GoogleCon;
import domein.Docent;

public class DocentDao
{
	public void CreateDocent(Docent d){
		Connection conn = null;
		try{
			conn=GoogleCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("Insert into Docent(email, wachtwoord,voornaam,achternaam,schoolnaam,schoolplaats)values(?,?,?,?,?,?)");
			pStmt.setString(1, d.getEmail());
			pStmt.setString(2, d.getWachtwoord());
			pStmt.setString(3, d.getVoornaam());
			pStmt.setString(4, d.getAchternaam());
			pStmt.setString(5, d.getSchoolnaam());
			pStmt.setString(6, d.getSchoolplaats());
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			GoogleCon.closeConnection(conn);
		}
	}
	
	public void RemoveDocent(String email){
		Connection conn = null;

		try{
			conn=GoogleCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("delete from Docent where email = '?'");
			pStmt.setString(1,email);
			pStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			GoogleCon.closeConnection(conn);
		}
	
	}
	
	public void updateDocent(Docent d){
		Connection conn = null;
		try{
			conn=GoogleCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("update Docent set email='?',schoolnaam='?',schoolplaats='?'");
			pStmt.setString(1,d.getEmail());
			pStmt.setString(2,d.getSchoolnaam());
			pStmt.setString(3,d.getSchoolplaats());
			pStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			GoogleCon.closeConnection(conn);
		}
	}
	
	public Docent getDocentByEmail(String email){
		Connection conn = null;
		Docent d = new Docent();
		try{
			conn=GoogleCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from Docent where email = '?'");
			pStmt.setString(1,email);
			pStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			GoogleCon.closeConnection(conn);
		}
		
	}
	
	
}