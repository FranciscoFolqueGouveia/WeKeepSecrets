package users;

import weKeepSecrets.*;

public class UserOfficerClass extends UserAbstractClass implements UserOfficer  {
	
	
	/**
	 * grantsGiven - number of grants given by the UserOfficer
	 * grantsRevoked - number of grants revoked by the UserOfficer
	 * 
	 */
	private int grantsGiven;
	private int grantsRevoked;
	
	/**
	 * Constructor
	 * 
	 * uses the constructor of the super Class
	 */
	public UserOfficerClass(String id, SecurityLvl sl) {		
		super(id, sl, "officer");
		this.grantsGiven = 0;
	}
	
	public int grantsGiven() {
		return this.grantsGiven;
	}
	
	public int revokesGiven() {
		return this.grantsRevoked;
	}
	
	public void increaseGrantNumber() {
		this.grantsGiven ++;
	}
	
	public void increaseRevokes() {
		this.grantsRevoked ++;
	}

}
