package com.learn.webservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.learn.webservice.model.ToDo;

public interface ToDoService {

	public ToDo getToDoItem(@PathVariable String username, @PathVariable long id);
	public List<ToDo> getAllToDos(@PathVariable String username);
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id);
	public ResponseEntity<ToDo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody ToDo todo);
	public ResponseEntity<ToDo> addTodo(@PathVariable String username, @PathVariable long id, @RequestBody ToDo todo);
}
