package org.greatlearning.empmgmt_rest_api.repo;

import org.greatlearning.empmgmt_rest_api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
