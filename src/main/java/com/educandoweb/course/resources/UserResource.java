package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

/*
This is a resource class. This kind of class, in this application, serves the purpose of
granting the interface access to the data. (REST CONTROLLER)
 */

@RestController
@RequestMapping(value = "/users") //Defines the resource path.
public class UserResource {
	
	//ending point
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.colm", "31972110555", "******");
		
		return ResponseEntity.ok().body(u);
	}
}
