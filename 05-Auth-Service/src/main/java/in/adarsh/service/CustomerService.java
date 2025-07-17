package in.adarsh.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.adarsh.Entity.CustomerEntity;
import in.adarsh.repo.CustomerRepo;

@Service
public class CustomerService implements UserDetailsService {

	@Autowired
	private CustomerRepo custRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		CustomerEntity custEntity = custRepo.findByEmail(email);
		return new User(custEntity.getEmail(), custEntity.getPassword(), Collections.emptyList());
	}

}
