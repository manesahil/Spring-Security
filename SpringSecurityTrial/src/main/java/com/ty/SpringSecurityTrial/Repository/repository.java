package com.ty.SpringSecurityTrial.Repository;

import com.ty.SpringSecurityTrial.model.user;

public interface repository {
	
	public user FindUsername(String username);

}