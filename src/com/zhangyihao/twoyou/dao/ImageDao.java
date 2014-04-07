package com.zhangyihao.twoyou.dao;

import java.util.List;

import com.zhangyihao.twoyou.entity.Image;

public interface ImageDao {
	Image get(Integer id);
	void add(Image image);
	void delete(Integer id);
	void update(Image image);
	List<Image> getAll();
	List<Image> getAllByPage(int page, int pageSize);
	List<Image> getAllByTag(String tag);
	List<Image> getByTag(String tag, int page, int pageSize);
}
