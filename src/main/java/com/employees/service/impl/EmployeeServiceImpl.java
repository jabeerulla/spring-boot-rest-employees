package com.employees.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employees.dao.EmployeeDao;
import com.employees.exception.NotFoundException;
import com.employees.model.EmployeeDetails;
import com.employees.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<EmployeeDetails> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public EmployeeDetails getSingle(int id) {
		Optional<EmployeeDetails> employee = employeeDao.getAll().stream()
				.filter(a -> a.getId() == id)
				.findFirst();
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new NotFoundException("Employee with id not found : " + id);
	}

}
