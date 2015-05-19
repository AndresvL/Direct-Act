package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		if(v.getAfbeelding() == null){
			String blob = "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY/j//z8DAAj8Av6IXwbgAAAAAElFTkSuQmCC";
			v.setAfbeelding(blob);
		}
		
		RequestDispatcher rd = null;
		String code = req.getParameter("code");
		if(req.getParameter("button").equals("login")){
			if(controller.checkCode(code)){
				controller.setStudent(s,code);
				req.getSession().setAttribute("student", s);
				req.getSession().setAttribute("vraag", v.getVraagstelling());
				req.getSession().setAttribute("vraagnummer", v.getNummer());
				req.getSession().setAttribute("context", v.getContext());
				req.getSession().setAttribute("type", v.getType());
				req.getSession().setAttribute("plaatje", v.getAfbeelding());
				req.getSession().setAttribute("rekenmachine", v.isRekenmachine());
				req.getSession().setAttribute("minuten", Calendar.MINUTE);
				req.getSession().setAttribute("seconden", Calendar.SECOND);
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
