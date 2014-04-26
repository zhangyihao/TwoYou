package com.zhangyihao.twoyou.dao;

import java.util.List;

import com.zhangyihao.twoyou.entity.Image;

public interface ImageDao {
	Image get(Integer id);
	void add(Image image);
	void delete(Image image);
	void update(Image image);
//	把某个相册下的所有图片移动到另一个相册下
	void updateAlbum(Integer oldAlbumId, Integer newAlbumId);
	List<Image> getAll();
	List<Image> getByAlbum(Integer albumId);
	List<Image> getAllByPage(int page, int pageSize);
	List<Image> getAllByTag(String tag);
	List<Image> getByTag(String tag, int page, int pageSize);
}
