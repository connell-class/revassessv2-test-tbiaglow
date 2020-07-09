package com.revature.tier1;

public class User {
	String name = "Bob";
	Integer id = 1124;
	protected boolean isAuthorized = false;
	void decrementId () {
		this.id -= 1;
	}
}
