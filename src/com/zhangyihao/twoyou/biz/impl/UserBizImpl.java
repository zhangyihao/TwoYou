package com.zhangyihao.twoyou.biz.impl;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import com.zhangyihao.twoyou.biz.UserBiz;
import com.zhangyihao.twoyou.dao.AlbumDao;
import com.zhangyihao.twoyou.dao.UserDao;
import com.zhangyihao.twoyou.entity.Album;
import com.zhangyihao.twoyou.entity.User;
import com.zhangyihao.twoyou.util.FileUtil;
import com.zhangyihao.twoyou.util.MD5Util;
import com.zhangyihao.twoyou.util.image.HeadImgUtil;

public class UserBizImpl implements UserBiz {
	private UserDao userDao;
	private AlbumDao albumDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	@Override
	public User login(String email, String password) {
		User user = userDao.getByEmail(email);
		if(user!=null) {
			if(MD5Util.enctry(password).equals(user.getPassword())) {
				user.setHeadImgLarge(FileUtil.getHeadImagePath(user.getHeadImg(), "large"));
				user.setHeadImgMedium(FileUtil.getHeadImagePath(user.getHeadImg(), "medium"));
				user.setHeadImgSmall(FileUtil.getHeadImagePath(user.getHeadImg(), "small"));
				return user;
			}
		}
		return null;
	}

	@Override
	public void register(User user) {
		String activeCode = UUID.randomUUID().toString();
		
		user.setPassword(MD5Util.enctry(user.getPassword()));
		user.setIsActive(0);
		user.setActiveCode(activeCode);
		user.setActiveSendTime(new Date());
		user.setPasswordCode(null);
		user.setPasswordSendTime(null);
		user.setHeadImg("default");
		user.setUsername("昵称");
		
		userDao.add(user);
		
		sendActiveCodeEmail(user.getEmail(), activeCode);
		createDefaultAlbum(user); //为新用户生成默认相册
		createFolder(user.getId()); //为新用户创建存放图片的文件夹
	}
	
	private void createDefaultAlbum(User user) {
		Album album = new Album();
		album.setUser(user);
		album.setName("默认");
		album.setDescription("这是默认相册");
		
		albumDao.add(album);
	}
	
	private void createFolder(int id) {
		String picPath = FileUtil.getRoot()+"/pin/"+id;
		File file = new File(picPath+"/pic/");
		File file1 = new File(picPath+"/236x/");
		File file2 = new File(picPath+"/216x200/");
		File file3 = new File(picPath+"/658x/");
		File tx = new File(picPath+"/tx/");
		file.mkdirs();
		file1.mkdirs();
		file2.mkdirs();
		file3.mkdirs();
		tx.mkdirs();
	}
	

	@Override
	public void modifyUserInfo(User user) {
		userDao.update(user);
	}

	@Override
	public boolean isRegister(String email) {
		User user = userDao.getByEmail(email);
		if(user!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyPassword(Integer id, String password) {
		User user = userDao.get(id);
		if(user!=null) {
			user.setPassword(MD5Util.enctry(password));
			userDao.update(user);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean isPasswordRight(Integer id, String password) {
		User user = userDao.get(id);
		if(user!=null) {
			if(user.getPassword().equals(MD5Util.enctry(password))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void sendGetPasswordBackEmail(String email) {
		String pswCode = UUID.randomUUID().toString();
		String link = "http://localhost:8080/TwoYou/resetpaswordbyemail?email="+email+"&code="+pswCode+"sign=3626487";
		String object = "找回密码";
		String content = "你好!：<br/>"
+"请点击下面的链接进行重置：<a href='"+link+"' target='_balnk'>"+link+"</a><br/>"
+"此链接只能使用一次, 如果失效请重新申请(有效时长为14小时). 如果以上链接无法点击，请将它拷贝到浏览器(例如IE)的地址栏中。<br/>"
+"感谢你对图游的支持。<br/>" +
"(这是一封自动产生的email，请勿回复)";
//		EmailUtil.sendEmail(object, content, email);
		
		User user = userDao.getByEmail(email);
		user.setPasswordCode(pswCode);
		user.setPasswordSendTime(new Date());
		userDao.update(user);
	}
	
	@Override
	public void sendActiveEmail(String email){
		String activeCode = UUID.randomUUID().toString();
		sendActiveCodeEmail(email, activeCode);
		
		User user = userDao.getByEmail(email);
		user.setPasswordCode(activeCode);
		user.setPasswordSendTime(new Date());
		userDao.update(user);
	}
	
	private void sendActiveCodeEmail(String email, String activeCode) {
		String link = "http://localhost:8080/TwoYou/resetpaswordbyemail?email="+email+"&code="+activeCode+"sign=3659565";
		String object = "激活账户";
		String content = "你好!：<br/>"
+"请点击下面的链接进行激活：<a href='"+link+"' target='_balnk'>"+link+"</a><br/>"
+"此链接只能使用一次， 如果以上链接无法点击，请将它拷贝到浏览器(例如IE)的地址栏中。<br/>"
+"感谢你对图游的支持。<br/>" +
"(这是一封自动产生的email，请勿回复)";
		
//		EmailUtil.sendEmail(object, content, email);
	}

	@Override
	public User get(Integer userId) {
		if(userId!=null) {
			return userDao.get(userId);
		}
		return null;
	}

	@Override
	public void modifyHeadImg(User user, String fileName, String fileContentType) {
		String path = "pin/"+user.getId()+"/tx/"+fileName;
		new Thread(new HeadImgUtil(FileUtil.getRoot() + "/" + path, fileContentType)).start();
		
		String oldPath = user.getHeadImg();
		File file = new File(FileUtil.getRoot(), oldPath);
		File fileLarge = new File(FileUtil.getRoot(), FileUtil.getHeadImagePath(oldPath, "large"));
		File fileMedium = new File(FileUtil.getRoot(), FileUtil.getHeadImagePath(oldPath, "medium"));
		File fileSmall = new File(FileUtil.getRoot(), FileUtil.getHeadImagePath(oldPath, "small"));
		if(file.exists()) {
			file.delete();
		}
		if(fileLarge.exists()) {
			fileLarge.delete();
		}
		if(fileMedium.exists()) {
			fileMedium.delete();
		}
		if(fileSmall.exists()) {
			fileSmall.delete();
		}
		
		user.setHeadImg(path);
		userDao.update(user);
	}

	@Override
	public boolean isUserNameExist(String username) {
		User user = userDao.getByUserName(username);
		if(user!=null) {
			return true;
		}
		return false;
	}
}
