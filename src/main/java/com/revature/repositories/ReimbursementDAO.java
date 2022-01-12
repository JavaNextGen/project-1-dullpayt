package com.revature.repositories;


import com.revature.models.Reimbursement;
//import com.revature.models.Status;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {
	
	public List<Reimbursement> getReimbursements() { //This will use SQL SELECT functionality
	
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
	

			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String sql = "SELECT * FROM ers_reimbursement;";
			
			//Put the SQL query into a Statement object (The Connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The Statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(sql);
			
			//All the code above makes a call to your database... Now we need to store the data in an ArrayList.
			
			//create an empty ArrayList to be filled with the data from the database
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
				while(rs.next()) {
				
				//Use the all args constructor to create a new Employee object from each returned row from the DB
				Reimbursement r = new Reimbursement(
						//we want to use rs.get for each column in the record
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getString("reimb_description"),
						rs.getByte("reimb_receipt"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
							

				reimbursementList.add(r); //e is the new Employee object we created above
		
			}
						
			//when there are no more results in rs, the while loop will break
			//then, return the populated ArrayList of Employees
			return reimbursementList;
	
	
		}	
	
		catch (SQLException e) {
			System.out.println("Something went wrong selecting reimbursements!");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block, so Java won't yell
		//(Since there's no guarantee that the try will run)
		
		
	}
	
	public List<Reimbursement> getReimbursementsByAuthor(int id) { 
		
		try(Connection conn = ConnectionFactory.getConnection()){ 
	
			ResultSet rs = null;
		
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = " + id + " ;";
			
			Statement statement = conn.createStatement();
		
			rs = statement.executeQuery(sql);
			
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
				while(rs.next()) {
				
				Reimbursement r = new Reimbursement(
				
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getString("reimb_description"),
						rs.getByte("reimb_receipt"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
				reimbursementList.add(r); 
			}
			return reimbursementList;
		}	
		catch (SQLException e) {
			System.out.println("Something went wrong selecting reimbursements!");
			e.printStackTrace();
		}
		return null; 
	}

		public void insertReimbursement(Reimbursement newReimbursement) { //This is INSERT functionality 
        
        try(Connection conn = ConnectionFactory.getConnection()){
            
            //we'll create a SQL statement using parameters to insert a new Reimbursement
            String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_status_id, reimb_type_id) " //creating a line break for readability
                        + "VALUES (?, ?, ?, 1, ?); "; //these are parameters!! We have to specify the value of each "?"
            
            PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
            
            //use the PreparedStatement objects' methods to insert values into the query's ?s
            //the values will come from the Employee object we send in.
            ps.setInt(1, newReimbursement.getReimb_amount()); //1 is the first ?, 2 is the second, etc.
            ps.setString(2, newReimbursement.getReimb_description());
            ps.setInt(3, newReimbursement.getReimb_author());
            ps.setInt(4, newReimbursement.getReimb_type_id());
            
            //this executeUpdate() method actually sends and executes the SQL command we built
            ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
            //we use executeQuery() for selects
            
            //send confirmation to the console if successful.
            System.out.println("Reimbursement " + " created.");
            
            
        } catch(SQLException e) {
            System.out.println("Add Reimbursement failed! :(");
            e.printStackTrace();
        }  
        
    }
	
		public void updateReimbursement(Reimbursement reimbursement) { //This is INSERT functionality 
	        
	        try(Connection conn = ConnectionFactory.getConnection()){
	            
	            //we'll create a SQL statement using parameters to update a Reimbursement
	            String sql = "UPDATE ers_reimbursement SET reimb_status_id = ? , reimb_resolver = ? WHERE reimb_id = ?;";

	            
	            PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
	            
	            //use the PreparedStatement objects' methods to insert values into the query's ?s
	            //the values will come from the Employee object we send in.
	            ps.setInt(1, reimbursement.getReimb_status_id()); //1 is the first ?, 2 is the second, etc.
	            
	            ps.setInt(2, reimbursement.getReimb_resolver());
	            ps.setInt(3, reimbursement.getReimb_id());
	            
	            //this executeUpdate() method actually sends and executes the SQL command we built
	            ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
	            //we use executeQuery() for selects
	            
	            //send confirmation to the console if successful.
	            System.out.println("Reimbursement updated.");
	            
	            
	        } catch(SQLException e) {
	            System.out.println("Update Reimbursement failed!");
	            e.printStackTrace();
	        }	
		
	}
    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Reimbursement> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(int status) {
        return Collections.emptyList();
    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	return null;
    }
}
