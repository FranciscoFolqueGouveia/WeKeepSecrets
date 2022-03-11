package weKeepSecrets;

import users.*;
import accesses.Access;
import accesses.AccessIterator;
import documents.*;
import grants.Grant;
import grants.GrantIterator;

/**
 * @author Martim Costa/Francisco Gouveia
 *
 */
public interface WeKeepSecrets {
	/**
	 * @param type- type of the User (clerk or officer)
	 * @param id    - name /id of the User
	 * @param sl    - security level of the User This method regists a User,
	 *              receiving his id, his security level and his type
	 */
	void register(String type, String id, String sl);
	/**
	 * @param doc  - name of the document
	 * @param user - id of the User that want to upload the document
	 * @param sl   - security level of the document
	 * @param desc - description of the document This method uploads a document to
	 * This method uploads a document to the User document list, 
	 * receiving the document name, the user name, 
	 * the document security level and the description of the document
	 * 
	 */
	void uploadDoc(String doc, String user, String sl, String desc);
	
	/**
	 * @param user - id of the user 
	 * @return the object User with the Id given in the UsersList of the Class
	 */
	User getUser(String user);

	/**
	 * @param user - User that we want too see his document collection
	 * @return list of documents of the user
	 */
	DocsList getUserDocList(String user);
	
	/**
	 * @param user - id of the user
	 * @return the kind of the user(clerk or officer)
	 */
	String getUserKind(String user);
	
	
	
	
	/**
	 * @param access - Object of type access
	 * @return security type of the user of that access
	 */
	String getSecurityTypeOfAccessUser(Access access);

	

	/**
	 * @param grant - Object of type grant
	 * @return security type of the user of that grant
	 */
	String getSecurityTypeOfGrantsUser(Grant grant);

	/**
	 * @param grant - Object of type grant
	 * @return the id of the user of that grant
	 */
	String getIdOfGrantsUser(Grant grant);
	
	/**
	 * @param access - Object of type access
	 * @return the id of the user of that access
	 */
	String getIdOfAccessUser(Access access);
	
	/**
	 * @param d - Object of the type document
	 * @return the number of accesses of that document
	 */
	int getDocNumberOfAccess(Document d);
	
	
	// Document must be instance of ClassifiedDoc for this method
		/**
		 * @param d - Object of the type document
		 * @return the number of grants of that document
		 */
		int getDocNumberOfGrants(Document d);
		
		
		
		
		/**
		 * @param user - id of the User that owns the document
		 * @param doc - name of the document
		 * @return true if the Document is a Classified document, else return false if it is not a Classified document
		 */
		boolean instanceOfClassified(String user, String doc);
		
		
		
		/**
		 * @param id - User Id
		 *  This method checks if exists a user in the UsersList with the Id given
		 */
		boolean hasUser(String id);
		
		/**
		 * @param user- the id of the user that we want to see if he has the document
		 * @param doc -  the name of the document that we want to search on the User document list
		 * @return true if the User has the document with that name
		 * @return false if the User does not have the document with that name
		 * 
		 * This method checks if the User given has on in DocsList the Document title
		 * given The method getUser() is used to get the Object User from the String
		 * given (Id)
		 */
		boolean userHasDoc(String user, String doc);
		
		/**
		 * @param doc - name of the document
		 * @param manager - id of the owner of the document
		 * @param user - id of the user that we want to see if has grant
		 * @return true if the user has grant for the document, else return false if the user does not have that grant
		 */
		boolean userHasGrant(String doc, String manager, String user);
		
		/**
		 * @param doc - name of the document
		 * @param manager - id of the owner of the document
		 * @param user - id of the user that we want to see if has revoke
		 * @return true if the user has revoke for the document, else return false if the user does not have that revoke
		 */
		boolean userHasRevoke(String doc, String manager, String user);
		
		/**
		 * @param owner - id of the User that owns the document
		 * @param user - id of the User that we want to verify if has access to the document
		 * @param doc - name of the document 
		 * @return true if the User has access to the document
		 * @return false if the User does not have access
		 */
		boolean hasUserAccessToDoc(String owner, String user, String doc);
		
		
		/**
		 * @param user - id of the User that we want to compare his security level
		 * @param sl - security level that we want to compare
		 * @return true if the security level of the User is sufficient for the security level given
		 * @return false if the security level of the User is lower of the security level given
		 */
		boolean isUserSecureEnough(String user, String sl);
		
		
		// Document must be instance of ClassifiedDoc for this method
		/**
		 * @param manager - id of the owner of the document
		 * @param writer - id of the User that wants to change the description of the document
		 * @param doc - name of the document
		 * @param desc - the new description for the document
		 * This method will change the description of the document and it will regist that type of access on the access list
		 */
		void writeDocument(String manager, String writer, String doc, String desc);

		/**
		 * @param manager- id of the owner of the document
		 * @param reader -id of the User that wants to see the description of the document
		 * @param doc - name of the document
		 * @return the description of the document
		 * This method will return the description of the document and it will regist that type of access on the Access list
		 */
		String readDocument(String manager, String reader, String doc);
		
		// User must be instance of UserOfficer for this method
		/**
		 * @param doc - name of the document
		 * @param granter - id of the User that will grant access
		 * @param user - id of the user that will receive grant
		 * This method will grant access of a document to a user 
		 * and it will regist that grant on the GrantsList of the document.
		 * This method also increases the number of grantsGiven of the user and the number of nLeaks of the document
		 * If it was the first grantGiven by the user, we regist him in the topGranters UsersList
		 * If it was the first leak of the document, we regist it in the topLeaked DocsList 
		 */
		void grantAccessToDoc(String doc, String granter, String user);

		// User must be instance of UserOfficer for this method
		/**
		 * @param doc - name of the document
		 * @param granter - id of the User that will grant access
		 * @param user - id of the user that will receive grant
		 * This method will revoke the access to a document to a user 
		 * and it will regist that revoke ont the Grant List
		 * This method also increase the number of revokes on the document 
		 * and on the user that owns that document
		 */
		void revokeAccessToDoc(String doc, String granter, String user);
		
		
		
		
	
		
	

	

	/**
	 * @return true if the User List is empty, else return true if the list has at least one User
	 */
	boolean isUsersEmpty();

	/**
	 * @return true if the Granters list is empty, else return true if the list has at least one Granter
	 */
	boolean isGrantersEmpty();
	
	
	/**
	 * @return true if the number of leaks of a document is empty, else return false if there is at leats one leak
	 */
	boolean isLeakedEmpty();

	

	

	

	

	

	
	

	

	/**
	 * @param d - Object of the type document
	 * @return the access iterator of the document
	 */
	AccessIterator docAccessIterator(Document d);

	/**
	 * @param user -id of the user
	 * @return the iterator of the classified documents of the user
	 */
	DocIterator ClassifiedDocsIterator(String user);

	/**
	 * @param user - id of the user
	 * @return the iterator of the official documents of the user
	 */
	DocIterator OfficialDocsIterator(String user);
	
	
	/**
	 * @return the iterator of Users
	 */
	UserIterator UsersIterator();
	
	
	/**
	 * @return gIt- the granter iterator
	 * This method will initialize the Granters iterator and it will sort them by number of grants
	 */
	UserGranterIterator grantersIterator();
	
	/**
	 * @return the iterator of grants of classified documents
	 * 
	 * */
	public GrantIterator docGrantsIterator(Document d);
	
	/**
	 * @return lIt - the iterator of leak of documents
	 * This method will initialize the Leaks iterator and it will sort them by number of leaks
	 * */
	public LeaksIterator leakedDocsIterator();
	
	

	

	
	
}
	
