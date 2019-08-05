package com.learn.webservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.webservice.model.ToDo;
import com.learn.webservice.service.impl.ToDoServiceImpl;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/todo")
public class ToDoController {

	@Autowired
	public ToDoServiceImpl todoServiceImpl;
	
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public ToDo getToDoItem(@PathVariable String username, @PathVariable long id) {
		return todoServiceImpl.getToDoItem(username, id);
	}
	
	@GetMapping("/jpa/users/{username}/todos")
	public List<ToDo> getAllToDos(@PathVariable String username){
		return todoServiceImpl.getAllToDos(username);
	}
	
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		
		return todoServiceImpl.deleteTodo(username, id);
	}
	
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<ToDo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody ToDo todo){
		return todoServiceImpl.updateTodo(username, id, todo);
	}
	
	@PostMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<ToDo> addTodo(@PathVariable String username, @PathVariable long id, @RequestBody ToDo todo){
		return todoServiceImpl.addTodo(username, id, todo);
	}
	
}
