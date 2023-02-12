package org.greatlearning.empmgmt_rest_api.service;

import java.util.List;

import org.greatlearning.empmgmt_rest_api.entity.Employee;
import org.springframework.data.domain.Sort.Direction;

public interface EmployeeService {

	Employee addEmployees(Employee employee);

	List<Employee> listAllEmployees();

	Employee getEmployeeById(Integer id);

	Object deleteEmployeeById(Integer id);

	List<Employee> getEmployeesSortedByName(Direction direction);

	List<Employee> findByFirstName(String firstName);

}