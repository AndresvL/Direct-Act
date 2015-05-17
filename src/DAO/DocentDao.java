package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import DBUtil.GoogleCon;
import domein.Docent;
import domein.Gebruiker;

public class DocentDao
{
	private GoogleCon connection = new GoogleCon();
	public void CreateDocent(Docent d){
		Connection conn = null;
		try{
			conn = connection.getConnection();
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
			conn = connection.getConnection();
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
			conn = connection.getConnection();
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
			conn = connection.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from Docent where email = '?'");
			pStmt.setString(1,email);
			ResultSet rSet = pStmt.executeQuery();
			d.setEmail(rSet.getString("email"));
			d.setVoornaam(rSet.getString("voornaam"));
			d.setAchternaam(rSet.getString("achternaam"));
			d.setWachtwoord(rSet.getString("wachtwoord"));
			d.setSchoolnaam(rSet.getString("schoolplaats"));
			d.setSchoolplaats(rSet.getString("schoolplaats"));
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			GoogleCon.closeConnection(conn);
		}
		return d;
		
	}
	
	
}