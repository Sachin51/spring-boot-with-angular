package com.learn.webservice.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.webservice.model.ApplicationUser;
import com.learn.webservice.repo.ApplicationUserRepo;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	ApplicationUserRepo userRepo;

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "user",
        "$2a$10$6Iiz9p9S0vFyNYN4OUnRJuavKGaMsE6p4ZFuV83KSwMRD1izbY6Ja", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  System.out.println("username ......................"+username);
	ApplicationUser loggedInuser = userRepo.findByUserName(username);
	  System.out.println("Logged in user......................"+loggedInuser.toString());
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


