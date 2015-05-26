package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.StudentController;
import domein.Student;

public class StudentcodeServlet extends HttpServlet{
	private StudentController sc = new StudentController();
	private ArrayList<Integer> codes = new ArrayList<Integer>();
	private Student s = new Student();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int aantal = Integer.parseInt(req.getParameter("aantal"));	
		boolean done = false;
		String msgs = "";
		for(int i = 0; i<aantal; i++){
			int getal = (int)(888888*Math.random()+111111);
			if(i==aantal-1){
				done = true;
			}
			if(!sc.checkCode(getal, done)){		
				System.out.println("deze code staat NIET in de database "+getal);
				s.setCode(getal);
				System.out.println(s.getCode());
				sc.setStudentCode(s);
				msgs += getal +"<br />";
			}else{
				System.out.println("deze code staat WEL in de database "+getal);
				aantal++;
			}
		}		
//				
//			}
			
//		}
		RequestDispatcher rd = null;
		req.setAttribute("msgs", msgs);
		rd = req.getRequestDispatcher("/studentcode-aanmaken.jsp");
		rd.forward(req, resp);
	}
}
