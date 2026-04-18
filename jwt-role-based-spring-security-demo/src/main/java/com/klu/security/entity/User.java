package com.klu.security.entity;

import jakarta.persistence.*;
@Entity
@Table(name="jwt") 
public class User 
{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String username;
private String password;
private String role;

public String getUsername() 
{
return username;
}

public String getPassword() 
{
return password;
}

public String getRole() 
{
return role;
}

}