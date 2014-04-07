package com.zhangyihao.twoyou.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhangyihao.twoyou.biz.ImageBiz;
import com.zhangyihao.twoyou.dao.ImageDao;
import com.zhangyihao.twoyou.entity.Image;
import com.zhangyihao.twoyou.entity.PageBar;

public class ImageBizImpl implements ImageBiz {
	private ImageDao imageDao;

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

	@Override
	public Map<String, Object> getImages(int requestNum, int page) {
		List<Image> images = imageDao.getAllByPage((page-1)*4+requestNum, PageBar.getPageSize());
		List<Image> total = imageDao.getAll();
		
		PageBar pageBar = pageSplit(total.size(), page);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("PAGEBAR", pageBar);
		result.put("IMAGES", images);
		
		return result;
	}

	@Override
	public Map<String, Object> getImagesByTag(String tag, int requestNum, int page) {
		List<Image> images = imageDao.getByTag(tag, (page-1)*4+requestNum, PageBar.getPageSize());
		List<Image> total = imageDao.getAllByTag(tag);
		
		PageBar pageBar = pageSplit(total.size(), page);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("PAGEBAR", pageBar);
		result.put("IMAGES", images);
		
		return result;
	}
	
	
	private PageBar pageSplit(int total, int page) {
		int totalPage = (total-1)/(4*PageBar.getPageSize()) +1;
		
		int nextPage = page+1>totalPage?totalPage:page+1;
		int prevPage = page-1<0?0:page-1;
		
		PageBar pageBar = new PageBar();
		pageBar.setLastPage(totalPage);
		pageBar.setNextPage(nextPage);
		pageBar.setPrevPage(prevPage);
		pageBar.setTotalPage(totalPage);
		pageBar.setTotalRecord(total);
		return pageBar;
	}
}
