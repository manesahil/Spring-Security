package com.ty.SpringSecurityTrial.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ty.SpringSecurityTrial.model.UserRowMapper;
import com.ty.SpringSecurityTrial.model.user;

@Repository
public class Repositoryimpl implements repository{

	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public user FindUsername(String Username)
	{
		String sql="SELECT * FROM users WHERE Username=?";
		
		return jdbcTemplate.queryForObject(sql,new UserRowMapper(),Username);
	}

	
	
	
	
	
	
}
