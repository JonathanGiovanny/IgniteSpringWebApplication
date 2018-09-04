package com.ignite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignite.model.Student;
import com.ignite.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/getAll")
	public List<Student> getAll() {
		return studentService.getAll();
	}

	@GetMapping("/getOne/{id}")
	public Student getOne(@PathVariable Long id) {
		return studentService.getOne(id);
	}
}
