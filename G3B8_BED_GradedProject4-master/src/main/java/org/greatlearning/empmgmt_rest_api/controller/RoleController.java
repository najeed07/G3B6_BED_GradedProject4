package org.greatlearning.empmgmt_rest_api.controller;

import org.greatlearning.empmgmt_rest_api.entity.Role;
import org.greatlearning.empmgmt_rest_api.repo.RoleRepo;
import org.greatlearning.empmgmt_rest_api.service.RoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleServiceInterface roleService;

	// 8. Add Role
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}

}
