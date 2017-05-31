package com.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseFileUpload extends ActionSupport {
	protected File file;
	protected String fileContentType;//文件类型
	protected String fileFileName;//文件名字
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	/**
	 * @throws IOException 
	 * 
	* @Title: upload 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @return  返回文件名称，用于封装到实体类中
	* @return String 返回类型 
	* @throws
	 */
	public String upload(String desPath) throws IOException{
		if(file != null){
			//得到项目发布路径下的file文件路径。。。下载到的文件路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/");
			File f = new File(realPath+"/img/");
//			File webApps = f.getParentFile();
			
			File file2 = new File(f,desPath);
			//如果文件不存在，就创建出来
			if(!file2.exists())f.mkdirs();
			
			FileUtils.copyFile(file, new File(file2,fileFileName));
			
			return fileFileName;
		}else{
			return null;
		}
		
	}
}
