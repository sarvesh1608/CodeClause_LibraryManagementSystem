package com.librarymanagement.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.librarymanagement.library.entity.Staff;
import com.librarymanagement.library.repository.StaffRepository;

@Service
public class LoginService {
	@Autowired
	StaffRepository staffRepository;
	
	public boolean checkCredentials(Staff staff) {
		
		try {
			String userName = staff.getUserName();
			String password = staff.getPassword();
//			Staff value = findByUserName(staff).get();
//			
//			String dbValue = value.getUserName();
			boolean flag = false;
			
			String dbUserName = staffRepository.findByUserName(userName).getUserName();
			String dbPassword = staffRepository.findByUserName(userName).getPassword();
			
			if(userName.equals(dbUserName) && password.equals(dbPassword)) {
				return true;
			}
			else {
				return false;
			}
//			

		}catch(NullPointerException npe) {
			npe.printStackTrace();
			return false;
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
		
	
}
