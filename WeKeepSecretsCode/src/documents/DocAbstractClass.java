package documents;


import accesses.AccessIterator;
import accesses.AccessList;
import weKeepSecrets.*;




public abstract class DocAbstractClass implements Document {

	/*
	 * @manager - user who created the document;
	 * 
	 * @title - name of the document
	 * 
	 * @description - content of the document;
	 * 
	 * @nAccesses - number of accesses made to the document;
	 * 
	 * @securityLvl - Security level of the document;
	 * 
	 */

	private String manager;
	private String title;
	private String description;
    private SecurityLvl securityLvl;
	

	/**
	 * Constructor
	 * 
	 * 
	 */
	public DocAbstractClass(String title, String manager, SecurityLvl securityLvl, String description) {
		this.title = title;
		this.manager = manager;
		this.securityLvl = securityLvl;
		this.description = description;

		

	}


	public String getManager() {
		return this.manager;

	}


	public String getTitle() {
		return this.title;
	}


	

	public String readDescription() {
		return this.description;

	}


	public SecurityLvl getSecurityLevel() {
		return this.securityLvl;

	}
	
	public String getSecurityType() {
		
		return this.securityLvl.getSecurityType();
		
	}

		public int getNumberOfAccess() {
		return getAccessList().getCounter();
	}

	public abstract AccessList getAccessList();
	
	public abstract AccessIterator accessesIterator();
	
	
	
	// method only used by classified documents (method in the DocClassified interface)

		/**
		 * @description - for the document This method is used to update the documents
		 *              description
		 */
		public void changeDescription(String description) {
			this.description = description;

		}
	

}
