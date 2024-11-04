package com.ty.SpringSecurityTrial.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<user> {

	@Override
	public user mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		user user = new user();
		user.setId(rs.getLong("Id"));
		user.setUserName(rs.getString("UserName"));
		user.setPassword(rs.getString("Password"));
		return user;
	}

}
