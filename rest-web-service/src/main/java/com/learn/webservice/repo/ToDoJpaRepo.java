package com.learn.webservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.webservice.model.ToDo;

@Repository
public interface ToDoJpaRepo extends JpaRepository<ToDo, Long>{

	public List<ToDo> findByUsername(String username);
}
