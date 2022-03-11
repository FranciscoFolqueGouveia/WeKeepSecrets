package weKeepSecrets;

import documents.Document;


/**
 * @author Martim Costa / Francisco Gouveia
 *
 */
public interface LeaksIterator {
	/**
	 * @return true if there is a next Leak to iterate and if the number of iterated documents is smaller than 10
	 * else return false
	 */
	boolean hasNext();

	/**
	 * @return the next document to iterate
	 */
	Document next();

	/**
	 *  this method sort the documents in the array by the value of the their variable nLeaks
	 * if documents have the same nLeaks value, this method sort them by their title (alphabetic order)
	 */
	void sortByLeaks();
}
