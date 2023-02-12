package org.greatlearning.empmgmt_rest_api.utility;

import javax.transaction.Transactional;

import org.greatlearning.empmgmt_rest_api.entity.Employee;
import org.greatlearning.empmgmt_rest_api.entity.Role;
import org.greatlearning.empmgmt_rest_api.entity.User;
import org.greatlearning.empmgmt_rest_api.repo.EmployeeRepo;
import org.greatlearning.empmgmt_rest_api.repo.RoleRepo;
import org.greatlearning.empmgmt_rest_api.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BootstrapAppData {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private RoleRepo roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public BootstrapAppData(EmployeeRepo employeeRepo, UserRepo userRepository, PasswordEncoder passwordEncoder) {
		this.employeeRepo = employeeRepo;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	//Dummy employees
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void usersData(ApplicationReadyEvent readyEvent) {

		Employee najeed = new Employee("Najeed", "Kashan", "nk@gmail.com");
		Employee ayushi = new Employee("Ayushi", "Sharma", "ayushi.das@gmail.com");
		Employee praveen = new Employee("Praveen", "Bandi", "bandi@gmail.com");
		Employee sushma = new Employee("Sushma", "Bhujel", "sushma@gmail.com");

		this.employeeRepo.save(najeed);
		this.employeeRepo.save(ayushi);
		this.employeeRepo.save(praveen);
		this.employeeRepo.save(sushma);
	}

	//Dummy users
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void insertAllData(ApplicationReadyEvent event) {
		User najeed = new User("najeed", passwordEncoder.encode("froggy"));
		User ayushi = new User("ayushi", passwordEncoder.encode("bully"));


		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");

		roleRepository.saveAndFlush(userRole);
		roleRepository.saveAndFlush(adminRole);

		najeed.addRole(adminRole);
		ayushi.addRole(userRole);

		userRepository.saveAndFlush(najeed);
		userRepository.saveAndFlush(ayushi);

	}

}
