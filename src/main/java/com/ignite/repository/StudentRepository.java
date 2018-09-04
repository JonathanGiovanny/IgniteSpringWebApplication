package com.ignite.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ignite.model.Student;

@RepositoryConfig(cacheName = "StudentCache")
@Component
@Repository
public interface StudentRepository extends IgniteRepository<Student, Long> {

}
