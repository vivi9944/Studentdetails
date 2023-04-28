package com.pro2.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro2.demo.model.Student;
import com.pro2.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService StudentController;
	
	@GetMapping("fetchstudent")
	public List<Student> getAllStudents()
	{
		List<Student>studentList=StudentController.getAllStudents();
		return studentList;
	}
	
	@PostMapping("save-student")
	public Student saveStudent(@RequestBody Student s ) {
		return StudentController.saveStudent(s);
	}
	@PutMapping("/updateStudent/{regno}")
	public  Student updateStudent(@RequestBody Student s,@PathVariable("regno") int regno)
	{	
		return StudentController.updateStudent(s,regno);
	}	
	@DeleteMapping("delete-student/{id}")
	public void deleteStudent(@PathVariable("id") int id) {
		StudentController.deleteStudent(id);
	}
	@GetMapping("/sortStudents/{field}")
	public List<Student>sortStudents(@PathVariable String field){
		return StudentController.sortStudents(field);
	}
	@GetMapping("/pagingStudents/{offset}/{pageSize}")
	public List<Student>pagingStudents(@PathVariable int offset,@PathVariable int pageSize)
	{
		return StudentController.pagingStudents(offset,pageSize);
	}

}
