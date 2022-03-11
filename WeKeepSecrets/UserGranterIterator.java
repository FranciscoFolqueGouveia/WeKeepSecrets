package weKeepSecrets;

import users.User;

/**
 * @author Martim Costa / Francisco Gouveia
 *
 */
public interface UserGranterIterator {
	
	
	
	/**
	 * @return true if there is a next user in the array and if the number of iterated users is smaller than 10;
	 * else return false
	 */
	boolean hasNext();
	
	/**
	 * @return the next user to iterate
	 */
	User next();
	
	/**
	 * this method sort the users in the array by the value of the their variable grantsGiven
	 * if users have the same grantsGiven value, this method sort them by their id (alphabetic order)
	 */
	void sortByGrants();

}
