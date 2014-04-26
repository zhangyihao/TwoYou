package com.zhangyihao.twoyou.dao;

import java.util.List;

import com.zhangyihao.twoyou.entity.Collection;

public interface CollectionDao {
	void add(Collection collection);
	void update(Collection collection);
	void delete(Collection collection);
	Collection get(Integer id);
	List<Collection> getCollectionByUser(Integer userId);
}
