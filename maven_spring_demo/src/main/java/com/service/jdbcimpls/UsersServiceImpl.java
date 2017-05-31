package com.service.jdbcimpls;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.dao.interfaces.IUsersDao;
import com.entity.Users;
import com.service.interfaces.IUsersService;
@Service("usersService")
public class UsersServiceImpl implements IUsersService {
	@Resource(name="usersDao")
	private IUsersDao usersDao;
	
	/* (non-Javadoc)
	 * @see com.service.impls.IUsersService#insert(com.entity.Users)
	 */
	@Override
	public void insert(Users u){
		usersDao.insert(u);
	}
	
	/* (non-Javadoc)
	 * @see com.service.impls.IUsersService#delete(int)
	 */
	@Override
	public void delete(int id){
		usersDao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see com.service.impls.IUsersService#update(com.entity.Users)
	 */
	@Override
	public void update(Users u){
		usersDao.update(u);
	}
	
	/* (non-Javadoc)
	 * @see com.service.impls.IUsersService#queryOne(int)
	 */
	@Override
	public Users queryOne(int id){
		
		return usersDao.queryOne(id);
		
	}
	
	/* (non-Javadoc)
	 * @see com.service.impls.IUsersService#queryList()
	 */
	@Override
	public List<Map<String, Object>> queryList(){
		return usersDao.queryList();
	}
}	
