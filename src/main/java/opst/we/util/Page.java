package opst.we.util;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7952526807832924934L;

	/**
	 * 当前页数
	 */
	private int page;
	/**
	 *总页数 
	 */
	private int pageCount;
	/**
	 * 数据库总记录数
	 */
	private long total;

	/**
	 * 每页显示记录数
	 */
	private int pageSize;
	
	@SuppressWarnings("rawtypes")
	private List rows;
	
	public Page() {
		super();
	}
	
	/**
	 * @param 当前页数,数据库总记录数, 每页显示记录数
	 */
	public Page(String page, int total, int pageSize) {
		super();
		this.total = total;
		this.pageSize = pageSize;
		this.pageCount = (int)((this.total + this.pageSize - 1) / this.pageSize);
		
		if(page == null){
			this.page = 1;
		}else{
			try {
				this.page = Integer.parseInt(page);
				if(this.page < 1){
					this.page = pageCount;
				}
				else if(this.page > pageCount){
					this.page = 1;
				}
			} catch (Exception e) {
				this.page = 1;
			}
		}
	}
	
	/**
	 * @param 
	 */
	public Page(String page, int pageSize) {
		this.pageSize = pageSize;
		if(page == null){
			this.page = 1;
		}else{
			try {
				this.page = Integer.parseInt(page);
			} catch (Exception e) {
				this.page = 1;
			}
		}
	}
	
	public static Page getPage(String page, String rows) {
		return getPage(page, rows, 10);
	}
	
	public static Page getPage(String page, String rows, int defrows) {
		int pagesize = 0;
		try {
			pagesize = Integer.parseInt(rows);;
		} catch (Exception e) {
			pagesize = defrows;
		}
		return new Page(page,pagesize);
	}
	
	/**
	 *当前页
	 */
	public int getPage() {
		return page;
	}
	/**
	 *当前页
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 *总页数 
	 */
	public int getPageCount() {
		return pageCount;
	}
	/**
	 *总页数 
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * 每页显示记录数
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * 每页显示记录数
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	
	public void setTotal(long total) {
		this.total = total;
		this.pageCount = (int)((this.total + this.pageSize - 1) / this.pageSize);
		if(this.pageCount < 1){
			this.pageCount = 1;
		}
		if(this.page < 1){
			this.page = 1;
		}
		else if(this.page > pageCount){
			this.page = pageCount;
		}
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getRows() {
		return rows;
	}

	@SuppressWarnings("rawtypes")
	public Page setRows(List rows) {
		this.rows = rows;
		return this;
	}
}
