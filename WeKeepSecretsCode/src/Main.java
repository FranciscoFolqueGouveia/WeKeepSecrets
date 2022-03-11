
import java.util.Scanner;

import accesses.*;
import users.*;
import documents.*;
import grants.*;

import weKeepSecrets.*;

/**
 * Principal program of WeeKeepSecrets
 * 
 * @author Martim Costa/ Francisco Gouveia
 */
public class Main {

	/**
	 * User commands
	 */
	private static final String REGISTER = "REGISTER";
	private static final String LISTUSERS = "LISTUSERS";
	private static final String UPLOAD = "UPLOAD";
	private static final String WRITE = "WRITE";
	private static final String READ = "READ";
	private static final String GRANT = "GRANT";
	private static final String REVOKE = "REVOKE";
	private static final String USERDOCS = "USERDOCS";
	private static final String TOPLEAKED = "TOPLEAKED";
	private static final String TOPGRANTERS = "TOPGRANTERS";
	private static final String HELP = "HELP";
	private static final String EXIT = "EXIT";

	/**
	 * Feedback given by the program
	 *
	 */
	// help command messages
	private static final String REGISTERHELP = "register - registers a new user";
	private static final String LISTUSERSHELP = "listusers - list all registered users";
	private static final String UPLOADHELP = "upload - upload a document";
	private static final String READHELP = "read - read a document";
	private static final String WRITEHELP = "write - write a document";
	private static final String GRANTHELP = "grant - grant access to a document";
	private static final String REVOKEHELP = "revoke - revoke a grant to access a document";
	private static final String USERDOCSHELP = "userdocs - list the official or classified documents of an user";
	private static final String TOPLEAKEDHELP = "topleaked - list the top 10 documents with more grants";
	private static final String TOPGRANTSHELP = "topgranters - list the top 10 officers that have given more grants";
	private static final String HELPHELP = "help - shows the available commands";
	private static final String EXITHELP = "exit - terminates the execution of the program";

	// Errors and sucess messages
	//User messages
	private static final String USER = "User ";
	private static final String REGISTERED = " was registered.";
	private static final String IDENTIFIER = "Identifier ";
	private static final String ALREADYREGISTED = " is already assigned to another user.";
	private static final String UNREGISTED = "Not a registered user.";
	private static final String NONEREGISTEDUSERS = "There are no registered users.";
	//Document messages
	private static final String DOCUMENT = "Document ";
	private static final String DOCUMENT1 = "Document: ";
	private static final String UPLOADED = " was uploaded.";
	private static final String ALREADYUPLOADED = " already exists in the user account.";
	private static final String UPDATED = " was updated.";
	private static final String NONEEXISTANTDOCUMENT = " does not exist in the user account.";
	private static final String UNUPDATED = " cannot be updated.";
	private static final String NONEEXISTANTDOCUMENTS = "There are no ";
	private static final String DOCUMENTS = " documents.";
	//security level message
	private static final String INSUFICIENTSECURITY = "Insufficient security clearance.";
	//Access, grants and revokes messages
	private static final String ACCESS = "Access to document ";
	private static final String ACCESSGRANTED = " has been granted.";
	private static final String REVOKED = " has been revoked.";
	private static final String ACCESSBYOFFICER = "Grants can only be issued between officers.";
	private static final String ALREADYACCESS = "Already has access to document ";
	private static final String GRANTFOROFFICER = "Grant for officer ";
	private static final String DOESNOTEXIST = " does not exist.";
	private static final String ALREADYREVOKED = " was already revoked.";
	private static final String NOACCESSES = "There are no accesses.";
	private static final String NOGRANTS = "There are no grants.";
	private static final String NONELEAKED = "There are no leaked documents.";
	private static final String NONEGIVENGRANTS = "No officer has given grants.";
	// Unknown command and exit messages
	private static final String UNKNOWNCOMMAND = "Unknown command. Type help to see available commands.";
	private static final String EXITING = "Bye!";

