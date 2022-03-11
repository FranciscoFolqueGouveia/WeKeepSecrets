package accesses;

public class AccessIteratorClassified implements AccessIterator {
	/*
	 * accesses - array of Accesses 
	 * counter - index of the number of objects (accesses) in the array
	 * nextAccess - next access to iterate
	 * 
	 */
	

	
	private Access[] accesses;
	private int counter;
	private int nextAccess;
	
	
	/*
	 * Constructor :
	 * 
	 * Receives the array and the counter of an existing AccessList 
	 * nextAccess - starts in 0, as the arrays
	 **/
	public AccessIteratorClassified(Access[] access, int counter) {
		this.accesses = access;
		this.counter = counter;
		this.nextAccess = 0;
		
		
	}
	
	public boolean hasNext() {
		return (nextAccess < counter);
	}
	
	public Access next() {
	
		return accesses[nextAccess++];
		
	}

}
