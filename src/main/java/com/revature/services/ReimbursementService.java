package com.revature.services;



import com.revature.models.Reimbursement;


import com.revature.models.Status;
import com.revature.models.User;

import java.util.Collections;
import java.util.List;

import com.revature.repositories.ReimbursementDAO;




/**
 * The ReimbursementService should handle the submission, processing,
 * and retrieval of Reimbursements for the ERS application.
 *
 * {@code process} and {@code getReimbursementsByStatus} are the minimum methods required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create Reimbursement</li>
 *     <li>Update Reimbursement</li>
 *     <li>Get Reimbursements by ID</li>
 *     <li>Get Reimbursements by Author</li>
 *     <li>Get Reimbursements by Resolver</li>
 *     <li>Get All Reimbursements</li>
 * </ul>
 */
public class ReimbursementService {
	
	ReimbursementDAO rDAO = new ReimbursementDAO(); //so that I can use the methods from the EmployeeDAO
	
	public List<Reimbursement> getReimbursements() {
		
		//get the List of Employees by calling the DAO method that selects them from the database
		List<Reimbursement> reimbursements = rDAO.getReimbursements();
		
		//return the list of employees
		return reimbursements;
	}
	
	public void insertReimbursement(Reimbursement newReimbursement) {
		
		//take in the Employee object sent from the menu and send it to the EmployeeDAO to be inserted into the database
		
		//call the DAO method that inserts the new Employee
		rDAO.insertReimbursement(newReimbursement);
	}
    /**
     * <ul>
     *     <li>Should ensure that the user is logged in as a Finance Manager</li>
     *     <li>Must throw exception if user is not logged in as a Finance Manager</li>
     *     <li>Should ensure that the reimbursement request exists</li>
     *     <li>Must throw exception if the reimbursement request is not found</li>
     *     <li>Should persist the updated reimbursement status with resolver information</li>
     *     <li>Must throw exception if persistence is unsuccessful</li>
     * </ul>
     *
     * Note: unprocessedReimbursement will have a status of PENDING, a non-zero ID and amount, and a non-null Author.
     * The Resolver should be null. Additional fields may be null.
     * After processing, the reimbursement will have its status changed to either APPROVED or DENIED.
     */
    public Reimbursement process(Reimbursement unprocessedReimbursement, Status finalStatus, User resolver) {
        return null;
    }

    /**
     * Should retrieve all reimbursements with the correct status.
     */
    public List<Reimbursement> getReimbursementsByStatus(Status status) {
        return Collections.emptyList();
    }
}
