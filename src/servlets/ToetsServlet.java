package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AntwoordController;
import controller.VraagController;
import domein.Vraag;
import domein.Antwoord;


public class ToetsServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1120482309534L;
	private AntwoordController antw = new AntwoordController();
	private VraagController vrg = new VraagController();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher rd = null;
		if(req.getParameter("button").equals("volgende")){
			Antwoord a = new Antwoord();
			int nrs = (Integer)req.getSession().getAttribute("vraagnummer");
			Vraag huidig = new Vraag(nrs, (String)req.getSession().getAttribute("type"));
			
			int nr = huidig.getNummer();
			a.setNummer(nr);
			a.setAntwoord((String)req.getParameter("antwoord"));
			a.setCategorie(huidig.getType());
			antw.verwerk(a);
			if(vrg.isVolgendeVraag(nr + 1) != false){
				Vraag v = vrg.volgendeVraag(nr + 1);
				req.getSession().setAttribute("vraagnummer", v.getNummer());
				req.getSession().setAttribute("context", v.getContext());
				req.getSession().setAttribute("antwoord", "");
				req.getSession().setAttribute("vraag", v.getVraagstelling());
				rd = req.getRequestDispatcher("/toets-vraag.jsp");
			}else rd = req.getRequestDispatcher("/toets-eind.jsp");
		}
		rd.forward(req,resp);
	}
	
}
