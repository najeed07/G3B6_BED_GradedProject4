package org.greatlearning.empmgmt_rest_api.repo;

import java.util.Optional;

import org.greatlearning.empmgmt_rest_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	@Query(nativeQuery = true, value = "SELECT * FROM USERS WHERE USERNAME LIKE %?1%")
	Optional<User> findUserByUsername(String userName);
}
