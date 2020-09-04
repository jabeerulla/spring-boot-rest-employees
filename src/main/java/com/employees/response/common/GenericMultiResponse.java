package com.employees.response.common;

import static com.employees.constants.RestConstants.AT_TYPE;
import static com.employees.constants.RestConstants.AT_URI;
import static com.employees.constants.RestConstants.ITEMS;
import static com.employees.constants.RestConstants.PAGING;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@uri", "type", "paging", "items" })
public class GenericMultiResponse<T> {
	public static final String COLLECTION = "Collection";

	protected PagingInfo pageInfo;
	protected List<T> items;
	protected String uri;
	protected String type = COLLECTION;

	public GenericMultiResponse(String uri, PagingInfo pageInfo, List<T> items) {
		this.pageInfo = pageInfo;
		this.items = items;
		this.uri = uri;
	}

	@JsonProperty(AT_URI)
	public String getUri() {
		return uri;
	}

	@JsonProperty(AT_TYPE)
	public String getType() {
		return type;
	}

	@JsonProperty(PAGING)
	public PagingInfo getPageInfo() {
		return pageInfo;
	}

	@JsonProperty(ITEMS)
	public List<T> getItems() {
		return items;
	}
}
