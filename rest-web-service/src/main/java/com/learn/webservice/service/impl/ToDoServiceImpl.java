package com.learn.webservice.service.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn.webservice.model.ToDo;
import com.learn.webservice.repo.ToDoJpaRepo;
import com.learn.webservice.service.ToDoService;

@Service
public class ToDoServiceImpl implements ToDoService{

	@Autowired
	public ToDoJpaRepo todoJpaRepo;
	
	@Override
	public ToDo getToDoItem(String username, long id) {
		return todoJpaRepo.findById(id).get();
	}

	@Override
	public List<ToDo> getAllToDos(String username) {
		return todoJpaRepo.findByUsername(username);
	}

	@Override
	public ResponseEntity<Void> deleteTodo(String username, long id) {
		todoJpaRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<ToDo> updateTodo(String username, long id, ToDo todo) {
		todoJpaRepo.save(todo);
		return new ResponseEntity<ToDo>(todo,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ToDo> addTodo(String username, long id, ToDo todo) {
		ToDo createdToDo = todoJpaRepo.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}").buildAndExpand(createdToDo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
