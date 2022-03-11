package documents;

import accesses.*;
import weKeepSecrets.*;
import grants.*;

public class DocClassifiedClass extends DocAbstractClass implements DocClassified {
	/*
	 * grantList - list of all grants given and revoked to the document
	 * accessList - Document list of accesses 
	 * nLeaks - number of times the access to the document was granted to a User 
	 * nRevokes- number of grants revoked to the document
	 * */

	private GrantsList grantList;
    private AccessList accessList;
	private int nLeaks;
	private int nRevokes;
	
	/**
	 * Constructor
	 * 
	 * uses the constructor of the super Class
	 * 
	 * 
	 */

	public DocClassifiedClass(String title, String manager, SecurityLvl sl, String description) {
		super(title, manager, sl, description);
		this.grantList = new GrantsListClass();
        this.accessList = new AccessListClass();
		this.nLeaks = 0;
		this.nRevokes = 0;

	}

	public int getNumberOfLeaks() {
		return this.nLeaks;
	}

	public int getNumberOfRevokes() {
		return this.nRevokes;
	}

	public void increaseLeaks() {
		this.nLeaks++;
	}

	public void increaseRevokes() {
		this.nRevokes++;
	}
	public int getNumberOfGrants() {
		return this.grantList.getCounter();
	}

	public GrantsList listOfGrants() {
		return this.grantList;
	}

	

	

	public GrantIterator grantsIterator() {
		GrantIterator it = new GrantIteratorClass(grantList.getArray(), grantList.getCounter());
		return it;
	}

	public AccessIterator accessesIterator() {
		AccessIterator it = new AccessIteratorClassified(accessList.getArray(), accessList.getCounter());
		return it;
	}
	public AccessList getAccessList() {

		return this.accessList;
	}

}
