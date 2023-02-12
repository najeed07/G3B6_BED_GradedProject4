package org.greatlearning.empmgmt_rest_api.security;

import java.util.Optional;

import org.greatlearning.empmgmt_rest_api.entity.User;
import org.greatlearning.empmgmt_rest_api.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DomainUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo userRepository;

	public DomainUserDetailsService(UserRepo userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> optionalUser = userRepository.findUserByUsername(username);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			return new DomainUserDetails(user);
		} else {
			throw new UsernameNotFoundException("Invalid Username: " + username);
		}

	}

}
