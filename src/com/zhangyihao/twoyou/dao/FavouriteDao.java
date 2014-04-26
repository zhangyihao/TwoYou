package com.zhangyihao.twoyou.dao;

import java.util.List;

import com.zhangyihao.twoyou.entity.Favourite;

public interface FavouriteDao {
	void add(Favourite fav);
	void delete(Favourite fav);
	List<Favourite> getByUser(Integer userId);
	List<Favourite> getByUserAndPage(Integer userId, int pageNum, int pageSize);
}
