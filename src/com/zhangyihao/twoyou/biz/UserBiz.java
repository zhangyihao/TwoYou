package com.zhangyihao.twoyou.biz;

import com.zhangyihao.twoyou.entity.User;

public interface UserBiz {
	User login(String email, String password);
	void register(User user);
	void modifyUserInfo(User user);
	boolean isRegister(String email);
	boolean modifyPassword(Integer id, String password);
	boolean isPasswordRight(Integer id, String password);
	void sendGetPasswordBackEmail(String email);
	void sendActiveEmail(String email);
}
