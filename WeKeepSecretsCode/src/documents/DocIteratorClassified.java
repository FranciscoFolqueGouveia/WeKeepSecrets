package documents;

public class DocIteratorClassified implements DocIterator {
	/*
	 * docs- Array of documents
	 * counter - number of classified documents
	 * next - index of the next Document to iterate
	 * */

	private Document[] docs;
	private int counter;
	private int next;
	
//Constructor
	public DocIteratorClassified(Document[] docs, int counter) {
		this.docs = docs;
		this.counter = counter;
		this.next = -1;

	}
	

	
	//finds if the array has a next DocClassified and gives to "next" the position of that document (if it exists);

	public boolean hasNext() {

		boolean found = false;

		while (next < counter && !found) {
			if (docs[next+1] instanceof DocClassified) {
				found = true;

			} next++;
		}

		return (found);

	}

	public Document next() {
		return docs[next];


	}
	

}
