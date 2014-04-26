package com.zhangyihao.twoyou.dao;

import java.util.List;

import com.zhangyihao.twoyou.entity.Album;
import com.zhangyihao.twoyou.entity.User;

public interface AlbumDao {
	void add(Album album);
	void delete(Album album);
	void update(Album album);
	Album get(Integer id);
	Album getDefaultByUser(User user);
	List<Album> getAlbumByUser(Integer userId);
}
