package controller;
import DAO.StudentDAO;
import domein.Student;

public class StudentController {
	private StudentDAO dao = new StudentDAO();

	public boolean checkCode(int code, boolean done) {
		if(dao.getStudentByCode(code, done) != null)return true; else return false;
	}

	public Student setStudent(Student s, int code, boolean done) {
		s = dao.getStudentByCode(code, done);
		return s;		
	}

	public void setStudentCode(Student s) {
		dao.setStudentCode(s);
		
	}

}
