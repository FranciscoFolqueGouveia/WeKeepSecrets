package documents;

import grants.*;

/**
 * @author Martim Costa / Francisco Gouveia
 *
 */
public interface DocClassified extends Document {
	/**
	 * @return nLeaks - number of times the access to the document was granted to a User
	 */
	int getNumberOfLeaks();

	/**
	 * @return nRevokes- number of grants revoked to the document
	 */
	int getNumberOfRevokes();

	/**
	 * This method is used to increase the number of leaks of a document
	 */
	public void increaseLeaks();

	/**
	 * This method is used to increase the number of revokes  of a document
	 */
	public void increaseRevokes();
	/**
	 * @return the number of grants in the documents GrantsList 
	 */
	int getNumberOfGrants();


	/**
	 * @return grantList - list of all grants
	 */
	GrantsList listOfGrants();

	/**
	 * @return it - the iterator of all grants given and revoked 
	 */
	GrantIterator grantsIterator();



	/**
	 * @description - new description to update the document;
	 *  This method is used to update the documents description
	 */
	void changeDescription(String description);
}

	
