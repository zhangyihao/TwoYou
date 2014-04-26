package com.zhangyihao.twoyou.biz;

import java.util.List;
import java.util.Map;

import com.zhangyihao.twoyou.entity.Image;
import com.zhangyihao.twoyou.entity.User;

public interface ImageBiz {
	Map<String, Object> getImages(int rquestNum, int page);
	Map<String, Object> getImagesByTag(String tag, int rquestNum, int page);
	void pubImage(User user, Image image, String contentType);
	Image getAlbumCover(Integer albumId);
	List<Image> getByAlbum(Integer albumId);
	void moveImage(Integer toAlbumId, List<Integer> imageIds);
	void delImage(List<Integer> imageIds);
	void editImage(Image image);
	Image getEditImageById(Integer imageId); //获取在编辑图片页面的所用到图片
	Image getShowImageById(Integer imageId);  //获取查看图片页面所需要的图片
}