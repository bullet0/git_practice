package com.service.hibernateimpls;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaces.ITeacherDao;
import com.entity.Dictionary;
import com.entity.Teacher;
import com.service.interfaces.ITeacherService;
import com.util.PageUtil;

@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService {
	@Resource(name="teacherDao")
	private ITeacherDao dao;
	
	/* (non-Javadoc)
	 * @see com.service.hibernateimpls.ITeacherService#insert(com.entity.Teacher)
	 */
	@Override
	public void insert(Teacher tea){
		dao.insert(tea);
	}
	/* (non-Javadoc)
	 * @see com.service.hibernateimpls.ITeacherService#update(com.entity.Teacher)
	 */
	@Override
	public void update(Teacher tea){
		dao.update(tea);
	}
	
	/* (non-Javadoc)
	 * @see com.service.hibernateimpls.ITeacherService#delete(int)
	 */
	@Override
	public void delete(Teacher tea){
		dao.delete(tea);
	}
	
	/* (non-Javadoc)
	 * @see com.service.hibernateimpls.ITeacherService#queryOne(int)
	 */
	@Override
	public Teacher queryOne(int id){
		return dao.queryOne(id);
	}
	
	/* (non-Javadoc)
	 * @see com.service.hibernateimpls.ITeacherService#queryList()
	 */
	@Override
	public List<Teacher> queryList(){
		return dao.queryList();
	}
	@Override
	public List<Dictionary> queryDictionnary() {
		// TODO Auto-generated method stub
		return dao.queryDictionnary();
	}
	@Override
	public String queryOldHeadImg(Integer gettId) {
		// TODO Auto-generated method stub
		return dao.queryOldHeadImg(gettId);
	}
	@Override
	public boolean queryName(String gettName) {
		// TODO Auto-generated method stub
		String name = dao.queryName(gettName);
		if(name==null){
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public PageUtil queryListByPage(PageUtil pageUtil) {
		// TODO Auto-generated method stub
		int count = dao.queryCount(pageUtil.getCondition());
		pageUtil.setTotalCount(count);
		pageUtil.countTotalPage();
		List<Teacher> list = dao.queryListByPage(pageUtil);
		pageUtil.setList(list);
		return pageUtil;
	}
	
	
}
