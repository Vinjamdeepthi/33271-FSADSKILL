package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;
import com.demo.service.StudentManager;

@CrossOrigin(origins="http://localhost:5173")  //common resource sharing
@RestController //controller + json
@RequestMapping("/dbcrud")
@ResponseBody
public class StudentController 
{

	@Autowired
	StudentManager sm;
	@PostMapping("/insert")
	public String insert(@RequestBody Student s2)
	{
		return sm.insertData(s2);
	}
	
	//http://localhost:8080/dbcrud/getalldata
	@GetMapping("/getalldata")
	@ResponseBody
	public List<Student>getAll()
	{
	return sm.getAllData();
	}
	
	//http://localhost:8080/dbcrud/getbyid/4
	@GetMapping("/getbyid/{sid}")
	@ResponseBody
	public Student getById(@PathVariable Long sid)
	{
		return sm.getDatabyId(sid);
	}
	//http://localhost:8080/dbcrud/updateall/3
	@PutMapping("/updateall/{sid}")
	@ResponseBody
	public String updateAllData(@PathVariable Long sid,@RequestBody Student s5)
	{
		return sm.updateAllData(sid, s5);
	}
	//http://localhost:8080/dbcrud/updateName/3?sname=chiru
	@PatchMapping("/updateName/{sid}")
	@ResponseBody
	public String updateName(@PathVariable Long sid,@RequestParam String sname)
	{
		return sm.updateName(sid, sname);
	}
	//http://localhost:8080/dbcrud/updateDept/2?sdept=eee
	@PatchMapping("/updateDept/{sid}")
	@ResponseBody
	public String updateDept(@PathVariable Long sid,@RequestParam String sdept)
	{
		return sm.updateDept(sid, sdept);
	}
	
	//http://localhost:8080/dbcrud/deletedata/3
	@DeleteMapping("/deletedata/{sid}")
	@ResponseBody
	public String deletedata(@PathVariable Long sid)
	{
		return sm.deleteData(sid);
	}
	
	
	
	
}
