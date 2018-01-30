package opst.we.util;

/**
 * 排序
 * @author Administrator
 */
public class Sort {

	/**
	 * 排序字段
	 */
	private String sort;

	/**
	 * 排序规则
	 */
	private String order;
	

	public Sort() {
		this.sort = "ID";
		this.order = "DESC";
	}


	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}




	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}



	/**
	 * 获得排序规则
	 * @param sortFiled sortFiled
	 * @param sort sort
	 * @return Sort
	 */
	public static Sort getSort(String sort, String order){
		Sort sort2 = new Sort();
		sort2.setSort(sort);
		sort2.setOrder(order);
		if(StringUtils.isEmpty(sort)){
			sort2.setSort("ID");
		}
		if(StringUtils.isEmpty(order)){
			sort2.setSort("DESC");
		}
		return sort2;
	}
	
	/**
	 * 获得排序SQL
	 * @return SQL
	 */
	public String getSortSql(){
		return " order by " + this.sort +" "+ this.order;
	}
}
