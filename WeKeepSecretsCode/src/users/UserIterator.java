package users;

public interface UserIterator {
	
	
	
	/**
	 * @return true if exists a next User in the array
	 * else return false 
	 */
	boolean hasNext();
	
	/**
	 * @return the next User object to iterate
	 */
	
	User next();
	
	


}
