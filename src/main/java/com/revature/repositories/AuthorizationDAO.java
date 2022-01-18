package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class AuthorizationDAO {

	public User getUser(String ers_username, String ers_password) {
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			

			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
            
            //use the PreparedStatement objects' methods to insert values into the query's ?s
            //the values will come from the Employee object we send in.
            ps.setString(1, ers_username); //1 is the first ?, 2 is the second, etc.
          
            
            //this executeUpdate() method actually sends and executes the SQL command we built
           

			
			//Put the SQL query into a Statement object (The Connection object has a method for this!!)
			
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The Statement object has a method that takes Strings to execute as a SQL query
			rs = ps.executeQuery();
			
			//All the code above makes a call to your database... Now we need to store the data in an ArrayList.
			
			//create an empty ArrayList to be filled with the data from the database
			
				while(rs.next()){
				
				//Use the all args constructor to create a new Employee object from each returned row from the DB
				User u = new User(
						//we want to use rs.get for each column in the record
						rs.getInt("ers_users_id"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						);
				
//				ers_users_id serial PRIMARY KEY,
//				ers_username varchar(50) UNIQUE,
//				ers_password varchar(50),
//				user_first_name varchar(100), 
//				user_last_name varchar(100),
//				user_email varchar(150) UNIQUE,
//				user_role_id int,
	
				
					
			    
				
				//and populate the ArrayList with each new Employee object
				//e is the new Employee object we created above
		
			
						
			//when there are no more results in rs, the while loop will break
			//then, return the populated ArrayList of Employees
			return u;
	
		}	
		}	
	
		catch (SQLException e) {
			System.out.println("Something went wrong with logging in!");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block, so Java won't yell
		//(Since there's no guarantee that the try will run)
		
		
	
	}
}
