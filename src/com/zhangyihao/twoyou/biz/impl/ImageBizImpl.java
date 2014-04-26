package com.zhangyihao.twoyou.biz.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhangyihao.twoyou.biz.ImageBiz;
import com.zhangyihao.twoyou.dao.AlbumDao;
import com.zhangyihao.twoyou.dao.ImageDao;
import com.zhangyihao.twoyou.entity.Album;
import com.zhangyihao.twoyou.entity.Image;
import com.zhangyihao.twoyou.entity.PageBar;
import com.zhangyihao.twoyou.entity.User;
import com.zhangyihao.twoyou.util.image.PubImageUtil;

public class ImageBizImpl implements ImageBiz {
	private ImageDao imageDao;
	private AlbumDao albumDao;
	
	private final String small = "216x200";
	private final String medium = "236x";
	private final String large = "658x";

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
	
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	
	@Override
	public void pubImage(User user, Image image, String contentType) {
		Album defaultAlbum = albumDao.getDefaultByUser(user);
		image.setAlbum(defaultAlbum);
		image.setStatus("0");
		image.setPubTime(new Date());
		imageDao.add(image);
//		对图片进行加水印和缩放
		new Thread(new PubImageUtil(user.getId(),image.getPath(), contentType, 216, 200, 236, 658)).start();
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

	@Override
	public Image getAlbumCover(Integer albumId) {
		Image image = new Image();
		image.setPath("");
		if(albumId!=null) {
			List<Image> images = imageDao.getByAlbum(albumId);
			if(images!=null && images.size()>0) {
				image.setPath(convertAlbumPath(images.get(0).getPath(), small));
			}
		}
		return image;
	}

	@Override
	public List<Image> getByAlbum(Integer albumId) {
		List<Image> images = imageDao.getByAlbum(albumId);
		if(images!=null && images.size()>0) {
			for(int i=0; i<images.size(); i++) {
				Image image = images.get(i);
				image.setPath(convertAlbumPath(image.getPath(), small));
				if(image.getDescription().length()>12) {
					image.setDescription(image.getDescription().substring(0, 12)+"...");
				}
			}
		}
		return images;
	}
	

	@Override
	public void moveImage(Integer toAlbumId, List<Integer> imageIds) {
		Album album = albumDao.get(toAlbumId);
		if(album!=null && imageIds!=null && imageIds.size()>0) {
			for(int i=0; i<imageIds.size(); i++) {
				Image image = imageDao.get(imageIds.get(i));
				image.setAlbum(album);
				imageDao.update(image);
			}
		}
	}
	
	@Override
	public void delImage(List<Integer> imageIds) {
		//用户删除图片信息，只需要将图片状态设置为1，并不需要真正删除图片
		if(imageIds!=null && imageIds.size()>0) {
			for(int i=0; i<imageIds.size(); i++) {
				Image image = imageDao.get(imageIds.get(i));
				if(image!=null) {
					image.setStatus("1");
					imageDao.update(image);
				}
			}
		}
	}


	@Override
	public void editImage(Image image) {
		Image img = imageDao.get(image.getId());
		Album album = albumDao.get(image.getAlbum().getId());
		if(img!=null && album!=null) {
			img.setAlbum(album);
			img.setDescription(image.getDescription());
			img.setTags(image.getTags());
			imageDao.update(img);
		}
	}

	@Override
	public Image getEditImageById(Integer imageId) {
		Image image = null;
		if(imageId!=null) {
			image = imageDao.get(imageId);
			image.setPath(convertAlbumPath(image.getPath(), small));
		}
		return image;
	}
	
	@Override
	public Image getShowImageById(Integer imageId) {
		Image image = null;
		if(imageId!=null) {
			image = imageDao.get(imageId);
			image.setPath(convertAlbumPath(image.getPath(), large));
		}
		return image;
	}
	
	/**
	 * 根据原图片路径，转换成缩放后的图片的路径
	 * @param path
	 * @return
	 */
	private String convertAlbumPath(String path, String size) {
//		pin/1/ pic/ 1398078318873 .jpg
//		pin/1/216x200/1398078318873216200.jpg
		StringBuilder sb = new StringBuilder();
		sb.append(path.substring(0, path.indexOf("pic"))); //pin/1/
		sb.append(size).append("/");
		sb.append(path.substring(path.lastIndexOf("/")+1, path.lastIndexOf("."))); //1398078318873
		
		if(size.equals(small)) {
			sb.append("216200");
		} else if(size.equals(medium)) {
			sb.append("236");
		} else {
			sb.append("658");
		}
		
		sb.append(path.substring(path.lastIndexOf("."))); //.jpg
		return sb.toString();
	}
}
