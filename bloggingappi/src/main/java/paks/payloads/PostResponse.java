package paks.payloads;

import java.util.List;

public class PostResponse {

	private List<PostDto> content;
	private int PageNumber;
	private int PageSize;
	private long totalElements;
	private int totalPage;
	private boolean lastPage;
	
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostResponse(List<PostDto> content, int pageNumber, int pageSize, long totalElements, int totalPage,
			boolean lastPage) {
		super();
		this.content = content;
		this.PageNumber = pageNumber;
		this.PageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPage = totalPage;
		this.lastPage = lastPage;
	}

	public List<PostDto> getContent() {
		return content;
	}

	public void setContent(List<PostDto> content) {
		this.content = content;
	}

	public int getPageNumber() {
		return PageNumber;
	}

	public void setPageNumber(int pageNumber) {
		PageNumber = pageNumber;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
 
	
	
	
}
