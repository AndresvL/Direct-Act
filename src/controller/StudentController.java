package controller;
import DAO.StudentDAO;
import domein.Student;

public class StudentController {
	private StudentDAO dao = new StudentDAO();

	public boolean checkCode(String code) {
		if(dao.getStudentByCode(code) != null)return true; else return false;
	}

	public Student setStudent(Student s, String code) {
		s = dao.getStudentByCode(code);
		return s;
		
	}

}
