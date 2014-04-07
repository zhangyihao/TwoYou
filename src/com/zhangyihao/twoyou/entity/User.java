package com.zhangyihao.twoyou.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer id;
	private String username;
	private String email;
	private String password;
	private Integer isActive;
	private String activeCode;
	private Date activeSendTime;
	private String passwordCode;
	private Date passwordSendTime;
	private String headImg;

	private Set<Image> favourites = new HashSet<Image>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getActiveCode() {
		return this.activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public Date getActiveSendTime() {
		return this.activeSendTime;
	}

	public void setActiveSendTime(Date activeSendTime) {
		this.activeSendTime = activeSendTime;
	}

	public String getPasswordCode() {
		return this.passwordCode;
	}

	public void setPasswordCode(String passwordCode) {
		this.passwordCode = passwordCode;
	}

	public Date getPasswordSendTime() {
		return this.passwordSendTime;
	}

	public void setPasswordSendTime(Date passwordSendTime) {
		this.passwordSendTime = passwordSendTime;
	}

	public String getHeadImg() {
		return this.headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Set<Image> getFavourites() {
		return this.favourites;
	}

	public void setFavourites(Set<Image> favourites) {
		this.favourites = favourites;
	}

}