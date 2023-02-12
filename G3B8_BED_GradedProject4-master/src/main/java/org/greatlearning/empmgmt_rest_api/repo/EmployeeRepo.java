package org.greatlearning.empmgmt_rest_api.repo;

import java.util.List;

import org.greatlearning.empmgmt_rest_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	List<Employee> findByFirstName(String firstName);
}
