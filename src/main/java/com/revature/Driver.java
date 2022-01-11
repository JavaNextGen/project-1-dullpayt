package com.revature;

import java.sql.Connection; 




import java.sql.SQLException;


//import com.revature.models.Menu;
import com.revature.util.ConnectionFactory;
import com.revature.models.Reimbursement;
import com.revature.controllers.AuthController;

import com.revature.controllers.UserController;
import com.revature.controllers.ReimbursementController;

import io.javalin.Javalin;




public class Driver {

    public static void main(String[] args) {
    	
    	UserController uc = new UserController();
    	AuthController ac = new AuthController();
    	ReimbursementController rc = new ReimbursementController();
    	
    	//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
				}
			).start(3000);
	
	//app.get("/user", uc.getUserHandler);
	//app.post("/user", uc.insertUserHandler);
	
	//app.get("/login", ac.loginHandler);
	
	app.get("/reimbursement", rc.getReimbursementsHandler);
	app.post("/reimbursement", rc.insertReimbursementHandler);
	
	}
    	
}
    

