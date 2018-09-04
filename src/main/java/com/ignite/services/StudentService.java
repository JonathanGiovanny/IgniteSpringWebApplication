package com.ignite.services;

import java.util.Iterator;

import com.ignite.model.Student;

public interface StudentService {

	public Iterator<Student> getAll();
}
