package com.employees.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.employees.dao.EmployeeDao;
import com.employees.model.EmployeeDetails;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static List<EmployeeDetails> serviceData = new ArrayList<>();
	private static List<String> status = new ArrayList<String>() {
		{
			add("Active");
			add("Inactive");
		}
	};
	static {

		IntStream.range(1, 51)
				.forEach(i -> serviceData.add(new EmployeeDetails(i, "Employee " + i, status.get(i % 2))));

	}

	@Override
	public List<EmployeeDetails> getAll() {
		return serviceData;
	}

}
