package weKeepSecrets;

import accesses.*;
import documents.*;
import users.*;
import grants.*;

/**
 * @author Francisco Gouveia / Martim Costa
 *
 */
public class WeKeepSecretsClass implements WeKeepSecrets {
	/*
	 * OFFICER- fixed string "officer"
	 * CLERK- fixed string "clerk"
	 * OFFICIAL - fixed string "official"
	 * users - list of users
	 * topGranters -list of users that will regist the granters
	 * topLeaked - list of the documents that will regist the leaked documents
	 * */

	private static final String OFFICER = "officer";
	private static final String CLERK = "clerk";
	private static final String OFFICIAL = "official";
    private UsersList users;
	private UsersList topGranters;
	private DocsList topLeaked;

	
	/**
	 * Constructor
	 */
	
	public WeKeepSecretsClass() {
		this.users = new UsersListClass();
		this.topGranters = new UsersListClass();
		this.topLeaked = new DocsListClass();

	}
	
	public void register(String type, String id, String sl) {

		if (type.equalsIgnoreCase(OFFICER)) {
			users.registOfficer(id, getSecurityLvl(sl));

		} else if (type.equalsIgnoreCase(CLERK)) {
			users.registClerk(id);

		}

	}

	
	public void uploadDoc(String doc, String manager, String sl, String desc) {

		if (sl.equalsIgnoreCase(OFFICIAL)) {

			getUserDocList(manager).registOfficialDoc(doc, manager, desc);
		} else {

			getUserDocList(manager).registClassifiedDoc(doc, manager, getSecurityLvl(sl), desc);
		}
	}


	public User getUser(String user) {
		return this.users.getUser(user);
	}
	public DocsList getUserDocList(String user) {
		return getUser(user).getUserDocs();
	}
	
	public String getUserKind(String user) {
		return getUser(user).getKind();
	}


	public Document getUserDoc(String user, String doc) {

		return getUserDocList(user).getDoc(doc);

	}
	public String getSecurityTypeOfAccessUser(Access a) {
		return a.getUser().getSecurityType();		
	}
	
	
	
	public String getSecurityTypeOfGrantsUser(Grant a) {
		return a.getUser().getSecurityType();		
	}
	
	
	public String getIdOfGrantsUser(Grant a) {
		return a.getUser().getId();
		}
	
	
	public String getIdOfAccessUser(Access a) {
		return a.getUser().getId();
		
	}
	public int getDocNumberOfAccess(Document d) {
		return d.getNumberOfAccess();
	}

	// Document must be instance of DocClassified for this method
	
	public int getDocNumberOfGrants(Document d) {
		return ((DocClassified) (d)).getNumberOfGrants();
	}
	
	public boolean instanceOfClassified(String user, String doc) {

		return (getUserDoc(user, doc) instanceof DocClassified);

	}
	
	public boolean hasUser(String id) {

		return this.users.hasUser(id);

	}

	
	public boolean userHasDoc(String user, String doc) {

		return getUserDocList(user).hasDoc(doc);
	}
	
	public boolean userHasGrant(String doc, String manager, String user) {

		return getDocGrantsList(manager, doc).userHasGrant(user);
	}
	
	
	public boolean userHasRevoke(String doc, String manager, String user) {
		return getDocGrantsList(manager, doc).userHasRevoke(user);

	}
	
	public boolean hasUserAccessToDoc(String owner, String user, String doc) {

		return getUserSecurityLvl(user).isBigger(getDocSecurityLvl(owner, doc));
	}

	
	public boolean isUserSecureEnough(String user, String sl) {

		return getUserSecurityLvl(user).isBigger(getSecurityLvl(sl));

	}
	
	// Document must be instance of DocClassified for this method
       public void writeDocument(String manager, String reader, String doc, String desc) {

			User u = getUser(reader);

			changeDocDescription(manager, doc, desc);
			getDocAccesList(manager, doc).registWriteAccess(u);

		}

		public String readDocument(String manager, String reader, String doc) {

			User u = getUser(reader);

			String description = getDocDescription(manager, doc);
			getDocAccesList(manager, doc).registReadAccess(u);

			return description;

		}

		
		// User must be instance of UserOfficer for this method

		public void grantAccessToDoc(String doc, String manager, String user) {

		
			User toGiveGrant = getUser(user);

			getDocGrantsList(manager, doc).registGrantGiven(toGiveGrant);
			increaseGrants(manager);
			increaseLeaks(manager, doc);
		}

		// Document must be instance of DocClassified for this method
		// User must be instance of UserOfficer for this method
		
		public void revokeAccessToDoc(String doc, String manager, String user) {

			Document d = getUserDoc(manager, doc);
			User toTakeGrant = getUser(user);
			User granter = getUser(manager);

			getDocGrantsList(manager, doc).registGrantRevoked(toTakeGrant);
			((DocClassified) (d)).increaseRevokes();
			((UserOfficer) (granter)).increaseRevokes();

		}
		
