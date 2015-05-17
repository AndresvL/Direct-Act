package domein;

public class Vraag {
	private boolean rekenmachine;
	private int nummer;
	private String context;
	private String stelling;
	private enum type{getallen,verhoudingen, verbanden, meetkunde}
	type cat;
	
	public Vraag(boolean rek, int nr, String con, String vrg, String t){
		this.setRekenmachine(rek);
		this.setNummer(nr);
		this.setContext(con);
		this.setStelling(vrg);
		this.setType(t);
		
	}

	public Vraag() {
		// TODO Auto-generated constructor stub
	}

	public void setType(String t){
		for(type tt : type.values()){
			if(tt.name().equals(t)){
				this.cat = tt;
			}
		}
	}
	
	public String getType(){
		return cat.name();
	}
	
	public boolean isRekenmachine() {
		return rekenmachine;
	}

	public void setRekenmachine(boolean rekenmachine) {
		this.rekenmachine = rekenmachine;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getStelling() {
		return stelling;
	}

	public void setStelling(String stelling) {
		this.stelling = stelling;
	}
	
}
	
