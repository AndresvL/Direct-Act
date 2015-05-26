package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import DBUtil.SQLCon;
import domein.Student;

public class StudentDAO {

	public void setStudentCode(Student s) {
		Connection conn = null;
		try {
			conn = SQLCon.getConnection();
			System.out.println("studentcode " + s.getCode());
			PreparedStatement pStmt = conn
					.prepareStatement("insert into student(studentcode)values(?)");
			pStmt.setInt(1, s.getCode());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
	}

	public void createStudent(Student s) {
		Connection conn = null;
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("insert into student(studentcode,school,lesjaar,niveau,geslacht,gemwiskundeCijfer,wanneerBlijvenZitten)values(?,?,?,?,?,?,?,?)");
			pStmt.setInt(1, s.getCode());
			pStmt.setString(2, s.getSchool());
			pStmt.setString(3, s.getLesJaar());
			pStmt.setString(4, s.getNiveau());
			pStmt.setString(6, s.getGeslacht());
			pStmt.setString(7, s.getGemCijfer());
			pStmt.setDate(8, s.getIsBlijvenZitten());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
	}

	public ArrayList<Student> getStudenten() {
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select * from student");
			ResultSet rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getInt("studencode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getString("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getDate("isBlijvenZitten"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return Studenten;

	}

	public ArrayList<Student> getStudentByGeslacht(String ges) {
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select * from student where geslacht = '?'");
			pStmt.setString(1, ges);
			ResultSet rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getInt("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getString("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getDate("isBlijvenZitten"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return Studenten;

	}

	public ArrayList<Student> getStudentByniveau(String niv) {
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select * from student where niveau = '?'");
			pStmt.setString(1, niv);
			ResultSet rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getInt("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getString("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getDate("isBlijvenZitten"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return Studenten;

	}

	public ArrayList<Student> getStudentByLesjaar(String jaar) {
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select * from student where lesjaar = '?'");
			pStmt.setString(1, jaar);
			ResultSet rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getInt("studentcode"));
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getString("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getDate("isBlijvenZitten"));
				Studenten.add(s);
			}
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return Studenten;

	}

	public Student getStudentByCode(int code, boolean done) {
		Connection conn = null;
		Student s = null;
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("SELECT * FROM student WHERE studentcode=?");
			pStmt.setInt(1, code);
			ResultSet rSet = pStmt.executeQuery();
			while (rSet.next()) {
				s = new Student();
				s.setCode(code);
				s.setSchool(rSet.getString("school"));
				s.setJaar(rSet.getString("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setIsBlijvenZitten(rSet.getDate("wanneerBlijvenZitten"));
				s.setGemCijfer(rSet.getString("gemWiskundeCijfer"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(done){
				SQLCon.closeConnection(conn);
			}
		}
		return s;

	}

}
