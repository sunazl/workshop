package com.lt.workshop.doorman.auth.domain;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user_entity")
public class User {

  @Id
  private long id;
  private String username;
  private String password;
  private Date lastAccessedTime;

  User() {
  }

  public User(String username) {
    this.username = username;
    this.lastAccessedTime = new Date();
  }

  public String getUsername() {
    return username;
  }
}
