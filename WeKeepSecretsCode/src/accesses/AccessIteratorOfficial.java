package accesses;

public class AccessIteratorOfficial implements AccessIterator{
	/*
	 * MAX - fix number that represents the maximum Accesses to iterate 
	 * accesses - array of Accesses 
	 * counter - number of objects in the array
	 * nextAccess- index of the next access to iterate
	 * accessesIterated - number of accesses already iterated
	 * 
	 */
	
	private static final int MAX = 10;
	private Access[] accesses;
	private int nextAccess;
	private int accessesIterated;

	
	
	/*
	 * Constructor :
	 * 
	 * Receives the array and the counter of an existing AccessList 
	 * nextAccess - starts in 0, as the arrays
	 **/
	
	public AccessIteratorOfficial(Access[] access, int counter) {
		this.accesses = access;
		this.nextAccess = counter - 1;
		this.accessesIterated = 0;
		
	}
	
	/**
	 * this method returns true while the array have a next access and while the number of iterated accesses has not reached 10 (MAX)
	 */
	public boolean hasNext() {
		return (nextAccess >= 0 && accessesIterated < MAX);
	}
	
	
	
	/**
	 * this method return the next access and increase the number of accessesIterated by 1;
	 */
	public Access next() {
		this.accessesIterated ++;
		return accesses[nextAccess--];
		
	}

}
