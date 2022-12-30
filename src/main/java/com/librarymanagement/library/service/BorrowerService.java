package com.librarymanagement.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagement.library.entity.Borrower;
import com.librarymanagement.library.exception.NotFoundException;
import com.librarymanagement.library.repository.BorrowerRepository;
import java.util.function.Supplier;

import javax.naming.NameNotFoundException;

@Service
public class BorrowerService {
	
	@Autowired
	BorrowerRepository borrowerRepository;
	
	public Borrower saveBorrower(Borrower borrower) {
		return borrowerRepository.save(borrower);
	}
	
	public List<Borrower> getAllBorrower() {
		return borrowerRepository.findAll();
	}
	
	public Borrower getBorrowerById(Integer id) {
		return borrowerRepository.findById(id).get();
	}
	
	public void deleteBorrower(Integer id) throws Throwable {
		
		Borrower borrower = null;
		
		try {
			borrower = borrowerRepository.findById(id).orElseThrow(new Supplier<Throwable>() {
				public Throwable get() {
					return new NotFoundException(String.format("Borrower not found"));
				}
			});
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		borrowerRepository.deleteById(borrower.getBorrowerId());
	}
	
	public Borrower updateBorrower(Borrower borrower) {
		return borrowerRepository.save(borrower);
	}
}
