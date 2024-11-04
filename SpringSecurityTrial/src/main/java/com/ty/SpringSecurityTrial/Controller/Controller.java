package com.ty.SpringSecurityTrial.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/h1")
public class Controller {

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
	//@PreAuthorize("hasRole('USER')")
	@PostMapping("/user")
	public String user() {
		return "hello user";
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return "hello admin";
	}

}
