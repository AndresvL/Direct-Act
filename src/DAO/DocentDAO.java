package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.SQLCon;
import domein.Docent;

public class DocentDAO {
	public Docent getDocent(String em, String ww) {
		Connection conn = null;
		Docent d = null;
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from docent where email=? and wachtwoord=?");
			pStmt.setString(1, em);
			pStmt.setString(2, ww);
			ResultSet rSet = pStmt.executeQuery();
			while(rSet.next()){
				d = new Docent();
				d.setEmail(rSet.getString("email"));
				d.setWachtwoord(rSet.getString("wachtwoord"));
				d.setVoornaam(rSet.getString("voornaam"));
				d.setAchternaam(rSet.getString("achternaam"));
				d.setSchoolnaam(rSet.getString("schoolnaam"));
				d.setSchoolplaats(rSet.getString("schoolplaats"));	
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return d;

	}
}
