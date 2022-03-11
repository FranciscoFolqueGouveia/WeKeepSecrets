package users;

import weKeepSecrets.*;

public interface UsersList {
	
	/**
	 * @return the Array of the UsersList 
	 */
	public User[] getArray();
	
	
	/**
	 * @return the number of users in the array
	 */
	public int getCounter();

	/**
	 * @param id - id of a new user
	 * @param sl - security level of a new user
	 * 
	 * this method regists a new Officer in the UsersList, saving his id and his SecurityLvl
	 */
	void registOfficer(String id, SecurityLvl sl);

	/**
	 * @param id - id of a new user
	 * 
	 * this method regists a new Clerk in the UsersList, saving his id. 
	 * This method do not ask for a SecurityLvl because it is constant for the Clerks
	 *  */
	void registClerk(String id);
	
	/**
	 * @param user - User that already exists 
	 * this method regists a user that already exists in the UsersList
	 */
	void registerUser(User user);

	/**
	 * @param id - id of the user we want to verify if exists
	 *
	 * @return true if the user with that id is in the UsersList
	 * else return false
	 */
	boolean hasUser(String id);

	/**
	 * @param id - id of the user we want to find
	 * @return the User with that id in the UsersList
	 */
	User getUser(String id);

	/**
	 * @return the UserIterator of the UsersList
	 */
	UserIterator UsersIterator();

	/**
	 * @return true if the UsersList is empty
	 * else return false
	 */
	boolean isEmpty();
	
	

}