	/**
	 * Principal program. Invoke the command interpreter.
	 * 
	 * @param args -argument used for the app. Not used in this app
	 */
	public static void main(String[] args) {

		Main.commands();

	}

	/**
	 * command interpreter.
	 */
	private static void commands() {

		Scanner input = new Scanner(System.in);
		String command = input.next().toUpperCase();
		WeKeepSecrets wks = new WeKeepSecretsClass();

		while (!command.equals(Main.EXIT)) {

			switch (command) {

			case Main.REGISTER:
				registUser(input, wks);
				break;
			case Main.LISTUSERS:
				listUsers(wks);
				break;
			case Main.UPLOAD:
				uploadDocument(input, wks);
				break;
			case Main.WRITE:
				write(input, wks);
				break;
			case Main.READ:
				read(input, wks);
				break;
			case Main.GRANT:
				grant(input, wks);
				break;
			case Main.REVOKE:
				revoke(input, wks);
				break;
			case Main.USERDOCS:
				userDocs(input, wks);
				break;
			case Main.TOPLEAKED:
				topLeaked(wks);
				break;
			case Main.TOPGRANTERS:
				topGranters(wks);
				break;
			case Main.HELP:
				help();
				break;

			default:
				System.out.println(UNKNOWNCOMMAND);
				input.nextLine();

				break;
			}

			command = input.next().toUpperCase();

		}
		System.out.println(EXITING);
	}
	
	

	/**
	 * @param in - Scanner
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others) 
	 * 
	 * This method regists a user in the WeKeepSecrets;
	 * The user should not exist yet;
	 * 
	 * Scanner expects:
	 * String kind - kind of the user to regist (Clerk or Officer)
	 * String id - id of the user to regist
	 * String sl - Security level of the user to regist
	 * 
	 */
	private static void registUser(Scanner in, WeKeepSecrets wks) {
		String kind = in.next();
		String id = in.next();
		String sl = in.next();
		if (wks.hasUser(id) == false) {
			wks.register(kind, id, sl);
			System.out.println(USER + id + REGISTERED);
		} else
			System.out.println(IDENTIFIER + id + ALREADYREGISTED);

	}

	/**
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * 
	 * this method list all the users registed in the WeKeepSecrets; 
	 * 
	 * No inputs expected;
	 */
	private static void listUsers(WeKeepSecrets wks) {
		if (wks.isUsersEmpty() == false) {
			UserIterator i = wks.UsersIterator();

			while (i.hasNext()) {

				User u = i.next();

				System.out.println(u.getKind() + " " + u.getId() + " " + u.getSecurityLevel().getSecurityType());
			}
		} else
			System.out.println(NONEREGISTEDUSERS);

	}

	/**
	 * @param in - Scanner
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * 
	 * In this method a user uploads a new document, which is registed in the user DocsList;
	 * 
	 * Scanner expects:
	 * String doc - document title;
	 * String user - user id who wants to upload the document;
	 * String sl - security level defined for the document;
	 * String desc - description of the new document
	 *  
	 */
	private static void uploadDocument(Scanner in, WeKeepSecrets wks) {
		String doc = in.next();
		String user = in.next();
		String sl = in.next();
		in.nextLine();
		String desc = in.nextLine();
		if (wks.hasUser(user)) {
			if (wks.userHasDoc(user, doc) == false) {
				if (wks.isUserSecureEnough(user, sl)) {
					wks.uploadDoc(doc, user, sl, desc);
					System.out.println(DOCUMENT + doc + UPLOADED);

				} else
					System.out.println(INSUFICIENTSECURITY);

			} else
				System.out.println(DOCUMENT + doc + ALREADYUPLOADED);

		} else
			System.out.println(UNREGISTED);

	}

