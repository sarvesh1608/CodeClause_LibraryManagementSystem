package com.librarymanagement.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagement.library.entity.Staff;
import com.librarymanagement.library.repository.StaffRepository;

@Service
public class RegistrationService {
	
	@Autowired
	StaffRepository staffRepository;
	
	public Staff saveStaffDetails(Staff staff) {
		return staffRepository.save(staff);
	}
	
}
