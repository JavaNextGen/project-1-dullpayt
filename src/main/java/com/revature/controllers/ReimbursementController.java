package com.revature.controllers;

import java.util.List;




import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.models.AbstractReimbursement;
import com.revature.models.Reimbursement;

import com.revature.services.ReimbursementService;
import com.revature.services.UserService;


import io.javalin.http.Handler;


public class ReimbursementController {

	ReimbursementService rs = new ReimbursementService();
	
	
	public Handler getReimbursementsHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { //if the session exist
			
			List<Reimbursement> allReimbursements = rs.getReimbursements(); //MAYBE ABSTRACT REIMBURSEMENTS???--------
			
			// Add the dependency into your pom.xml so it can import the Gson library
			Gson gson = new Gson();
			
			// Use gson library to convert the java object to a JSON string
			String JSONReimbursements = gson.toJson(allReimbursements);
			
			// Give a response body with a JSON string 
			ctx.result(JSONReimbursements);
			ctx.status(201);
			

		} else {
			ctx.result("Oh no you failed to get the reimbursement!");
			ctx.status(404);
		}
	};
	
	public Handler insertReimbursementHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
			
			rs.insertReimbursement(reimbursement);
			
			
			ctx.result("Reimbursement was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to insert an reimbursement!!!");
			ctx.status(404);
		}
		
		
	};


	public Handler putReimbursementsHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
			
			rs.updateReimbursement(reimbursement);
			
			
			ctx.result("Reimbursement was successfully updated!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to update an reimbursement!!!");
			ctx.status(406);
		}
		 
			
	};
	
	public Handler getReimbursementsByAuthorHandler = ctx -> {
		if(ctx.req.getSession(true) !=null) {
			try {
				int id = Integer.parseInt(ctx.pathParam("id"));
				List<Reimbursement> Reimbursement = rs.getReimbursementsByAuthor(id);
				Gson gson = new Gson();
				String JSONReimbursements = gson.toJson(Reimbursement);
				ctx.result(JSONReimbursements);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Reimbursements by Role");
				ctx.status(404);
			}
			
		} else {	
				ctx.result("Unauthorized User");
				ctx.status(403);	
		}
	};	
}
