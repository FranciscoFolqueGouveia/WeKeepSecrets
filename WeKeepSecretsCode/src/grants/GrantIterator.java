package grants;

/**
 * @author Martim Costa /Francisco Gouveia
 *
 */
public interface GrantIterator {
	
	/**
	 * 
	 * @return true if the array has a next Grant given on the list
	 * @return false if the array does not have a next Grant given
	 */
	 
	boolean hasNext();
	/**
	 * @return the next Grant given
	 */
	Grant next();
	

}
