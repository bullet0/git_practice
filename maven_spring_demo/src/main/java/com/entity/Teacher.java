package com.entity;

import java.sql.Date;

public class Teacher {
	
	//t_id 
	private Integer tId;
	//t_name 
	private String tName;
	//t_salary 
	private Double tSalary;
	//t_idcard 
	private String tIdcard;
	//t_age 
	private Integer tAge;
	//t_sex 
	private Dictionary tSex;
	//t_head_img 
	private String tHeadImg;
	//t_startdate 
	private Date tStartdate;
	//t_enddate 
	private Date tEnddate;
	//t_state 
	private Dictionary tState;
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	//hibernate必须对应，所以这两个方法也不能删
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	//struts是去调用setPId和getPId的方法,所以提供一下两个方法
	//可以解决报错Class ognl.OgnlRuntime can not access a member of class com.entity.Teacher was "private"
	public Integer getTId() {
		return tId;
	}
	public void setTId(Integer tId) {
		this.tId = tId;
	}
	
	
	
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public Double gettSalary() {
		return tSalary;
	}
	public void settSalary(Double tSalary) {
		this.tSalary = tSalary;
	}
	public String gettIdcard() {
		return tIdcard;
	}
	public void settIdcard(String tIdcard) {
		this.tIdcard = tIdcard;
	}
	public Integer gettAge() {
		return tAge;
	}
	public void settAge(Integer tAge) {
		this.tAge = tAge;
	}
	public Dictionary gettSex() {
		return tSex;
	}
	public void settSex(Dictionary tSex) {
		this.tSex = tSex;
	}
	public String gettHeadImg() {
		return tHeadImg;
	}
	public void settHeadImg(String tHeadImg) {
		this.tHeadImg = tHeadImg;
	}
	public Date gettStartdate() {
		return tStartdate;
	}
	public void settStartdate(Date tStartdate) {
		this.tStartdate = tStartdate;
	}
	public Date gettEnddate() {
		return tEnddate;
	}
	public void settEnddate(Date tEnddate) {
		this.tEnddate = tEnddate;
	}
	public Dictionary gettState() {
		return tState;
	}
	public void settState(Dictionary tState) {
		this.tState = tState;
	}
	
	//修改后的setter  &  getter
	public String getTName() {
		return tName;
	}
	public void setTName(String tName) {
		this.tName = tName;
	}
	public Double getTSalary() {
		return tSalary;
	}
	public void setTSalary(Double tSalary) {
		this.tSalary = tSalary;
	}
	public String getTIdcard() {
		return tIdcard;
	}
	public void setTIdcard(String tIdcard) {
		this.tIdcard = tIdcard;
	}
	public Integer getTAge() {
		return tAge;
	}
	public void setTAge(Integer tAge) {
		this.tAge = tAge;
	}
	public Dictionary getTSex() {
		return tSex;
	}
	public void setTSex(Dictionary tSex) {
		this.tSex = tSex;
	}
	public String getTHeadImg() {
		return tHeadImg;
	}
	public void setTHeadImg(String tHeadImg) {
		this.tHeadImg = tHeadImg;
	}
	public Date getTStartdate() {
		return tStartdate;
	}
	public void setTStartdate(Date tStartdate) {
		this.tStartdate = tStartdate;
	}
	public Date getTEnddate() {
		return tEnddate;
	}
	public void setTEnddate(Date tEnddate) {
		this.tEnddate = tEnddate;
	}
	public Dictionary getTState() {
		return tState;
	}
	public void setTState(Dictionary tState) {
		this.tState = tState;
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", tName=" + tName + ", tSalary=" + tSalary + ", tIdcard=" + tIdcard + ", tAge="
				+ tAge + ", tSex=" + tSex + ", tHeadImg=" + tHeadImg + ", tStartdate=" + tStartdate + ", tEnddate="
				+ tEnddate + ", tState=" + tState + "]";
	}
	
	
	
	
}
