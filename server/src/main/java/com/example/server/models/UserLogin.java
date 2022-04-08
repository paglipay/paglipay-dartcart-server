package com.example.server.models;
import lombok.Data;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserLogin {
    private String username;
    private String password;    
}
