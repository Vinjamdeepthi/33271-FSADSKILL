package com.klu.servivce;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Student;
import com.klu.exception.StudentNotFoundException;
import com.klu.repository.StudentRepository;
@Service
public class StudentManager 
{

    @Autowired
    StudentRepository repo;

    public String insertData(Student s) 
    {
        repo.save(s);
        return "Student added successfully";
    }

    public List<Student> getAll() 
    {
        return repo.findAll();
    }

    public Student getById(Long id) 
    {
        return repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not found with id: " + id));
    }

    public String update(Long id, Student s) 
    {
        Student existing = getById(id);
        existing.setName(s.getName());
        existing.setEmail(s.getEmail());
        existing.setCourse(s.getCourse());
        repo.save(existing);
        return "Student updated successfully";
    }

    public String delete(Long id) 
    {
        Student s = getById(id);
        repo.delete(s);
        return "Student deleted successfully";
    }
}