package com.spring.crud.services;

import java.util.List;

import com.spring.crud.entity.Student;

public interface StudentService {
	Student getById(Long id) ;
	List<Student> getAll();
	Student save(Student s);
	Student update(Long id, Student news);
	Boolean delete(Long id);
}
