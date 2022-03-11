package users;

import documents.*;
import weKeepSecrets.*;

/**
 * @author Francisco Gouveia / Martim Costa
 *
 */

public interface User {

	/**
	 * @return Users id;
	 */
	public String getId();
	/**
	 * @return Users kind (Officer or Clerk)
	 */
	String getKind();

	/**
	 * @return Users SecurityLvl
	 */
	public SecurityLvl getSecurityLevel();
	
	/**
	 * @return Users SecurityLvl type (Official or secret or topSecret or confidential)
	 */
	String getSecurityType();

	/**
	 * @return User list of Documents
	 */
	public DocsList getUserDocs();

	/**
	 * @return DocIterator to iterate the User classified documents on his list of
	 *         documents
	 */
	DocIterator ClassifiedDocsIterator();

	/**
	 * @return DocIterator to iterate the User Official documents on his list of
	 *         documents
	 */
	public DocIterator OfficialDocsIterator();
	
	

	

}
