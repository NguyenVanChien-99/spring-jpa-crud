package com.spring.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.entity.Student;
import com.spring.crud.repository.StudenRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudenRepository repo;
	
	@Override
	public Student getById(Long id) {
		return repo.getById(id);
	}

	@Override
	public List<Student> getAll() {
		return repo.findAll();
	}

	@Override
	public Student save(Student s) {
		return repo.save(s);
	}

	@Override
	public Student update(Long id, Student news) {
		Student old = repo.getById(id);
		if(old==null) {
			return null;
		}
		old.setName(news.getName());
		old.setAge(news.getAge());
		return repo.save(old);
	}

	@Override
	public Boolean delete(Long id) {
		Student old = repo.getById(id);
		if(old==null) {
			return false;
		}
		repo.delete(old);
		return true;
	}

}
