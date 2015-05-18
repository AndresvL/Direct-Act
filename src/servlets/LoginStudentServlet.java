package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.VraagController;
import controller.StudentController;
import domein.Student;
import domein.Vraag;

public class LoginStudentServlet extends HttpServlet{

	private static final long serialVersionUID = 194503685680L;
	private StudentController controller = new StudentController();
	private VraagController vc = new VraagController();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Student s = new Student();
		Vraag v = vc.eersteVraag();
		
		RequestDispatcher rd = null;
		String code = req.getParameter("code");
		if(req.getParameter("button").equals("login")){
			if(controller.checkCode(code)){
				controller.setStudent(s,code);
				req.getSession().setAttribute("student", s);
				req.getSession().setAttribute("vraag", v.getVraagstelling());
				req.getSession().setAttribute("vraagnummer", v.getNummer());
				req.getSession().setAttribute("context", v.getContext());
				if(s.isFirstTime())rd = req.getRequestDispatcher("/enquette.jsp");
				else rd=req.getRequestDispatcher("/toets-vraag.jsp");
								
			}else{
				req.setAttribute("msgs", "code bestaat niet");
			rd = req.getRequestDispatcher("/login-student.jsp");
			}
		}
		rd.forward(req, resp);
		
	}
}
