package documents;

import weKeepSecrets.*;

/**
 * @author Martim Costa/ Francisco Gouveia
 *
 */
public interface DocsList {

	/**
	 * @return the array of Documents
	 */
	Document[] getArray();

	/**
	 * @return the number of documents in the array
	 */
	int getCounter();

	/**
	 * @param title - documents title
	 * @param manager - name of the user who has uploaded the document
	 * @param description - description of the document
	 * 
	 * this method regists a classified Document in the DocsList; His securityLvl is constant (OFFICIAL);
	 */
	void registOfficialDoc(String title, String manager, String description);

	/**
	 * @param title - documents title
	 * @param manager - name of the user who uploaded the document
	 * @param securityLvl - security level defined for the document
	 * @param description - description of the document
	 * 
	 * this method regists a classified Document in the DocsList; His securityLvl must be defined;
	 */
	void registClassifiedDoc(String title, String manager, SecurityLvl securityLvl, String description);

	/**
	 * @param d - Object document
	 * 
	 * this method regists an existent document in the DocsList
	 */
	void registDoc(Document d);

	/**
	 * @param title - document title
	 * @return true if that document exists in the DocsList
	 * @return false if that document do not exist in the DocsList
	 */
	boolean hasDoc(String title);

	/**
	 * @param doc - document title
	 * @return the object Document from the DocsList based on his title
	 */
	Document getDoc(String doc);

	/**
	 * @return number of classified documents in the DocsList
	 */
	int getNumberOfClassified();

	/**
	 * @return number of official documents in the DocsList
	 */
	int getNumberOfOfficial();
	
	/**
	 * @return true if the Array of documents is empty
	 * else return false;
	 */
	boolean isEmpty();
}
