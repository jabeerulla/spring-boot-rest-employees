package com.employees.dao;

import java.util.List;

import com.employees.model.EmployeeDetails;

public interface EmployeeDao {
	List<EmployeeDetails> getAll();

	EmployeeDetails create(EmployeeDetails request);

	EmployeeDetails update(EmployeeDetails request);

	boolean delete(EmployeeDetails request);
}
