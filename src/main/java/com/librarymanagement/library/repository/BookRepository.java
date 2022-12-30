package com.librarymanagement.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarymanagement.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
