package com.employees.model;

import com.google.common.base.MoreObjects;

public class EmployeeDetails {

	private int id;
	private String name;
	private String status;

	public EmployeeDetails(int id, String name, String status) {
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

	public static EmployeeDetailsBuilder builder() {
		return new EmployeeDetailsBuilder();
	}

	public static final class EmployeeDetailsBuilder {
		protected int id;
		protected String name;
		protected String status;

		private EmployeeDetailsBuilder() {
		}

		public EmployeeDetailsBuilder withId(int id) {
			this.id = id;
			return this;
		}

		public EmployeeDetailsBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public EmployeeDetailsBuilder withStatus(String status) {
			this.status = status;
			return this;
		}

		public EmployeeDetails build() {
			EmployeeDetails employeeDetails = new EmployeeDetails(id, name, status);
			return employeeDetails;
		}
	}
}
