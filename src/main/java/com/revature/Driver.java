package com.revature;

import java.sql.Connection; 
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.models.FinanceManager;
import com.revature.util.ConnectionFactory;
import com.revature.models.Reimbursement;



public class Driver {

    public static void main(String[] args) {
    	
    	//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
		//Here is the actual functionality of our application-------------------
		
		//spoiler alert... there will only be two lines of codes here
		//
		
		//Instantiate a menu object
		Employee menu = new Employee();
		
		//Use the Menu Class's displayMenu() method to give the user the menu
		menu.displayMenu();
		
		
		//this is our entire main method (until we learn Javalin in week 4)
		
		//all of the complicated menu logic is hidden in the Menu class... this is power of abstraction!!!!!
		
	}
    	
}
    

