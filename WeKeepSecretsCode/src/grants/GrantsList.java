package grants;

import users.User;

/**
 * @author Martim Costa / Francisco Gouveia
 *
 */
public interface GrantsList {
	/**
	 * @return grants - the list of grants
	 */
	Grant[] getArray();

	/**
	 * @return counter - the number of grants on the list of grants
	 */
	int getCounter();

	/**
	 * @param user - User that the grant was given
	 * This method regists  the grant that was given to the user in the list of grants
	 */
	void registGrantGiven(User user);

	/**
	 * @param user - User that grant was revoked
	 * This method regists  the grant that was revoked to the user in the list of grants
	 */
	void registGrantRevoked(User user);

	

	/**
	 * @param user - name of the user that we want to verify if has grant
	 * @return result - if that user with that name has a grant,
	 *  result will be true, 
	 * else if the user does not has a grant result will be equal to -1
	 * 
	 * This method will search if the user with that name has a grant.
	  */
	boolean userHasGrant(String user);

	/**
	 * @param user  name of the user that we want to verify if has revoke
	 * @return result - if that user with that name has a revoke,
	 *  result will be true, 
	 * else if the user does not has a revoke result will be equal to -1
	 * 
	 * This method will search if the user with that name has a revoke.
	 */
	boolean userHasRevoke(String user);

}
