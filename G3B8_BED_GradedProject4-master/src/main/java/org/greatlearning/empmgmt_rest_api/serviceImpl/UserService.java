package org.greatlearning.empmgmt_rest_api.serviceImpl;

import org.greatlearning.empmgmt_rest_api.entity.User;
import org.greatlearning.empmgmt_rest_api.repo.UserRepo;
import org.greatlearning.empmgmt_rest_api.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepo userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.saveAndFlush(user);
	}

}
