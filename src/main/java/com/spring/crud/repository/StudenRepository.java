package com.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.entity.Student;

@Repository
public interface StudenRepository extends JpaRepository<Student, Long>{

}
