package org.greatlearning.empmgmt_rest_api.controller;

import org.greatlearning.empmgmt_rest_api.entity.User;
import org.greatlearning.empmgmt_rest_api.repo.UserRepo;
import org.greatlearning.empmgmt_rest_api.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	// 9. Add user
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);

	}
}