		public boolean isUsersEmpty() {
			return users.isEmpty();
		}

		public boolean isGrantersEmpty() {
			return topGranters.isEmpty();
		}

		public boolean isLeakedEmpty() {
			return topLeaked.isEmpty();
		}
		
		
		public AccessIterator docAccessIterator(Document d) {

			return d.accessesIterator();

		}
		
		public DocIterator ClassifiedDocsIterator(String user) {
			User u = getUser(user);

			return u.ClassifiedDocsIterator();
		}

		public DocIterator OfficialDocsIterator(String user) {
			User u = getUser(user);

			return u.OfficialDocsIterator();
		}


	public UserIterator UsersIterator() {
		return users.UsersIterator();
	}
	
	
	public UserGranterIterator grantersIterator() {
		UserGranterIterator gIt = new UserGranterIteratorClass(topGranters.getArray(), topGranters.getCounter());
		gIt.sortByGrants();
		return gIt;

	}
	
	// Document must be instance of DocClassified for this method

		public GrantIterator docGrantsIterator(Document d) {

			return ((DocClassified) (d)).grantsIterator();
		}
	
	public LeaksIterator leakedDocsIterator() {
		LeaksIterator lIt = new LeaksIteratorClass(topLeaked.getArray(), topLeaked.getCounter());
		lIt.sortByLeaks();
		return lIt;

	}	
	
	/**
	 * @param user - user Id
	 * @return the securityLvl of the User who name was given First it gets that
	 *         User on the class UsersList
	 */
	private SecurityLvl getUserSecurityLvl(String user) {
		return this.getUser(user).getSecurityLevel();
	}
	/**
	 * @param security - a String that represents a SecurityLvl
	 * @return The SecurityLvl associated to that String
	 */
	private SecurityLvl getSecurityLvl(String security) {
		return SecurityLvl.getSecurityLvl(security);

	}
	/**
	 * @param doc - doc title
	 * @return the SecurityLvl of the document whose title was given First it gets
	 *         that Document on the class DocsList
	 */
	private SecurityLvl getDocSecurityLvl(String user, String doc) {
		return this.getUserDoc(user, doc).getSecurityLevel();

	}
	/**
	 * @param user - users Id
	 * @param doc - documents title
	 * @return the AccessList of the Document that is own by the user
	 */
	private AccessList getDocAccesList(String user, String doc) {
		return getUserDoc(user, doc).getAccessList();
	}

	
	// Document must be instance of DocClassified for this method
	/**
	 *  
	 * @param manager - Id of the user who owns the document
	 * @param doc - title of the document
	 * @param desc - new description to update the document
	 * 
	 * this method updates the description of the document that is own by the user
	 */
	private void changeDocDescription(String manager, String doc, String desc) {
		((DocClassified) (getUserDoc(manager, doc))).changeDescription(desc);
	}

	
	/**
	 * @param manager - Id of the user who owns the document
	 * @param doc - title of the document	 * 
	 * @return the description of the document that is own by the user
	 */
	
	private String getDocDescription(String manager, String doc) {
		return getUserDoc(manager, doc).readDescription();
	}
	
	
	
	// User must be instance of UserOfficer for this method
	/**
	 * @param manager - Id of the user who gave a grant
	 * 
	 * this method increases the variable grantsGiven of the user by 1;
	 * If that variable grantsGiven of the user equals to 1, that means it was the first grant given, 
	 * So we regist the user who gave the grant in the topGranters UsersList;
	 */
	private void increaseGrants(String manager) {

		User granter = getUser(manager);

		((UserOfficer) (granter)).increaseGrantNumber();

		if (((UserOfficer) (granter)).grantsGiven() == 1) {
			this.topGranters.registerUser(granter);
		}

	}
	
	
	// Document must be instance of DocClassified for this method
	/**
	 * @param manager - Id of the user who owns the document
	 * @param doc - title of the document
	 * 
	 * This method increases the variable nLeaks of the document by 1;
	 * If that variable value equals to 1, that means it was the first leak of the document,
	 * So we regist it in the topLeaked DocsList 
	 */
	private void increaseLeaks(String manager, String doc) {
		Document d = getUserDoc(manager, doc);

		((DocClassified) (d)).increaseLeaks();
		if (((DocClassified) (d)).getNumberOfLeaks() == 1)
			this.topLeaked.registDoc(d);
	}
	
	
	// Document must be instance of DocClassified for this method
		/**
		 * @param user - id of the user who owns the document
		 * @param doc - title of the document
		 * @return the GrantsList of the document
		 */
		private GrantsList getDocGrantsList(String user, String doc) {

			return ((DocClassified) (getUserDoc(user, doc))).listOfGrants();
		}

	}
