package com.librarymanagement.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarymanagement.library.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
