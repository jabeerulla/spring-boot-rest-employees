package com.employees.request;

import static com.employees.constants.RestConstants.ID;
import static com.employees.constants.RestConstants.NAME;
import static com.employees.constants.RestConstants.STATUS;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ ID, NAME, STATUS })
public class EmployeeDetailsRequest {

	private int id;
	private String name;
	private String status;

	@JsonCreator
	public EmployeeDetailsRequest(@JsonProperty(ID) int id, @JsonProperty(NAME) String name,
			@JsonProperty(STATUS) String status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("name", name)
				.add("status", status)
				.toString();
	}

	public static EmployeeDetailsResponseBuilder builder() {
		return new EmployeeDetailsResponseBuilder();
	}

	public static final class EmployeeDetailsResponseBuilder {
		protected int id;
		protected String name;
		protected String status;

		private EmployeeDetailsResponseBuilder() {
		}

		public EmployeeDetailsResponseBuilder withId(int id) {
			this.id = id;
			return this;
		}

		public EmployeeDetailsResponseBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public EmployeeDetailsResponseBuilder withStatus(String status) {
			this.status = status;
			return this;
		}

		public EmployeeDetailsRequest build() {
			EmployeeDetailsRequest employeeDetailsResponse = new EmployeeDetailsRequest(id, name, status);
			return employeeDetailsResponse;
		}
	}

}
