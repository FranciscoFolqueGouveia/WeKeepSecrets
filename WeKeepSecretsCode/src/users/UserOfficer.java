package users;

public interface UserOfficer extends User{
	
	
	
	/**
	 * @return the number of grants given by the UserOfficer
	 */
	int grantsGiven();
	/**
	 * @return the number of grants revoked by the UserOfficer
	 */
	
	int revokesGiven();
	
	
	
	/**
	 *  this method increases the variable grantsGiven by 1;
	 */
	void increaseGrantNumber();
	
	
	
	
	/**
	 *  this method increases the variable grantsRevoked by 1;
	 */
	
	void increaseRevokes() ;

}
