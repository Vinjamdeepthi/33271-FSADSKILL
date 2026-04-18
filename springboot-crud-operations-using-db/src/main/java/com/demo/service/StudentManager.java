package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.StudentNotFoundException;
import com.demo.model.Student;
import com.demo.repository.StudentRepository;
@Service
public class StudentManager 
{

	@Autowired
	StudentRepository sr;  //dependency injection
	public String insertData(Student s1)
	{
	sr.save(s1);
	return "student data insert successfully";
	}
	public List<Student>getAllData()
	{
		return sr.findAll();
	}
	public Student getDatabyId(Long sid)
	{
	    Optional<Student> s2 = sr.findById(sid);

	    if (s2.isPresent())
	    {
	        return s2.get();
	    }
	    else
	    {
	        throw new StudentNotFoundException("Student record does not exist with id: " + sid);
	    }
	}
	public String updateAllData(Long sid,Student s2)//upadte can be only done by id and we can upadate all or field by field
	{
		Optional<Student> s3=sr.findById(sid);
		if (s3.isPresent())
		{
			Student s4=s3.get();
			s4.setSname(s2.getSname());
			s4.setSdept(s2.getSdept());
			sr.save(s4);
			return "data was updated successfully";
		}
		else
		{
			throw new StudentNotFoundException("Student record does not exist with id: " + sid);
		}
	}
	public String updateName(Long sid,String sname)
	{
		Optional<Student> s2=sr.findById(sid);
		if (s2.isPresent()) {
			Student s3=s2.get();
			s3.setSname(sname);
			sr.save(s3);
			return "sudent name was updated successfully";
		}
		else
		{
			throw new StudentNotFoundException("Student record does not exist with id: " + sid);
		}
	}
	public String updateDept(Long sid,String sdept)
	{
		Optional<Student> s2=sr.findById(sid);
		if (s2.isPresent()) {
			Student s3=s2.get();
			s3.setSdept(sdept);
			sr.save(s3);
			return "sudent dept was updated successfully";
		}
		else
		{
			throw new StudentNotFoundException("Student record does not exist with id: " + sid);
		}
		
	}
	public String deleteData(Long sid)
	{	Optional<Student> s2=sr.findById(sid);
		if (s2.isPresent())
		{
		sr.deleteById(sid);
		return "data was deleted successfully";
		}
		else
		{
			throw new StudentNotFoundException("Student record does not exist with id: " + sid);
		}
	}
	
}
