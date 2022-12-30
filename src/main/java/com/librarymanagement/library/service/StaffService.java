package com.librarymanagement.library.service;

import java.util.List;
import java.util.function.Supplier;

import javax.naming.NameAlreadyBoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagement.library.entity.Staff;
import com.librarymanagement.library.exception.NotFoundException;
import com.librarymanagement.library.repository.StaffRepository;

@Service
public class StaffService {
	
	@Autowired
	StaffRepository staffRepository;
//	
//	public Staff saveStaff(Staff staff) {
//		return staffRepository.save(staff);
//	}
	
//	public Staff updateStaffDetails(Staff staff) {
//		return staffRepository.save(staff);
//	}
//	
	public List<Staff> getAllStaff(){
		return staffRepository.findAll();
	}
//	
//	public Staff getStaffById(Integer id) {
//		return staffRepository.findById(id).get();
//	}
//
	public void deleteStaff(Integer id) {
		
		Staff staff = null;
		try {
			staff = staffRepository.findById(id).orElseThrow
					(new Supplier<Throwable>() {
				public Throwable get() {
					return new NotFoundException(String.format("Staff not found"));
				}
			});
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		staffRepository.deleteById(staff.getStaffId());
	}
}
