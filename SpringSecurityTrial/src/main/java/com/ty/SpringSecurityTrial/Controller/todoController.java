package com.ty.SpringSecurityTrial.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringSecurityTrial.Service.todoservice;
import com.ty.SpringSecurityTrial.dto.Todolisttrequest;
import com.ty.SpringSecurityTrial.model.Todolist;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/todo")
public class todoController {

	@Autowired
	private todoservice Todoservice;

	@PostMapping("/add")
	public ResponseEntity<String> addtodo(@RequestBody Todolist Todolist) {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			Todoservice.addtodo(username,Todolist);
			return ResponseEntity.ok("Data Added");
		} catch (Error e) {
			throw new RuntimeErrorException(e, "data not been added");
		}
	}

	@GetMapping("/viewall")
	public ResponseEntity<?> getTodos() {
		return ResponseEntity.ok(Todoservice.viewalltodo());

	}

	
	
	
	@GetMapping("/viewbyid")
	public ResponseEntity<List<Todolisttrequest>> viewbyid() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return ResponseEntity.ok(Todoservice.viewbyid(username));
		} catch (Error e) {
			throw new RuntimeErrorException(e, "ID NOT FOUND");
		}
	}
	
//	@PostMapping("path")
//	public String Update(@RequestBody String entity) {
//		//TODO: process POST request
//		
//		return entity;
//	}
	
	
//	String username = SecurityContextHolder.getContext().getAuthentication().getName();

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable Long id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Todoservice.deletebyid(username, id);
		return ResponseEntity.ok("DATA DELETED");
	}
	
	@PostMapping("/Paginated/{page}/{size}")
	public ResponseEntity<List<Todolisttrequest>> findPaginated(@PathVariable int page, @PathVariable int size) {

		return ResponseEntity.ok(Todoservice.findPaginated(page, size));
	}
	
	

}
