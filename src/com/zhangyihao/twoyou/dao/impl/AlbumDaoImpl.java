package com.zhangyihao.twoyou.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zhangyihao.twoyou.dao.AlbumDao;
import com.zhangyihao.twoyou.entity.Album;
import com.zhangyihao.twoyou.entity.User;

public class AlbumDaoImpl extends HibernateDaoSupport implements AlbumDao {

	@Override
	public void add(Album album) {
		this.getHibernateTemplate().save(album);
	}

	@Override
	public void delete(Album album) {
		this.getHibernateTemplate().delete(album);
	}

	@Override
	public void update(Album album) {
		this.getHibernateTemplate().update(album);
	}

	@Override
	public Album get(Integer id) {
		return this.getHibernateTemplate().get(Album.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> getAlbumByUser(Integer userId) {
		return (List<Album>)this.getHibernateTemplate().find("from Album where user.id=?", userId);
	}

	@Override
	public Album getDefaultByUser(User user) {
		String hql = "from Album where user.id=? and name='默认'";
		return (Album)this.getHibernateTemplate().find(hql, user.getId()).get(0);
	}

}
