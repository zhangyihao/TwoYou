package com.zhangyihao.twoyou.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangyihao.twoyou.biz.UserBiz;
import com.zhangyihao.twoyou.entity.User;
import com.zhangyihao.twoyou.util.ValidateUtil;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = -4604882257611487394L;

	private UserBiz userBiz;
	
	private String email;
	private String password;
	private String remember;
	
	public String tologin() {
		return "success";
	}
	
	public String login() {
		User user = userBiz.login(email, password);
		if(user==null) {
			this.addActionError("邮箱或密码错误！");
			return "input";
		} else {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("USER", user);
			return "success";
		}
	}
	
	public void validateLogin() {
		if(!ValidateUtil.isEmail(email)) {
			this.addActionError("邮箱或密码错误！");
		} else if(!ValidateUtil.isPassword(password)) {
			this.addActionError("邮箱或密码错误！");
		}
	}
	
	
	public String toRegister() {
		return "success";
	}
	
	public String register() {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		userBiz.register(user);
		return "success";
	}
	
	public void validateRegister() {
		if(!ValidateUtil.isEmail(email)) {
			this.addFieldError("email", "请填写一个正确的邮箱！");
		} else if(userBiz.isRegister(email)) {
			this.addFieldError("email", "邮箱已注册！");
		} else if(!ValidateUtil.isPassword(password)) {
			this.addFieldError("password", "请填写一个长度为6-20位的密码");
		}
	}
	
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}
	
}
