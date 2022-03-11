package weKeepSecrets;

import documents.*;


public class LeaksIteratorClass implements LeaksIterator{
	/*
	 * MAX - fix the max number that will be iterated
	 * docs - array of documents
	 * next - index of the next document to iterate
	 * docsIterated -  number of documents already iterated
	 * counter - number of documents
	 * 
	 * */

	private static final int MAX = 10;
    private Document[] docs;
	private int next;
	private int docsIterated;
	private int counter;

	public LeaksIteratorClass(Document[] docs, int counter) {
		this.docs = docs;
		this.next = 0;
		this.docsIterated = 0;
		this.counter = counter;

	}

	public boolean hasNext() {
		return (next < counter && docsIterated < MAX);
	}

	public Document next() {
		this.docsIterated++;
		return docs[next++];

	}

	public void sortByLeaks() {

		for (int i = 1; i < counter; i++) {
			for (int j = counter - 1; j >= i; j--) {
				if (((DocClassified) (docs[j - 1])).getNumberOfLeaks() < ((DocClassified) (docs[j])).getNumberOfLeaks()) {
					Document d = docs[j - 1];
					docs[j - 1] = docs[j];
					docs[j] = d;
				} else if (((DocClassified) (docs[j - 1])).getNumberOfLeaks() == (((DocClassified) (docs[j])).getNumberOfLeaks())) {
					if (docs[j - 1].getTitle().compareTo(docs[j].getTitle()) > 0) {
						Document d = docs[j - 1];
						docs[j - 1] = docs[j];
						docs[j] = d;
					}
				}
			}
		}

	}

}
