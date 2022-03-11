package grants;

import users.User;

/**
 * @author Martim Costa / Francisco Gouveia
 *
 */
public interface Grant {

	/**
	 * @return user- User of the grant
	 */
	User getUser();

	/**
	 * @return type- type of Grant of the User
	 */
	String getTypeOfGrant();
}
