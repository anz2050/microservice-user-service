package com.vzb.microservice.model;

public class User {
	
	private String userName;
	private long userId;
	
	
	public User(long userId, String userName) {
		this.userId = userId;
		this.userName = userName;
		
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

}
