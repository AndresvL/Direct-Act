package domein;

import java.sql.Date;

public class Student{

	private boolean firstTime;
	private String code;
	private String school;
	private String jaar;
	private String niveau;
	private String geslacht;
	private String cijfer;
	private Date isBlijvenZitten;

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
		return jaar;
	}

	public void setJaar(String jaar) {
		this.jaar = jaar;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	public String getGemCijfer() {
		return cijfer;
	}

	public void setGemCijfer(String cijfer) {
		this.cijfer = cijfer;
	}

	public Date getIsBlijvenZitten() {
		return isBlijvenZitten;
	}

	public void setIsBlijvenZitten(Date isBlijvenZitten) {
		this.isBlijvenZitten = isBlijvenZitten;
	}

	public String getLesJaar() {
		// TODO Auto-generated method stub
		return null;
	}
	



}
