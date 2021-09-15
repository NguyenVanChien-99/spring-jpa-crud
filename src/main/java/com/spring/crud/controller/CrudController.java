package com.spring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.entity.Student;
import com.spring.crud.services.StudentService;

@RestController
public class CrudController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public ResponseEntity<Object> getAll(){
		return new ResponseEntity<Object>(service.getAll(),HttpStatus.OK);
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id){
		Student s = service.getById(id);
		return s==null?new ResponseEntity<Object>("Student not found", HttpStatus.NOT_FOUND): new ResponseEntity<Object>(s,HttpStatus.OK);
	}
	@PostMapping("/student")
	public ResponseEntity<Object> create(@RequestBody Student s){
		Student saved = service.save(s);
		return saved==null?new ResponseEntity<Object>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR):new ResponseEntity<Object>(saved,HttpStatus.OK);
	}
	@PutMapping("/student/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id,@RequestBody Student news){
		Student s = service.getById(id);
		if(s==null) {
			return new ResponseEntity<Object>("Student not found", HttpStatus.NOT_FOUND);
		}
		Student saved = service.update(id, news);
		return saved==null?new ResponseEntity<Object>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR):new ResponseEntity<Object>(saved,HttpStatus.OK);
	}
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		Boolean rs = service.delete(id);
		return rs?new ResponseEntity<Object>("Deleted",HttpStatus.OK):new ResponseEntity<Object>("Student not found",HttpStatus.NOT_FOUND);
	}
}
