package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

import DBUtil.GoogleCon;
import DBUtil.SQLCon;
import domein.Student;

public class StudentDAO
{
	public void CreateStudent(Student s){
		Connection conn = null;
		try{
			conn=SQLCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("Insert into Student(studentcode, school,lesjaar,profiel,niveau,geslacht,gemWiskundeCijfer,wanneerBlijvenZitten,docent_email)values(?,?,?,?,?,?,?,?,?)");
			pStmt.setString(1, s.getCode());
			pStmt.setString(2, s.getSchool());
			pStmt.setString(3, s.getLesJaar());
			pStmt.setString(4, s.getProfiel());
			pStmt.setString(5, s.getNiveau());
			pStmt.setString(6, s.getGeslacht());
			pStmt.setString(7, s.getGemWiskundeCijfer());
			pStmt.setString(8, s.getWanneerBlijvenZitten());
			pStmt.setString(9, s.getDocent());
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			SQLCon.closeConnection(conn);
		}
	}
		public ArrayList<Student> getStudenten(){
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();		
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from student");
			ResultSet rSet = pStmt.executeQuery();
			while(rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setProfiel(rSet.getString("profiel"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemWiskundeCijfer(rSet.getString("gemWiskundeCijfer"));
				s.setWanneerBlijvenZitten(rSet.getString("wanneerBlijvenZitten"));
				s.setDocent(rSet.getString("docent"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return Studenten;
	
	
	}
	public ArrayList<Student> getStudentByGeslacht(String ges){
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();		
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from student where geslacht = '?'");
			pStmt.setString(1, ges);
			ResultSet rSet = pStmt.executeQuery();
			while(rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setProfiel(rSet.getString("profiel"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemWiskundeCijfer(rSet.getString("gemWiskundeCijfer"));
				s.setWanneerBlijvenZitten(rSet.getString("wanneerBlijvenZitten"));
				s.setDocent(rSet.getString("docent"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return Studenten;
	
	
	}
		public ArrayList<Student> getStudentByniveau(String niv){
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();		
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from student where niveau = '?'");
			pStmt.setString(1, niv);
			ResultSet rSet = pStmt.executeQuery();
			while(rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setProfiel(rSet.getString("profiel"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemWiskundeCijfer(rSet.getString("gemWiskundeCijfer"));
				s.setWanneerBlijvenZitten(rSet.getString("wanneerBlijvenZitten"));
				s.setDocent(rSet.getString("docent"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return Studenten;
	
	
	}
		public ArrayList<Student> getStudentByLesjaar(String jaar){
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();		
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from student where lesjaar = '?'");
			pStmt.setString(1, jaar);
			ResultSet rSet = pStmt.executeQuery();
			while(rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setProfiel(rSet.getString("profiel"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemWiskundeCijfer(rSet.getString("gemWiskundeCijfer"));
				s.setWanneerBlijvenZitten(rSet.getString("wanneerBlijvenZitten"));
				s.setDocent(rSet.getString("docent"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return Studenten;
	
	
	}
		public Student getStudentByCode(String code){
		Connection conn = null;
		Student s = new Student();
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from student where studentcode = '?'");
			pStmt.setString(1, code);
			ResultSet rSet = pStmt.executeQuery();
			s.setCode(rSet.getString("studentcode"));
			s.setSchool(rSet.getString("school"));
			s.setJaar(rSet.getString("lesjaar"));
			s.setProfiel(rSet.getString("profiel"));
			s.setNiveau(rSet.getString("niveau"));
			s.setGeslacht(rSet.getString("geslacht"));
			s.setGemWiskundeCijfer(rSet.getString("gemWiskundeCijfer"));
			s.setWanneerBlijvenZitten(rSet.getString("wanneerBlijvenZitten"));
			s.setDocent(rSet.getString("docent"));
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return s;
	
	
	}
	
	}
