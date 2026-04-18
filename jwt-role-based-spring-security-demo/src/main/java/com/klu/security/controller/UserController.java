package com.klu.security.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController 
{

@GetMapping("/profile")
public String profile(){

return "User Profile API working";

}

}