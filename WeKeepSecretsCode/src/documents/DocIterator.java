package documents;

/**
 * @author Martim Costa /Francisco Gouveia
 *
 */
public interface DocIterator {
	
	/**
	 * @return true if the array has a next Document on the list
	 * @return false if the array does not have a next Document   
	 */
	boolean hasNext();
	/**
	 * @return the next Document to iterate
	 */
	Document next();

}
