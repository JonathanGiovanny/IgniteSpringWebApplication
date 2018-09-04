package com.ignite.services;

import java.util.List;

import com.ignite.model.Student;

public interface StudentService {

	public List<Student> getAll();
	public Student getOne(Long id);
}
