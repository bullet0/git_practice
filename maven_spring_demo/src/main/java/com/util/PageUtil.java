package com.util;

import java.util.List;

public class PageUtil {
	private int curPage;
	private int pageSize=10;
	private int totalPage;
	private int totalCount;
	private String condition;
	private List list;
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void countTotalPage() {
		if(totalCount%pageSize == 0){
			this.totalPage = totalCount/pageSize;
		}else{
			this.totalPage = totalCount/pageSize + 1;
		}
		
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}	
