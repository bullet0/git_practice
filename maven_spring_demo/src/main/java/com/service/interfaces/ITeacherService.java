package com.service.interfaces;

import java.util.List;

import com.entity.Dictionary;
import com.entity.Teacher;
import com.util.PageUtil;

public interface ITeacherService {

	void insert(Teacher tea);

	void update(Teacher tea);

	void delete(Teacher tea);

	Teacher queryOne(int id);

	List<Teacher> queryList();

	List<Dictionary> queryDictionnary();

	String queryOldHeadImg(Integer gettId);

	boolean queryName(String gettName);

	PageUtil queryListByPage(PageUtil pageUtil);

}