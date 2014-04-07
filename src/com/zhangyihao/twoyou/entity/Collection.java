package com.zhangyihao.twoyou.entity;

import java.util.HashSet;
import java.util.Set;

public class Collection {

	private Integer id;
	private User user;
	private String name;
	private String description;
	private Set<Image> collectionImgs = new HashSet<Image>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Image> getCollectionImgs() {
		return this.collectionImgs;
	}

	public void setCollectionImgs(Set<Image> collectionImgs) {
		this.collectionImgs = collectionImgs;
	}

}