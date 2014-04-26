package com.zhangyihao.twoyou.entity;

import java.util.Date;

public class Image {

	private Integer id;
	private String path;
	private String description;
	private String tags;
	private String status;
	private Album album;
	private Date pubTime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return this.tags;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	
	public Date getPubTime() {
		return this.pubTime;
	}

}