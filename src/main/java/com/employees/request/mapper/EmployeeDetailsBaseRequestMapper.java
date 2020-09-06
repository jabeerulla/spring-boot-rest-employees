package com.employees.request.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.employees.model.EmployeeDetails;
import com.employees.request.EmployeeDetailsRequest;

@Service
public class EmployeeDetailsBaseRequestMapper implements Function<EmployeeDetailsRequest , EmployeeDetails> {
	@Override
	public EmployeeDetails apply(EmployeeDetailsRequest employeeDetailsRequest) {
		return EmployeeDetails.builder()
				.withId(employeeDetailsRequest.getId())
				.withName(employeeDetailsRequest.getName())
				.withStatus(employeeDetailsRequest.getStatus())
				.build();
	}
}
