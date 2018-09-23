package javaBean;

public class Page{
	private String tableName;
	private Integer page;
	private Integer pageSize;
	private Integer totalPageCount;
	private Integer totalRecordCount;
	private String condition;//
	private String orderField;//排序字段
	private String order;//升序还是降序
	private String searchSql;
	private Boolean result;


	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public Integer getPage() {
		return page;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalPageCount() {
		return totalPageCount;
	}
	
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	public Integer getTotalRecordCount() {
		return totalRecordCount;
	}
	
	public void setTotalRecordCount(Integer totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getOrderField() {
		return orderField;
	}
	
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	
	public String getOrder() {
		return order;
	}
	
	public void setOrder(String order) {
		this.order = order;
	}
	
	public String getSearchSql() {
		return searchSql;
	}
	
	public void setSearchSql(String searchSql) {
		this.searchSql = searchSql;
	}
	
	public Boolean getResult() {
		return result;
	}
	
	public void setResult(Boolean result) {
		this.result = result;
	}
}
