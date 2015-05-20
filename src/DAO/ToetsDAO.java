package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DBUtil.GoogleCon;
import DBUtil.SQLCon;
import domein.Antwoord;
import domein.Vraag;
public class ToetsDAO{
	
public Vraag getVraagByNr(int nr){
	 
	Connection conn = null;
	ResultSet rSet;	
	Vraag v = null;
	
	try{
		conn = SQLCon.getConnection();
		PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM vraag WHERE vraagNummer = ?");
		pStmt.setInt(1,nr);
		rSet = pStmt.executeQuery();
		while(rSet.next()){
			v = new Vraag(rSet.getBoolean("heeftRekenmachine"),rSet.getInt("vraagNummer"),rSet.getString("context"),rSet.getBoolean("afbeelding"), rSet.getString("categorie"), rSet.getString("opgave"));
		}
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
		conn = SQLCon.getConnection();
		PreparedStatement pStmt = conn.prepareStatement("insert into antwoord values ?,?,?;");
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