package domein;

public class Antwoord {
	private int nummer;
	private String antw;
	private int tijd;
	private enum categorie{getal,meet,verhouding,verband}
	categorie cat;
	public Antwoord(){
	}
	public Antwoord(int nr,String antw,String cat, int t){
		setNummer(nr);
		setAntwoord(antw);
		setCategorie(cat);
		setTijd(t);
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

}
