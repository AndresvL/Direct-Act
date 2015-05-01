package domein;

public abstract class Gebruiker {
	protected String username;
	
	public Gebruiker(String uName){
		username = uName;
	}
	protected void setUsername(String uName){
		username = uName;
	}
	protected String getUsername(){
		return username;
	}
	
}
