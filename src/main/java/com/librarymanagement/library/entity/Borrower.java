package com.librarymanagement.library.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "borrower")
public class Borrower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	private Integer borrowerId;
	
	@OneToOne
	@JoinColumn(name = "studId", referencedColumnName = "studId")
	private Student student;

	private String dept;
	
	@OneToOne
	@JoinColumn(name = "IssuedBy", referencedColumnName = "StaffId")
	private Staff issuedBy;
	
	private Date issuedDate;
	
	private Date returnDate;
	
	@OneToOne
	@JoinColumn(name = "BookId", referencedColumnName = "BookId")
	private Book book;
	
	@Transient
	private List<Book> books;
	
	@Transient
	private List<Student> students;
	
	@Transient
	private List<Staff> staffs;

	@Transient
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Transient
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Transient
	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public Integer getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(Integer borrowerId) {
		this.borrowerId = borrowerId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Staff getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(Staff issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Borrower [borrowerId=" + borrowerId + ", student=" + student + ", dept=" + dept + ", issuedBy="
				+ issuedBy + ", issuedDate=" + issuedDate + ", returnDate=" + returnDate + ", book=" + book + "]";
	}

}
	
