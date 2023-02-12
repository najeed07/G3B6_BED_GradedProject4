package org.greatlearning.empmgmt_rest_api.serviceImpl;

import org.greatlearning.empmgmt_rest_api.entity.Role;
import org.greatlearning.empmgmt_rest_api.repo.RoleRepo;
import org.greatlearning.empmgmt_rest_api.service.RoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RoleServiceInterface {

	@Autowired
	private RoleRepo roleRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

}
