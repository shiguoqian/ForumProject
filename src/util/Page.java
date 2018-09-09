package util;
/**
 * 分页 功能
 * @author wanp
 */

public class Page {
	
	private int totalCount; // 数据总数
	private int pageSize=10; // 页面大小
	private int currentPage; // 当前页
	private int pageCount; // 总页数.(没有set方法)

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Page(int pageSize, int currentPage) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		if (totalCount % pageSize == 0) {
			return pageCount = totalCount / pageSize;
		} else {
			return pageCount = totalCount / pageSize + 1;
		}

	}

}
