package com.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Dictionary;
import com.entity.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.interfaces.ITeacherService;
import com.util.PageUtil;
@Controller("teacherAction")
@Scope(scopeName="prototype")
public class TeacherAction extends BaseFileUpload{
	
	@Resource(name="teacherService")
	private ITeacherService service;
	
	public Teacher teacher;
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	
	
	
	private int curPage;
	private String condition;
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	
	public String queryListByPage(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(condition == null){
			if(session.get("condition") == null){
				condition = "";
			}else{
				condition = session.get("condition").toString();
			}
		}
		session.put("condition", condition);
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCondition(condition);
		if(curPage != 0){
			pageUtil.setCurPage(curPage);
		}else{
			pageUtil.setCurPage(1);
		}
		
		pageUtil = service.queryListByPage(pageUtil);
//		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext.getContext().put("pageUtil", pageUtil);
		return "show";
	}
	
	public String queryOne(){
		Teacher tea = service.queryOne(teacher.gettId());
		List<Dictionary> dictionnary = service.queryDictionnary();
		
		ActionContext.getContext().put("teacher", tea);
		ActionContext.getContext().put("dictionary", dictionnary);
		return "update";
	}
	public String update(){
		String fileName = null;
		try {
			fileName = this.upload("/myfile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fileName == null){
			fileName = service.queryOldHeadImg(teacher.gettId());
		}
		teacher.setTHeadImg(fileName);
		service.update(teacher);
		return "toShow";
	}
	public String add(){
		String fileName = null;
		try {
			fileName = this.upload("/myfile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teacher.setTHeadImg(fileName);	
		
		service.insert(teacher);
		return "toShow";
	}
	
	public String delete(){
		service.delete(teacher);
		return "toShow";
	}
//	public String test(){
//		System.out.println(tId);
//		System.out.println(teacher);
//		page = "a.jsp";
//		return "test";
//	}
	//struts2，需要把要返回的变量设为全局变量，并且提供setget方法
	boolean flag;
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String queryName(){
		flag = service.queryName(teacher.gettName());
		System.out.println(flag);
		return "checkName";
	}
	
	private InputStream excelStream;
	private String excelName;
	
	
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	public String getExcelName() {
		return excelName;
	}
	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}
	
	public String download(){
		
		//--->创建了一个excel文件  
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//--->创建了一个工作簿 
		HSSFSheet sheet = wb.createSheet();
		
		sheet.addMergedRegion(new CellRangeAddress(0,(short)2,0,(short)11));
		
		//设置内部数据   （表头设置）
		HSSFRow biaotou = sheet.createRow(0);
		biaotou.setHeight((short)30);
		HSSFCell biaoti = biaotou.createCell(0);
		biaoti.setCellValue("老师信息数据");
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = wb.createFont();
		font.setBoldweight((short)100);
		style.setFont(font);
		biaoti.setCellStyle(style);
	
		//创建格子（表头）
		
		HSSFRow row1 = sheet.createRow(3);
		
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellValue("序号");
		
		HSSFCell cell2 = row1.createCell(1);
		cell2.setCellValue("姓名");
		
		HSSFCell cell3 = row1.createCell(2);
		cell3.setCellValue("年龄");
		
		HSSFCell cell4 = row1.createCell(3);
		cell4.setCellValue("工资");
		HSSFCell cell5 = row1.createCell(4);
		cell5.setCellValue("身份证号");
		HSSFCell cell6 = row1.createCell(5);
		cell6.setCellValue("性别");
		
		HSSFCell cell7 = row1.createCell(6);
		cell7.setCellValue("入职日期");
		HSSFCell cell8 = row1.createCell(7);
		cell8.setCellValue("离职日期");
		
		List<Teacher> list = service.queryList();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		//设置内容
		for (int i = 0; i < list.size(); i++) {
			
			//循环一次创建一行    数据   （表内容设置）
			HSSFRow row = sheet.createRow(i+4);
			//序号
			HSSFCell cell01 = row.createCell(0);
			cell01.setCellValue(i+1);
			if(list.get(i).getTName() != null){
				//name
				HSSFCell cell02 = row.createCell(1);
				cell02.setCellValue(list.get(i).getTName());
			}
			
			if(list.get(i).gettAge() != null){
				//age
				HSSFCell cell03 = row.createCell(2);
				cell03.setCellValue(list.get(i).gettAge());
			}
			if(list.get(i).getTSalary() != null){
				HSSFCell cell04 = row.createCell(3);
				cell04.setCellValue(list.get(i).getTSalary());
			}
			if(list.get(i).gettIdcard() != null){
				HSSFCell cell05 = row.createCell(4);
				cell05.setCellValue(list.get(i).gettIdcard());
			}
			
			if(list.get(i).getTSex().getdValue() != null){
				HSSFCell cell06 = row.createCell(5);
				cell06.setCellValue(list.get(i).getTSex().getdValue());
			}
			if(list.get(i).gettStartdate() != null){
				HSSFCell cell07 = row.createCell(6);
				cell07.setCellValue(fmt.format(list.get(i).gettStartdate()));
			}
			
			if(list.get(i).gettEnddate() != null){
				HSSFCell cell08 = row.createCell(7);
				
				cell08.setCellValue(fmt.format(list.get(i).gettEnddate()));
			}
		}
		
		
		String fileName = "教师信息表";
		
		try {
			excelName = new String(fileName.getBytes("GBK"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			 wb.write(output);
			 byte[] ba = output.toByteArray();
			 excelStream = new ByteArrayInputStream(ba);
	         output.flush();
	         output.close();
			 
		} catch (IOException e) {
			 e.printStackTrace();
		}
//		return ServletActionContext.getServletContext().getResourceAsStream("upload/jd2chm源码生成chm格式文档.rar") 
		
		return "download";
		
	}
	
}	
