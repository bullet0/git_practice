package com.dao.impls;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dao.interfaces.ITeacherDao;
import com.entity.Dictionary;
import com.entity.Teacher;
import com.util.PageUtil;

@Repository("teacherDao")
public class TeacherDaoImpl implements ITeacherDao {
	@Resource(name="sessionFactory")
	private SessionFactory factory;
	
	/* (non-Javadoc)
	 * @see com.dao.impls.ITeacherDao#getSession()
	 */
	@Override
	public Session getSession(){
		return factory.getCurrentSession();
	}
	
	/* (non-Javadoc)
	 * @see com.dao.impls.ITeacherDao#insert(com.entity.Teacher)
	 */
	@Override
	public void insert(Teacher tea){
		this.getSession().save(tea);
	}
	/* (non-Javadoc)
	 * @see com.dao.impls.ITeacherDao#update(com.entity.Teacher)
	 */
	@Override
	public void update(Teacher tea){
		this.getSession().update(tea);
	}
	/* (non-Javadoc)
	 * @see com.dao.impls.ITeacherDao#delete(int)
	 */
	@Override
	public void delete(Teacher tea){
		this.getSession().delete(tea);
	}
	
	/* (non-Javadoc)
	 * @see com.dao.impls.ITeacherDao#queryList()
	 */
	
	@Override
	public List<Teacher> queryList(){
		
//		Query query = this.getSession().createQuery("select t.tId,t.tName,tSalary,tIdcard,tAge,tHeadImg,tStartdate,tEnddate,"
//				+ "											d1.dId,d1.dType,d1.dValue,d2.dId,d2.dType,d2.dValue"
//													+ " from Teacher t, Dictionary d1 ,Dictionary d2  where  t.tSex.dId=d1.dId and t.tState.dId=d2.dId   ");
		Query query = this.getSession().createQuery("from Teacher");
		//手动设置查询缓存
		query.setCacheable(true);
		return query.list();
	}
	
	/* (non-Javadoc)
	 * @see com.dao.impls.ITeacherDao#queryOne(int)
	 */
	@Override
	public Teacher queryOne(int id){
//		return (Teacher) this.getSession().createQuery("from Teacher t where t.tId=?").setInteger(0, id).uniqueResult();
		return (Teacher) this.getSession().get(Teacher.class, id);
		
	}

	@Override
	public List<Dictionary> queryDictionnary() {
		// TODO Auto-generated method stub
		Query query = this.getSession().createQuery("from Dictionary");
		//手动设置查询缓存
		query.setCacheable(true);
		return query.list();
	}

	@Override
	public String queryOldHeadImg(Integer gettId) {
		// TODO Auto-generated method stub
		Object uniqueResult = this.getSession().createSQLQuery("select t_head_img from teacher where t_id=?").setInteger(0, gettId).uniqueResult();
		if(uniqueResult == null){
			return "";
		}else{
			return uniqueResult.toString();
		}
		
		
	}

	@Override
	public String queryName(String gettName) {
		// TODO Auto-generated method stub
		Object uniqueResult = this.getSession().createSQLQuery("select t_name from teacher where t_name=?").setString(0, gettName).uniqueResult();
		if(uniqueResult == null){
			return null;
		}else{
			return uniqueResult.toString();
		}
	}

	@Override
	public int queryCount(String condition) {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.getSession().createSQLQuery("select count(1) from teacher where t_name like ?").setString(0, "%"+condition+"%").uniqueResult().toString());
	}

	@Override
	public List<Teacher> queryListByPage(PageUtil pageUtil) {
		// TODO Auto-generated method stub                     
		return this.getSession().createQuery("from Teacher t where t.tName like ?").setString(0, "%"+pageUtil.getCondition()+"%").setFirstResult((pageUtil.getCurPage()-1)*pageUtil.getPageSize()).setMaxResults(pageUtil.getPageSize()).list();
	}
}
