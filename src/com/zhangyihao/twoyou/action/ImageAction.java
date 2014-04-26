package com.zhangyihao.twoyou.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangyihao.twoyou.biz.AlbumBiz;
import com.zhangyihao.twoyou.biz.ImageBiz;
import com.zhangyihao.twoyou.entity.Album;
import com.zhangyihao.twoyou.entity.Image;
import com.zhangyihao.twoyou.entity.User;
import com.zhangyihao.twoyou.util.FileUtil;

public class ImageAction extends ActionSupport {
	private static final long serialVersionUID = 7058926152109312500L;

	private ImageBiz imageBiz;
	private AlbumBiz albumBiz;
	
	private List<File> image;
	private List<String> imageFileName;
	private List<String> imageContentType;
	private List<String> description;
	private String tags;
	private Integer albumId;
	private Integer toAlbumId;
	private String[] imageIds;
	
	private Image img;
	private List<Album> albumList;
	
	public void setImageBiz(ImageBiz imageBiz) {
		this.imageBiz = imageBiz;
	}
	
	
	public String toPublicImage() {
		return "success";
	}
	
	public String publishImage() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
	
		String imagePath = FileUtil.getRoot()+"/pin/"+user.getId();
		for(int i=0; i<image.size(); i++) {
			
			String imageName = imageFileName.get(i);
			String desc = description.get(i)==null?"":description.get(i);
			
			String newName = System.currentTimeMillis()+imageName.substring(imageName.lastIndexOf("."));
			
			FileUtil.copyFile(image.get(i), new File(imagePath+"/pic", newName));
			
			Image image = new Image();
			image.setDescription(desc);
			image.setPath("pin/"+user.getId()+"/pic/"+newName);
			image.setTags(tags==null?"":tags);
			
			imageBiz.pubImage(user, image, imageContentType.get(i));
		}
		
		return "success";
	}
	
	public String moveImage() {
		if(albumId==null) {
			return "toAlbumList";
		}
		if(toAlbumId!=null && imageIds!=null && imageIds.length>0) {
			List<Integer> images = new ArrayList<Integer>();
			for(int i=0; i<imageIds.length; i++) {
				try {
					images.add(Integer.parseInt(imageIds[i]));
				} catch (Exception e) {
					System.out.println("移动图片出错，图片id为"+imageIds[i]);
				}
			}
			imageBiz.moveImage(toAlbumId, images);
		}
		return "toAlbumImage";
	}
	
	public String delImageBatch() {
		if(albumId==null) {
			return "toAlbumList";
		}
		if(imageIds!=null && imageIds.length>0) {
			List<Integer> images = new ArrayList<Integer>();
			for(int i=0; i<imageIds.length; i++) {
				try {
					images.add(Integer.parseInt(imageIds[i]));
				} catch (Exception e) {
					System.out.println("删除图片出错，图片id为"+imageIds[i]);
				}
			}
			imageBiz.delImage(images);
		}
		return "toAlbumImage";
	}
	
	public String toEditImage() {
		if(img==null || img.getId()==null) {
			return "toAlbumList";
		}
		img = imageBiz.getEditImageById(img.getId());
		if(img==null) {
			return "toAlbumList";
		}
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		albumList = albumBiz.getAlbumByUser(user);
		
		return "success";
	}
	
	public String editImage() {
		if(albumId==null || img==null || img.getId()==null) {
			return "toAlbumList";
		}
		
		Album album = new Album();
		album.setId(albumId);
		img.setAlbum(album);
		imageBiz.editImage(img);
		
		return "success";
	}
	
	public String showImage() {
		return "success";
	}
	
	
	
	
	public List<File> getImage() {
		return image;
	}

	public void setImage(List<File> image) {
		this.image = image;
	}

	public List<String> getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(List<String> imageFileName) {
		this.imageFileName = imageFileName;
	}

	public List<String> getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(List<String> imageContentType) {
		this.imageContentType = imageContentType;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	public Integer getAlbumId() {
		return albumId;
	}


	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}


	public Integer getToAlbumId() {
		return toAlbumId;
	}


	public void setToAlbumId(Integer toAlbumId) {
		this.toAlbumId = toAlbumId;
	}


	public String[] getImageIds() {
		return imageIds;
	}


	public void setImageIds(String[] imageIds) {
		this.imageIds = imageIds;
	}


	public Image getImg() {
		return img;
	}


	public void setImg(Image img) {
		this.img = img;
	}
	
	public List<Album> getAlbumList() {
		return albumList;
	}


	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}


	public void setAlbumBiz(AlbumBiz albumBiz) {
		this.albumBiz = albumBiz;
	}
}
