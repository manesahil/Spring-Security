package com.ty.SpringSecurityTrial.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ty.SpringSecurityTrial.model.Todolist;
import com.ty.SpringSecurityTrial.model.todolistrowmapper;
import com.ty.SpringSecurityTrial.dto.Todolisttrequest;

@Repository
public class todorepoimpl implements todolistrepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addtodo(Long user_id,Todolist Todolist) {

		String sql = "INSERT INTO todo (title, description, status, user_id) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, Todolist.getTitle(), Todolist.getDescription(), Todolist.getStatus(),
				user_id);
	}

	@SuppressWarnings({ "deprecation" })
	@Override
	public List<Todolisttrequest> viewbyid(Long user_id) {
		String sql = "SELECT * FROM todo WHERE user_id=?";

		return (List<Todolisttrequest>) jdbcTemplate.query(sql, new Object[] { user_id }, new todolistrowmapper());

	}

	@SuppressWarnings("deprecation")
	public List<Todolisttrequest> findByUserId(Long userId) {
		String sql = "SELECT * FROM todo WHERE user_id=?";

		return jdbcTemplate.query(sql, new Object[] { userId }, new todolistrowmapper());
	}

	@Override
	public List<Todolisttrequest> viewalltodo() {
		String sql = "SELECT * FROM todo";
		return jdbcTemplate.query(sql, new todolistrowmapper());
	}

	@Override
	public void Update(Long user_id, Long id, Todolisttrequest Todolisttrequest) {
		String sql = "UPDATE todo SET title=?,description=?,status=? WHERE user_id=? AND id=?";
		jdbcTemplate.update(sql, Todolisttrequest.getTitle(), Todolisttrequest.getDescription(),
				Todolisttrequest.getStatus(), user_id, id);
	}

	@Override
	public void deletebyid(Long user_id, Long id) {
		String sql = "DELETE FROM todo WHERE user_id=? AND id=?";
		jdbcTemplate.update(sql, user_id, id);
	}

	@SuppressWarnings("deprecation")
	public List<Todolisttrequest> findPaginated(int page, int size) {
		int offset = (page - 1) * size;
		String sql = "SELECT * FROM todo LIMIT ? OFFSET ?";
		
		
		return jdbcTemplate.query(sql, new Object[] { size, offset }, new todolistrowmapper());
	
	}
}
