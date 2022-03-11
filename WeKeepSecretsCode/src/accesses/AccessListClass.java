package accesses;

import users.*;

public class AccessListClass implements AccessList {

	/**
	 * GROWTH - fix number to increase the length of the array; 
	 * SIZE - initial length of the array; 
	 * access - array of Objects of the type Access; 
	 * counter - number of objects in the array;
	 */

	private static final int GROWTH = 2;
	private static final int SIZE = 10;
	private Access[] access;
	private int counter;
	
	/*
	 * Constructor :
	 * 
	 * Initialize an array of accesses 
	 * counter - count the number of access in the array
	 **/
	
	public AccessListClass() {
		this.access = new Access[SIZE];
		this.counter = 0;
	}

	public Access[] getArray() {
		return this.access;
	}

	public int getCounter() {
		return this.counter;
	}

	/**
	 * @param user - User who updates a document; This method regists an access in
	 *             the document AccessList, saving the user and the type of access
	 *             ("write")
	 */

	public void registWriteAccess(User user) {
		if (isFull()) {
			resize();
		}
		access[counter++] = new AccessClass(user, "write");
	}

	/**
	 * @param user - User who reads a document; This method regists an access in the
	 *             document AccessList, saving the user and the type of access
	 *             ("read")
	 */

	public void registReadAccess(User user) {
		if (isFull()) {
			resize();
		}
		access[counter++] = new AccessClass(user, "read");
	}

	/**
	 * @return true if the array is full (no space to regist another Access)
	 * @return false if the array have space to regist another Access
	 */
	private boolean isFull() {
		return counter == access.length;

	}
	
	/**
	 * This method increases the arrays length
	 */
	private void resize() {

		Access[] a = new Access[access.length * GROWTH];

		for (int i = 0; i < counter; i++) {
			a[i] = access[i];
		}

		access = a;

	}
}
