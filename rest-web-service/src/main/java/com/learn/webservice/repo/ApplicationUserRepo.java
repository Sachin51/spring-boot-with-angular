package com.learn.webservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.webservice.model.ApplicationUser;

public interface ApplicationUserRepo extends JpaRepository<ApplicationUser, Long>{

	ApplicationUser findByUserName(String username);
}
