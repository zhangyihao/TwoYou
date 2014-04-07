package com.zhangyihao.twoyou.action;

import java.util.List;
import java.util.Map;

import com.zhangyihao.twoyou.biz.ImageBiz;
import com.zhangyihao.twoyou.entity.Image;
import com.zhangyihao.twoyou.entity.PageBar;

public class IndexAction {
	
	private ImageBiz imageBiz;
	
	private Integer page;
	private Integer rquestNum;
	private PageBar pageBar;
	private List<Image> images;
	
	@SuppressWarnings("unchecked")
	public String toIndex() {
		Map<String, Object> map = imageBiz.getImages(1, 1);
		pageBar = (PageBar)map.get("PAGEBAR");
		images = (List<Image>)map.get("IMAGES");
		return "success";
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRquestNum() {
		return rquestNum;
	}

	public void setRquestNum(Integer rquestNum) {
		this.rquestNum = rquestNum;
	}

	public PageBar getPageBar() {
		return pageBar;
	}

	public void setPageBar(PageBar pageBar) {
		this.pageBar = pageBar;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public void setImageBiz(ImageBiz imageBiz) {
		this.imageBiz = imageBiz;
	}
}
