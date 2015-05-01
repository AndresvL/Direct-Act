package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

import DBUtil.GoogleCon;
import domein.Student;

public class StudentDao
{
	public void CreateStudent(Student s){
		Connection conn = null;
		try{
			conn=GoogleCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("Insert into Student(studentcode, school,lesjaar,niveau,postcode,geslacht,gemCijfer,isBlijvenZitten)values(?,?,?,?,?,?,?,?)");
			pStmt.setString(1, s.getCode());
			pStmt.setString(2, s.getSchool());
			pStmt.setString(3, s.getLesJaar());
			pStmt.setString(4, s.getNiveau());
			pStmt.setString(5, s.getPostcode());
			pStmt.setString(6, s.getGeslacht());
			pStmt.setString(7, s.getGemCijfer());
			pStmt.setString(8, s.getIsBlijvenZitten());
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			GoogleCon.closeConnection(conn);
		}
	}
		public ArrayList<Student> getStudenten(){
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();		
		try {
			conn = GoogleCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from student");
			ResultSet rSet = pStmt.executeQuery();
			while(rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studencode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setPostcode(rSet.getString("postcode"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getString("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			GoogleCon.closeConnection(conn);
		}
		return Studenten;
	
	
	}
	public ArrayList<Student> getStudentByGeslacht(String ges){
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();		
		try {
			conn = GoogleCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from student where geslacht = '?'");
			pStmt.setString(1, ges);
			ResultSet rSet = pStmt.executeQuery();
			while(rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setPostcode(rSet.getString("postcode"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getString("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			GoogleCon.closeConnection(conn);
		}
		return Studenten;
	
	
	}
		public ArrayList<Student> getStudentByniveau(String niv){
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();		
		try {
			conn = GoogleCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from student where niveau = '?'");
			pStmt.setString(1, niv);
			ResultSet rSet = pStmt.executeQuery();
			while(rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setPostcode(rSet.getString("postcode"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getString("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			GoogleCon.closeConnection(conn);
		}
		return Studenten;
	
	
	}
		public ArrayList<Student> getStudentByLesjaar(String jaar){
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();		
		try {
			conn = GoogleCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from student where lesjaar = '?'");
			pStmt.setString(1, jaar);
			ResultSet rSet = pStmt.executeQuery();
			while(rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setPostcode(rSet.getString("postcode"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getString("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			GoogleCon.closeConnection(conn);
		}
		return Studenten;
	
	
	}
		public Student getStudentByCode(String code){
		Connection conn = null;
		Student s = new Student();
		try {
			conn = GoogleCon.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("select * from student where studentcode = '?'");
			pStmt.setString(1, code);
			ResultSet rSet = pStmt.executeQuery();
			while(rSet.next()) {
				s.setCode(rSet.getString("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setPostcode(rSet.getString("postcode"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getString("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
				
			}
			pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			GoogleCon.closeConnection(conn);
		}
		return s;
	
	
	}
	
	}
