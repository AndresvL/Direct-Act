package domein;

public class Antwoord {
	private int nummer;
	private String antw;
	private int toetsNummer;
	private int tijd;
	private boolean heeftRekenmachineGebruikt;
	private enum categorie{getal,meet,verhouding,verband}
	categorie cat;
	public Antwoord(){
	}
	public Antwoord(int nr,String antw,String cat, int t, int tN){
		setNummer(nr);
		setAntwoord(antw);
		setCategorie(cat);
		setTijd(t);
		setToetsNummer(tN);
	}
	
	public void setNummer(int nr) {
		this.nummer = nr;
		
	}
	public int getNummer(){
		return nummer;
	}
	public String getAntwoord(){
		return antw;
	}
	public void setAntwoord(String antw){
		this.antw = antw;
	}
	public void setCategorie(String t){
		for(categorie tt : categorie.values()){
			if(tt.name().equals(t)){
				this.cat = tt;
			}
		}
	}
	
	public String getCategorie(){
		return cat.toString();
	}
	public void setTijd(int seconden) {
		this.tijd = seconden;
		
	}
	public int getTijd(){
		return tijd;
	}
	public int getToetsNummer() {
		return toetsNummer;
	}
	public void setToetsNummer(int toetsNummer) {
		this.toetsNummer = toetsNummer;
	}
	public boolean heeftRekenmachineGebruikt(boolean b) {
		if(b) heeftRekenmachineGebruikt = true;
		else heeftRekenmachineGebruikt = false;
		return b;
	}

}
