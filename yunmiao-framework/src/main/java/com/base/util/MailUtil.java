package com.base.util;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.base.CoreConstants;

/**
 * 使用javamail发送邮件
 */
public class MailUtil {
	private static String from = CoreConstants.getProperty("mail.from");// 发件人
	private static String host = CoreConstants.getProperty("mail.host");// SMTP服务器地址
	private static String username = CoreConstants.getProperty("mail.user");// 发件人帐号
	private static String password = CoreConstants.getProperty("mail.pwd");// 发件人密码
	
	/**
	 * 方法说明：把主题转换为中文 <br>
	 * 输入参数：String strText <br>
	 * 返回类型：
	 */
	public String transferChinese(String strText) {
		try {
			strText = MimeUtility.encodeText(new String(strText.getBytes(), "GB2312"), "GB2312", "B");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strText;
	}
	
	public static boolean sendMail(String to,String subject,String content){
		return sendMail(to,subject,content,null,new Vector());
	}

	/**
	 * 方法说明：发送邮件 <br>
	 * 输入参数： <br>
	 * 返回类型：boolean 成功为true，反之为false
	 */
	public static boolean sendMail(String to,String subject,String content,String filename,Vector file) {
		// 构造mail session
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// 构造MimeMessage 并设定基本的值
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(username,from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 收件人
			// 添加邮件主题
			msg.setSubject(subject, "UTF-8");
			// 构造Multipart
			Multipart mp = new MimeMultipart();
			// 向Multipart添加正文
			MimeBodyPart mbpContent = new MimeBodyPart();
			mbpContent.setContent(content, "text/html;charset=UTF-8");
			// 向MimeMessage添加（Multipart代表正文）
			mp.addBodyPart(mbpContent);
			// 添加附件
			if (!file.isEmpty()) {// 有附件
				Enumeration efile = file.elements();
				while (efile.hasMoreElements()) {
					mbpContent = new MimeBodyPart();
					filename = efile.nextElement().toString(); // 选择出每一个附件名
					FileDataSource fds = new FileDataSource(filename); // 得到数据源
					mbpContent.setDataHandler(new DataHandler(fds)); // 得到附件本身并至入BodyPart
					mbpContent.setFileName(MimeUtility.encodeText(fds.getName(), "GBK", "B")); // 得到文件名同样至入BodyPart
					mp.addBodyPart(mbpContent);
				}
				file.removeAllElements();
			}
			msg.setContent(mp);
			msg.setSentDate(new Date());
			msg.saveChanges();
			// 发送邮件
			Transport transport = session.getTransport("smtp");
			transport.connect(host, username, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (Exception mex) {
			mex.printStackTrace();
			return false;
		}
		return true;
	}
}
