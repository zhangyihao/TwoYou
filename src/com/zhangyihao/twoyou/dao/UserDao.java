package com.zhangyihao.twoyou.dao;

import com.zhangyihao.twoyou.entity.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	User get(Integer id);
	User getByEmail(String email);
	User getByUserName(String username);
}
