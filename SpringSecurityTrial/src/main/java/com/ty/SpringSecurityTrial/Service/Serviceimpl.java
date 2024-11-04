package com.ty.SpringSecurityTrial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.SpringSecurityTrial.Repository.repository;
import com.ty.SpringSecurityTrial.model.user;


@Service
public class Serviceimpl implements service {
@Autowired
public repository repository;
	
	public boolean ValidateUser(String username, String Password) {
		user users=repository.FindUsername(username);
		return users !=null && users.getPassword().equals(Password);
	}
	
}
