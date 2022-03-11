package documents;


import accesses.AccessIterator;
import accesses.AccessList;
import weKeepSecrets.*;


/**
 * @author Martim Costa / Francisco Gouveia
 *
 */
public interface Document {

	
	/**
	 * return documents manager
	 */
	
	String getManager();

	
	/**
	 * return documents title
	 */
	
	String getTitle();


	/**
	 * return documents description to read
	 */
	
	String readDescription();
	
	/**
	 * return documents security level
	 */
	
	SecurityLvl getSecurityLevel();
	
	/**
	 * @return Document SecurityLvl type (Official or secret or topSecret or confidential)
	 */
	String getSecurityType();
	
	
	
	/**
	 * @return the number of Accesses in the document AccessList
	 */
	int getNumberOfAccess();
		
	/**
	 * @return the documents AccesList
	 */
	AccessList getAccessList();	
	
	/**
	 * @return the documents AccessIterator (different if is a DocClassified or a DocOfficial)
	 */
		
	AccessIterator accessesIterator();
	
	
	
}
