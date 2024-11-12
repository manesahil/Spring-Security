package com.ty.SpringSecurityTrial.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.SpringSecurityTrial.Repository.repository;
import com.ty.SpringSecurityTrial.Repository.todolistrepository;
import com.ty.SpringSecurityTrial.dto.Todolisttrequest;
import com.ty.SpringSecurityTrial.model.Todolist;

@Service
public class todolistserviceimpl implements todoservice {

	@Autowired
	private todolistrepository todolistrepository;

	@Autowired
	repository repository;
	
	@Override
	public void addtodo(String username,Todolist Todolist) {
		Long userid = repository.findUserId(username);
		todolistrepository.addtodo(userid,Todolist);
	}

	@Override
	public List<Todolisttrequest> viewbyid(String username) {
		Long userid = repository.findUserId(username);
		return todolistrepository.viewbyid(userid);
	}

	@Override
	public List<Todolisttrequest> viewalltodo() {

			return todolistrepository.viewalltodo();
		}
	

	@Override
	public void Update(String username, Long id, Todolisttrequest Todolisttrequest) {
		Long userid=repository.findUserId(username);
		todolistrepository.Update(userid, id, Todolisttrequest);
	}

	@Override
	public void deletebyid(String username, Long id) {
		Long userid=repository.findUserId(username);
		todolistrepository.deletebyid(userid, id);
	}

	@Override
	public List<Todolisttrequest> findPaginated(int page, int size) {
		return todolistrepository.findPaginated(page, size);
	}

}
