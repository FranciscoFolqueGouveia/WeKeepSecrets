package accesses;

import users.*;

/**
 * @author Martim Costa/ Francisco Gouveia
 *
 */
public interface AccessList {
	/**
	 * @return the Array of the AccessList
	 */
	public Access[] getArray();
	/**
	 * @return the counter of the AccessList
	 */
	public int getCounter();


	/**
	 * @param user - User who updates a document; This method regists an access in
	 *             the document AccessList, saving the user and the type of access
	 *             (write)
	 */
	void registWriteAccess(User user);

	/**
	 * @param user - User who reads a document; This method regists an access in the
	 *             document AccessList, saving the user and the type of access
	 *             (read)
	 */
	void registReadAccess(User user);


	

}
