package com.example.server.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private int id;

  

  @NotNull
  @Column(unique = true)
//   @Getter(AccessLevel.NONE)
//   @Setter(AccessLevel.NONE)
  private String username;

  @NotNull
//   @Getter(AccessLevel.NONE)
//   @Setter(AccessLevel.NONE)
  private String password;
    
}
