package users;

public class UserIteratorClass implements UserIterator {
	
	
	/**
	 * user - Array of Users
	 * counter - number of users in the array
	 * nextUser - index of the next user in the array to iterate
	 */
	private User[] user;
	private int counter;
	private int nextUser;

	/**
	 * Constructor
	 */	
public UserIteratorClass(User[] user,int counter) {
	this.user=user;
	this.counter=counter;
}

	
	public boolean hasNext() {
		
		return nextUser < counter;
	}

	
	public User next() {
		
		return  user[nextUser++];
	}}