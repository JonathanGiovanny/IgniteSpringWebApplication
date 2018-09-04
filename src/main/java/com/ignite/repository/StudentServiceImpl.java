package com.ignite.repository;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignite.model.Student;
import com.ignite.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public Iterator<Student> getAll() {
		return studentRepo.findAll().iterator();
	}
}
