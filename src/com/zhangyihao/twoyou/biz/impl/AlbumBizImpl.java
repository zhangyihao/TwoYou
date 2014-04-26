package com.zhangyihao.twoyou.biz.impl;

import java.util.List;

import com.zhangyihao.twoyou.biz.AlbumBiz;
import com.zhangyihao.twoyou.dao.AlbumDao;
import com.zhangyihao.twoyou.dao.ImageDao;
import com.zhangyihao.twoyou.entity.Album;
import com.zhangyihao.twoyou.entity.User;

public class AlbumBizImpl implements AlbumBiz {

	private AlbumDao albumDao;
	private ImageDao imageDao;
	
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

	
	@Override
	public void addAlbum(Album album) {
		if(album!=null) {
			albumDao.add(album);
		}
	}

	@Override
	public void editAlbum(Album album) {
		if(album.getId()!=null) {
			Album old = albumDao.get(album.getId());
			if(old!=null) {
				old.setName(album.getName());
				old.setDescription(album.getDescription());
				albumDao.update(old);
			}
		}
	}

	@Override
	public void delAlbum(Integer albumId,User user) {
		Album album = albumDao.get(albumId);
		if(album!=null) {
			Album defaultAlbum = albumDao.getDefaultByUser(user);
			
			imageDao.updateAlbum(albumId, defaultAlbum.getId());
			albumDao.delete(albumDao.get(albumId));
		}
	}

	@Override
	public List<Album> getAlbumByUser(User user) {
		return albumDao.getAlbumByUser(user.getId());
	}


	@Override
	public Album getAlbum(Integer albumId) {
		if(albumId==null) {
			return null;
		}
		return albumDao.get(albumId);
	}


	@Override
	public Album getDefaultAlbum(User user) {
		return albumDao.getDefaultByUser(user);
	}

}
