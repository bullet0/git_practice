package com.dao.impls;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dao.interfaces.IUsersDao;
import com.entity.Users;
@Repository("usersDao")
public class UsersDaoImpl implements IUsersDao {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @see com.dao.impls.IUsersDao#insert(com.entity.Users)
	 */
	@Override
	public void insert(Users user){
		String sql = "insert into users (account,password,phone) values (?,?,?)";
		jdbcTemplate.update(sql, new String[]{user.getAccount(),user.getPassword(),user.getPhone()});
	}
	
	/* (non-Javadoc)
	 * @see com.dao.impls.IUsersDao#update(com.entity.Users)
	 */
	@Override
	public void update(Users user){
		String sql = "update users set account=?,password=?,phone=? where id=?";
		jdbcTemplate.update(sql, new Object[]{user.getAccount(),user.getPassword(),user.getPhone(),user.getId()});
	}
	/* (non-Javadoc)
	 * @see com.dao.impls.IUsersDao#delete(int)
	 */
	@Override
	public void delete(int id){
		String sql = "delete from users where id=?";
		jdbcTemplate.update(sql,id);
	}
	/* (non-Javadoc)
	 * @see com.dao.impls.IUsersDao#queryOne(int)
	 */
	@Override
	public Users queryOne(int id){
		String sql = "select id,account,password,phone from users where id=?";
		RowMapper<Users> rowMapper = new BeanPropertyRowMapper(Users.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, new Object[]{1});
	}
	
	/* (non-Javadoc)
	 * @see com.dao.impls.IUsersDao#queryList()
	 */
	@Override
	public List<Map<String, Object>> queryList(){
		String sql = "select id,account,password,phone from users";
		
		return jdbcTemplate.queryForList(sql);
	}
	
	
}
