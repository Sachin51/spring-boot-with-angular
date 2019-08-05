package com.learn.webservice.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;
    
    
//    {
//    	"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTY1MDAwMzQ1LCJpYXQiOjE1NjQzOTU1NDV9.zcWXszoiUru_MtGTU4QcBUbwO2FcCvyymJ0xgV0r2tIj-mNkIB_saKpeAzD0L6vV8P8NsOKx__Q4f1Pey9SwQg"
//    }

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

