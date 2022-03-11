package documents;

import weKeepSecrets.*;

public class DocsListClass implements DocsList {
	/*
	 * GROWTH - fix number to increase the length of the array;
	 * SIZE - initial length of the array; 
	 * docs -Array of documents
	 * counter-  total number of documents classified and official documents on the array
	 * nClassified -number of classified documents on the documents list
	 * nOfficial - number of official documents on the documents list
	 * 
	 * */

	private static final int GROWTH = 2;
	private static final int SIZE = 10;
	private Document[] docs;
	private int counter;
	private int nClassified;
	private int nOfficial;

	/**
	 * Constructor 
	 */
	public DocsListClass() {
		this.docs = new Document[SIZE];
		this.counter = 0;
		this.nClassified = 0;
		this.nOfficial = 0;

	}

	public Document[] getArray() {
		return this.docs;
	}

	public int getCounter() {
		return this.counter;
	}
	public void registOfficialDoc(String title, String manager, String description) {
		if (isFull()) {
			resize();
		}
		docs[counter++] = new DocOfficialClass(title, manager, description);
		this.nOfficial++;

	}
	public void registClassifiedDoc(String title, String manager, SecurityLvl securityLvl, String description) {
		if (isFull()) {
			resize();
		}
		docs[counter++] = new DocClassifiedClass(title, manager, securityLvl, description);
		this.nClassified++;
	}
	public void registDoc(Document d) {
		if (isFull()) {
			resize();
		}
		
		docs[counter++] = d;
	}
	
	public boolean hasDoc(String title) {

		return searchIndex(title) > -1;

	}
	public Document getDoc(String doc) {

		return docs[searchIndex(doc)];

	}

	public int getNumberOfClassified() {
		return this.nClassified;
	}

	public int getNumberOfOfficial() {
		return this.nOfficial;
	}
	
	
	public boolean isEmpty() {
		return this.counter == 0;
	}
	
	/**
	 * @param doc - the name of the document that we are trying to find
	 * @return result - if the document with that name exists,
	 *  result will be the position of that document on the array, 
	 * else if the document does not exist result will be equal to -1
	 * 
	 * This method receives a name of a document and will try to find that documents index on the Document list
	 */
	private int searchIndex(String doc) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i < counter && !found)
			if (docs[i].getTitle().equalsIgnoreCase(doc)) {
				found = true;
			} else
				i++;
		if (found) {
			result = i;
		}
		return result;

	}
	/**
	 * @return true if the array is full (no space to regist another Document)
	 * @return false if the array have space to regist another Document
	 */
	
	private boolean isFull() {
		return counter == docs.length;

	}
	
	/**
	 * This method increases the arrays length
	 */

	private void resize() {

		Document[] d = new Document[docs.length * GROWTH];

		for (int i = 0; i < counter; i++) {
			d[i] = docs[i];
		}

		docs = d;

	}

}
