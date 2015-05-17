package domein;

public class Student{

	private boolean firstTime;
	private String code;
	private String school;
	private String lesjaar;
	private String profiel;
	private String niveau;
	private String geslacht;
	private String gemWiskundeCijfer;
	private String wanneerBlijvenZitten;
	private String docent;

	public boolean isFirstTime() {
		return firstTime;
	}

	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getJaar() {
		return lesjaar;
	}

	public void setJaar(String jaar) {
		this.lesjaar = jaar;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	public String getProfiel() {
		return profiel;
	}

	public void setProfiel(String profiel) {
		this.profiel = profiel;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	public String getGemWiskundeCijfer() {
		return gemWiskundeCijfer;
	}

	public void setGemWiskundeCijfer(String cijfer) {
		this.gemWiskundeCijfer = cijfer;
	}

	public String getWanneerBlijvenZitten() {
		return wanneerBlijvenZitten;
	}

	public void setWanneerBlijvenZitten(String isBlijvenZitten) {
		this.wanneerBlijvenZitten = isBlijvenZitten;
	}

	public String getLesJaar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getDocent() {
		return docent;
	}

	public void setDocent(String docent) {
		this.docent = docent;
	}
	



}
