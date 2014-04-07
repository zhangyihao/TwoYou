package com.zhangyihao.twoyou.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangyihao.twoyou.biz.UserBiz;
import com.zhangyihao.twoyou.util.EmailUtil;
import com.zhangyihao.twoyou.util.ValidateUtil;

public class PasswordAction extends ActionSupport {
	private static final long serialVersionUID = -3067299556130341661L;
	
	private UserBiz userBiz;
	
	private String email;
	private String mailAddr;

	public String toForgetPass() {
		return "success";
	}
	
	public String forgetPass() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("EMAIL", email);
		return "success";
	}
	
	public void validateForgetPass() {
		if(email==null || "".equals(email.trim())) {
			this.addActionError("邮箱不能为空!");
		} else if(!ValidateUtil.isEmail(email)) {
			this.addActionError("不是一个邮箱!");
		} else if(!userBiz.isRegister(email)) {
			this.addActionError("邮箱未注册!");
		}
	}
	
	public String getPasswordBack() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String mail = (String)session.get("EMAIL");
		if(mail==null || "".equals(mail.trim())) {
			return "input";
		}
		mailAddr = EmailUtil.getMailAddress(mail);
		
		userBiz.sendGetPasswordBackEmail(mail);
		session.put("EMAIL", null);
		return "success";
	}
	
	public String reSendGetPswBackMail() {
		if(email==null || "".equals(email.trim())) {
			return "input";
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("EMAIL", email);
		mailAddr = EmailUtil.getMailAddress(email);
		userBiz.sendGetPasswordBackEmail(email);
		return "success";
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
	public String getMailAddr() {
		return mailAddr;
	}

	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr;
	}
}
