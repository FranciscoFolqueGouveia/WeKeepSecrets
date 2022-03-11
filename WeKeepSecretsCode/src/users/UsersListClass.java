package users;

import weKeepSecrets.*;

public class UsersListClass implements UsersList {
	
	

	/**	
	 * GROWTH - fix number to increase the length of the array;
	 * SIZE - initial length of the array; 
	 * users - Array of Users
	 * counter - number of users in the array
	 * 
	 */
	private static final int GROWTH = 2;
	private static final int SIZE = 10;
	private User[] users;
	private int counter;
	
	/**
	 * Constructor
	 */
	
	public UsersListClass() {
		this.users = new User[SIZE];
		this.counter = 0;
	}

	public User[] getArray() {
		return this.users;
	}

	public int getCounter() {
		return this.counter;
	}
	
	
	public void registOfficer(String id, SecurityLvl sl) {
		if (isFull()) {
			resize();
		}
		users[counter++] = new UserOfficerClass(id, sl);

	}

	public void registClerk(String id) {
		if (isFull()) {
			resize();
		}
		users[counter++] = new UserClerkClass(id);
	}



	public void registerUser(User user) {
		if (isFull()) {
			resize();
		}
		
		users[counter++] = user;


	}

	public boolean hasUser(String id) {

		return searchIndex(id) > -1;

	}
	

	

	public User getUser(String user) {

		return users[searchIndex(user)];

	}

	public UserIterator UsersIterator() {
		UserIterator i = new UserIteratorClass(this.users, this.counter);
		return i;
	}

	public boolean isEmpty() {
		return counter == 0;
	}

	/**
	 * @return true if the array is full (no space to regist another User)
	 * else return false
	 */

	private boolean isFull() {
		return counter == users.length;

	}
	
	/**
	 * This method increases the arrays length
	 */

	private void resize() {

		User[] u = new User[users.length * GROWTH];

		for (int i = 0; i < counter; i++) {
			u[i] = users[i];
		}

		users = u;

	}
	/**
	 * @param user - the id of the user that we are trying to find
	 * @return result - if the user with that id exists,
	 *  result will be the position of that user on the array, 
	 * else if the document does not exists, result will be equal to -1
	 * 
	 */
	private int searchIndex(String user) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i < counter && !found)
			if (users[i].getId().equalsIgnoreCase(user))
				found = true;
			else
				i++;
		if (found)
			result = i;
		return result;

	}

}
