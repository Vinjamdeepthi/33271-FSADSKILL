package com.klu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.Student;
import com.klu.servivce.StudentManager;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
//http://localhost:8080/swagger-ui/index.html
public class StudentController 
{

    @Autowired
    StudentManager sm;

    @Operation(summary = "Add Student")
    @PostMapping
    public String add(@RequestBody Student s) 
    {
        return sm.insertData(s);
    }

    @Operation(summary = "Get All Students")
    @GetMapping
    public List<Student> getAll() 
    {
        return sm.getAll();
    }

    @Operation(summary = "Get Student By ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Success"),@ApiResponse(responseCode = "404", description = "Not Found")})
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) 
    {
        return sm.getById(id);
    }

    @Operation(summary = "Update Student")
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Student s) 
    {
        return sm.update(id, s);
    }

    @Operation(summary = "Delete Student")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) 
    {
        return sm.delete(id);
    }
}