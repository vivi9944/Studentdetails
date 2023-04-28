package com.pro2.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pro2.demo.model.Student;
import com.pro2.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentservice;
	
	public List<Student> getAllStudents()
	{
		List<Student>studentList=studentservice.findAll();
		return studentList;
	}
	
	public Student saveStudent(Student s) {
		return studentservice.save(s);
	}
	
	public void deleteStudent(int s) {
		studentservice.deleteById(s);
	}
	public List<Student>sortStudents(String field){
		return studentservice.findAll(Sort.by(Direction.DESC,field));
	}
	public  Student updateStudent(Student s,int regno) {
		Optional<Student> optional=studentservice.findById(regno);
		Student obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			obj.setRegno(s.getRegno());
			obj.setName(s.getName());
			obj.setDepartment(s.getDepartment());
			obj.setEmail(s.getEmail());
		studentservice.saveAndFlush(s);
		}
		return obj;
	}
	
	public List<Student>pagingStudents(int offset,int pageSize){
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<Student>studentData=studentservice.findAll(paging);
		List<Student>studentList=studentData.getContent();
		return studentList;
	}
}
