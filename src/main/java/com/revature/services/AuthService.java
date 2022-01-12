package com.revature.services;



import com.revature.repositories.AuthorizationDAO;

//Need to figure out which classes to import. Which DAO to call... pretty sure the UserDAO



import com.revature.repositories.UserDAO;

import com.revature.models.User;

import java.util.Optional;

/**
 * The AuthService should handle login and registration for the ERS application.
 *
 * {@code login} and {@code register} are the minimum methods required; however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Retrieve Currently Logged-in User</li>
 *     <li>Change Password</li>
 *     <li>Logout</li>
 * </ul>
 */
public class AuthService {
	AuthorizationDAO aDAO = new AuthorizationDAO();
public int login(String username, String password) {
	try {
	
	User user = aDAO.getUser(username,password);
	String checkUsername = user.getErs_username();
	
	String checkPassword = user.getErs_password();
	int role = user.getUser_role_id();
	
	if(username.equals(checkUsername) && password.equals(checkPassword) && role == 1) {
		return 1;
	} else if (username.equals(checkUsername) && password.equals(checkPassword) && role == 2) {
		return 2;
	}
	else {
		return 0;
	}
	
	}
	catch(IndexOutOfBoundsException e){
		System.out.println("Password did not match the system");
		return 0;
	}
	
	

};

	



	
	
	
    /**
     * <ul>
     *     <li>Needs to check for existing users with username/email provided.</li>
     *     <li>Must throw exception if user does not exist.</li>
     *     <li>Must compare password provided and stored password for that user.</li>
     *     <li>Should throw exception if the passwords do not match.</li>
     *     <li>Must return user object if the user logs in successfully.</li>
     * </ul>
     */
   

    /**
     * <ul>
     *     <li>Should ensure that the username/email provided is unique.</li>
     *     <li>Must throw exception if the username/email is not unique.</li>
     *     <li>Should persist the user object upon successful registration.</li>
     *     <li>Must throw exception if registration is unsuccessful.</li>
     *     <li>Must return user object if the user registers successfully.</li>
     *     <li>Must throw exception if provided user has a non-zero ID</li>
     * </ul>
     *
     * Note: userToBeRegistered will have an id=0, additional fields may be null.
     * After registration, the id will be a positive integer.
     */
    public User register(User userToBeRegistered) {
        return null;
    }

    /**
     * This is an example method signature for retrieving the currently logged-in user.
     * It leverages the Optional type which is a useful interface to handle the
     * possibility of a user being unavailable.
     */
    public Optional<User> exampleRetrieveCurrentUser() {
        return Optional.empty();
    }
}
