package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAO {

public void insertUser(User newUser) { //This is INSERT functionality 
        
        try(Connection conn = ConnectionFactory.getConnection()){

            //we'll create a SQL statement using parameters to insert a new Reimbursement
            String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) " //creating a line break for readability
                        + "VALUES (?, ?, ?, ?, ?, ?); "; //these are parameters!! We have to specify the value of each "?"
            
            PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
            
	           
				ps.setString(1, newUser.getErs_username());
				ps.setString(2, newUser.getErs_password());
				ps.setString(3, newUser.getUser_first_name());
				ps.setString(4, newUser.getUser_last_name());
				ps.setString(5, newUser.getUser_email());
				ps.setInt(6, newUser.getUser_role_id());
	              
            //this executeUpdate() method actually sends and executes the SQL command we built
            ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
            //we use executeQuery() for selects
            
            //send confirmation to the console if successful.
            System.out.println("User Created! Nice!");
            
            
        } catch(SQLException e) {
            System.out.println("Create User Failed! Darn :(");
            e.printStackTrace();
        }  
        
    }
	

    /**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }

    /**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     *
     * Note: The userToBeRegistered will have an id=0, and username and password will not be null.
     * Additional fields may be null.
     */
    public User create(User userToBeRegistered) {
        return userToBeRegistered;
    }
}
