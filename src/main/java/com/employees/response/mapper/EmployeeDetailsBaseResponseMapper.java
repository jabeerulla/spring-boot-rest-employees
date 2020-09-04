package com.employees.response.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.employees.model.EmployeeDetails;
import com.employees.response.EmployeeDetailsResponse;

@Service
public class EmployeeDetailsBaseResponseMapper implements Function<EmployeeDetails, EmployeeDetailsResponse> {
	@Override
	public EmployeeDetailsResponse apply(EmployeeDetails employeeDetails) {
		return EmployeeDetailsResponse.builder()
				.withId(employeeDetails.getId())
				.withName(employeeDetails.getName())
				.withStatus(employeeDetails.getStatus())
				.build();
	}
}
