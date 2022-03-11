package weKeepSecrets;

import users.*;

public class UserGranterIteratorClass implements UserGranterIterator{
	
	

	/**
	 * MAX - fix number that represents the maximum users to iterate 
	 * users - array of users
	 * nextUser - index of the next user to iterate
	 * usersIterated - number of users iterated
	 * counter - number of users in the array
	 * 
	 */
	private static final int MAX = 10;
	private User[] users;
	private int nextUser;
	private int usersIterated;
	private int counter;

	//Constructor
	public UserGranterIteratorClass(User[] users, int counter) {
		this.users = users;
		this.nextUser = 0;
		this.usersIterated = 0;
		this.counter = counter;

	}

	public boolean hasNext() {
		return (nextUser < counter && usersIterated < MAX);
	}

	public User next() {
		this.usersIterated++;
		return users[nextUser++];

	}

	public void sortByGrants() {

		for (int i = 1; i < counter; i++) {
			for (int j = counter - 1; j >= i; j--) {
				if (((UserOfficer) (users[j - 1])).grantsGiven() < ((UserOfficer) (users[j])).grantsGiven()) {
					User u = users[j - 1];
					users[j - 1] = users[j];
					users[j] = u;
				} else if (((UserOfficer) (users[j - 1])).grantsGiven() == ((UserOfficer) (users[j])).grantsGiven()) {
					if (users[j - 1].getId().compareTo(users[j].getId()) > 0) {
						User u = users[j - 1];
						users[j - 1] = users[j];
						users[j] = u;
					}
				}
			}
		}

	}

}