	/**
	 * @param in - Scanner
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others) 
	 * 
	 * This method is used to update a existing document (change its description)
	 * The user who wants to write should have the same or bigger security level than the document
	 * 
	 * Scanner expects:
	 * String doc - title of the document to update;
	 * String manager - id of the manager of that document;
	 * String writer - id of the user who wants to update;
	 * String description - new description of the document;
	 * 
	 */
	public static void write(Scanner in, WeKeepSecrets wks) {
		String doc = in.next();
		String manager = in.next();
		String writer = in.next();
		in.nextLine();
		String description = in.nextLine();
		if (wks.hasUser(manager) && wks.hasUser(writer)) {
			if (wks.userHasDoc(manager, doc) == true) {
				if (wks.instanceOfClassified(manager, doc)) {
					if (wks.hasUserAccessToDoc(manager, writer, doc) || wks.userHasGrant(doc, manager, writer)) {
						wks.writeDocument(manager, writer, doc, description);
						System.out.println(DOCUMENT + doc + UPDATED);
					} else
						System.out.println(INSUFICIENTSECURITY);

				} else
					System.out.println(DOCUMENT + doc + UNUPDATED);

			} else
				System.out.println(DOCUMENT + doc + NONEEXISTANTDOCUMENT);

		} else
			System.out.println(UNREGISTED);
	}
	
	/**
	 * @param in - Scanner
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others) 
	 * 
	 * This method is used to read the description of an existing document 
	 * The user who wants to read should sufficient security level for the document the document
	 * In alternative user should have a grant to access the document
	 * 
	 * Scanner expects:
	 * String doc - title of the document to read;
	 * String manager - id of the manager of that document;
	 * String reader - id of the user who wants to read;
	 * 
	 * 
	 */

	public static void read(Scanner in, WeKeepSecrets wks) {
		String doc = in.next();
		String manager = in.next();
		String reader = in.next();
		if (wks.hasUser(manager) && wks.hasUser(reader)) {
			if (wks.userHasDoc(manager, doc) == true) {
				if (wks.hasUserAccessToDoc(manager, reader, doc) || wks.userHasGrant(doc, manager, reader) == true) {

					System.out.println(DOCUMENT1 + wks.readDocument(manager, reader, doc));
				} else
					System.out.println(INSUFICIENTSECURITY);
			} else
				System.out.println(DOCUMENT + doc + NONEEXISTANTDOCUMENT);

		} else
			System.out.println(UNREGISTED);
	}

	/**
	 * @param in - Scanner
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * 
	 * This method is used for the users of kind Officer 
	 * to give grants (permission to access documents) 
	 * to users who do not have security level sufficient for the managers document 
	 * 
	 * Scanner expects:
	 * String doc - title of the document to leak;
	 * String manager - id of the user that gives a grant for the document he owns;
	 * String user - id of the user that will receive the grant to the document; 
	 */
	private static void grant(Scanner in, WeKeepSecrets wks) {
		String doc = in.next();
		String manager = in.next();
		String user = in.next();
		if (wks.hasUser(manager) && wks.hasUser(user)) {
			if (wks.getUser(manager) instanceof UserOfficer && wks.getUser(user) instanceof UserOfficer) {
				if (wks.userHasDoc(manager, doc) == true) {
					if (!(wks.hasUserAccessToDoc(manager, user, doc)) && !(wks.userHasGrant(doc, manager, user))) {
						wks.grantAccessToDoc(doc, manager, user);
						System.out.println(ACCESS + doc + ACCESSGRANTED);

					} else
						System.out.println(ALREADYACCESS + doc + ".");

				} else
					System.out.println(DOCUMENT + doc + NONEEXISTANTDOCUMENT);
			} else
				System.out.println(ACCESSBYOFFICER);
		} else
			System.out.println(UNREGISTED);
	}
	
	

