package documents;


import accesses.AccessIterator;
import accesses.AccessIteratorOfficial;
import accesses.AccessList;
import accesses.AccessListClass;
import weKeepSecrets.*;


public class DocOfficialClass extends DocAbstractClass implements DocOfficial {
	/*
	 * official - Security lvl of type official
	 * accessList - list of Accesses of the document
	 * 
	 * */

	private static SecurityLvl official = SecurityLvl.OFFICIAL;
	private AccessList accessList;

	
	/**
	 * Constructor
	 * 
	 * uses the constructor of the super Class
	 * 
	 * 
	 */
	public DocOfficialClass(String title, String manager, String description) {
		super(title, manager, official, description);
		this.accessList = new AccessListClass();

	}


	public AccessList getAccessList() {
		return this.accessList;
	}

	public AccessIterator accessesIterator() {
		AccessIterator it = new AccessIteratorOfficial(accessList.getArray(), accessList.getCounter());
		return it;
	}


	



}
