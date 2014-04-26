package com.zhangyihao.twoyou.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zhangyihao.twoyou.dao.UserDao;
import com.zhangyihao.twoyou.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}

	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	public User get(Integer id) {
		return this.getHibernateTemplate().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public User getByEmail(String email) {
		List<User> users = this.getHibernateTemplate().find("from User where email=?", email);
		if(users!=null && users.size()>0) {
			return users.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getByUserName(String username) {
		List<User> users = this.getHibernateTemplate().find("from User where username=?", username);
		if(users!=null && users.size()>0) {
			return users.get(0);
		}
		return null;
	}

}
