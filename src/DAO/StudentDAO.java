package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

import DBUtil.SQLCon;
import domein.Student;

public class StudentDAO {

	public void setStudentCode(Student s, String email) {
		Connection conn = null;
		try {
			conn = SQLCon.getConnection();
			System.out.println("studentcode " + s.getCode());
			PreparedStatement pStmt = conn
					.prepareStatement("insert into student(studentcode,docent_email)values(?,?)");
			pStmt.setInt(1, s.getCode());
			pStmt.setString(2, email);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
	}

	public boolean createStudent(Student s) {
		Connection conn = null;
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("update student set school=?,lesjaar=?,profiel=?,niveau=?,geslacht=?,gemWiskundeCijfer=?,wanneerBlijvenZitten=? where studentcode = ?");
			pStmt.setString(1, s.getSchool());
			pStmt.setInt(2, s.getJaar());
			pStmt.setString(3, s.getProfiel());
			pStmt.setString(4, s.getNiveau());
			pStmt.setString(5, s.getGeslacht());
			pStmt.setDouble(6, s.getGemCijfer());
			pStmt.setString(7, s.getIsBlijvenZitten());
			pStmt.setInt(8, s.getCode());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		return true;
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
				s.setJaar(rSet.getInt("lesjaar"));
				s.setProfiel(rSet.getString("profiel"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getDouble("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
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
				s.setJaar(rSet.getInt("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getDouble("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
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
				s.setJaar(rSet.getInt("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getDouble("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
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
				s.setJaar(rSet.getInt("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setGemCijfer(rSet.getDouble("gemCijfer"));
				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
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
				s.setJaar(rSet.getInt("lesjaar"));
				s.setNiveau(rSet.getString("niveau"));
				s.setGeslacht(rSet.getString("geslacht"));
				s.setIsBlijvenZitten(rSet.getString("wanneerBlijvenZitten"));
				s.setGemCijfer(rSet.getDouble("gemWiskundeCijfer"));
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
