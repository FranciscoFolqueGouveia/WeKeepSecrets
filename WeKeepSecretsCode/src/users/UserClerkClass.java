package users;

import weKeepSecrets.*;

public class UserClerkClass extends UserAbstractClass implements UserClerk {
	
	/**
	 * official - constant security Level of Clerks (SecurityLvl of type OFFICIAL)
	 */
	private static SecurityLvl official = SecurityLvl.OFFICIAL;
	
	/**
	 * Constructor
	 * 
	 * uses the constructor of the super Class
	 */
	
	public UserClerkClass(String id) {		
		super(id, official, "clerk");
		
	}
	

}
