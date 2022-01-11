package com.revature.controllers;

import com.google.gson.Gson;


import java.util.List;
import com.revature.services.UserService;
import com.revature.models.ERSLoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

//LINE 29 --- cannot convert String to boolean operation???


public class AuthController {

	AuthService as = new AuthService();
	
	public Handler loginHandler = (ctx) -> {
		
		//whats the request body? (which we get from ctx.body) it is the data that gets send in with a request
		//GET requests will have empty request bodies, but POST requests, which send data, will have some data
		String body = ctx.body();//turn the body (data) of the POST request into a Java String
		
		Gson gson = new Gson();//create a new Gson object to make Java <-> JSON conversions
		
		ERSLoginDTO LDTO = gson.fromJson(body, ERSLoginDTO.class);//turn that JSON String into a LoginDTO object
		
		//control flow to determine what happens i the event of successful/unsuccessful login
		//invoke the login() method of the AuthService using the username and password from the LoginDTO
		if(as.login(LDTO.getUsername(), LDTO.getPassword())) {
			
			//create a user session so that they can access the applications other functionalities
			ctx.req.getSession();//req is a "request object", we establish sessions through it
			
			//return a successful status code
			ctx.status(202);//User credentials were accepted... you could use any 200 level status code
			
			//send a message relaying the success
			ctx.result("Login Success!");
			
		} else {
			
			ctx.status(401);//unauthorized status code
			ctx.result("Login Failed beeeeech");
		}
		
		
		
	};
	
	
}
