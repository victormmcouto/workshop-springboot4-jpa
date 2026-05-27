package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

/*
This is a resource class. This kind of class, in this application, serves the purpose of
granting the interface access to the data. (REST CONTROLLER)
 */

@RestController
@RequestMapping(value = "/orders") //Defines the resource path.
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	//ending point
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		 List<Order> list = service.findAll();
		 
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = service.findById(id);
		return ResponseEntity.ok().body(order);
	}
}
