package users;

import documents.*;
import weKeepSecrets.*;

/**
 * @author Francisco Gouveia / Martim Costa
 *
 */
public class UserAbstractClass implements User {
	
	

	/**
	 * id - identifier of the user
	 * kind - kind of user (officer or clerk)
	 * securityLvl - security level of the user
	 * userDocs - list of Documents that the user has uploaded
	 */
	private String id;
	private String kind;
	private SecurityLvl securityLvl;
	private DocsList userDocs;
	
	/**
	 * Constructor
	 */
	
	public UserAbstractClass(String id, SecurityLvl security, String kind) {
		this.id = id;
		this.kind = kind;
		this.securityLvl = security;
		this.userDocs = new DocsListClass();
		

	}

	public String getId() {
		return this.id;

	}

	public String getKind() {
		return this.kind;
	}

	public SecurityLvl getSecurityLevel() {
		return this.securityLvl;
	}
	
	public String getSecurityType() {
		return this.securityLvl.getSecurityType();
	}

	public DocsList getUserDocs() {
		return this.userDocs;
	}


	public DocIterator ClassifiedDocsIterator() {
		DocIterator it = new DocIteratorClassified(userDocs.getArray(), userDocs.getCounter());
		return it;
	}

	public DocIterator OfficialDocsIterator() {
		DocIterator it = new DocIteratorOfficial(userDocs.getArray(), userDocs.getCounter());
		return it;
	}

}
