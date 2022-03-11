package grants;



public class GrantIteratorClass implements GrantIterator{
	/*
	 * grants - list of grants given and revoked
	 * counter - number of objects on the array
	 * nextGrant - next Grant to iterate
	 * */
	
	private Grant[] grants;
	private int counter;
	private int nextGrant;
	
	
	//Constructor
	public GrantIteratorClass(Grant[] grants, int counter) {
		this.grants = grants;
		this.counter = counter;
		this.nextGrant = 0;
		
		
	}
	
	public boolean hasNext() {
		return (nextGrant < counter);
	}
	
	public Grant next() {
	
		return grants[nextGrant++];
		
	}

}



