package com.ignite.repository;

import java.util.List;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.Query;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import com.ignite.model.Student;

@RepositoryConfig(cacheName = "StudentCache")
public interface StudentRepository extends IgniteRepository<Student, Long> {

	@Override
	public List<Student> findAll();

	@Query("SELECT id FROM Student WHERE orgId = ?")
	public Student findOne(Long id);
}
