package com.klu.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "student_59_swagger")
@Schema(description = "Student Entity")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "1")
    private Long id;

    @NotBlank
    @Schema(example = "Venki")
    private String name;

    @Email
    @Schema(example = "venki@gmail.com")
    private String email;

    @NotBlank
    @Schema(example = "CSE")
    private String course;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}