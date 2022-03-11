package accesses;

public interface AccessIterator {
	
	/**
	 * @return true if the array has a next Access on the list
	 * @return false if the array does not have a next Access
	 */
	boolean hasNext();
	
	/**
	 * @return the next Access to iterate
	 */
	Access next();

}
