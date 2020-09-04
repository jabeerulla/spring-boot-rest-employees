package com.employees.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ PagingInfo.TOTAL_NUM_ITEMS, PagingInfo.LIMIT, PagingInfo.OFFSET, PagingInfo.NUM_ITEMS,
		PagingInfo.HAS_MORE_ITEMS, PagingInfo.PREV_PAGE_URI, PagingInfo.NEXT_PAGE_URI })
public class PagingInfo {

	protected static final String NEXT_PAGE_URI = "next_page_uri";
	protected static final String PREV_PAGE_URI = "prev_page_uri";
	protected static final String HAS_MORE_ITEMS = "has_more_items";
	protected static final String NUM_ITEMS = "num_items";
	protected static final String LIMIT = "limit";
	protected static final String OFFSET = "offset";
	protected static final String TOTAL_NUM_ITEMS = "total_num_items";

	@JsonProperty(TOTAL_NUM_ITEMS)
	private int total;

	@JsonProperty(OFFSET)
	private int offset;

	@JsonProperty(LIMIT)
	private int limit;

	@JsonProperty(NUM_ITEMS)
	private int numItems;

	@JsonProperty(HAS_MORE_ITEMS)
	private boolean hasMoreItems;

	@JsonProperty(PREV_PAGE_URI)
	private String prevPageUri;

	@JsonProperty(NEXT_PAGE_URI)
	private String nextPageUri;

	@JsonProperty("sort_by")
	private String sortBy;

	@JsonProperty("sort_order")
	private String sortOrder;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	public boolean isHasMoreItems() {
		return hasMoreItems;
	}

	public void setHasMoreItems(boolean hasMoreItems) {
		this.hasMoreItems = hasMoreItems;
	}

	public String getPrevPageUri() {
		return prevPageUri;
	}

	public void setPrevPageUri(String prevPageUri) {
		this.prevPageUri = prevPageUri;
	}

	public String getNextPageUri() {
		return nextPageUri;
	}

	public void setNextPageUri(String nextPageUri) {
		this.nextPageUri = nextPageUri;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

}