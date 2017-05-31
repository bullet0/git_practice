package maven_spring_demo;


import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.dao.impls.TeacherDaoImpl;
import com.entity.Teacher;
import com.service.hibernateimpls.TeacherServiceImpl;
import com.service.interfaces.ITeacherService;

public class TestTeacherService {
	private ClassPathXmlApplicationContext cxt;
	private ITeacherService service;
	{
		cxt = new ClassPathXmlApplicationContext("spring/application-config.xml");
		service = cxt.getBean("teacherService",ITeacherService.class);
	}
	@Test
	public void test() {
		LocalSessionFactoryBean bean = cxt.getBean(LocalSessionFactoryBean.class);
	}
	@Test
	public void testInsert(){
		Teacher tea = new Teacher();
		tea.settName("王五66");
		tea.settAge(25);
		tea.settSalary(58.2);
		tea.settIdcard("1478-----9");
		tea.settHeadImg("/888/oo/pp.jpg");
		service.insert(tea);
	}
	@Test
	public void testUpdate(){
		Teacher tea = new Teacher();
		tea.settId(5);
		tea.settName("王五66");
		tea.settAge(250);
		tea.settSalary(58.2);
		tea.settIdcard("1478-----9");
		tea.settHeadImg("/888/oo/pp.jpg");
		service.update(tea);
	}
	@Test
	public void testDelete(){
		Teacher tea = new Teacher();
		tea.settId(5);
		service.delete(tea);
	}
	@Test
	public void testQueryList(){
		
		List<Teacher> queryList = service.queryList();
		System.out.println(queryList);
	}
	@Test
	public void testQueryOne(){
		Teacher queryOne = service.queryOne(2);
		System.out.println(queryOne);
		
		Teacher queryOne1 = service.queryOne(1);
		System.out.println(queryOne1);
	}
}
