package com.ramso.restapi;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public final class UserDTO {  //DTO class with data validation rules
	
	private String id;
	@NotEmpty
    @Size(max = User.MAX_LENGTH_NAME)
	private String name;
	private int credits;
	//private boolean isAdmin;
	
	public UserDTO(){
		
	}
	
	 public String getId() {
	        return id;
	}
	public String getName(){
		return name;
	}
	
	public int getCredits(){
		return credits;
	}
	/*
	public boolean getIsAdmin(){
		return isAdmin;
	}*/
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setCredits(int credits){
		this.credits=credits;
	}/*
	public void setIsAdmin(boolean isAdmin){
		this.isAdmin = isAdmin;
	}*/
	
	@Override
    public String toString() {
        return String.format(
                //"UserDTO[id=%s, name=%s, credits=%s, isAdmin=%s]",
        		"UserDTO[id=%s, name=%s, credits=%s]",
                this.id,
                this.name,
                this.credits
               // this.isAdmin
        );
    }

}
