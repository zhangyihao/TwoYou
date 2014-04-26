package com.zhangyihao.twoyou.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangyihao.twoyou.biz.AlbumBiz;
import com.zhangyihao.twoyou.biz.ImageBiz;
import com.zhangyihao.twoyou.entity.Album;
import com.zhangyihao.twoyou.entity.Image;
import com.zhangyihao.twoyou.entity.User;

public class AlbumAction extends ActionSupport {
	

	private static final long serialVersionUID = 5993952844541370066L;
	private AlbumBiz albumBiz;
	private ImageBiz imageBiz;
	
	private List<Map<String, Object>> albums;
	private List<Image> images;
	private List<Album> albumList;
	
	private Integer albumId;
	private String albumName;
	private String description;
	private Integer defaultAlbumId;
	
	public String seeAlbum() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		
		if(albums==null) {
			albums = new ArrayList<Map<String, Object>>();
		}
		
		List<Album> list = albumBiz.getAlbumByUser(user);
		for(int i=0; i<list.size(); i++) {
			Image cover = imageBiz.getAlbumCover(list.get(i).getId());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ALBUM", list.get(i));
			map.put("COVER", cover.getPath());
			albums.add(map);
		}
		
		Album defaultAlbum = albumBiz.getDefaultAlbum(user);
		defaultAlbumId = defaultAlbum.getId();
		
		return "success";
	}
	
	public String toAddAlbum() {
		return "success";
	}
	
	public String addAlbum() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		
		Album album = new Album();
		album.setDescription(description==null?"":description);
		album.setName(albumName);
		album.setUser(user);
		
		albumBiz.addAlbum(album);
		
		return "success";
	}
	
	
	public void validateAddAlbum() {
		if(albumName==null || "".equals(albumName)) {
			this.addActionError("相册名称不能为空");
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		List<Album> albums = albumBiz.getAlbumByUser(user);
		for(int i=0; i<albums.size(); i++) {
			if(albumName.equals(albums.get(i).getName())) {
				this.addActionError("此相册已存在");
			}
		}
	}

	public String toEditAlbum() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");

		Album album = albumBiz.getAlbum(albumId);
		Album defaultAlbum = albumBiz.getDefaultAlbum(user);
		if(album==null) {
			return "input";
		}
		albumId = album.getId();
		albumName = album.getName();
		description = album.getDescription();
		defaultAlbumId = defaultAlbum.getId();

		return "success";
	}
	
	public String editAlbum() {
		Album album = new Album();
		album.setId(albumId);
		album.setDescription(description==null?"":description);
		album.setName(albumName);
		
		albumBiz.editAlbum(album);
		return "success";
	}
	
	public void validateEditAlbum() {
		if(albumName==null || "".equals(albumName)) {
			this.addActionError("相册名称不能为空");
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		List<Album> albums = albumBiz.getAlbumByUser(user);
		for(int i=0; i<albums.size(); i++) {
			if(albumName.equals(albums.get(i).getName())&&albumId!=albums.get(i).getId()) {
				this.addActionError("此相册已存在");
			}
		}
	}
	
	public String delAlbum() {
		if(albumId!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User)session.get("USER");
			albumBiz.delAlbum(albumId, user);
		}
		return "success";
	}
	
	public String albumDetail() {
		Album album = albumBiz.getAlbum(albumId);
		if(album==null) {
			return "input";
		}
		albumName = album.getName();
		description = album.getDescription();
		
		images = imageBiz.getByAlbum(albumId);
		return "success";
	}
	
	/**
	 * 去往批量管理相册图片界面
	 * @return
	 */
	public String manageAlbum() {
		if(albumId==null) {
			return "input";
		}
		Album album = albumBiz.getAlbum(albumId);
		if(album==null) {
			return "input";
		}
		albumId = album.getId();
		albumName = album.getName();
		description = album.getDescription();
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		albumList = albumBiz.getAlbumByUser(user);
		
		images = imageBiz.getByAlbum(albumId);
		return "success";
	}
	

	public void setAlbumBiz(AlbumBiz albumBiz) {
		this.albumBiz = albumBiz;
	}

	public void setImageBiz(ImageBiz imageBiz) {
		this.imageBiz = imageBiz;
	}
	
	public List<Map<String, Object>> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Map<String, Object>> albums) {
		this.albums = albums;
	}
	
	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDefaultAlbumId() {
		return defaultAlbumId;
	}

	public void setDefaultAlbumId(Integer defaultAlbumId) {
		this.defaultAlbumId = defaultAlbumId;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}
	
}
