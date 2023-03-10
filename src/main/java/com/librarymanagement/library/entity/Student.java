package com.librarymanagement.library.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	private Integer studId;
	
	private String name;
	
	private String dept;
	
	private String year;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer studentId, String name, String dept, String year) {
		super();
		this.studId = studentId;
		this.name = name;
		this.dept = dept;
		this.year = year;
	}

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studentId) {
		this.studId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studId + ", name=" + name + ", dept=" + dept + ", year=" + year + "]";
	}

	
	
}
