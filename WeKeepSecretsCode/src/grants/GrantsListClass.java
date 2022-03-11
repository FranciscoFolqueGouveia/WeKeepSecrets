package grants;

import users.User;

public class GrantsListClass implements GrantsList {
	/*
	 * GROWTH - fix number to increase the length of the array;
	 * SIZE - initial length of the array;
	 * grants - list of grants and revokes;
	 * counter - total number of grants and revokes given
	 * 
	 * */

	private static final int GROWTH = 2;
	private static final int SIZE = 10;
	private Grant[] grants;
	private int counter;
	
	/**
	 * Constructor
	 */
	
	public GrantsListClass() {
		this.grants = new Grant[SIZE];
		this.counter = 0;
	}

	public Grant[] getArray() {
		return this.grants;
	}

	public int getCounter() {
		return this.counter;
	}


	public void registGrantGiven(User user) {
		if (isFull()) {
			resize();
		}
		grants[counter++] = new GrantClass(user, "grant");
	}

	public void registGrantRevoked(User user) {
		if (isFull()) {
			resize();
		}
		grants[counter++] = new GrantClass(user, "revoked");
	}

	

	public boolean userHasGrant(String user) {

		boolean found = false;
		boolean result = false;

		for (int i = counter - 1; i >= 0 && !found; i--) {
			if (grants[i].getUser().getId().equalsIgnoreCase(user)) {
				found = true;
				if (grants[i].getTypeOfGrant().equalsIgnoreCase("grant")) {
					result = true;
				}
			}

		}
		return result;

	}
	public boolean userHasRevoke(String user) {

		boolean found = false;
		boolean result = false;

		for (int i = counter - 1; i >= 0 && !found; i--) {
			if (grants[i].getUser().getId().equalsIgnoreCase(user)) {
				found = true;
				if (grants[i].getTypeOfGrant().equalsIgnoreCase("revoked")) {
					result = true;
				}

			}

		}
		return result;

	}
	
	/**
	 * @return true if the counter has already the size of grants list
	 * */
		private boolean isFull() {
			return counter == grants.length;

		}/**
		*This method will increase the length of the array of list of grants
		 */
		private void resize() {

			Grant[] a = new Grant[grants.length * GROWTH];

			for (int i = 0; i < counter; i++) {
				a[i] = grants[i];
			}

			grants = a;

		}
}
