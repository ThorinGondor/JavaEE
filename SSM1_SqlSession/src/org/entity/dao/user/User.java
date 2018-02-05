package org.entity.dao.user;

public class User {
	private int ID;
	private String userCode;
	private String userName;
	private int gender;
	private int userRole;
	
	public User(){
		
	}
	public User(int ID,String userName,int userRole){
		this.ID = ID;
		this.userName = userName;
		this.userRole = userRole;
	}
	public User(int ID,String userCode,String userName,int gender,int userRole){
		this.ID = ID;
		this.userCode = userCode;
		this.userName = userName;
		this.gender = gender;
		this.userRole = userRole;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}
	public void setUserCode(String userCode){
		this.userCode = userCode;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public void setGender(int gender){
		this.gender = gender;
	}
	public void setUserRole(int userRole){
		this.userRole = userRole;
	}
	
	public int getID(){
		return this.ID;
	}
	public String getUserCode(){
		return this.userCode;
	}
	public String getUserName(){
		return this.userName;
	}
	public int getGender(){
		return this.gender;
	}
	public int getUserRole(){
		return this.userRole;
	}
}
