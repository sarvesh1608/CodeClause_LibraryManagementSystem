package com.librarymanagement.library.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagement.library.entity.Book;
import com.librarymanagement.library.exception.NotFoundException;
import com.librarymanagement.library.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book getBook(Integer id) {
		return bookRepository.findById(id).get();
	}
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Integer id) {
		
		Book book = null;
		try {
			book = bookRepository.findById(id)
					.orElseThrow(new Supplier<Throwable>() {
						public Throwable get() {
							return new NotFoundException(String.format("Book not found"));
						}
					});
			
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		bookRepository.deleteById(book.getBookId());
	}
	
	public Book updateBookDetails(Book book) {
		return bookRepository.save(book);
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
}
