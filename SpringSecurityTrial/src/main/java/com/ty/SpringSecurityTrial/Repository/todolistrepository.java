package com.ty.SpringSecurityTrial.Repository;

import java.util.List;

import com.ty.SpringSecurityTrial.dto.Todolisttrequest;
import com.ty.SpringSecurityTrial.model.Todolist;

public interface todolistrepository {

	public void addtodo(Long user_id,Todolist Todolist);

	public List<Todolisttrequest> viewbyid(Long user_id);

	public List<Todolisttrequest> viewalltodo();

	public void Update(Long user_id, Long id, Todolisttrequest Todolisttrequest);

	public void deletebyid(Long user_id, Long id);
	
	public List<Todolisttrequest> findPaginated(int page, int size);

}
