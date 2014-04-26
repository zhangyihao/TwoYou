package com.zhangyihao.twoyou.biz;

import com.zhangyihao.twoyou.entity.User;

public interface UserBiz {
	User login(String email, String password);
	User get(Integer userId);
	void register(User user);
	void modifyUserInfo(User user);
	void modifyHeadImg(User user, String fileName, String fileContentType);
	boolean isRegister(String email);
	boolean modifyPassword(Integer id, String password);
	boolean isPasswordRight(Integer id, String password);
	void sendGetPasswordBackEmail(String email);
	void sendActiveEmail(String email);
	boolean isUserNameExist(String username);
}
