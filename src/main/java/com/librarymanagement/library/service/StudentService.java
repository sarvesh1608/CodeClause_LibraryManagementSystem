package com.librarymanagement.library.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagement.library.entity.Student;
import com.librarymanagement.library.exception.NotFoundException;
import com.librarymanagement.library.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).get();
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public void deleteStudent(Integer id) {
		
		Student student = null;
		
		try {
			student = studentRepository.findById(id).
					orElseThrow(new Supplier<Throwable>() {
						public Throwable get() {
							return new NotFoundException("Student not Found");
						}
						
					});
			
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		studentRepository.deleteById(student.getStudId());
	}
}
