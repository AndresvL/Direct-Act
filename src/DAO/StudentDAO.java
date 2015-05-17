package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

import DBUtil.GoogleCon;
import domein.Student;

public class StudentDAO {
	private GoogleCon connection = new GoogleCon();

	public void CreateStudent(Student s) {
		Connection conn = null;
		try {
			conn = connection.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("Insert into Student(studentcode, school,lesjaar,niveau,geslacht,gemwiskundeCijfer,wanneerBlijvenZitten)values(?,?,?,?,?,?,?,?)");
			pStmt.setString(1, s.getCode());
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
			GoogleCon.closeConnection(conn);
		}
	}

	public ArrayList<Student> getStudenten() {
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();
		try {
			conn = connection.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select * from student");
			ResultSet rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studencode"));
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
			GoogleCon.closeConnection(conn);
		}
		return Studenten;

	}

	public ArrayList<Student> getStudentByGeslacht(String ges) {
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();
		try {
			conn = connection.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select * from student where geslacht = '?'");
			pStmt.setString(1, ges);
			ResultSet rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studentcode"));
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
			GoogleCon.closeConnection(conn);
		}
		return Studenten;

	}

	public ArrayList<Student> getStudentByniveau(String niv) {
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();
		try {
			conn = connection.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select * from student where niveau = '?'");
			pStmt.setString(1, niv);
			ResultSet rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studentcode"));
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
			GoogleCon.closeConnection(conn);
		}
		return Studenten;

	}

	public ArrayList<Student> getStudentByLesjaar(String jaar) {
		Connection conn = null;
		ArrayList<Student> Studenten = new ArrayList<Student>();
		try {
			conn = connection.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select * from student where lesjaar = '?'");
			pStmt.setString(1, jaar);
			ResultSet rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Student s = new Student();
				s.setCode(rSet.getString("studentcode"));
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
			GoogleCon.closeConnection(conn);
		}
		return Studenten;

	}

	public Student getStudentByCode(String code) {
		Connection conn = null;
		Student s = new Student();
		try {
			conn = connection.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("SELECT * FROM student WHERE studentcode=?");
			pStmt.setInt(1, Integer.parseInt(code));
			ResultSet rSet = pStmt.executeQuery();
			if (rSet.next()) {
				while (rSet.next()) {
					System.out.println("studentnr " + pStmt);
					s.setCode(code);
					s.setSchool(rSet.getString("school"));
					s.setJaar(rSet.getString("lesjaar"));
					s.setNiveau(rSet.getString("niveau"));
					s.setGeslacht(rSet.getString("geslacht"));
					s.setIsBlijvenZitten(rSet.getDate("wanneerBlijvenZitten"));
					s.setGemCijfer(rSet.getString("gemWiskundeCijfer"));
				}
			} else {
				s = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GoogleCon.closeConnection(conn);
		}
		return s;

	}

}
