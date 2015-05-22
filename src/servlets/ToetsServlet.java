package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	private Calendar cal = Calendar.getInstance();	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher rd = null;
		if(req.getParameter("button").equals("volgende")){
			Antwoord a = new Antwoord();
			int nrs = (Integer)req.getSession().getAttribute("vraagnummer");
			Vraag huidig = new Vraag(nrs, (String)req.getSession().getAttribute("type"));			
			int nr = huidig.getNummer();
			int uur = (Integer)req.getSession().getAttribute("uren");
			int min = (Integer)req.getSession().getAttribute("minuten");
			int sec = (Integer)req.getSession().getAttribute("seconden");
			a.setNummer(nr);
			a.setTijd(getVraagTijd(sec, min, uur, (System.currentTimeMillis())));
			a.setAntwoord((String)req.getParameter("antwoord"));
			a.setCategorie(huidig.getType());
			a.setToetsNummer((Integer)req.getSession().getAttribute("toetsnummer"));
			a.setVraagNummer(nr);
			a.setHeeftRekenmachineGebruikt(false);
			antw.verwerk(a);		
			if(vrg.isVolgendeVraag(nr + 1) != false){				
				Vraag v = vrg.volgendeVraag(nr + 1);
				if(v.getAfbeelding() == null){
					String blob = "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY/j//z8DAAj8Av6IXwbgAAAAAElFTkSuQmCC";
					v.setAfbeelding(blob);
				}
				req.getSession().setAttribute("vraagnummer", v.getNummer());
				req.getSession().setAttribute("context", v.getContext());
				req.getSession().setAttribute("antwoord", "");
				req.getSession().setAttribute("vraag", v.getVraagstelling());
				req.getSession().setAttribute("plaatje", v.getAfbeelding());
				req.getSession().setAttribute("rekenmachine", v.isRekenmachine());
				rd = req.getRequestDispatcher("/toets-vraag.jsp");
			}else rd = req.getRequestDispatcher("/toets-eind.jsp");
		}
		rd.forward(req,resp);
	}

	public Date getToday(){
        cal = Calendar.getInstance();        
        return cal.getTime();
    }
	private int getVraagTijd(int sec, int min, int ur, long millisecs) {
		Date resultdate = new Date(millisecs);
//		haalt uren, minuten en seconden uit het systeem
		SimpleDateFormat uur = new SimpleDateFormat("HH");
		SimpleDateFormat minuut = new SimpleDateFormat("mm");
		SimpleDateFormat seconde = new SimpleDateFormat("ss");	
//		parsed de tijd in int en maakt secondes van de tijd van de huidige vraag
	    int uurSeconden = Integer.parseInt(uur.format(resultdate))*3600;
	    int minuutSeconden = Integer.parseInt(minuut.format(resultdate))*60;
	    int seconden = Integer.parseInt(seconde.format(resultdate));
	    int totaal = uurSeconden + minuutSeconden + seconden;
//	    maakt secondes van de tijd van de vorige vraag
	    int uSeconden = ur*3600;
	    int mSeconden = min*60;
	    int totaal2 = uSeconden+mSeconden+sec;
	    return totaal-totaal2;
	}	
}
