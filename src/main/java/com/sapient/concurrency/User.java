package com.sapient.concurrency;

public class User {
	
	private String user;
	private String password;
	
	public User(String user, String password) {
		this.user= user;
		this.password= password;
	}
	
	public boolean login() {
		return user.equalsIgnoreCase("vivek") && password.equalsIgnoreCase("vivek");
	}

}
