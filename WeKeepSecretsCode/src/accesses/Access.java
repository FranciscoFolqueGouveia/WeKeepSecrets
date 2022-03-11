package accesses;

import users.*;

/**
 * @author Martim Costa/Francisco Gouveia
 *
 */
public interface Access {
	
	/**
	 * @return user - User of the access
	 */
	public User getUser();
	
	/**
	 * @return type- Type of access of the user
	 */
	public String getTypeOfAccess();

}
