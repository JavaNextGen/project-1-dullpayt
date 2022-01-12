package com.revature.services;

import java.util.List;



import java.util.Optional;
import com.revature.controllers.UserController;
import com.revature.repositories.UserDAO;

import com.revature.models.Reimbursement;
import com.revature.models.User;

/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class UserService {

	UserDAO uDAO = new UserDAO();
		public void insertUser(User newUser) {
			
			//take in the Employee object sent from the menu and send it to the EmployeeDAO to be inserted into the database
			
			//call the DAO method that inserts the new Employee
			uDAO.insertUser(newUser);
		}
	
	

		
}		