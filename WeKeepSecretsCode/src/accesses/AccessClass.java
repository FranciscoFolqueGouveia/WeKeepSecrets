package accesses;

import users.*;

public class AccessClass implements Access {
	/**
	 * type - type of access made by the User
	 * user - User who made the access
	 * 
	 */
	private String type;
	private User user;
	
	/*
	 * Constructor of an access:
	 * An access receives an existing user, and a string that characterize the type of access (read or write)
	 * */
	public AccessClass(User user, String type) {
		this.type = type;
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public String getTypeOfAccess() {
		return this.type;
	}
	

}
