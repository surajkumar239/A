package com.becoder.confiq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.becoder.entity.Employee;
import com.becoder.repository.EmployeeRepository;

@Component
public class CustomUserDetails implements UserDetailsService {
    @Autowired
	private EmployeeRepository empRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = empRepo.findByname(username);
		if (employee==null) {
			 throw new UsernameNotFoundException("user not found"); 
		}
		return new CustomUser(employee);
	
	}

}
