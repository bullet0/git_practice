package maven_spring_demo;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.impls.UsersDaoImpl;
import com.dao.interfaces.IUsersDao;
import com.entity.Users;

public class TestUsersDao {
	private ClassPathXmlApplicationContext cxt;
	private IUsersDao dao;
	{
		cxt = new ClassPathXmlApplicationContext("spring/application-config.xml");
		dao = cxt.getBean("usersDao",UsersDaoImpl.class);
	}
	
	@Test
	public void testDaoInsert() {
		Users u = new Users();
		u.setAccount("李四");
		u.setPassword("789");
		u.setPhone("18888888888");
		dao.insert(u);
	}
	
	@Test
	public void testDaoUpdate() {
		Users u = new Users();
		u.setId(2);
		u.setAccount("李四");
		u.setPassword("789");
		u.setPhone("18888888888");
		dao.update(u);
	}
	@Test
	public void testDaoDelete() {
		dao.delete(5);
	}
	
	@Test
	public void testqueryOne() {
		Users queryOne = dao.queryOne(1);
		System.out.println(queryOne);
	}
	@Test
	public void testqueryList() {
		List<Map<String, Object>> queryList = dao.queryList();
//		List<Users> queryList = dao.queryList();
		System.out.println(queryList);
	}
}
