package com.zhangyihao.twoyou.dao;

import java.util.List;

import com.zhangyihao.twoyou.entity.Message;

public interface MessageDao {
	void add(Message msg);
	void delete(Message msg);
	Message get(Integer id);
	void update(Message msg);
	List<Message> getByUser(Integer userId);
}
