package com.dao.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Users;

public interface IUsersDao {

	void insert(Users user);

	void update(Users user);

	void delete(int id);

	Users queryOne(int id);

	List<Map<String, Object>> queryList();

}