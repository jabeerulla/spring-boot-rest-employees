package com.employees.response;

import static com.employees.constants.RestConstants.AT_URI;
import static com.employees.constants.RestConstants.ITEMS;
import static com.employees.constants.RestConstants.PAGING;

import java.util.List;

import com.employees.response.common.GenericMultiResponse;
import com.employees.response.common.PagingInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDetailsBaseMultiResponse extends GenericMultiResponse<EmployeeDetailsResponse> {

	@JsonCreator
	public EmployeeDetailsBaseMultiResponse(@JsonProperty(AT_URI) String uri, @JsonProperty(PAGING) PagingInfo pageInfo,
			@JsonProperty(ITEMS) List<EmployeeDetailsResponse> items) {
		super(uri, pageInfo, items);
	}

	@JsonProperty(ITEMS)
	@Override
	public List<EmployeeDetailsResponse> getItems() {
		return items;
	}

	public static EmployeeDetailsBaseMultiResponseBuilder builder() {
		return new EmployeeDetailsBaseMultiResponseBuilder();
	}

	public static final class EmployeeDetailsBaseMultiResponseBuilder {
		protected PagingInfo pageInfo;
		protected List<EmployeeDetailsResponse> items;
		protected String uri;
		protected String type = "Collection";

		private EmployeeDetailsBaseMultiResponseBuilder() {
		}

		public EmployeeDetailsBaseMultiResponseBuilder withPageInfo(PagingInfo pageInfo) {
			this.pageInfo = pageInfo;
			return this;
		}

		public EmployeeDetailsBaseMultiResponseBuilder withItems(List<EmployeeDetailsResponse> items) {
			this.items = items;
			return this;
		}

		public EmployeeDetailsBaseMultiResponseBuilder withUri(String uri) {
			this.uri = uri;
			return this;
		}

		public EmployeeDetailsBaseMultiResponse build() {
			EmployeeDetailsBaseMultiResponse employeeDetailsBaseMultiResponse = new EmployeeDetailsBaseMultiResponse(uri, pageInfo,
					null);
			employeeDetailsBaseMultiResponse.items = this.items;
			employeeDetailsBaseMultiResponse.type = this.type;
			return employeeDetailsBaseMultiResponse;
		}
	}
}
