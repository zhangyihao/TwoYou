package com.zhangyihao.twoyou.biz;

import java.util.List;

import com.zhangyihao.twoyou.entity.Album;
import com.zhangyihao.twoyou.entity.User;

public interface AlbumBiz {
	void addAlbum(Album album);
	void editAlbum(Album album);
	void delAlbum(Integer albumId,User user);
	List<Album> getAlbumByUser(User user);
	Album getAlbum(Integer albumId);
	Album getDefaultAlbum(User user);
}
