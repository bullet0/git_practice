package com.service.interfaces;

import java.util.List;
import java.util.Map;

import com.entity.Users;

public interface IUsersService {

	void insert(Users u);

	void delete(int id);

	void update(Users u);

	Users queryOne(int id);

	List<Map<String, Object>> queryList();

}