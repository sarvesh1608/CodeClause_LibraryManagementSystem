package com.librarymanagement.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarymanagement.library.entity.Staff;

@Repository
public interface RegstrationRepository extends JpaRepository<Staff, Integer>{

}
