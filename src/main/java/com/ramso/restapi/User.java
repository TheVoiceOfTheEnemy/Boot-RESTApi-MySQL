package com.ramso.restapi;


import org.springframework.data.annotation.Id;

import static com.ramso.restapi.util.ConditionsMethods.isTrue;
import static com.ramso.restapi.util.ConditionsMethods.notEmpty;
import static com.ramso.restapi.util.ConditionsMethods.notNull;





final class User {
	
	static final int MAX_LENGTH_NAME = 30;
	
	@Id  					 //API Doc: http://docs.jboss.org/hibernate/orm/3.3/reference/en/html/mapping.html#mapping-declaration-id
	private String id;
	private String name;
	private int credits;
	//private boolean isAdmin;
	
	public User(){}
	
	private User(Builder builder){
		this.name = builder.name;
		this.credits = builder.credits;
	//	this.isAdmin = builder.isAdmin;
	}
	
	 static Builder getBuilder() {
	        return new Builder();
	    }
	 
	 public String getId(){
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
	 
	 
	 public void update(String name, int credits){
		 checkUserConstraints(name);
		 this.name = name;
		 this.credits = credits;
	 }
	 
	 @Override
	    public String toString() {
	        return String.format(
	                "User[id=%s,name=%s,credits=%s]",
	                this.id,
	                this.name,
	                this.credits
	        );
	    }
	
	//Builder class
	static class Builder{
		
		public String name;
		public int credits;
		//public boolean isAdmin;
		
		private Builder() {}
		
		Builder name(String name){
			this.name=name;
			return this;
		}
		
		Builder credits(int credits){
			this.credits=credits;
			return this;
		}
		/*
		Builder isAdmin(boolean isAdmin){
			this.isAdmin=isAdmin;
			return this;
		}*/
		
		User build(){
			User build = new User(this);
			
			build.checkUserConstraints(build.getName());
			
			return build;
		}
		
		
		
	
		
	}//>> Builder class
	
	private void checkUserConstraints(String name){
		notNull(name, "User name cannot be null");
		
		notEmpty(name, "User name cannot be empty");
		
        isTrue(name.length() <= MAX_LENGTH_NAME,
                "Name cannot be longer than %d characters",
                MAX_LENGTH_NAME
        );
		
	}
	
}//>> User class
