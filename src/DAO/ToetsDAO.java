package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.GoogleCon;
import domein.Antwoord;
import domein.Vraag;
public class ToetsDAO{

public Vraag getVraagByNr(int nr){
	Connection conn = null;
	Vraag v = null;
	try{
		conn=GoogleCon.getConnection();
		PreparedStatement pStmt = conn.prepareStatement("select * from Vraag where nr = '?'");
		pStmt.setInt(1,nr);
		ResultSet rSet = pStmt.executeQuery();
		v = new Vraag(rSet.getBoolean("rekenmachine"),rSet.getInt("nummer"),rSet.getString("context"),rSet.getString("stelling"), rSet.getString("categorie"));
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		GoogleCon.closeConnection(conn);
	}
	return v;
}

public void addAntwoord(Antwoord a) {
	Connection conn = null;
	try{
		conn=GoogleCon.getConnection();
		PreparedStatement pStmt = conn.prepareStatement("insert into Antwoord values ?,?,?;");
		pStmt.setInt(1, a.getNummer());
		pStmt.setString(2, a.getAntwoord());
		pStmt.setString(3, a.getCategorie());
		pStmt.executeUpdate();
	
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		GoogleCon.closeConnection(conn);
	}
	
}
}