	/**
	 * @param in - Scanner
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * 
	 * This method is used to revoke a grant (permission to access a document) 
	 * to a user that has received a grant to a certain document
	 * 
	 * Scanner expects:
	 * String doc - title of the document that the user has grant
	 * String manager - id of the user who owns the document
	 * String user - user to revoke grant 
	 * 
	 */
	private static void revoke(Scanner in, WeKeepSecrets wks) {
		String doc = in.next();
		String manager = in.next();
		String user = in.next();
		if ((wks.hasUser(manager) && wks.hasUser(user))) {
			if (wks.getUser(manager) instanceof UserOfficer && wks.getUser(user) instanceof UserOfficer) {
				if (wks.userHasDoc(manager, doc) == true) {
					if (!(wks.userHasRevoke(doc, manager, user))) {
						if (wks.userHasGrant(doc, manager, user)) {
							wks.revokeAccessToDoc(doc, manager, user);
							System.out.println(ACCESS + doc + REVOKED);
						} else
							System.out.println(GRANTFOROFFICER + user + DOESNOTEXIST);

					} else
						System.out.println(GRANTFOROFFICER + user + ALREADYREVOKED);

				} else
					System.out.println(DOCUMENT + doc + NONEEXISTANTDOCUMENT);

			} else
				System.out.println(ACCESSBYOFFICER);
		} else
			System.out.println(UNREGISTED);

	}

	/**
	 * @param in - Scanner
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * 
	 * This method is used to list the documents of a user 
	 * It lists the classified documents or the official documents (must choose one)
	 * 
	 * Scanner expects:
	 * String user - id of the user we want to list the documents
	 * String type - type of documents we want to list (Official or Classified)
	 */
	public static void userDocs(Scanner in, WeKeepSecrets wks) {
		String user = in.next();
		String type = in.next();

		if (wks.hasUser(user)) {

			if (type.equalsIgnoreCase("official")) {
				processUserOfficalDocs(wks, user);

			} else if (type.equalsIgnoreCase("classified")) {
				processUserClassifiedDocs(wks, user, type);

			}
		} else
			System.out.println(UNREGISTED);
	}
	
	

	/**
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * @param user - user id
	 * 
	 * this method lists the official documents of a given user
	 * If the document has accesses, this method lists the last 10 accesses made to to it
	 * 
	 */
	public static void processUserOfficalDocs(WeKeepSecrets wks, String user) {

		if (wks.getUserDocList(user).getNumberOfOfficial() > 0) {
			DocIterator it = wks.OfficialDocsIterator(user);

			while (it.hasNext()) {
				Document d = it.next();
				System.out.print(d.getTitle() + " " + wks.getDocNumberOfAccess(d) + ": ");

				if (wks.getDocNumberOfAccess(d) > 0) {
					AccessIterator at = wks.docAccessIterator(d);
					listAccessesOfOfficialDoc(wks, at);

				} else
					System.out.println(NOACCESSES);

			}

		} else
			System.out.println(NONEEXISTANTDOCUMENTS + "official" + DOCUMENTS);

	}

	/**
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * @param at - AccessIterator of a specific Document
	 * 
	 * This method lists the 10 last accesses made to the document
	 */
	private static void listAccessesOfOfficialDoc(WeKeepSecrets wks, AccessIterator at) {

		while (at.hasNext()) {
			Access a = at.next();

			System.out.print(a.getUser().getId() + " [" + wks.getSecurityTypeOfAccessUser(a));

			if (at.hasNext()) {
				System.out.print("], ");
			} else
				System.out.println("]");

		}

	}
	
	/**
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * @param user - user id
	 * 
	 * this method lists the classified documents of a given user
	 * If the document has accesses, this method lists all the accesses made to to it
	 * If the document has grants associated to it (permissions to access), this method list all those grants
	 * 
	 */

