package com.zhangyihao.twoyou.action;

import java.io.File;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangyihao.twoyou.biz.UserBiz;
import com.zhangyihao.twoyou.entity.User;
import com.zhangyihao.twoyou.util.FileUtil;
import com.zhangyihao.twoyou.util.ValidateUtil;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = -4604882257611487394L;

	private UserBiz userBiz;
	
	private String email;
	private String password;
	private String remember;
	private String headImg75;
	private String headImg192;
	
	private Integer model;
	private String username;
	private String newPassword;
	private String rePassword;
	private File headImg;
	private String headImgFileName;
	private String headImgContentType;
	
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
	
	public String toEditUserInfo() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		
		headImg192 = FileUtil.getHeadImagePath(user.getHeadImg(), "large");
		headImg75 = FileUtil.getHeadImagePath(user.getHeadImg(), "small");
		model = null;
		
		return "editinfo";
	}
	
	public String editBasicInfo() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		
		user.setUsername(username);
		userBiz.modifyUserInfo(user);
		
		user = userBiz.get(user.getId());
		session.put("USER", user);
		model = 1;
		return "success";
	}
	
	public void validateEditBasicInfo() {
		model = 1;
		if(username==null || username.equals("")) {
			this.addActionError("昵称不能为空！");
		} else if(userBiz.isUserNameExist(username)) {
			this.addActionError("该昵称已经存在！");
		}
		afterValidate();
	}
	
	public String editEmail() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		
		user.setEmail(email);
		userBiz.modifyUserInfo(user);
		
		user = userBiz.get(user.getId());
		session.put("USER", user);
		model = 2;
		return "success";
	}
	
	public void validateEditEmail() {
		model = 2;
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		if(email==null || email.equals("")) {
			this.addActionError("邮箱不能为空！");
		} else if(userBiz.isRegister(email)) {
			this.addActionError("该邮箱已经注册过了！");
		} else if(!userBiz.isPasswordRight(user.getId(), password)) {
			this.addActionError("登录密码错误");
		}
		afterValidate();
	}
	
	public String editPassword() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		
		userBiz.modifyPassword(user.getId(), newPassword);
		user = userBiz.get(user.getId());
		session.put("USER", user);
		model = 3;
		return "success";
	}
	
	public void validateEditPassword() {
		model = 3;
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		
		if(password==null || password.equals("")) {
			this.addActionError("密码不能为空!");
		} else if(newPassword==null || newPassword.equals("")) {
			this.addActionError("新密码不能为空!");
		} else if(!ValidateUtil.isPassword(newPassword)) {
			this.addActionError("请填写一个长度为6-20位的密码");
		} else if(!newPassword.equals(rePassword)) {
			this.addActionError("新密码和确认密码不一致!");
		} else if(!userBiz.isPasswordRight(user.getId(), password)) {
			this.addActionError("登录密码错误");
		}
		
		afterValidate();
	}

	public String editHeadImg() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
	
		String imagePath = FileUtil.getRoot()+"/pin/"+user.getId();
		String newName = System.currentTimeMillis()+headImgFileName.substring(headImgFileName.lastIndexOf("."));
		
		FileUtil.copyFile(headImg, new File(imagePath+"/tx", newName));
		
		userBiz.modifyHeadImg(user, newName, headImgContentType);
		user = userBiz.get(user.getId());
		session.put("USER", user);
		model = 4;
		return "success";
	}
	
	public void validateEditHeadImg() {
		model = 4;
		if(headImg == null || headImg.getTotalSpace()<=0) {
			this.addActionError("请选择一个头像图片进行上传！");
		} else if(!ValidateUtil.isAllowType(headImgContentType)) {
			this.addActionError("选择的文件不是要求的图片类型，请上传jpg类型图片!");
		}
		afterValidate();
	}
	
	private void afterValidate() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		
		headImg192 = FileUtil.getHeadImagePath(user.getHeadImg(), "large");
		headImg75 = FileUtil.getHeadImagePath(user.getHeadImg(), "small");
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

	public String getHeadImg75() {
		return headImg75;
	}

	public void setHeadImg75(String headImg75) {
		this.headImg75 = headImg75;
	}

	public String getHeadImg192() {
		return headImg192;
	}

	public void setHeadImg192(String headImg192) {
		this.headImg192 = headImg192;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public String getHeadImgContentType() {
		return headImgContentType;
	}

	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}
	
}
