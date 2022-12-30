package com.librarymanagement.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarymanagement.library.entity.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer>{

}
