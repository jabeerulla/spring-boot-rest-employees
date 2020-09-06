package com.employees.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.employees.dao.EmployeeDao;
import com.employees.model.EmployeeDetails;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static AtomicInteger ID_COUNTER = new AtomicInteger(51);
	private static List<EmployeeDetails> serviceData = new ArrayList<>();
	private static List<String> status = Arrays.asList("Active", "Inactive");

	static {
		IntStream.range(1, 51).forEach(i -> serviceData.add(
				EmployeeDetails.builder()
				.withId(i).withName("Employee " + i)
				.withStatus(status.get(i % 2))
				.build()));
	}

	@Override
	public List<EmployeeDetails> getAll() {
		return serviceData;
	}

	@Override
	public EmployeeDetails create(EmployeeDetails request) {
		request.setId(ID_COUNTER.getAndIncrement());
		serviceData.add(request);
		return request;
	}

	@Override
	public EmployeeDetails update(EmployeeDetails request) {
		return null;
	}

	@Override
	public boolean delete(EmployeeDetails request) {
		return serviceData.remove(request);
	}

}
