package maven_spring_demo;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Users;
import com.service.interfaces.IUsersService;
import com.service.jdbcimpls.UsersServiceImpl;

public class TestUsersService {
	private ClassPathXmlApplicationContext cxt;
	private IUsersService service;
	{
		cxt = new ClassPathXmlApplicationContext("spring/application-config.xml");
		service = cxt.getBean("usersService",IUsersService.class);
	}
	
	@Test
	public void testServiceInsert() {
		Users u = new Users();
		u.setAccount("李wu");
		u.setPassword("789");
		u.setPhone("18888888888");
		service.insert(u);
	}
	
	@Test
	public void testServiceUpdate() {
		Users u = new Users();
		u.setId(6);
		u.setAccount("李四66");
		u.setPassword("78966");
		u.setPhone("18899999666");
		service.update(u);
	}
	@Test
	public void testServiceDelete() {
		service.delete(9);
	}
	
	@Test
	public void testServiceQueryOne() {
		Users queryOne = service.queryOne(1);
		System.out.println(queryOne);
	}
	@Test
	public void testServiceQueryList() {
		List<Map<String, Object>> queryList = service.queryList();
//		List<Users> queryList = dao.queryList();
		System.out.println(queryList);
	}
}
