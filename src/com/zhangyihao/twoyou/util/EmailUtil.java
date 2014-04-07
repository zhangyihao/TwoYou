package com.zhangyihao.twoyou.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class EmailUtil {
	public static String getMailAddress(String email) {
		return "htpp://mail.163.com";
	}
	
	public static void sendEmail(String object, String content, String recipient) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.163.com");
		
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("zyh5540", "zyh_1991_9_13");
			}
		});
		//session.setDebug(true); //？？？？？？
		
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress("\"" + MimeUtility.encodeText("图游系统邮件") + "\" <zyh5540@163.com>"));
			msg.setSubject(object);
			//注意第二个参数要写成"text/html;charset=utf-8"，表明这是一封html邮件
			msg.setContent(content, "text/html;charset=utf-8");
			msg.setRecipients(RecipientType.TO, InternetAddress.parse(recipient));
			Transport.send(msg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
