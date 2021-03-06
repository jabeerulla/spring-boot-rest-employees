package com.employees.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employees.constants.RestConstants;
import com.employees.model.EmployeeDetails;
import com.employees.request.EmployeeDetailsRequest;
import com.employees.request.mapper.EmployeeDetailsBaseRequestMapper;
import com.employees.response.EmployeeDetailsBaseMultiResponse;
import com.employees.response.EmployeeDetailsResponse;
import com.employees.response.common.PagingInfo;
import com.employees.response.mapper.EmployeeDetailsBaseResponseMapper;
import com.employees.service.EmployeeService;

@RestController
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	private static final String loadBalancerAddress = "http://localhost:8083";
	private EmployeeDetailsBaseResponseMapper employeeDetailsBaseResponseMapper = new EmployeeDetailsBaseResponseMapper();

	@Autowired
	private EmployeeService pservice;

	@RequestMapping(value = RestConstants.GET_ALL_EMPLOYEES, method = RequestMethod.GET)
	public @ResponseBody EmployeeDetailsBaseMultiResponse getAll(
			@RequestParam(name = "name", required = false, defaultValue = "") String name,
			@RequestParam(name = "status", required = false, defaultValue = "") String status,
			@RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit,
			@RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset) throws Exception {
		LOGGER.info("***** getAll");

		List<EmployeeDetails> allEmployeeDetailsList = pservice.getAll();
		List<EmployeeDetails> employeeDetailsList = allEmployeeDetailsList.stream()
				.filter(e -> StringUtils.isEmpty(name) || e.getName().contains(name))
				.filter(e -> StringUtils.isEmpty(name) || status.equalsIgnoreCase(e.getStatus()))
				.skip(offset)
				.limit(limit)
				.collect(Collectors.toList());

		URIBuilder uriBuilder = new URIBuilder(loadBalancerAddress + RestConstants.GET_ALL_EMPLOYEES)
				.addParameter(RestConstants.PARAM_LIMIT, String.valueOf(limit))
				.addParameter(RestConstants.PARAM_OFFSET, String.valueOf(offset));

		PagingInfo pagingInfo = new PagingInfo();
		pagingInfo.setTotal(allEmployeeDetailsList.size());
		pagingInfo.setLimit(limit);
		pagingInfo.setOffset(offset);
		pagingInfo.setNumItems(employeeDetailsList.size());
		if (employeeDetailsList.size() >= limit) {
			pagingInfo.setHasMoreItems(true);
			URI nextUri = uriBuilder.setParameter(RestConstants.PARAM_OFFSET, String.valueOf(offset + limit)).build();
			pagingInfo.setNextPageUri(nextUri.toString());
		} else {
			pagingInfo.setHasMoreItems(false);
		}

		if (offset > 0) {
			int prevOffset = (offset - limit < 0) ? 0 : (offset - limit);
			pagingInfo.setPrevPageUri(
					uriBuilder.setParameter(RestConstants.PARAM_OFFSET, String.valueOf(prevOffset)).build().toString());
		}

		String url = loadBalancerAddress + RestConstants.GET_ALL_EMPLOYEES + "?offset=" + offset + "&limit=" + limit;

		return EmployeeDetailsBaseMultiResponse.builder()
				.withPageInfo(pagingInfo)
				.withUri(url)
				.withItems(employeeDetailsList.stream()
						.map(employeeDetailsBaseResponseMapper)
						.collect(Collectors.toList()))
				.build();
	}

	@RequestMapping(value = RestConstants.GET_SINGLE_EMPLOYEE, method = RequestMethod.GET)
	public @ResponseBody EmployeeDetailsResponse getSingle(@PathVariable("id") int id) {
		LOGGER.info("getSingle by id : " + id);
		EmployeeDetails employeeDetails = pservice.getSingle(id);
		LOGGER.info(employeeDetails.toString());
		return employeeDetailsBaseResponseMapper.apply(employeeDetails);
	}

	@RequestMapping(value = RestConstants.POST_EMPLOYEE, method = RequestMethod.POST)
	public @ResponseBody EmployeeDetailsResponse create(@RequestBody final EmployeeDetailsRequest request) {
		LOGGER.info("create : " + request);
		EmployeeDetails employeeDetails = new EmployeeDetailsBaseRequestMapper().apply(request);
		return employeeDetailsBaseResponseMapper.apply(pservice.create(employeeDetails));
	}

	@RequestMapping(value = RestConstants.PUT_EMPLOYEE, method = RequestMethod.PUT)
	public @ResponseBody EmployeeDetailsResponse update(@PathVariable("id") int id,
			@RequestBody final EmployeeDetailsRequest request) {
		LOGGER.info("update : " + id);
		LOGGER.info(request.toString());
		EmployeeDetails employeeDetails = new EmployeeDetailsBaseRequestMapper().apply(request);
		return employeeDetailsBaseResponseMapper.apply(pservice.update(id, employeeDetails));
	}

	@RequestMapping(value = RestConstants.PUT_EMPLOYEE, method = RequestMethod.DELETE)
	public @ResponseBody EmployeeDetailsResponse delete(@PathVariable("id") int id) {
		LOGGER.info("delete : " + id);
		return employeeDetailsBaseResponseMapper.apply(pservice.delete((id)));
	}

}
