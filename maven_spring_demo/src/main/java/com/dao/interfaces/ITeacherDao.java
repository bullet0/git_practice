package com.dao.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.entity.Dictionary;
import com.entity.Teacher;
import com.util.PageUtil;

public interface ITeacherDao {

	Session getSession();

	void insert(Teacher tea);

	void update(Teacher tea);

	void delete(Teacher tea);

	List<Teacher> queryList();

	Teacher queryOne(int id);

	List<Dictionary> queryDictionnary();

	String queryOldHeadImg(Integer gettId);

	String queryName(String gettName);

	int queryCount(String condition);

	List<Teacher> queryListByPage(PageUtil pageUtil);

}