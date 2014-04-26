package com.zhangyihao.twoyou.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zhangyihao.twoyou.dao.ImageDao;
import com.zhangyihao.twoyou.entity.Image;

public class ImageDaoImpl extends HibernateDaoSupport implements ImageDao {

	@Override
	public Image get(Integer id) {
		return this.getHibernateTemplate().get(Image.class, id);
	}

	@Override
	public void add(Image image) {
		this.getHibernateTemplate().save(image);
	}

	@Override
	public void delete(Image image) {
		this.getHibernateTemplate().delete(image);
	}

	@Override
	public void update(Image image) {
		this.getHibernateTemplate().update(image);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Image> getAll() {
		return this.getHibernateTemplate().find("from Image where status='0'");
	}

	@Override
	public List<Image> getAllByPage(int page, int pageSize) {
		String hql = "from Image where status='0'";
		return doSplitPage(hql, page, pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Image> getAllByTag(String tag) {
		String hql = "from Image where tags like '%" + tag + "%' and status='0'";
		return this.getHibernateTemplate().find(hql);
	}
	
	@Override
	public List<Image> getByTag(String tag, int page, int pageSize) {
		String hql = "from Image where tags like '%" + tag + "%' and status='0'";
		return doSplitPage(hql, page, pageSize);
	}
	
	private List<Image> doSplitPage(final String hql,final int page, final int pageSize) {
		return (List<Image>)this.getHibernateTemplate().execute(new HibernateCallback<List<Image>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<Image> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				return query.setFirstResult((page-1)*pageSize).setMaxResults(pageSize).list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Image> getByAlbum(Integer albumId) {
		return (List<Image>)this.getHibernateTemplate().find("from Image where album.id=? and status='0'", albumId);
	}

	@Override
	public void updateAlbum(Integer oldAlbumId, Integer newAlbumId) {
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Image t set t.album.id=? where t.album.id=?");
		query.setInteger(0, newAlbumId);
		query.setInteger(1, oldAlbumId);
		query.executeUpdate();
	}
	
}
