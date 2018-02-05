package org.entity.dao.user;

public class Provider {
	private int ID;
	private String proName;
	private String proContact;
	public Provider(){
		
	}
	public Provider(int ID, String proName, String proContact){
		this.ID = ID;
		this.proName = proName;
		this.proContact = proContact;
	}
	public void setID(int ID){
		this.ID = ID;
	}
	public void setProName(String proName){
		this.proName = proName;
	}
	public void setProContact(String proContact){
		this.proContact = proContact;
	}
	public int getID(){
		return this.ID;
	}
	public String getProName(){
		return this.proName;
	}
	public String getProContact(){
		return this.proContact;
	}
}