	public static void processUserClassifiedDocs(WeKeepSecrets wks, String user, String type) {

		if (wks.getUser(user) instanceof UserOfficer) {
			if (wks.getUserDocList(user).getNumberOfClassified() > 0) {

				DocIterator it = wks.ClassifiedDocsIterator(user);

				while (it.hasNext()) {
					Document d = it.next();

					System.out.println(d.getTitle() + " " + d.getSecurityType() + " " + wks.getDocNumberOfAccess(d));

					if (wks.getDocNumberOfAccess(d) > 0) {
						AccessIterator at = wks.docAccessIterator(d);
						listAccessesOfClassifiedDoc(wks, at);

					} else
						System.out.println(NOACCESSES);

					if (wks.getDocNumberOfGrants(d) > 0) {
						GrantIterator gt = wks.docGrantsIterator(d);
						listGrantsOfClassifiedDoc(wks, gt);

					} else
						System.out.println(NOGRANTS);
				}

			} else
				System.out.println(NONEEXISTANTDOCUMENTS + type + DOCUMENTS);

		} else
			System.out.println("Inappropriate security level.");

	}

	
	/**
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * @param at - AccessIterator of a specific Document
	 * 
	 * This method lists the accesses made to the document
	 */
	
	private static void listAccessesOfClassifiedDoc(WeKeepSecrets wks, AccessIterator at) {

		while (at.hasNext()) {
			Access a = at.next();
			System.out.print(
					wks.getIdOfAccessUser(a) + " [" + wks.getSecurityTypeOfAccessUser(a) + ", " + a.getTypeOfAccess());

			if (at.hasNext()) {
				System.out.print("], ");
			} else {
				System.out.println("]");
			}
		}

	}
	
	/**
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * @param gt - GrantIterator of a specific Document
	 * 
	 * This method lists the grants associated to the document
	 */

	private static void listGrantsOfClassifiedDoc(WeKeepSecrets wks, GrantIterator gt) {

		while (gt.hasNext()) {
			Grant g = gt.next();
			System.out.print(
					wks.getIdOfGrantsUser(g) + " [" + wks.getSecurityTypeOfGrantsUser(g) + ", " + g.getTypeOfGrant());
			if (gt.hasNext()) {
				System.out.print("], ");
			} else {
				System.out.println("]");
			}

		}

	}

	/**
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * 
	 * This method list the top 10 documents with more leaks (grants given to) in the WeKeepSecrets
	 * 
	 * This method do not require inputs
	 */
	private static void topLeaked(WeKeepSecrets wks) {
		if (wks.isLeakedEmpty() == false) {
			LeaksIterator lIt = wks.leakedDocsIterator();
			while (lIt.hasNext()) {
				Document d = lIt.next();
				System.out.println(d.getTitle() + " " + d.getManager() + " " + d.getSecurityLevel().getSecurityType()
						+ " " + wks.getDocNumberOfAccess(d) + " " + ((DocClassified) (d)).getNumberOfLeaks() + " "
						+ ((DocClassified) (d)).getNumberOfRevokes());

			}

		} else
			System.out.println(NONELEAKED);

	}
	
	/**
	 * @param wks - WeKeepSecrets (principal class that interacts with all the others)
	 * 
	 * This method list the top 10 users with more grants given (to other users) in the WeKeepSecrets
	 * 
	 * This method do not require inputs
	 */

	private static void topGranters(WeKeepSecrets wks) {

		if (wks.isGrantersEmpty() == false) {
			UserGranterIterator gIt = wks.grantersIterator();

			while (gIt.hasNext()) {
				User u = gIt.next();

				System.out.println(
						u.getId() + " " + u.getSecurityLevel().getSecurityType() + " " + u.getUserDocs().getCounter()
								+ " " + ((UserOfficer) (u)).grantsGiven() + " " + ((UserOfficer) (u)).revokesGiven());
			}
		} else
			System.out.println(NONEGIVENGRANTS);
	}
	
	

	/**
	 *  This method prints all the commands available in this program;
	 */
	private static void help() {
		System.out.println(REGISTERHELP);
		System.out.println(LISTUSERSHELP);
		System.out.println(UPLOADHELP);
		System.out.println(READHELP);
		System.out.println(WRITEHELP);
		System.out.println(GRANTHELP);
		System.out.println(REVOKEHELP);
		System.out.println(USERDOCSHELP);
		System.out.println(TOPLEAKEDHELP);
		System.out.println(TOPGRANTSHELP);
		System.out.println(HELPHELP);
		System.out.println(EXITHELP);

	}
}
