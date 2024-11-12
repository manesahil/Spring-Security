package com.ty.SpringSecurityTrial.Service;

import java.util.List;

import com.ty.SpringSecurityTrial.dto.Todolisttrequest;
import com.ty.SpringSecurityTrial.model.Todolist;

public interface todoservice {

	public void addtodo(String username,Todolist Todolist);

	public List<Todolisttrequest> viewbyid(String username);

	public List<Todolisttrequest> viewalltodo();

	public void Update(String username, Long id, Todolisttrequest Todolisttrequest);

	public void deletebyid(String username, Long id);

	public List<Todolisttrequest> findPaginated(int page, int size);

}
