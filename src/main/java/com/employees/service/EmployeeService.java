package com.employees.service;

import java.util.List;

import com.employees.model.EmployeeDetails;

public interface EmployeeService {
	List<EmployeeDetails> getAll();

	EmployeeDetails getSingle(int id);

	EmployeeDetails create(EmployeeDetails request);

	EmployeeDetails update(int id, EmployeeDetails request);

	EmployeeDetails delete(int id);

}
