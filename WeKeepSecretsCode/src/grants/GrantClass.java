package grants;

import users.*;

public class GrantClass implements Grant {
	/**
	 * type - type of Grant given  to the User
	 * user - User who grant or revoke was given
	 * 
	 */
	private String type;
	private User user;
	
	/**
	 * Constructor
	 */
	public GrantClass(User user, String type) {
		this.type = type;
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public String getTypeOfGrant() {
		return this.type;
	}
	

}
